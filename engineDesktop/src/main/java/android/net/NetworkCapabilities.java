package android.net;

/**
 * Desktop shim for {@code android.net.NetworkCapabilities}. A desktop is treated
 * as a single Wi-Fi-class transport, so the engine's per-network logic settles
 * on {@code WIFI} mode (a sensible, stable default for a wired/Wi-Fi machine).
 */
public final class NetworkCapabilities {

    public static final int TRANSPORT_CELLULAR = 0;
    public static final int TRANSPORT_WIFI = 1;
    public static final int TRANSPORT_VPN = 4;
    public static final int TRANSPORT_ETHERNET = 3;

    /** Mirror the real Android constants; the desktop poller ignores requests. */
    public static final int NET_CAPABILITY_NOT_VPN = 15;
    public static final int NET_CAPABILITY_INTERNET = 12;

    private final int transport;

    public NetworkCapabilities(int transport) {
        this.transport = transport;
    }

    public boolean hasTransport(int t) {
        return t == transport;
    }
}
