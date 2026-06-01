package android.database.sqlite;

import android.content.Context;

import java.io.File;

/**
 * Desktop shim for {@code android.database.sqlite.SQLiteOpenHelper}. It opens (or
 * creates) the SQLite file under the app data dir and drives the same
 * create/upgrade lifecycle Android does, tracking the schema version in
 * {@code PRAGMA user_version} (Android's own mechanism). Subclasses
 * ({@code ProxyStore}) implement {@link #onCreate}/{@link #onUpgrade} unchanged.
 */
public abstract class SQLiteOpenHelper {

    private final Context context;
    private final String name;
    private final int version;
    private SQLiteDatabase db;

    public SQLiteOpenHelper(Context context, String name,
                            SQLiteDatabase.CursorFactory factory, int version) {
        this.context = context;
        this.name = name;
        this.version = version;
    }

    public abstract void onCreate(SQLiteDatabase db);

    public abstract void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);

    public void onConfigure(SQLiteDatabase db) { }

    public void onOpen(SQLiteDatabase db) { }

    public SQLiteDatabase getWritableDatabase() {
        return open();
    }

    public SQLiteDatabase getReadableDatabase() {
        return open();
    }

    public synchronized void close() {
        db = null;
    }

    private synchronized SQLiteDatabase open() {
        if (db != null) return db;
        File path = context.getDatabasePath(name);
        SQLiteDatabase opened = SQLiteDatabase.open(path);
        onConfigure(opened);
        int current = opened.getUserVersion();
        if (current == 0) {
            opened.beginTransaction();
            try {
                onCreate(opened);
                opened.setUserVersion(version);
                opened.setTransactionSuccessful();
            } finally {
                opened.endTransaction();
            }
        } else if (current < version) {
            opened.beginTransaction();
            try {
                onUpgrade(opened, current, version);
                opened.setUserVersion(version);
                opened.setTransactionSuccessful();
            } finally {
                opened.endTransaction();
            }
        }
        onOpen(opened);
        db = opened;
        return db;
    }
}
