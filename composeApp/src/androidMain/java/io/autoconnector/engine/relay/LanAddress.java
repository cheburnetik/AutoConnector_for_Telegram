package io.autoconnector.engine.relay;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * Resolves the device's LAN-facing IPv4 — the address neighbours on the same
 * Wi-Fi/LAN use to reach the relay's web portal / SOCKS proxy. Pure JDK net API
 * so it works on both Android and desktop.
 */
public final class LanAddress {

    private LanAddress() {}

    /** Best site-local IPv4 (192.168.* / 10.* / 172.16-31.*) of an up, non-loopback
     *  interface, or {@code null} if the device has no LAN address. Obvious virtual
     *  / tunnel adapters are skipped so we return the real Wi-Fi/Ethernet address. */
    public static String bestLanIPv4() {
        String fallback = null;
        try {
            Enumeration<NetworkInterface> ifs = NetworkInterface.getNetworkInterfaces();
            if (ifs == null) return null;
            while (ifs.hasMoreElements()) {
                NetworkInterface ni = ifs.nextElement();
                try {
                    if (!ni.isUp() || ni.isLoopback() || ni.isVirtual()) continue;
                    String name = ni.getName() == null ? "" : ni.getName().toLowerCase();
                    if (name.contains("vmnet") || name.contains("vbox") || name.startsWith("tun")
                            || name.startsWith("tap") || name.contains("docker") || name.contains("ham")) {
                        continue;
                    }
                    Enumeration<InetAddress> addrs = ni.getInetAddresses();
                    while (addrs.hasMoreElements()) {
                        InetAddress a = addrs.nextElement();
                        if (!(a instanceof Inet4Address) || a.isLoopbackAddress() || a.isLinkLocalAddress()) {
                            continue;
                        }
                        String ip = a.getHostAddress();
                        if (a.isSiteLocalAddress()) return ip;   // typical LAN — prefer
                        if (fallback == null) fallback = ip;      // public/other — last resort
                    }
                } catch (Exception ignored) {}
            }
        } catch (Exception ignored) {}
        return fallback;
    }
}
