package io.autoconnector.engine.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * MTProto "obfuscated2" transport handshake — both ends.
 *
 * <ul>
 *   <li>{@link #perform} — client side: build and send the 64-byte init
 *       (used to talk to an upstream proxy or a DC directly);</li>
 *   <li>{@link #accept} — server side: read a client's init, derive the
 *       cipher pair and expose the requested transport tag and DC id (used by
 *       the local relay server that Telegram connects to).</li>
 * </ul>
 *
 * After either call {@link #enc}/{@link #dec} carry the application stream.
 */
public final class Obfuscated2 {

    /** Transport tag for the "intermediate" transport. */
    public static final int TAG_INTERMEDIATE = 0xeeeeeeee;

    private static final SecureRandom RND = new SecureRandom();

    public MtCrypto.Ctr enc;
    public MtCrypto.Ctr dec;

    /** Transport tag carried in the handshake (echoed end-to-end by the relay). */
    public int transportTag = TAG_INTERMEDIATE;
    /** Telegram DC id requested in the handshake. */
    public int dcId;

    /**
     * Client side: builds the 64-byte init frame, sends it, arms the ciphers.
     *
     * @param secret16     16-byte proxy secret, or null to talk to a DC directly
     * @param transportTag transport tag to advertise (echo of the client's tag)
     * @param dcId         target Telegram DC id
     */
    public void perform(OutputStream out, byte[] secret16, int transportTag, int dcId)
            throws IOException {
        byte[] init = new byte[64];
        do {
            RND.nextBytes(init);
        } while (!validInit(init));

        putInt32le(init, 56, transportTag);
        init[60] = (byte) (dcId & 0xff);
        init[61] = (byte) ((dcId >> 8) & 0xff);

        byte[] encKey = Arrays.copyOfRange(init, 8, 40);
        byte[] encIv = Arrays.copyOfRange(init, 40, 56);

        byte[] rev = reverse(init);
        byte[] decKey = Arrays.copyOfRange(rev, 0, 32);
        byte[] decIv = Arrays.copyOfRange(rev, 32, 48);

        if (secret16 != null) {
            encKey = MtCrypto.sha256(encKey, secret16);
            decKey = MtCrypto.sha256(decKey, secret16);
        }
        enc = MtCrypto.ctr(encKey, encIv);
        dec = MtCrypto.ctr(decKey, decIv);
        this.transportTag = transportTag;
        this.dcId = dcId;

        byte[] encrypted = enc.process(init);            // advances keystream over all 64
        byte[] frame = new byte[64];
        System.arraycopy(init, 0, frame, 0, 56);         // first 56 bytes sent in clear
        System.arraycopy(encrypted, 56, frame, 56, 8);   // last 8 bytes encrypted
        out.write(frame);
        out.flush();
    }

    /** Convenience: client side with the intermediate transport. */
    public void perform(OutputStream out, byte[] secret16, int dcId) throws IOException {
        perform(out, secret16, TAG_INTERMEDIATE, dcId);
    }

    /**
     * Server side: reads the peer's 64-byte init, derives the cipher pair, and
     * populates {@link #transportTag} / {@link #dcId} from the handshake.
     */
    public void accept(InputStream in, byte[] secret16) throws IOException {
        byte[] init = readFully(in, 64);

        // the peer's encryption key/iv become our decryption key/iv
        byte[] decKey = Arrays.copyOfRange(init, 8, 40);
        byte[] decIv = Arrays.copyOfRange(init, 40, 56);

        // the peer's decryption key/iv become our encryption key/iv
        byte[] rev = reverse(init);
        byte[] encKey = Arrays.copyOfRange(rev, 0, 32);
        byte[] encIv = Arrays.copyOfRange(rev, 32, 48);

        if (secret16 != null) {
            decKey = MtCrypto.sha256(decKey, secret16);
            encKey = MtCrypto.sha256(encKey, secret16);
        }
        dec = MtCrypto.ctr(decKey, decIv);
        enc = MtCrypto.ctr(encKey, encIv);

        byte[] decrypted = dec.process(init);  // advance keystream, reveal [56..64]
        transportTag = (decrypted[56] & 0xff) | ((decrypted[57] & 0xff) << 8)
                | ((decrypted[58] & 0xff) << 16) | ((decrypted[59] & 0xff) << 24);
        dcId = (short) ((decrypted[60] & 0xff) | ((decrypted[61] & 0xff) << 8));
    }

    /** Bytes [8..56] of the init, reversed — 48 bytes. */
    private static byte[] reverse(byte[] init) {
        byte[] rev = new byte[48];
        for (int i = 0; i < 48; i++) rev[i] = init[55 - i];
        return rev;
    }

    /** Init frame must not collide with HTTP verbs, TLS or transport tags. */
    private static boolean validInit(byte[] b) {
        if ((b[0] & 0xff) == 0xef) return false;
        switch (beInt(b, 0)) {
            case 0x48454144: // "HEAD"
            case 0x504f5354: // "POST"
            case 0x47455420: // "GET "
            case 0x4f505449: // "OPTI"
            case 0x16030102: // TLS record
            case 0xdddddddd:
            case 0xeeeeeeee:
                return false;
            default:
                return beInt(b, 4) != 0;
        }
    }

    private static int beInt(byte[] b, int o) {
        return ((b[o] & 0xff) << 24) | ((b[o + 1] & 0xff) << 16)
                | ((b[o + 2] & 0xff) << 8) | (b[o + 3] & 0xff);
    }

    private static void putInt32le(byte[] b, int o, int v) {
        b[o] = (byte) v;
        b[o + 1] = (byte) (v >> 8);
        b[o + 2] = (byte) (v >> 16);
        b[o + 3] = (byte) (v >> 24);
    }

    private static byte[] readFully(InputStream in, int n) throws IOException {
        byte[] buf = new byte[n];
        int got = 0;
        while (got < n) {
            int r = in.read(buf, got, n - got);
            if (r < 0) throw new IOException("obfuscated2: EOF after " + got + "/" + n);
            got += r;
        }
        return buf;
    }
}
