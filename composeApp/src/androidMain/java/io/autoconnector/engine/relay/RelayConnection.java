package io.autoconnector.engine.relay;

import io.autoconnector.engine.core.Prefs;
import io.autoconnector.engine.db.ProxyStore;
import io.autoconnector.engine.model.ProxyEntry;
import io.autoconnector.engine.model.ProxyType;
import io.autoconnector.engine.net.DcAddresses;
import io.autoconnector.engine.net.HandshakeMode;
import io.autoconnector.engine.net.HandshakeStats;
import io.autoconnector.engine.net.MtCrypto;
import io.autoconnector.engine.net.Obfuscated2;
import io.autoconnector.engine.net.Socks5Server;
import io.autoconnector.engine.traffic.TrafficMeter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Bridges one Telegram connection (arriving on a local SOCKS5 port) to an
 * upstream proxy.
 *
 * <p>It answers the SOCKS5 handshake, strips Telegram's transport obfuscation,
 * picks a rated upstream (with connect-time failover), then runs two
 * re-ciphering pipes: the inner end-to-end-encrypted MTProto stream passes
 * through untouched while the obfuscation layer is swapped local↔upstream.
 */
public final class RelayConnection implements Runnable {

    private static final int UPSTREAM_TIMEOUT_MS = 8000;
    private static final int HANDSHAKE_TIMEOUT_MS = 15000;
    /**
     * Idle read-timeout once the relay is piping bytes. Telegram normally
     * pings every minute or two, so silence past this threshold means the
     * connection is dead (network dropped, user switched proxies in Telegram,
     * upstream went silent) — we tear it down so the LiveConn registry stays
     * honest and the user doesn't see a stale "active session".
     */
    private static final int PIPE_IDLE_TIMEOUT_MS = 180_000;
    private static final int FAILOVER_CANDIDATES = 12;
    private static final int PIPE_BUF = 16384;

    /** Monotonic id so every Telegram connection has a stable "session" the
     *  Logs UI can group by (one expandable block per port+session). */
    private static final java.util.concurrent.atomic.AtomicLong SESSION_SEQ =
            new java.util.concurrent.atomic.AtomicLong();

    private final Socket tg;
    private final int localPort;
    private final ProxyStore store;
    private final RelayManager manager;
    private final RelayServer.Listener listener;
    private final long sessionId = SESSION_SEQ.incrementAndGet();

    /** Session tag carried on every log line of this connection: "<port>#<id>". */
    private String sess() { return localPort + "#" + sessionId; }

    private volatile Socket upSocket;
    private volatile ProxyEntry upstreamProxy;
    /** Set once the LiveConn is registered — both pipe directions update its
     *  counters / latency-pair timestamps through this reference. */
    private volatile RelayStats.LiveConn liveConnRefForLatency;

    public RelayConnection(Socket tg, int localPort, ProxyStore store,
                           RelayManager manager, RelayServer.Listener listener) {
        this.tg = tg;
        this.localPort = localPort;
        this.store = store;
        this.manager = manager;
        this.listener = listener;
    }

    @Override
    public void run() {
        // Tag every log line of this connection with its session (auto-applied
        // by RelayLog.emit on this thread); cleared in finally since the relay
        // thread pool reuses threads.
        RelayLog.setSession(sess());
        RelayStats.active.incrementAndGet();
        RelayStats.accepting.incrementAndGet();
        RelayStats.totalConns.incrementAndGet();
        listener.event(null);

        long liveId = -1;
        long sessionStart = 0;
        UpstreamConnector.Channel up = null;
        RelayStats.LiveConn liveConnRef = null;
        boolean acceptingDecremented = false;
        Prefs prefs = new Prefs(manager.appContext);
        HandshakeMode handshakeMode = prefs.dpiApplyRelay()
                ? HandshakeMode.fromOrdinal(prefs.handshakeMode())
                : HandshakeMode.NORMAL;
        boolean onlyFakeTls = prefs.onlyFakeTls();
        // Experimental upstream engine (OFF → reference path, bit-identical).
        WireShaper.Mode expEngine = WireShaper.Mode.fromCode(prefs.expEngineMode());
        // Experimental connect strategy (OFF → serial 8s, reference).
        RelayConnectMode connMode = RelayConnectMode.fromCode(prefs.relayConnectMode());
        try {
            tg.setSoTimeout(HANDSHAKE_TIMEOUT_MS);
            InputStream tgIn = tg.getInputStream();
            OutputStream tgOut = tg.getOutputStream();

            // 1. SOCKS5 handshake — learn the DC endpoint Telegram wants.
            Socks5Server.Target dst = Socks5Server.handshake(tgIn, tgOut);
            RelayLog.emit("↪ Telegram открыл сокет на порту " + localPort
                    + " → " + dst.host + ":" + dst.port);

            manager.onConnection(localPort);

            // BYPASS mode (Settings: ProxyMode = DISABLED / DISABLED_ON_VPN
            // while VPN is up). Telegram's MTProto stream goes raw to the
            // DC — we do NOT read the obfuscated2 header ourselves, since
            // doing so would consume Telegram's key material that the
            // server expects to see verbatim. Plain SOCKS5 byte forwarder.
            if (prefs.shouldBypassProxies()) {
                // handleBypassRaw owns the single accept-counter decrement for
                // this connection; flag it so run()'s finally doesn't decrement
                // a SECOND time (that double-decrement drove accepting negative —
                // the "TG→ -59" the user saw).
                acceptingDecremented = true;
                handleBypassRaw(tg, tgIn, tgOut, dst, prefs.dpiApplyDirect());
                return;
            }

            // No live proxies yet (cold pool / still bootstrapping) → forward
            // Telegram straight to the DC instead of dropping the connection.
            // Dropping it makes Telegram declare the proxy "misconfigured" and
            // DISABLE it; a direct pass-through keeps the proxy enabled, and as
            // soon as live proxies appear the next connections route through them.
            int aliveNow;
            try {
                aliveNow = store.countAlive();
            } catch (Exception dbErr) {
                // A transient DB hiccup (e.g. SQLITE_BUSY under a concurrent scan)
                // must NEVER tear this connection down — Telegram would instantly
                // flag the proxy as broken and disable it. Treat it as a cold pool
                // and pass straight through, which keeps the proxy enabled.
                RelayLog.emit("⚠ БД на миг недоступна — Telegram идёт напрямую к DC "
                        + "(прокси не отключаем)");
                aliveNow = 0;
            }
            if (aliveNow == 0) {
                RelayLog.emit("⚠ живых прокси пока нет — Telegram идёт напрямую к DC "
                        + "(чтобы Telegram не отключил прокси); идёт набор пула…");
                acceptingDecremented = true;  // see note above — avoid double-decrement
                handleBypassRaw(tg, tgIn, tgOut, dst, prefs.dpiApplyDirect());
                return;
            }

            // 2. Strip Telegram's obfuscated2 (no secret over SOCKS5).
            Obfuscated2 local = new Obfuscated2();
            local.accept(tgIn, null);
            int tag = local.transportTag;
            int dcId = local.dcId;
            if (dcId < 1 || dcId > 5) dcId = DcAddresses.dcIdForIp(dst.host);

            // 3. Acquire an upstream, with connect-time failover.
            up = acquireUpstream(tag, dcId, dst, handshakeMode, onlyFakeTls, expEngine, connMode);
            if (up == null) {
                listener.event("порт " + localPort + ": нет рабочего апстрима (DC" + dcId + ")");
                return;
            }
            upstreamProxy = up.proxy;
            upSocket = up.socket;
            manager.setUpstream(localPort, upstreamProxy);

            // Persist the successful Telegram→upstream handshake.
            // SQLite serialises writes — no Java monitor needed (and that
            // monitor used to stall every other pipe + UI onCreate).
            long now = System.currentTimeMillis();
            try {
                store.logRelayAttempt(upstreamProxy.id, true);
                store.setLastTelegramConnect(upstreamProxy.id, now);
                store.markAliveFromRelay(upstreamProxy.id, now);
                io.autoconnector.engine.core.NetworkMode net =
                        io.autoconnector.engine.core.NetworkMonitor.currentMode();
                if (net != io.autoconnector.engine.core.NetworkMode.UNKNOWN) {
                    store.markRelaySuccess(upstreamProxy.id, net, now);
                }
            } catch (Exception ignored) {}
            prefs.setLastTelegramConnect(now);
            if (localPort == manager.portA) prefs.setLastTelegramConnectPortA(now);
            else if (localPort == manager.portB) prefs.setLastTelegramConnectPortB(now);
            RelayLog.emit("→ " + upstreamProxy.host + ":" + upstreamProxy.port
                    + " (порт " + localPort + ", DC" + dcId
                    + ", " + (upstreamProxy.type == ProxyType.MTPROTO ? "MT" : "S5") + ")");

            tg.setSoTimeout(PIPE_IDLE_TIMEOUT_MS);
            up.socket.setSoTimeout(PIPE_IDLE_TIMEOUT_MS);
            try { tg.setKeepAlive(true); } catch (Exception ignored) {}
            try { up.socket.setKeepAlive(true); } catch (Exception ignored) {}

            String sni = upstreamProxy.isFakeTls()
                    ? io.autoconnector.engine.net.FakeTlsClient.domainFromSecret(upstreamProxy.secret)
                    : null;
            int srcNum = 0;
            try {
                long srcId = store.primarySourceId(upstreamProxy.id);
                if (srcId > 0) {
                    int i = 1;
                    for (ProxyStore.Source s : store.listSources()) {
                        if (s.id == srcId) { srcNum = i; break; }
                        i++;
                    }
                }
            } catch (Exception ignored) {}
            RelayStats.LiveConn liveConn = new RelayStats.LiveConn(
                    localPort, upstreamProxy.host + ":" + upstreamProxy.port,
                    upstreamProxy.id, dcId,
                    upstreamProxy.type == ProxyType.MTPROTO,
                    upstreamProxy.rttMs, sni, srcNum);
            liveConnRef = liveConn;
            liveConnRefForLatency = liveConn;
            // Seed the relay-ping graph with this upstream's TCP-connect RTT — a
            // real, always-present sample on every (re)connect. The per-chunk
            // request→response pairing below then keeps it live during the
            // session. Telegram reconnects often, so this alone keeps the line
            // populated even if a session sees little request/response traffic.
            if (up != null && up.connectMs > 0) {
                io.autoconnector.engine.traffic.LatencyBuffer.INSTANCE.sample(up.connectMs);
            }
            liveConn.lastDataAt.set(now);
            liveConn.killer = this::closeBoth;
            liveId = RelayStats.register(liveConn);
            sessionStart = now;
            HandshakeStats.recordTgConnected(up.handshakeMode);
            RelayStats.accepting.decrementAndGet();
            acceptingDecremented = true;
            listener.event("порт " + localPort + " → "
                    + upstreamProxy.host + ":" + upstreamProxy.port + " (DC" + dcId + ")");

            // Diagnostic net-log (metadata only; no-op unless the user enabled it).
            NetLog.open(sess(),
                    "net=" + io.autoconnector.engine.core.NetworkMonitor.currentMode()
                    + " eng=" + expEngine.key
                    + " dpi=" + up.handshakeMode.name()
                    + " up=" + upstreamProxy.host + ":" + upstreamProxy.port
                    + " type=" + (upstreamProxy.type == ProxyType.MTPROTO
                            ? (upstreamProxy.isFakeTls() ? "ee" : "MT") : "S5")
                    + (sni != null ? " sni=" + sni : "")
                    + " dc=" + dcId
                    + " dst=" + dst.host + ":" + dst.port);

            // 4. Re-ciphering pipes in both directions.
            final UpstreamConnector.Channel fup = up;
            final Obfuscated2 flocal = local;
            final RelayStats.LiveConn lc = liveConn;
            final String session = sess();
            Thread down = new Thread(() ->
                    pipe(fup.in, fup.obf.dec, flocal.enc, tgOut,
                            RelayStats.bytesDown, lc.bytesDown, false, session),
                    "relay-down-" + localPort);
            down.setDaemon(true);
            down.start();
            pipe(tgIn, local.dec, fup.obf.enc, fup.out,
                    RelayStats.bytesUp, liveConn.bytesUp, true, session);
            // Bounded join — pipe's SoTimeout (180s) should bring it home,
            // but if anything weird happens we don't sit on the relay pool slot.
            down.join(PIPE_IDLE_TIMEOUT_MS + 5_000L);
            if (down.isAlive()) {
                down.interrupt();
                closeBoth();  // forces the down-pipe's read() to error out
                down.join(2_000L);
            }
        } catch (Exception ignored) {
            // handshake / IO failure — just tear the connection down
        } finally {
            closeBoth();
            if (liveId >= 0) RelayStats.unregister(liveId);
            if (upstreamProxy != null && sessionStart > 0) {
                long dur = System.currentTimeMillis() - sessionStart;
                try {
                    store.recordSession(upstreamProxy.id, dur);
                    long sessBytes = (liveConnRef != null)
                            ? liveConnRef.bytesUp.get() + liveConnRef.bytesDown.get()
                            : 0;
                    io.autoconnector.engine.core.NetworkMode net =
                            io.autoconnector.engine.core.NetworkMonitor.currentMode();
                    if (net != io.autoconnector.engine.core.NetworkMode.UNKNOWN) {
                        store.modeRecordSession(upstreamProxy.id, net, dur, sessBytes);
                    }
                } catch (Exception ignored) {}
                // Anti-DPI bookkeeping. "active" window = first real byte
                // after handshake → end-of-session; "duration" = whole pipe
                // lifetime including the warmup. Average throughput in Stats
                // uses the active window so it isn't artificially low.
                if (liveConnRef != null && up != null) {
                    long bytes = liveConnRef.bytesUp.get() + liveConnRef.bytesDown.get();
                    long first = liveConnRef.firstDataAt.get();
                    long last = liveConnRef.lastDataAt.get();
                    long activeMs = (first > 0 && last > first) ? last - first : 0;
                    HandshakeStats.recordSessionEnd(up.handshakeMode, dur, bytes, activeMs);
                }
                RelayLog.emit("⨂ " + upstreamProxy.host + ":" + upstreamProxy.port
                        + " — сессия закрыта, длилась "
                        + io.autoconnector.engine.core.Durations.human(dur / 1000));
                long upB = (liveConnRef != null) ? liveConnRef.bytesUp.get() : 0;
                long downB = (liveConnRef != null) ? liveConnRef.bytesDown.get() : 0;
                NetLog.close(sess(), "durMs=" + dur + " up=" + upB + " down=" + downB);
            }
            if (!acceptingDecremented) RelayStats.accepting.decrementAndGet();
            RelayStats.active.decrementAndGet();
            listener.event(null);
            RelayLog.clearSession();
        }
    }

    /**
     * Plain SOCKS5→TCP forwarder. After SOCKS5 we already know the
     * destination Telegram asked for ({@code dst.host:dst.port}, typically
     * 149.154.x.x:443); we just open a TCP socket there and copy bytes in
     * both directions verbatim.
     *
     * <p>Crucially we do NOT touch the MTProto / obfuscated2 layer here.
     * Telegram's first 64 bytes contain its own obfuscated2-handshake; the
     * server keys off those exact bytes. The previous version called
     * {@code local.accept()} and then re-emitted a fresh obfuscated2 to the
     * server, which meant the server saw OUR keys while the rest of the
     * stream was still encrypted with TELEGRAM's keys — Telegram looked
     * connected from the relay's side but Telegram itself never got a
     * valid response and sat in "Подключение..." forever.
     */
    private void handleBypassRaw(Socket tg, InputStream tgIn, OutputStream tgOut,
                                 Socks5Server.Target dst, boolean antiDpi) {
        Socket direct = null;
        long liveId = -1;
        boolean acceptingDecremented = false;
        try {
            String host = dst.host;
            int port = dst.port;
            if (host == null || host.isEmpty()) {
                RelayLog.emit("✗ прямой выход: SOCKS5-цель пуста");
                return;
            }
            direct = new Socket();
            direct.connect(new java.net.InetSocketAddress(host, port), UPSTREAM_TIMEOUT_MS);
            direct.setSoTimeout(PIPE_IDLE_TIMEOUT_MS);
            tg.setSoTimeout(PIPE_IDLE_TIMEOUT_MS);
            try { tg.setKeepAlive(true); } catch (Exception ignored) {}
            try { direct.setKeepAlive(true); } catch (Exception ignored) {}
            upSocket = direct;

            int dcId = DcAddresses.dcIdForIp(host);
            RelayLog.emit("→ " + host + ":" + port + " (порт " + localPort
                    + ", прямой выход, DC" + dcId
                    + (antiDpi ? ", анти-DPI: фрагментация" : "") + ")");
            NetLog.open(sess(),
                    "net=" + io.autoconnector.engine.core.NetworkMonitor.currentMode()
                    + " eng=direct" + (antiDpi ? "+frag" : "")
                    + " dc=" + dcId + " dst=" + host + ":" + port);

            RelayStats.LiveConn lc = new RelayStats.LiveConn(
                    localPort, host + ":" + port,
                    -1L, dcId, false, 0, null, 0);
            lc.lastDataAt.set(System.currentTimeMillis());
            lc.killer = this::closeBoth;
            liveConnRefForLatency = lc;
            liveId = RelayStats.register(lc);
            RelayStats.accepting.decrementAndGet();
            acceptingDecremented = true;

            final InputStream upIn = direct.getInputStream();
            final OutputStream upOut = direct.getOutputStream();
            final RelayStats.LiveConn flc = lc;
            final String session = sess();
            Thread down = new Thread(() ->
                    directPipe(upIn, tgOut, RelayStats.bytesDown, flc.bytesDown, false, session, false),
                    "bypass-down-" + localPort);
            down.setDaemon(true);
            down.start();
            // Up-direction (Telegram → DC): when anti-DPI-to-direct is on, the
            // first outbound burst (the obfuscated2 handshake) is split into
            // several small TCP segments so a DPI box can't match it in one read.
            directPipe(tgIn, upOut, RelayStats.bytesUp, lc.bytesUp, antiDpi, session, true);
            down.join(PIPE_IDLE_TIMEOUT_MS + 5_000L);
            if (down.isAlive()) {
                down.interrupt();
                closeBoth();
            }
        } catch (Exception e) {
            RelayLog.emit("✗ прямой выход " + dst.host + ":" + dst.port + ": "
                    + (e.getMessage() != null ? e.getMessage()
                                              : e.getClass().getSimpleName()));
        } finally {
            if (liveId >= 0) RelayStats.unregister(liveId);
            if (!acceptingDecremented) RelayStats.accepting.decrementAndGet();
            RelayStats.LiveConn fin = liveConnRefForLatency;
            if (fin != null) {
                NetLog.close(sess(), "up=" + fin.bytesUp.get() + " down=" + fin.bytesDown.get());
            }
            try { if (direct != null) direct.close(); } catch (Exception ignored) {}
            closeQuietly(tg);
        }
    }

    /**
     * Raw byte pump for bypass mode — no obfuscation re-cipher, just copy.
     * When {@code fragmentFirst} is set, the very first burst is written split
     * into a few small TCP segments (anti-DPI for the direct DC connection).
     */
    private void directPipe(InputStream src, OutputStream dst,
                            java.util.concurrent.atomic.AtomicLong global,
                            java.util.concurrent.atomic.AtomicLong perConn,
                            boolean fragmentFirst, String session, boolean upDirection) {
        byte[] buf = new byte[PIPE_BUF];
        boolean first = fragmentFirst;
        try {
            int n;
            while ((n = src.read(buf)) > 0) {
                if (first) {
                    writeFragmented(dst, buf, n);
                    first = false;
                } else {
                    dst.write(buf, 0, n);
                    dst.flush();
                }
                if (upDirection) NetLog.up(session, n); else NetLog.down(session, n);
                global.addAndGet(n);
                perConn.addAndGet(n);
                TrafficMeter.add(TrafficMeter.Cat.RELAY, n);
                RelayStats.LiveConn lc = liveConnRefForLatency;
                if (lc != null) lc.lastDataAt.set(System.currentTimeMillis());
            }
        } catch (IOException ignored) {
        } finally {
            closeBoth();
        }
    }

    private static final java.util.Random DPI_RND = new java.util.Random();

    /**
     * Splits {@code [0,len)} of {@code buf} into 3–5 small TCP segments with a
     * few ms between them. The destination socket is TCP_NODELAY-agnostic here:
     * each {@code flush()} pushes its own segment, so a DPI box that fingerprints
     * the obfuscated2 handshake in a single read sees only a fragment. Falls back
     * to a plain write for tiny payloads where splitting would be pointless.
     */
    private static void writeFragmented(OutputStream dst, byte[] buf, int len)
            throws IOException {
        if (len <= 8) {
            dst.write(buf, 0, len);
            dst.flush();
            return;
        }
        int chunks = 3 + DPI_RND.nextInt(3);          // 3..5
        int per = Math.max(1, len / chunks);
        int idx = 0;
        for (int i = 0; i < chunks - 1 && idx + per < len; i++) {
            dst.write(buf, idx, per);
            dst.flush();
            try { Thread.sleep(4 + DPI_RND.nextInt(12)); } catch (InterruptedException ignored) {}
            idx += per;
        }
        dst.write(buf, idx, len - idx);
        dst.flush();
    }

    /**
     * Tries the port's sticky upstream, then a diversified pool: top-rated
     * alive + random alive hosts outside the top + a sprinkle of unverified
     * proxies. If every candidate fails we treat that as a cascade and
     * trigger an async wider check so the next Telegram retry has something
     * fresh to try (and the previous "stuck on dead top-5" symptom can't
     * persist).
     */
    private UpstreamConnector.Channel acquireUpstream(int tag, int dcId,
                                                      Socks5Server.Target dst,
                                                      HandshakeMode mode,
                                                      boolean onlyFakeTls,
                                                      WireShaper.Mode exp,
                                                      RelayConnectMode connMode) {
        List<ProxyEntry> candidates = new ArrayList<>();
        ProxyEntry sticky = manager.stickyUpstream(localPort);
        if (sticky != null && (!onlyFakeTls || sticky.isFakeTls())) {
            candidates.add(sticky);
        }
        int wantTop = 15;
        int wantRandom = 15;
        int multi = onlyFakeTls ? 4 : 1;
        io.autoconnector.engine.core.NetworkMode net =
                io.autoconnector.engine.core.NetworkMonitor.currentMode();
        boolean usePerMode = net != io.autoconnector.engine.core.NetworkMode.UNKNOWN;

        // 1. Top alive for THIS network — VPN/WiFi/LTE are graded separately
        //    so we don't try VPN-only winners on bare LTE.
        final io.autoconnector.engine.core.NetworkMode fnet = net;
        java.util.List<ProxyEntry> topAlive = safeList(() -> usePerMode
                ? store.topAliveForMode(fnet, wantTop * multi)
                : store.topAlive(wantTop * multi));
        for (ProxyEntry p : topAlive) {
            if (onlyFakeTls && !p.isFakeTls()) continue;
            if (!containsId(candidates, p.id)) candidates.add(p);
            if (candidates.size() >= wantTop + 1) break;
        }
        // 2. Random alive outside the top — diversifies and exposes hosts
        //    the rating undervalues (or that just recovered).
        java.util.List<ProxyEntry> randomAlive = safeList(() -> usePerMode
                ? store.randomAliveForMode(fnet, wantRandom * multi)
                : store.randomAlive(wantRandom * multi));
        for (ProxyEntry p : randomAlive) {
            if (onlyFakeTls && !p.isFakeTls()) continue;
            if (!containsId(candidates, p.id)) candidates.add(p);
            if (candidates.size() >= wantTop + wantRandom + 1) break;
        }
        // 3. Per-mode pool thin (fresh install, desktop, or a just-changed /
        //    mis-detected network)? Pull GLOBAL alive proxies — these are
        //    alive-filtered, so we NEVER hand Telegram a dead host while live
        //    ones exist somewhere. Handing over a dead upstream is exactly what
        //    made Telegram see a "broken" proxy and disable it.
        if (candidates.size() < 5) {
            for (ProxyEntry p : safeList(() -> store.topAlive(wantTop * multi))) {
                if (onlyFakeTls && !p.isFakeTls()) continue;
                if (!containsId(candidates, p.id)) candidates.add(p);
                if (candidates.size() >= wantTop + 1) break;
            }
            for (ProxyEntry p : safeList(() -> store.randomAlive(wantRandom * multi))) {
                if (onlyFakeTls && !p.isFakeTls()) continue;
                if (!containsId(candidates, p.id)) candidates.add(p);
                if (candidates.size() >= wantTop + wantRandom + 1) break;
            }
        }
        // 4. Truly nothing alive matched — last resort, try best-by-score
        //    (may be unverified) so there's at least something to attempt.
        if (candidates.isEmpty()) {
            java.util.List<ProxyEntry> fallback = safeList(() -> usePerMode
                    ? store.topForMode(fnet, 20 * multi)
                    : store.top(20 * multi));
            if (fallback.isEmpty()) fallback = safeList(() -> store.top(20 * multi));
            for (ProxyEntry p : fallback) {
                if (onlyFakeTls && !p.isFakeTls()) continue;
                if (!containsId(candidates, p.id)) candidates.add(p);
                if (candidates.size() >= 25) break;
            }
        }

        // Pick the connect strategy. OFF is the reference serial trial; the
        // others are experimental and aim to cut "very long to find a link".
        UpstreamConnector.Channel ch;
        switch (connMode) {
            case PARALLEL_RACE:
                ch = tryRace(candidates, tag, dcId, dst, mode, exp,
                        RelayConnectMode.RACE_WIDTH, UPSTREAM_TIMEOUT_MS);
                break;
            case FAST_TIMEOUT:
                ch = trySerial(candidates, tag, dcId, dst, mode, exp,
                        RelayConnectMode.FAST_TIMEOUT_MS);
                break;
            case STICKY_FIRST:
                ch = tryStickyFirst(candidates, tag, dcId, dst, mode, exp);
                break;
            case OFF:
            default:
                // Spread repeated Telegram connects across DIFFERENT alive hosts
                // instead of always re-using the sticky/top one. Otherwise a
                // couple of high-rated hosts win every connection, their rating
                // climbs unbeatably (rich-get-richer), and the rest of the live
                // pool — including the «random alive» diversity candidates added
                // above — never gets actually used. Every candidate here is
                // already alive-verified, so randomising the order costs no
                // reliability, just balances usage.
                java.util.Collections.shuffle(candidates);
                ch = trySerial(candidates, tag, dcId, dst, mode, exp, UPSTREAM_TIMEOUT_MS);
                break;
        }
        // Cascade — nobody took the connection though we had candidates. Wake
        // up the wider check in the background so the next retry has fresh data.
        if (ch == null && !candidates.isEmpty()) {
            RelayLog.emit("⚠ кандидаты не дали апстрим — запускаю расширенную проверку в фоне");
            triggerWiderCheck();
        }
        return ch;
    }

    /** Reference strategy: try candidates one by one with the given timeout. */
    private UpstreamConnector.Channel trySerial(List<ProxyEntry> candidates, int tag, int dcId,
                                                Socks5Server.Target dst, HandshakeMode mode,
                                                WireShaper.Mode exp, int timeoutMs) {
        for (ProxyEntry p : candidates) {
            try {
                return UpstreamConnector.connect(
                        p, tag, dcId, dst.host, dst.port, timeoutMs, mode, exp);
            } catch (Exception e) {
                manager.markUpstreamBad(localPort, p);
                try { store.logRelayAttempt(p.id, false); } catch (Exception ignored) {}
                String why = e.getMessage() != null
                        ? e.getMessage() : e.getClass().getSimpleName();
                RelayLog.emit("✗ " + p.host + ":" + p.port + " — " + why);
            }
        }
        return null;
    }

    /**
     * Experimental: dial the first {@code width} candidates concurrently and
     * keep the FIRST one whose handshake completes; the rest self-close when
     * they finish (the winner is already set). Mimics the instant connect you
     * get pasting one good proxy straight into Telegram, because the fastest
     * healthy upstream wins instead of waiting out dead ones in series. Falls
     * back to a serial trial of the remaining candidates if all racers fail.
     */
    private UpstreamConnector.Channel tryRace(List<ProxyEntry> candidates, int tag, int dcId,
                                              Socks5Server.Target dst, HandshakeMode mode,
                                              WireShaper.Mode exp, int width, int timeoutMs) {
        if (candidates.isEmpty()) return null;
        int n = Math.min(width, candidates.size());
        final java.util.concurrent.atomic.AtomicReference<UpstreamConnector.Channel> winner =
                new java.util.concurrent.atomic.AtomicReference<>();
        final java.util.concurrent.CountDownLatch done = new java.util.concurrent.CountDownLatch(1);
        final java.util.concurrent.atomic.AtomicInteger remaining =
                new java.util.concurrent.atomic.AtomicInteger(n);
        for (int i = 0; i < n; i++) {
            final ProxyEntry p = candidates.get(i);
            Thread t = new Thread(() -> {
                try {
                    UpstreamConnector.Channel c = UpstreamConnector.connect(
                            p, tag, dcId, dst.host, dst.port, timeoutMs, mode, exp);
                    if (winner.compareAndSet(null, c)) {
                        done.countDown();                 // first finisher wins
                    } else {
                        closeQuietly(c.socket);           // lost the race — discard
                    }
                } catch (Exception e) {
                    manager.markUpstreamBad(localPort, p);
                    try { store.logRelayAttempt(p.id, false); } catch (Exception ignored) {}
                    String why = e.getMessage() != null
                            ? e.getMessage() : e.getClass().getSimpleName();
                    RelayLog.emit("✗ " + p.host + ":" + p.port + " — " + why);
                } finally {
                    if (remaining.decrementAndGet() == 0) done.countDown();  // all failed
                }
            }, "race-" + localPort + "-" + i);
            t.setDaemon(true);
            t.start();
        }
        try {
            done.await(timeoutMs + 2000L, java.util.concurrent.TimeUnit.MILLISECONDS);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        UpstreamConnector.Channel ch = winner.get();
        if (ch != null) return ch;
        // All racers failed — try the remaining candidates serially (rare).
        if (candidates.size() > n) {
            return trySerial(candidates.subList(n, candidates.size()), tag, dcId, dst, mode, exp, timeoutMs);
        }
        return null;
    }

    /**
     * Experimental: try the proven sticky/best candidates first with a short
     * timeout (the relay keeps these warm + health-checked), and only fall
     * back to the full list if they don't take the connection.
     */
    private UpstreamConnector.Channel tryStickyFirst(List<ProxyEntry> candidates, int tag, int dcId,
                                                     Socks5Server.Target dst, HandshakeMode mode,
                                                     WireShaper.Mode exp) {
        int head = Math.min(2, candidates.size());
        UpstreamConnector.Channel ch = trySerial(
                candidates.subList(0, head), tag, dcId, dst, mode, exp,
                RelayConnectMode.FAST_TIMEOUT_MS);
        if (ch != null) return ch;
        if (candidates.size() > head) {
            return trySerial(candidates.subList(head, candidates.size()),
                    tag, dcId, dst, mode, exp, UPSTREAM_TIMEOUT_MS);
        }
        return null;
    }

    /**
     * Kicks off a wider health-check pass on the SERVICE pool. Idempotent
     * via a process-wide guard so a flood of failing Telegram retries doesn't
     * spawn dozens of overlapping checks.
     */
    private static final java.util.concurrent.atomic.AtomicLong wideCheckLastAt
            = new java.util.concurrent.atomic.AtomicLong();
    private static final long WIDE_CHECK_COOLDOWN_MS = 60_000L;

    private void triggerWiderCheck() {
        long now = System.currentTimeMillis();
        long last = wideCheckLastAt.get();
        if (now - last < WIDE_CHECK_COOLDOWN_MS) return;
        if (!wideCheckLastAt.compareAndSet(last, now)) return;
        io.autoconnector.engine.core.AppExecutors.SERVICE.submit(() -> {
            try {
                io.autoconnector.engine.check.CheckRunner runner = new io.autoconnector.engine.check.CheckRunner(
                        store, RelayLog::emit, 16);
                runner.runOn(store.top(150), "after-cascade");
                if (manager != null) manager.refreshStickies();
                RelayLog.emit("⟳ расширенная проверка завершена · живых: "
                        + store.aliveCount());
            } catch (Throwable t) {
                RelayLog.emit("расширенная проверка: " + t.getMessage());
            }
        });
    }

    /** Supplies a proxy list, possibly throwing a DB error. */
    private interface ListSupplier { List<ProxyEntry> get() throws Exception; }

    /**
     * Runs a pool query, returning an empty list if it throws. A transient DB
     * error on one source must not bubble up and null the whole upstream
     * selection — that handed Telegram nothing and showed as an instant "broken
     * proxy". We just fall through to the next source / fallback instead.
     */
    private static List<ProxyEntry> safeList(ListSupplier s) {
        try {
            List<ProxyEntry> r = s.get();
            return r != null ? r : java.util.Collections.emptyList();
        } catch (Exception e) {
            return java.util.Collections.emptyList();
        }
    }

    private static boolean containsId(List<ProxyEntry> list, long id) {
        for (ProxyEntry p : list) {
            if (p.id == id) return true;
        }
        return false;
    }

    /**
     * Copies {@code src → dst}, deobfuscating with {@code dec} and
     * re-obfuscating with {@code enc}. On any end-of-stream both sockets are
     * closed so the sibling pipe unblocks too.
     */
    private void pipe(InputStream src, MtCrypto.Ctr dec, MtCrypto.Ctr enc,
                      OutputStream dst,
                      java.util.concurrent.atomic.AtomicLong globalCounter,
                      java.util.concurrent.atomic.AtomicLong connCounter,
                      boolean upDirection, String session) {
        byte[] buf = new byte[PIPE_BUF];
        long accumForProxy = 0;
        long lastFlush = System.currentTimeMillis();
        try {
            int n;
            while ((n = src.read(buf)) > 0) {
                byte[] plain = dec.process(buf, 0, n);
                dst.write(enc.process(plain));
                dst.flush();
                if (upDirection) NetLog.up(session, n); else NetLog.down(session, n);
                long now = System.currentTimeMillis();
                globalCounter.addAndGet(n);
                connCounter.addAndGet(n);
                TrafficMeter.add(TrafficMeter.Cat.RELAY, n);
                RelayStats.LiveConn lc = liveConnRefForLatency;
                if (lc != null) {
                    lc.lastDataAt.set(now);
                    lc.firstDataAt.compareAndSet(0L, now);
                    if (upDirection) {
                        // Mark a write timestamp only if none is pending —
                        // pair the FIRST byte of a Telegram burst with the
                        // FIRST byte of the reply so the gap measures RTT,
                        // not "Telegram's slow write of a 64KB chunk".
                        lc.pendingWriteAt.compareAndSet(0L, now);
                    } else {
                        long sentAt = lc.pendingWriteAt.getAndSet(0L);
                        if (sentAt > 0) {
                            long rtt = now - sentAt;
                            if (rtt > 0 && rtt < 60_000) {
                                io.autoconnector.engine.traffic.LatencyBuffer.INSTANCE.sample(rtt);
                            }
                        }
                    }
                }
                accumForProxy += n;
                if (accumForProxy >= 262144
                        || now - lastFlush >= 15000) {
                    flushBytesToProxy(accumForProxy);
                    accumForProxy = 0;
                    lastFlush = now;
                }
            }
        } catch (IOException ignored) {
            // peer closed or network dropped
        } finally {
            flushBytesToProxy(accumForProxy);
            closeBoth();
        }
    }

    private void flushBytesToProxy(long n) {
        ProxyEntry up = upstreamProxy;
        if (n <= 0 || up == null) return;
        // SQLiteDatabase serialises writes internally — no extra lock here,
        // which used to block sibling pipes on every 256 KB flush.
        try {
            store.addBytesRelayed(up.id, n);
        } catch (Exception ignored) {
        }
    }

    private void closeBoth() {
        closeQuietly(tg);
        closeQuietly(upSocket);
    }

    private static void closeQuietly(Socket s) {
        try {
            if (s != null) s.close();
        } catch (Exception ignored) {
        }
    }
}
