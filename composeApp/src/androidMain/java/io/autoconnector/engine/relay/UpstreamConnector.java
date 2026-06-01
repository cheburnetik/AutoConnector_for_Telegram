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

    public static Channel connect(ProxyEntry p, int transportTag, int dcId,
                                  String destHost, int destPort, int timeoutMs,
                                  HandshakeMode userMode) throws Exception {
        HandshakeMode effective = (userMode == HandshakeMode.AUTO_RANDOM)
                ? HandshakeMode.randomTrick() : userMode;
        HandshakeStats.noteUsed(effective);
        HandshakeStats.recordAttempt(effective);

        Channel ch;
        if (p.type == io.autoconnector.engine.model.ProxyType.SOCKS5) {
            ch = connectSocks5(p, transportTag, dcId, destHost, destPort, timeoutMs);
        } else {
            ch = connectMtproto(p, transportTag, dcId, timeoutMs, effective);
        }
        ch.proxy = p;
        ch.handshakeMode = effective;
        HandshakeStats.recordHandshake(effective);
        return ch;
    }

    /** SOCKS5 upstream: tunnel to the exact DC endpoint, obfuscated2 (no secret). */
    private static Channel connectSocks5(ProxyEntry p, int tag, int dcId,
                                         String destHost, int destPort, int timeoutMs)
            throws Exception {
        String host = destHost;
        int port = destPort;
        if (host == null || host.isEmpty()) {
            host = DcAddresses.ip(dcId);
            port = DcAddresses.PORT;
        }
        Socket s = Socks5.connect(p.host, p.port, host, port, timeoutMs);
        try {
            Obfuscated2 obf = new Obfuscated2();
            obf.perform(s.getOutputStream(), null, tag, dcId);
            return new Channel(s, s.getInputStream(), s.getOutputStream(), obf);
        } catch (Exception e) {
            closeQuietly(s);
            throw e;
        }
    }

    /** MTProto upstream: obfuscated2 with the proxy secret, FakeTLS-wrapped if needed. */
    private static Channel connectMtproto(ProxyEntry p, int tag, int dcId,
                                          int timeoutMs, HandshakeMode mode)
            throws Exception {
        byte[] secret = HealthChecker.secretBytes(p.secret);
        Socket s = new Socket();
        try {
            s.connect(new InetSocketAddress(p.host, p.port), timeoutMs);
            s.setSoTimeout(timeoutMs);

            InputStream in;
            OutputStream out;
            if (p.isFakeTls()) {
                FakeTlsClient tls = FakeTlsClient.handshake(
                        s.getInputStream(), s.getOutputStream(),
                        secret, FakeTlsClient.domainFromSecret(p.secret), mode);
                in = tls.in;
                out = tls.out;
            } else {
                // No FakeTLS layer to vary; still honor TCP-side tricks.
                applyTcpTricks(s, mode);
                in = s.getInputStream();
                out = s.getOutputStream();
            }

            Obfuscated2 obf = new Obfuscated2();
            obf.perform(out, secret, tag, dcId);
            return new Channel(s, in, out, obf);
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
