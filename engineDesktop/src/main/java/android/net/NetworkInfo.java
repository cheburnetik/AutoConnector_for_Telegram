package android.net;

/** Desktop shim for {@code android.net.NetworkInfo} (legacy &lt; M path only). */
public final class NetworkInfo {
    public boolean isConnected() { return true; }
    public int getType() { return ConnectivityManager.TYPE_WIFI; }
}
