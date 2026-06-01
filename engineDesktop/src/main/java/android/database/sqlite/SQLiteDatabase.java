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
import java.util.concurrent.locks.ReentrantLock;

import io.autoconnector.platform.SnapshotCursor;

/**
 * Desktop shim for {@code android.database.sqlite.SQLiteDatabase}, backed by the
 * embedded {@code org.xerial:sqlite-jdbc} driver. It implements exactly the
 * surface {@code ProxyStore} uses: {@code execSQL}, {@code rawQuery},
 * {@code insertWithOnConflict}, {@code update} and transactions.
 *
 * <p><b>Concurrency.</b> Android's SQLiteDatabase serialises access internally;
 * a single JDBC {@link Connection} is not thread-safe, so every operation is
 * guarded by a {@link ReentrantLock}. {@code beginTransaction} acquires the lock
 * and {@code endTransaction} releases it, so a bulk insert is atomic against
 * other engine threads while nested calls on the same thread re-enter freely.
 * Reads are snapshotted (see {@link SnapshotCursor}) so no live ResultSet is
 * ever held across the lock.
 */
public final class SQLiteDatabase {

    /** Conflict algorithms — values match Android's so engine constants line up. */
    public static final int CONFLICT_IGNORE = 4;
    public static final int CONFLICT_REPLACE = 5;

    /** Marker interface kept only so {@code SQLiteOpenHelper}'s ctor signature matches. */
    public interface CursorFactory { }

    private final Connection conn;
    private final ReentrantLock lock = new ReentrantLock();
    private boolean txnSuccess = false;

    private SQLiteDatabase(Connection conn) {
        this.conn = conn;
    }

    static SQLiteDatabase open(File file) {
        try {
            //noinspection ResultOfMethodCallIgnored
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:" + file.getAbsolutePath());
            c.setAutoCommit(true);
            return new SQLiteDatabase(c);
        } catch (Exception e) {
            throw new RuntimeException("cannot open sqlite db " + file, e);
        }
    }

    // --- schema version (PRAGMA user_version), used by SQLiteOpenHelper --------

    int getUserVersion() {
        lock.lock();
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("PRAGMA user_version")) {
            return rs.next() ? rs.getInt(1) : 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    void setUserVersion(int v) {
        execSQL("PRAGMA user_version = " + v);
    }

    // --- writes ---------------------------------------------------------------

    public void execSQL(String sql) {
        lock.lock();
        try (Statement st = conn.createStatement()) {
            st.execute(sql);
        } catch (Exception e) {
            throw new RuntimeException("execSQL failed: " + sql, e);
        } finally {
            lock.unlock();
        }
    }

    public void execSQL(String sql, Object[] bindArgs) {
        lock.lock();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            bind(ps, bindArgs, 1);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("execSQL failed: " + sql, e);
        } finally {
            lock.unlock();
        }
    }

    public Cursor rawQuery(String sql, String[] selectionArgs) {
        lock.lock();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            if (selectionArgs != null) {
                for (int i = 0; i < selectionArgs.length; i++) {
                    ps.setString(i + 1, selectionArgs[i]);
                }
            }
            try (ResultSet rs = ps.executeQuery()) {
                return new SnapshotCursor(rs);
            }
        } catch (Exception e) {
            throw new RuntimeException("rawQuery failed: " + sql, e);
        } finally {
            lock.unlock();
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
        lock.lock();
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
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                bind(ps, vals, 1);
                int changed = ps.executeUpdate();
                if (changed == 0) return -1L; // OR IGNORE skipped an existing row
            }
            try (Statement st = conn.createStatement();
                 ResultSet rs = st.executeQuery("SELECT last_insert_rowid()")) {
                return rs.next() ? rs.getLong(1) : -1L;
            }
        } catch (Exception e) {
            throw new RuntimeException("insert failed into " + table, e);
        } finally {
            lock.unlock();
        }
    }

    /** {@code UPDATE table SET col=? … WHERE <where>} with values then whereArgs bound. */
    public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
        lock.lock();
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
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                int idx = bind(ps, vals, 1);
                if (whereArgs != null) {
                    for (String a : whereArgs) ps.setString(idx++, a);
                }
                return ps.executeUpdate();
            }
        } catch (Exception e) {
            throw new RuntimeException("update failed on " + table, e);
        } finally {
            lock.unlock();
        }
    }

    // --- transactions ---------------------------------------------------------

    public void beginTransaction() {
        lock.lock(); // held until endTransaction()
        try {
            conn.setAutoCommit(false);
            txnSuccess = false;
        } catch (Exception e) {
            lock.unlock();
            throw new RuntimeException(e);
        }
    }

    public void setTransactionSuccessful() {
        txnSuccess = true;
    }

    public void endTransaction() {
        try {
            if (txnSuccess) conn.commit(); else conn.rollback();
            conn.setAutoCommit(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            txnSuccess = false;
            lock.unlock();
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
