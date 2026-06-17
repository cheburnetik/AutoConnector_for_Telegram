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
 * <p>Detection is driven by {@code registerDefaultNetworkCallback}: it tracks
 * the single network the system is actually routing traffic through. When a
 * VPN comes up it BECOMES the default network (its caps carry
 * {@code TRANSPORT_VPN} on top of the underlying transport), so we report VPN;
 * when it drops, the default flips back to Wi-Fi/Cellular and the same callback
 * fires again. This also catches a plain Wi-Fi↔LTE handover, which the old
 * custom {@code NetworkRequest} (strict default capabilities) used to miss —
 * its onLost/onCapabilitiesChanged never fired for the VPN or the transition,
 * so the detected mode stuck.
 *
 * <p>The mode is read STRAIGHT from the capabilities the callback hands us
 * ({@code TRANSPORT_VPN} > {@code WIFI} > {@code CELLULAR} > {@code ETHERNET}),
 * not by re-scanning {@link ConnectivityManager#getAllNetworks()} — that scan
 * can lag the callback and re-introduce the stickiness. getAllNetworks() is
 * kept only as a fallback for {@code onLost} and the initial one-shot read.
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
        return m != null ? m.effective() : NetworkMode.UNKNOWN;
    }

    /** Force a network mode regardless of detection ({@code null} = auto).
     *  Persisting the choice is the engine's job, not done here. */
    public static void setManualMode(NetworkMode m) {
        NetworkMonitor i = instance;
        if (i == null) return;
        synchronized (i) {
            NetworkMode before = i.effective();
            i.manual = m;
            NetworkMode now = i.effective();
            if (now != before) i.notifyAll_(now);
        }
    }

    /** Current user override, or {@code null} when in auto mode. */
    public static NetworkMode manualMode() {
        NetworkMonitor i = instance;
        return i != null ? i.manual : null;
    }

    /** True when no manual override is active (mode follows detection). */
    public static boolean isAuto() {
        NetworkMonitor i = instance;
        return i == null || i.manual == null;
    }

    /** Feed a detected transport from a platform without a
     *  {@code ConnectivityManager} (desktop). Null-safe. */
    public static void setDetectedMode(NetworkMode m) {
        NetworkMonitor i = instance;
        if (i != null) i.applyDetected(m);
    }

    private final Context ctx;
    private final List<Listener> listeners = new CopyOnWriteArrayList<>();
    private volatile NetworkMode detected = NetworkMode.UNKNOWN;
    private volatile NetworkMode manual = null;
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
            public void onAvailable(Network n) {
                // Caps usually arrive in onCapabilitiesChanged right after this;
                // recompute as a safety net in case that ordering is skipped.
                recompute(cm);
            }
            @Override
            public void onLost(Network n) {
                // The default network went away — the next default (if any)
                // arrives via onAvailable/onCapabilitiesChanged. Recompute now
                // so we don't linger on a transport that no longer exists.
                recompute(cm);
            }
            @Override
            public void onCapabilitiesChanged(Network n, NetworkCapabilities c) {
                // Authoritative path: read the mode straight from the DEFAULT
                // network's fresh caps. This is what kills the stickiness — no
                // getAllNetworks() race, and a VPN-up / VPN-down / Wi-Fi↔LTE
                // handover all surface here as a new capability set.
                applyDetected(modeFromCaps(c));
            }
        };
        try {
            // The default-network callback follows whichever single network the
            // system routes through. A VPN, once connected, IS that default
            // network (and its caps carry TRANSPORT_VPN), so both its arrival
            // and its teardown reach us — unlike the old strict NetworkRequest,
            // which silently dropped VPN and mid-handover networks and left the
            // detected mode frozen.
            cm.registerDefaultNetworkCallback(cb);
        } catch (Exception e) {
            // Should not happen on minSdk 24+, but don't fail silently: fall
            // back to a lenient ALL-networks listen plus a one-shot read.
            io.autoconnector.engine.relay.RelayLog.emit(
                    "⚠ NetworkMonitor: registerDefaultNetworkCallback failed ("
                    + e.getClass().getSimpleName() + "), using fallback");
            try {
                NetworkRequest req = new NetworkRequest.Builder()
                        .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                        .removeCapability(NetworkCapabilities.NET_CAPABILITY_NOT_VPN)
                        .build();
                cm.registerNetworkCallback(req, cb);
            } catch (Exception ignored) {
                // very old / locked-down devices — rely on the one-shot below.
            }
        }
        recompute(cm);
    }

    /** Classify a single network's capabilities into a transport mode.
     *  VPN wins because a VPN network's caps also expose the underlying
     *  transport (Wi-Fi/Cellular) — the tunnel is what the user cares about. */
    private static NetworkMode modeFromCaps(NetworkCapabilities c) {
        if (c == null) return NetworkMode.UNKNOWN;
        if (c.hasTransport(NetworkCapabilities.TRANSPORT_VPN)) return NetworkMode.VPN;
        if (c.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) return NetworkMode.WIFI;
        if (c.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) return NetworkMode.LTE;
        if (c.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) return NetworkMode.ETHERNET;
        return NetworkMode.UNKNOWN;
    }

    private synchronized void recompute(ConnectivityManager cm) {
        NetworkMode next = NetworkMode.UNKNOWN;
        boolean hasWifi = false, hasCell = false, hasVpn = false, hasEth = false;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (Network n : cm.getAllNetworks()) {
                NetworkCapabilities c = cm.getNetworkCapabilities(n);
                if (c == null) continue;
                if (c.hasTransport(NetworkCapabilities.TRANSPORT_VPN)) hasVpn = true;
                if (c.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) hasWifi = true;
                if (c.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) hasCell = true;
                if (c.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) hasEth = true;
            }
        } else {
            android.net.NetworkInfo info = cm.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                int t = info.getType();
                if (t == ConnectivityManager.TYPE_VPN) hasVpn = true;
                else if (t == ConnectivityManager.TYPE_WIFI) hasWifi = true;
                else if (t == ConnectivityManager.TYPE_MOBILE) hasCell = true;
                else if (t == ConnectivityManager.TYPE_ETHERNET) hasEth = true;
            }
        }
        if (hasVpn) next = NetworkMode.VPN;
        else if (hasWifi) next = NetworkMode.WIFI;
        else if (hasCell) next = NetworkMode.LTE;
        else if (hasEth) next = NetworkMode.ETHERNET;

        applyDetected(next);
    }

    /** Store a freshly detected transport and notify only if the EFFECTIVE
     *  mode (override-aware) actually changed. */
    private synchronized void applyDetected(NetworkMode next) {
        NetworkMode before = effective();
        detected = next;
        NetworkMode now = effective();
        if (now != before) notifyAll_(now);
    }

    /** Effective mode: the manual override when set, else the detected one. */
    private NetworkMode effective() {
        return manual != null ? manual : detected;
    }

    private void notifyAll_(NetworkMode m) {
        for (Listener l : listeners) {
            try { l.onModeChanged(m); } catch (Exception ignored) {}
        }
    }
}
