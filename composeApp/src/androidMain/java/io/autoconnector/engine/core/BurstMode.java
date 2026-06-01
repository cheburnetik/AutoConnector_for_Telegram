package io.autoconnector.engine.core;

import android.os.SystemClock;

/**
 * Short-lived "scan harder" override. The Subscriptions top buttons flip
 * this on for {@link #DURATION_MS}, during which RelayService runs its
 * mains/explore probes far more often and with larger batches; afterwards
 * the schedule falls back to the user's normal Settings interval.
 *
 * <p>Singleton, atomic so any thread can poke it without lock contention.
 */
public final class BurstMode {

    public static final long DURATION_MS = 90_000L;

    private static volatile long activeUntil = 0L;

    public static void activate() {
        activeUntil = SystemClock.uptimeMillis() + DURATION_MS;
    }

    public static boolean isActive() {
        return SystemClock.uptimeMillis() < activeUntil;
    }

    /** Seconds left in the burst window, 0 if inactive. */
    public static long remainingSec() {
        long left = activeUntil - SystemClock.uptimeMillis();
        return left > 0 ? left / 1000 : 0;
    }

    private BurstMode() {}
}
