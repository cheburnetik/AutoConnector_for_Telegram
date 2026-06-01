package io.autoconnector.engine.net;

import java.io.IOException;
import java.security.SecureRandom;

/**
 * Minimal unauthenticated MTProto handshake: sends {@code req_pq_multi} and
 * expects a well-formed {@code resPQ}. A valid resPQ proves the transport
 * actually reaches a live Telegram DC — this is the real liveness test, as
 * opposed to a bare TCP connect.
 */
public final class MtHandshakeProbe {

    private static final SecureRandom RND = new SecureRandom();
    private static final int REQ_PQ_MULTI = 0xbe7e8ef1;
    private static final int RES_PQ = 0x05162463;

    /** Runs the probe over an established transport; throws on any failure. */
    public static void probe(IntermediateTransport t) throws IOException {
        byte[] nonce = new byte[16];
        RND.nextBytes(nonce);

        // body: req_pq_multi#be7e8ef1 nonce:int128
        byte[] body = new byte[20];
        putInt32le(body, 0, REQ_PQ_MULTI);
        System.arraycopy(nonce, 0, body, 4, 16);

        // unencrypted MTProto message: auth_key_id(=0) | msg_id | length | body
        byte[] msg = new byte[8 + 8 + 4 + body.length];
        long msgId = (System.currentTimeMillis() / 1000L) << 32;
        putInt64le(msg, 8, msgId);
        putInt32le(msg, 16, body.length);
        System.arraycopy(body, 0, msg, 20, body.length);

        t.writeMessage(msg);

        byte[] resp = t.readMessage();
        if (resp.length < 40) {
            throw new IOException("resPQ too short: " + resp.length);
        }
        int ctor = readInt32le(resp, 20);
        if (ctor != RES_PQ) {
            throw new IOException(String.format("not resPQ: 0x%08x", ctor));
        }
        for (int i = 0; i < 16; i++) {
            if (resp[24 + i] != nonce[i]) {
                throw new IOException("resPQ nonce mismatch");
            }
        }
        // valid resPQ with our nonce echoed back — DC reachable.
    }

    private static void putInt32le(byte[] b, int o, int v) {
        b[o] = (byte) v;
        b[o + 1] = (byte) (v >> 8);
        b[o + 2] = (byte) (v >> 16);
        b[o + 3] = (byte) (v >> 24);
    }

    private static void putInt64le(byte[] b, int o, long v) {
        for (int i = 0; i < 8; i++) b[o + i] = (byte) (v >> (8 * i));
    }

    private static int readInt32le(byte[] b, int o) {
        return (b[o] & 0xff) | ((b[o + 1] & 0xff) << 8)
                | ((b[o + 2] & 0xff) << 16) | ((b[o + 3] & 0xff) << 24);
    }

    private MtHandshakeProbe() {}
}
