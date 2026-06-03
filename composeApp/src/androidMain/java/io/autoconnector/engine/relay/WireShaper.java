package io.autoconnector.engine.relay;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;

/**
 * Experimental upstream "proxying engines" — opt-in alternatives to the
 * reference relay path, selectable in Settings → «Экспериментально».
 *
 * <p><b>Why a separate knob.</b> The reference relay re-ciphers Telegram's
 * obfuscated2 stream byte-for-byte; we must not alter a single byte of it.
 * What we <em>can</em> vary is <b>how those bytes are written to the upstream
 * TCP socket</b> — segment sizes, flush cadence, TLS-record boundaries. That
 * is exactly the surface a DPI box fingerprints, and exactly what these modes
 * reshape. {@link Mode#OFF} (the default) wraps nothing, so the working
 * reference scenario is left bit-identical.
 *
 * <p>The shaping is applied only to the live <b>upstream proxy</b> connection
 * (see {@link UpstreamConnector}); background probes and the direct/bypass path
 * are untouched.
 *
 * <p>Two insertion points exist (see UpstreamConnector):
 * <ul>
 *   <li>{@link #wrapRaw} — wraps the bare socket output, so the shaping splits
 *       <em>TCP segments</em> of whatever flows (FakeTLS records or the plain
 *       obfuscated2 stream), including the handshake. Used by the "innermost"
 *       modes.</li>
 *   <li>{@link #wrapApp} — wraps the application stream above the FakeTLS
 *       record layer, so each logical write becomes its own (small) TLS record.
 *       Used by {@link Mode#TLS_RECHUNK}.</li>
 * </ul>
 */
public final class WireShaper {

    private static final Random RND = new Random();

    /** A selectable experimental engine. {@code code} is the persisted int. */
    public enum Mode {
        /** Reference path — no shaping, no socket-option changes. Default. */
        OFF(0, "off", "Выключено (эталонный путь)",
                "Стандартный релей без изменений — рабочий проверенный путь."),
        /** Heavily fragment only the first few writes (handshake + first data). */
        SPLIT_FIRST_N(1, "split_first", "Дробление первых пакетов",
                "Режет первые ~4 исходящих записи (рукопожатие + начало) на "
                + "крошечные TCP-сегменты с задержкой; дальше — без изменений. "
                + "Лёгкий: цель — сбить сигнатурный матч на старте, не теряя скорость."),
        /** Fragment every outbound write into moderate random segments. */
        FRAGMENT_ALL(2, "frag_all", "Фрагментация всего потока",
                "Каждую исходящую запись дробит на сегменты ~80–1200 Б "
                + "(TCP_NODELAY вкл). Сбивает анализ по всему потоку, но тяжелее по скорости."),
        /** FakeTLS: emit many small TLS records. Non-TLS: falls back to frag. */
        TLS_RECHUNK(3, "tls_rechunk", "Переразбивка TLS-records",
                "Для FakeTLS-прокси (ee): app-data разбивается на множество мелких "
                + "TLS-records (~80–700 Б) вместо одного крупного — против DPI по размеру records. "
                + "Для обычных MT/SOCKS5 — деградирует во фрагментацию."),
        /** Buffer + Nagle on: send larger batches, mimic a bulk TLS download. */
        COALESCE_DELAY(4, "coalesce", "Коалесинг (батчинг)",
                "Буферизует мелкие записи и шлёт крупными порциями (TCP_NODELAY выкл, "
                + "задержка до ~12 мс) — маскирует обмен под bulk-загрузку. Обратный по смыслу режим.");

        public final int code;
        public final String key;
        public final String label;
        public final String description;

        Mode(int code, String key, String label, String description) {
            this.code = code;
            this.key = key;
            this.label = label;
            this.description = description;
        }

        public static Mode fromCode(int c) {
            for (Mode m : values()) if (m.code == c) return m;
            return OFF;
        }
    }

    private WireShaper() {}

    /**
     * Sets TCP options that make the shaping actually reach the wire. Only
     * touches the socket when a non-OFF mode is active, so the reference path
     * keeps the JDK defaults it has always used.
     */
    public static void applySocketOptions(Socket s, Mode m) {
        if (s == null || m == Mode.OFF) return;
        try {
            // Fragmenting modes need Nagle OFF so each flushed segment goes out
            // on its own; the coalescing mode wants Nagle ON to batch.
            s.setTcpNoDelay(m != Mode.COALESCE_DELAY);
        } catch (Exception ignored) {
        }
    }

    /**
     * Wraps the bare socket output for the "innermost" modes (segment-level
     * shaping of everything, handshake included). Returns {@code raw} unchanged
     * for {@link Mode#OFF} and {@link Mode#TLS_RECHUNK} (which shapes higher up).
     */
    public static OutputStream wrapRaw(OutputStream raw, Mode m) {
        switch (m) {
            case SPLIT_FIRST_N:
                return new FirstNFragmenting(raw, 4, 8, 64, 6);
            case FRAGMENT_ALL:
                return new Fragmenting(raw, 80, 1200, 0);
            case COALESCE_DELAY:
                return new Coalescing(raw, 1400, 12);
            default:
                return raw;
        }
    }

    /**
     * Wraps the application stream (above any FakeTLS record layer) for
     * {@link Mode#TLS_RECHUNK}: each logical write is split small so the record
     * layer emits many small records. For non-FakeTLS upstreams this degrades
     * to plain segment fragmentation. All other modes return {@code appOut}.
     */
    public static OutputStream wrapApp(OutputStream appOut, Mode m, boolean fakeTls) {
        if (m != Mode.TLS_RECHUNK) return appOut;
        return fakeTls ? new Fragmenting(appOut, 80, 700, 0)
                       : new Fragmenting(appOut, 80, 1200, 0);
    }

    // === decorators =======================================================

    private static void sleepQuiet(int ms) {
        if (ms <= 0) return;
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    /** Splits every {@code write(byte[],...)} into random [min,max]-sized,
     *  individually-flushed segments, with optional per-segment jitter. */
    private static final class Fragmenting extends OutputStream {
        private final OutputStream d;
        private final int min, max, jitter;

        Fragmenting(OutputStream d, int min, int max, int jitter) {
            this.d = d;
            this.min = Math.max(1, min);
            this.max = Math.max(this.min, max);
            this.jitter = jitter;
        }

        @Override public void write(int b) throws IOException { d.write(b); }

        @Override public void write(byte[] b, int off, int len) throws IOException {
            int end = off + len, p = off;
            while (p < end) {
                int span = max > min ? min + RND.nextInt(max - min + 1) : min;
                if (span > end - p) span = end - p;
                d.write(b, p, span);
                d.flush();
                p += span;
                if (p < end) sleepQuiet(jitter > 0 ? RND.nextInt(jitter + 1) : 0);
            }
        }

        @Override public void flush() throws IOException { d.flush(); }
        @Override public void close() throws IOException { d.close(); }
    }

    /** Fragments only the first {@code n} writes heavily, then passes through —
     *  targets the start-of-connection signature with negligible throughput cost. */
    private static final class FirstNFragmenting extends OutputStream {
        private final OutputStream d;
        private final int min, max, jitter;
        private int remaining;

        FirstNFragmenting(OutputStream d, int n, int min, int max, int jitter) {
            this.d = d;
            this.remaining = n;
            this.min = Math.max(1, min);
            this.max = Math.max(this.min, max);
            this.jitter = jitter;
        }

        @Override public void write(int b) throws IOException { d.write(b); }

        @Override public void write(byte[] b, int off, int len) throws IOException {
            boolean frag;
            synchronized (this) {
                frag = remaining > 0;
                if (frag) remaining--;
            }
            if (!frag) {
                d.write(b, off, len);
                d.flush();
                return;
            }
            int end = off + len, p = off;
            while (p < end) {
                int span = max > min ? min + RND.nextInt(max - min + 1) : min;
                if (span > end - p) span = end - p;
                d.write(b, p, span);
                d.flush();
                p += span;
                if (p < end) sleepQuiet(jitter > 0 ? RND.nextInt(jitter + 1) : 0);
            }
        }

        @Override public void flush() throws IOException { d.flush(); }
        @Override public void close() throws IOException { d.close(); }
    }

    /**
     * Buffers writes and only forwards once {@code threshold} bytes accumulate
     * or {@code maxDelayMs} elapsed since the oldest buffered byte. {@code flush()}
     * is intentionally lazy (it would otherwise defeat batching) but still
     * forwards an aged buffer; {@code close()} flushes whatever remains.
     *
     * <p>The cap on held time is small (default 12 ms) and the next write always
     * drains an aged buffer, so an interactive stream never stalls noticeably.
     */
    private static final class Coalescing extends OutputStream {
        private final OutputStream d;
        private final int threshold;
        private final long maxDelayMs;
        private final byte[] buf;
        private int len;
        private long firstAt;

        Coalescing(OutputStream d, int threshold, long maxDelayMs) {
            this.d = d;
            this.threshold = Math.max(64, threshold);
            this.maxDelayMs = Math.max(1, maxDelayMs);
            this.buf = new byte[Math.max(this.threshold * 2, 4096)];
        }

        @Override public synchronized void write(int b) throws IOException {
            ensureRoomOrFlush(1);
            buf[len++] = (byte) b;
            stampAndMaybeSend();
        }

        @Override public synchronized void write(byte[] b, int off, int len) throws IOException {
            int p = off, end = off + len;
            while (p < end) {
                int room = buf.length - this.len;
                if (room == 0) { send(); room = buf.length; }
                int n = Math.min(room, end - p);
                System.arraycopy(b, p, buf, this.len, n);
                if (this.len == 0) firstAt = System.currentTimeMillis();
                this.len += n;
                p += n;
                maybeSend();
            }
        }

        private void ensureRoomOrFlush(int need) throws IOException {
            if (buf.length - len < need) send();
        }

        private void stampAndMaybeSend() throws IOException {
            if (len == 1) firstAt = System.currentTimeMillis();
            maybeSend();
        }

        private void maybeSend() throws IOException {
            if (len >= threshold
                    || (len > 0 && System.currentTimeMillis() - firstAt >= maxDelayMs)) {
                send();
            }
        }

        private void send() throws IOException {
            if (len == 0) return;
            d.write(buf, 0, len);
            d.flush();
            len = 0;
        }

        @Override public synchronized void flush() throws IOException {
            // Lazy: only drain if the buffer is already aged past the cap.
            if (len > 0 && System.currentTimeMillis() - firstAt >= maxDelayMs) send();
        }

        @Override public synchronized void close() throws IOException {
            try { send(); } finally { d.close(); }
        }
    }
}
