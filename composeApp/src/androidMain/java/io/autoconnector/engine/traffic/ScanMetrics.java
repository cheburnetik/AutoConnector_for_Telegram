package io.autoconnector.engine.traffic;

/**
 * Wall-clock windowed counters for the scan/subscription pipeline:
 * subscription downloads (ok / failed) and bytes spent downloading
 * subscriptions + probing hosts. Mirrors {@link CheckRateBuffer}'s ring
 * design; rolls forward lazily on every access so no external tick is needed.
 *
 * <p>"per minute" = sum of the last 60 one-second slots; "per hour" = sum of
 * the last 60 one-minute slots.
 */
public final class ScanMetrics {

    public static final int N = 60;
    public static final ScanMetrics INSTANCE = new ScanMetrics();

    private final long[] subOkSec = new long[N];
    private final long[] subOkMin = new long[N];
    private final long[] subFailSec = new long[N];
    private final long[] subFailMin = new long[N];
    private final long[] bytesSec = new long[N];
    private final long[] bytesMin = new long[N];

    private long lastSec = 0;
    private long lastMin = 0;

    private ScanMetrics() {}

    public synchronized void reset() {
        for (int i = 0; i < N; i++) {
            subOkSec[i] = subOkMin[i] = subFailSec[i] = subFailMin[i] = bytesSec[i] = bytesMin[i] = 0;
        }
        lastSec = lastMin = 0;
    }

    /** Records one finished subscription download. */
    public synchronized void noteSub(boolean ok) {
        long now = System.currentTimeMillis();
        rollTo(now);
        int si = idx(now / 1000L);
        int mi = idx(now / 60_000L);
        if (ok) { subOkSec[si]++; subOkMin[mi]++; }
        else    { subFailSec[si]++; subFailMin[mi]++; }
    }

    /** Records bytes spent on scanning/probing (downloads + probe traffic). */
    public synchronized void addBytes(long n) {
        if (n <= 0) return;
        long now = System.currentTimeMillis();
        rollTo(now);
        bytesSec[idx(now / 1000L)] += n;
        bytesMin[idx(now / 60_000L)] += n;
    }

    private static int idx(long t) { return (int) ((t % N + N) % N); }

    private void rollTo(long now) {
        long curSec = now / 1000L;
        long curMin = now / 60_000L;
        if (lastSec == 0) { lastSec = curSec; lastMin = curMin; return; }
        if (curSec > lastSec) {
            long gap = Math.min(N, curSec - lastSec);
            for (long s = lastSec + 1; s <= lastSec + gap; s++) {
                int i = idx(s); subOkSec[i] = subFailSec[i] = bytesSec[i] = 0;
            }
            lastSec = curSec;
        }
        if (curMin > lastMin) {
            long gap = Math.min(N, curMin - lastMin);
            for (long m = lastMin + 1; m <= lastMin + gap; m++) {
                int i = idx(m); subOkMin[i] = subFailMin[i] = bytesMin[i] = 0;
            }
            lastMin = curMin;
        }
    }

    private long sum(long[] a) { long s = 0; for (long v : a) s += v; return s; }

    public synchronized long subsOkMin()   { rollTo(System.currentTimeMillis()); return sum(subOkSec); }
    public synchronized long subsOkHour()  { rollTo(System.currentTimeMillis()); return sum(subOkMin); }
    public synchronized long subsFailMin() { rollTo(System.currentTimeMillis()); return sum(subFailSec); }
    public synchronized long subsFailHour(){ rollTo(System.currentTimeMillis()); return sum(subFailMin); }
    public synchronized long bytesMinSum() { rollTo(System.currentTimeMillis()); return sum(bytesSec); }
    public synchronized long bytesHourSum(){ rollTo(System.currentTimeMillis()); return sum(bytesMin); }
}
