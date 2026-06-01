package io.autoconnector.engine.work;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import io.autoconnector.engine.check.CheckRunner;
import io.autoconnector.engine.core.Prefs;
import io.autoconnector.engine.db.ProxyStore;

/** Periodic background health-check pass, scheduled by {@link Scheduler}. */
public final class CheckWorker extends Worker {

    public CheckWorker(@NonNull Context ctx, @NonNull WorkerParameters params) {
        super(ctx, params);
    }

    @NonNull
    @Override
    public Result doWork() {
        Context ctx = getApplicationContext();
        Prefs p = new Prefs(ctx);
        if (!p.scanEnabled()) return Result.success();
        try {
            CheckRunner runner = new CheckRunner(
                    ProxyStore.get(ctx), s -> {}, p.checkConcurrency());
            runner.runBatch(p.checkBatch());
            return Result.success();
        } catch (Exception e) {
            return Result.retry();
        } finally {
            new Prefs(ctx).setLastCheckRun(System.currentTimeMillis());
        }
    }
}
