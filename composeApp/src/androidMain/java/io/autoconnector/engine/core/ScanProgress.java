package io.autoconnector.engine.core;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Live "what is the scan doing right now" snapshot, shared across the relay
 * engine and both UI backends (desktop / Android). A probe pass calls
 * {@link #begin(int)} when it starts and {@link #end()} when it finishes;
 * {@link io.autoconnector.engine.core.ScanState#probing} already tracks the
 * exact number of probes in flight, so the UI reads that for the thread count.
 *
 * <p>Passes can overlap (the scheduled mains pass and a manual «Сканировать
 * сейчас» may run together), so an active-pass counter guards the timer: the
 * elapsed clock starts on the first pass and only resets once the last one ends.
 */
public final class ScanProgress {

    private static final AtomicInteger active = new AtomicInteger();
    private static volatile long startedAtMs = 0;  // 0 = nothing running
    private static volatile int currentBatch = 0;  // size of the running pass

    /** A probe pass of {@code batch} proxies is about to start. */
    public static void begin(int batch) {
        currentBatch = batch;
        if (active.getAndIncrement() == 0) startedAtMs = System.currentTimeMillis();
    }

    /** A probe pass finished. */
    public static void end() {
        if (active.decrementAndGet() <= 0) {
            active.set(0);
            startedAtMs = 0;
            currentBatch = 0;
        }
    }

    /** Epoch-ms the current run started, or 0 if idle. */
    public static long startedAtMs() { return startedAtMs; }

    /** Proxies in the pass currently running (0 if idle). */
    public static int currentBatch() { return currentBatch; }

    private ScanProgress() {}
}
