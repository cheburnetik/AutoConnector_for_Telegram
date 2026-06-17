package io.autoconnector.engine.model;

/**
 * One row of a host's "attempt history" log — either a background check probe
 * or a Telegram-relay connect, with its per-attempt timings and byte counts so
 * the UI can render the last N attempts for a host.
 */
public class AttemptRow {
    /** Epoch ms of the attempt. */
    public long ts;
    /** 0 = background check probe, 1 = telegram relay connect. */
    public int kind;
    public boolean success;
    /** TCP socket connect time, -1 if unknown. */
    public int tcpMs = -1;
    /** TLS/handshake time, -1 if unknown. */
    public int tlsMs = -1;
    /** Total connect+handshake duration, -1 if unknown. */
    public int totalMs = -1;
    /** Bytes received during this attempt/session (0 if n/a). */
    public long bytesIn;
    /** Bytes sent during this attempt/session (0 if n/a). */
    public long bytesOut;
}
