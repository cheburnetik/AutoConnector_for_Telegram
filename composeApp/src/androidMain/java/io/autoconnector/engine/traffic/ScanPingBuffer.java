package io.autoconnector.engine.traffic;

/**
 * Wall-clock indexed buckets of scan-probe ping (ms), reported as the REAL
 * per-second AVERAGE of the probes that actually completed in that window.
 *
 * <p>Earlier designs used a carry-forward EMA / a pool average, which produced
 * a constant "held" number that looked frozen (and therefore fake) whenever the
 * measurement rate dropped. This buffer instead simply averages the connect
 * RTTs measured during each second / minute — so the line moves with real data
 * and reads 0 only when nothing was actually probed in that window. Samples
 * come from {@link io.autoconnector.engine.check.CheckRunner} (TCP-connect RTT).
 */
public final class ScanPingBuffer {

    public static final int N = 60;
    public static final ScanPingBuffer INSTANCE = new ScanPingBuffer();

    private final long[] secSum = new long[N];
    private final int[]  secCnt = new int[N];
    private final long[] minSum = new long[N];
    private final int[]  minCnt = new int[N];

    private long lastSec = 0;
    private long lastMin = 0;

    private ScanPingBuffer() {}

    public synchronized void reset() {
        for (int i = 0; i < N; i++) {
            secSum[i] = 0; secCnt[i] = 0;
            minSum[i] = 0; minCnt[i] = 0;
        }
        lastSec = 0;
        lastMin = 0;
    }

    /** Record one real probe RTT sample (ms) into the current second / minute. */
    public synchronized void note(long ms) {
        if (ms <= 0 || ms > 60_000) return;
        long now = System.currentTimeMillis();
        rollTo(now);
        int si = idx(now / 1000L);
        int mi = idx(now / 60_000L);
        secSum[si] += ms; secCnt[si]++;
        minSum[mi] += ms; minCnt[mi]++;
    }

    /** Called once a second by the engine — just rolls the aged buckets to 0. */
    public synchronized void tick() {
        rollTo(System.currentTimeMillis());
    }

    private static int idx(long t) { return (int) (((t % N) + N) % N); }

    private void rollTo(long now) {
        long curSec = now / 1000L;
        long curMin = now / 60_000L;
        if (lastSec == 0) { lastSec = curSec; lastMin = curMin; return; }
        if (curSec > lastSec) {
            long gap = Math.min(N, curSec - lastSec);
            for (long s = lastSec + 1; s <= lastSec + gap; s++) {
                int i = idx(s); secSum[i] = 0; secCnt[i] = 0;
            }
            lastSec = curSec;
        }
        if (curMin > lastMin) {
            long gap = Math.min(N, curMin - lastMin);
            for (long m = lastMin + 1; m <= lastMin + gap; m++) {
                int i = idx(m); minSum[i] = 0; minCnt[i] = 0;
            }
            lastMin = curMin;
        }
    }

    /** Snapshot ordered oldest→newest (newest at index 59); each value is the
     *  average ping measured in that second, or 0 if no probe landed. */
    public synchronized long[] secondsSnapshot() {
        rollTo(System.currentTimeMillis());
        long now = System.currentTimeMillis() / 1000L;
        long base = now - (N - 1);
        long[] out = new long[N];
        for (int i = 0; i < N; i++) {
            long t = base + i;
            int j = idx(t);
            out[i] = (t <= lastSec && secCnt[j] > 0) ? secSum[j] / secCnt[j] : 0;
        }
        return out;
    }

    public synchronized long[] minutesSnapshot() {
        rollTo(System.currentTimeMillis());
        long now = System.currentTimeMillis() / 60_000L;
        long base = now - (N - 1);
        long[] out = new long[N];
        for (int i = 0; i < N; i++) {
            long t = base + i;
            int j = idx(t);
            out[i] = (t <= lastMin && minCnt[j] > 0) ? minSum[j] / minCnt[j] : 0;
        }
        return out;
    }
}
