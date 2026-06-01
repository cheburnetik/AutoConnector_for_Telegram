package io.autoconnector.engine.traffic;

/**
 * Wall-clock indexed buckets of relay latency (ms). Each second / minute
 * slot keeps the <em>maximum</em> observed latency in that window — the
 * stat that matters for UX is the worst RTT a Telegram message saw, not
 * the average across the bucket.
 *
 * <p>Latency samples come from {@link io.autoconnector.engine.relay.RelayConnection},
 * which records the gap between writing a chunk towards the upstream and
 * reading the next chunk back from it (i.e. an application-level
 * request→response RTT). Same clock-slot rotation as {@link SparkBuffer}
 * so old slots auto-zero as time crosses second / minute boundaries.
 */
public final class LatencyBuffer {

    public static final int N = 60;
    public static final LatencyBuffer INSTANCE = new LatencyBuffer();

    private final long[] secBuckets = new long[N];
    private final long[] minBuckets = new long[N];
    private long lastSecSlotTime = 0;
    private long lastMinSlotTime = 0;

    private LatencyBuffer() {}

    public synchronized void reset() {
        for (int i = 0; i < N; i++) {
            secBuckets[i] = 0;
            minBuckets[i] = 0;
        }
        lastSecSlotTime = 0;
        lastMinSlotTime = 0;
    }

    /** Record one application-level RTT sample (ms). */
    public synchronized void sample(long latencyMs) {
        if (latencyMs <= 0 || latencyMs > 60_000) return;
        long now = System.currentTimeMillis();
        rollTo(now);
        long curSec = now / 1000L;
        long curMin = now / 60_000L;
        int si = (int) (((curSec % N) + N) % N);
        int mi = (int) (((curMin % N) + N) % N);
        if (latencyMs > secBuckets[si]) secBuckets[si] = latencyMs;
        if (latencyMs > minBuckets[mi]) minBuckets[mi] = latencyMs;
    }

    /** Mark current second/minute even with no samples, so we can read snapshots. */
    public synchronized void tick() {
        rollTo(System.currentTimeMillis());
    }

    private void rollTo(long now) {
        long curSec = now / 1000L;
        long curMin = now / 60_000L;
        if (lastSecSlotTime == 0) { lastSecSlotTime = curSec; lastMinSlotTime = curMin; return; }
        if (curSec > lastSecSlotTime) {
            long gap = Math.min(N, curSec - lastSecSlotTime);
            for (long s = lastSecSlotTime + 1; s <= lastSecSlotTime + gap; s++) {
                secBuckets[(int) (((s % N) + N) % N)] = 0;
            }
            lastSecSlotTime = curSec;
        }
        if (curMin > lastMinSlotTime) {
            long gap = Math.min(N, curMin - lastMinSlotTime);
            for (long m = lastMinSlotTime + 1; m <= lastMinSlotTime + gap; m++) {
                minBuckets[(int) (((m % N) + N) % N)] = 0;
            }
            lastMinSlotTime = curMin;
        }
    }

    public synchronized long[] secondsSnapshot() {
        rollTo(System.currentTimeMillis());
        long now = System.currentTimeMillis() / 1000L;
        long base = now - (N - 1);
        long[] out = new long[N];
        for (int i = 0; i < N; i++) {
            long t = base + i;
            out[i] = secBuckets[(int) (((t % N) + N) % N)];
            if (t > lastSecSlotTime) out[i] = 0;
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
            out[i] = minBuckets[(int) (((t % N) + N) % N)];
            if (t > lastMinSlotTime) out[i] = 0;
        }
        return out;
    }
}
