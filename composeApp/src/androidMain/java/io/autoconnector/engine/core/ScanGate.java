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

    public static boolean isAborted() {
        return aborted;
    }

    public static void setAborted(boolean v) {
        aborted = v;
    }

    private ScanGate() {}
}
