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

    /**
     * @param text        raw page body
     * @param source      page URL, stored for provenance
     * @param bareDefault type assigned to bare {@code host:port} lines
     */
    public static List<ProxyEntry> parse(String text, String source, ProxyType bareDefault) {
        List<ProxyEntry> out = new ArrayList<>();
        if (text == null || text.isEmpty()) return out;

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
        return out;
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
