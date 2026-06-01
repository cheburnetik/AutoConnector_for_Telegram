package android.os;

/**
 * Desktop shim for {@code android.os.SystemClock}. The engine only uses
 * {@link #uptimeMillis()} as a monotonic clock for the burst-mode window and
 * notification debounce, so a {@link System#nanoTime()} reading is an exact
 * functional match (monotonic, unaffected by wall-clock changes).
 */
public final class SystemClock {
    private SystemClock() {}

    public static long uptimeMillis() {
        return System.nanoTime() / 1_000_000L;
    }

    public static long elapsedRealtime() {
        return uptimeMillis();
    }
}
