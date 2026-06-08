package io.autoconnector.engine.core;

/**
 * Network classification used to keep separate proxy stats per environment.
 * A host that connects 100/sec via a corporate VPN may completely fail
 * under raw LTE — same rating across all conditions is misleading.
 *
 * <p>{@link NetworkMonitor} decides the current mode and emits change
 * events; everything downstream (Rating, CheckRunner, RelayConnection,
 * HandshakeStats) tags its writes / reads with this enum.
 */
public enum NetworkMode {
    /** Any VPN tunnel is active on the device — usually changes the entire
     *  picture of which proxies reach Telegram. */
    VPN("vpn", "🔒 VPN"),
    /** Direct Wi-Fi without VPN. */
    WIFI("wifi", "📶 Wi-Fi"),
    /** Direct cellular (3G/4G/5G) without VPN. */
    LTE("lte", "📡 LTE"),
    /** Direct wired connection (Ethernet). */
    ETHERNET("ethernet", "🌐 Ethernet"),
    /** Manual-only profile ("WhitePages"). Never auto-selected by
     *  {@link NetworkMonitor}; the user forces it from Settings. Keeps its own
     *  per-mode ratings, still downloads subscriptions and scans. */
    WHITEPAGES("wp", "📋 White"),
    /** Fallback when the transport isn't yet determined. */
    UNKNOWN("unk", "?");

    /** True for modes the auto-detector may pick (everything except the
     *  manual-only WhitePages and the UNKNOWN placeholder). */
    public boolean isAutoSelectable() {
        return this == VPN || this == WIFI || this == LTE || this == ETHERNET;
    }

    public final String code;
    public final String label;

    NetworkMode(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public static NetworkMode fromCode(String c) {
        if (c == null) return UNKNOWN;
        for (NetworkMode m : values()) {
            if (m.code.equals(c)) return m;
        }
        return UNKNOWN;
    }

    /** The four "real" modes (incl. manual WhitePages) — UNKNOWN excluded so
     *  stats tables only show meaningful columns. */
    public static NetworkMode[] reportable() {
        return new NetworkMode[]{VPN, WIFI, LTE, ETHERNET, WHITEPAGES};
    }
}
