package io.autoconnector.engine.work;

import android.content.Context;

import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import io.autoconnector.engine.core.Prefs;

import java.util.concurrent.TimeUnit;

/**
 * Enqueues the periodic background scan + check jobs, applying the user's
 * battery-saving constraints (Wi-Fi only, charging only, skip on low battery).
 * Safe to call repeatedly — existing work is updated in place.
 */
public final class Scheduler {

    /** WorkManager's hard minimum for periodic work. */
    private static final int MIN_INTERVAL_MIN = 15;

    private Scheduler() {}

    /** Approximate seconds until the next auto-run of "scan" or "check". */
    public static long nextAutoSec(Context ctx, String tag) {
        Prefs p = new Prefs(ctx);
        long last;
        int intervalMin;
        if ("scan".equals(tag)) {
            last = p.lastScanRunMs();
            intervalMin = Math.max(MIN_INTERVAL_MIN, p.scanIntervalMin());
        } else {
            last = p.lastCheckRunMs();
            intervalMin = Math.max(MIN_INTERVAL_MIN, p.checkIntervalMin());
        }
        if (last == 0) last = p.lastRescheduleMs();
        if (last == 0) return -1;
        long nextMs = last + intervalMin * 60_000L;
        return (nextMs - System.currentTimeMillis()) / 1000;
    }

    /** Cancels both background workers. Called when the user disables
     *  «Сканирование» — without this the WorkManager keeps firing them
     *  every 15 min regardless of our in-process flag. */
    public static void cancelAll(Context ctx) {
        WorkManager wm = WorkManager.getInstance(ctx);
        wm.cancelUniqueWork("scan");
        wm.cancelUniqueWork("check");
    }

    public static void reschedule(Context ctx) {
        Prefs p = new Prefs(ctx);
        p.setLastReschedule(System.currentTimeMillis());
        if (!p.scanEnabled()) {
            cancelAll(ctx);
            return;
        }

        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(
                        p.wifiOnly() ? NetworkType.UNMETERED : NetworkType.CONNECTED)
                .setRequiresCharging(p.chargingOnly())
                .setRequiresBatteryNotLow(p.skipLowBattery())
                .build();

        PeriodicWorkRequest scan = new PeriodicWorkRequest.Builder(
                ScanWorker.class,
                Math.max(MIN_INTERVAL_MIN, p.scanIntervalMin()), TimeUnit.MINUTES)
                .setConstraints(constraints)
                .build();

        PeriodicWorkRequest check = new PeriodicWorkRequest.Builder(
                CheckWorker.class,
                Math.max(MIN_INTERVAL_MIN, p.checkIntervalMin()), TimeUnit.MINUTES)
                .setConstraints(constraints)
                .build();

        WorkManager wm = WorkManager.getInstance(ctx);
        wm.enqueueUniquePeriodicWork("scan", ExistingPeriodicWorkPolicy.UPDATE, scan);
        wm.enqueueUniquePeriodicWork("check", ExistingPeriodicWorkPolicy.UPDATE, check);
    }
}
