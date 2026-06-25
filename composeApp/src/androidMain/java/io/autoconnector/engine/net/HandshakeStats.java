package io.autoconnector.engine.net;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Per-mode A/B counters for the anti-DPI test.
 *
 * <p>The relay tracks five orthogonal facts about every upstream connect so
 * the leaderboard can rank tricks by what they actually <em>buy us</em>, not
 * just by whether the first TCP packet survived:
 *
 * <ol>
 *   <li><b>attempts</b> — the relay tried this trick.</li>
 *   <li><b>handshakes</b> — FakeTLS / Obfuscated2 handshake completed
 *       (i.e. our program produced a working channel to the upstream).</li>
 *   <li><b>tgConnected</b> — Telegram actually started using the channel
 *       (live session registered).</li>
 *   <li><b>longSessions</b> — session lived ≥ {@link #LONG_MS} ms
 *       (DPI didn't kill it in the first seconds).</li>
 *   <li><b>fatSessions</b> — session carried ≥ {@link #FAT_BYTES} bytes
 *       (real content flowed, not just a Telegram keep-alive).</li>
 * </ol>
 *
 * <p>"usable" is the intersection {@code longSessions ∩ fatSessions}; the
 * "выгодность" {@link #score(HandshakeMode)} weighs all four rates so a
 * trick that always handshakes but never holds a session scores low, while
 * one that handshakes 30% of the time but every survivor stays alive for
 * 10+ minutes wins. Counters persist in SharedPreferences.
 */
public final class HandshakeStats {

    private static final String FILE = "autoconnector_handshake_stats";
    /** "Long" threshold — sessions surviving past this count as DPI-evading. */
    public static final long LONG_MS = 10_000L;
    /** "Fat" threshold — sessions over this carry real content. */
    public static final long FAT_BYTES = 16 * 1024L;
    /** A session that pushed at least this many bytes counts as "real chat". */
    public static final long BYTES_5K = 5 * 1024L;
    public static final long BYTES_100K = 100 * 1024L;

    private static volatile SharedPreferences sp;

    private static volatile HandshakeMode lastUsed;

    public static void noteUsed(HandshakeMode m) {
        if (m != null) lastUsed = m;
    }

    public static HandshakeMode lastUsed() {
        return lastUsed;
    }

    public static synchronized void init(Context ctx) {
        if (sp != null) return;
        sp = ctx.getApplicationContext().getSharedPreferences(FILE, 0);
    }

    private static String key(String prefix, HandshakeMode m) {
        return prefix + "_" + m.name();
    }

    private static String key(String prefix, HandshakeMode m,
                              io.autoconnector.engine.core.NetworkMode net) {
        // Network-scoped key — keeps VPN successes from inflating LTE numbers.
        return prefix + "_" + net.code + "_" + m.name();
    }

    private static synchronized void bumpScoped(String prefix, HandshakeMode m,
                                                io.autoconnector.engine.core.NetworkMode net,
                                                long by) {
        if (sp == null || m == null || net == null) return;
        String k = key(prefix, m, net);
        sp.edit().putLong(k, sp.getLong(k, 0) + by).apply();
    }

    private static synchronized long getScoped(String prefix, HandshakeMode m,
                                               io.autoconnector.engine.core.NetworkMode net) {
        return sp != null ? sp.getLong(key(prefix, m, net), 0) : 0;
    }

    private static synchronized void bump(String prefix, HandshakeMode m, long by) {
        if (sp == null || m == null) return;
        String k = key(prefix, m);
        sp.edit().putLong(k, sp.getLong(k, 0) + by).apply();
    }

    public static void recordAttempt(HandshakeMode m)  {
        bump("a", m, 1);
        bumpScopedCurrent("a", m);
    }
    public static void recordHandshake(HandshakeMode m) {
        bump("h", m, 1);
        bumpScopedCurrent("h", m);
    }
    public static void recordTgConnected(HandshakeMode m) {
        bump("g", m, 1);
        bumpScopedCurrent("g", m);
    }

    private static void bumpScopedCurrent(String prefix, HandshakeMode m) {
        io.autoconnector.engine.core.NetworkMode net = io.autoconnector.engine.core.NetworkMonitor.currentMode();
        if (net != io.autoconnector.engine.core.NetworkMode.UNKNOWN) {
            bumpScoped(prefix, m, net, 1);
        }
    }

    /**
     * Closes the bookkeeping for a finished session: increments long / fat
     * subcounters if thresholds were met, and accumulates totals.
     */
    /**
     * Records a finished session. {@code activeMs} is the time between
     * "first actual data byte after handshake" and "last byte" — the
     * "useful work" window that excludes the handshake-only warmup, so
     * average throughput etc. is honest. Pass 0 if not measured.
     */
    public static synchronized void recordSessionEnd(HandshakeMode m,
                                                     long durationMs,
                                                     long bytes,
                                                     long activeMs) {
        if (sp == null || m == null) return;
        SharedPreferences.Editor e = sp.edit();
        long dur = Math.max(0, durationMs);
        long act = Math.max(0, activeMs);
        long b = Math.max(0, bytes);
        e.putLong(key("td", m), sp.getLong(key("td", m), 0) + dur);
        e.putLong(key("ta", m), sp.getLong(key("ta", m), 0) + act);
        e.putLong(key("tb", m), sp.getLong(key("tb", m), 0) + b);
        boolean longS = dur >= LONG_MS;
        boolean fatS = b >= FAT_BYTES;
        boolean five = b >= BYTES_5K;
        boolean hund = b >= BYTES_100K;
        // Global (mode-independent) Telegram-session tallies for the Scan tab.
        e.putLong("g_sessAll", sp.getLong("g_sessAll", 0) + 1);
        if (longS && fatS) e.putLong("g_sessOk", sp.getLong("g_sessOk", 0) + 1);
        if (dur >= 60_000L)  e.putLong("g_ov1",  sp.getLong("g_ov1",  0) + 1);
        if (dur >= 300_000L) e.putLong("g_ov5",  sp.getLong("g_ov5",  0) + 1);
        if (dur >= 900_000L) e.putLong("g_ov15", sp.getLong("g_ov15", 0) + 1);
        if (longS) e.putLong(key("l", m), sp.getLong(key("l", m), 0) + 1);
        if (fatS)  e.putLong(key("f", m), sp.getLong(key("f", m), 0) + 1);
        if (five)  e.putLong(key("s5",  m), sp.getLong(key("s5",  m), 0) + 1);
        if (hund)  e.putLong(key("s100", m), sp.getLong(key("s100", m), 0) + 1);
        if (longS && fatS) {
            e.putLong(key("u", m), sp.getLong(key("u", m), 0) + 1);
            e.putLong(key("ud", m), sp.getLong(key("ud", m), 0) + dur);
        }
        // Extra per-mode buckets for the detailed stats table.
        boolean b10 = b >= 10 * 1024L;
        boolean over1 = dur >= 60_000L;
        boolean over5 = dur >= 300_000L;
        if (b10)   e.putLong(key("b10", m), sp.getLong(key("b10", m), 0) + 1);
        if (over1) e.putLong(key("o1",  m), sp.getLong(key("o1",  m), 0) + 1);
        if (over5) e.putLong(key("o5",  m), sp.getLong(key("o5",  m), 0) + 1);
        // Summed working time for "real" sockets (≥5 КБ AND >1 минуты).
        if (five && over1) e.putLong(key("qa", m), sp.getLong(key("qa", m), 0) + dur);
        io.autoconnector.engine.core.NetworkMode net = io.autoconnector.engine.core.NetworkMonitor.currentMode();
        if (net != io.autoconnector.engine.core.NetworkMode.UNKNOWN) {
            e.putLong(key("td", m, net), sp.getLong(key("td", m, net), 0) + dur);
            e.putLong(key("ta", m, net), sp.getLong(key("ta", m, net), 0) + act);
            e.putLong(key("tb", m, net), sp.getLong(key("tb", m, net), 0) + b);
            if (longS) e.putLong(key("l", m, net), sp.getLong(key("l", m, net), 0) + 1);
            if (fatS)  e.putLong(key("f", m, net), sp.getLong(key("f", m, net), 0) + 1);
            if (five)  e.putLong(key("s5", m, net),   sp.getLong(key("s5", m, net), 0) + 1);
            if (hund)  e.putLong(key("s100", m, net), sp.getLong(key("s100", m, net), 0) + 1);
            if (longS && fatS) {
                e.putLong(key("u", m, net), sp.getLong(key("u", m, net), 0) + 1);
                e.putLong(key("ud", m, net), sp.getLong(key("ud", m, net), 0) + dur);
            }
        }
        e.apply();
    }

    /** Backward-compat overload — kept so anything missed by the refactor
     *  still compiles. activeMs falls back to durationMs (overestimates a
     *  bit when there was no real data after handshake, but doesn't crash). */
    public static void recordSessionEnd(HandshakeMode m, long durationMs, long bytes) {
        recordSessionEnd(m, durationMs, bytes, durationMs);
    }

    // --- per-network readers (used by StatsActivity 3-column table) ---
    public static long attempts(HandshakeMode m, io.autoconnector.engine.core.NetworkMode n)   { return getScoped("a",  m, n); }
    public static long handshakes(HandshakeMode m, io.autoconnector.engine.core.NetworkMode n) { return getScoped("h",  m, n); }
    public static long tgConnected(HandshakeMode m, io.autoconnector.engine.core.NetworkMode n){ return getScoped("g",  m, n); }
    public static long longSessions(HandshakeMode m, io.autoconnector.engine.core.NetworkMode n){return getScoped("l",  m, n); }
    public static long fatSessions(HandshakeMode m, io.autoconnector.engine.core.NetworkMode n){ return getScoped("f",  m, n); }
    public static long usable(HandshakeMode m, io.autoconnector.engine.core.NetworkMode n)     { return getScoped("u",  m, n); }
    public static long usableDurationMs(HandshakeMode m, io.autoconnector.engine.core.NetworkMode n){ return getScoped("ud", m, n); }
    public static long totalDurationMs(HandshakeMode m, io.autoconnector.engine.core.NetworkMode n){ return getScoped("td", m, n); }
    public static long totalActiveMs(HandshakeMode m, io.autoconnector.engine.core.NetworkMode n){ return getScoped("ta", m, n); }
    public static long totalBytes(HandshakeMode m, io.autoconnector.engine.core.NetworkMode n) { return getScoped("tb", m, n); }

    private static synchronized long get(String prefix, HandshakeMode m) {
        return sp != null ? sp.getLong(key(prefix, m), 0) : 0;
    }

    public static long attempts(HandshakeMode m)         { return get("a",  m); }
    public static long handshakes(HandshakeMode m)       { return get("h",  m); }
    public static long tgConnected(HandshakeMode m)      { return get("g",  m); }
    public static long longSessions(HandshakeMode m)     { return get("l",  m); }
    public static long fatSessions(HandshakeMode m)      { return get("f",  m); }
    public static long usable(HandshakeMode m)           { return get("u",  m); }
    public static long usableDurationMs(HandshakeMode m) { return get("ud", m); }
    public static long totalDurationMs(HandshakeMode m)  { return get("td", m); }
    public static long totalBytes(HandshakeMode m)       { return get("tb", m); }
    public static long over10k(HandshakeMode m)          { return get("b10", m); }
    public static long over100k(HandshakeMode m)         { return get("s100", m); }
    public static long over1min(HandshakeMode m)         { return get("o1", m); }
    public static long over5min(HandshakeMode m)         { return get("o5", m); }
    public static long qualifiedActiveMs(HandshakeMode m){ return get("qa", m); }

    /**
     * Composite "выгодность" score in roughly [0..1.5]. Higher is better.
     *
     * <p>Combines the four rates with the usable-session average minutes:
     * <pre>
     *   meanRate = (hs + tg + long + fat) / (4 × attempts)
     *   avgMin   = usableDurationMs / usable / 60000
     *   score    = meanRate × log10(1 + avgMin)
     * </pre>
     * Returns -1 for unprobed modes so the UI can sort them last.
     */
    public static double score(HandshakeMode m) {
        long att = attempts(m);
        if (att <= 0) return -1;
        long hs = handshakes(m);
        long tg = tgConnected(m);
        long lng = longSessions(m);
        long fat = fatSessions(m);
        double meanRate = (hs + tg + lng + fat) / (4.0 * att);
        long us = usable(m);
        double avgMin = us > 0 ? usableDurationMs(m) / (double) us / 60_000.0 : 0;
        return meanRate * Math.log10(1.0 + avgMin);
    }

    // --- global Telegram-session tallies (Scan tab) ---
    private static synchronized long glob(String k) { return sp != null ? sp.getLong(k, 0) : 0; }
    public static long tgSessionsAll() { return glob("g_sessAll"); }
    public static long tgSessionsOk()  { return glob("g_sessOk"); }
    public static long sessionsOver1m()  { return glob("g_ov1"); }
    public static long sessionsOver5m()  { return glob("g_ov5"); }
    public static long sessionsOver15m() { return glob("g_ov15"); }

    public static synchronized void resetAll() {
        if (sp == null) return;
        sp.edit().clear().apply();
    }

    private HandshakeStats() {}
}
