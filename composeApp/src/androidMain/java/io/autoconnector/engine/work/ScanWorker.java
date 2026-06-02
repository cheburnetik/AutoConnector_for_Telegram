package io.autoconnector.engine.work;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import io.autoconnector.engine.core.Prefs;
import io.autoconnector.engine.db.ProxyStore;
import io.autoconnector.engine.scan.PageScanner;

/**
 * Periodic background page scan, scheduled by {@link Scheduler}. Sources that
 * keep failing get exponential backoff so we don't burn battery hammering
 * permanently-dead URLs.
 */
public final class ScanWorker extends Worker {

    public ScanWorker(@NonNull Context ctx, @NonNull WorkerParameters params) {
        super(ctx, params);
    }

    @NonNull
    @Override
    public Result doWork() {
        Context ctx = getApplicationContext();
        if (!new Prefs(ctx).scanEnabled()) return Result.success();
        try {
            ProxyStore store = ProxyStore.get(ctx);
            PageScanner scanner = new PageScanner(store, s -> {});
            long now = System.currentTimeMillis();
            for (ProxyStore.Source s : store.listSources()) {
                if (!s.enabled) continue;
                long backoff = backoffFor(s.consecutiveFailures);
                if (s.lastRefreshAt > 0 && now - s.lastRefreshAt < backoff) continue;
                PageScanner.ScanResult r = scanner.scanPage(s.url);
                store.markSourceRefreshed(s.id);
                store.setSourceScanResult(s.id, r.found, r.bytes, r.error);
            }
            return Result.success();
        } catch (Exception e) {
            return Result.retry();
        } finally {
            new Prefs(ctx).setLastScanRun(System.currentTimeMillis());
        }
    }

    /** Exponential backoff for sources that keep failing — saves battery. */
    private static long backoffFor(int failures) {
        if (failures < 3) return 0;
        if (failures < 5) return 60L * 60_000L;        // 1 hour
        if (failures < 8) return 6L * 60 * 60_000L;    // 6 hours
        return 24L * 60 * 60_000L;                     // 1 day
    }
}
