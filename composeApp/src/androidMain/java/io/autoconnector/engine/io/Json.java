package io.autoconnector.engine.io;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Tiny self-contained JSON encoder/parser — the project has no JSON dependency
 * and adding one to the desktop bundle is fragile, so this covers exactly what
 * the backup export/import needs: objects (LinkedHashMap, insertion-ordered),
 * arrays (ArrayList), strings, numbers (parsed as Double), booleans and null.
 */
public final class Json {

    private Json() {}

    // ------------------------------------------------------------------ encode

    public static String encode(Object o) {
        StringBuilder sb = new StringBuilder();
        write(sb, o);
        return sb.toString();
    }

    private static void write(StringBuilder sb, Object o) {
        if (o == null) { sb.append("null"); return; }
        if (o instanceof String) { writeString(sb, (String) o); return; }
        if (o instanceof Boolean) { sb.append(o.toString()); return; }
        if (o instanceof Number) {
            double d = ((Number) o).doubleValue();
            if ((o instanceof Double || o instanceof Float)
                    && d == Math.rint(d) && !Double.isInfinite(d)) {
                sb.append(Long.toString((long) d));      // drop the trailing .0
            } else {
                sb.append(o.toString());
            }
            return;
        }
        if (o instanceof Map) {
            sb.append('{');
            boolean first = true;
            for (Map.Entry<?, ?> e : ((Map<?, ?>) o).entrySet()) {
                if (!first) sb.append(',');
                first = false;
                writeString(sb, String.valueOf(e.getKey()));
                sb.append(':');
                write(sb, e.getValue());
            }
            sb.append('}');
            return;
        }
        if (o instanceof Iterable) {
            sb.append('[');
            boolean first = true;
            for (Object item : (Iterable<?>) o) {
                if (!first) sb.append(',');
                first = false;
                write(sb, item);
            }
            sb.append(']');
            return;
        }
        writeString(sb, o.toString());
    }

    private static void writeString(StringBuilder sb, String s) {
        sb.append('"');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '"':  sb.append("\\\""); break;
                case '\\': sb.append("\\\\"); break;
                case '\n': sb.append("\\n");  break;
                case '\r': sb.append("\\r");  break;
                case '\t': sb.append("\\t");  break;
                case '\b': sb.append("\\b");  break;
                case '\f': sb.append("\\f");  break;
                default:
                    if (c < 0x20) sb.append(String.format("\\u%04x", (int) c));
                    else sb.append(c);
            }
        }
        sb.append('"');
    }

    // ------------------------------------------------------------------- parse

    public static Object parse(String s) {
        P p = new P(s);
        p.ws();
        Object v = p.value();
        return v;
    }

    /** Convenience: parse and cast to a JSON object, or empty map on failure. */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> parseObject(String s) {
        try {
            Object o = parse(s);
            if (o instanceof Map) return (Map<String, Object>) o;
        } catch (Exception ignored) {}
        return new LinkedHashMap<>();
    }

    private static final class P {
        final String s;
        int i;
        P(String s) { this.s = s; }

        void ws() { while (i < s.length() && Character.isWhitespace(s.charAt(i))) i++; }

        Object value() {
            ws();
            if (i >= s.length()) throw new RuntimeException("unexpected end of JSON");
            char c = s.charAt(i);
            switch (c) {
                case '{': return obj();
                case '[': return arr();
                case '"': return str();
                case 't': case 'f': return bool();
                case 'n': i += 4; return null;   // null
                default:  return num();
            }
        }

        Map<String, Object> obj() {
            Map<String, Object> m = new LinkedHashMap<>();
            i++;                                  // {
            ws();
            if (i < s.length() && s.charAt(i) == '}') { i++; return m; }
            while (true) {
                ws();
                String k = str();
                ws();
                if (s.charAt(i) != ':') throw new RuntimeException("expected ':'");
                i++;
                m.put(k, value());
                ws();
                char c = s.charAt(i++);
                if (c == '}') break;
                if (c != ',') throw new RuntimeException("expected ',' or '}'");
            }
            return m;
        }

        List<Object> arr() {
            List<Object> l = new ArrayList<>();
            i++;                                  // [
            ws();
            if (i < s.length() && s.charAt(i) == ']') { i++; return l; }
            while (true) {
                l.add(value());
                ws();
                char c = s.charAt(i++);
                if (c == ']') break;
                if (c != ',') throw new RuntimeException("expected ',' or ']'");
            }
            return l;
        }

        String str() {
            ws();
            if (s.charAt(i) != '"') throw new RuntimeException("expected string");
            i++;                                  // opening "
            StringBuilder sb = new StringBuilder();
            while (true) {
                char c = s.charAt(i++);
                if (c == '"') break;
                if (c == '\\') {
                    char e = s.charAt(i++);
                    switch (e) {
                        case '"':  sb.append('"');  break;
                        case '\\': sb.append('\\'); break;
                        case '/':  sb.append('/');  break;
                        case 'n':  sb.append('\n'); break;
                        case 'r':  sb.append('\r'); break;
                        case 't':  sb.append('\t'); break;
                        case 'b':  sb.append('\b'); break;
                        case 'f':  sb.append('\f'); break;
                        case 'u':  sb.append((char) Integer.parseInt(s.substring(i, i + 4), 16)); i += 4; break;
                        default:   sb.append(e);
                    }
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }

        Boolean bool() {
            if (s.startsWith("true", i))  { i += 4; return Boolean.TRUE; }
            if (s.startsWith("false", i)) { i += 5; return Boolean.FALSE; }
            throw new RuntimeException("bad literal");
        }

        Double num() {
            int start = i;
            while (i < s.length()) {
                char c = s.charAt(i);
                if (c == '-' || c == '+' || c == '.' || c == 'e' || c == 'E' || (c >= '0' && c <= '9')) i++;
                else break;
            }
            return Double.parseDouble(s.substring(start, i));
        }
    }
}
