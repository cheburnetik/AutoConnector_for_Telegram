package io.autoconnector.engine.traffic;

import io.autoconnector.engine.relay.RelayStats;

/**
 * Process-wide singleton that owns the per-second and per-minute traffic
 * buckets feeding the two main-screen sparklines.
 *
 * <p>Slots are indexed by wall-clock (epoch_seconds % 60, epoch_minutes % 60)
 * so the buffer is stable across Activity onPause/onResume — switching to
 * a different screen and back, or a Telegram reconnect, no longer wipes the
 * graph. Old slots are auto-zeroed as we cross into a new second/minute.
 *
 * <p>This used to live in MainActivity, where it was reset on every onResume.
 */
public final class SparkBuffer {

    public static final int N = 60;
    public static final SparkBuffer INSTANCE = new SparkBuffer();

    private final long[] secBuckets = new long[N];
    private final long[] minBuckets = new long[N];

    private long lastSecSlotTime = 0;
    private long lastMinSlotTime = 0;
    private long prevTotalBytes = -1;

    private SparkBuffer() {}

    /** Reset everything — e.g. after RelayStats.resetCumulative(). */
    public synchronized void reset() {
        for (int i = 0; i < N; i++) {
            secBuckets[i] = 0;
            minBuckets[i] = 0;
        }
        prevTotalBytes = -1;
        lastSecSlotTime = 0;
        lastMinSlotTime = 0;
    }

    /**
     * Ingests the current total bytes counter (up+down). Computes the delta
     * since the last call and lays it into the current second / minute slot.
     */
    public synchronized void onSample(long totalBytesNow) {
        long now = System.currentTimeMillis();
        long curSec = now / 1000L;
        long curMin = now / 60_000L;

        if (prevTotalBytes < 0) {
            prevTotalBytes = totalBytesNow;
            lastSecSlotTime = curSec;
            lastMinSlotTime = curMin;
            return;
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

        long delta = totalBytesNow - prevTotalBytes;
        // Negative delta = RelayStats was reset under us; treat absolute value.
        if (delta < 0) delta = Math.max(0, totalBytesNow);
        prevTotalBytes = totalBytesNow;

        if (delta > 0) {
            secBuckets[(int) (((curSec % N) + N) % N)] += delta;
            minBuckets[(int) (((curMin % N) + N) % N)] += delta;
        }
    }

    /** Snapshot ordered oldest→newest, suitable for TrafficSparkView.setData(buf, 0). */
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

    /** Convenience: pull current bytes total from RelayStats and ingest. */
    public void tickFromRelay() {
        onSample(RelayStats.bytesUp.get() + RelayStats.bytesDown.get());
    }
}
