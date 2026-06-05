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
                + "задержка до ~12 мс) — маскирует обмен под bulk-загрузку. Единственный "
                + "стабильный режим, но душит загрузку/отправку медиа."),

        // --- Coalescing-family experiments (fix media throughput, keep evasion) ---

        /** Batch SMALL writes (hide MTProto cadence), pass LARGE writes straight
         *  through (media data), with a shorter delay. Aimed at uploads + mixed. */
        COALESCE_ADAPTIVE(5, "coalesce_adaptive", "Коалесинг адаптивный",
                "Мелкие записи батчит (прячет «мелко-пакетную» сигнатуру MTProto), "
                + "а крупные (медиа-данные) пропускает сразу, задержка короче (~4 мс). "
                + "Цель — не душить аплоад/крупный трафик, оставаясь незаметным."),

        /** Coalesce only the opening window, then full passthrough — bets that DPI
         *  classifies a flow at its start. Aimed at downloads. */
        COALESCE_WARMUP(6, "coalesce_warmup", "Коалесинг старта",
                "Батчит только первые ~128 КБ соединения, дальше — полностью прозрачно. "
                + "Расчёт: DPI «решает» в начале потока; после прогрева медиа идёт на полной скорости. "
                + "Если связь отваливается на больших файлах — значит DPI смотрит постоянно, верните обычный коалесинг."),

        /** No userspace delay — just TCP_NODELAY off; let the kernel (Nagle) coalesce. */
        NAGLE_ONLY(7, "nagle", "Только Nagle (ядро)",
                "Без искусственной задержки: только TCP_NODELAY выкл — ядро само склеивает "
                + "мелкие записи (Nagle). Самый лёгкий по скорости; проверить, хватает ли его маскировки."),

        // --- New coalescing engines: media-friendly, TCP_NODELAY ON ---------------
        // The older coalescing modes (4–6) keep Nagle ON, so the kernel holds the
        // batch a SECOND time on top of the userspace buffer — two buffers stacked,
        // which is exactly what strangled media. These force TCP_NODELAY ON:
        // userspace alone decides batching, and a flush always hits the wire at once.

        /** Smart media engine: batch small MTProto control packets at the start to
         *  keep the bulk-TLS look, pass large writes straight through, and LATCH to
         *  full passthrough after the opening window / first big burst. */
        COALESCE_TURBO(8, "coalesce_turbo", "Коалесинг турбо (медиа)",
                "Лучший для медиа. В начале прячет мелко-пакетную сигнатуру (батчит "
                + "записи <512 Б, задержка ~3 мс, TCP_NODELAY ВКЛ), крупные пропускает сразу. "
                + "После ~256 КБ или первой большой порции защёлкивается в полный проброс — "
                + "медиа идёт на полной скорости, а старт всё равно выглядит как bulk-TLS."),

        /** Lightest masking: batch only tiny control packets, everything else goes
         *  immediately. TCP_NODELAY ON so a flush is never double-buffered. */
        COALESCE_LIGHT(9, "coalesce_light", "Коалесинг мягкий",
                "Минимум маскировки, максимум скорости: батчит только крошечные управляющие "
                + "пакеты (<256 Б, ~2 мс), всё крупнее шлёт сразу. TCP_NODELAY ВКЛ. "
                + "Если «турбо» быстр, но рвётся связь на больших файлах — попробуйте этот."),

        /** Pure bulk-batching like classic coalescing, but TCP_NODELAY ON so the
         *  kernel doesn't stack a second Nagle delay on top of the userspace buffer. */
        COALESCE_NODELAY(10, "coalesce_nd", "Коалесинг без Nagle",
                "Как обычный коалесинг (батчит всё до ~1400 Б / ~8 мс под bulk-загрузку), "
                + "но TCP_NODELAY ВКЛ — ядро не добавляет вторую задержку поверх буфера. "
                + "Маскировка как у обычного, но без двойной буферизации, которая душила медиа."),

        // --- Time-released coalescing + first-packet split family -----------------
        // Why time-based: byte-latched modes (turbo/warmup) only go transparent
        // after enough bytes are SENT upstream. A media DOWNLOAD sends almost
        // nothing upstream (just tiny ACK/request packets), so the latch never
        // trips and those ACKs stay delayed — which throttles the download to a
        // crawl. A wall-clock release fires regardless of direction, so it covers
        // the DPI's start-of-flow classification window and then frees media.

        /** Coalesce small writes only for the first ~1.5 s of the connection, then
         *  go fully transparent — fixes media DOWNLOADS that byte-latched modes
         *  can't (a download sends too little upstream to ever trip a byte latch). */
        COALESCE_TIME(11, "coalesce_time", "Коалесинг старта по времени",
                "Прячет мелко-пакетную сигнатуру первые ~1.5 с соединения (батчит записи "
                + "<512 Б, крупные — сразу), потом полностью прозрачно. В отличие от «турбо/старта», "
                + "release по ВРЕМЕНИ, а не по объёму — поэтому разблокирует и СКАЧИВАНИЕ медиа "
                + "(при загрузке вверх уходит мало байт, и счётчик защёлки не срабатывал)."),

        /** Split only the very first outbound payload into a tiny first TCP
         *  segment + the rest, then pass through. TCP_NODELAY ON so each flush is
         *  its own real segment. The lightest, media-safe desync — the default. */
        GBDPI_SPLIT(12, "split_first_pkt", "Сплит первого пакета",
                "Самый первый исходящий пакет режется на крошечный первый TCP-сегмент (≈2 Б) + "
                + "остаток — так маркер/сигнатура не лежит целиком в одном сегменте, а DPI без "
                + "пересборки её не видит. Дальше поток без изменений (TCP_NODELAY ВКЛ). "
                + "Лёгкий, не душит медиа — рекомендуется по умолчанию."),

        /** First-packet split AND a time-released coalescing window — handshake
         *  desync + bulk-look that frees media after ~1.5 s. */
        GBDPI_SPLIT_TIME(13, "split_first_time", "Сплит первого пакета + коалесинг",
                "Комбо: режет первый пакет И первые ~1.5 с маскирует обмен под bulk-загрузку, "
                + "затем полный проброс. Шанс пройти DPI на старте и не задушить медиа после. "
                + "Пробуйте, если простой сплит проходит, но хочется маскировки старта."),

        // --- «Сплит первого пакета»: усиленные вариации (оригинал не трогаем) -----
        // The plain split cuts ONE write at a tiny offset. These push the same idea
        // harder for stubborn DPI, while still passing all later writes straight
        // through (TCP_NODELAY ON) so media throughput stays intact.

        /** Splits the first THREE outbound writes (handshake + first data), each
         *  into a tiny head + rest — a stronger desync than the single-write split. */
        SPLIT_FIRST_X3(14, "split_first_x3", "Сплит первого пакета ×3",
                "Как «Сплит первого пакета», но режет первые ТРИ исходящие записи "
                + "(рукопожатие + начало данных), каждую на крошечный сегмент (≈3 Б) + остаток. "
                + "Сильнее сбивает DPI на старте; дальше — полный проброс, медиа не страдает."),

        /** Dices the first payload into many tiny segments over its opening bytes —
         *  no contiguous window for a non-reassembling DPI to match on. */
        SPLIT_FIRST_MULTI(15, "split_first_multi", "Сплит первого пакета (мульти)",
                "Первый пакет рубится на множество мелких сегментов (~8 Б) на первых ~64 байтах, "
                + "затем остаток и весь дальнейший поток идут как есть. У DPI вообще нет цельного "
                + "окна для матча в начале. Самый агрессивный сплит, медиа не душит."),

        /** First-packet split with a short pause between the two segments so even a
         *  stack that coalesces back-to-back writes still emits two packets. */
        SPLIT_FIRST_GAP(16, "split_first_gap", "Сплит первого пакета с паузой",
                "Режет первый пакет и делает короткую паузу (~6 мс) перед остатком — так даже "
                + "сетевой стек, склеивающий соседние записи, гарантированно отправит ДВА пакета. "
                + "Для DPI/прокси, где обычный сплит иногда «слипается» обратно в один сегмент.");

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

    /**
     * Order the engines appear in the settings picker, independent of the enum's
     * declaration order: OFF, then the first-packet split family (the default and
     * its stronger variations), then the coalescing family, then the older
     * fragmenting modes. Codes are unchanged, so saved settings still resolve.
     */
    public static Mode[] displayOrder() {
        return new Mode[] {
                Mode.OFF,
                // First-packet split family — split first, default.
                Mode.GBDPI_SPLIT, Mode.SPLIT_FIRST_X3, Mode.SPLIT_FIRST_MULTI,
                Mode.SPLIT_FIRST_GAP, Mode.GBDPI_SPLIT_TIME,
                // Coalescing family — they work but throttle media downloads.
                Mode.COALESCE_DELAY, Mode.COALESCE_TURBO, Mode.COALESCE_LIGHT,
                Mode.COALESCE_NODELAY, Mode.COALESCE_TIME, Mode.COALESCE_ADAPTIVE,
                Mode.COALESCE_WARMUP, Mode.NAGLE_ONLY,
                // Older fragmenting modes.
                Mode.SPLIT_FIRST_N, Mode.FRAGMENT_ALL, Mode.TLS_RECHUNK,
        };
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
            // Coalescing family wants Nagle ON (nodelay=false) to batch; the
            // fragmenting family wants it OFF so each flushed segment goes out.
            boolean nagle;
            switch (m) {
                case COALESCE_DELAY:
                case COALESCE_ADAPTIVE:
                case COALESCE_WARMUP:
                case NAGLE_ONLY:
                    nagle = true; break;
                // New coalescing engines own their batching in userspace and want
                // TCP_NODELAY ON so a flush isn't held a second time by the kernel.
                case COALESCE_TURBO:
                case COALESCE_LIGHT:
                case COALESCE_NODELAY:
                case COALESCE_TIME:
                case GBDPI_SPLIT:
                case GBDPI_SPLIT_TIME:
                case SPLIT_FIRST_X3:
                case SPLIT_FIRST_MULTI:
                case SPLIT_FIRST_GAP:
                    nagle = false; break;
                default:
                    nagle = false; break;
            }
            s.setTcpNoDelay(!nagle);
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
            case COALESCE_ADAPTIVE:
                // Small (<512B) writes batch up to 16 KB / 4 ms; larger writes
                // (media bursts) pass straight through.
                return new AdaptiveCoalescing(raw, 512, 16384, 4);
            case COALESCE_WARMUP:
                // Coalesce the first 128 KB like COALESCE_DELAY, then passthrough.
                return new WarmupCoalescing(raw, 128 * 1024, 1400, 12);
            case COALESCE_TURBO:
                // small (<512B) batch to 8 KB / 3 ms, large pass straight through,
                // then LATCH to full passthrough after 256 KB or a 16 KB burst.
                return new TurboCoalescing(raw, 512, 8192, 3, 256 * 1024, 16 * 1024);
            case COALESCE_LIGHT:
                // Only tiny (<256 B) control packets batched (4 KB / 2 ms cap);
                // anything larger passes through. Paired with TCP_NODELAY ON.
                return new AdaptiveCoalescing(raw, 256, 4096, 2);
            case COALESCE_NODELAY:
                // Classic bulk batching (1400 B / 8 ms) but with TCP_NODELAY ON.
                return new Coalescing(raw, 1400, 8);
            case COALESCE_TIME:
                // Coalesce small (<512B) writes for the first 1500 ms, then transparent.
                return new TimeCoalescing(raw, 1500, 512, 8192, 4);
            case GBDPI_SPLIT:
                // Split the first payload at 2 bytes, then passthrough.
                return new FirstSplit(raw, 2);
            case GBDPI_SPLIT_TIME:
                // First-packet split (innermost, nearest the socket) under a 1500 ms
                // coalescing window (outer). The coalescer's first flush is what the
                // splitter cuts, so the split survives the batching.
                return new TimeCoalescing(new FirstSplit(raw, 2), 1500, 512, 8192, 4);
            case SPLIT_FIRST_X3:
                // Split each of the first 3 outbound writes at a 3-byte head.
                return new FirstNSplit(raw, 3, 3);
            case SPLIT_FIRST_MULTI:
                // Dice the first payload into 8-byte segments over its first 64 bytes.
                return new FirstMultiSplit(raw, 8, 64);
            case SPLIT_FIRST_GAP:
                // Split the first payload at 2 bytes with a 6 ms gap before the rest.
                return new FirstSplitDelay(raw, 2, 6);
            case NAGLE_ONLY:
                // No userspace shaping; the kernel coalesces via Nagle (nodelay off).
                return raw;
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

    /**
     * Coalesces only SMALL writes — hiding the tell-tale small-packet MTProto
     * cadence — while letting LARGE writes (media bursts) pass straight through,
     * with a short flush delay. Keeps the bulk-TLS look that survives DPI without
     * throttling big transfers (the weakness of plain {@link Coalescing}).
     */
    private static final class AdaptiveCoalescing extends OutputStream {
        private final OutputStream d;
        private final int smallThreshold;   // writes >= this bypass the buffer
        private final int batchThreshold;   // flush the small-buffer at this fill
        private final long maxDelayMs;
        private final byte[] buf;
        private int len;
        private long firstAt;

        AdaptiveCoalescing(OutputStream d, int smallThreshold, int batchThreshold, long maxDelayMs) {
            this.d = d;
            this.smallThreshold = Math.max(1, smallThreshold);
            this.batchThreshold = Math.max(this.smallThreshold, batchThreshold);
            this.maxDelayMs = Math.max(1, maxDelayMs);
            this.buf = new byte[this.batchThreshold + 1024];
        }

        @Override public synchronized void write(int b) throws IOException {
            if (len == buf.length) send();
            if (len == 0) firstAt = System.currentTimeMillis();
            buf[len++] = (byte) b;
            if (len >= batchThreshold) send();
        }

        @Override public synchronized void write(byte[] b, int off, int n) throws IOException {
            if (n >= smallThreshold) {
                // Large (media) write: flush pending small bytes to keep order,
                // then send the big chunk straight through.
                send();
                d.write(b, off, n);
                d.flush();
                return;
            }
            int p = off, end = off + n;
            while (p < end) {
                int room = buf.length - len;
                if (room == 0) { send(); room = buf.length; }
                int take = Math.min(room, end - p);
                System.arraycopy(b, p, buf, len, take);
                if (len == 0) firstAt = System.currentTimeMillis();
                len += take;
                p += take;
                if (len >= batchThreshold) send();
            }
        }

        private void send() throws IOException {
            if (len == 0) return;
            d.write(buf, 0, len);
            d.flush();
            len = 0;
        }

        @Override public synchronized void flush() throws IOException {
            if (len > 0 && System.currentTimeMillis() - firstAt >= maxDelayMs) send();
        }

        @Override public synchronized void close() throws IOException {
            try { send(); } finally { d.close(); }
        }
    }

    /**
     * Coalesces like {@link Coalescing} until {@code warmupBytes} have flowed, then
     * switches to plain passthrough — bets that DPI fingerprints a flow only near
     * its start, so media after the warmup runs at full speed. If a connection
     * dies on large transfers under this mode, DPI is watching continuously and
     * plain coalescing is the safer pick.
     */
    private static final class WarmupCoalescing extends OutputStream {
        private final OutputStream d;
        private final long warmupBytes;
        private final int threshold;
        private final long maxDelayMs;
        private final byte[] buf;
        private int len;
        private long firstAt;
        private long written;
        private boolean warm;

        WarmupCoalescing(OutputStream d, long warmupBytes, int threshold, long maxDelayMs) {
            this.d = d;
            this.warmupBytes = Math.max(1, warmupBytes);
            this.threshold = Math.max(64, threshold);
            this.maxDelayMs = Math.max(1, maxDelayMs);
            this.buf = new byte[this.threshold * 2 + 1024];
        }

        @Override public synchronized void write(int b) throws IOException {
            write(new byte[]{(byte) b}, 0, 1);
        }

        @Override public synchronized void write(byte[] b, int off, int n) throws IOException {
            written += n;
            if (warm) { d.write(b, off, n); d.flush(); return; }
            int p = off, end = off + n;
            while (p < end) {
                int room = buf.length - len;
                if (room == 0) { send(); room = buf.length; }
                int take = Math.min(room, end - p);
                System.arraycopy(b, p, buf, len, take);
                if (len == 0) firstAt = System.currentTimeMillis();
                len += take;
                p += take;
                if (len >= threshold) send();
            }
            if (written >= warmupBytes) { send(); warm = true; }
        }

        private void send() throws IOException {
            if (len == 0) return;
            d.write(buf, 0, len);
            d.flush();
            len = 0;
        }

        @Override public synchronized void flush() throws IOException {
            if (warm) { d.flush(); return; }
            if (len > 0 && System.currentTimeMillis() - firstAt >= maxDelayMs) send();
        }

        @Override public synchronized void close() throws IOException {
            try { send(); } finally { d.close(); }
        }
    }

    /**
     * The media-first coalescing engine. While "cold" it behaves like
     * {@link AdaptiveCoalescing}: small writes are batched (hiding the small-packet
     * MTProto cadence behind a bulk-TLS look) and large writes pass straight
     * through. Once the connection has pushed {@code latchBytes} total <em>or</em>
     * emitted a single write ≥ {@code burstLatch}, it LATCHES into pure passthrough
     * for the rest of its life — no buffering, no delay. The opening-window bet is
     * the same as {@link WarmupCoalescing} (DPI fingerprints a flow at its start),
     * but the latch also trips on the first real media burst, so big transfers are
     * never throttled. TCP_NODELAY is ON for this mode, so every flush hits the
     * wire immediately instead of being held again by the kernel.
     */
    private static final class TurboCoalescing extends OutputStream {
        private final OutputStream d;
        private final int smallThreshold;   // writes >= this bypass the buffer
        private final int batchThreshold;   // flush the small-buffer at this fill
        private final long maxDelayMs;
        private final long latchBytes;      // total bytes after which we go transparent
        private final int burstLatch;       // a single write this big latches too
        private final byte[] buf;
        private int len;
        private long firstAt;
        private long written;
        private boolean latched;

        TurboCoalescing(OutputStream d, int smallThreshold, int batchThreshold,
                        long maxDelayMs, long latchBytes, int burstLatch) {
            this.d = d;
            this.smallThreshold = Math.max(1, smallThreshold);
            this.batchThreshold = Math.max(this.smallThreshold, batchThreshold);
            this.maxDelayMs = Math.max(1, maxDelayMs);
            this.latchBytes = Math.max(1, latchBytes);
            this.burstLatch = Math.max(1, burstLatch);
            this.buf = new byte[this.batchThreshold + 1024];
        }

        @Override public synchronized void write(int b) throws IOException {
            write(new byte[]{(byte) b}, 0, 1);
        }

        @Override public synchronized void write(byte[] b, int off, int n) throws IOException {
            written += n;
            if (latched) { d.write(b, off, n); d.flush(); return; }
            // First big burst (or enough total bytes) → go transparent from here on.
            if (n >= burstLatch || written >= latchBytes) {
                send();                       // drain pending small bytes in order
                d.write(b, off, n);
                d.flush();
                latched = true;
                return;
            }
            if (n >= smallThreshold) {        // large-ish but pre-latch: pass through
                send();
                d.write(b, off, n);
                d.flush();
                return;
            }
            int p = off, end = off + n;       // small control packet: batch it
            while (p < end) {
                int room = buf.length - len;
                if (room == 0) { send(); room = buf.length; }
                int take = Math.min(room, end - p);
                System.arraycopy(b, p, buf, len, take);
                if (len == 0) firstAt = System.currentTimeMillis();
                len += take;
                p += take;
                if (len >= batchThreshold) send();
            }
        }

        private void send() throws IOException {
            if (len == 0) return;
            d.write(buf, 0, len);
            d.flush();
            len = 0;
        }

        @Override public synchronized void flush() throws IOException {
            if (latched) { d.flush(); return; }
            if (len > 0 && System.currentTimeMillis() - firstAt >= maxDelayMs) send();
        }

        @Override public synchronized void close() throws IOException {
            try { send(); } finally { d.close(); }
        }
    }

    /**
     * First-packet TCP fragmentation (the userspace-doable subset): the very
     * FIRST outbound payload is cut into a tiny first segment of {@code splitAt}
     * bytes and the remainder, each flushed separately so (with TCP_NODELAY on)
     * they become two distinct TCP segments. The forbidden marker therefore never
     * sits contiguously in the first segment a non-reassembling DPI inspects.
     * Every subsequent write passes straight through — throughput is untouched, so
     * this does not strangle media. Raw-socket tricks (fake packets, low TTL,
     * wrong seq/checksum) are NOT possible from a pure-Java connected socket and
     * are omitted.
     */
    private static final class FirstSplit extends OutputStream {
        private final OutputStream d;
        private final int splitAt;
        private boolean done;

        FirstSplit(OutputStream d, int splitAt) {
            this.d = d;
            this.splitAt = Math.max(1, splitAt);
        }

        @Override public synchronized void write(int b) throws IOException {
            d.write(b); d.flush(); done = true;   // a 1-byte write is already "split"
        }

        @Override public synchronized void write(byte[] b, int off, int len) throws IOException {
            if (done || len <= splitAt) {
                d.write(b, off, len);
                d.flush();
                done = true;
                return;
            }
            d.write(b, off, splitAt);              // segment #1: tiny head
            d.flush();
            d.write(b, off + splitAt, len - splitAt); // segment #2: the rest
            d.flush();
            done = true;
        }

        @Override public void flush() throws IOException { d.flush(); }
        @Override public void close() throws IOException { d.close(); }
    }

    /**
     * {@link FirstSplit} applied to the first {@code count} outbound writes (not
     * just one): each is cut into a {@code splitAt}-byte head + the rest, flushed
     * separately. Stronger handshake desync; every write after the count passes
     * straight through, so throughput / media stay untouched.
     */
    private static final class FirstNSplit extends OutputStream {
        private final OutputStream d;
        private final int splitAt;
        private int left;

        FirstNSplit(OutputStream d, int count, int splitAt) {
            this.d = d;
            this.left = Math.max(1, count);
            this.splitAt = Math.max(1, splitAt);
        }

        @Override public synchronized void write(int b) throws IOException {
            d.write(b); d.flush(); if (left > 0) left--;
        }

        @Override public synchronized void write(byte[] b, int off, int len) throws IOException {
            if (left <= 0 || len <= splitAt) {
                d.write(b, off, len); d.flush();
                if (left > 0) left--;
                return;
            }
            d.write(b, off, splitAt); d.flush();              // tiny head
            d.write(b, off + splitAt, len - splitAt); d.flush(); // the rest
            left--;
        }

        @Override public void flush() throws IOException { d.flush(); }
        @Override public void close() throws IOException { d.close(); }
    }

    /**
     * Dices the FIRST outbound payload into {@code seg}-byte segments over its
     * opening {@code head} bytes (each its own flush → its own TCP segment), then
     * the remainder and every later write pass straight through. Leaves no
     * contiguous opening window for a non-reassembling DPI to match — the most
     * aggressive first-packet split — without touching later throughput.
     */
    private static final class FirstMultiSplit extends OutputStream {
        private final OutputStream d;
        private final int seg;
        private final int head;
        private boolean done;

        FirstMultiSplit(OutputStream d, int seg, int head) {
            this.d = d;
            this.seg = Math.max(1, seg);
            this.head = Math.max(this.seg, head);
        }

        @Override public synchronized void write(int b) throws IOException {
            d.write(b); d.flush(); done = true;
        }

        @Override public synchronized void write(byte[] b, int off, int len) throws IOException {
            if (done) { d.write(b, off, len); d.flush(); return; }
            int end = off + len;
            int cut = off + Math.min(len, head);
            int p = off;
            while (p < cut) {
                int take = Math.min(seg, cut - p);
                d.write(b, p, take); d.flush();
                p += take;
            }
            if (p < end) { d.write(b, p, end - p); d.flush(); }
            done = true;
        }

        @Override public void flush() throws IOException { d.flush(); }
        @Override public void close() throws IOException { d.close(); }
    }

    /**
     * {@link FirstSplit} plus a short {@code gapMs} pause between the head segment
     * and the remainder, so even a network stack that coalesces back-to-back
     * writes still emits two distinct packets. Only the first payload is affected.
     */
    private static final class FirstSplitDelay extends OutputStream {
        private final OutputStream d;
        private final int splitAt;
        private final long gapMs;
        private boolean done;

        FirstSplitDelay(OutputStream d, int splitAt, long gapMs) {
            this.d = d;
            this.splitAt = Math.max(1, splitAt);
            this.gapMs = Math.max(1, gapMs);
        }

        @Override public synchronized void write(int b) throws IOException {
            d.write(b); d.flush(); done = true;
        }

        @Override public synchronized void write(byte[] b, int off, int len) throws IOException {
            if (done || len <= splitAt) {
                d.write(b, off, len); d.flush(); done = true;
                return;
            }
            d.write(b, off, splitAt); d.flush();              // tiny head
            try { Thread.sleep(gapMs); } catch (InterruptedException ignored) {
                Thread.currentThread().interrupt();
            }
            d.write(b, off + splitAt, len - splitAt); d.flush(); // the rest
            done = true;
        }

        @Override public void flush() throws IOException { d.flush(); }
        @Override public void close() throws IOException { d.close(); }
    }

    /**
     * Coalesces SMALL writes (hiding the small-packet MTProto cadence behind a
     * bulk-TLS look) only for the first {@code warmupMs} wall-clock milliseconds
     * of the connection, then switches to pure passthrough forever. Large writes
     * always pass straight through even during the window.
     *
     * <p>Unlike {@link WarmupCoalescing} / {@link TurboCoalescing}, the release is
     * driven by ELAPSED TIME, not bytes sent. That matters for media DOWNLOADS:
     * the upstream direction carries only tiny ACK/request packets, so a byte
     * latch never trips and those ACKs stay coalesced — throttling the download.
     * A time latch always fires, covering the DPI's start-of-flow classification
     * window and then letting ACKs (and uploads) flow immediately. TCP_NODELAY is
     * on for this mode so a flushed batch egresses at once.
     */
    private static final class TimeCoalescing extends OutputStream {
        private final OutputStream d;
        private final long warmupMs;
        private final int smallThreshold;
        private final int batchThreshold;
        private final long maxDelayMs;
        private final byte[] buf;
        private int len;
        private long firstAt;
        private long startAt;      // 0 until the first write
        private boolean warm;

        TimeCoalescing(OutputStream d, long warmupMs, int smallThreshold,
                       int batchThreshold, long maxDelayMs) {
            this.d = d;
            this.warmupMs = Math.max(1, warmupMs);
            this.smallThreshold = Math.max(1, smallThreshold);
            this.batchThreshold = Math.max(this.smallThreshold, batchThreshold);
            this.maxDelayMs = Math.max(1, maxDelayMs);
            this.buf = new byte[this.batchThreshold + 1024];
        }

        @Override public synchronized void write(int b) throws IOException {
            write(new byte[]{(byte) b}, 0, 1);
        }

        @Override public synchronized void write(byte[] b, int off, int n) throws IOException {
            long now = System.currentTimeMillis();
            if (startAt == 0) startAt = now;
            if (!warm && now - startAt >= warmupMs) { send(); warm = true; }
            if (warm) { d.write(b, off, n); d.flush(); return; }
            if (n >= smallThreshold) {             // large write passes immediately
                send();
                d.write(b, off, n);
                d.flush();
                return;
            }
            int p = off, end = off + n;            // small write: batch it
            while (p < end) {
                int room = buf.length - len;
                if (room == 0) { send(); room = buf.length; }
                int take = Math.min(room, end - p);
                System.arraycopy(b, p, buf, len, take);
                if (len == 0) firstAt = now;
                len += take;
                p += take;
                if (len >= batchThreshold) send();
            }
        }

        private void send() throws IOException {
            if (len == 0) return;
            d.write(buf, 0, len);
            d.flush();
            len = 0;
        }

        @Override public synchronized void flush() throws IOException {
            if (warm) { d.flush(); return; }
            if (len > 0 && System.currentTimeMillis() - firstAt >= maxDelayMs) send();
        }

        @Override public synchronized void close() throws IOException {
            try { send(); } finally { d.close(); }
        }
    }
}
