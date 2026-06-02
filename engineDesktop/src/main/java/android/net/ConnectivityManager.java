package android.net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * Desktop shim for {@code android.net.ConnectivityManager}.
 *
 * <p>Unlike a phone, a desktop OS owns connectivity transitions — but the
 * engine's "skip proxies while a VPN is on" feature still needs to know when a
 * VPN tunnel is up. So this shim does a best-effort scan of the machine's
 * network interfaces and reports {@code TRANSPORT_VPN} when a live VPN-style
 * adapter is present (WireGuard / OpenVPN / TUN-TAP / Tailscale / utun / etc.),
 * otherwise plain Wi-Fi. A small daemon poller re-checks every few seconds and
 * replays a capability change into {@code NetworkMonitor} so toggling the VPN
 * updates the mode live instead of latching the startup state forever.
 */
public final class ConnectivityManager {

    public static final int TYPE_MOBILE = 0;
    public static final int TYPE_WIFI = 1;
    public static final int TYPE_VPN = 17;

    /** The single fake network reported on this machine. */
    private static final Network THE_NETWORK = new Network();

    /** Latest VPN-present reading, refreshed by the poller and on every read. */
    private static volatile boolean vpnActive = detectVpn();

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
        vpnActive = detectVpn();
        return new NetworkCapabilities(
                vpnActive ? NetworkCapabilities.TRANSPORT_VPN
                          : NetworkCapabilities.TRANSPORT_WIFI);
    }

    public NetworkInfo getActiveNetworkInfo() {
        return new NetworkInfo();
    }

    /**
     * Spins up (once) a daemon poller that watches for VPN up/down and replays
     * a capability change so {@code NetworkMonitor} recomputes its mode.
     */
    public void registerNetworkCallback(NetworkRequest request, NetworkCallback callback) {
        VpnPoller.ensureStarted(callback);
    }

    public void unregisterNetworkCallback(NetworkCallback callback) {
    }

    /** Heuristic: any up, non-loopback interface with a bound address whose
     *  name/description looks like a VPN tunnel. */
    static boolean detectVpn() {
        try {
            Enumeration<NetworkInterface> ifs = NetworkInterface.getNetworkInterfaces();
            if (ifs == null) return false;
            while (ifs.hasMoreElements()) {
                NetworkInterface ni = ifs.nextElement();
                try {
                    if (!ni.isUp() || ni.isLoopback()) continue;
                } catch (Exception e) {
                    continue;
                }
                if (!looksLikeVpn(ni.getName()) && !looksLikeVpn(ni.getDisplayName())) continue;
                // Require a real bound address so a disabled adapter doesn't count.
                Enumeration<InetAddress> addrs = ni.getInetAddresses();
                while (addrs.hasMoreElements()) {
                    InetAddress a = addrs.nextElement();
                    if (!a.isLoopbackAddress() && !a.isLinkLocalAddress()) return true;
                }
            }
        } catch (Throwable ignored) {
        }
        return false;
    }

    private static boolean looksLikeVpn(String s) {
        if (s == null) return false;
        String n = s.toLowerCase();
        // Windows descriptions: "WireGuard Tunnel", "TAP-Windows Adapter",
        // "OpenVPN ...", "Wintun Userspace Tunnel". *nix/macOS names:
        // tun0 / tap0 / wg0 / utun3 / nordlynx / ppp0 / tailscale0.
        return n.contains("vpn")
                || n.contains("wireguard") || n.contains("wintun") || n.startsWith("wg")
                || n.startsWith("tun") || n.startsWith("tap") || n.contains("tap-windows")
                || n.startsWith("utun") || n.startsWith("ppp")
                || n.contains("openvpn") || n.contains("tailscale") || n.contains("nordlynx")
                || n.contains("proton");
    }

    /** Single background watcher shared across the process. */
    private static final class VpnPoller {
        private static volatile boolean started;

        static synchronized void ensureStarted(NetworkCallback cb) {
            if (started || cb == null) return;
            started = true;
            Thread t = new Thread(() -> {
                boolean prev = vpnActive;
                while (true) {
                    try { Thread.sleep(5000); } catch (InterruptedException e) { return; }
                    boolean now = detectVpn();
                    vpnActive = now;
                    if (now != prev) {
                        prev = now;
                        try {
                            cb.onCapabilitiesChanged(THE_NETWORK,
                                    new NetworkCapabilities(now
                                            ? NetworkCapabilities.TRANSPORT_VPN
                                            : NetworkCapabilities.TRANSPORT_WIFI));
                        } catch (Throwable ignored) {}
                    }
                }
            }, "desktop-vpn-poller");
            t.setDaemon(true);
            t.start();
        }
    }
}
