package io.autoconnector.engine.traffic;

/**
 * Per-second and per-minute counts of new relay connections (inbound sockets
 * Telegram opens plus outbound upstream connections), split by the two local
 * ports. The lower port (55001) goes to series A, the higher (55002) to series B.
 *
 * <p>{@link #noteInbound(int)} / {@link #noteOutbound(int)} record events with
 * their local port; {@link #tick()} (once a second) zeroes aged-out slots.
 */
public final class ConnectBuffer {

    public static final int N = 60;
    public static final ConnectBuffer INSTANCE = new ConnectBuffer();

    // Fixed local relay ports (Prefs defaults). Lower → series A (left graph),
    // higher → series B (right graph).
    private static final int PORT_A = 55001;
    private static final int PORT_B = 55002;

    private final long[] secA = new long[N];
    private final long[] secB = new long[N];
    private final long[] minA = new long[N];
    private final long[] minB = new long[N];
    private long lastSec = 0;
    private long lastMin = 0;

    private ConnectBuffer() {}

    public synchronized void reset() {
        for (int i = 0; i < N; i++) { secA[i] = 0; secB[i] = 0; minA[i] = 0; minB[i] = 0; }
        lastSec = 0; lastMin = 0;
    }

    /** series 1 (B) for the higher port, series 0 (A) otherwise. */
    private int slotForPort(int port) {
        return (port == PORT_B) ? 1 : 0;
    }

    public synchronized void note(int port) {
        long now = System.currentTimeMillis();
        roll(now);
        int si = (int) (((now / 1000L) % N + N) % N);
        int mi = (int) (((now / 60000L) % N + N) % N);
        if (slotForPort(port) == 0) { secA[si]++; minA[mi]++; }
        else { secB[si]++; minB[mi]++; }
    }

    public void noteInbound(int port) { note(port); }
    public void noteOutbound(int port) { note(port); }

    public synchronized void tick() { roll(System.currentTimeMillis()); }

    private void roll(long now) {
        long cur = now / 1000L;
        if (lastSec == 0) lastSec = cur;
        else if (cur > lastSec) {
            long gap = Math.min(N, cur - lastSec);
            for (long sct = lastSec + 1; sct <= lastSec + gap; sct++) {
                int i = (int) ((sct % N + N) % N);
                secA[i] = 0; secB[i] = 0;
            }
            lastSec = cur;
        }
        long curMin = now / 60000L;
        if (lastMin == 0) lastMin = curMin;
        else if (curMin > lastMin) {
            long gap = Math.min(N, curMin - lastMin);
            for (long m = lastMin + 1; m <= lastMin + gap; m++) {
                int i = (int) ((m % N + N) % N);
                minA[i] = 0; minB[i] = 0;
            }
            lastMin = curMin;
        }
    }

    public synchronized long[] secondsSnapshotA() { return snap(secA, lastSec); }
    public synchronized long[] secondsSnapshotB() { return snap(secB, lastSec); }
    public synchronized long[] minutesSnapshotA() { return snap(minA, lastMin); }
    public synchronized long[] minutesSnapshotB() { return snap(minB, lastMin); }
    public int portA() { return PORT_A; }
    public int portB() { return PORT_B; }

    private long[] snap(long[] src, long last) {
        roll(System.currentTimeMillis());
        long base = last - (N - 1);
        long[] out = new long[N];
        for (int i = 0; i < N; i++) {
            long t = base + i;
            int idx = (int) ((t % N + N) % N);
            out[i] = (t > last) ? 0 : src[idx];
        }
        return out;
    }
}
