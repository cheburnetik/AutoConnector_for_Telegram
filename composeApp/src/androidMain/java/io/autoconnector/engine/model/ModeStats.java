package io.autoconnector.engine.model;

/**
 * Snapshot of one (proxy, {@link io.autoconnector.engine.core.NetworkMode network})
 * row from {@code proxy_mode_stats}. Mirrors the schema; populated by
 * {@link io.autoconnector.engine.db.ProxyStore} reads.
 */
public final class ModeStats {
    public long proxyId;
    public String mode;
    public long lastCheck;
    public long lastOk;
    public boolean alive;
    public int rttMs = -1;
    public int successes;
    public int failures;
    public double score;
    public long tgConnections;
    public long totalSessionMs;
    public long bytesRelayed;
}
