package io.autoconnector.engine.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import io.autoconnector.engine.core.NetworkMode;
import io.autoconnector.engine.model.ModeStats;
import io.autoconnector.engine.model.ProxyEntry;
import io.autoconnector.engine.model.ProxyType;
import io.autoconnector.engine.scan.PageScanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Single SQLite-backed store for discovered proxies plus the user-managed
 * list of {@link Source source pages} they were collected from.
 *
 * <p>Two tables share the data: {@code proxies} keyed by
 * {@link ProxyEntry#dedupKey()}, and {@code source_proxies} which records
 * which sources have advertised which proxy so the catalogue and the
 * per-source counts stay accurate when the same proxy appears on more than
 * one list.
 */
public class ProxyStore extends SQLiteOpenHelper {

    private static final String DB_NAME = "autoconnector.db";
    private static final int DB_VERSION = 11;
    private static final String T = "proxies";
    private static final String S = "sources";
    private static final String SP = "source_proxies";
    private static final String CL = "check_log";
    private static final String RL = "relay_log";
    /** Per-host attempt history: individual check probes AND telegram-relay
     *  connects, each with its own timings/bytes, capped per host so the UI
     *  can show the last N attempts. */
    private static final String AL = "attempt_log";
    /** Per-(proxy, network-mode) snapshot: a proxy's score and aliveness
     *  depend on whether the device is on Wi-Fi, LTE, or behind a VPN, so
     *  we track them independently. The legacy columns on {@link #T}
     *  still hold the aggregate / current-mode picture for backwards
     *  compatibility with screens that haven't been split yet. */
    private static final String PMS = "proxy_mode_stats";

    /** A user-managed scan source. */
    public static final class Source {
        public long id;
        public String url;
        public boolean enabled;
        public long lastRefreshAt;
        public long lastCheckStartedAt;
        public long lastCheckAt;
        public int totalCount;
        public int aliveCount;
        public int deadCount;
        /** Last scan error (download failure or no proxies parsed); null = OK. */
        public String lastError;
        /** How many proxies were parsed out of the most recent successful scan. */
        public int lastFoundCount;
        /** Bytes downloaded on the most recent scan attempt (0 if it failed). */
        public long lastBytes;
        /** Streak of failed refreshes — drives the background-scan backoff. */
        public int consecutiveFailures;
    }

    private static ProxyStore instance;

    public static synchronized ProxyStore get(Context ctx) {
        if (instance == null) {
            instance = new ProxyStore(ctx.getApplicationContext());
        }
        return instance;
    }

    private ProxyStore(Context ctx) {
        super(ctx, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + T + " ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "dedup_key TEXT UNIQUE NOT NULL,"
                + "type TEXT NOT NULL,"
                + "host TEXT NOT NULL,"
                + "port INTEGER NOT NULL,"
                + "secret TEXT,"
                + "source TEXT,"
                + "added_at INTEGER NOT NULL,"
                + "last_check INTEGER NOT NULL DEFAULT 0,"
                + "alive INTEGER NOT NULL DEFAULT 0,"
                + "rtt_ms INTEGER NOT NULL DEFAULT -1,"
                + "successes INTEGER NOT NULL DEFAULT 0,"
                + "failures INTEGER NOT NULL DEFAULT 0,"
                + "score REAL NOT NULL DEFAULT 0,"
                + "last_error TEXT,"
                + "last_ok INTEGER NOT NULL DEFAULT 0,"
                + "tg_connections INTEGER NOT NULL DEFAULT 0,"
                + "total_session_ms INTEGER NOT NULL DEFAULT 0,"
                + "bytes_relayed INTEGER NOT NULL DEFAULT 0,"
                + "last_tg_connect_at INTEGER NOT NULL DEFAULT 0)");
        db.execSQL("CREATE INDEX idx_score ON " + T + "(score DESC)");
        db.execSQL("CREATE INDEX idx_check ON " + T + "(last_check ASC)");

        db.execSQL("CREATE TABLE " + S + " ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "url TEXT UNIQUE NOT NULL,"
                + "enabled INTEGER NOT NULL DEFAULT 1,"
                + "last_refresh_at INTEGER NOT NULL DEFAULT 0,"
                + "last_check_started_at INTEGER NOT NULL DEFAULT 0,"
                + "last_check_at INTEGER NOT NULL DEFAULT 0,"
                + "order_index INTEGER NOT NULL DEFAULT 0,"
                + "last_error TEXT,"
                + "last_found_count INTEGER NOT NULL DEFAULT 0,"
                + "last_bytes INTEGER NOT NULL DEFAULT 0,"
                + "consecutive_failures INTEGER NOT NULL DEFAULT 0)");

        db.execSQL("CREATE TABLE " + SP + " ("
                + "source_id INTEGER NOT NULL,"
                + "proxy_id INTEGER NOT NULL,"
                + "PRIMARY KEY (source_id, proxy_id))");
        db.execSQL("CREATE INDEX idx_sp_source ON " + SP + "(source_id)");

        db.execSQL("CREATE TABLE " + CL + " ("
                + "proxy_id INTEGER NOT NULL,"
                + "ts INTEGER NOT NULL,"
                + "success INTEGER NOT NULL)");
        db.execSQL("CREATE INDEX idx_cl_proxy ON " + CL + "(proxy_id, ts)");
        db.execSQL("CREATE INDEX idx_cl_ts ON " + CL + "(ts)");

        db.execSQL("CREATE TABLE " + RL + " ("
                + "proxy_id INTEGER NOT NULL,"
                + "ts INTEGER NOT NULL,"
                + "success INTEGER NOT NULL)");
        db.execSQL("CREATE INDEX idx_rl_proxy ON " + RL + "(proxy_id, ts)");
        db.execSQL("CREATE INDEX idx_rl_ts ON " + RL + "(ts)");

        createModeStatsTable(db);
        createAttemptLogTable(db);
        seedDefaultSources(db);
    }

    private static void createAttemptLogTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + AL + " ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "proxy_id INTEGER NOT NULL,"
                + "ts INTEGER NOT NULL,"
                + "kind INTEGER NOT NULL,"
                + "success INTEGER NOT NULL,"
                + "tcp_ms INTEGER NOT NULL DEFAULT -1,"
                + "tls_ms INTEGER NOT NULL DEFAULT -1,"
                + "total_ms INTEGER NOT NULL DEFAULT -1,"
                + "bytes_in INTEGER NOT NULL DEFAULT 0,"
                + "bytes_out INTEGER NOT NULL DEFAULT 0)");
        db.execSQL("CREATE INDEX IF NOT EXISTS idx_al_proxy ON " + AL + "(proxy_id, ts)");
    }

    private static void createModeStatsTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + PMS + " ("
                + "proxy_id INTEGER NOT NULL,"
                + "mode TEXT NOT NULL,"
                + "last_check INTEGER NOT NULL DEFAULT 0,"
                + "last_ok INTEGER NOT NULL DEFAULT 0,"
                + "alive INTEGER NOT NULL DEFAULT 0,"
                + "rtt_ms INTEGER NOT NULL DEFAULT -1,"
                + "successes INTEGER NOT NULL DEFAULT 0,"
                + "failures INTEGER NOT NULL DEFAULT 0,"
                + "score REAL NOT NULL DEFAULT 0,"
                + "tg_connections INTEGER NOT NULL DEFAULT 0,"
                + "total_session_ms INTEGER NOT NULL DEFAULT 0,"
                + "bytes_relayed INTEGER NOT NULL DEFAULT 0,"
                + "PRIMARY KEY (proxy_id, mode))");
        db.execSQL("CREATE INDEX IF NOT EXISTS idx_pms_mode_score "
                + "ON " + PMS + "(mode, score DESC)");
        db.execSQL("CREATE INDEX IF NOT EXISTS idx_pms_mode_alive "
                + "ON " + PMS + "(mode, alive, score DESC)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        if (oldV < 6) {
            // Full reset for pre-v6 schemas — older structure differs too much.
            db.execSQL("DROP TABLE IF EXISTS " + RL);
            db.execSQL("DROP TABLE IF EXISTS " + CL);
            db.execSQL("DROP TABLE IF EXISTS " + SP);
            db.execSQL("DROP TABLE IF EXISTS " + S);
            db.execSQL("DROP TABLE IF EXISTS " + T);
            onCreate(db);
            return;
        }
        if (oldV < 7) {
            db.execSQL("ALTER TABLE " + S
                    + " ADD COLUMN last_check_started_at INTEGER NOT NULL DEFAULT 0");
        }
        if (oldV < 8) {
            db.execSQL("ALTER TABLE " + S
                    + " ADD COLUMN consecutive_failures INTEGER NOT NULL DEFAULT 0");
        }
        if (oldV < 9) {
            createModeStatsTable(db);
        }
        if (oldV < 10) {
            db.execSQL("ALTER TABLE " + S
                    + " ADD COLUMN last_bytes INTEGER NOT NULL DEFAULT 0");
        }
        if (oldV < 11) {
            createAttemptLogTable(db);
        }
    }

    private static void seedDefaultSources(SQLiteDatabase db) {
        int i = 0;
        for (String url : PageScanner.DEFAULT_PAGES) {
            ContentValues v = new ContentValues();
            v.put("url", url);
            v.put("enabled", 1);
            v.put("order_index", i++);
            db.insertWithOnConflict(S, null, v, SQLiteDatabase.CONFLICT_IGNORE);
        }
    }

    /** Idempotently adds any missing default source URLs (after upgrades).
     *  SQLite serialises writes internally — no need to hold a Java-level
     *  monitor across the call (which used to stall UI onCreate when a
     *  background worker held the store's lock). */
    public void ensureDefaultSources() {
        seedDefaultSources(getWritableDatabase());
    }

    // --- writes (proxies) --------------------------------------------------

    /**
     * Inserts the proxy if its dedup key is new, and links it to the
     * {@code p.source} URL. Returns true when the proxy itself was new.
     */
    public boolean add(ProxyEntry p) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put("dedup_key", p.dedupKey());
        v.put("type", p.type.name());
        v.put("host", p.host);
        v.put("port", p.port);
        v.put("secret", p.secret);
        v.put("source", p.source);
        v.put("added_at", p.addedAt);
        long proxyId = db.insertWithOnConflict(T, null, v, SQLiteDatabase.CONFLICT_IGNORE);
        boolean fresh = proxyId != -1;
        if (proxyId == -1) {
            proxyId = lookupId(db, "SELECT id FROM " + T + " WHERE dedup_key=?", p.dedupKey());
        }
        if (proxyId > 0 && p.source != null && !p.source.isEmpty()) {
            long sourceId = upsertSourceId(db, p.source);
            if (sourceId > 0) {
                ContentValues link = new ContentValues();
                link.put("source_id", sourceId);
                link.put("proxy_id", proxyId);
                db.insertWithOnConflict(SP, null, link, SQLiteDatabase.CONFLICT_IGNORE);
            }
        }
        return fresh;
    }

    /** Bulk insert in one transaction. Returns the count of NEW rows. */
    public int addAll(List<ProxyEntry> list) {
        int added = 0;
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            for (ProxyEntry p : list) {
                if (add(p)) added++;
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
        return added;
    }

    /** Persists the mutable health/rating fields of an existing row. */
    public void updateStats(ProxyEntry p) {
        ContentValues v = new ContentValues();
        v.put("last_check", p.lastCheck);
        v.put("alive", p.alive ? 1 : 0);
        v.put("rtt_ms", p.rttMs);
        v.put("successes", p.successes);
        v.put("failures", p.failures);
        v.put("score", p.score);
        v.put("last_error", p.lastError);
        v.put("last_ok", p.lastOk);
        getWritableDatabase().update(T, v, "id=?", new String[]{String.valueOf(p.id)});
    }

    /**
     * A successful relay handshake is the strongest possible proof of life —
     * stronger than the background probe — so refresh {@code last_check} /
     * {@code last_ok} / {@code alive} accordingly and append a success entry
     * to the 24-hour probe log so the catalogue's "пров." column updates.
     */
    public void markAliveFromRelay(long proxyId, long ms) {
        getWritableDatabase().execSQL(
                "UPDATE " + T + " SET last_check=?, last_ok=?, alive=1,"
                        + " successes=successes+1, last_error=NULL"
                        + " WHERE id=?",
                new Object[]{ms, ms, proxyId});
        logCheck(proxyId, true);
    }

    /** Records one completed relay session through the given proxy. */
    public void recordSession(long proxyId, long durationMs) {
        getWritableDatabase().execSQL(
                "UPDATE " + T + " SET tg_connections=tg_connections+1,"
                        + " total_session_ms=total_session_ms+? WHERE id=?",
                new Object[]{durationMs, proxyId});
    }

    /** Updates the "Telegram last successfully connected via" timestamp. */
    public void setLastTelegramConnect(long proxyId, long ms) {
        getWritableDatabase().execSQL(
                "UPDATE " + T + " SET last_tg_connect_at=? WHERE id=?",
                new Object[]{ms, proxyId});
    }

    /** Logs the outcome of one Telegram-relay handshake attempt. */
    public void logRelayAttempt(long proxyId, boolean success) {
        getWritableDatabase().execSQL(
                "INSERT INTO " + RL + " (proxy_id, ts, success) VALUES (?, ?, ?)",
                new Object[]{proxyId, System.currentTimeMillis(), success ? 1 : 0});
    }

    /** Drops {@link #logRelayAttempt} rows older than 24 hours. */
    public void purgeOldRelayAttempts() {
        long cutoff = System.currentTimeMillis() - 86_400_000L;
        getWritableDatabase().execSQL("DELETE FROM " + RL + " WHERE ts<?",
                new Object[]{cutoff});
    }

    /** {@code [ok, fail]} relay-attempt counts over the last 24 hours. */
    public int[] relayConnects24h(long proxyId) {
        long cutoff = System.currentTimeMillis() - 86_400_000L;
        Cursor c = getReadableDatabase().rawQuery(
                "SELECT COALESCE(SUM(success), 0), COALESCE(SUM(1-success), 0)"
                        + " FROM " + RL + " WHERE proxy_id=? AND ts>?",
                new String[]{String.valueOf(proxyId), String.valueOf(cutoff)});
        try {
            if (c.moveToFirst()) {
                return new int[]{c.getInt(0), c.getInt(1)};
            }
        } finally {
            c.close();
        }
        return new int[]{0, 0};
    }

    /** Adds bytes carried through the proxy by an active relay session. */
    public void addBytesRelayed(long proxyId, long bytes) {
        if (bytes <= 0) return;
        getWritableDatabase().execSQL(
                "UPDATE " + T + " SET bytes_relayed=bytes_relayed+? WHERE id=?",
                new Object[]{bytes, proxyId});
    }

    /** Appends one probe result to the 24-hour rolling log. */
    public void logCheck(long proxyId, boolean success) {
        getWritableDatabase().execSQL(
                "INSERT INTO " + CL + " (proxy_id, ts, success) VALUES (?, ?, ?)",
                new Object[]{proxyId, System.currentTimeMillis(), success ? 1 : 0});
    }

    /** Drops {@link #logCheck} rows older than 24 hours. */
    public void purgeOldChecks() {
        long cutoff = System.currentTimeMillis() - 86_400_000L;
        getWritableDatabase().execSQL("DELETE FROM " + CL + " WHERE ts<?",
                new Object[]{cutoff});
    }

    /**
     * Appends one entry to the per-host attempt history — a background check
     * probe ({@code kind=0}) or a Telegram relay connect ({@code kind=1}) —
     * with its individual timings/bytes, then prunes the host's log down to
     * the most recent 50 rows. Never throws to the caller.
     */
    public void logAttempt(long proxyId, int kind, boolean success, int tcpMs,
                           int tlsMs, int totalMs, long bytesIn, long bytesOut) {
        try {
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL("INSERT INTO " + AL
                            + " (proxy_id, ts, kind, success, tcp_ms, tls_ms,"
                            + " total_ms, bytes_in, bytes_out)"
                            + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    new Object[]{proxyId, System.currentTimeMillis(), kind,
                            success ? 1 : 0, tcpMs, tlsMs, totalMs, bytesIn, bytesOut});
            db.execSQL("DELETE FROM " + AL + " WHERE proxy_id=? AND id NOT IN"
                            + " (SELECT id FROM " + AL + " WHERE proxy_id=?"
                            + " ORDER BY ts DESC, id DESC LIMIT 50)",
                    new Object[]{proxyId, proxyId});
        } catch (Exception ignored) {
            // history logging is best-effort — never break the caller
        }
    }

    /**
     * The host's most recent attempts, newest first, capped to {@code limit}.
     * Returns an empty list on any error (never throws).
     */
    public java.util.List<io.autoconnector.engine.model.AttemptRow> hostHistory(
            long proxyId, int limit) {
        java.util.List<io.autoconnector.engine.model.AttemptRow> out = new ArrayList<>();
        Cursor c = null;
        try {
            c = getReadableDatabase().rawQuery(
                    "SELECT ts, kind, success, tcp_ms, tls_ms, total_ms,"
                            + " bytes_in, bytes_out FROM " + AL
                            + " WHERE proxy_id=? ORDER BY ts DESC, id DESC LIMIT ?",
                    new String[]{String.valueOf(proxyId), String.valueOf(limit)});
            while (c.moveToNext()) {
                io.autoconnector.engine.model.AttemptRow r =
                        new io.autoconnector.engine.model.AttemptRow();
                r.ts = c.getLong(0);
                r.kind = c.getInt(1);
                r.success = c.getInt(2) != 0;
                r.tcpMs = c.getInt(3);
                r.tlsMs = c.getInt(4);
                r.totalMs = c.getInt(5);
                r.bytesIn = c.getLong(6);
                r.bytesOut = c.getLong(7);
                out.add(r);
            }
        } catch (Exception ignored) {
            // reading history is best-effort — return whatever we have
        } finally {
            if (c != null) c.close();
        }
        return out;
    }

    /**
     * Resets the working catalog state + all statistics WITHOUT deleting hosts
     * or subscriptions. Every proxy keeps its identity (host/port/secret/type/
     * source/added_at) and stays in the pool, but its health + rating + tallies
     * are zeroed, so the next scan re-rates everything from scratch. The rolling
     * check/relay logs and per-network mode stats are cleared too.
     *
     * <p>Leaves {@code sources} (subscriptions) and {@code source_proxies} (the
     * host↔subscription linkage) completely untouched.
     */
    public void resetCatalogStats() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE " + T + " SET "
                + "last_check=0, alive=0, rtt_ms=-1, successes=0, failures=0, "
                + "score=0, last_error=NULL, last_ok=0, tg_connections=0, "
                + "total_session_ms=0, bytes_relayed=0, last_tg_connect_at=0");
        db.execSQL("DELETE FROM " + CL);
        db.execSQL("DELETE FROM " + RL);
        db.execSQL("DELETE FROM " + AL);
        db.execSQL("DELETE FROM " + PMS);
    }

    /**
     * Forgets every downloaded host (the whole proxy pool) and everything keyed
     * to it, but keeps the user's subscriptions so the next scan can re-fill the
     * pool from them. {@code sources} rows survive; {@code source_proxies} links
     * are cleared since the proxies they referenced are gone.
     */
    public void clearDownloadedHosts() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + T);
        db.execSQL("DELETE FROM " + SP);
        db.execSQL("DELETE FROM " + CL);
        db.execSQL("DELETE FROM " + RL);
        db.execSQL("DELETE FROM " + AL);
        db.execSQL("DELETE FROM " + PMS);
    }

    /** {@code [ok, fail]} probe counts for one proxy over the last 24 hours. */
    public int[] checks24h(long proxyId) {
        long cutoff = System.currentTimeMillis() - 86_400_000L;
        Cursor c = getReadableDatabase().rawQuery(
                "SELECT COALESCE(SUM(success), 0), COALESCE(SUM(1-success), 0)"
                        + " FROM " + CL + " WHERE proxy_id=? AND ts>?",
                new String[]{String.valueOf(proxyId), String.valueOf(cutoff)});
        try {
            if (c.moveToFirst()) {
                return new int[]{c.getInt(0), c.getInt(1)};
            }
        } finally {
            c.close();
        }
        return new int[]{0, 0};
    }

    // --- reads (proxies) ---------------------------------------------------

    public int count() {
        return scalar("SELECT COUNT(*) FROM " + T, null);
    }

    public int countAlive() {
        return scalar("SELECT COUNT(*) FROM " + T + " WHERE alive=1", null);
    }

    public int countByType(ProxyType t) {
        return scalar("SELECT COUNT(*) FROM " + T + " WHERE type=?",
                new String[]{t.name()});
    }

    public int countDead() {
        return scalar("SELECT COUNT(*) FROM " + T + " WHERE last_check>0 AND alive=0", null);
    }

    public int countUnchecked() {
        return scalar("SELECT COUNT(*) FROM " + T + " WHERE last_check=0", null);
    }

    /** All-time probe outcomes summed across every proxy: {successes, failures}. */
    public long[] sumCheckCounts() {
        Cursor c = getReadableDatabase().rawQuery(
                "SELECT COALESCE(SUM(successes),0), COALESCE(SUM(failures),0) FROM " + T, null);
        try {
            if (c.moveToFirst()) return new long[]{c.getLong(0), c.getLong(1)};
            return new long[]{0, 0};
        } finally {
            c.close();
        }
    }

    /** Alive proxies whose last check landed within {@code minutes} ago. */
    public int countAliveWithinMin(int minutes) {
        long cutoff = System.currentTimeMillis() - minutes * 60_000L;
        return scalar("SELECT COUNT(*) FROM " + T
                        + " WHERE alive=1 AND last_check>?",
                new String[]{String.valueOf(cutoff)});
    }

    /** Hosts that ever served at least one successful Telegram session. */
    public int countEverServedTelegram() {
        return scalar("SELECT COUNT(*) FROM " + T + " WHERE tg_connections>0", null);
    }

    /**
     * Lowest-ordered source that links to this proxy, or 0 if none —
     * used in the catalogue to show which subscription a host came from.
     */
    public long primarySourceId(long proxyId) {
        Cursor c = getReadableDatabase().rawQuery(
                "SELECT s.id FROM " + S + " s JOIN " + SP + " sp ON s.id=sp.source_id"
                        + " WHERE sp.proxy_id=? ORDER BY s.order_index ASC, s.id ASC LIMIT 1",
                new String[]{String.valueOf(proxyId)});
        try {
            if (c.moveToFirst()) return c.getLong(0);
        } finally {
            c.close();
        }
        return 0;
    }

    public List<ProxyEntry> top(int limit) {
        return query("SELECT * FROM " + T + " ORDER BY score DESC, rtt_ms ASC LIMIT ?",
                new String[]{String.valueOf(limit)});
    }

    /** Top-rated proxies that are ALSO currently {@code alive=1}. Used by
     *  the relay's failover pool so we don't waste retries on hosts that
     *  the last probe already declared dead. */
    public List<ProxyEntry> topAlive(int limit) {
        return query("SELECT * FROM " + T + " WHERE alive=1 AND last_check>0"
                        + " ORDER BY score DESC, rtt_ms ASC LIMIT ?",
                new String[]{String.valueOf(limit)});
    }

    /** Random sample of alive hosts NOT in the top tier — for diversification
     *  in the failover pool. If the top dies cascade-style we want fresh
     *  candidates, not endless retries of the same dead set. */
    public List<ProxyEntry> randomAlive(int limit) {
        return query("SELECT * FROM " + T + " WHERE alive=1 AND last_check>0"
                        + " ORDER BY RANDOM() LIMIT ?",
                new String[]{String.valueOf(limit)});
    }

    /** Count of currently-alive hosts — cheap; lets callers decide whether
     *  to trigger a wider scan after a failover cascade. */
    public int aliveCount() {
        return scalar("SELECT COUNT(*) FROM " + T + " WHERE alive=1 AND last_check>0", null);
    }

    /**
     * Picks proxies most worth re-probing. Sort priority:
     *   0 — never checked yet,
     *   1 — currently alive (maintain health),
     *   2 — recently alive (last_ok within 24h),
     *   3 — long dead.
     * Within each tier, oldest {@code last_check} goes first. This means
     * battery-expensive periodic checks focus on hosts that can still pay
     * off, instead of hammering a thousand permanently-dead RU IPs.
     */
    public List<ProxyEntry> dueForCheck(int limit) {
        return dueForCheck(limit, 0L);
    }

    /**
     * As {@link #dueForCheck(int)}, but with an anti-flood floor: a host whose
     * last check is NEWER than {@code now - minAgeMs} is EXCLUDED so the same
     * host isn't re-probed too often. Never-checked hosts ({@code last_check=0})
     * always stay eligible. {@code minAgeMs <= 0} disables the floor.
     */
    public List<ProxyEntry> dueForCheck(int limit, long minAgeMs) {
        long now = System.currentTimeMillis();
        long cutoff = now - 86_400_000L;
        java.util.ArrayList<String> args = new java.util.ArrayList<>();
        java.util.ArrayList<String> conds = new java.util.ArrayList<>();
        if (minAgeMs > 0) {
            conds.add("(last_check=0 OR last_check<=?)");
            args.add(String.valueOf(now - minAgeMs));
        }
        // Exclude hosts already being probed RIGHT NOW so two concurrent check
        // passes (e.g. the fresh-start bootstrap loop + the mains loop) don't
        // both grab the same overdue host — no duplicate probing.
        String inflight = inFlightCsv();
        if (inflight != null) conds.add("id NOT IN (" + inflight + ")");
        String where = conds.isEmpty() ? "" : " WHERE " + String.join(" AND ", conds);
        args.add(String.valueOf(cutoff));
        args.add(String.valueOf(limit));
        return query("SELECT * FROM " + T + where
                        + " ORDER BY"
                        + " CASE WHEN last_check=0 THEN 0"
                        + "      WHEN alive=1 THEN 1"
                        + "      WHEN last_ok>? THEN 2"
                        + "      ELSE 3 END ASC,"
                        + " last_check ASC LIMIT ?",
                args.toArray(new String[0]));
    }

    /** Comma-separated ids of hosts being probed right now (or null if none) —
     *  used to keep concurrent {@code dueForCheck} passes from picking the same
     *  host. Ids come from our own DB, so inlining them is injection-safe. */
    private static String inFlightCsv() {
        java.util.Set<Long> p = io.autoconnector.engine.core.ScanState.probing;
        if (p.isEmpty()) return null;
        StringBuilder sb = new StringBuilder();
        for (Long id : p) {
            if (id == null) continue;
            if (sb.length() > 0) sb.append(',');
            sb.append(id.longValue());
        }
        return sb.length() == 0 ? null : sb.toString();
    }

    /** Fetches the given proxy ids. Order is not guaranteed. */
    public List<ProxyEntry> proxiesByIds(java.util.Collection<Long> ids) {
        if (ids == null || ids.isEmpty()) return new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (Long id : ids) {
            if (id == null) continue;
            if (sb.length() > 0) sb.append(',');
            sb.append(id);
        }
        if (sb.length() == 0) return new ArrayList<>();
        return query("SELECT * FROM " + T + " WHERE id IN (" + sb + ")", null);
    }

    /** All proxies that were ever seen on the given source. */
    public List<ProxyEntry> proxiesForSource(long sourceId) {
        return query("SELECT p.* FROM " + T + " p JOIN " + SP + " sp"
                        + " ON p.id=sp.proxy_id WHERE sp.source_id=?",
                new String[]{String.valueOf(sourceId)});
    }

    // --- sources -----------------------------------------------------------

    /** All sources, ordered by display order, with their cached counts. */
    public List<Source> listSources() {
        List<Source> out = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(
                "SELECT * FROM " + S + " ORDER BY order_index ASC, id ASC", null);
        try {
            while (c.moveToNext()) {
                Source s = new Source();
                s.id = c.getLong(c.getColumnIndexOrThrow("id"));
                s.url = c.getString(c.getColumnIndexOrThrow("url"));
                s.enabled = c.getInt(c.getColumnIndexOrThrow("enabled")) != 0;
                s.lastRefreshAt = c.getLong(c.getColumnIndexOrThrow("last_refresh_at"));
                s.lastCheckStartedAt = c.getLong(c.getColumnIndexOrThrow("last_check_started_at"));
                s.lastCheckAt = c.getLong(c.getColumnIndexOrThrow("last_check_at"));
                s.lastError = c.getString(c.getColumnIndexOrThrow("last_error"));
                s.lastFoundCount = c.getInt(c.getColumnIndexOrThrow("last_found_count"));
                s.lastBytes = c.getLong(c.getColumnIndexOrThrow("last_bytes"));
                s.consecutiveFailures =
                        c.getInt(c.getColumnIndexOrThrow("consecutive_failures"));
                populateCounts(db, s);
                out.add(s);
            }
        } finally {
            c.close();
        }
        return out;
    }

    /** Single source with refreshed counts; null if missing. */
    public Source getSource(long id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + S + " WHERE id=?",
                new String[]{String.valueOf(id)});
        try {
            if (!c.moveToFirst()) return null;
            Source s = new Source();
            s.id = c.getLong(c.getColumnIndexOrThrow("id"));
            s.url = c.getString(c.getColumnIndexOrThrow("url"));
            s.enabled = c.getInt(c.getColumnIndexOrThrow("enabled")) != 0;
            s.lastRefreshAt = c.getLong(c.getColumnIndexOrThrow("last_refresh_at"));
            s.lastCheckAt = c.getLong(c.getColumnIndexOrThrow("last_check_at"));
            s.lastError = c.getString(c.getColumnIndexOrThrow("last_error"));
            s.lastFoundCount = c.getInt(c.getColumnIndexOrThrow("last_found_count"));
            s.lastBytes = c.getLong(c.getColumnIndexOrThrow("last_bytes"));
            populateCounts(db, s);
            return s;
        } finally {
            c.close();
        }
    }

    private void populateCounts(SQLiteDatabase db, Source s) {
        s.totalCount = scalarOn(db,
                "SELECT COUNT(*) FROM " + SP + " WHERE source_id=?", s.id);
        s.aliveCount = scalarOn(db,
                "SELECT COUNT(*) FROM " + T + " p JOIN " + SP + " sp ON p.id=sp.proxy_id"
                        + " WHERE sp.source_id=? AND p.alive=1 AND p.last_check>0", s.id);
        s.deadCount = scalarOn(db,
                "SELECT COUNT(*) FROM " + T + " p JOIN " + SP + " sp ON p.id=sp.proxy_id"
                        + " WHERE sp.source_id=? AND p.alive=0 AND p.last_check>0", s.id);
    }

    /** Inserts the URL (if new) or returns the id of an existing row. */
    public long upsertSource(String url) {
        return upsertSourceId(getWritableDatabase(), url);
    }

    private long upsertSourceId(SQLiteDatabase db, String url) {
        ContentValues v = new ContentValues();
        v.put("url", url);
        long id = db.insertWithOnConflict(S, null, v, SQLiteDatabase.CONFLICT_IGNORE);
        if (id == -1) {
            id = lookupId(db, "SELECT id FROM " + S + " WHERE url=?", url);
        }
        return id;
    }

    public void setSourceEnabled(long id, boolean enabled) {
        getWritableDatabase().execSQL("UPDATE " + S + " SET enabled=? WHERE id=?",
                new Object[]{enabled ? 1 : 0, id});
    }

    public void updateSourceUrl(long id, String url) {
        try {
            getWritableDatabase().execSQL("UPDATE " + S + " SET url=? WHERE id=?",
                    new Object[]{url, id});
        } catch (Exception ignored) {
            // collides with another source's URL — leave as is
        }
    }

    public void deleteSource(long id) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + SP + " WHERE source_id=?", new Object[]{id});
        db.execSQL("DELETE FROM " + S + " WHERE id=?", new Object[]{id});
    }

    public void markSourceRefreshed(long id) {
        getWritableDatabase().execSQL("UPDATE " + S + " SET last_refresh_at=? WHERE id=?",
                new Object[]{System.currentTimeMillis(), id});
    }

    public void markSourceCheckStarted(long id) {
        getWritableDatabase().execSQL(
                "UPDATE " + S + " SET last_check_started_at=? WHERE id=?",
                new Object[]{System.currentTimeMillis(), id});
    }

    /**
     * Persists the per-source outcome of the last scan attempt, plus the
     * consecutive-failures counter that drives background backoff.
     */
    public void setSourceScanResult(long id, int foundCount, long bytes, String error) {
        boolean ok = error == null && foundCount > 0;
        if (ok) {
            getWritableDatabase().execSQL(
                    "UPDATE " + S + " SET last_found_count=?, last_bytes=?, last_error=NULL,"
                            + " consecutive_failures=0 WHERE id=?",
                    new Object[]{foundCount, bytes, id});
        } else {
            getWritableDatabase().execSQL(
                    "UPDATE " + S + " SET last_found_count=?, last_bytes=?, last_error=?,"
                            + " consecutive_failures=consecutive_failures+1 WHERE id=?",
                    new Object[]{foundCount, bytes, error, id});
        }
    }

    public void markSourceChecked(long id) {
        getWritableDatabase().execSQL("UPDATE " + S + " SET last_check_at=? WHERE id=?",
                new Object[]{System.currentTimeMillis(), id});
    }

    /**
     * Forgets every subscription's download history — last-refresh time, found
     * count, byte size, error and the backoff counter — so the UI shows
     * "downloaded: never / zeros" and the next pass re-downloads them all from
     * scratch. The {@code sources} rows themselves (url / enabled) survive.
     */
    public void resetSourceStats() {
        getWritableDatabase().execSQL("UPDATE " + S + " SET "
                + "last_refresh_at=0, last_check_at=0, last_check_started_at=0, "
                + "last_found_count=0, last_bytes=0, last_error=NULL, "
                + "consecutive_failures=0");
    }

    /** URLs of every enabled source, in display order. */
    public List<String> enabledSourceUrls() {
        List<String> out = new ArrayList<>();
        // Only http(s) sources are real subscriptions to download. Sources whose
        // url is a sentinel (e.g. "manual:fixed") hold manually-pasted proxies —
        // a fixed list that must NOT be fetched.
        Cursor c = getReadableDatabase().rawQuery(
                "SELECT url FROM " + S + " WHERE enabled=1 AND url LIKE 'http%' ORDER BY order_index ASC, id ASC",
                null);
        try {
            while (c.moveToNext()) out.add(c.getString(0));
        } finally {
            c.close();
        }
        return out;
    }

    // --- helpers -----------------------------------------------------------

    private int scalar(String sql, String[] args) {
        Cursor c = getReadableDatabase().rawQuery(sql, args);
        try {
            return c.moveToFirst() ? c.getInt(0) : 0;
        } finally {
            c.close();
        }
    }

    private int scalarOn(SQLiteDatabase db, String sql, long arg) {
        Cursor c = db.rawQuery(sql, new String[]{String.valueOf(arg)});
        try {
            return c.moveToFirst() ? c.getInt(0) : 0;
        } finally {
            c.close();
        }
    }

    private long lookupId(SQLiteDatabase db, String sql, String arg) {
        Cursor c = db.rawQuery(sql, new String[]{arg});
        try {
            return c.moveToFirst() ? c.getLong(0) : -1;
        } finally {
            c.close();
        }
    }

    private List<ProxyEntry> query(String sql, String[] args) {
        List<ProxyEntry> out = new ArrayList<>();
        Cursor c = getReadableDatabase().rawQuery(sql, args);
        try {
            while (c.moveToNext()) out.add(read(c));
        } finally {
            c.close();
        }
        return out;
    }

    private static ProxyEntry read(Cursor c) {
        ProxyEntry p = new ProxyEntry();
        p.id = c.getLong(c.getColumnIndexOrThrow("id"));
        p.type = ProxyType.valueOf(c.getString(c.getColumnIndexOrThrow("type")));
        p.host = c.getString(c.getColumnIndexOrThrow("host"));
        p.port = c.getInt(c.getColumnIndexOrThrow("port"));
        p.secret = c.getString(c.getColumnIndexOrThrow("secret"));
        p.source = c.getString(c.getColumnIndexOrThrow("source"));
        p.addedAt = c.getLong(c.getColumnIndexOrThrow("added_at"));
        p.lastCheck = c.getLong(c.getColumnIndexOrThrow("last_check"));
        p.alive = c.getInt(c.getColumnIndexOrThrow("alive")) != 0;
        p.rttMs = c.getInt(c.getColumnIndexOrThrow("rtt_ms"));
        p.successes = c.getInt(c.getColumnIndexOrThrow("successes"));
        p.failures = c.getInt(c.getColumnIndexOrThrow("failures"));
        p.score = c.getDouble(c.getColumnIndexOrThrow("score"));
        p.lastError = c.getString(c.getColumnIndexOrThrow("last_error"));
        p.lastOk = c.getLong(c.getColumnIndexOrThrow("last_ok"));
        p.tgConnections = c.getLong(c.getColumnIndexOrThrow("tg_connections"));
        p.totalSessionMs = c.getLong(c.getColumnIndexOrThrow("total_session_ms"));
        p.bytesRelayed = c.getLong(c.getColumnIndexOrThrow("bytes_relayed"));
        p.lastTgConnectAt = c.getLong(c.getColumnIndexOrThrow("last_tg_connect_at"));
        return p;
    }

    // === PER-MODE STATS API =================================================
    // Mode-tagged variants of the host-rating queries. NetworkMonitor decides
    // the current mode; everything that picks an upstream or records a probe
    // now goes through these so VPN-only successes don't lift a host's rank
    // on bare LTE.

    /** Returns the ModeStats row for {@code (proxyId, mode)} or {@code null}. */
    public ModeStats modeStatsOf(long proxyId, NetworkMode mode) {
        Cursor c = getReadableDatabase().rawQuery(
                "SELECT * FROM " + PMS + " WHERE proxy_id=? AND mode=?",
                new String[]{String.valueOf(proxyId), mode.code});
        try {
            if (c.moveToFirst()) return readModeStats(c);
        } finally {
            c.close();
        }
        return null;
    }

    /** Returns all three ModeStats rows for one proxy, keyed by mode.
     *  Missing rows simply have a fresh empty {@link ModeStats} returned. */
    public java.util.Map<NetworkMode, ModeStats> modeStatsAll(long proxyId) {
        java.util.Map<NetworkMode, ModeStats> out = new java.util.HashMap<>();
        Cursor c = getReadableDatabase().rawQuery(
                "SELECT * FROM " + PMS + " WHERE proxy_id=?",
                new String[]{String.valueOf(proxyId)});
        try {
            while (c.moveToNext()) {
                ModeStats s = readModeStats(c);
                out.put(NetworkMode.fromCode(s.mode), s);
            }
        } finally {
            c.close();
        }
        for (NetworkMode m : NetworkMode.reportable()) {
            if (!out.containsKey(m)) {
                ModeStats empty = new ModeStats();
                empty.proxyId = proxyId;
                empty.mode = m.code;
                out.put(m, empty);
            }
        }
        return out;
    }

    // ---- backup export / import -------------------------------------------

    /** Hosts that are alive in at least one network mode — what a "catalog of
     *  live hosts" backup exports. */
    public List<ProxyEntry> aliveHostsAnyMode() {
        return query("SELECT DISTINCT p.* FROM " + T + " p"
                + " JOIN " + PMS + " m ON m.proxy_id=p.id"
                + " WHERE m.alive=1 AND m.last_check>0", null);
    }

    /** Insert (or find existing, by dedup key) a host on import; returns its id. */
    public long importHost(ProxyEntry p) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put("dedup_key", p.dedupKey());
        v.put("type", p.type.name());
        v.put("host", p.host);
        v.put("port", p.port);
        v.put("secret", p.secret);
        v.put("source", p.source);
        v.put("added_at", p.addedAt > 0 ? p.addedAt : System.currentTimeMillis());
        long id = db.insertWithOnConflict(T, null, v, SQLiteDatabase.CONFLICT_IGNORE);
        if (id == -1) id = lookupId(db, "SELECT id FROM " + T + " WHERE dedup_key=?", p.dedupKey());
        return id;
    }

    /** Upsert one per-mode stats row on import (replaces any existing row). */
    public void importModeStats(long proxyId, String modeCode, boolean alive, int rttMs,
                                double score, int successes, int failures,
                                long lastCheck, long lastOk, long tgConnections,
                                long totalSessionMs, long bytesRelayed) {
        ContentValues v = new ContentValues();
        v.put("proxy_id", proxyId);
        v.put("mode", modeCode);
        v.put("last_check", lastCheck);
        v.put("last_ok", lastOk);
        v.put("alive", alive ? 1 : 0);
        v.put("rtt_ms", rttMs);
        v.put("successes", successes);
        v.put("failures", failures);
        v.put("score", score);
        v.put("tg_connections", tgConnections);
        v.put("total_session_ms", totalSessionMs);
        v.put("bytes_relayed", bytesRelayed);
        getWritableDatabase().insertWithOnConflict(PMS, null, v, SQLiteDatabase.CONFLICT_REPLACE);
    }

    /** Folds one probe outcome into the per-mode row for the given proxy
     *  and recomputes its score in-place. */
    public void recordProbe(ProxyEntry p, NetworkMode mode, boolean ok,
                            int rttMs, String detail) {
        SQLiteDatabase db = getWritableDatabase();
        ModeStats prev = modeStatsOf(p.id, mode);
        if (prev == null) {
            prev = new ModeStats();
            prev.proxyId = p.id;
            prev.mode = mode.code;
        }
        long now = System.currentTimeMillis();
        prev.lastCheck = now;
        prev.alive = ok;
        if (ok) {
            prev.successes++;
            prev.rttMs = rttMs;
            prev.lastOk = now;
        } else {
            prev.failures++;
        }
        prev.score = io.autoconnector.engine.check.Rating.computePerMode(
                prev.successes, prev.failures, prev.rttMs, prev.alive);

        ContentValues v = new ContentValues();
        v.put("proxy_id", prev.proxyId);
        v.put("mode", prev.mode);
        v.put("last_check", prev.lastCheck);
        v.put("last_ok", prev.lastOk);
        v.put("alive", prev.alive ? 1 : 0);
        v.put("rtt_ms", prev.rttMs);
        v.put("successes", prev.successes);
        v.put("failures", prev.failures);
        v.put("score", prev.score);
        v.put("tg_connections", prev.tgConnections);
        v.put("total_session_ms", prev.totalSessionMs);
        v.put("bytes_relayed", prev.bytesRelayed);
        db.insertWithOnConflict(PMS, null, v, SQLiteDatabase.CONFLICT_REPLACE);
    }

    /** Marks a successful Telegram relay session and (optionally) accumulates
     *  its duration/bytes — split per network mode, so a host that's only
     *  ever served Telegram under VPN doesn't appear "experienced" on LTE. */
    public void markRelaySuccess(long proxyId, NetworkMode mode, long now) {
        ContentValues v = new ContentValues();
        v.put("proxy_id", proxyId);
        v.put("mode", mode.code);
        v.put("last_check", now);
        v.put("last_ok", now);
        v.put("alive", 1);
        getWritableDatabase().insertWithOnConflict(PMS, null, v,
                SQLiteDatabase.CONFLICT_IGNORE);
        getWritableDatabase().execSQL(
                "UPDATE " + PMS + " SET last_check=?, last_ok=?, alive=1,"
                        + " successes=successes+1 WHERE proxy_id=? AND mode=?",
                new Object[]{now, now, proxyId, mode.code});
    }

    public void modeRecordSession(long proxyId, NetworkMode mode, long durMs, long bytes) {
        ContentValues v = new ContentValues();
        v.put("proxy_id", proxyId);
        v.put("mode", mode.code);
        getWritableDatabase().insertWithOnConflict(PMS, null, v,
                SQLiteDatabase.CONFLICT_IGNORE);
        getWritableDatabase().execSQL(
                "UPDATE " + PMS + " SET tg_connections=tg_connections+1,"
                        + " total_session_ms=total_session_ms+?,"
                        + " bytes_relayed=bytes_relayed+?"
                        + " WHERE proxy_id=? AND mode=?",
                new Object[]{Math.max(0, durMs), Math.max(0, bytes), proxyId, mode.code});
    }

    /** Top-rated alive proxies for the given mode — used by the relay to
     *  pick a failover candidate that actually works on this network. */
    public List<ProxyEntry> topAliveForMode(NetworkMode mode, int limit) {
        return joinedQuery(
                "JOIN " + PMS + " m ON m.proxy_id=p.id AND m.mode=?"
                        + " WHERE m.alive=1 AND m.last_check>0"
                        + " ORDER BY m.score DESC, m.rtt_ms ASC LIMIT ?",
                new String[]{mode.code, String.valueOf(limit)});
    }

    /** Catalog view for one mode: every host probed at least once on this
     *  network, alive ones first, then by rating. Unlike
     *  {@link #topAliveForMode(NetworkMode, int)} this keeps probed-but-dead
     *  hosts so the per-mode Catalog tab shows the full picture. */
    public List<ProxyEntry> topForMode(NetworkMode mode, int limit) {
        return joinedQuery(
                "JOIN " + PMS + " m ON m.proxy_id=p.id AND m.mode=?"
                        + " WHERE (m.last_check>0 OR m.alive=1)"
                        + " ORDER BY m.alive DESC, m.score DESC, m.rtt_ms ASC LIMIT ?",
                new String[]{mode.code, String.valueOf(limit)});
    }

    public List<ProxyEntry> randomAliveForMode(NetworkMode mode, int limit) {
        return joinedQuery(
                "JOIN " + PMS + " m ON m.proxy_id=p.id AND m.mode=?"
                        + " WHERE m.alive=1 AND m.last_check>0"
                        + " ORDER BY RANDOM() LIMIT ?",
                new String[]{mode.code, String.valueOf(limit)});
    }

    public int aliveCountForMode(NetworkMode mode) {
        // JOIN proxies so orphaned PMS rows (left by copy/clear) don't inflate
        // the count — same host set the catalog (topForMode) actually shows.
        return scalar("SELECT COUNT(*) FROM " + PMS + " m JOIN " + T + " p ON p.id=m.proxy_id"
                        + " WHERE m.mode=? AND m.alive=1 AND m.last_check>0",
                new String[]{mode.code});
    }

    /** Average RTT (ms) of the currently-alive proxies — a stable "pool ping"
     *  for the Scan-tab graph, which would otherwise starve to 0 between sparse
     *  probe passes once the pool is full. 0 when nothing is alive. */
    public int avgAliveRtt() {
        return scalar("SELECT CAST(AVG(rtt_ms) AS INT) FROM " + T
                        + " WHERE alive=1 AND rtt_ms>0", null);
    }

    /** Per-mode counterpart of {@link #avgAliveRtt()}. */
    public int avgAliveRttForMode(NetworkMode mode) {
        return scalar("SELECT CAST(AVG(m.rtt_ms) AS INT) FROM " + PMS + " m"
                        + " JOIN " + T + " p ON p.id=m.proxy_id"
                        + " WHERE m.mode=? AND m.alive=1 AND m.rtt_ms>0",
                new String[]{mode.code});
    }

    /** Zeroes every per-mode rating/tally for one network mode while keeping
     *  the rows (and the hosts) in place, so the next scan re-rates this mode
     *  from scratch. The global catalog stats are left untouched. */
    public void resetModeStats(NetworkMode mode) {
        getWritableDatabase().execSQL("UPDATE " + PMS + " SET "
                        + "last_check=0,last_ok=0,rtt_ms=-1,successes=0,"
                        + "failures=0,score=0,tg_connections=0,total_session_ms=0,"
                        + "bytes_relayed=0 WHERE mode=?",
                new Object[]{mode.code});
    }

    /** Forgets every per-mode row for one network mode, so the hosts have no
     *  history on this network at all. The global catalog and the other modes'
     *  rows survive. */
    public void forgetModeHosts(NetworkMode mode) {
        getWritableDatabase().execSQL("DELETE FROM " + PMS + " WHERE mode=?",
                new Object[]{mode.code});
    }

    /** Replaces all per-mode rows of [to] with a copy of [from]'s rows, so the
     *  target mode inherits the source mode's host ratings/alive verbatim. */
    public void copyModeStats(NetworkMode from, NetworkMode to) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + PMS + " WHERE mode=?", new Object[]{to.code});
        db.execSQL("INSERT INTO " + PMS + " (proxy_id, mode, last_check, last_ok, alive, rtt_ms, successes, failures, score, tg_connections, total_session_ms, bytes_relayed) "
            + "SELECT proxy_id, ?, last_check, last_ok, alive, rtt_ms, successes, failures, score, tg_connections, total_session_ms, bytes_relayed FROM " + PMS + " WHERE mode=?",
            new Object[]{to.code, from.code});
    }

    /** Proxies most worth re-probing for the current mode. Mirrors the
     *  global {@link #dueForCheck(int)} tiering but against the per-mode row. */
    public List<ProxyEntry> dueForCheckForMode(NetworkMode mode, int limit) {
        return dueForCheckForMode(mode, limit, 0L);
    }

    /**
     * As {@link #dueForCheckForMode(NetworkMode, int)}, but with an anti-flood
     * floor on the per-mode {@code m.last_check}: a host probed on this mode
     * NEWER than {@code now - minAgeMs} is EXCLUDED. Hosts never probed on this
     * mode ({@code m.last_check} NULL / 0) always stay eligible. {@code minAgeMs
     * <= 0} disables the floor.
     */
    public List<ProxyEntry> dueForCheckForMode(NetworkMode mode, int limit, long minAgeMs) {
        long now = System.currentTimeMillis();
        long cutoff = now - 86_400_000L;
        java.util.ArrayList<String> args = new java.util.ArrayList<>();
        args.add(mode.code);
        java.util.ArrayList<String> conds = new java.util.ArrayList<>();
        if (minAgeMs > 0) {
            conds.add("(m.last_check IS NULL OR m.last_check=0 OR m.last_check<=?)");
            args.add(String.valueOf(now - minAgeMs));
        }
        // Skip hosts already in flight on any concurrent pass (no duplicates).
        String inflight = inFlightCsv();
        if (inflight != null) conds.add("p.id NOT IN (" + inflight + ")");
        String floor = conds.isEmpty() ? "" : " WHERE " + String.join(" AND ", conds);
        args.add(String.valueOf(cutoff));
        args.add(String.valueOf(limit));
        return joinedQuery(
                "LEFT JOIN " + PMS + " m ON m.proxy_id=p.id AND m.mode=?" + floor
                        + " ORDER BY"
                        + " CASE WHEN m.last_check IS NULL OR m.last_check=0 THEN 0"
                        + "      WHEN m.alive=1 THEN 1"
                        + "      WHEN m.last_ok>? THEN 2"
                        + "      ELSE 3 END ASC,"
                        + " COALESCE(m.last_check, 0) ASC LIMIT ?",
                args.toArray(new String[0]));
    }

    /** Aggregate counters for the «Стат» screen — three columns per metric. */
    public static final class ModeAggregate {
        public NetworkMode mode;
        public int total;
        public int alive;
        public int deadProbed;
        public int neverProbed;
        public long sumTgConnections;
        public long sumSessionMs;
        public long sumBytes;
    }

    public ModeAggregate aggregateForMode(NetworkMode mode) {
        ModeAggregate a = new ModeAggregate();
        a.mode = mode;
        a.total = scalar("SELECT COUNT(*) FROM " + T, null);
        Cursor c = getReadableDatabase().rawQuery(
                "SELECT"
                        + " SUM(CASE WHEN m.alive=1 AND m.last_check>0 THEN 1 ELSE 0 END),"
                        + " SUM(CASE WHEN m.alive=0 AND m.last_check>0 THEN 1 ELSE 0 END),"
                        + " SUM(m.tg_connections), SUM(m.total_session_ms), SUM(m.bytes_relayed)"
                        + " FROM " + PMS + " m JOIN " + T + " p ON p.id=m.proxy_id WHERE m.mode=?",
                new String[]{mode.code});
        try {
            if (c.moveToFirst()) {
                a.alive = c.getInt(0);
                a.deadProbed = c.getInt(1);
                a.sumTgConnections = c.getLong(2);
                a.sumSessionMs = c.getLong(3);
                a.sumBytes = c.getLong(4);
            }
        } finally {
            c.close();
        }
        a.neverProbed = Math.max(0, a.total - a.alive - a.deadProbed);
        return a;
    }

    private List<ProxyEntry> joinedQuery(String tail, String[] args) {
        List<ProxyEntry> out = new ArrayList<>();
        Cursor c = getReadableDatabase().rawQuery(
                "SELECT p.* FROM " + T + " p " + tail, args);
        try {
            while (c.moveToNext()) out.add(read(c));
        } finally {
            c.close();
        }
        return out;
    }

    private static ModeStats readModeStats(Cursor c) {
        ModeStats s = new ModeStats();
        s.proxyId = c.getLong(c.getColumnIndexOrThrow("proxy_id"));
        s.mode = c.getString(c.getColumnIndexOrThrow("mode"));
        s.lastCheck = c.getLong(c.getColumnIndexOrThrow("last_check"));
        s.lastOk = c.getLong(c.getColumnIndexOrThrow("last_ok"));
        s.alive = c.getInt(c.getColumnIndexOrThrow("alive")) != 0;
        s.rttMs = c.getInt(c.getColumnIndexOrThrow("rtt_ms"));
        s.successes = c.getInt(c.getColumnIndexOrThrow("successes"));
        s.failures = c.getInt(c.getColumnIndexOrThrow("failures"));
        s.score = c.getDouble(c.getColumnIndexOrThrow("score"));
        s.tgConnections = c.getLong(c.getColumnIndexOrThrow("tg_connections"));
        s.totalSessionMs = c.getLong(c.getColumnIndexOrThrow("total_session_ms"));
        s.bytesRelayed = c.getLong(c.getColumnIndexOrThrow("bytes_relayed"));
        return s;
    }
}
