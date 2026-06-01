package android.database;

/**
 * Desktop shim for {@code android.database.Cursor} — the read surface the
 * engine's {@code ProxyStore} uses. Column indices are 0-based, matching
 * Android (the JDBC-backed implementation translates to 1-based internally).
 */
public interface Cursor extends AutoCloseable {
    boolean moveToFirst();
    boolean moveToNext();
    int getColumnIndexOrThrow(String name);
    int getColumnIndex(String name);
    int getCount();
    boolean isNull(int columnIndex);
    int getInt(int columnIndex);
    long getLong(int columnIndex);
    double getDouble(int columnIndex);
    String getString(int columnIndex);
    @Override void close();
}
