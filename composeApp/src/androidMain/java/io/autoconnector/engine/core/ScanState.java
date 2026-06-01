package io.autoconnector.engine.core;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Process-wide set of proxy ids that are being probed right now.
 * The host-detail UI reads this to show a per-host "scanning" marker.
 */
public final class ScanState {

    public static final Set<Long> probing = ConcurrentHashMap.newKeySet();

    private ScanState() {}
}
