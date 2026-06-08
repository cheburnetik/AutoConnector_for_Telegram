package io.autoconnector.engine.check;

import io.autoconnector.engine.core.AppExecutors;
import io.autoconnector.engine.core.ScanState;
import io.autoconnector.engine.db.ProxyStore;
import io.autoconnector.engine.model.ProxyEntry;
import io.autoconnector.engine.traffic.TrafficMeter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Probes a batch of proxies in parallel and persists the refreshed ratings.
 *
 * <p>Each probe also lands in the {@link ProxyStore#logCheck rolling 24-hour
 * log} (used by the host-detail screen) and is announced via
 * {@link ScanState#probing} so the UI can flag the host that is being checked
 * right now. Network work — must run off the main thread.
 */
public final class CheckRunner {

    /** Sink for human-readable progress lines. */
    public interface Log {
        void line(String s);
    }

    /** @deprecated kept for source compat — read/write {@link io.autoconnector.engine.core.ScanGate} directly. */
    @Deprecated
    public static boolean GLOBAL_ABORT;  // mirror of ScanGate, no longer authoritative

    private static final int DEFAULT_CONCURRENCY = 12;
    private static final int PROBE_TIMEOUT_MS = 8000;
    /** Coarse per-probe traffic estimate (handshake + resPQ round-trip). */
    private static final int PROBE_BYTES_ESTIMATE = 1400;

    private final ProxyStore store;
    private final Log log;
    private final int concurrency;
    private final HealthChecker checker = new HealthChecker(PROBE_TIMEOUT_MS);

    public CheckRunner(ProxyStore store, Log log) {
        this(store, log, DEFAULT_CONCURRENCY);
    }

    public CheckRunner(ProxyStore store, Log log, int concurrency) {
        this.store = store;
        this.log = log;
        this.concurrency = Math.max(1, concurrency);
    }

    /** Mirrors the relay's anti-DPI policy onto the background probes. */
    public void setProbeMode(io.autoconnector.engine.net.HandshakeMode m) {
        checker.setProbeMode(m);
    }

    /** Probes up to {@code batch} proxies most overdue for a check. */
    public void runBatch(int batch) {
        runOn(store.dueForCheck(batch), "due-for-check");
    }

    /** Probes the given proxy list using the shared probe pool. */
    public void runOn(List<ProxyEntry> list, String label) {
        runOn(list, label, AppExecutors.PROBE);
    }

    /**
     * Probes the given proxy list with at most {@link #concurrency} in flight
     * at a time. Uses {@code pool} for execution (default: the shared
     * {@link AppExecutors#PROBE}) and a {@link Semaphore} for the in-flight
     * cap so that multiple concurrent {@code runOn} calls don't blow the
     * pool past its bound.
     */
    public void runOn(List<ProxyEntry> list, String label, ExecutorService pool) {
        if (list.isEmpty()) {
            log.line("Нет прокси для проверки в " + label + ".");
            return;
        }
        io.autoconnector.engine.core.ScanProgress.begin(list.size());
        try {
            runOnInner(list, label, pool);
        } finally {
            io.autoconnector.engine.core.ScanProgress.end();
        }
    }

    private void runOnInner(List<ProxyEntry> list, String label, ExecutorService pool) {
        try { store.purgeOldChecks(); } catch (Exception ignored) {}
        log.line("— проверка " + list.size() + " прокси (" + label + ") —");

        AtomicInteger full = new AtomicInteger();
        AtomicInteger stealth = new AtomicInteger();
        AtomicInteger dead = new AtomicInteger();
        List<Future<?>> futures = new ArrayList<>();
        Semaphore inflight = new Semaphore(concurrency);

        for (ProxyEntry p : list) {
            if (io.autoconnector.engine.core.ScanGate.isProbeAbort()) break;
            try {
                inflight.acquire();
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                break;
            }
            try {
                futures.add(pool.submit(() -> {
                    try { probeOne(p, full, stealth, dead); }
                    finally { inflight.release(); }
                }));
            } catch (Exception ignored) {
                inflight.release();
                break;
            }
        }
        // Wait with a hard ceiling so a stuck probe can't pin this method
        // forever — the probe's own socket timeout will release the slot
        // shortly after, and the caller (foreground service / Activity)
        // can move on.
        long deadline = System.nanoTime()
                + TimeUnit.SECONDS.toNanos(60L + list.size() * 2L);
        for (Future<?> f : futures) {
            if (io.autoconnector.engine.core.ScanGate.isProbeAbort()) { f.cancel(true); continue; }
            long remain = deadline - System.nanoTime();
            if (remain <= 0) { f.cancel(true); continue; }
            try {
                f.get(remain, TimeUnit.NANOSECONDS);
            } catch (Exception ignored) {
                f.cancel(true);
            }
        }
        log.line("— готово: живых " + full + ", stealth " + stealth
                + ", мёртвых " + dead + " —");
    }

    private void probeOne(ProxyEntry p,
                          AtomicInteger full, AtomicInteger stealth, AtomicInteger dead) {
        ScanState.probing.add(p.id);
        try {
            long t0 = System.currentTimeMillis();
            HealthChecker.Result r = checker.check(p);
            long durMs = System.currentTimeMillis() - t0;
            TrafficMeter.add(TrafficMeter.Cat.SERVICE, PROBE_BYTES_ESTIMATE);
            io.autoconnector.engine.traffic.ScanMetrics.INSTANCE.addBytes(PROBE_BYTES_ESTIMATE);
            io.autoconnector.engine.traffic.CheckRateBuffer.INSTANCE.onResult(r.ok());
            // Ping = TCP-connect round-trip — a real network ping that EVERY
            // reachable host yields (FULL and STEALTH alike), 0 only for dead
            // hosts. This replaces the old handshake-elapsed which was either
            // sparse (FULL-only) or a flat fake ~2.5 s (STEALTH read-timeout).
            // We persist it as the proxy's rtt too, so the Scan-tab ping graph
            // can read a STABLE pool ping each second (it would otherwise starve
            // to 0 between sparse probe passes once the pool is full).
            int pingMs = (r.connectMs > 0) ? r.connectMs : r.rttMs;
            if (r.connectMs > 0)
                io.autoconnector.engine.traffic.ScanPingBuffer.INSTANCE.note(r.connectMs);
            try {
                // Aggregate (legacy) record — UI screens that haven't been
                // mode-split yet still read these columns.
                Rating.record(p, r.ok(), pingMs, r.detail);
                store.updateStats(p);
                store.logCheck(p.id, r.ok());
                // Per-mode record — what the relay actually uses to pick
                // an upstream on the current network.
                io.autoconnector.engine.core.NetworkMode mode =
                        io.autoconnector.engine.core.NetworkMonitor.currentMode();
                if (mode != io.autoconnector.engine.core.NetworkMode.UNKNOWN) {
                    store.recordProbe(p, mode, r.ok(), pingMs, r.detail);
                }
            } catch (Exception ignored) {}
            switch (r.grade) {
                case FULL: full.incrementAndGet(); break;
                case STEALTH: stealth.incrementAndGet(); break;
                default: dead.incrementAndGet(); break;
            }
            log.line(badge(r.grade) + " " + p.host + ":" + p.port
                    + "  " + (r.ok() ? "успех" : "нет")
                    + "  " + String.format("%.1f", durMs / 1000.0) + "с");
        } finally {
            ScanState.probing.remove(p.id);
        }
    }

    /** Single-char prefix used by MainActivity's log-line colourer to tell
     *  a background-probe outcome from a relay-time error: green for OK,
     *  approximation for STEALTH, dim middle-dot for the routine DEAD —
     *  visually distinct from the bright "✗ relay failed" from the pipe. */
    private static String badge(HealthChecker.Grade g) {
        switch (g) {
            case FULL: return "✓";
            case STEALTH: return "≈";
            default: return "·";
        }
    }
}
