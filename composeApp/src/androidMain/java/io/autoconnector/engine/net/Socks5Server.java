package io.autoconnector.engine.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Server side of SOCKS5: handles the greeting + CONNECT request that Telegram
 * sends when configured to use the relay as a SOCKS5 proxy, and reports the
 * destination Telegram asked to reach (a DC endpoint).
 */
public final class Socks5Server {

    /** Destination of a SOCKS5 CONNECT request. */
    public static final class Target {
        public final String host;
        public final int port;

        Target(String host, int port) {
            this.host = host;
            this.port = port;
        }
    }

    /**
     * Completes the SOCKS5 handshake (no authentication) and answers success.
     * After this returns, the stream carries the tunnelled connection.
     */
    public static Target handshake(InputStream in, OutputStream out) throws IOException {
        // greeting: VER, NMETHODS, METHODS[]
        if (readByte(in) != 0x05) throw new IOException("SOCKS5: bad version");
        int nMethods = readByte(in);
        readFully(in, nMethods);
        out.write(new byte[]{0x05, 0x00}); // choose "no authentication"
        out.flush();

        // request: VER, CMD, RSV, ATYP, addr, port
        byte[] head = readFully(in, 4);
        if (head[0] != 0x05) throw new IOException("SOCKS5: bad request version");
        if (head[1] != 0x01) throw new IOException("SOCKS5: only CONNECT supported");

        String host;
        switch (head[3] & 0xff) {
            case 0x01: { // IPv4
                byte[] a = readFully(in, 4);
                host = (a[0] & 0xff) + "." + (a[1] & 0xff) + "."
                        + (a[2] & 0xff) + "." + (a[3] & 0xff);
                break;
            }
            case 0x03: { // domain name
                int len = readByte(in);
                host = new String(readFully(in, len), "US-ASCII");
                break;
            }
            case 0x04: { // IPv6
                host = ipv6(readFully(in, 16));
                break;
            }
            default:
                throw new IOException("SOCKS5: bad ATYP");
        }
        byte[] p = readFully(in, 2);
        int port = ((p[0] & 0xff) << 8) | (p[1] & 0xff);

        // success reply, bound address 0.0.0.0:0
        out.write(new byte[]{0x05, 0x00, 0x00, 0x01, 0, 0, 0, 0, 0, 0});
        out.flush();
        return new Target(host, port);
    }

    private static String ipv6(byte[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i += 2) {
            if (i > 0) sb.append(':');
            sb.append(Integer.toHexString(((a[i] & 0xff) << 8) | (a[i + 1] & 0xff)));
        }
        return sb.toString();
    }

    private static int readByte(InputStream in) throws IOException {
        int b = in.read();
        if (b < 0) throw new IOException("SOCKS5: unexpected EOF");
        return b;
    }

    private static byte[] readFully(InputStream in, int n) throws IOException {
        byte[] buf = new byte[n];
        int got = 0;
        while (got < n) {
            int r = in.read(buf, got, n - got);
            if (r < 0) throw new IOException("SOCKS5: unexpected EOF");
            got += r;
        }
        return buf;
    }

    private Socks5Server() {}
}
