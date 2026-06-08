package io.autoconnector.engine.relay;

import io.autoconnector.engine.check.HealthChecker;
import io.autoconnector.engine.model.ProxyEntry;
import io.autoconnector.engine.net.DcAddresses;
import io.autoconnector.engine.net.FakeTlsClient;
import io.autoconnector.engine.net.HandshakeMode;
import io.autoconnector.engine.net.HandshakeStats;
import io.autoconnector.engine.net.Obfuscated2;
import io.autoconnector.engine.net.Socks5;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Opens an obfuscated channel to an upstream proxy, ready for the relay to
 * pump transport bytes through. The transport tag and DC id are echoed from
 * the Telegram-side handshake so the inner stream passes through verbatim.
 */
public final class UpstreamConnector {

    /** A live upstream channel: socket, stream pair and the obfuscated2 ciphers. */
    public static final class Channel {
        public final Socket socket;
        public final InputStream in;
        public final OutputStream out;
        public final Obfuscated2 obf;
        public ProxyEntry proxy;
        /** Which handshake-mode actually got applied (after AUTO_RANDOM resolves). */
        public HandshakeMode handshakeMode = HandshakeMode.NORMAL;
        /** TCP-connect RTT (ms) to the upstream — a real ping for the relay tab. */
        public int connectMs = -1;

        Channel(Socket socket, InputStream in, OutputStream out, Obfuscated2 obf) {
            this.socket = socket;
            this.in = in;
            this.out = out;
            this.obf = obf;
        }
    }

    /**
     * Connects to {@code p} and completes the obfuscated2 handshake.
     *
     * @param transportTag transport tag echoed from the Telegram handshake
     * @param dcId         DC id requested by Telegram
     * @param destHost     exact DC endpoint Telegram asked for (used by SOCKS5)
     * @param destPort     exact DC port Telegram asked for
     */
    /** Backwards-compatible overload — defaults to {@link HandshakeMode#NORMAL}. */
    public static Channel connect(ProxyEntry p, int transportTag, int dcId,
                                  String destHost, int destPort, int timeoutMs)
            throws Exception {
        return connect(p, transportTag, dcId, destHost, destPort, timeoutMs,
                HandshakeMode.NORMAL);
    }

    /** Reference overload (no experimental wire-shaping). */
    public static Channel connect(ProxyEntry p, int transportTag, int dcId,
                                  String destHost, int destPort, int timeoutMs,
                                  HandshakeMode userMode) throws Exception {
        return connect(p, transportTag, dcId, destHost, destPort, timeoutMs,
                userMode, WireShaper.Mode.OFF);
    }

    /**
     * @param exp experimental upstream engine. {@link WireShaper.Mode#OFF}
     *            keeps the reference path bit-identical.
     */
    public static Channel connect(ProxyEntry p, int transportTag, int dcId,
                                  String destHost, int destPort, int timeoutMs,
                                  HandshakeMode userMode, WireShaper.Mode exp) throws Exception {
        HandshakeMode effective = (userMode == HandshakeMode.AUTO_RANDOM)
                ? HandshakeMode.randomTrick() : userMode;
        HandshakeStats.noteUsed(effective);
        HandshakeStats.recordAttempt(effective);

        Channel ch;
        if (p.type == io.autoconnector.engine.model.ProxyType.SOCKS5) {
            ch = connectSocks5(p, transportTag, dcId, destHost, destPort, timeoutMs, exp);
        } else {
            ch = connectMtproto(p, transportTag, dcId, timeoutMs, effective, exp);
        }
        ch.proxy = p;
        ch.handshakeMode = effective;
        HandshakeStats.recordHandshake(effective);
        return ch;
    }

    /** SOCKS5 upstream: tunnel to the exact DC endpoint, obfuscated2 (no secret). */
    private static Channel connectSocks5(ProxyEntry p, int tag, int dcId,
                                         String destHost, int destPort, int timeoutMs,
                                         WireShaper.Mode exp)
            throws Exception {
        String host = destHost;
        int port = destPort;
        if (host == null || host.isEmpty()) {
            host = DcAddresses.ip(dcId);
            port = DcAddresses.PORT;
        }
        long connT0 = System.nanoTime();
        Socket s = Socks5.connect(p.host, p.port, host, port, timeoutMs);
        int connMs = (int) ((System.nanoTime() - connT0) / 1_000_000L);
        try {
            WireShaper.applySocketOptions(s, exp);
            // No FakeTLS layer here, so the experimental shaping applies to the
            // bare obfuscated2 stream (raw segments). OFF → s.getOutputStream().
            OutputStream out = WireShaper.wrapApp(
                    WireShaper.wrapRaw(s.getOutputStream(), exp), exp, false);
            Obfuscated2 obf = new Obfuscated2();
            obf.perform(out, null, tag, dcId);
            Channel c = new Channel(s, s.getInputStream(), out, obf);
            c.connectMs = connMs;
            return c;
        } catch (Exception e) {
            closeQuietly(s);
            throw e;
        }
    }

    /** MTProto upstream: obfuscated2 with the proxy secret, FakeTLS-wrapped if needed. */
    private static Channel connectMtproto(ProxyEntry p, int tag, int dcId,
                                          int timeoutMs, HandshakeMode mode,
                                          WireShaper.Mode exp)
            throws Exception {
        byte[] secret = HealthChecker.secretBytes(p.secret);
        Socket s = new Socket();
        try {
            long connT0 = System.nanoTime();
            s.connect(new InetSocketAddress(p.host, p.port), timeoutMs);
            int connMs = (int) ((System.nanoTime() - connT0) / 1_000_000L);
            s.setSoTimeout(timeoutMs);
            WireShaper.applySocketOptions(s, exp);

            // "Innermost" wrap: for OFF / TLS_RECHUNK this returns the raw
            // output unchanged; for the segment-level modes it fragments the
            // whole TCP stream including the FakeTLS handshake.
            OutputStream rawOut = WireShaper.wrapRaw(s.getOutputStream(), exp);

            boolean fakeTls = p.isFakeTls();
            InputStream in;
            OutputStream out;
            if (fakeTls) {
                FakeTlsClient tls = FakeTlsClient.handshake(
                        s.getInputStream(), rawOut,
                        secret, FakeTlsClient.domainFromSecret(p.secret), mode);
                in = tls.in;
                // TLS_RECHUNK splits app-data into many small records; other
                // modes leave the record stream as-is (OFF → tls.out verbatim).
                out = WireShaper.wrapApp(tls.out, exp, true);
            } else {
                // No FakeTLS layer to vary; still honor TCP-side tricks.
                applyTcpTricks(s, mode);
                in = s.getInputStream();
                out = WireShaper.wrapApp(rawOut, exp, false);
            }

            Obfuscated2 obf = new Obfuscated2();
            obf.perform(out, secret, tag, dcId);
            Channel c = new Channel(s, in, out, obf);
            c.connectMs = connMs;
            return c;
        } catch (Exception e) {
            closeQuietly(s);
            throw e;
        }
    }

    /** Apply non-TLS-specific tricks to a plain socket (delays, etc.). */
    private static void applyTcpTricks(Socket s, HandshakeMode mode) {
        if (mode == HandshakeMode.TCP_DELAY) {
            try {
                Thread.sleep(200 + (int) (Math.random() * 300));
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        // Segmented mode for plain/dd is implemented by Obfuscated2 internally
        // simply by chunking writes — for now we leave it as a TLS-only trick.
    }

    private static void closeQuietly(Socket s) {
        try {
            if (s != null) s.close();
        } catch (Exception ignored) {
        }
    }

    private UpstreamConnector() {}
}
