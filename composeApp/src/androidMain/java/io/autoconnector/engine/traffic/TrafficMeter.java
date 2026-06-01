package io.autoconnector.engine.traffic;

import java.util.Arrays;
import java.util.Locale;

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
 */
public final class TrafficMeter {

    /** Traffic category — the two breakdowns the stats screen reports. */
    public enum Cat { SERVICE, RELAY }

    public static final int WINDOW_5M = 5;
    public static final int WINDOW_15M = 15;
    public static final int WINDOW_60M = 60;
    public static final int WINDOW_24H = 1440;

    private static final int MINUTES = 1440;
    private static final long[] service = new long[MINUTES];
    private static final long[] relay = new long[MINUTES];
    private static long curMinute = System.currentTimeMillis() / 60000L;

    private TrafficMeter() {}

    /** Clears buckets that have aged out since the last touch. */
    private static void roll() {
        long m = System.currentTimeMillis() / 60000L;
        if (m == curMinute) return;
        if (m - curMinute >= MINUTES) {
            Arrays.fill(service, 0);
            Arrays.fill(relay, 0);
        } else {
            for (long i = curMinute + 1; i <= m; i++) {
                int idx = (int) (i % MINUTES);
                service[idx] = 0;
                relay[idx] = 0;
            }
        }
        curMinute = m;
    }

    public static synchronized void reset() {
        Arrays.fill(service, 0);
        Arrays.fill(relay, 0);
        curMinute = System.currentTimeMillis() / 60000L;
    }

    public static synchronized void add(Cat c, long bytes) {
        if (bytes <= 0) return;
        roll();
        int idx = (int) (curMinute % MINUTES);
        if (c == Cat.SERVICE) {
            service[idx] += bytes;
        } else {
            relay[idx] += bytes;
        }
    }

    /** Total bytes for {@code c} over the last {@code minutes}. */
    public static synchronized long sum(Cat c, int minutes) {
        roll();
        long[] arr = (c == Cat.SERVICE) ? service : relay;
        long total = 0;
        for (int k = 0; k < minutes && k < MINUTES; k++) {
            int idx = (int) (((curMinute - k) % MINUTES + MINUTES) % MINUTES);
            total += arr[idx];
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
