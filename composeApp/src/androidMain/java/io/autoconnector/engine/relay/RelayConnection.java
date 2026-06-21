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

    /** Short-lived shared cache of the DB-derived upstream candidate pool, so a
     *  burst of Telegram sockets shares one set of queries instead of hammering
     *  SQLite (and pinning the WAL) per connection. See acquireUpstream(). */
    private static volatile java.util.List<ProxyEntry> CAND_CACHE = null;
    private static volatile long CAND_CACHE_AT = 0L;
    private static volatile String CAND_CACHE_KEY = "";
    private static final long CAND_CACHE_TTL_MS = 1500L;

    /** Debounce for the app-level "last Telegram connect" pref stamps: writing
     *  them on every connection rewrote the whole .prefs file synchronously in
     *  the relay hot path. They are display-only, so once every few seconds is
     *  plenty. */
    private static final java.util.concurrent.atomic.AtomicLong LAST_TG_PREF_AT =
            new java.util.concurrent.atomic.AtomicLong();
    private static final long TG_PREF_MIN_GAP_MS = 8000L;

    /** Per-host debounce for failed-relay accounting: a handshake-failure storm
     *  tries many candidates / Telegram opens many sockets fast, so we count a
     *  given host's failure at most once per window (the cooldown then pulls it
     *  out of the selection pool). See CONCEPT_RATING.md. */
    private static final java.util.concurrent.ConcurrentHashMap<Long, Long> FAIL_AT =
            new java.util.concurrent.ConcurrentHashMap<>();
    private static final long FAIL_DEBOUNCE_MS = 8_000L;

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

            // 0. LAN sharing / web-portal multiplex (same ports as Telegram).
            //    - A LAN client when sharing is OFF → ignore (loopback always allowed).
            //    - Sniff the first byte: a browser (HTTP method / TLS 0x16) gets the
            //      proxy-list web page; SOCKS5 (0x05) is Telegram (local or a neighbour)
            //      and falls through to the normal relay path. The peeked byte is
            //      pushed back so the SOCKS handshake sees the stream intact.
            boolean loopback = tg.getInetAddress() != null && tg.getInetAddress().isLoopbackAddress();
            if (!loopback && !prefs.lanShareEnabled()) return;
            java.io.PushbackInputStream pin = new java.io.PushbackInputStream(tgIn, 1);
            int first = pin.read();
            if (first == -1) return;
            pin.unread(first);
            tgIn = pin;
            if (first == 0x16) {                       // TLS ClientHello → browser via https://
                String ip = LanAddress.bestLanIPv4();
                WebPortal.serveTlsHint(tgOut, "http://" + (ip != null ? ip : "<device-ip>") + ":" + localPort);
                return;
            }
            if (first >= 'A' && first <= 'Z') {        // HTTP method (GET/POST/HEAD/…) → browser
                serveWebPortal(pin, tgOut);
                return;
            }

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
            // Read the obfuscated2-init THROUGH a recorder, so that if no upstream
            // can be acquired below we can still replay those exact bytes into a
            // direct bypass. Without this, a hard close after SOCKS-success makes
            // tdesktop declare the proxy "misconfigured" and DISABLE it.
            RecordingInputStream rec = new RecordingInputStream(tgIn);
            Obfuscated2 local = new Obfuscated2();
            local.accept(rec, null);
            int tag = local.transportTag;
            int dcId = local.dcId;
            if (dcId < 1 || dcId > 5) dcId = DcAddresses.dcIdForIp(dst.host);

            // 3. Acquire an upstream, with connect-time failover.
            // 3a. Experimental: try a pre-warmed standby socket first — if the pool
            //     has a warm FakeTLS channel it skips the (multi-RTT) connect/handshake.
            //     take() returns null when the feature is off, so the normal path runs.
            boolean fromPrewarm = false;
            PrewarmPool pw = manager.prewarm();
            if (pw != null) { up = pw.take(tag, dcId, expEngine, handshakeMode); fromPrewarm = up != null; }
            // 3b. Otherwise connect normally.
            if (up == null) {
                up = acquireUpstream(tag, dcId, dst, handshakeMode, onlyFakeTls, expEngine, connMode,
                        prefs.relayRaceWidth(), prefs.relayBreadth(), prefs.relayConnectTimeoutMs());
            }
            // If the chosen proxying engine failed EVERY upstream handshake (common
            // on Windows with «нет»/«сплит» — immediate/fragmented first send), retry
            // once with coalescing: it batches the obfuscated2-init + FakeTLS hello
            // into one clean segment, which far more capricious upstreams accept.
            // This is the engine that empirically never trips Telegram's "proxy
            // misconfigured / will be disabled", so the relay self-heals to it
            // regardless of the user's chosen default. Candidate pool is cached, so
            // the retry only re-does the handshake, not the DB queries.
            if (up == null && expEngine != WireShaper.Mode.COALESCE_DELAY) {
                RelayLog.emit("↻ ни один апстрим не принял handshake (" + expEngine.key
                        + ") — повторяю с коалесингом");
                up = acquireUpstream(tag, dcId, dst, handshakeMode, onlyFakeTls,
                        WireShaper.Mode.COALESCE_DELAY, connMode,
                        prefs.relayRaceWidth(), prefs.relayBreadth(), prefs.relayConnectTimeoutMs());
            }
            if (up == null) {
                // No upstream took the connection — DON'T drop it (that disables the
                // proxy in Telegram). Pass straight to the DC instead, replaying the
                // obfuscated2-init that local.accept() already consumed so the DC
                // sees the full MTProto handshake. The next connection self-heals
                // through a live upstream as soon as one is available.
                listener.event("порт " + localPort + ": нет рабочего апстрима (DC" + dcId
                        + ") — прямой проход, чтобы Telegram не выключил прокси");
                RelayLog.emit("→ прямой проход на DC" + dcId + " (нет рабочего апстрима; прокси оставляем включённым)");
                acceptingDecremented = true;  // handleBypassRaw owns the single decrement
                java.io.InputStream bypassIn = new java.io.SequenceInputStream(
                        new java.io.ByteArrayInputStream(rec.recorded()), tgIn);
                handleBypassRaw(tg, bypassIn, tgOut, dst, prefs.dpiApplyDirect());
                return;
            }
            rec.stopRecording();  // committed to the relay path — free the buffer
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
            // Debounced: these display-only stamps rewrite the whole .prefs file
            // synchronously, so under a burst of Telegram sockets writing them per
            // connection thrashed the disk. Once every few seconds is plenty.
            long prevPref = LAST_TG_PREF_AT.get();
            if (now - prevPref >= TG_PREF_MIN_GAP_MS && LAST_TG_PREF_AT.compareAndSet(prevPref, now)) {
                prefs.setLastTelegramConnect(now);
                if (localPort == manager.portA) prefs.setLastTelegramConnectPortA(now);
                else if (localPort == manager.portB) prefs.setLastTelegramConnectPortB(now);
            }
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
            liveConn.fromPrewarm = fromPrewarm;
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
                // Per-host attempt-history row for the detail card (last-25 list):
                // a successful Telegram connect with its connect timings and the
                // bytes carried this session.
                try {
                    long inB = (liveConnRef != null) ? liveConnRef.bytesDown.get() : 0;
                    long outB = (liveConnRef != null) ? liveConnRef.bytesUp.get() : 0;
                    store.logAttempt(upstreamProxy.id, 1, true,
                            up != null ? up.connectMs : -1,
                            up != null ? up.tlsMs : -1,
                            up != null ? up.totalMs : -1,
                            inB, outB, dur);
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
                                                      RelayConnectMode connMode,
                                                      int raceWidth,
                                                      int breadth,
                                                      int connectTimeoutMs) {
        int multi = onlyFakeTls ? 4 : 1;
        io.autoconnector.engine.core.NetworkMode net =
                io.autoconnector.engine.core.NetworkMonitor.currentMode();
        boolean usePerMode = net != io.autoconnector.engine.core.NetworkMode.UNKNOWN;
        final io.autoconnector.engine.core.NetworkMode fnet = net;

        // If Telegram keeps bouncing between relay ports it can't hold a link —
        // widen the search HARD regardless of the user's breadth knob so the
        // hundreds of other alive hosts get a turn (the «stuck on 4 hosts» bug).
        boolean bouncing = manager.isPortBouncing();
        int b = bouncing ? Math.max(breadth, 80) : Math.max(0, Math.min(100, breadth));

        // Breadth shapes the pool: narrow (0) → mostly top-rated proven hosts;
        // wide (100) → mostly random hosts pulled from the whole alive pool.
        final int wantTop = Math.max(2, 20 - (b * 18 / 100));   // 20 (narrow)..2 (wide)
        final int wantRandom = 4 + (b * 46 / 100);              // 4 (narrow)..50 (wide)
        final boolean wideGlobal = b >= 45;                     // also mix in GLOBAL alive

        // The DB-derived candidate pool is the same for every Telegram socket in a
        // short window, so cache it (TTL ~1.5 s). A burst of connects then shares
        // ONE set of queries instead of hammering SQLite per socket — that read
        // storm was what pinned the WAL (constant disk churn) and slowed acquire
        // (→ SOCKS timeouts → "proxy disabled"). Liveness is still proven by the
        // actual connect below, so a slightly stale list costs nothing.
        String cacheKey = fnet.code + "|" + (b / 10) + "|" + bouncing + "|" + onlyFakeTls;
        long nowMs = System.currentTimeMillis();
        java.util.List<ProxyEntry> pool = CAND_CACHE;
        if (!(pool != null && cacheKey.equals(CAND_CACHE_KEY)
                && nowMs - CAND_CACHE_AT < CAND_CACHE_TTL_MS && !pool.isEmpty())) {
            java.util.List<ProxyEntry> built = new ArrayList<>();
            // 1. Top-rated alive for THIS network mode (VPN/WiFi/LTE graded apart).
            for (ProxyEntry p : safeList(() -> usePerMode
                    ? store.topAliveForMode(fnet, wantTop * multi)
                    : store.topAlive(wantTop * multi))) {
                if (onlyFakeTls && !p.isFakeTls()) continue;
                if (!containsId(built, p.id)) built.add(p);
                if (built.size() >= wantTop) break;
            }
            // 2. Random alive outside the top (per-mode) — exposes undervalued hosts.
            int base = built.size();
            for (ProxyEntry p : safeList(() -> usePerMode
                    ? store.randomAliveForMode(fnet, wantRandom * multi)
                    : store.randomAlive(wantRandom * multi))) {
                if (onlyFakeTls && !p.isFakeTls()) continue;
                if (!containsId(built, p.id)) built.add(p);
                if (built.size() >= base + wantRandom) break;
            }
            // 3. Wide breadth OR a thin per-mode pool: pull from the GLOBAL alive
            //    pool (hundreds of hosts alive globally but not graded for THIS mode).
            if (wideGlobal || built.size() < 5) {
                int base3 = built.size();
                final int globalRandom = Math.max(wantRandom, bouncing ? 60 : 30);
                for (ProxyEntry p : safeList(() -> store.randomAlive(globalRandom * multi))) {
                    if (onlyFakeTls && !p.isFakeTls()) continue;
                    if (!containsId(built, p.id)) built.add(p);
                    if (built.size() >= base3 + globalRandom) break;
                }
                for (ProxyEntry p : safeList(() -> store.topAlive(wantTop * multi))) {
                    if (onlyFakeTls && !p.isFakeTls()) continue;
                    if (!containsId(built, p.id)) built.add(p);
                    if (built.size() >= base3 + globalRandom + wantTop) break;
                }
            }
            // 4. Truly nothing alive matched — last resort, best-by-score (unverified).
            if (built.isEmpty()) {
                java.util.List<ProxyEntry> fallback = safeList(() -> usePerMode
                        ? store.topForMode(fnet, 20 * multi)
                        : store.top(20 * multi));
                if (fallback.isEmpty()) fallback = safeList(() -> store.top(20 * multi));
                for (ProxyEntry p : fallback) {
                    if (onlyFakeTls && !p.isFakeTls()) continue;
                    if (!containsId(built, p.id)) built.add(p);
                    if (built.size() >= 25) break;
                }
            }
            pool = built;
            CAND_CACHE = built;          // shared read-only snapshot
            CAND_CACHE_KEY = cacheKey;
            CAND_CACHE_AT = nowMs;
        }

        // Working copy (never mutate the shared cache): sticky upstream (per-port,
        // in-memory — no DB) first unless widening, then the cached pool.
        List<ProxyEntry> candidates = new ArrayList<>(pool.size() + 1);
        if (!bouncing && b < 70) {
            ProxyEntry sticky = manager.stickyUpstream(localPort);
            if (sticky != null && (!onlyFakeTls || sticky.isFakeTls())
                    && !store.isCooled(sticky.id)) candidates.add(sticky);
        }
        for (ProxyEntry p : pool) if (!containsId(candidates, p.id)) candidates.add(p);

        if (bouncing) {
            RelayLog.emit("⟳ Telegram мечется по портам — расширяю выбор до "
                    + candidates.size() + " разных живых хостов");
        }
        // For wide breadth / bouncing, shuffle so the race AND the serial trial
        // pull from across the whole varied pool, not just the top of the list.
        if (bouncing || b >= 50) java.util.Collections.shuffle(candidates);

        // Pick the connect strategy. OFF is the reference serial trial; the
        // others are experimental and aim to cut "very long to find a link".
        UpstreamConnector.Channel ch;
        switch (connMode) {
            case PARALLEL_RACE:
                ch = tryRace(candidates, tag, dcId, dst, mode, exp,
                        raceWidth, connectTimeoutMs);
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
                // pool never gets used. Every candidate is already alive-verified,
                // so randomising order costs no reliability, just balances usage.
                java.util.Collections.shuffle(candidates);
                ch = trySerial(candidates, tag, dcId, dst, mode, exp, connectTimeoutMs);
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
                logFailedAttempt(p.id);
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
                    logFailedAttempt(p.id);
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
                // Persist the relayed-bytes counter at most every 15 s (and once
                // at session end). The previous per-256 KB flush issued a DB UPDATE
                // dozens of times a second on a fast download — pure disk churn;
                // the live UI reads the in-memory counter, not this column.
                if (now - lastFlush >= 15000) {
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

    /** Records a failed real-Telegram relay attempt against the host: penalises
     *  its rating (failures++ → score recompute) and arms a growing cooldown
     *  after repeated failures so Telegram stops being sent to a host whose real
     *  connects keep failing (CONCEPT_RATING.md). Debounced per host. */
    private void logFailedAttempt(long proxyId) {
        long now = System.currentTimeMillis();
        Long last = FAIL_AT.get(proxyId);
        if (last != null && now - last < FAIL_DEBOUNCE_MS) return;
        FAIL_AT.put(proxyId, now);
        io.autoconnector.engine.core.NetworkMode net =
                io.autoconnector.engine.core.NetworkMonitor.currentMode();
        try { store.markRelayFailure(proxyId, net, now); } catch (Exception ignored) {}
        try { store.logAttempt(proxyId, 1, false, -1, -1, -1, 0, 0, 0); } catch (Exception ignored) {}
    }

    /** Serves the LAN web portal to a browser: this device as a SOCKS proxy
     *  (both relay ports) plus the best discovered hosts as Telegram proxy links. */
    private void serveWebPortal(java.io.InputStream in, OutputStream out) {
        try {
            String ip = LanAddress.bestLanIPv4();
            java.util.List<WebPortal.Link> links = new java.util.ArrayList<>();
            try {
                for (ProxyEntry p : store.topAlive(20)) {
                    String sub = (p.type == ProxyType.MTPROTO)
                            ? ("MTProto" + (p.isFakeTls() ? " · FakeTLS" : p.isDdSecret() ? " · dd" : ""))
                            : "SOCKS5";
                    links.add(new WebPortal.Link(p.host + ":" + p.port, sub, p.tgLink()));
                }
            } catch (Exception ignored) {}
            WebPortal.serveHttp(in, out, ip, manager.portA, manager.portB, links);
        } catch (Exception ignored) {}
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

    /**
     * Input stream that copies everything read into a small buffer until
     * {@link #stopRecording()} is called. Used so the obfuscated2-init consumed
     * by {@code local.accept()} can be replayed into a direct bypass when no
     * upstream can be acquired (otherwise the DC would miss the MTProto handshake
     * and the bypass would fail). Reading is delegated verbatim, so the relay
     * path stays byte-identical.
     */
    private static final class RecordingInputStream extends InputStream {
        private final InputStream src;
        private final java.io.ByteArrayOutputStream rec = new java.io.ByteArrayOutputStream(96);
        private boolean recording = true;

        RecordingInputStream(InputStream src) { this.src = src; }
        void stopRecording() { recording = false; }
        byte[] recorded() { return rec.toByteArray(); }

        @Override public int read() throws IOException {
            int b = src.read();
            if (recording && b >= 0) rec.write(b);
            return b;
        }

        @Override public int read(byte[] b, int off, int len) throws IOException {
            int n = src.read(b, off, len);
            if (recording && n > 0) rec.write(b, off, n);
            return n;
        }

        @Override public int available() throws IOException { return src.available(); }
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
