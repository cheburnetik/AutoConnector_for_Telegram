package io.autoconnector.engine.core;

/**
 * Single source of truth for "stop all background scanning right now".
 *
 * <p>Flipped to {@code true} when the user unchecks «Сканирование».
 * Every loop that fetches a subscription page, probes a proxy, or runs a
 * checkMains pass reads {@link #isAborted()} on each iteration and bails.
 *
 * <p>Centralised here so a one-line toggle in MainActivity actually stops
 * everything; previously each component had its own (or no) abort check.
 */
public final class ScanGate {

    private static volatile boolean aborted = false;

    /**
     * Probe-only pause. Set when the scan INTENSITY for the current network
     * mode is pushed past the OFF threshold (schedule shows «период —
     * отключено»), while the master «Сканирование» toggle is still on. Stops
     * host-probe passes ({@link io.autoconnector.engine.check.CheckRunner})
     * but deliberately does NOT touch subscription downloads
     * ({@link io.autoconnector.engine.scan.PageScanner}) — those keep their own
     * per-mode cadence and must not report "сканирование отключено" just
     * because the host pool is already full.
     */
    private static volatile boolean probesPaused = false;

    public static boolean isAborted() {
        return aborted;
    }

    public static void setAborted(boolean v) {
        aborted = v;
    }

    public static void setProbesPaused(boolean v) {
        probesPaused = v;
    }

    /** True when host-probe passes must stop — master abort OR intensity pause. */
    public static boolean isProbeAbort() {
        return aborted || probesPaused;
    }

    private ScanGate() {}
}
