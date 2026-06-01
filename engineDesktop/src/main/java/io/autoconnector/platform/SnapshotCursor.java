package io.autoconnector.platform;

import android.database.Cursor;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * A {@link Cursor} that eagerly copies an entire {@link ResultSet} into memory
 * and then closes the JDBC resources. This deliberately diverges from Android's
 * lazy window cursor for one reason: the engine hits a single shared SQLite
 * connection from several threads (poll loop, scan workers, relay), and holding
 * a live JDBC ResultSet open across that would race. Snapshotting keeps each
 * query's rows immutable and lets the connection lock release immediately.
 *
 * <p>Every query in {@code ProxyStore} is bounded (counts, or {@code LIMIT}ed
 * lists), so the in-memory copy stays small.
 */
public final class SnapshotCursor implements Cursor {

    private final List<Object[]> rows = new ArrayList<>();
    private final Map<String, Integer> colIndex = new HashMap<>(); // lower-cased name -> 0-based
    private int pos = -1;

    public SnapshotCursor(ResultSet rs) throws Exception {
        ResultSetMetaData md = rs.getMetaData();
        int n = md.getColumnCount();
        for (int i = 1; i <= n; i++) {
            // getColumnLabel honours "AS" aliases and bare column names alike.
            colIndex.put(md.getColumnLabel(i).toLowerCase(Locale.ROOT), i - 1);
        }
        while (rs.next()) {
            Object[] row = new Object[n];
            for (int i = 1; i <= n; i++) row[i - 1] = rs.getObject(i);
            rows.add(row);
        }
    }

    @Override public boolean moveToFirst() { pos = 0; return !rows.isEmpty(); }

    @Override public boolean moveToNext() { pos++; return pos < rows.size(); }

    @Override public int getColumnIndex(String name) {
        Integer i = colIndex.get(name.toLowerCase(Locale.ROOT));
        return i != null ? i : -1;
    }

    @Override public int getColumnIndexOrThrow(String name) {
        int i = getColumnIndex(name);
        if (i < 0) throw new IllegalArgumentException("column '" + name + "' does not exist");
        return i;
    }

    @Override public int getCount() { return rows.size(); }

    private Object cell(int col) { return rows.get(pos)[col]; }

    @Override public boolean isNull(int col) { return cell(col) == null; }

    @Override public int getInt(int col) {
        Object v = cell(col);
        if (v == null) return 0;
        if (v instanceof Number) return ((Number) v).intValue();
        try { return Integer.parseInt(v.toString()); } catch (Exception e) { return 0; }
    }

    @Override public long getLong(int col) {
        Object v = cell(col);
        if (v == null) return 0L;
        if (v instanceof Number) return ((Number) v).longValue();
        try { return Long.parseLong(v.toString()); } catch (Exception e) { return 0L; }
    }

    @Override public double getDouble(int col) {
        Object v = cell(col);
        if (v == null) return 0d;
        if (v instanceof Number) return ((Number) v).doubleValue();
        try { return Double.parseDouble(v.toString()); } catch (Exception e) { return 0d; }
    }

    @Override public String getString(int col) {
        Object v = cell(col);
        return v == null ? null : v.toString();
    }

    @Override public void close() { /* nothing to release — already snapshotted */ }
}
