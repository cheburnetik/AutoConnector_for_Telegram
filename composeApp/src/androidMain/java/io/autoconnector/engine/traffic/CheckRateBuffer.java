package io.autoconnector.engine.traffic;

/**
 * Wall-clock indexed buckets of background-probe outcomes — successes and
 * failures kept separately so the UI can render them as positive-up and
 * negative-down bars on the same axis.
 *
 * <p>CheckRunner calls {@link #onResult(boolean)} for every probe; ticks
 * are advanced by {@link #tick()} (RelayService once a second), which
 * also zeroes any second/minute slots that aged out.
 */
public final class CheckRateBuffer {

    public static final int N = 60;
    public static final CheckRateBuffer INSTANCE = new CheckRateBuffer();

    private final int[] secOk = new int[N];
    private final int[] secFail = new int[N];
    private final int[] minOk = new int[N];
    private final int[] minFail = new int[N];

    private long lastSec = 0;
    private long lastMin = 0;

    private CheckRateBuffer() {}

    public synchronized void reset() {
        for (int i = 0; i < N; i++) {
            secOk[i] = secFail[i] = minOk[i] = minFail[i] = 0;
        }
        lastSec = lastMin = 0;
    }

    public synchronized void onResult(boolean ok) {
        long now = System.currentTimeMillis();
        rollTo(now);
        int si = (int) (((now / 1000L) % N + N) % N);
        int mi = (int) (((now / 60_000L) % N + N) % N);
        if (ok) { secOk[si]++; minOk[mi]++; }
        else    { secFail[si]++; minFail[mi]++; }
    }

    public synchronized void tick() {
        rollTo(System.currentTimeMillis());
    }

    private void rollTo(long now) {
        long curSec = now / 1000L;
        long curMin = now / 60_000L;
        if (lastSec == 0) { lastSec = curSec; lastMin = curMin; return; }
        if (curSec > lastSec) {
            long gap = Math.min(N, curSec - lastSec);
            for (long s = lastSec + 1; s <= lastSec + gap; s++) {
                int i = (int) ((s % N + N) % N);
                secOk[i] = secFail[i] = 0;
            }
            lastSec = curSec;
        }
        if (curMin > lastMin) {
            long gap = Math.min(N, curMin - lastMin);
            for (long m = lastMin + 1; m <= lastMin + gap; m++) {
                int i = (int) ((m % N + N) % N);
                minOk[i] = minFail[i] = 0;
            }
            lastMin = curMin;
        }
    }

    public static final class Snapshot {
        public final int[] ok;
        public final int[] fail;
        public Snapshot(int[] ok, int[] fail) { this.ok = ok; this.fail = fail; }
    }

    public synchronized Snapshot secondsSnapshot() {
        return snapshot(secOk, secFail, lastSec);
    }

    public synchronized Snapshot minutesSnapshot() {
        rollTo(System.currentTimeMillis());
        return snapshot(minOk, minFail, lastMin);
    }

    private Snapshot snapshot(int[] ok, int[] fail, long last) {
        long now = last;
        long base = now - (N - 1);
        int[] outOk = new int[N];
        int[] outFail = new int[N];
        for (int i = 0; i < N; i++) {
            long t = base + i;
            int idx = (int) ((t % N + N) % N);
            outOk[i] = (t > last) ? 0 : ok[idx];
            outFail[i] = (t > last) ? 0 : fail[idx];
        }
        return new Snapshot(outOk, outFail);
    }
}
