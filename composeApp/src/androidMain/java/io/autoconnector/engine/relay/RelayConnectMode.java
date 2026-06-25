package io.autoconnector.engine.relay;

/**
 * Experimental strategies for <b>how the relay acquires an upstream proxy</b>
 * for a fresh Telegram connection — opt-in via Settings → «Экспериментально».
 *
 * <p>Motivation: pasting a single good MTProto proxy straight into Telegram
 * connects instantly, but through the relay it can be slow. The reference path
 * ({@link #OFF}) tries candidate proxies <em>one by one</em> with an 8-second
 * timeout each, so a couple of dead/slow candidates at the top stall the very
 * first connection for tens of seconds. These modes change only the
 * <em>selection/connect strategy</em>; the byte-level relay is untouched.
 */
public enum RelayConnectMode {

    /** Reference: serial candidate trial, 8 s timeout each. Default. */
    OFF(0, "off", "Выключено (эталонный путь)",
            "Кандидаты пробуются по очереди, таймаут 8 с на каждого — как сейчас."),

    /** Race several upstreams at once, first completed handshake wins. */
    PARALLEL_RACE(1, "race", "Параллельная гонка апстримов",
            "Открывает несколько апстримов одновременно (до 5/8/12 — настраивается) и берёт первый, "
            + "с кем прошёл handshake; остальные закрывает. Должно дать почти "
            + "мгновенный коннект, как при прямом вводе одного хорошего прокси."),

    /** Serial, but a short 3 s timeout so dead candidates are skipped fast. */
    FAST_TIMEOUT(2, "fast", "Быстрый таймаут (3 с)",
            "Тот же последовательный перебор, но таймаут на кандидата 3 с вместо 8 — "
            + "быстрее проскакивает мёртвые прокси."),

    /** Try the proven sticky/pinned upstream first (short timeout), then full list. */
    STICKY_FIRST(3, "sticky", "Сначала проверенный",
            "Сначала пробует закреплённый/лучший прокси с коротким таймаутом "
            + "(как прямой ввод одного прокси), и только при неудаче — полный перебор.");

    /** Short connect/handshake timeout for the fast / sticky-first modes. */
    public static final int FAST_TIMEOUT_MS = 3000;

    public final int code;
    public final String key;
    public final String label;
    public final String description;

    RelayConnectMode(int code, String key, String label, String description) {
        this.code = code;
        this.key = key;
        this.label = label;
        this.description = description;
    }

    public static RelayConnectMode fromCode(int c) {
        for (RelayConnectMode m : values()) if (m.code == c) return m;
        return OFF;
    }
}
