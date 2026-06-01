package io.autoconnector.engine.check;

import io.autoconnector.engine.model.ProxyEntry;

/**
 * Health-probe bookkeeping and the 0..100 rating formula.
 *
 * <p>Score blends three signals: the success ratio, the last round-trip,
 * and an alive bonus — all scaled by a confidence factor so a proxy with
 * only one or two probes never outranks a thoroughly-tested one.
 */
public final class Rating {

    /** Folds one probe result into the entry's stats and recomputes score. */
    public static void record(ProxyEntry p, boolean ok, int rttMs, String detail) {
        long now = System.currentTimeMillis();
        p.lastCheck = now;
        p.alive = ok;
        if (ok) {
            p.successes++;
            p.rttMs = rttMs;
            p.lastOk = now;
            p.lastError = null;
        } else {
            p.failures++;
            p.lastError = detail;
        }
        p.score = compute(p);
    }

    private static double compute(ProxyEntry p) {
        return computePerMode(p.successes, p.failures, p.rttMs, p.alive);
    }

    /** Same scoring formula as the aggregate, but driven by per-(proxy,mode)
     *  counters so VPN successes don't lift a host's LTE rank. */
    public static double computePerMode(int successes, int failures, int rttMs, boolean alive) {
        int total = successes + failures;
        if (total == 0) return 0;
        double ratio = (double) successes / total;
        double rttFactor = rttMs <= 0
                ? 0.5
                : Math.max(0, Math.min(1, 1.0 - rttMs / 3000.0));
        double confidence = Math.min(1.0, total / 5.0);
        double base = ratio * 70 + rttFactor * 25;
        double freshness = alive ? 1.0 : 0.1;
        return Math.round(base * confidence * freshness * 10) / 10.0;
    }

    private Rating() {}
}
