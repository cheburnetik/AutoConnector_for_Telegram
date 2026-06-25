package io.autoconnector.engine.relay;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Process-wide live relay counters plus a registry of the connections being
 * relayed right now (so the UI can show whether — and where — Telegram is
 * connected).
 */
public final class RelayStats {

    /** Connections currently being relayed (handshake done, traffic flowing). */
    public static final AtomicInteger active = new AtomicInteger();
    /** Telegram sockets accepted on our SOCKS5 port that are still acquiring an upstream. */
    public static final AtomicInteger accepting = new AtomicInteger();
    /** Connections handled since the relay started. */
    public static final AtomicLong totalConns = new AtomicLong();
    /** Bytes carried Telegram → upstream. */
    public static final AtomicLong bytesUp = new AtomicLong();
    /** Bytes carried upstream → Telegram. */
    public static final AtomicLong bytesDown = new AtomicLong();
    /** Wall-clock ms of the most recent live relay connection registration.
     *  Lets background machinery (e.g. the pre-warm pool) cheaply tell "a
     *  Telegram client is using us / used us very recently" from "idle for a
     *  while" without scanning the live registry. 0 = never. */
    public static final AtomicLong lastClientActivityMs = new AtomicLong();

    private static final Map<Long, LiveConn> live = new ConcurrentHashMap<>();
    private static final AtomicLong liveSeq = new AtomicLong();

    /** A single relay connection in progress. */
    public static final class LiveConn {
        public final int localPort;
        public final String upstream;   // host:port of the chosen upstream proxy
        public final long upstreamProxyId;
        public final int dcId;
        public final boolean upstreamMtproto;
        public final int rttMs;
        /** FakeTLS cover-domain for ee-secrets, null otherwise. */
        public final String fakeTlsSni;
        /** Subscription # the host primarily came from (0 = none). */
        public final int sourceNumber;
        public final long startedAt;
        /** Bytes Telegram → upstream within this connection. */
        public final AtomicLong bytesUp = new AtomicLong();
        /** Bytes upstream → Telegram within this connection. */
        public final AtomicLong bytesDown = new AtomicLong();
        /** Last wall-clock ms when any byte (either direction) moved. */
        public final AtomicLong lastDataAt = new AtomicLong();
        /** First wall-clock ms when ANY real byte flowed AFTER handshake.
         *  Lets stats separate "useful" session time from the handshake warm-up. */
        public final AtomicLong firstDataAt = new AtomicLong();
        /** Wall-clock ms of the most recent Telegram→upstream write —
         *  paired with the next downstream read to estimate request RTT. */
        public final AtomicLong pendingWriteAt = new AtomicLong();
        /** Closer hook — set by RelayConnection so RelayManager can yank a
         *  whole port's worth of sockets when Telegram migrates away. */
        public volatile Runnable killer;
        /** True if this connection's upstream came from the pre-warm pool. */
        public volatile boolean fromPrewarm;

        public LiveConn(int localPort, String upstream, long upstreamProxyId,
                        int dcId, boolean upstreamMtproto, int rttMs,
                        String fakeTlsSni, int sourceNumber) {
            this.localPort = localPort;
            this.upstream = upstream;
            this.upstreamProxyId = upstreamProxyId;
            this.dcId = dcId;
            this.upstreamMtproto = upstreamMtproto;
            this.rttMs = rttMs;
            this.fakeTlsSni = fakeTlsSni;
            this.sourceNumber = sourceNumber;
            this.startedAt = System.currentTimeMillis();
        }
    }

    public static long register(LiveConn c) {
        long id = liveSeq.incrementAndGet();
        live.put(id, c);
        lastClientActivityMs.set(System.currentTimeMillis());
        return id;
    }

    public static void unregister(long id) {
        live.remove(id);
    }

    public static List<LiveConn> liveConnections() {
        return new ArrayList<>(live.values());
    }

    /** Triggers each live connection's {@code killer} for the given port.
     *  Used when Telegram migrates to the OTHER relay port — the abandoned
     *  sockets are guaranteed dead weight at that point. */
    public static int closeOnPort(int port) {
        int killed = 0;
        for (LiveConn c : live.values()) {
            if (c.localPort != port) continue;
            Runnable k = c.killer;
            if (k != null) {
                try { k.run(); } catch (Exception ignored) {}
                killed++;
            }
        }
        return killed;
    }

    public static void reset() {
        active.set(0);
        accepting.set(0);
        totalConns.set(0);
        bytesUp.set(0);
        bytesDown.set(0);
        live.clear();
    }

    private RelayStats() {}
}
