package io.autoconnector.engine.traffic;

/**
 * Process-wide singleton that records the SAMPLED total live-proxy count per
 * second and per minute, feeding the Scan tab's "total live proxies" graph.
 *
 * <p>Unlike {@link SparkBuffer} (which sums deltas into each bucket), this is a
 * gauge: each bucket holds the LATEST sample seen during that second / minute,
 * not a running sum. Slots are indexed by wall-clock (epoch_seconds % 60,
 * epoch_minutes % 60) so the series is stable across screen switches; aged-out
 * slots are zeroed as we cross into a new second / minute.
 */
public final class AliveHistBuffer {

    public static final int N = 60;
    public static final AliveHistBuffer INSTANCE = new AliveHistBuffer();

    private final long[] secBuckets = new long[N];
    private final long[] minBuckets = new long[N];

    private long lastSecSlotTime = 0;
    private long lastMinSlotTime = 0;

    private AliveHistBuffer() {}

    /** Reset everything. */
    public synchronized void reset() {
        for (int i = 0; i < N; i++) {
            secBuckets[i] = 0;
            minBuckets[i] = 0;
        }
        lastSecSlotTime = 0;
        lastMinSlotTime = 0;
    }

    /**
     * Records the current total live-proxy count. The latest sample of each
     * second / minute wins (overwrite), so the graph tracks the gauge value.
     */
    public synchronized void tick(long aliveCount) {
        long now = System.currentTimeMillis();
        long curSec = now / 1000L;
        long curMin = now / 60_000L;

        if (lastSecSlotTime == 0) {
            lastSecSlotTime = curSec;
            lastMinSlotTime = curMin;
        }

        // Zero out slots that have aged out since the last sample.
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

        secBuckets[(int) (((curSec % N) + N) % N)] = aliveCount;
        minBuckets[(int) (((curMin % N) + N) % N)] = aliveCount;
    }

    /** Snapshot ordered oldest→newest (newest at index 59). */
    public synchronized long[] secondsSnapshot() {
        long now = System.currentTimeMillis() / 1000L;
        long base = now - (N - 1);
        long[] out = new long[N];
        for (int i = 0; i < N; i++) {
            long t = base + i;
            out[i] = secBuckets[(int) (((t % N) + N) % N)];
            // Slots beyond lastSecSlotTime (future) are zeroed.
            if (t > lastSecSlotTime) out[i] = 0;
        }
        return out;
    }

    public synchronized long[] minutesSnapshot() {
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
