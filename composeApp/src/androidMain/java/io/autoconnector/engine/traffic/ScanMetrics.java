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
    // Host-probe traffic only (CheckRunner). Kept separate from subscription
    // downloads so the Scan tab's «Трафик скана» graph reflects host scanning
    // alone — subscription bytes have their own channel below.
    private final long[] bytesSec = new long[N];
    private final long[] bytesMin = new long[N];
    // Subscription-download traffic only (PageScanner).
    private final long[] subBytesSec = new long[N];
    private final long[] subBytesMin = new long[N];

    private long lastSec = 0;
    private long lastMin = 0;

    private ScanMetrics() {}

    public synchronized void reset() {
        for (int i = 0; i < N; i++) {
            subOkSec[i] = subOkMin[i] = subFailSec[i] = subFailMin[i] = bytesSec[i] = bytesMin[i] = 0;
            subBytesSec[i] = subBytesMin[i] = 0;
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

    /** Records bytes spent on HOST probing (CheckRunner) — scan traffic only. */
    public synchronized void addBytes(long n) {
        if (n <= 0) return;
        long now = System.currentTimeMillis();
        rollTo(now);
        bytesSec[idx(now / 1000L)] += n;
        bytesMin[idx(now / 60_000L)] += n;
    }

    /** Records bytes spent downloading SUBSCRIPTIONS (PageScanner). */
    public synchronized void addSubBytes(long n) {
        if (n <= 0) return;
        long now = System.currentTimeMillis();
        rollTo(now);
        subBytesSec[idx(now / 1000L)] += n;
        subBytesMin[idx(now / 60_000L)] += n;
    }

    private static int idx(long t) { return (int) ((t % N + N) % N); }

    private void rollTo(long now) {
        long curSec = now / 1000L;
        long curMin = now / 60_000L;
        if (lastSec == 0) { lastSec = curSec; lastMin = curMin; return; }
        if (curSec > lastSec) {
            long gap = Math.min(N, curSec - lastSec);
            for (long s = lastSec + 1; s <= lastSec + gap; s++) {
                int i = idx(s); subOkSec[i] = subFailSec[i] = bytesSec[i] = subBytesSec[i] = 0;
            }
            lastSec = curSec;
        }
        if (curMin > lastMin) {
            long gap = Math.min(N, curMin - lastMin);
            for (long m = lastMin + 1; m <= lastMin + gap; m++) {
                int i = idx(m); subOkMin[i] = subFailMin[i] = bytesMin[i] = subBytesMin[i] = 0;
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
    public synchronized long subBytesMinSum() { rollTo(System.currentTimeMillis()); return sum(subBytesSec); }
    public synchronized long subBytesHourSum(){ rollTo(System.currentTimeMillis()); return sum(subBytesMin); }

    /** Snapshot of the per-second scan-traffic ring, aligned newest-at-index-59
     *  (oldest→newest), suitable for the Scan tab's bytes graph. */
    public synchronized long[] bytesSecSnapshot() {
        rollTo(System.currentTimeMillis());
        long now = System.currentTimeMillis() / 1000L;
        long base = now - (N - 1);
        long[] out = new long[N];
        for (int i = 0; i < N; i++) {
            long t = base + i;
            out[i] = bytesSec[idx(t)];
            // Slots beyond lastSec (future) are zeroed.
            if (t > lastSec) out[i] = 0;
        }
        return out;
    }

    /** Per-minute counterpart of {@link #bytesSecSnapshot()}. */
    public synchronized long[] bytesMinSnapshot() {
        rollTo(System.currentTimeMillis());
        long now = System.currentTimeMillis() / 60_000L;
        long base = now - (N - 1);
        long[] out = new long[N];
        for (int i = 0; i < N; i++) {
            long t = base + i;
            out[i] = bytesMin[idx(t)];
            if (t > lastMin) out[i] = 0;
        }
        return out;
    }

    /** Subscription-download counterpart of {@link #bytesSecSnapshot()}. */
    public synchronized long[] subBytesSecSnapshot() {
        rollTo(System.currentTimeMillis());
        long now = System.currentTimeMillis() / 1000L;
        long base = now - (N - 1);
        long[] out = new long[N];
        for (int i = 0; i < N; i++) {
            long t = base + i;
            out[i] = subBytesSec[idx(t)];
            if (t > lastSec) out[i] = 0;
        }
        return out;
    }

    /** Per-minute counterpart of {@link #subBytesSecSnapshot()}. */
    public synchronized long[] subBytesMinSnapshot() {
        rollTo(System.currentTimeMillis());
        long now = System.currentTimeMillis() / 60_000L;
        long base = now - (N - 1);
        long[] out = new long[N];
        for (int i = 0; i < N; i++) {
            long t = base + i;
            out[i] = subBytesMin[idx(t)];
            if (t > lastMin) out[i] = 0;
        }
        return out;
    }
}
