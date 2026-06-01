package io.autoconnector.engine.net;

import java.util.Random;

/**
 * Anti-DPI obfuscation modes for the upstream handshake. The user picks one
 * in Settings; the relay applies it on every fresh upstream connect. The
 * {@link #AUTO_RANDOM} mode picks a random "trick" each time and the success
 * counters in {@link HandshakeStats} build up a per-mode leaderboard.
 *
 * <p>The set covers SNI manipulation (override / empty / padded), browser
 * fingerprint mimicry (Chrome / Firefox / Safari / Edge / OkHttp), TLS-record
 * level tricks (fragmentation, CCS prelude, record-header version override),
 * cipher shuffling, padding-size variation and TCP timing tricks. Most are
 * inspired by ideas from goodbyedpi/Xray-uTLS and the broader anti-DPI scene.
 */
public enum HandshakeMode {

    NORMAL("0 · Обычный",
            "Стандартный FakeTLS с SNI из секрета"),
    SNI_JSDELIVR("[N/A] SNI jsdelivr",
            "Несовместим с FakeTLS-mtg (ломает HMAC секрета)"),
    SNI_GOOGLE("[N/A] SNI google",
            "Несовместим с FakeTLS-mtg (ломает HMAC секрета)"),
    SNI_CLOUDFLARE("[N/A] SNI cloudflare",
            "Несовместим с FakeTLS-mtg (ломает HMAC секрета)"),
    SNI_NONE("[N/A] Без SNI",
            "Несовместим с FakeTLS-mtg (ломает HMAC секрета)"),
    SNI_EMPTY("[N/A] Пустой SNI",
            "Несовместим с FakeTLS-mtg (ломает HMAC секрета)"),
    SNI_PADDED("[N/A] SNI с пробелом",
            "Несовместим с FakeTLS-mtg (ломает HMAC секрета)"),
    MIMIC_CHROME("1 · Mimic Chrome",
            "Cipher list и расширения как у Chrome, + GREASE + ALPN"),
    MIMIC_FIREFOX("2 · Mimic Firefox",
            "Cipher list и расширения как у Firefox, + GREASE"),
    MIMIC_SAFARI("3 · Mimic Safari",
            "Cipher list и расширения как у Safari, + GREASE + ALPN"),
    MIMIC_EDGE("4 · Mimic Edge",
            "Edge fingerprint: иной GREASE + cipher order"),
    MIMIC_OKHTTP("[N/A] Mimic OkHttp",
            "Без TLS 1.3 ciphers — часть mtg-серверов закрывает"),
    BIG_PADDING("6 · ClientHello 1024 байта",
            "Раздутый TLS-record padding-расширением"),
    SEGMENTED("7 · Сегментированный (TCP)",
            "Разрезает ClientHello на 3–5 TCP-кусков с задержкой"),
    TCP_DELAY("8 · TCP-задержка",
            "Держит TCP-сокет 200–500 мс перед ClientHello"),
    RECORD_FRAGMENT("[N/A] TLS-record split",
            "Несовместим с FakeTLS-mtg (требует один record)"),
    CCS_PRELUDE("[N/A] CCS prelude",
            "Несовместим с FakeTLS-mtg (сбивает state machine)"),
    CIPHER_SHUFFLE("[N/A] Случайный порядок шифров",
            "Шафл сбивает позиции TLS 1.3 ciphers — сервер закрывает"),
    RECORD_TLS12("[N/A] Record header 0x0303",
            "Строгие mtg-серверы закрывают handshake"),
    COMBO("[N/A] Combo",
            "Несовместим (содержит смену SNI)"),
    COMBO_MAX("[N/A] Combo Max",
            "Несовместим (смена SNI + record-frag + CCS)"),
    AUTO_RANDOM("Авто · случайные хитрости",
            "Каждый коннект — рандомный рабочий режим, лидерборд в «Стат»."),
    SPLIT_BEFORE_SNI("11 · TCP-split до SNI",
            "Разрезает TCP-сегмент ровно перед server_name extension"),
    SESSION_TICKET("[N/A] Session Ticket",
            "Расширение входит в HMAC — часть mtg-серверов не пропускает"),
    RANDOM_PADDING("13 · Случайный паддинг",
            "Длина TLS-record рандомизирована (600–2000Б)"),
    ALPN_STRICT_H2("14 · ALPN только h2",
            "Жёсткий ALPN h2 как у CDN без http/1.1"),
    TLS13_ONLY("15 · supported_versions 1.3",
            "ClientHello заявляет только TLS 1.3"),
    TLS12_ONLY("16 · supported_versions 1.2",
            "ClientHello заявляет только TLS 1.2");

    public final String label;
    public final String description;

    HandshakeMode(String label, String description) {
        this.label = label;
        this.description = description;
    }

    public static HandshakeMode fromOrdinal(int o) {
        HandshakeMode[] v = values();
        if (o < 0 || o >= v.length) return NORMAL;
        HandshakeMode m = v[o];
        // If the user's persisted choice is now-disabled, fall back gracefully.
        return m.isWorking() ? m : NORMAL;
    }

    /** Modes proven by bin/test_modes.py to handshake with real mtg-FakeTLS
     *  upstreams. {@code [N/A]}-prefixed modes are kept for ordinal stability
     *  but execute as {@link #NORMAL} on the wire. */
    public boolean isWorking() {
        switch (this) {
            // 0% with mtg-FakeTLS — architectural HMAC / state-machine breakage.
            case SNI_JSDELIVR: case SNI_GOOGLE: case SNI_CLOUDFLARE:
            case SNI_NONE: case SNI_EMPTY: case SNI_PADDED:
            case RECORD_FRAGMENT: case CCS_PRELUDE:
            case COMBO: case COMBO_MAX:
            // Partial-failure modes from bin/test_modes.py — kept ordinal-safe
            // but execute as NORMAL so the user never gets stuck on a flaky pick.
            case MIMIC_OKHTTP: case CIPHER_SHUFFLE:
            case RECORD_TLS12: case SESSION_TICKET:
                return false;
            default:
                return true;
        }
    }

    private static final Random RND = new Random();

    /**
     * Picks a random working "trick" (skips AUTO_RANDOM and N/A) — but with
     * {@link #CONTROL_PROBABILITY} the answer is plain {@link #NORMAL},
     * so the leaderboard always carries a "no-trick" baseline to compare
     * against. Without this baseline you can't tell whether a trick is
     * helping or just no worse than nothing.
     */
    public static final double CONTROL_PROBABILITY = 0.15;

    public static HandshakeMode randomTrick() {
        if (RND.nextDouble() < CONTROL_PROBABILITY) return NORMAL;
        HandshakeMode[] v = values();
        while (true) {
            HandshakeMode m = v[RND.nextInt(v.length)];
            if (m != NORMAL && m != AUTO_RANDOM && m.isWorking()) return m;
        }
    }
}
