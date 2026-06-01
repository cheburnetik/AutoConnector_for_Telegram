package io.autoconnector.engine.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/** Minimal SOCKS5 client: opens a tunnelled TCP connection through a proxy. */
public final class Socks5 {

    /**
     * Connects to {@code proxyHost:proxyPort} and asks it to reach
     * {@code destHost:destPort}. Returns the live, connected socket.
     */
    public static Socket connect(String proxyHost, int proxyPort,
                                 String destHost, int destPort,
                                 int timeoutMs) throws IOException {
        Socket s = new Socket();
        s.connect(new InetSocketAddress(proxyHost, proxyPort), timeoutMs);
        s.setSoTimeout(timeoutMs);
        try {
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();

            // greeting: VER=5, 1 method offered, 0x00 = no auth
            out.write(new byte[]{0x05, 0x01, 0x00});
            out.flush();
            byte[] hello = readN(in, 2);
            if (hello[0] != 0x05 || hello[1] != 0x00) {
                throw new IOException("SOCKS5: no-auth rejected");
            }

            // CONNECT request, destination given as a domain name
            byte[] host = destHost.getBytes("US-ASCII");
            byte[] req = new byte[4 + 1 + host.length + 2];
            req[0] = 0x05;             // version
            req[1] = 0x01;             // CONNECT
            req[2] = 0x00;             // reserved
            req[3] = 0x03;             // ATYP = domain
            req[4] = (byte) host.length;
            System.arraycopy(host, 0, req, 5, host.length);
            req[5 + host.length] = (byte) (destPort >> 8);
            req[6 + host.length] = (byte) destPort;
            out.write(req);
            out.flush();

            byte[] rep = readN(in, 4);
            if (rep[1] != 0x00) {
                throw new IOException("SOCKS5: CONNECT failed, code " + rep[1]);
            }
            int boundLen;
            switch (rep[3]) {
                case 0x01: boundLen = 4; break;                    // IPv4
                case 0x04: boundLen = 16; break;                   // IPv6
                case 0x03: boundLen = readN(in, 1)[0] & 0xff; break; // domain
                default: throw new IOException("SOCKS5: bad ATYP " + rep[3]);
            }
            readN(in, boundLen + 2); // bound address + port, discarded
            return s;
        } catch (IOException e) {
            try { s.close(); } catch (IOException ignored) {}
            throw e;
        }
    }

    private static byte[] readN(InputStream in, int n) throws IOException {
        byte[] b = new byte[n];
        int got = 0;
        while (got < n) {
            int r = in.read(b, got, n - got);
            if (r < 0) throw new IOException("SOCKS5: unexpected EOF");
            got += r;
        }
        return b;
    }

    private Socks5() {}
}
