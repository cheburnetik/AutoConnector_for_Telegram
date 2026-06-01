package io.autoconnector.engine.core;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/**
 * Process-wide transient flags and handles for per-source operations the
 * settings UI surfaces and lets the user cancel.
 */
public final class SourceState {

    /** Source ids whose host list is being downloaded right now. */
    public static final Set<Long> refreshing = ConcurrentHashMap.newKeySet();

    /** Source ids whose proxies are being health-checked right now. */
    public static final Set<Long> checking = ConcurrentHashMap.newKeySet();

    /** Start time (ms) of the in-flight refresh, keyed by source id. */
    public static final Map<Long, Long> refreshingSince = new ConcurrentHashMap<>();

    /** Start time (ms) of the in-flight host-check, keyed by source id. */
    public static final Map<Long, Long> checkingSince = new ConcurrentHashMap<>();

    /** Handle to the refresh thread — used to interrupt on Stop. */
    public static final Map<Long, Thread> refreshThreads = new ConcurrentHashMap<>();

    /** Handle to the host-check pool — used to shutdownNow on Stop. */
    public static final Map<Long, ExecutorService> checkPools = new ConcurrentHashMap<>();

    private SourceState() {}
}
