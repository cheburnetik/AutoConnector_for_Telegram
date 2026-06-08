package io.autoconnector.engine.traffic;

/**
 * Wall-clock indexed buckets of relay latency (ms), reported as the REAL
 * per-second AVERAGE of the RTT samples that actually landed in that window.
 *
 * <p>Samples come from {@link io.autoconnector.engine.relay.RelayConnection}:
 * the application-level request→response RTT (write toward the upstream paired
 * with the next read back) plus the one-shot upstream TCP-connect RTT recorded
 * at connection setup. Averaging per second — instead of holding a carry-forward
 * EMA — keeps the line moving with real traffic and reading 0 when Telegram
 * isn't actually talking, so it never sits frozen on a single fake number.
 */
public final class LatencyBuffer {

    public static final int N = 60;
    public static final LatencyBuffer INSTANCE = new LatencyBuffer();

    private final long[] secSum = new long[N];
    private final int[]  secCnt = new int[N];
    private final long[] minSum = new long[N];
    private final int[]  minCnt = new int[N];

    private long lastSec = 0;
    private long lastMin = 0;

    private LatencyBuffer() {}

    public synchronized void reset() {
        for (int i = 0; i < N; i++) {
            secSum[i] = 0; secCnt[i] = 0;
            minSum[i] = 0; minCnt[i] = 0;
        }
        lastSec = 0;
        lastMin = 0;
    }

    /** Record one real application-level RTT sample (ms). */
    public synchronized void sample(long latencyMs) {
        if (latencyMs <= 0 || latencyMs > 60_000) return;
        long now = System.currentTimeMillis();
        rollTo(now);
        int si = idx(now / 1000L);
        int mi = idx(now / 60_000L);
        secSum[si] += latencyMs; secCnt[si]++;
        minSum[mi] += latencyMs; minCnt[mi]++;
    }

    /** Called once a second by the engine — rolls the aged buckets to 0. */
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
