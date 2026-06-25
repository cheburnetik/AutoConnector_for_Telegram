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

    /** SO read timeout for the handshake phase — generous so a slow-but-live
     *  proxy isn't false-flagged dead. */
    private static final int PROBE_TIMEOUT_MS = 8000;
    /** TCP-connect timeout — shorter than the read timeout: a live proxy answers
     *  the TCP handshake in well under a second, so an unreachable host gives up
     *  in ~3.5s instead of 8s, roughly halving wasted radio time per dead host. */
    private static final int PROBE_CONNECT_TIMEOUT_MS = 3500;
    /** Rotating counter to sample successful checks into the per-host history
     *  (1 in 8) so continuous scanning doesn't flood attempt_log / the disk. */
    private static final AtomicInteger AL_SAMPLE = new AtomicInteger();
    /** Coarse per-probe traffic estimate (handshake + resPQ round-trip). */
    private static final int PROBE_BYTES_ESTIMATE = 1400;
    /** Throttle for {@link ProxyStore#purgeOldChecks()}: it does a full DELETE
     *  over the 24h check_log, so running it on every probe pass is wasteful.
     *  Gate it to at most once per {@link #PURGE_INTERVAL_MS}. */
    private static final java.util.concurrent.atomic.AtomicLong LAST_PURGE_MS =
            new java.util.concurrent.atomic.AtomicLong();
    private static final long PURGE_INTERVAL_MS = 5 * 60_000L;

    private final ProxyStore store;
    private final Log log;
    private final int concurrency;
    private final HealthChecker checker =
            new HealthChecker(PROBE_CONNECT_TIMEOUT_MS, PROBE_TIMEOUT_MS);

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
            log.line("No proxies to check in " + label + ".");
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
        // Prune the 24h check_log at most once every PURGE_INTERVAL_MS instead of
        // on every pass — the full DELETE is wasted work when passes run back to
        // back. CAS guards against concurrent passes both purging at once.
        long nowP = System.currentTimeMillis();
        long prevP = LAST_PURGE_MS.get();
        if (nowP - prevP >= PURGE_INTERVAL_MS && LAST_PURGE_MS.compareAndSet(prevP, nowP)) {
            try { store.purgeOldChecks(); } catch (Exception ignored) {}
        }
        log.line("— checking " + list.size() + " proxies (" + label + ") —");

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
        log.line("— done: live " + full + ", stealth " + stealth
                + ", dead " + dead + " —");
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
            // Batch this probe's writes (updateStats + cooldown + logCheck +
            // logAttempt + recordProbe) into ONE transaction: a single commit
            // per probe instead of 4-5 autocommits — far fewer WAL fsyncs
            // (battery / flash). Only the quick DB writes are inside the txn; the
            // slow network handshake already finished above. Rating/scoring is
            // unchanged — the legacy aggregate columns are still written.
            try {
                store.beginTransaction();
                try {
                    // Aggregate (legacy) record — UI screens that haven't been
                    // mode-split yet still read these columns.
                    Rating.record(p, r.ok(), pingMs, r.detail);
                    store.updateStats(p);
                    // Probe-failure cooldown: a host that keeps failing the probe
                    // earns a growing, capped cool_until so it drops out of
                    // dueForCheck instead of timing out every pass; a passing
                    // probe (a real resPQ from a live DC) clears the streak.
                    if (r.ok()) store.clearProbeCooldown(p.id);
                    else store.markProbeFailure(p.id, System.currentTimeMillis());
                    store.logCheck(p.id, r.ok());
                    // Record into the per-host history shown on the detail card. To
                    // keep disk writes low under continuous scanning we log EVERY
                    // failure (the interesting events) but only a 1-in-8 sample of
                    // routine successful re-checks; Telegram connects are always
                    // logged separately by the relay. logAttempt never throws.
                    if (!r.ok() || (AL_SAMPLE.incrementAndGet() & 0x7) == 0L) {
                        store.logAttempt(p.id, 0, r.ok(), -1, -1, r.ok() ? pingMs : -1, 0, 0, 0);
                    }
                    // Per-mode record — what the relay actually uses to pick
                    // an upstream on the current network.
                    io.autoconnector.engine.core.NetworkMode mode =
                            io.autoconnector.engine.core.NetworkMonitor.currentMode();
                    if (mode != io.autoconnector.engine.core.NetworkMode.UNKNOWN) {
                        store.recordProbe(p, mode, r.ok(), pingMs, r.detail);
                    }
                    store.setTransactionSuccessful();
                } finally {
                    store.endTransaction();
                }
            } catch (Exception ignored) {}
            switch (r.grade) {
                case FULL: full.incrementAndGet(); break;
                case STEALTH: stealth.incrementAndGet(); break;
                default: dead.incrementAndGet(); break;
            }
            log.line(badge(r.grade) + " " + p.host + ":" + p.port
                    + "  " + (r.ok() ? "ok" : "no")
                    + "  " + String.format("%.1f", durMs / 1000.0) + "s");
        } finally {
            ScanState.probing.remove(p.id);
        }
    }

    /** Single-char prefix the log-line colourer reads to grade a probe outcome:
     *  a bold green dot "●" for a working host (OK), an approximation "≈" for the
     *  partially-reachable STEALTH host (also OK/green), and a red cross "✗" for
     *  the routine DEAD host — so the scan log reads green for success, red for
     *  failure at a glance. */
    private static String badge(HealthChecker.Grade g) {
        switch (g) {
            case FULL: return "●";
            case STEALTH: return "≈";
            default: return "✗";
        }
    }
}
