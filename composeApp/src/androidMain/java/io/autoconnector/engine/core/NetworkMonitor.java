package io.autoconnector.engine.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Tracks current network transport (VPN / Wi-Fi / LTE) and notifies
 * subscribers on changes. Subscribers update rating snapshots, swap the
 * sticky upstream, and the UI re-renders the «current mode» chip.
 *
 * <p>Detection is via {@code ConnectivityManager.NetworkCallback} on
 * {@link NetworkRequest#NETWORK_CAPABILITIES_LISTEN_ALL}: every network the
 * device acquires (default + VPN overlay) fires its capabilities here.
 * If any of them carries {@code TRANSPORT_VPN} we report VPN mode — that's
 * the user-visible "VPN is on" state regardless of which app provides it.
 * Otherwise Wi-Fi wins over Cellular if both happen to be available.
 */
public final class NetworkMonitor {

    public interface Listener {
        void onModeChanged(NetworkMode newMode);
    }

    private static volatile NetworkMonitor instance;

    public static synchronized void init(Context ctx) {
        if (instance != null) return;
        instance = new NetworkMonitor(ctx.getApplicationContext());
        instance.register();
    }

    public static NetworkMonitor get() {
        return instance;
    }

    public static NetworkMode currentMode() {
        NetworkMonitor m = instance;
        return m != null ? m.mode : NetworkMode.UNKNOWN;
    }

    private final Context ctx;
    private final List<Listener> listeners = new CopyOnWriteArrayList<>();
    private volatile NetworkMode mode = NetworkMode.UNKNOWN;
    private ConnectivityManager.NetworkCallback cb;

    private NetworkMonitor(Context ctx) {
        this.ctx = ctx;
    }

    public void addListener(Listener l) { listeners.add(l); }
    public void removeListener(Listener l) { listeners.remove(l); }

    private void register() {
        ConnectivityManager cm = (ConnectivityManager)
                ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) return;

        cb = new ConnectivityManager.NetworkCallback() {
            @Override
            public void onAvailable(Network n) { recompute(cm); }
            @Override
            public void onLost(Network n) { recompute(cm); }
            @Override
            public void onCapabilitiesChanged(Network n, NetworkCapabilities c) { recompute(cm); }
        };
        try {
            NetworkRequest req = new NetworkRequest.Builder().build();
            cm.registerNetworkCallback(req, cb);
        } catch (Exception ignored) {
            // very old devices — fall back to a one-shot read.
        }
        recompute(cm);
    }

    private synchronized void recompute(ConnectivityManager cm) {
        NetworkMode next = NetworkMode.UNKNOWN;
        boolean hasWifi = false, hasCell = false, hasVpn = false;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (Network n : cm.getAllNetworks()) {
                NetworkCapabilities c = cm.getNetworkCapabilities(n);
                if (c == null) continue;
                if (c.hasTransport(NetworkCapabilities.TRANSPORT_VPN)) hasVpn = true;
                if (c.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) hasWifi = true;
                if (c.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) hasCell = true;
            }
        } else {
            android.net.NetworkInfo info = cm.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                int t = info.getType();
                if (t == ConnectivityManager.TYPE_VPN) hasVpn = true;
                else if (t == ConnectivityManager.TYPE_WIFI) hasWifi = true;
                else if (t == ConnectivityManager.TYPE_MOBILE) hasCell = true;
            }
        }
        if (hasVpn) next = NetworkMode.VPN;
        else if (hasWifi) next = NetworkMode.WIFI;
        else if (hasCell) next = NetworkMode.LTE;

        if (next != mode) {
            mode = next;
            for (Listener l : listeners) {
                try { l.onModeChanged(next); } catch (Exception ignored) {}
            }
        }
    }
}
