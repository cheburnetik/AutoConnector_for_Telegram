package io.autoconnector.engine.net;

/** Well-known Telegram data-centre endpoints (production, IPv4). */
public final class DcAddresses {

    private static final String[] IPS = {
            null,
            "149.154.175.53",   // DC1
            "149.154.167.51",   // DC2
            "149.154.175.100",  // DC3
            "149.154.167.91",   // DC4
            "91.108.56.130",    // DC5
    };

    public static final int DEFAULT_DC = 2;
    public static final int PORT = 443;

    public static String ip(int dcId) {
        if (dcId < 1 || dcId >= IPS.length) dcId = DEFAULT_DC;
        return IPS[dcId];
    }

    /** Reverse lookup: DC id for a known DC IP, or {@link #DEFAULT_DC}. */
    public static int dcIdForIp(String ip) {
        for (int i = 1; i < IPS.length; i++) {
            if (IPS[i].equals(ip)) return i;
        }
        return DEFAULT_DC;
    }

    private DcAddresses() {}
}
