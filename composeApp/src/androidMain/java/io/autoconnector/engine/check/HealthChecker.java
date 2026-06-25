package io.autoconnector.engine.check;

import io.autoconnector.engine.model.ProxyEntry;
import io.autoconnector.engine.model.ProxyType;
import io.autoconnector.engine.net.DcAddresses;
import io.autoconnector.engine.net.FakeTlsClient;
import io.autoconnector.engine.net.IntermediateTransport;
import io.autoconnector.engine.net.MtCrypto;
import io.autoconnector.engine.net.MtHandshakeProbe;
import io.autoconnector.engine.net.Obfuscated2;
import io.autoconnector.engine.net.Socks5;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Runs a real liveness probe against a single proxy.
 *
 * <p>For every proxy type it performs the obfuscated2 handshake and an actual
 * {@code req_pq_multi → resPQ} round-trip — a passing probe proves the proxy
 * relays to a live Telegram DC:
 * <ul>
 *   <li>plain / {@code dd} MTProto — obfuscated2 straight over TCP;</li>
 *   <li>{@code ee} FakeTLS — obfuscated2 inside the FakeTLS record channel;</li>
 *   <li>SOCKS5 — tunnel to a DC, then obfuscated2 without a secret.</li>
 * </ul>
 * If a FakeTLS proxy refuses the full handshake it falls back to the
 * socket-level "stealth" heuristic (TLS ClientHello probe + persistence).
 */
public final class HealthChecker {

    public enum Grade { FULL, STEALTH, DEAD }

    /** TCP-connect RTT (ms) of the LAST socket opened on THIS probe thread, set by
     *  {@link #openSocket}/{@link #checkSocks5}; -1 until a connect succeeds. This
     *  is the real, always-available network ping for any reachable host (FULL
     *  and STEALTH alike) — unlike the full handshake elapsed (which for STEALTH
     *  is merely the 2.5 s read timeout). Reset at the top of {@link #check}. */
    private static final ThreadLocal<Integer> LAST_CONNECT_MS =
            ThreadLocal.withInitial(() -> -1);

    /** Outcome of a single probe. */
    public static final class Result {
        public final Grade grade;
        public final int rttMs;
        public final String detail;
        /** TCP-connect RTT (ms) of this probe, or -1 if the connect failed. */
        public final int connectMs;

        Result(Grade grade, int rttMs, String detail) {
            this.grade = grade;
            this.rttMs = rttMs;
            this.detail = detail;
            Integer c = LAST_CONNECT_MS.get();
            this.connectMs = (c == null) ? -1 : c;
        }

        public boolean ok() {
            return grade != Grade.DEAD;
        }
    }

    /** SO read timeout (ms) — kept generous so a slow-but-live proxy still
     *  completes the handshake and isn't false-flagged dead. */
    private final int timeoutMs;
    /** TCP-connect timeout (ms) — typically SHORTER than {@link #timeoutMs}: a
     *  live proxy answers the TCP handshake in well under a second, so capping
     *  the connect wait roughly halves the radio time wasted on unreachable
     *  hosts without risking false negatives on the (separate, longer) read
     *  phase. */
    private final int connectTimeoutMs;

    /** Anti-DPI handshake policy used for FakeTLS probes — kept in sync with
     *  the relay so background checks mirror what a real Telegram connect does. */
    private volatile io.autoconnector.engine.net.HandshakeMode probeMode =
            io.autoconnector.engine.net.HandshakeMode.NORMAL;

    /** Back-compat: one timeout used for both connect and read. */
    public HealthChecker(int timeoutMs) {
        this(timeoutMs, timeoutMs);
    }

    public HealthChecker(int connectTimeoutMs, int readTimeoutMs) {
        this.connectTimeoutMs = connectTimeoutMs;
        this.timeoutMs = readTimeoutMs;
    }

    public void setProbeMode(io.autoconnector.engine.net.HandshakeMode m) {
        if (m != null) this.probeMode = m;
    }

    public Result check(ProxyEntry p) {
        // Clear any connect-time left over from a previous probe on this pooled
        // thread, so a host whose connect fails reports connectMs = -1 (no ping)
        // instead of the previous host's time.
        LAST_CONNECT_MS.set(-1);
        try {
            if (p.type == ProxyType.SOCKS5) return checkSocks5(p);
            if (p.isFakeTls()) return checkFakeTls(p);
            return checkMtproto(p);
        } catch (Exception e) {
            return new Result(Grade.DEAD, -1, message(e));
        }
    }

    /** plain / dd MTProto proxy: obfuscated2 → req_pq_multi → resPQ. */
    private Result checkMtproto(ProxyEntry p) throws Exception {
        byte[] secret = secretBytes(p.secret);
        long t0 = System.nanoTime();
        Socket s = openSocket(p.host, p.port);
        try {
            OutputStream out = s.getOutputStream();
            InputStream in = s.getInputStream();

            Obfuscated2 obf = new Obfuscated2();
            obf.perform(out, secret, DcAddresses.DEFAULT_DC);
            MtHandshakeProbe.probe(new IntermediateTransport(in, out, obf));

            return new Result(Grade.FULL, elapsedMs(t0), "resPQ OK — DC доступен");
        } finally {
            closeQuietly(s);
        }
    }

    /**
     * FakeTLS ({@code ee}) proxy: full FakeTLS handshake, obfuscated2 inside the
     * record channel, then resPQ. Falls back to the stealth heuristic on error.
     */
    private Result checkFakeTls(ProxyEntry p) {
        byte[] secret = secretBytes(p.secret);
        String domain = FakeTlsClient.domainFromSecret(p.secret);
        long t0 = System.nanoTime();
        Socket s = null;
        // Same DPI-trick selection the relay uses: AUTO_RANDOM rolls a fresh
        // working trick per probe, otherwise the fixed user mode.
        io.autoconnector.engine.net.HandshakeMode effective =
                (probeMode == io.autoconnector.engine.net.HandshakeMode.AUTO_RANDOM)
                        ? io.autoconnector.engine.net.HandshakeMode.randomTrick()
                        : probeMode;
        io.autoconnector.engine.net.HandshakeStats.noteUsed(effective);
        io.autoconnector.engine.net.HandshakeStats.recordAttempt(effective);
        try {
            s = openSocket(p.host, p.port);
            FakeTlsClient tls = FakeTlsClient.handshake(
                    s.getInputStream(), s.getOutputStream(), secret, domain, effective);

            Obfuscated2 obf = new Obfuscated2();
            obf.perform(tls.out, secret, DcAddresses.DEFAULT_DC);
            MtHandshakeProbe.probe(new IntermediateTransport(tls.in, tls.out, obf));

            io.autoconnector.engine.net.HandshakeStats.recordHandshake(effective);
            return new Result(Grade.FULL, elapsedMs(t0), "FakeTLS resPQ OK · DPI=" + effective.label);
        } catch (Exception e) {
            return checkFakeTlsStealth(p, "FakeTLS handshake: " + message(e));
        } finally {
            closeQuietly(s);
        }
    }

    /** SOCKS5: tunnel to a Telegram DC, then the same handshake (no secret). */
    private Result checkSocks5(ProxyEntry p) throws Exception {
        long t0 = System.nanoTime();
        Socket s = Socks5.connect(p.host, p.port,
                DcAddresses.ip(DcAddresses.DEFAULT_DC), DcAddresses.PORT, timeoutMs);
        LAST_CONNECT_MS.set((int) ((System.nanoTime() - t0) / 1_000_000L));
        try {
            OutputStream out = s.getOutputStream();
            InputStream in = s.getInputStream();

            Obfuscated2 obf = new Obfuscated2();
            obf.perform(out, null, DcAddresses.DEFAULT_DC);
            MtHandshakeProbe.probe(new IntermediateTransport(in, out, obf));

            return new Result(Grade.FULL, elapsedMs(t0), "SOCKS5 → DC resPQ OK");
        } finally {
            closeQuietly(s);
        }
    }

    /**
     * Interim FakeTLS heuristic: send a TLS-ClientHello-shaped frame seeded
     * with the secret and see whether the server answers with a record — or at
     * least keeps the connection open instead of resetting it.
     */
    private Result checkFakeTlsStealth(ProxyEntry p, String reason) {
        long t0 = System.nanoTime();
        Socket s = null;
        try {
            s = openSocket(p.host, p.port);
            OutputStream out = s.getOutputStream();
            InputStream in = s.getInputStream();

            byte[] head = MtCrypto.hexToBytes("16030100c8010000c40303");
            byte[] hello = new byte[head.length + 182];
            System.arraycopy(head, 0, hello, 0, head.length);
            if (p.secret.length() >= 34) {
                byte[] rnd = MtCrypto.hexToBytes(p.secret.substring(2, 34));
                System.arraycopy(rnd, 0, hello, head.length, rnd.length);
            }
            out.write(hello);
            out.flush();

            s.setSoTimeout(2500);
            try {
                int b = in.read();
                if (b < 0) {
                    return new Result(Grade.DEAD, -1, "FakeTLS: соединение сброшено");
                }
                String how = (b == 0x16 || b == 0x17)
                        ? "ServerHello принят"
                        : "ответ 0x" + Integer.toHexString(b);
                return new Result(Grade.STEALTH, elapsedMs(t0), "FakeTLS stealth: " + how);
            } catch (SocketTimeoutException te) {
                return new Result(Grade.STEALTH, elapsedMs(t0),
                        "FakeTLS stealth: persistence (нет сброса)");
            }
        } catch (Exception e) {
            return new Result(Grade.DEAD, -1, reason);
        } finally {
            closeQuietly(s);
        }
    }

    private Socket openSocket(String host, int port) throws java.io.IOException {
        Socket s = new Socket();
        long t0 = System.nanoTime();
        // Short connect timeout (unreachable hosts give up sooner); generous read
        // timeout for the handshake that follows.
        s.connect(new InetSocketAddress(host, port), connectTimeoutMs);
        LAST_CONNECT_MS.set((int) ((System.nanoTime() - t0) / 1_000_000L));
        s.setSoTimeout(timeoutMs);
        return s;
    }

    /** Extracts the 16-byte obfuscation secret from any MTProto secret form. */
    public static byte[] secretBytes(String secret) {
        String s = secret.toLowerCase();
        if (s.startsWith("ee") || s.startsWith("dd")) {
            s = s.substring(2);
        }
        if (s.length() > 32) {
            s = s.substring(0, 32);
        }
        return MtCrypto.hexToBytes(s);
    }

    private static int elapsedMs(long startNanos) {
        return (int) ((System.nanoTime() - startNanos) / 1_000_000L);
    }

    private static void closeQuietly(Socket s) {
        try {
            if (s != null) s.close();
        } catch (Exception ignored) {
        }
    }

    private static String message(Throwable e) {
        String m = e.getMessage();
        return m != null ? m : e.getClass().getSimpleName();
    }
}
