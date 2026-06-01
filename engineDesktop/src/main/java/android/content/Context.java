package android.content;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import io.autoconnector.platform.FilePreferences;

/**
 * Desktop shim for {@code android.content.Context}. On Android the Context is
 * the gateway to per-app storage and system services; here it is a thin holder
 * of an app data directory plus the two services the engine asks for:
 * {@link SharedPreferences} (file-backed) and the connectivity manager.
 *
 * <p>The engine treats Context as an opaque token (it stores it, passes it to
 * {@code Prefs}/{@code ProxyStore}, and reads prefs/db through it), so this
 * minimal surface is a complete functional stand-in.
 */
public class Context {

    public static final int MODE_PRIVATE = 0;
    public static final String CONNECTIVITY_SERVICE = "connectivity";

    private final File dataDir;
    private final Map<String, SharedPreferences> prefsCache = new HashMap<>();

    public Context(File dataDir) {
        this.dataDir = dataDir;
        //noinspection ResultOfMethodCallIgnored
        dataDir.mkdirs();
    }

    public Context getApplicationContext() {
        return this;
    }

    public synchronized SharedPreferences getSharedPreferences(String name, int mode) {
        return prefsCache.computeIfAbsent(name,
                n -> new FilePreferences(new File(dataDir, n + ".prefs")));
    }

    /** Resolves the on-disk path for a SQLite database file (used by the helper). */
    public File getDatabasePath(String name) {
        File dir = new File(dataDir, "databases");
        //noinspection ResultOfMethodCallIgnored
        dir.mkdirs();
        return new File(dir, name);
    }

    public File getFilesDir() {
        return dataDir;
    }

    public Object getSystemService(String name) {
        if (CONNECTIVITY_SERVICE.equals(name)) {
            return new android.net.ConnectivityManager();
        }
        return null;
    }
}
