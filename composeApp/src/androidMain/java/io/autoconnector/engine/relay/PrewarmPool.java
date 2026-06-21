package io.autoconnector.engine.relay;

import android.content.Context;

import io.autoconnector.engine.core.NetworkMode;
import io.autoconnector.engine.core.NetworkMonitor;
import io.autoconnector.engine.core.Prefs;
import io.autoconnector.engine.db.ProxyStore;
import io.autoconnector.engine.model.ProxyEntry;
import io.autoconnector.engine.net.HandshakeMode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * EXPERIMENTAL standby-socket pool ("pre-warm"). Off by default.
 *
 * <p>While the relay app is on it keeps up to N upstream sockets warm so a
 * Telegram connect can skip the expensive connect/handshake. Two modes (Prefs):
 * <ul>
 *   <li><b>deferred (0)</b> — hold only the TCP + FakeTLS handshake, NO
 *       obfuscated2 init: no DC is committed, no dcId/tag is bound, and zero
 *       application bytes are sent (so the cipher stream isn't pre-spent). On
 *       hand-off {@link UpstreamConnector#finishObf} sends the init with the
 *       real dcId/tag. FakeTLS upstreams only — that's where the multi-RTT TLS
 *       handshake actually costs.</li>
 *   <li><b>full (1)</b> — hold fully-handshaked channels (DC committed) spread
 *       across DCs; a hand-off only reuses one whose dcId+tag match.</li>
 * </ul>
 *
 * <p>There is no application-level keepalive: any byte sent would corrupt the
 * eventual real MTProto stream (continuous AES-CTR), and we have no Telegram
 * keys to speak valid MTProto. So liveness is just TCP keepalive + rotation:
 * each socket is dropped and rebuilt once it reaches {@code prewarmHoldSecs}
 * (or dies / its config changes). This is the realistic ceiling — see the
 * design notes in CONCEPT / the PR.
 */
public final class PrewarmPool {

    private static final int FAKETLS_PICK = 40;         // candidate window per source query

    private final ProxyStore store;
    private final Context ctx;

    private final Object lock = new Object();
    private final ArrayDeque<Entry> pool = new ArrayDeque<>();
    private volatile Thread worker;
    private volatile boolean running;
    /** Most recent transport tag seen on a real connect — full mode warms with it. */
    private volatile int lastTag = 0;
    private int dcRoundRobin = 1;                        // full mode: spread DC 1..5

    private static final class Entry {
        final UpstreamConnector.Channel ch;
        final long bornAt;
        final String cfg;
        final boolean deferred;
        final int dcId;     // full mode only
        final int tag;      // full mode only
        Entry(UpstreamConnector.Channel ch, long bornAt, String cfg, boolean deferred, int dcId, int tag) {
            this.ch = ch; this.bornAt = bornAt; this.cfg = cfg; this.deferred = deferred; this.dcId = dcId; this.tag = tag;
        }
    }

    public PrewarmPool(ProxyStore store, Context ctx) {
        this.store = store;
        this.ctx = ctx;
    }

    /** Standby sockets ready for instant hand-off right now. */
    public int readyCount() {
        synchronized (lock) { return pool.size(); }
    }

    /** One warming socket for the Connector-tab table. */
    public static final class Warm {
        public final String host;
        public final long ageSecs;
        Warm(String host, long ageSecs) { this.host = host; this.ageSecs = ageSecs; }
    }

    /** Snapshot of the sockets currently being warmed (not yet handed off). */
    public List<Warm> snapshot() {
        long now = System.currentTimeMillis();
        List<Warm> out = new ArrayList<>();
        synchronized (lock) {
            for (Entry e : pool) {
                String h = (e.ch.proxy != null) ? (e.ch.proxy.host + ":" + e.ch.proxy.port) : "?";
                out.add(new Warm(h, Math.max(0, (now - e.bornAt) / 1000)));
            }
        }
        return out;
    }

    public void start() {
        running = true;
        Thread t = new Thread(this::loop, "prewarm-pool");
        t.setDaemon(true);
        worker = t;
        t.start();
    }

    public void stop() {
        running = false;
        Thread t = worker; worker = null;
        if (t != null) t.interrupt();
        drain();
    }

    /**
     * Try to hand a Telegram connection a warm upstream. Returns a ready
     * {@link UpstreamConnector.Channel} (ciphers seeded) or {@code null} to fall
     * back to a normal connect. Called from RelayConnection before acquireUpstream.
     */
    public UpstreamConnector.Channel take(int tag, int dcId, WireShaper.Mode exp, HandshakeMode mode) {
        lastTag = tag;
        final Prefs p = new Prefs(ctx);
        if (!p.prewarmEnabled()) return null;
        final boolean deferred = p.prewarmMode() == 0;
        final String cfg = cfgSig(p);
        synchronized (lock) {
            for (Iterator<Entry> it = pool.iterator(); it.hasNext(); ) {
                Entry e = it.next();
                if (!cfg.equals(e.cfg) || e.deferred != deferred) continue;
                if (e.ch.socket.isClosed()) { it.remove(); closeQuietly(e.ch); continue; }
                if (deferred) {
                    it.remove();
                    try {
                        UpstreamConnector.finishObf(e.ch, tag, dcId);
                        RelayLog.emit("⚡ prewarm: тёплый сокет (deferred) → " + hostOf(e) + " DC" + dcId);
                        return e.ch;
                    } catch (Exception ex) {
                        closeQuietly(e.ch);   // dead/stale — try the next, else fall back
                    }
                } else if (e.dcId == dcId && e.tag == tag) {
                    it.remove();
                    RelayLog.emit("⚡ prewarm: тёплый сокет (full) → " + hostOf(e) + " DC" + dcId);
                    return e.ch;
                }
            }
        }
        return null;
    }

    // --- worker --------------------------------------------------------------

    private void loop() {
        while (running) {
            try { tick(); } catch (Throwable ignored) {}
            try { Thread.sleep(1000); } catch (InterruptedException ie) { break; }
        }
    }

    private void tick() {
        final Prefs p = new Prefs(ctx);
        if (!p.prewarmEnabled() || !p.appEnabled()) { drain(); return; }
        final boolean deferred = p.prewarmMode() == 0;
        final int want = p.prewarmPool();
        final long holdMs = p.prewarmHoldSecs() * 1000L;
        final String cfg = cfgSig(p);
        final long now = System.currentTimeMillis();

        // Prune aged-out / stale / dead entries. Liveness is probed OUTSIDE the
        // lock — a peer FIN does NOT flip Socket.isClosed()/isInputShutdown(), so
        // dead sockets used to linger the whole hold window (the main reason the
        // pool sat at 0-2 instead of N); we must actually peek the socket, and
        // doing it off-lock avoids blocking take() on the read.
        List<Entry> snapshot;
        synchronized (lock) { snapshot = new ArrayList<>(pool); }
        List<Entry> drop = new ArrayList<>();
        for (Entry e : snapshot) {
            boolean aged = (now - e.bornAt) >= holdMs;
            boolean stale = !cfg.equals(e.cfg) || e.deferred != deferred;
            if (aged || stale || isDeadSocket(e.ch)) drop.add(e);
        }
        if (!drop.isEmpty()) {
            synchronized (lock) { for (Entry e : drop) if (pool.remove(e)) closeQuietly(e.ch); }
        }

        int have;
        synchronized (lock) { have = pool.size(); }
        final int need = want - have;
        if (need <= 0) return;
        // Build the missing slots IN PARALLEL — one slow/failing handshake must not
        // starve the rest (the old serial+break loop sat at ~0-1 socket). Heavily
        // over-provision candidates + retries to ride out FakeTLS handshake
        // failures (~15-30%). Deferred mode needs FakeTLS hosts; full mode (commits
        // a DC anyway) can warm ANY alive proxy — far more candidates.
        final List<ProxyEntry> cands =
                pickCandidates(NetworkMonitor.currentMode(), need * 8 + 16, deferred);
        if (cands.isEmpty()) return;
        final java.util.concurrent.atomic.AtomicInteger ci = new java.util.concurrent.atomic.AtomicInteger(0);
        List<Thread> builders = new ArrayList<>();
        for (int i = 0; i < need && running; i++) {
            Thread t = new Thread(() -> {
                for (int a = 0; a < 5 && running; a++) {
                    int idx = ci.getAndIncrement();
                    if (idx >= cands.size()) return;
                    Entry e = buildOne(p, deferred, cfg, cands.get(idx));
                    if (e != null) {
                        synchronized (lock) {
                            if (pool.size() < want) pool.add(e); else closeQuietly(e.ch);
                        }
                        return;
                    }
                }
            }, "prewarm-build-" + i);
            t.setDaemon(true); builders.add(t); t.start();
        }
        for (Thread t : builders) {
            try { t.join(12000); } catch (InterruptedException ie) { Thread.currentThread().interrupt(); break; }
        }
    }

    private Entry buildOne(Prefs p, boolean deferred, String cfg, ProxyEntry proxy) {
        if (proxy == null) return null;
        HandshakeMode mode = p.dpiApplyRelay()
                ? HandshakeMode.fromOrdinal(p.handshakeMode()) : HandshakeMode.NORMAL;
        WireShaper.Mode exp = WireShaper.Mode.fromCode(p.expEngineMode());
        int timeout = Math.min(8000, p.relayConnectTimeoutMs());
        long born = System.currentTimeMillis();
        try {
            if (deferred) {
                UpstreamConnector.Channel ch = UpstreamConnector.connectHalf(proxy, timeout, mode, exp);
                trySetKeepAlive(ch);
                return new Entry(ch, born, cfg, true, 0, 0);
            } else {
                int dc = nextDc();
                int tag = lastTag != 0 ? lastTag : 0xefefefef;   // default: abridged tag
                UpstreamConnector.Channel ch =
                        UpstreamConnector.connect(proxy, tag, dc, null, 0, timeout, mode, exp);
                trySetKeepAlive(ch);
                return new Entry(ch, born, cfg, false, dc, tag);
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /** A widened, de-duplicated, shuffled candidate set to warm: per-mode top +
     *  global top + random alive. {@code fakeTlsOnly} (deferred mode) restricts to
     *  FakeTLS hosts; full mode accepts ANY alive proxy, which is a far larger pool
     *  when most hosts are plain dd. */
    private List<ProxyEntry> pickCandidates(NetworkMode net, int k, boolean fakeTlsOnly) {
        java.util.LinkedHashMap<Long, ProxyEntry> uniq = new java.util.LinkedHashMap<>();
        if (net != NetworkMode.UNKNOWN) { try { collect(uniq, store.topAliveForMode(net, FAKETLS_PICK), fakeTlsOnly); } catch (Exception ignored) {} }
        try { collect(uniq, store.topAlive(FAKETLS_PICK), fakeTlsOnly); } catch (Exception ignored) {}
        try { collect(uniq, store.randomAlive(FAKETLS_PICK), fakeTlsOnly); } catch (Exception ignored) {}
        List<ProxyEntry> out = new ArrayList<>(uniq.values());
        java.util.Collections.shuffle(out);
        return out.size() > k ? new ArrayList<>(out.subList(0, k)) : out;
    }

    private static void collect(java.util.Map<Long, ProxyEntry> m, List<ProxyEntry> l, boolean fakeTlsOnly) {
        if (l == null) return;
        for (ProxyEntry p : l) {
            if (p == null || m.containsKey(p.id)) continue;
            if (fakeTlsOnly && !p.isFakeTls()) continue;
            m.put(p.id, p);
        }
    }

    /** A pre-warm socket is dead/unusable if the peer closed it (read → -1) or it
     *  unexpectedly has inbound bytes (which would corrupt the deferred obf init).
     *  {@link java.net.Socket#isClosed()}/{@code isInputShutdown()} stay false on a
     *  peer FIN, so we peek with a tiny read timeout; a SocketTimeout means the
     *  socket is idle and alive (the expected state for a warmed standby). */
    private static boolean isDeadSocket(UpstreamConnector.Channel ch) {
        java.net.Socket s = (ch != null) ? ch.socket : null;
        if (s == null || s.isClosed() || s.isInputShutdown() || !s.isConnected()) return true;
        int old = 0;
        try {
            old = s.getSoTimeout();
            s.setSoTimeout(5);
            s.getInputStream().read();   // returns -1 (closed) or a stray byte → unusable
            return true;
        } catch (java.net.SocketTimeoutException te) {
            return false;                // would block → idle & alive (expected)
        } catch (Exception e) {
            return true;
        } finally {
            try { s.setSoTimeout(old); } catch (Exception ignored) {}
        }
    }

    private int nextDc() {
        int dc = dcRoundRobin;
        dcRoundRobin = dcRoundRobin >= 5 ? 1 : dcRoundRobin + 1;
        return dc;
    }

    private void drain() {
        synchronized (lock) {
            for (Entry e : pool) closeQuietly(e.ch);
            pool.clear();
        }
    }

    private String cfgSig(Prefs p) {
        return NetworkMonitor.currentMode().code + "|" + p.expEngineMode() + "|"
                + (p.dpiApplyRelay() ? p.handshakeMode() : -1) + "|" + p.prewarmMode();
    }

    private static void trySetKeepAlive(UpstreamConnector.Channel ch) {
        try { ch.socket.setKeepAlive(true); } catch (Exception ignored) {}
    }

    private static String hostOf(Entry e) {
        return e.ch.proxy != null ? (e.ch.proxy.host + ":" + e.ch.proxy.port) : "?";
    }

    private static void closeQuietly(UpstreamConnector.Channel ch) {
        try { if (ch != null && ch.socket != null) ch.socket.close(); } catch (Exception ignored) {}
    }
}
