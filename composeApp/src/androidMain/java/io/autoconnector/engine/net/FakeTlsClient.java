package io.autoconnector.engine.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;

/**
 * FakeTLS client for {@code ee}-prefixed MTProto proxies (mtg v2 style).
 *
 * <p>Variations of the ClientHello (cipher list, extensions, SNI, padding,
 * GREASE, ALPN, record-header version, record fragmentation, CCS prelude…)
 * are selected via {@link HandshakeMode} so the user can A/B test different
 * anti-DPI fingerprints from Settings.
 */
public final class FakeTlsClient {

    private static final SecureRandom RND = new SecureRandom();
    private static final int DEFAULT_RECORD_LEN = 517;
    private static final int BIG_RECORD_LEN = 1024;
    private static final int MAX_TLS_RECORD = 1 << 14;

    // --- cipher templates -------------------------------------------------

    private static final byte[] DEFAULT_CIPHERS = MtCrypto.hexToBytes(
            "130113021303c02bc02fc02cc030cca9cca8c013c014009c009d002f0035");

    private static final byte[] CHROME_CIPHERS = MtCrypto.hexToBytes(
            "0a0a"
            + "130113021303"
            + "c02bc02fc02cc030cca9cca8"
            + "c013c014"
            + "009c009d002f0035");

    private static final byte[] FIREFOX_CIPHERS = MtCrypto.hexToBytes(
            "130113031302"
            + "c02bc02fcca9cca8c02cc030"
            + "c013c014"
            + "009c009d002f0035");

    private static final byte[] SAFARI_CIPHERS = MtCrypto.hexToBytes(
            "130213031301"
            + "c02cc02bcca9c030c02fcca8"
            + "c00ac009c014c013"
            + "009d009c003d003c0035002f");

    private static final byte[] EDGE_CIPHERS = MtCrypto.hexToBytes(
            "1a1a"
            + "130113021303"
            + "c02bc02fc02cc030cca9cca8"
            + "c013c014"
            + "009c009d002f0035");

    private static final byte[] OKHTTP_CIPHERS = MtCrypto.hexToBytes(
            "c02bc02fc02cc030cca9cca8"
            + "c009c013c00ac014"
            + "009c009d002f0035");

    private static final String[] SNI_POOL = {
            "cdn.jsdelivr.net", "www.google.com", "www.cloudflare.com",
            "github.com", "www.microsoft.com", "www.youtube.com",
            "stackoverflow.com", "www.wikipedia.org"
    };

    public final InputStream in;
    public final OutputStream out;

    private FakeTlsClient(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    public static FakeTlsClient handshake(InputStream rawIn, OutputStream rawOut,
                                          byte[] secret16, String domain) throws IOException {
        return handshake(rawIn, rawOut, secret16, domain, HandshakeMode.NORMAL);
    }

    public static FakeTlsClient handshake(InputStream rawIn, OutputStream rawOut,
                                          byte[] secret16, String domain,
                                          HandshakeMode mode) throws IOException {
        // Disabled / N/A modes (proven incompatible with mtg-FakeTLS by
        // bin/test_modes.py) execute as NORMAL on the wire so they don't
        // sabotage the upstream — see HandshakeMode.isWorking().
        if (!mode.isWorking()) {
            mode = HandshakeMode.NORMAL;
        }
        byte[] hello = buildClientHello(secret16, domain, mode);

        if (mode == HandshakeMode.TCP_DELAY) {
            sleepQuiet(200 + RND.nextInt(300));
        }

        // CCS-prelude: send a ChangeCipherSpec record before ClientHello.
        if (mode == HandshakeMode.CCS_PRELUDE || mode == HandshakeMode.COMBO_MAX) {
            rawOut.write(new byte[]{0x14, 0x03, 0x03, 0x00, 0x01, 0x01});
            rawOut.flush();
            sleepQuiet(5);
        }

        if (mode == HandshakeMode.RECORD_FRAGMENT || mode == HandshakeMode.COMBO_MAX) {
            writeAsTwoRecords(rawOut, hello, mode);
        } else if (mode == HandshakeMode.SEGMENTED || mode == HandshakeMode.COMBO) {
            writeSegmented(rawOut, hello);
        } else if (mode == HandshakeMode.SPLIT_BEFORE_SNI) {
            writeSplitBeforeSni(rawOut, hello);
        } else {
            rawOut.write(hello);
            rawOut.flush();
        }

        // Consume server flight: ServerHello / CCS / ApplicationData.
        for (int guard = 0; guard < 16; guard++) {
            int type = readRecord(rawIn);
            if (type == 0x17) break;
            if (type == 0x15) throw new IOException("FakeTLS: server sent alert");
            if (guard == 15) throw new IOException("FakeTLS: server flight not understood");
        }
        rawOut.write(new byte[]{0x14, 0x03, 0x03, 0x00, 0x01, 0x01});
        rawOut.flush();
        return new FakeTlsClient(new RecordInput(rawIn), new RecordOutput(rawOut));
    }

    /**
     * Splits the TCP write exactly at the start of the SNI extension. DPI that
     * matches "ClientHello + server_name" in one segment misses, and the
     * reassembly cost is high enough that some boxes skip deep analysis.
     */
    private static void writeSplitBeforeSni(OutputStream out, byte[] hello) throws IOException {
        int sniOff = findSniOffset(hello);
        if (sniOff <= 0 || sniOff >= hello.length - 8) {
            out.write(hello);
            out.flush();
            return;
        }
        out.write(hello, 0, sniOff);
        out.flush();
        sleepQuiet(8 + RND.nextInt(15));
        out.write(hello, sniOff, hello.length - sniOff);
        out.flush();
    }

    /**
     * Locates the 4-byte extension header {@code 00 00 <len-hi> <len-lo>}
     * (server_name) inside the ClientHello body. Returns the absolute offset
     * within the record, or -1 if not present.
     */
    private static int findSniOffset(byte[] hello) {
        // Skip 5B record header + 4B handshake header + 2B version + 32B random
        int p = 5 + 4 + 2 + 32;
        if (hello.length < p + 1) return -1;
        int sidLen = hello[p] & 0xff;
        p += 1 + sidLen;
        if (hello.length < p + 2) return -1;
        int cipherLen = ((hello[p] & 0xff) << 8) | (hello[p + 1] & 0xff);
        p += 2 + cipherLen;
        if (hello.length < p + 1) return -1;
        int compLen = hello[p] & 0xff;
        p += 1 + compLen;
        if (hello.length < p + 2) return -1;
        int extLen = ((hello[p] & 0xff) << 8) | (hello[p + 1] & 0xff);
        p += 2;
        int extEnd = Math.min(hello.length, p + extLen);
        while (p + 4 <= extEnd) {
            int type = ((hello[p] & 0xff) << 8) | (hello[p + 1] & 0xff);
            int len = ((hello[p + 2] & 0xff) << 8) | (hello[p + 3] & 0xff);
            if (type == 0x0000) return p;
            p += 4 + len;
        }
        return -1;
    }

    private static void writeSegmented(OutputStream out, byte[] hello) throws IOException {
        int chunks = 3 + RND.nextInt(3);
        int per = Math.max(1, hello.length / chunks);
        int idx = 0;
        for (int i = 0; i < chunks - 1 && idx + per < hello.length; i++) {
            out.write(hello, idx, per);
            out.flush();
            sleepQuiet(5 + RND.nextInt(20));
            idx += per;
        }
        out.write(hello, idx, hello.length - idx);
        out.flush();
    }

    /**
     * Repacks one TLS-record-framed ClientHello into TWO records, so DPI that
     * matches on "first record contains ClientHello signature" gets split mid-
     * pattern. The split point is randomised.
     */
    private static void writeAsTwoRecords(OutputStream out, byte[] hello,
                                          HandshakeMode mode) throws IOException {
        if (hello.length < 12) {
            out.write(hello);
            out.flush();
            return;
        }
        byte[] body = new byte[hello.length - 5];
        System.arraycopy(hello, 5, body, 0, body.length);
        int split = 24 + RND.nextInt(Math.max(1, body.length / 2));
        if (split >= body.length) split = body.length / 2;
        byte verHi = 0x03;
        byte verLo = (mode == HandshakeMode.RECORD_TLS12 || mode == HandshakeMode.COMBO_MAX)
                ? (byte) 0x03 : (byte) 0x01;
        // record 1
        out.write(0x16); out.write(verHi); out.write(verLo);
        out.write((split >> 8) & 0xff); out.write(split & 0xff);
        out.write(body, 0, split);
        out.flush();
        sleepQuiet(3 + RND.nextInt(10));
        // record 2
        int rest = body.length - split;
        out.write(0x16); out.write(verHi); out.write(verLo);
        out.write((rest >> 8) & 0xff); out.write(rest & 0xff);
        out.write(body, split, rest);
        out.flush();
    }

    public static String domainFromSecret(String fullSecret) {
        if (fullSecret != null && fullSecret.length() > 34) {
            String hex = fullSecret.substring(34);
            if (hex.matches("(?i)[0-9a-f]+") && hex.length() % 2 == 0) {
                try {
                    return new String(MtCrypto.hexToBytes(hex), "US-ASCII");
                } catch (Exception ignored) {
                }
            }
        }
        return "www.cloudflare.com";
    }

    // --- ClientHello assembly ---------------------------------------------

    private static byte[] buildClientHello(byte[] secret16, String domain, HandshakeMode mode) {
        String sni = pickSni(mode, domain);
        int targetSize;
        if (mode == HandshakeMode.BIG_PADDING) {
            targetSize = BIG_RECORD_LEN;
        } else if (mode == HandshakeMode.RANDOM_PADDING) {
            targetSize = 600 + RND.nextInt(1400);
        } else {
            targetSize = DEFAULT_RECORD_LEN;
        }

        byte verLo = (mode == HandshakeMode.RECORD_TLS12) ? (byte) 0x03 : (byte) 0x01;

        byte[] rec0 = buildRecord(sni, mode, 0, verLo);
        int pad = Math.max(0, targetSize - rec0.length);
        byte[] rec = buildRecord(sni, mode, pad, verLo);

        // random[11..43] = HMAC-SHA256(secret, ClientHello-with-zeroed-random),
        // last 4 bytes XOR-ed with the current unix time.
        byte[] zeroed = rec.clone();
        for (int i = 11; i < 43; i++) zeroed[i] = 0;
        byte[] digest = MtCrypto.hmacSha256(secret16, zeroed);
        int now = (int) (System.currentTimeMillis() / 1000L);
        digest[28] ^= (byte) now;
        digest[29] ^= (byte) (now >>> 8);
        digest[30] ^= (byte) (now >>> 16);
        digest[31] ^= (byte) (now >>> 24);
        System.arraycopy(digest, 0, rec, 11, 32);
        return rec;
    }

    private static byte[] buildRecord(String sni, HandshakeMode mode, int paddingLen, byte verLo) {
        byte[] ciphers = pickCiphers(mode);
        byte[] ext = buildExtensions(sni, mode, paddingLen);
        byte[] sessionId = new byte[32];
        RND.nextBytes(sessionId);

        ByteArrayOutputStream body = new ByteArrayOutputStream();
        w2(body, 0x0303);
        body.write(new byte[32], 0, 32);
        body.write(32);
        write(body, sessionId);
        w2(body, ciphers.length);
        write(body, ciphers);
        body.write(1);
        body.write(0);
        w2(body, ext.length);
        write(body, ext);
        byte[] bodyB = body.toByteArray();

        ByteArrayOutputStream rec = new ByteArrayOutputStream();
        rec.write(0x16);
        rec.write(0x03);
        rec.write(verLo);
        w2(rec, bodyB.length + 4);
        rec.write(0x01);
        w3(rec, bodyB.length);
        write(rec, bodyB);
        return rec.toByteArray();
    }

    private static byte[] buildExtensions(String sni, HandshakeMode mode, int paddingLen) {
        ByteArrayOutputStream e = new ByteArrayOutputStream();

        boolean grease = wantsGrease(mode);
        boolean alpn = wantsAlpn(mode);

        if (grease) ext(e, 0x0a0a, new byte[0]);

        // SNI modes
        switch (mode) {
            case SNI_NONE:
                // no server_name extension
                break;
            case SNI_EMPTY:
                ext(e, 0x0000, new byte[]{0x00, 0x00});  // server_name_list length = 0
                break;
            default:
                addSni(e, sni);
                break;
        }

        if (alpn) ext(e, 0x0010, buildAlpn());
        if (mode == HandshakeMode.ALPN_STRICT_H2) ext(e, 0x0010, buildAlpnH2Only());

        // supported_versions: default lists TLS 1.3 + TLS 1.2; some modes
        // narrow it to one version to better mimic a real cover-domain.
        if (mode == HandshakeMode.TLS13_ONLY) {
            ext(e, 0x002b, new byte[]{0x02, 0x03, 0x04});
        } else if (mode == HandshakeMode.TLS12_ONLY) {
            ext(e, 0x002b, new byte[]{0x02, 0x03, 0x03});
        } else {
            ext(e, 0x002b, new byte[]{0x04, 0x03, 0x04, 0x03, 0x03});
        }

        ext(e, 0x000a, new byte[]{0x00, 0x04, 0x00, 0x1d, 0x00, 0x17});
        ext(e, 0x000d, new byte[]{0x00, 0x06, 0x04, 0x03, 0x08, 0x04, 0x04, 0x01});

        // session_ticket: a real-looking opaque blob trips DPI into treating
        // this connection as a resumed session.
        if (mode == HandshakeMode.SESSION_TICKET) {
            int n = 64 + RND.nextInt(64);
            byte[] ticket = new byte[n];
            RND.nextBytes(ticket);
            ext(e, 0x0023, ticket);
        }

        if (grease) ext(e, 0x1a1a, new byte[0]);
        ext(e, 0x0015, new byte[paddingLen]);
        return e.toByteArray();
    }

    private static byte[] buildAlpnH2Only() {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        w2(b, 3);
        b.write(2);
        b.write('h'); b.write('2');
        return b.toByteArray();
    }

    private static String pickSni(HandshakeMode m, String secretDomain) {
        switch (m) {
            case SNI_JSDELIVR:
                return "cdn.jsdelivr.net";
            case SNI_GOOGLE:
                return "www.google.com";
            case SNI_CLOUDFLARE:
                return "www.cloudflare.com";
            case SNI_PADDED:
                return " " + secretDomain;
            case COMBO:
            case COMBO_MAX:
                return SNI_POOL[RND.nextInt(SNI_POOL.length)];
            default:
                return secretDomain;
        }
    }

    private static byte[] pickCiphers(HandshakeMode m) {
        switch (m) {
            case MIMIC_CHROME:
            case COMBO:
            case COMBO_MAX:
                return shuffleIf(CHROME_CIPHERS,
                        m == HandshakeMode.COMBO_MAX);
            case MIMIC_FIREFOX:
                return FIREFOX_CIPHERS;
            case MIMIC_SAFARI:
                return SAFARI_CIPHERS;
            case MIMIC_EDGE:
                return EDGE_CIPHERS;
            case MIMIC_OKHTTP:
                return OKHTTP_CIPHERS;
            case CIPHER_SHUFFLE:
                return shuffleCiphers(DEFAULT_CIPHERS);
            default:
                return DEFAULT_CIPHERS;
        }
    }

    private static byte[] shuffleIf(byte[] base, boolean doShuffle) {
        return doShuffle ? shuffleCiphers(base) : base;
    }

    /** Fisher-Yates shuffle on 2-byte cipher IDs, keeping the GREASE prefix if present. */
    private static byte[] shuffleCiphers(byte[] base) {
        int n = base.length / 2;
        if (n < 4) return base;
        int keep = (base[0] == 0x0a || base[0] == 0x1a) ? 1 : 0;
        int[] order = new int[n];
        for (int i = 0; i < n; i++) order[i] = i;
        for (int i = n - 1; i > keep; i--) {
            int j = keep + RND.nextInt(i - keep + 1);
            int t = order[i]; order[i] = order[j]; order[j] = t;
        }
        byte[] out = new byte[base.length];
        for (int i = 0; i < n; i++) {
            out[i * 2] = base[order[i] * 2];
            out[i * 2 + 1] = base[order[i] * 2 + 1];
        }
        return out;
    }

    private static boolean wantsGrease(HandshakeMode m) {
        switch (m) {
            case MIMIC_CHROME: case MIMIC_FIREFOX: case MIMIC_SAFARI:
            case MIMIC_EDGE: case COMBO: case COMBO_MAX:
                return true;
            default:
                return false;
        }
    }

    private static boolean wantsAlpn(HandshakeMode m) {
        switch (m) {
            case MIMIC_CHROME: case MIMIC_SAFARI: case MIMIC_EDGE:
            case COMBO: case COMBO_MAX:
                return true;
            default:
                return false;
        }
    }

    private static void addSni(ByteArrayOutputStream e, String domain) {
        byte[] host;
        try {
            host = domain.getBytes("US-ASCII");
        } catch (Exception ex) {
            host = "www.cloudflare.com".getBytes();
        }
        ByteArrayOutputStream sni = new ByteArrayOutputStream();
        w2(sni, host.length + 3);
        sni.write(0x00);
        w2(sni, host.length);
        write(sni, host);
        ext(e, 0x0000, sni.toByteArray());
    }

    private static byte[] buildAlpn() {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        w2(b, 12);
        b.write(2);
        b.write('h'); b.write('2');
        b.write(8);
        b.write('h'); b.write('t'); b.write('t'); b.write('p');
        b.write('/'); b.write('1'); b.write('.'); b.write('1');
        return b.toByteArray();
    }

    private static void ext(ByteArrayOutputStream e, int type, byte[] data) {
        w2(e, type);
        w2(e, data.length);
        write(e, data);
    }

    private static void sleepQuiet(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    // --- record framing helpers -------------------------------------------

    private static int readRecord(InputStream in) throws IOException {
        byte[] hdr = readFully(in, 5);
        int len = ((hdr[3] & 0xff) << 8) | (hdr[4] & 0xff);
        if (len < 0 || len > 1 << 18) throw new IOException("FakeTLS: bad record length");
        readFully(in, len);
        return hdr[0] & 0xff;
    }

    private static byte[] readFully(InputStream in, int n) throws IOException {
        byte[] buf = new byte[n];
        int got = 0;
        while (got < n) {
            int r = in.read(buf, got, n - got);
            if (r < 0) throw new IOException("FakeTLS: EOF after " + got + "/" + n);
            got += r;
        }
        return buf;
    }

    private static void w2(ByteArrayOutputStream o, int v) {
        o.write((v >> 8) & 0xff);
        o.write(v & 0xff);
    }

    private static void w3(ByteArrayOutputStream o, int v) {
        o.write((v >> 16) & 0xff);
        o.write((v >> 8) & 0xff);
        o.write(v & 0xff);
    }

    private static void write(ByteArrayOutputStream o, byte[] b) {
        o.write(b, 0, b.length);
    }

    private static final class RecordOutput extends OutputStream {
        private final OutputStream raw;

        RecordOutput(OutputStream raw) {
            this.raw = raw;
        }

        @Override
        public void write(int b) throws IOException {
            write(new byte[]{(byte) b}, 0, 1);
        }

        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            while (len > 0) {
                int chunk = Math.min(len, MAX_TLS_RECORD);
                raw.write(0x17);
                raw.write(0x03);
                raw.write(0x03);
                raw.write((chunk >> 8) & 0xff);
                raw.write(chunk & 0xff);
                raw.write(b, off, chunk);
                off += chunk;
                len -= chunk;
            }
        }

        @Override
        public void flush() throws IOException {
            raw.flush();
        }

        @Override
        public void close() throws IOException {
            raw.close();
        }
    }

    private static final class RecordInput extends InputStream {
        private final InputStream raw;
        private byte[] buf = new byte[0];
        private int pos;

        RecordInput(InputStream raw) {
            this.raw = raw;
        }

        @Override
        public int read() throws IOException {
            byte[] one = new byte[1];
            int n = read(one, 0, 1);
            return n < 0 ? -1 : (one[0] & 0xff);
        }

        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            if (pos >= buf.length && !fill()) return -1;
            int n = Math.min(len, buf.length - pos);
            System.arraycopy(buf, pos, b, off, n);
            pos += n;
            return n;
        }

        private boolean fill() throws IOException {
            while (true) {
                byte[] hdr = readFully(raw, 5);
                int type = hdr[0] & 0xff;
                int len = ((hdr[3] & 0xff) << 8) | (hdr[4] & 0xff);
                if (len < 0 || len > 1 << 18) {
                    throw new IOException("FakeTLS: bad record length");
                }
                byte[] payload = readFully(raw, len);
                if (type == 0x14) continue;
                if (type == 0x17) {
                    if (len == 0) continue;
                    buf = payload;
                    pos = 0;
                    return true;
                }
                if (type == 0x15) return false;
                throw new IOException("FakeTLS: unexpected record type 0x"
                        + Integer.toHexString(type));
            }
        }

        @Override
        public void close() throws IOException {
            raw.close();
        }
    }
}
