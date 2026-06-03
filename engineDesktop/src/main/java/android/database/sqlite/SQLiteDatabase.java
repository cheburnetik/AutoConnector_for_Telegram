package android.database.sqlite;

import android.content.ContentValues;
import android.database.Cursor;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import io.autoconnector.platform.SnapshotCursor;

/**
 * Desktop shim for {@code android.database.sqlite.SQLiteDatabase}, backed by the
 * embedded {@code org.xerial:sqlite-jdbc} driver. It implements exactly the
 * surface {@code ProxyStore} uses: {@code execSQL}, {@code rawQuery},
 * {@code insertWithOnConflict}, {@code update} and transactions.
 *
 * <p><b>Concurrency — why this matters on desktop.</b> Android's native
 * {@code SQLiteDatabase} lets many threads read at once (WAL). The relay leans
 * hard on that: every fresh Telegram connection runs several proxy-pool queries
 * while picking an upstream, and the background scanner/checker query in
 * parallel. The first desktop port used a <em>single</em> JDBC connection behind
 * one global lock, so all of that serialised onto one thread — which is exactly
 * why connecting through the relay felt "very slow to find a link" on desktop
 * while the identical engine is snappy on Android.
 *
 * <p>This version mirrors Android instead: a small pool of JDBC connections, each
 * opened in <b>WAL</b> mode with a {@code busy_timeout}, so reads run truly
 * concurrently and a writer never blocks readers. There is no Java-level global
 * lock. A transaction pins one connection to the current thread (via a
 * {@link ThreadLocal}) for its whole lifetime, and every nested call on that
 * thread reuses it, so a bulk insert stays atomic without freezing other threads.
 * {@code txnSuccess} is per-thread too (the old single boolean could be clobbered
 * by a concurrent transaction).
 */
public final class SQLiteDatabase {

    /** Conflict algorithms — values match Android's so engine constants line up. */
    public static final int CONFLICT_IGNORE = 4;
    public static final int CONFLICT_REPLACE = 5;

    /** Marker interface kept only so {@code SQLiteOpenHelper}'s ctor signature matches. */
    public interface CursorFactory { }

    /** Max idle connections kept warm; extras are opened on demand and closed on return. */
    private static final int MAX_IDLE = 16;

    private final String url;
    private final Queue<Connection> idle = new ConcurrentLinkedQueue<>();
    /** Connection pinned to a thread for the duration of its open transaction. */
    private final ThreadLocal<Connection> txnConn = new ThreadLocal<>();
    private final ThreadLocal<Boolean> txnSuccess = new ThreadLocal<>();

    private SQLiteDatabase(String url) {
        this.url = url;
    }

    static SQLiteDatabase open(File file) {
        try {
            //noinspection ResultOfMethodCallIgnored
            Class.forName("org.sqlite.JDBC");
            File parent = file.getParentFile();
            if (parent != null) parent.mkdirs();
            SQLiteDatabase db = new SQLiteDatabase("jdbc:sqlite:" + file.getAbsolutePath());
            // Open one connection eagerly so the file + WAL header are created
            // before anyone queries, then hand it to the pool.
            db.recycle(db.newConnection());
            return db;
        } catch (Exception e) {
            throw new RuntimeException("cannot open sqlite db " + file, e);
        }
    }

    private Connection newConnection() throws Exception {
        Connection c = DriverManager.getConnection(url);
        c.setAutoCommit(true);
        try (Statement st = c.createStatement()) {
            // WAL = concurrent readers + a single writer, no reader/writer lock-out.
            st.execute("PRAGMA journal_mode=WAL");
            st.execute("PRAGMA busy_timeout=5000");
            st.execute("PRAGMA synchronous=NORMAL");
        }
        return c;
    }

    /** A connection for a one-shot op: the thread's txn connection if one is open,
     *  otherwise a pooled/fresh one (caller must {@link #recycle} it). */
    private Connection borrow() {
        Connection c = txnConn.get();
        if (c != null) return c;
        return acquire();
    }

    /** A pooled or freshly-opened connection, independent of any transaction. */
    private Connection acquire() {
        Connection c = idle.poll();
        if (c != null) return c;
        try {
            return newConnection();
        } catch (Exception e) {
            throw new RuntimeException("cannot open sqlite connection", e);
        }
    }

    private void recycle(Connection c) {
        if (c == null) return;
        if (txnConn.get() == c) return;       // still owned by an open transaction
        if (idle.size() >= MAX_IDLE) {
            try { c.close(); } catch (Exception ignored) {}
        } else {
            idle.offer(c);
        }
    }

    // --- schema version (PRAGMA user_version), used by SQLiteOpenHelper --------

    int getUserVersion() {
        Connection c = borrow();
        try (Statement st = c.createStatement();
             ResultSet rs = st.executeQuery("PRAGMA user_version")) {
            return rs.next() ? rs.getInt(1) : 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            recycle(c);
        }
    }

    void setUserVersion(int v) {
        execSQL("PRAGMA user_version = " + v);
    }

    // --- writes ---------------------------------------------------------------

    public void execSQL(String sql) {
        Connection c = borrow();
        try (Statement st = c.createStatement()) {
            st.execute(sql);
        } catch (Exception e) {
            throw new RuntimeException("execSQL failed: " + sql, e);
        } finally {
            recycle(c);
        }
    }

    public void execSQL(String sql, Object[] bindArgs) {
        Connection c = borrow();
        try (PreparedStatement ps = c.prepareStatement(sql)) {
            bind(ps, bindArgs, 1);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("execSQL failed: " + sql, e);
        } finally {
            recycle(c);
        }
    }

    public Cursor rawQuery(String sql, String[] selectionArgs) {
        Connection c = borrow();
        try (PreparedStatement ps = c.prepareStatement(sql)) {
            if (selectionArgs != null) {
                for (int i = 0; i < selectionArgs.length; i++) {
                    ps.setString(i + 1, selectionArgs[i]);
                }
            }
            try (ResultSet rs = ps.executeQuery()) {
                // SnapshotCursor materialises the rows eagerly, so the connection
                // is free to return to the pool immediately — no live ResultSet
                // is ever held across threads.
                return new SnapshotCursor(rs);
            }
        } catch (Exception e) {
            throw new RuntimeException("rawQuery failed: " + sql, e);
        } finally {
            recycle(c);
        }
    }

    /**
     * Builds {@code INSERT OR <conflict> INTO table (cols) VALUES (?,…)} and
     * returns the new rowid, or {@code -1} when an IGNORE conflict skipped the
     * row (matching Android's contract that {@code ProxyStore} relies on to tell
     * "freshly inserted" from "already existed").
     */
    public long insertWithOnConflict(String table, String nullColumnHack,
                                     ContentValues values, int conflictAlgorithm) {
        Connection c = borrow();
        try {
            StringBuilder cols = new StringBuilder();
            StringBuilder qs = new StringBuilder();
            Object[] vals = new Object[values.size()];
            int i = 0;
            for (Map.Entry<String, Object> e : values.valueSet()) {
                if (i > 0) { cols.append(','); qs.append(','); }
                cols.append(e.getKey());
                qs.append('?');
                vals[i++] = e.getValue();
            }
            String sql = "INSERT " + conflictClause(conflictAlgorithm) + "INTO " + table
                    + " (" + cols + ") VALUES (" + qs + ")";
            try (PreparedStatement ps = c.prepareStatement(sql)) {
                bind(ps, vals, 1);
                int changed = ps.executeUpdate();
                if (changed == 0) return -1L; // OR IGNORE skipped an existing row
            }
            // Same connection → correct last rowid even with the pool.
            try (Statement st = c.createStatement();
                 ResultSet rs = st.executeQuery("SELECT last_insert_rowid()")) {
                return rs.next() ? rs.getLong(1) : -1L;
            }
        } catch (Exception e) {
            throw new RuntimeException("insert failed into " + table, e);
        } finally {
            recycle(c);
        }
    }

    /** {@code UPDATE table SET col=? … WHERE <where>} with values then whereArgs bound. */
    public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
        Connection c = borrow();
        try {
            StringBuilder set = new StringBuilder();
            Object[] vals = new Object[values.size()];
            int i = 0;
            for (Map.Entry<String, Object> e : values.valueSet()) {
                if (i > 0) set.append(',');
                set.append(e.getKey()).append("=?");
                vals[i++] = e.getValue();
            }
            String sql = "UPDATE " + table + " SET " + set
                    + (whereClause != null && !whereClause.isEmpty() ? " WHERE " + whereClause : "");
            try (PreparedStatement ps = c.prepareStatement(sql)) {
                int idx = bind(ps, vals, 1);
                if (whereArgs != null) {
                    for (String a : whereArgs) ps.setString(idx++, a);
                }
                return ps.executeUpdate();
            }
        } catch (Exception e) {
            throw new RuntimeException("update failed on " + table, e);
        } finally {
            recycle(c);
        }
    }

    // --- transactions ---------------------------------------------------------

    public void beginTransaction() {
        Connection c = acquire();             // a dedicated connection for this txn
        try {
            c.setAutoCommit(false);
            txnConn.set(c);
            txnSuccess.set(Boolean.FALSE);
        } catch (Exception e) {
            recycle(c);
            throw new RuntimeException(e);
        }
    }

    public void setTransactionSuccessful() {
        txnSuccess.set(Boolean.TRUE);
    }

    public void endTransaction() {
        Connection c = txnConn.get();
        if (c == null) return;
        boolean ok = Boolean.TRUE.equals(txnSuccess.get());
        try {
            if (ok) c.commit(); else c.rollback();
            c.setAutoCommit(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            txnConn.remove();
            txnSuccess.remove();
            recycle(c);                       // now unpinned → returns to the pool
        }
    }

    // --- helpers --------------------------------------------------------------

    private static String conflictClause(int algo) {
        switch (algo) {
            case CONFLICT_IGNORE: return "OR IGNORE ";
            case CONFLICT_REPLACE: return "OR REPLACE ";
            default: return "";
        }
    }

    private static int bind(PreparedStatement ps, Object[] args, int start) throws Exception {
        int idx = start;
        if (args != null) {
            for (Object a : args) {
                if (a == null) ps.setObject(idx, null);
                else if (a instanceof Integer) ps.setInt(idx, (Integer) a);
                else if (a instanceof Long) ps.setLong(idx, (Long) a);
                else if (a instanceof Double) ps.setDouble(idx, (Double) a);
                else if (a instanceof Float) ps.setDouble(idx, ((Float) a).doubleValue());
                else if (a instanceof Boolean) ps.setInt(idx, ((Boolean) a) ? 1 : 0);
                else ps.setString(idx, a.toString());
                idx++;
            }
        }
        return idx;
    }
}
