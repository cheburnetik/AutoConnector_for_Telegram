package io.autoconnector.engine.traffic;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/**
 * Process-wide windowed traffic accounting.
 *
 * <p>Bytes are bucketed per minute into a 24-hour ring buffer, split into two
 * categories: {@link Cat#SERVICE} (page scanning + proxy checking) and
 * {@link Cat#RELAY} (Telegram traffic carried by the relay). {@link #sum}
 * answers the 5 / 15 / 60-minute and 24-hour windows the UI shows.
 *
 * <p>Counters live in memory for the process lifetime; they reset if the
 * process is killed.
 *
 * <p><b>Concurrency:</b> {@link #add} is called per relayed chunk from multiple
 * pipe threads, so the hot path is lock-free — the per-minute buckets are an
 * {@link AtomicLongArray} and an increment is a single {@code addAndGet}. The
 * only synchronization is the once-per-minute bucket roll-over, guarded by a
 * dedicated monitor that is contended at most when the clock crosses a minute
 * boundary (not on every byte, as the old class-wide {@code synchronized} was).
 * {@code curMinute} is published as the last write under that lock, so a reader
 * that observes a new minute is guaranteed to also observe its bucket already
 * cleared (happens-before through the {@link AtomicLong}).
 */
public final class TrafficMeter {

    /** Traffic category — the two breakdowns the stats screen reports. */
    public enum Cat { SERVICE, RELAY }

    public static final int WINDOW_5M = 5;
    public static final int WINDOW_15M = 15;
    public static final int WINDOW_60M = 60;
    public static final int WINDOW_24H = 1440;

    private static final int MINUTES = 1440;
    private static final AtomicLongArray service = new AtomicLongArray(MINUTES);
    private static final AtomicLongArray relay = new AtomicLongArray(MINUTES);
    private static final AtomicLong curMinute = new AtomicLong(System.currentTimeMillis() / 60000L);
    /** Guards only the rare minute-boundary roll-over, never the increments. */
    private static final Object ROLL_LOCK = new Object();

    private TrafficMeter() {}

    /**
     * Clears buckets that have aged out since the last touch. Lock-free in the
     * common case (no minute crossed); only crossing a minute boundary takes the
     * roll lock, and only the lock holder clears + publishes the new minute.
     */
    private static void roll() {
        long m = System.currentTimeMillis() / 60000L;
        if (m == curMinute.get()) return;          // common case: same minute, no lock
        synchronized (ROLL_LOCK) {
            long cur = curMinute.get();
            if (m <= cur) return;                  // another thread already rolled
            if (m - cur >= MINUTES) {
                for (int i = 0; i < MINUTES; i++) { service.set(i, 0); relay.set(i, 0); }
            } else {
                for (long i = cur + 1; i <= m; i++) {
                    int idx = (int) (i % MINUTES);
                    service.set(idx, 0);
                    relay.set(idx, 0);
                }
            }
            curMinute.set(m);                      // publish last: bucket(m) is now clear
        }
    }

    public static void reset() {
        synchronized (ROLL_LOCK) {
            for (int i = 0; i < MINUTES; i++) { service.set(i, 0); relay.set(i, 0); }
            curMinute.set(System.currentTimeMillis() / 60000L);
        }
    }

    public static void add(Cat c, long bytes) {
        if (bytes <= 0) return;
        roll();
        int idx = (int) (curMinute.get() % MINUTES);
        if (c == Cat.SERVICE) {
            service.addAndGet(idx, bytes);
        } else {
            relay.addAndGet(idx, bytes);
        }
    }

    /** Total bytes for {@code c} over the last {@code minutes}. */
    public static long sum(Cat c, int minutes) {
        roll();
        AtomicLongArray arr = (c == Cat.SERVICE) ? service : relay;
        long cur = curMinute.get();
        long total = 0;
        for (int k = 0; k < minutes && k < MINUTES; k++) {
            int idx = (int) (((cur - k) % MINUTES + MINUTES) % MINUTES);
            total += arr.get(idx);
        }
        return total;
    }

    /** Human-readable byte count (Б / КБ / МБ / ГБ). */
    public static String human(long bytes) {
        if (bytes < 1024) return bytes + " Б";
        double kb = bytes / 1024.0;
        if (kb < 1024) return String.format(Locale.US, "%.1f КБ", kb);
        double mb = kb / 1024.0;
        if (mb < 1024) return String.format(Locale.US, "%.1f МБ", mb);
        return String.format(Locale.US, "%.2f ГБ", mb / 1024.0);
    }
}
