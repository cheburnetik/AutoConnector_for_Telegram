package io.autoconnector.engine.scan;

import io.autoconnector.engine.model.ProxyEntry;
import io.autoconnector.engine.model.ProxyType;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Extracts proxy entries from an arbitrary blob of text. Handles the common
 * representations found on public proxy pages:
 *
 * <ul>
 *   <li>{@code tg://proxy?server=..&port=..&secret=..}</li>
 *   <li>{@code https://t.me/proxy?...} and {@code https://t.me/socks?...}</li>
 *   <li>bare {@code host:port:secret} (MTProto)</li>
 *   <li>bare {@code host:port} (SOCKS5)</li>
 * </ul>
 *
 * De-duplication is handled later by the store; this class only parses.
 */
public final class ProxyParser {

    private ProxyParser() {}

    /** tg:// or t.me/ proxy|socks links anywhere in the text. */
    private static final Pattern URL_PROXY = Pattern.compile(
            "(?:tg://|https?://t\\.me/|t\\.me/)(proxy|socks)\\?([^\\s\"'<>)\\]]+)",
            Pattern.CASE_INSENSITIVE);

    /** Stand-alone {@code server=H&port=P&secret=S} parameter string (no scheme). */
    private static final Pattern PARAMS_MT = Pattern.compile(
            "server=([a-zA-Z0-9._\\-]+)&(?:amp;)?port=(\\d{1,5})&(?:amp;)?secret=([A-Za-z0-9+/=_\\-]+)",
            Pattern.CASE_INSENSITIVE);

    /** bare host:port:secret — secret as a hex string (>= 32 hex chars). */
    private static final Pattern BARE_MT = Pattern.compile(
            "(?<![\\w.])([a-zA-Z0-9][a-zA-Z0-9.\\-]{1,253}):(\\d{1,5}):([0-9a-fA-F]{32,})(?![\\w])");

    /** bare host:port — domain-with-TLD or IPv4. */
    private static final Pattern BARE_HP = Pattern.compile(
            "(?<![\\w.])((?:\\d{1,3}\\.){3}\\d{1,3}|[a-zA-Z0-9][a-zA-Z0-9.\\-]+\\.[a-zA-Z]{2,}):(\\d{1,5})(?![\\w:.])");

    /** A flat JSON-ish object (no nested braces) — proxy APIs emit arrays of
     *  {@code {"host":..,"port":..,"secret":..}}. Field ORDER is not assumed. */
    private static final Pattern JSON_OBJ = Pattern.compile("\\{[^{}]{0,600}\\}");
    private static final Pattern J_HOST = Pattern.compile(
            "\"(?:host|ip|server|address|addr)\"\\s*:\\s*\"([^\"]+)\"", Pattern.CASE_INSENSITIVE);
    private static final Pattern J_PORT = Pattern.compile(
            "\"port\"\\s*:\\s*\"?(\\d{1,5})\"?", Pattern.CASE_INSENSITIVE);
    private static final Pattern J_SECRET = Pattern.compile(
            "\"secret\"\\s*:\\s*\"([^\"]*)\"", Pattern.CASE_INSENSITIVE);

    /** {@code atob('BASE64')} blobs — many sites hide their list inside an
     *  eval(atob(..)) wrapper to defeat naive scrapers. */
    private static final Pattern ATOB = Pattern.compile(
            "atob\\(\\s*['\"]([A-Za-z0-9+/=_\\-]{32,})['\"]\\s*\\)");
    /** A whole body that is just one base64 token (V2Ray-style subscriptions). */
    private static final Pattern WHOLE_B64 = Pattern.compile("^[A-Za-z0-9+/=_\\-\\s]+$");

    private static final int MAX_DEPTH = 3;

    /**
     * @param text        raw page body
     * @param source      page URL, stored for provenance
     * @param bareDefault type assigned to bare {@code host:port} lines
     */
    public static List<ProxyEntry> parse(String text, String source, ProxyType bareDefault) {
        List<ProxyEntry> out = new ArrayList<>();
        parse(text, source, bareDefault, 0, out);
        return out;
    }

    private static void parse(String text, String source, ProxyType bareDefault,
                              int depth, List<ProxyEntry> out) {
        if (text == null || text.isEmpty() || depth > MAX_DEPTH) return;

        // 1a) URL-form proxies — scan the whole blob.
        Matcher m = URL_PROXY.matcher(text);
        while (m.find()) {
            String kind = m.group(1).toLowerCase();
            String query = m.group(2);
            String host = firstNonNull(qparam(query, "server"), qparam(query, "host"));
            int port = parsePort(qparam(query, "port"));
            if (host == null || port < 0) continue;
            if ("socks".equals(kind)) {
                out.add(new ProxyEntry(ProxyType.SOCKS5, host, port, null, source));
            } else {
                String secret = normSecret(qparam(query, "secret"));
                if (secret == null) {
                    // tg://proxy? with user/pass and no secret is a SOCKS5
                    // advertisement (Telegram accepts both forms).
                    if (qparam(query, "user") != null || qparam(query, "pass") != null) {
                        out.add(new ProxyEntry(ProxyType.SOCKS5, host, port, null, source));
                    }
                    continue;
                }
                out.add(new ProxyEntry(ProxyType.MTPROTO, host, port, secret, source));
            }
        }

        // 1b) Free-standing server=&port=&secret= parameter strings (catalogue pages).
        Matcher pm = PARAMS_MT.matcher(text);
        while (pm.find()) {
            int port = parsePort(pm.group(2));
            if (port < 0) continue;
            out.add(new ProxyEntry(ProxyType.MTPROTO, pm.group(1), port,
                    normSecret(pm.group(3)), source));
        }

        // 2) Bare line forms — one proxy per line.
        for (String raw : text.split("\\r?\\n")) {
            String line = raw.trim();
            if (line.isEmpty() || line.startsWith("#") || line.startsWith("//")) continue;
            if (line.contains("proxy?") || line.contains("socks?")) continue; // handled above

            Matcher mt = BARE_MT.matcher(line);
            if (mt.find()) {
                int port = parsePort(mt.group(2));
                if (port >= 0) {
                    out.add(new ProxyEntry(ProxyType.MTPROTO, mt.group(1), port,
                            normSecret(mt.group(3)), source));
                }
                continue;
            }
            Matcher hp = BARE_HP.matcher(line);
            if (hp.find()) {
                int port = parsePort(hp.group(2));
                if (port >= 0) {
                    out.add(new ProxyEntry(bareDefault, hp.group(1), port, null, source));
                }
            }
        }

        // 3) JSON objects — {"host":..,"port":..,"secret":..} in any field order.
        //    Covers proxy-list APIs (e.g. mtpro.xyz) that emit a JSON array.
        Matcher jo = JSON_OBJ.matcher(text);
        while (jo.find()) {
            String obj = jo.group();
            Matcher jh = J_HOST.matcher(obj);
            Matcher jp = J_PORT.matcher(obj);
            if (!jh.find() || !jp.find()) continue;
            int port = parsePort(jp.group(1));
            if (port < 0) continue;
            Matcher js = J_SECRET.matcher(obj);
            String secret = js.find() ? normSecret(js.group(1)) : null;
            out.add(new ProxyEntry(secret != null ? ProxyType.MTPROTO : bareDefault,
                    jh.group(1), port, secret, source));
        }

        // 4) De-obfuscation: decode atob('…') blobs (sites hide their list in an
        //    eval(atob(..)) wrapper) and re-scan the decoded text.
        Matcher ab = ATOB.matcher(text);
        while (ab.find()) {
            String dec = b64decode(ab.group(1));
            if (dec != null && !dec.isEmpty()) parse(dec, source, bareDefault, depth + 1, out);
        }

        // 5) Whole-body base64 (V2Ray-style subscription) — only when nothing else
        //    matched, to avoid mangling normal pages.
        if (out.isEmpty() && depth == 0) {
            String trimmed = text.trim();
            if (trimmed.length() >= 40 && trimmed.length() <= MAX_B64_BODY
                    && WHOLE_B64.matcher(trimmed).matches()) {
                String dec = b64decode(trimmed);
                if (dec != null && !dec.isEmpty() && !dec.equals(trimmed)) {
                    parse(dec, source, bareDefault, depth + 1, out);
                }
            }
        }
    }

    private static final int MAX_B64_BODY = 4 * 1024 * 1024;

    /** Minimal, dependency-free base64 decoder (standard + URL-safe alphabets,
     *  whitespace tolerated, padding optional). Returns null on malformed input.
     *  java.util.Base64 needs API 26 and minSdk here is 24, so we roll our own. */
    private static String b64decode(String in) {
        if (in == null) return null;
        int[] inv = B64_INV;
        byte[] buf = new byte[in.length() * 3 / 4 + 3];
        int outLen = 0, accum = 0, bits = 0;
        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            if (c == '=' || c == '\n' || c == '\r' || c == ' ' || c == '\t') continue;
            int v = (c < 128) ? inv[c] : -1;
            if (v < 0) continue;          // skip stray chars rather than fail
            accum = (accum << 6) | v;
            bits += 6;
            if (bits >= 8) {
                bits -= 8;
                buf[outLen++] = (byte) ((accum >> bits) & 0xFF);
            }
        }
        try {
            return new String(buf, 0, outLen, "UTF-8");
        } catch (Exception e) {
            return null;
        }
    }

    private static final int[] B64_INV = buildB64Inv();
    private static int[] buildB64Inv() {
        int[] t = new int[128];
        for (int i = 0; i < 128; i++) t[i] = -1;
        String std = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        for (int i = 0; i < std.length(); i++) t[std.charAt(i)] = i;
        t['-'] = 62; t['_'] = 63;        // URL-safe alphabet maps onto +,/
        return t;
    }

    private static String qparam(String query, String key) {
        // Decode HTML-encoded ampersand so links coming from HTML pages
        // (where "?a=1&b=2" arrives as "?a=1&amp;b=2") split correctly.
        String q = query.replace("&amp;", "&");
        for (String pair : q.split("&")) {
            int eq = pair.indexOf('=');
            if (eq <= 0) continue;
            if (pair.substring(0, eq).equalsIgnoreCase(key)) {
                return urlDecode(pair.substring(eq + 1));
            }
        }
        return null;
    }

    private static String urlDecode(String s) {
        try {
            return URLDecoder.decode(s, "UTF-8");
        } catch (Exception e) {
            return s;
        }
    }

    private static int parsePort(String s) {
        if (s == null) return -1;
        try {
            int p = Integer.parseInt(s.trim());
            return (p > 0 && p <= 65535) ? p : -1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Lower-cases hex secrets (case-insensitive); leaves base64url secrets
     * untouched since their case is significant.
     */
    private static String normSecret(String s) {
        if (s == null) return null;
        s = s.trim();
        if (s.isEmpty()) return null;
        if (s.matches("[0-9a-fA-F]+") && s.length() % 2 == 0) {
            return s.toLowerCase();
        }
        return s;
    }

    private static String firstNonNull(String a, String b) {
        return a != null ? a : b;
    }
}
