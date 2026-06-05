package io.autoconnector.engine.relay;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import io.autoconnector.R;
import io.autoconnector.engine.check.CheckRunner;
import io.autoconnector.engine.core.Prefs;
import io.autoconnector.engine.db.ProxyStore;
import io.autoconnector.engine.model.ProxyEntry;
import io.autoconnector.MainActivity;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Foreground service that keeps the {@link RelayManager} (the two loopback
 * SOCKS5 ports) alive in the background and surfaces its state in an ongoing
 * notification.
 */
public final class RelayService extends Service {

    /** True while the relay is bound and accepting connections. */
    public static volatile boolean running = false;

    private static final int NOTIF_ID = 7;
    private static final String CHANNEL_ID = "relay";
    private static final String CHANNEL_ID_QUIET = "relay_quiet";
    /** How often the "main" sticky upstreams get a priority health check
     *  plus a sweep of {@code dueForCheck} candidates. Was 5 min — that
     *  meant 8000-host catalogues went a full day between coverage passes,
     *  catalogue "пров." stuck on hours-old numbers. */
    private static final long MAINS_CHECK_INTERVAL_MS = 2 * 60_000L;

    /** Dedicated looper so periodic tasks never touch the UI thread.
     *  Previously ticks lived on the main looper, where a single stuck
     *  notification IPC or DB query would ANR the whole process — including
     *  MainActivity, hence the white-screen-on-launch symptom. */
    private HandlerThread serviceThread;
    private Handler svc;
    private RelayManager manager;
    private int portA;
    private int portB;

    private final Runnable mainsCheckTask = new Runnable() {
        @Override
        public void run() {
            try {
                if (new io.autoconnector.engine.core.Prefs(RelayService.this).scanEnabled()) {
                    checkMains();
                }
            } catch (Throwable ignored) {}
            if (running) svc.postDelayed(this, dynamicCheckInterval());
        }
    };

    /**
     * Combines three modifiers on top of {@link #MAINS_CHECK_INTERVAL_MS}:
     *   1. user's per-network multiplier from Prefs
     *      (typically 1× Wi-Fi / 1× VPN / 2× LTE for battery)
     *   2. adaptive fast-mode if alive-count falls below the threshold
     *      (cuts interval roughly in half until we refill the pool)
     *   3. {@link io.autoconnector.engine.core.BurstMode} from the Subscriptions
     *      action buttons (forces a 4× sprint for ~90 seconds)
     */
    private long dynamicCheckInterval() {
        io.autoconnector.engine.core.Prefs prefs = new io.autoconnector.engine.core.Prefs(this);
        io.autoconnector.engine.core.NetworkMode net =
                io.autoconnector.engine.core.NetworkMonitor.currentMode();
        int alive = (net != io.autoconnector.engine.core.NetworkMode.UNKNOWN)
                ? ProxyStore.get(this).aliveCountForMode(net)
                : ProxyStore.get(this).aliveCount();
        // Base interval is the user's «Проверка, мин», scaled by the combined
        // intensity (per-net × adaptive). At max intensity it collapses to 0 →
        // we scan continuously (loop with a 1 s yield, not a hot spin).
        float mult = prefs.currentScanMult(net, alive);
        int sec = io.autoconnector.engine.core.Prefs.effectiveCheckSec(prefs.checkIntervalMin(), mult);
        return sec <= 0 ? 1_000L : sec * 1_000L;
    }

    /** Once-a-second SparkBuffer ingest, runs as long as the service is alive,
     *  so the per-minute sparkline keeps filling whether MainActivity is open
     *  or not. */
    private static final long SPARK_TICK_MS = 1_000L;
    private final Runnable sparkTick = new Runnable() {
        @Override
        public void run() {
            try {
                io.autoconnector.engine.traffic.SparkBuffer.INSTANCE.tickFromRelay();
                io.autoconnector.engine.traffic.LatencyBuffer.INSTANCE.tick();
                io.autoconnector.engine.traffic.CheckRateBuffer.INSTANCE.tick();
            } catch (Throwable ignored) {}
            if (running) svc.postDelayed(this, SPARK_TICK_MS);
        }
    };

    /** Coalesces notification updates so a burst of relay events
     *  doesn't fire dozens of NotificationManager IPCs per second. */
    private static final long NOTIF_DEBOUNCE_MS = 2_000L;
    private long lastNotifFired = 0;
    private boolean notifPending = false;
    private final Runnable notifFlush = new Runnable() {
        @Override
        public void run() {
            notifPending = false;
            lastNotifFired = android.os.SystemClock.uptimeMillis();
            try { refreshNotification(); } catch (Throwable ignored) {}
        }
    };

    private void scheduleNotifRefresh() {
        long now = android.os.SystemClock.uptimeMillis();
        long since = now - lastNotifFired;
        if (since >= NOTIF_DEBOUNCE_MS) {
            svc.removeCallbacks(notifFlush);
            notifFlush.run();
        } else if (!notifPending) {
            notifPending = true;
            svc.postDelayed(notifFlush, NOTIF_DEBOUNCE_MS - since);
        }
    }

    /** Re-reads Prefs (proxy-on, scan-on) and applies them: starts/stops
     *  the SOCKS5 ports, starts/stops the mains-check loop, and stops the
     *  whole service when both are off. Always safe to send. */
    public static final String ACTION_RECONFIGURE = "io.autoconnector.engine.RECONFIGURE";

    public static void start(Context ctx) {
        // Don't kick the foreground service if there's nothing for it to do —
        // calling startForegroundService() obligates us to call startForeground()
        // within ~5s or Android kills the process. When both master switches
        // are off we skip the request entirely.
        Prefs prefs = new Prefs(ctx);
        if (!prefs.appEnabled() && !prefs.scanEnabled()) return;
        Intent i = new Intent(ctx, RelayService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            ctx.startForegroundService(i);
        } else {
            ctx.startService(i);
        }
    }

    public static void reconfigure(Context ctx) {
        Intent i = new Intent(ctx, RelayService.class)
                .setAction(ACTION_RECONFIGURE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            ctx.startForegroundService(i);
        } else {
            ctx.startService(i);
        }
    }

    public static void stop(Context ctx) {
        ctx.stopService(new Intent(ctx, RelayService.class));
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // CRITICAL: startForeground MUST be called within ~5s of
        // startForegroundService(), unconditionally. If we skip it (e.g.
        // because both switches are off and we'd just stopSelf), Android
        // crashes the process with ForegroundServiceDidNotStartInTimeException.
        // So: always startForeground FIRST, then decide whether to stay.
        createChannel();
        try {
            if (Build.VERSION.SDK_INT >= 34) {
                startForeground(NOTIF_ID, buildNotification("Релей запускается…"),
                        android.content.pm.ServiceInfo.FOREGROUND_SERVICE_TYPE_SPECIAL_USE);
            } else {
                startForeground(NOTIF_ID, buildNotification("Релей запускается…"));
            }
        } catch (Throwable ignored) {
            // Couldn't promote — Android may still kill us, but at least we
            // tried. The catch keeps the process alive for the rest of init.
        }

        Prefs prefs = new Prefs(this);
        boolean proxyOn = prefs.appEnabled();
        boolean scanOn = prefs.scanEnabled();
        if (!proxyOn && !scanOn) {
            // Both off now → release the notification + stop. We already
            // satisfied the startForeground contract above.
            stopForeground(true);
            stopSelf();
            return START_NOT_STICKY;
        }

        if (serviceThread == null) {
            serviceThread = new HandlerThread("relay-svc",
                    android.os.Process.THREAD_PRIORITY_DEFAULT);
            serviceThread.start();
            svc = new Handler(serviceThread.getLooper());
        }

        svc.post(() -> {
            try {
                io.autoconnector.engine.net.HandshakeStats.init(this);
                io.autoconnector.engine.core.NetworkMonitor.init(this);
                io.autoconnector.engine.core.NetworkMonitor nm =
                        io.autoconnector.engine.core.NetworkMonitor.get();
                if (nm != null && netListener == null) {
                    netListener = newMode -> {
                        RelayLog.emit("⟳ сеть → " + newMode.label
                                + " · обновляю sticky и проверяю топ");
                        if (manager != null) manager.refreshStickies();
                        if (new Prefs(this).scanEnabled()) svc.post(mainsCheckTask);
                    };
                    nm.addListener(netListener);
                }
                applyPrefs();
            } catch (Throwable t) {
                updateNotification("Сбой: " + t.getClass().getSimpleName());
            }
        });
        return START_STICKY;
    }

    private io.autoconnector.engine.core.NetworkMonitor.Listener netListener;

    /** Toggle relay/scan to match Prefs. Idempotent. Called on initial start
     *  and on every ACTION_RECONFIGURE intent (UI toggle). */
    private void applyPrefs() {
        Prefs prefs = new Prefs(this);
        boolean proxyOn = prefs.appEnabled();
        boolean scanOn = prefs.scanEnabled();
        // --- relay/ports ---
        if (proxyOn && manager == null) {
            try {
                portA = prefs.relayPortA();
                portB = prefs.relayPortB();
                RelayStats.reset();
                manager = new RelayManager(portA, portB, ProxyStore.get(this),
                        line -> svc.post(this::scheduleNotifRefresh),
                        getApplicationContext());
                manager.start();
                RelayLog.emit("⏻ релей запущен, порты " + portA + "/" + portB);
            } catch (IOException e) {
                updateNotification("Ошибка запуска: " + e.getMessage());
                manager = null;
            }
        } else if (!proxyOn && manager != null) {
            try {
                manager.stop();
            } catch (Throwable ignored) {}
            manager = null;
            RelayStats.reset();
            RelayLog.emit("⏻ релей остановлен, порты закрыты");
        }
        // --- background scanning ---
        svc.removeCallbacks(mainsCheckTask);
        svc.removeCallbacks(sparkTick);
        if (scanOn) svc.post(mainsCheckTask);
        // Spark ingest also runs in proxy-only mode so the traffic graph keeps
        // filling even when background scanning is off.
        if (scanOn || proxyOn) svc.post(sparkTick);
        running = proxyOn;
        refreshNotification();
        // If everything ended up off (race with toggle), shut down.
        if (!proxyOn && !scanOn) stopSelf();
    }

    @Override
    public void onDestroy() {
        running = false;
        if (svc != null) svc.removeCallbacksAndMessages(null);
        if (manager != null) { try { manager.stop(); } catch (Throwable ignored) {} }
        manager = null;
        if (netListener != null) {
            io.autoconnector.engine.core.NetworkMonitor nm = io.autoconnector.engine.core.NetworkMonitor.get();
            if (nm != null) nm.removeListener(netListener);
            netListener = null;
        }
        if (serviceThread != null) serviceThread.quitSafely();
        super.onDestroy();
    }

    /**
     * Periodic priority probe of the relay's current sticky upstreams plus
     * a small exploration batch from {@link ProxyStore#dueForCheck} so the
     * relay constantly grooms its candidate pool, not just the stickies.
     * If 0 sticky come back alive we trigger an immediate wider check (200
     * hosts) — without this, a cascading death of the top hosts would mean
     * Telegram had no working upstreams until the next scheduled check.
     */
    private void checkMains() {
        io.autoconnector.engine.core.AppExecutors.SERVICE.submit(() -> {
            ProxyStore store = ProxyStore.get(this);
            Set<Long> ids = RelayManager.currentStickyProxyIds();
            List<ProxyEntry> mains = ids.isEmpty()
                    ? new java.util.ArrayList<>()
                    : store.proxiesByIds(ids);

            // Exploration batch + parallelism scale with the current scan
            // intensity («Размер пачки» / «Параллельно» × per-net × adaptive),
            // so cranking intensity probes more hosts, more concurrently.
            io.autoconnector.engine.core.Prefs prefs = new io.autoconnector.engine.core.Prefs(this);
            io.autoconnector.engine.core.NetworkMode net =
                    io.autoconnector.engine.core.NetworkMonitor.currentMode();
            int aliveNow = (net != io.autoconnector.engine.core.NetworkMode.UNKNOWN)
                    ? store.aliveCountForMode(net) : store.aliveCount();
            float mult = prefs.currentScanMult(net, aliveNow);
            int batch = io.autoconnector.engine.core.Prefs.effectiveBatch(prefs.checkBatch(), mult);
            int conc = io.autoconnector.engine.core.Prefs.effectiveConcurrency(prefs.checkConcurrency(), mult);

            List<ProxyEntry> due = store.dueForCheck(batch);
            List<ProxyEntry> combined = new java.util.ArrayList<>(mains);
            for (ProxyEntry d : due) {
                if (!containsId(combined, d.id)) combined.add(d);
            }
            if (combined.isEmpty()) return;

            RelayLog.emit("⟳ проверка: главных " + mains.size()
                    + " + новых " + (combined.size() - mains.size()));
            CheckRunner runner = new CheckRunner(store, RelayLog::emit,
                    Math.min(conc, combined.size()));
            runner.runOn(combined, "mains+due");

            List<ProxyEntry> after = ids.isEmpty()
                    ? new java.util.ArrayList<>()
                    : store.proxiesByIds(ids);
            int aliveMains = 0;
            for (ProxyEntry p : after) if (p.alive) aliveMains++;

            int aliveTotal = store.aliveCount();
            RelayLog.emit("⟳ главные: " + aliveMains + "/" + after.size()
                    + " · в базе живых: " + aliveTotal);

            if (manager != null) manager.refreshStickies();

            // Cascade: every sticky just died AND there are alive hosts
            // elsewhere — go find them aggressively.
            if (!mains.isEmpty() && aliveMains == 0) {
                RelayLog.emit("⚠ все главные мертвы — широкая проверка топ-200");
                CheckRunner wide = new CheckRunner(store, RelayLog::emit, 16);
                wide.runOn(store.top(200), "wide-after-cascade");
                if (manager != null) manager.refreshStickies();
                RelayLog.emit("⟳ широкая проверка готова · живых: "
                        + store.aliveCount());
            }
        });
    }

    private static boolean containsId(List<ProxyEntry> list, long id) {
        for (ProxyEntry p : list) if (p.id == id) return true;
        return false;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void refreshNotification() {
        updateNotification("Порты " + portA + "/" + portB
                + " · соединений: " + RelayStats.active.get()
                + " · всего: " + RelayStats.totalConns.get());
    }

    // --- notification plumbing --------------------------------------------

    private void createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager nm = getSystemService(NotificationManager.class);
            if (nm == null) return;
            NotificationChannel low = new NotificationChannel(
                    CHANNEL_ID, "Релей", NotificationManager.IMPORTANCE_LOW);
            low.setShowBadge(false);
            nm.createNotificationChannel(low);
            // Min-importance channel for "Уведомления отключены" mode:
            // shows nothing on lock screen, silent, collapsed in the
            // drawer. We can't kill the notification entirely while a
            // foreground service runs, but this is the quietest Android allows.
            NotificationChannel min = new NotificationChannel(
                    CHANNEL_ID_QUIET, "Релей (тихо)", NotificationManager.IMPORTANCE_MIN);
            min.setShowBadge(false);
            min.setSound(null, null);
            min.enableVibration(false);
            min.setLockscreenVisibility(Notification.VISIBILITY_SECRET);
            nm.createNotificationChannel(min);
        }
    }

    private Notification buildNotification(String text) {
        int flags = PendingIntent.FLAG_UPDATE_CURRENT;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            flags |= PendingIntent.FLAG_IMMUTABLE;
        }
        PendingIntent tap = PendingIntent.getActivity(
                this, 0, new Intent(this, MainActivity.class), flags);

        boolean quiet = !new Prefs(this).notificationsEnabled();
        String channelId = quiet ? CHANNEL_ID_QUIET : CHANNEL_ID;
        NotificationCompat.Builder b = new NotificationCompat.Builder(this, channelId)
                .setContentTitle("AutoConnector for Telegram — релей активен")
                .setContentText(text)
                .setSmallIcon(R.drawable.ic_stat)
                .setOngoing(true)
                .setContentIntent(tap)
                .setPriority(quiet ? NotificationCompat.PRIORITY_MIN
                                    : NotificationCompat.PRIORITY_LOW)
                .setOnlyAlertOnce(true)
                .setShowWhen(false);
        if (quiet) {
            b.setSilent(true);
            b.setVisibility(NotificationCompat.VISIBILITY_SECRET);
        }
        return b.build();
    }

    private void updateNotification(String text) {
        try {
            NotificationManagerCompat.from(this).notify(NOTIF_ID, buildNotification(text));
        } catch (SecurityException ignored) {
            // POST_NOTIFICATIONS not granted — the service still runs
        }
    }
}
