package io.autoconnector.engine.scan;

import io.autoconnector.engine.db.ProxyStore;
import io.autoconnector.engine.model.ProxyEntry;
import io.autoconnector.engine.model.ProxyType;
import io.autoconnector.engine.traffic.TrafficMeter;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Downloads a configured page, parses proxies out of it, stores the
 * de-duplicated result and produces a structured {@link ScanResult} so the
 * UI can show exactly what went wrong if anything did.
 *
 * <p>Each scan iterates {@link Mirrors#alternatives mirrors} for the URL
 * (direct first, then GitHub proxies / Wayback) and stops at the first one
 * that responds successfully. For {@code t.me/s/<channel>} URLs the initial
 * page only carries the latest ~20 messages, so we additionally walk the
 * {@code ?before=<msgId>} endpoint a couple of times to scoop up older
 * messages — that simulates the user scrolling up.
 */
public final class PageScanner {

    /** Sink for human-readable progress lines. */
    public interface Log {
        void line(String s);
    }

    /** Outcome of one scan pass over a single source URL. */
    public static final class ScanResult {
        /** Proxies parsed out of the page (across all sources of the URL). */
        public int found;
        /** New rows actually inserted (after de-duplication). */
        public int added;
        /** Final mirror URL that succeeded, or {@code null} if all failed. */
        public String usedUrl;
        /**
         * Non-null when the scan failed: the URL couldn't be downloaded, or
         * downloaded but parsed zero proxies. Used as the per-source error
         * banner in settings.
         */
        public String error;
    }

    /**
     * Seed pages the app ships with. Every entry is one of:
     * <ul>
     *   <li>An HTML catalogue page that embeds {@code tg://proxy?…} or
     *       {@code https://t.me/proxy?…} links anywhere in the markup.</li>
     *   <li>A Telegram channel web preview ({@code t.me/s/<channel>}) — also
     *       HTML with embedded proxy links; older messages are scrolled in via
     *       {@code ?before=<id>}.</li>
     *   <li>A GitHub raw text file with one
     *       {@code https://t.me/proxy?server=…&port=…&secret=…} per line.</li>
     * </ul>
     */
    public static final String[] DEFAULT_PAGES = {
            // HTML catalogue sites
            "https://widum.ru/proxy/",
            "https://free-telegram.link/",
            "https://mtproto.cloud/",
            "https://vanced.to/telegram/",
            "https://daintycloud.com/proxy-telegram-free-mtproto-proxy-list-real-time-updates/",
            "https://mtpro.xyz/mtproto-ru",
            // Telegram channel previews
            "https://t.me/s/ProXyMTproto",
            "https://t.me/s/TelMTProto",
            "https://t.me/s/MTProtoProxies",
            "https://t.me/s/proxymtproto",
            "https://t.me/s/mtp4tg",
            "https://t.me/s/TURKMEN_VPNLAR",
            "https://t.me/s/proxy_tm_unlimited",
            "https://tgstat.com/channel/@TURKMEN_VPNLAR",
            // GitHub raw plain-text lists
            "https://raw.githubusercontent.com/ALIILAPRO/MTProtoProxy/main/mtproto.txt",
            "https://raw.githubusercontent.com/Grim1313/mtproto-for-telegram/master/all_proxies.txt",
            "https://raw.githubusercontent.com/SoliSpirit/mtproto/master/all_proxies.txt",
            "https://raw.githubusercontent.com/kort0881/telegram-proxy-collector/refs/heads/main/proxy_all.txt",
            "https://raw.githubusercontent.com/Argh94/Proxy-List/refs/heads/main/MTProto.txt",
            "https://raw.githubusercontent.com/LoneKingCode/free-proxy-db/refs/heads/main/proxies/all.txt",
            "https://raw.githubusercontent.com/V2RAYCONFIGSPOOL/TELEGRAM_PROXY_SUB/refs/heads/main/telegram_proxy_no1.txt",
            "https://raw.githubusercontent.com/V2RAYCONFIGSPOOL/TELEGRAM_PROXY_SUB/refs/heads/main/telegram_proxy_no2.txt",
            "https://raw.githubusercontent.com/V2RAYCONFIGSPOOL/TELEGRAM_PROXY_SUB/refs/heads/main/telegram_proxy_no3.txt",
            "https://raw.githubusercontent.com/V2RAYCONFIGSPOOL/TELEGRAM_PROXY_SUB/refs/heads/main/telegram_proxy_no4.txt",
            // Forum threads (paginated — last pages are walked automatically)
            "https://4pda.to/forum/index.php?showtopic=1119405&st=9999999",
    };

    private static final Pattern TME_CHANNEL = Pattern.compile(
            "(?i)https?://t\\.me/s/[^/?#]+");
    private static final Pattern POST_ID = Pattern.compile(
            "data-post=\"[^/\"]+/(\\d+)\"");
    private static final int TME_SCROLL_PAGES = 8;
    /** Inter-page delay when walking ?before=N so we don't hammer t.me. */
    private static final long TME_SCROLL_DELAY_MS = 1200;
    private static final int MAX_BODY = 8 * 1024 * 1024;

    /** 4pda forum topic (paginated via &st=offset). */
    private static final Pattern TOPIC_4PDA = Pattern.compile(
            "(?i)4pda\\.to/forum/index\\.php\\?[^\\s\"']*showtopic=\\d+");
    /** Any {@code st=<offset>} in the page — used to discover neighbour pages. */
    private static final Pattern ST_OFFSET = Pattern.compile("(?:&amp;|&|\\?)st=(\\d+)");
    /** How many of the last forum pages to walk (incl. the last one). */
    private static final int FORUM_LAST_PAGES = 5;
    private static final long FORUM_PAGE_DELAY_MS = 1200;

    private final ProxyStore store;
    private final Log log;

    public PageScanner(ProxyStore store, Log log) {
        this.store = store;
        this.log = log;
    }

    /** Scans one page, trying mirrors until one works. */
    public ScanResult scanPage(String pageUrl) {
        ScanResult r = new ScanResult();
        // Honour the global stop switch — user can flip «Сканирование» off
        // while a parallelScanAll is in mid-stride; we must respect that
        // between mirror attempts so HTTP fetches stop too.
        if (io.autoconnector.engine.core.ScanGate.isAborted()) {
            r.error = "сканирование отключено";
            return r;
        }
        String body = null;
        String lastWhy = null;

        List<String> alternatives = Mirrors.alternatives(pageUrl);
        for (String alt : alternatives) {
            if (io.autoconnector.engine.core.ScanGate.isAborted()) {
                r.error = "сканирование отключено";
                return r;
            }
            try {
                body = fetch(alt);
                r.usedUrl = alt;
                log.line("✓ скачано: " + shortUrl(alt));
                break;
            } catch (Exception e) {
                lastWhy = errorMessage(e);
                log.line("✗ " + shortUrl(alt) + " — " + lastWhy);
            }
        }

        if (body == null) {
            r.error = "не удалось скачать (попыток " + alternatives.size()
                    + ", последняя ошибка: "
                    + (lastWhy != null ? lastWhy : "неизвестная")
                    + "). Возможно блокировка или ссылка неверна.";
            io.autoconnector.engine.traffic.ScanMetrics.INSTANCE.noteSub(false);
            return r;
        }
        // Count the downloaded payload as scan traffic.
        io.autoconnector.engine.traffic.ScanMetrics.INSTANCE.addBytes(body.length());

        // For Telegram channel previews, scroll up a few times so we collect
        // older posts too — the bare URL only carries the latest ~20.
        if (TME_CHANNEL.matcher(pageUrl).matches()) {
            body = augmentWithOlderMessages(pageUrl, body);
        } else if (TOPIC_4PDA.matcher(pageUrl).find()) {
            // 4pda forum topic: the given URL (st=9999999) lands on the LAST
            // page; also walk a few previous pages for fresher coverage.
            body = augmentWith4pdaPages(pageUrl, body);
        }

        List<ProxyEntry> list = ProxyParser.parse(body, pageUrl, ProxyType.SOCKS5);
        r.found = list.size();
        if (r.found == 0) {
            r.error = "контент скачан (" + body.length()
                    + " Б), но в нём не найдено ни одного прокси —"
                    + " возможно сайт сменил формат или контент рендерится через JS.";
            log.line("⚠ " + shortUrl(pageUrl) + " — " + r.error);
            io.autoconnector.engine.traffic.ScanMetrics.INSTANCE.noteSub(false);
            return r;
        }

        r.added = store.addAll(list);
        log.line("→ " + shortUrl(pageUrl) + ": найдено " + r.found
                + ", новых " + r.added);
        io.autoconnector.engine.traffic.ScanMetrics.INSTANCE.noteSub(true);
        return r;
    }

    /** Scans every page; returns the total number of NEW proxies added. */
    public int scanAll(List<String> pages) {
        int total = 0;
        for (String p : pages) {
            total += scanPage(p).added;
        }
        return total;
    }

    // --- t.me scroll-up ---------------------------------------------------

    /**
     * Walks {@code ?before=<id>} backwards a configurable number of times to
     * pull older posts. Adds a small delay between fetches so we don't flood
     * t.me from one phone.
     */
    private String augmentWithOlderMessages(String pageUrl, String initialBody) {
        StringBuilder all = new StringBuilder(initialBody);
        String base = pageUrl.split("\\?")[0];
        String body = initialBody;
        for (int iter = 0; iter < TME_SCROLL_PAGES; iter++) {
            if (io.autoconnector.engine.core.ScanGate.isAborted()) break;
            Long minId = findMinPostId(body);
            if (minId == null || minId <= 1) break;
            try {
                Thread.sleep(TME_SCROLL_DELAY_MS);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                break;
            }
            String url = base + "?before=" + minId;
            try {
                body = fetch(url);
            } catch (Exception e) {
                log.line("↓ дочитка " + shortUrl(url) + " прервана: "
                        + errorMessage(e));
                break;
            }
            if (body.isEmpty()) break;
            all.append('\n').append(body);
            log.line("↓ дочитал старые посты до #" + minId
                    + " (+" + body.length() + " Б)");
        }
        return all.toString();
    }

    /**
     * Walks the last few pages of a 4pda forum topic. The incoming URL uses
     * {@code st=9999999}, so 4pda serves the LAST page; its pagination tells us
     * the real last offset and the per-page step, and we read the previous
     * {@link #FORUM_LAST_PAGES}-1 pages too. Degrades to the single last page
     * if pagination can't be parsed.
     */
    private String augmentWith4pdaPages(String pageUrl, String initialBody) {
        // Collect the st offsets present in the page's pagination.
        java.util.TreeSet<Integer> offs = new java.util.TreeSet<>();
        Matcher m = ST_OFFSET.matcher(initialBody);
        while (m.find()) {
            try {
                int v = Integer.parseInt(m.group(1));
                if (v >= 0 && v < 9_000_000) offs.add(v);
            } catch (NumberFormatException ignored) {}
        }
        if (offs.isEmpty()) return initialBody;

        int lastSt = offs.last();
        // Step = smallest positive gap between adjacent offsets (posts per page),
        // falling back to the 4pda default of 20.
        int step = 20;
        Integer prev = null;
        int minGap = Integer.MAX_VALUE;
        for (int v : offs) {
            if (prev != null && v - prev > 0) minGap = Math.min(minGap, v - prev);
            prev = v;
        }
        if (minGap != Integer.MAX_VALUE) step = minGap;

        String base = pageUrl.replaceAll("(?i)(&amp;|&)st=\\d+", "");
        StringBuilder all = new StringBuilder(initialBody);
        for (int k = 1; k < FORUM_LAST_PAGES; k++) {
            if (io.autoconnector.engine.core.ScanGate.isAborted()) break;
            int targetSt = lastSt - step * k;
            if (targetSt < 0) break;
            try {
                Thread.sleep(FORUM_PAGE_DELAY_MS);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                break;
            }
            String url = base + (base.contains("?") ? "&" : "?") + "st=" + targetSt;
            try {
                String b = fetch(url);
                if (b.isEmpty()) break;
                io.autoconnector.engine.traffic.ScanMetrics.INSTANCE.addBytes(b.length());
                all.append('\n').append(b);
                log.line("↓ 4pda: дочитал страницу st=" + targetSt + " (+" + b.length() + " Б)");
            } catch (Exception e) {
                log.line("↓ 4pda st=" + targetSt + " прервана: " + errorMessage(e));
                break;
            }
        }
        return all.toString();
    }

    private static Long findMinPostId(String html) {
        Matcher m = POST_ID.matcher(html);
        long min = Long.MAX_VALUE;
        while (m.find()) {
            try {
                long id = Long.parseLong(m.group(1));
                if (id < min) min = id;
            } catch (NumberFormatException ignored) {
            }
        }
        return min == Long.MAX_VALUE ? null : min;
    }

    // --- fetch -------------------------------------------------------------

    private static String fetch(String urlStr) throws Exception {
        HttpURLConnection c = (HttpURLConnection) new URL(urlStr).openConnection();
        c.setConnectTimeout(15000);
        c.setReadTimeout(20000);
        c.setInstanceFollowRedirects(true);
        c.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 14) AppleWebKit/537.36 "
                + "(KHTML, like Gecko) Chrome/120.0.0.0 Mobile Safari/537.36");
        c.setRequestProperty("Accept", "*/*");
        try {
            int code = c.getResponseCode();
            if (code < 200 || code >= 300) {
                throw new RuntimeException("HTTP " + code);
            }
            InputStream in = c.getInputStream();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[8192];
            int n, total = 0;
            while ((n = in.read(buf)) != -1) {
                bos.write(buf, 0, n);
                total += n;
                if (total > MAX_BODY) break;
            }
            TrafficMeter.add(TrafficMeter.Cat.SERVICE, total);
            return new String(bos.toByteArray(), "UTF-8");
        } finally {
            c.disconnect();
        }
    }

    /** Maps a low-level exception into a short, user-readable phrase. */
    private static String errorMessage(Exception e) {
        if (e instanceof UnknownHostException) {
            return "DNS не нашёл хост (возможно блокировка или нет сети)";
        }
        if (e instanceof SocketTimeoutException) {
            return "таймаут соединения";
        }
        if (e instanceof ConnectException) {
            return "не удалось подключиться (возможно заблокировано)";
        }
        String m = e.getMessage();
        return m != null ? m : e.getClass().getSimpleName();
    }

    private static String shortUrl(String u) {
        int s = u.indexOf("://");
        return s < 0 ? u : u.substring(s + 3);
    }
}
