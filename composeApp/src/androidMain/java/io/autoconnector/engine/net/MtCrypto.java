package io.autoconnector.engine.net;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Crypto primitives for MTProto transport obfuscation: a manually-driven
 * AES-256-CTR keystream and a SHA-256 helper.
 *
 * <p>CTR is built on top of {@code AES/ECB/NoPadding} so a partial input
 * never gets buffered by the provider — every byte handed in is transformed
 * immediately, which the streaming obfuscation layer relies on.
 */
public final class MtCrypto {

    /** One-directional AES-256-CTR keystream; {@link #process} is XOR-in-place. */
    public static final class Ctr {
        private final Cipher ecb;
        private final byte[] counter;       // 128-bit big-endian counter block
        private byte[] keystream = new byte[0];
        private int ksPos;

        Ctr(byte[] key, byte[] iv) {
            try {
                ecb = Cipher.getInstance("AES/ECB/NoPadding");
                ecb.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"));
            } catch (Exception e) {
                throw new RuntimeException("AES-CTR init failed", e);
            }
            counter = iv.clone();
        }

        public byte[] process(byte[] data) {
            return process(data, 0, data.length);
        }

        public byte[] process(byte[] data, int off, int len) {
            byte[] out = new byte[len];
            for (int i = 0; i < len; i++) {
                if (ksPos >= keystream.length) {
                    try {
                        keystream = ecb.doFinal(counter);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    incrementCounter();
                    ksPos = 0;
                }
                out[i] = (byte) (data[off + i] ^ keystream[ksPos++]);
            }
            return out;
        }

        private void incrementCounter() {
            for (int i = 15; i >= 0; i--) {
                if (++counter[i] != 0) break;
            }
        }
    }

    public static Ctr ctr(byte[] key, byte[] iv) {
        return new Ctr(key, iv);
    }

    public static byte[] sha256(byte[]... parts) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            for (byte[] p : parts) md.update(p);
            return md.digest();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] hmacSha256(byte[] key, byte[] data) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(key, "HmacSHA256"));
            return mac.doFinal(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] hexToBytes(String hex) {
        int n = hex.length() / 2;
        byte[] out = new byte[n];
        for (int i = 0; i < n; i++) {
            out[i] = (byte) Integer.parseInt(hex.substring(i * 2, i * 2 + 2), 16);
        }
        return out;
    }

    private MtCrypto() {}
}
