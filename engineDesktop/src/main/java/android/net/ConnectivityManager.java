package android.net;

/**
 * Desktop shim for {@code android.net.ConnectivityManager}. It presents a single
 * stable Wi-Fi network and never fires change callbacks, so {@code NetworkMonitor}
 * resolves to {@code WIFI} mode once and stays there — the right behaviour for a
 * desktop, where the OS, not this app, manages connectivity transitions.
 */
public final class ConnectivityManager {

    public static final int TYPE_MOBILE = 0;
    public static final int TYPE_WIFI = 1;
    public static final int TYPE_VPN = 17;

    /** The single fake network reported on this machine. */
    private static final Network THE_NETWORK = new Network();

    /** Abstract callback — matches the Android API the engine subclasses. */
    public abstract static class NetworkCallback {
        public void onAvailable(Network network) { }
        public void onLost(Network network) { }
        public void onCapabilitiesChanged(Network network, NetworkCapabilities caps) { }
    }

    public Network[] getAllNetworks() {
        return new Network[]{ THE_NETWORK };
    }

    public NetworkCapabilities getNetworkCapabilities(Network network) {
        return new NetworkCapabilities(NetworkCapabilities.TRANSPORT_WIFI);
    }

    public NetworkInfo getActiveNetworkInfo() {
        return new NetworkInfo();
    }

    /** No-op: desktop connectivity changes are not surfaced to the app. */
    public void registerNetworkCallback(NetworkRequest request, NetworkCallback callback) {
    }

    public void unregisterNetworkCallback(NetworkCallback callback) {
    }
}
