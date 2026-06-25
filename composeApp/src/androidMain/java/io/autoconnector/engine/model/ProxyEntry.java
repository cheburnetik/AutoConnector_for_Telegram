package io.autoconnector.engine.model;

/**
 * A single proxy plus its accumulated health stats.
 *
 * <p>For {@link ProxyType#MTPROTO} the {@link #secret} carries the protocol
 * variant in its prefix: {@code ee...} = FakeTLS, {@code dd...} = padded
 * intermediate, otherwise plain obfuscated2. For {@link ProxyType#SOCKS5}
 * the secret is {@code null}.
 */
public class ProxyEntry {

    public long id;
    public ProxyType type;
    public String host;
    public int port;
    public String secret;      // null for SOCKS5
    public String source;      // page URL it was discovered on
    public long addedAt;

    // --- health / rating ---
    public long lastCheck;     // epoch ms of last probe, 0 = never
    public boolean alive;
    public int rttMs = -1;     // last measured round-trip, -1 = unknown
    public int successes;
    public int failures;
    public double score;       // rating, higher is better
    public String lastError;
    public long lastOk;        // epoch ms of last successful probe

    // --- relay usage ---
    public long tgConnections; // successful Telegram sessions relayed via this proxy
    public long totalSessionMs;// summed duration of those sessions
    public long bytesRelayed;  // total bytes carried through this proxy
    public long lastTgConnectAt; // epoch ms of the last successful Telegram session

    public ProxyEntry() {}

    public ProxyEntry(ProxyType type, String host, int port, String secret, String source) {
        this.type = type;
        this.host = host;
        this.port = port;
        this.secret = secret;
        this.source = source;
        this.addedAt = System.currentTimeMillis();
    }

    /** True for an {@code ee}-prefixed FakeTLS MTProto secret. */
    public boolean isFakeTls() {
        return secret != null && secret.length() >= 2
                && secret.regionMatches(true, 0, "ee", 0, 2);
    }

    /** True for a {@code dd}-prefixed padded-intermediate MTProto secret. */
    public boolean isDdSecret() {
        return secret != null && secret.length() >= 2
                && secret.regionMatches(true, 0, "dd", 0, 2);
    }

    /**
     * Stable identity used for de-duplication. Two entries that describe the
     * same proxy — even if discovered in different textual formats — collapse
     * onto the same key.
     */
    public String dedupKey() {
        String s = secret == null ? "" : secret.toLowerCase();
        return type.name() + "|" + host.toLowerCase() + ":" + port + "|" + s;
    }

    /** Link form suitable for pasting into Telegram's proxy settings. */
    public String tgLink() {
        if (type == ProxyType.MTPROTO) {
            return "tg://proxy?server=" + host + "&port=" + port + "&secret=" + secret;
        }
        return "tg://socks?server=" + host + "&port=" + port;
    }

    @Override
    public String toString() {
        return type + " " + host + ":" + port + (secret != null ? " " + secret : "");
    }
}
