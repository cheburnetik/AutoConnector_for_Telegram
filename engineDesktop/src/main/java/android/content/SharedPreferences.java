package android.content;

/**
 * Desktop shim for {@code android.content.SharedPreferences} — only the typed
 * getters/setters the engine ({@code Prefs}, {@code HandshakeStats}) actually
 * calls. The concrete implementation is a small file-backed store (see
 * {@code io.autoconnector.platform.FilePreferences}).
 */
public interface SharedPreferences {

    int getInt(String key, int defValue);
    long getLong(String key, long defValue);
    float getFloat(String key, float defValue);
    boolean getBoolean(String key, boolean defValue);
    String getString(String key, String defValue);

    Editor edit();

    interface Editor {
        Editor putInt(String key, int value);
        Editor putLong(String key, long value);
        Editor putFloat(String key, float value);
        Editor putBoolean(String key, boolean value);
        Editor putString(String key, String value);
        Editor remove(String key);
        Editor clear();
        void apply();
        boolean commit();
    }
}
