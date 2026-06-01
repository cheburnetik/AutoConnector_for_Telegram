package android.content;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Desktop shim for {@code android.content.ContentValues}: an ordered column→value
 * bag the SQLite shim turns into {@code INSERT}/{@code UPDATE} parameter lists.
 * Insertion order is preserved so generated SQL is stable.
 */
public final class ContentValues {

    private final LinkedHashMap<String, Object> values = new LinkedHashMap<>();

    public void put(String key, String value) { values.put(key, value); }
    public void put(String key, Integer value) { values.put(key, value); }
    public void put(String key, Long value) { values.put(key, value); }
    public void put(String key, Float value) { values.put(key, value); }
    public void put(String key, Double value) { values.put(key, value); }
    public void put(String key, Boolean value) { values.put(key, value == null ? null : (value ? 1 : 0)); }

    public Object get(String key) { return values.get(key); }
    public Set<String> keySet() { return values.keySet(); }
    public Set<Map.Entry<String, Object>> valueSet() { return values.entrySet(); }
    public int size() { return values.size(); }
}
