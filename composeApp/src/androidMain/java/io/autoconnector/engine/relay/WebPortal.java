package io.autoconnector.engine.relay;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Tiny embedded HTTP responder that serves an adaptive mobile HTML page listing
 * Telegram proxy links. Pure Java (no Android imports, no third-party libraries)
 * so it compiles for BOTH Android and desktop.
 */
public final class WebPortal {

    private WebPortal() {}

    private static final String GITHUB_URL = "https://github.com/cheburnetik/AutoConnector_for_Telegram";
    private static final String CHAT_URL = "https://t.me/AutoConnector_for_Telegram";
    private static final String APP_NAME = "AutoConnector for Telegram";

    /** One proxy entry shown on the page. */
    public static final class Link {
        public final String label;  // e.g. "1.2.3.4:443"
        public final String sub;    // e.g. "MTProto · FakeTLS · ★9" or "SOCKS5"
        public final String url;    // tg://proxy?... or https://t.me/proxy?... or tg://socks?...
        public Link(String label, String sub, String url) {
            this.label = label;
            this.sub = sub;
            this.url = url;
        }
    }

    /**
     * Reads &amp; discards the incoming HTTP request from {@code in} (read up to the
     * blank line, with a hard cap so it never blocks forever), then writes a full
     * HTTP/1.1 200 response with an adaptive mobile HTML page to {@code out}.
     *
     * @param ip     this device's LAN IPv4 (may be null when offline)
     * @param portA  first relay/SOCKS port (e.g. 55001)
     * @param portB  second relay/SOCKS port (e.g. 55002)
     * @param hosts  the best discovered hosts. Caller closes the socket afterward.
     */
    public static void serveHttp(java.io.InputStream in, java.io.OutputStream out, String ip,
                                 int portA, int portB, java.util.List<Link> hosts) throws java.io.IOException {
        drainRequest(in);
        String html = buildHtml(ip, portA, portB, hosts);
        byte[] body = html.getBytes(StandardCharsets.UTF_8);
        StringBuilder head = new StringBuilder();
        head.append("HTTP/1.1 200 OK\r\n");
        head.append("Content-Type: text/html; charset=utf-8\r\n");
        head.append("Content-Length: ").append(body.length).append("\r\n");
        head.append("Connection: close\r\n");
        head.append("\r\n");
        out.write(head.toString().getBytes(StandardCharsets.ISO_8859_1));
        out.write(body);
        out.flush();
    }

    /**
     * For a TLS ClientHello (first byte 0x16) we cannot speak TLS, so write a
     * minimal plaintext HTTP 200 telling the user to open the http:// URL instead.
     */
    public static void serveTlsHint(OutputStream out, String httpUrl) throws IOException {
        String safeUrl = httpUrl == null ? "" : httpUrl;
        String text = "Откройте " + safeUrl + " (без https) — страница доступна по обычному HTTP.\n";
        byte[] body = text.getBytes(StandardCharsets.UTF_8);
        StringBuilder head = new StringBuilder();
        head.append("HTTP/1.1 200 OK\r\n");
        head.append("Content-Type: text/plain; charset=utf-8\r\n");
        head.append("Content-Length: ").append(body.length).append("\r\n");
        head.append("Connection: close\r\n");
        head.append("\r\n");
        out.write(head.toString().getBytes(StandardCharsets.ISO_8859_1));
        out.write(body);
        out.flush();
    }

    // ----------------------------------------------------------------------

    private static final int MAX_REQUEST_BYTES = 8 * 1024;

    /** Read &amp; discard the request up to the blank line, capped, never blocking forever. */
    private static void drainRequest(InputStream in) throws IOException {
        if (in == null) return;
        int total = 0;
        int s = 0; // state of CRLFCRLF matcher: \r=1 \r\n=2 \r\n\r=3 done=4
        while (total < MAX_REQUEST_BYTES) {
            int b;
            try {
                b = in.read();
            } catch (IOException e) {
                // socket timeout or reset: stop reading, still serve the page
                return;
            }
            if (b < 0) return; // end of stream
            total++;
            switch (s) {
                case 0: s = (b == '\r') ? 1 : 0; break;
                case 1: s = (b == '\n') ? 2 : ((b == '\r') ? 1 : 0); break;
                case 2: s = (b == '\r') ? 3 : 0; break;
                case 3:
                    if (b == '\n') return; // full \r\n\r\n seen
                    s = (b == '\r') ? 1 : 0;
                    break;
                default: return;
            }
        }
    }

    // ----------------------------------------------------------------------

    private static String buildHtml(String ip, int portA, int portB, List<Link> hosts) {
        StringBuilder b = new StringBuilder(8192);
        b.append("<!DOCTYPE html>\n");
        b.append("<html lang=\"ru\">\n<head>\n");
        b.append("<meta charset=\"utf-8\">\n");
        b.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
        b.append("<title>").append(esc(APP_NAME)).append("</title>\n");
        b.append("<style>\n");
        b.append(CSS);
        b.append("</style>\n");
        b.append("</head>\n<body>\n");
        b.append("<div class=\"wrap\">\n");

        // ---------- Header ----------
        b.append("<header>\n");
        b.append("<h1>").append(esc(APP_NAME)).append("</h1>\n");
        b.append("<div class=\"links\">\n");
        b.append("<a class=\"btn\" href=\"").append(escAttr(GITHUB_URL)).append("\" target=\"_blank\">GitHub</a>\n");
        b.append("<a class=\"btn\" href=\"").append(escAttr(CHAT_URL)).append("\" target=\"_blank\">Telegram-чат</a>\n");
        b.append("</div>\n");
        b.append("</header>\n");

        // ---------- Intro ----------
        b.append("<section class=\"intro\">\n");
        b.append("<p>Эта страница открылась, потому что на одном из устройств в вашей сети включена галочка "
                + "«Раздача по локальной сети» в приложении <b>").append(esc(APP_NAME)).append("</b>. "
                + "Чтобы её закрыть — выключите эту галочку в приложении (Ещё → Раздача по локальной сети).</p>\n");
        b.append("<p class=\"warn\">Страница и прокси доступны <b>ВСЕМ</b> устройствам в этой локальной сети — "
                + "дома, на работе, в общественном Wi-Fi. Будьте осторожны: включайте раздачу только в сетях, "
                + "которым доверяете; в публичных сетях ею могут воспользоваться посторонние.</p>\n");
        b.append("<div class=\"info\"><b>Важно:</b> никакие режимы работы ").append(esc(APP_NAME))
         .append(" ни при каких обстоятельствах не позволяют никому — ни вам, ни гостям — перехватить или "
                + "расшифровать вашу переписку. Прокси лишь передаёт уже зашифрованный трафик Telegram и не "
                + "может его прочитать; шифрование гарантирует сам Telegram.</div>\n");
        b.append("</section>\n");

        // ---------- Вариант 1 — установить приложение ----------
        b.append("<section class=\"variant\">\n");
        b.append("<div class=\"card\">\n");
        b.append("<h2>Вариант 1 · Установить приложение</h2>\n");
        b.append("<p>Скачайте <b>").append(esc(APP_NAME)).append("</b> и поставьте на своё устройство — "
                + "оно само найдёт рабочие прокси.</p>\n");
        b.append("<div class=\"btns\">\n");
        b.append("<a class=\"btn primary\" href=\"").append(escAttr(GITHUB_URL))
         .append("\" target=\"_blank\">Открыть на GitHub</a>\n");
        b.append("</div>\n");
        b.append("<p class=\"hint\">или загуглите «").append(esc(APP_NAME)).append("».</p>\n");
        b.append("</div>\n");
        b.append("</section>\n");

        // ---------- Вариант 2 — настроить порты в Telegram ----------
        b.append("<section class=\"variant\">\n");
        b.append("<div class=\"card\">\n");
        b.append("<h2>Вариант 2 · Настроить порты в Telegram</h2>\n");
        if (ip == null) {
            b.append("<p class=\"hint\">У этого устройства нет адреса в локальной сети — подключите его к Wi-Fi.</p>\n");
        } else {
            String urlA = "tg://socks?server=" + ip + "&port=" + portA;
            String urlB = "tg://socks?server=" + ip + "&port=" + portB;

            // №1 — кнопками
            b.append("<div class=\"step\">\n");
            b.append("<div class=\"steptitle\">№1 — кнопками</div>\n");
            b.append("<div class=\"btns\">\n");
            b.append("<a class=\"btn primary\" href=\"").append(escAttr(urlA)).append("\">Прокси ")
             .append(portA).append("</a>\n");
            b.append("<a class=\"btn primary\" href=\"").append(escAttr(urlB)).append("\">Прокси ")
             .append(portB).append("</a>\n");
            b.append("</div>\n");
            b.append("<p class=\"hint\">Нажатие откроет Telegram и предложит включить SOCKS-прокси.</p>\n");
            b.append("</div>\n");

            // №2 — ссылками
            String bothLines = urlA + "\n" + urlB;
            b.append("<div class=\"step\">\n");
            b.append("<div class=\"steptitle\">№2 — ссылками</div>\n");
            b.append("<div class=\"copybox\">\n");
            b.append("<textarea class=\"copytext\" readonly rows=\"2\" onclick=\"this.select()\">")
             .append(esc(bothLines)).append("</textarea>\n");
            b.append("<button class=\"btn copy\" type=\"button\" data-url=\"").append(escAttr(bothLines))
             .append("\">Копировать</button>\n");
            b.append("</div>\n");
            b.append("<p class=\"hint\">Скопируйте и отправьте себе в «Избранное» в Telegram, затем откройте.</p>\n");
            b.append("</div>\n");

            // №3 — вручную
            b.append("<div class=\"step\">\n");
            b.append("<div class=\"steptitle\">№3 — вручную</div>\n");
            b.append("<p>Добавьте в Telegram прокси <b>SOCKS5</b> вручную: Сервер <b>").append(esc(ip))
             .append("</b>, Порт <b>").append(portA).append("</b> или <b>").append(portB)
             .append("</b>, без логина/пароля.</p>\n");
            b.append("<div class=\"chips\">\n");
            b.append(chip("Сервер " + ip, ip));
            b.append(chip("Порт " + portA, String.valueOf(portA)));
            b.append(chip("Порт " + portB, String.valueOf(portB)));
            b.append("</div>\n");
            b.append("</div>\n");

            b.append("<p class=\"hint\">Дальше: в Telegram включите автопереключение прокси.</p>\n");
        }
        b.append("</div>\n");
        b.append("</section>\n");

        // ---------- Вариант 3 — готовые прокси ----------
        b.append("<section class=\"variant\">\n");
        b.append("<div class=\"card\">\n");
        b.append("<h2>Вариант 3 · Готовые прокси</h2>\n");
        b.append("<p class=\"hint\">Нажимайте на любую синюю кнопку, добавляйте в Telegram прокси, потом "
                + "возвращайтесь на эту страницу и снова нажимайте синие кнопки.</p>\n");
        b.append("<p>Скопируйте один или несколько прокси себе — или просто нажмите «Открыть», "
                + "и появится Telegram.</p>\n");
        if (hosts == null || hosts.isEmpty()) {
            b.append("<p class=\"hint\">Пока нет проверенных хостов — зайдите позже.</p>\n");
        } else {
            for (Link l : hosts) {
                if (l == null) continue;
                b.append("<div class=\"row\">\n");
                b.append("<div class=\"rowhead\">\n");
                b.append("<span class=\"rlabel\">").append(esc(l.label)).append("</span>\n");
                b.append("<span class=\"rsub\">").append(esc(l.sub)).append("</span>\n");
                b.append("</div>\n");
                b.append("<div class=\"rowctl\">\n");
                b.append("<input class=\"urlbox\" type=\"text\" readonly value=\"")
                 .append(escAttr(l.url)).append("\" data-url=\"").append(escAttr(l.url))
                 .append("\" onclick=\"this.select()\">\n");
                b.append("<a class=\"ico open\" href=\"").append(escAttr(l.url))
                 .append("\" title=\"Открыть\" aria-label=\"Открыть\">↗</a>\n");
                b.append("<button class=\"ico copy\" type=\"button\" title=\"Копировать\" aria-label=\"Копировать\" data-url=\"")
                 .append(escAttr(l.url)).append("\">⧉</button>\n");
                b.append("</div>\n");
                b.append("</div>\n");
            }
        }
        b.append("</div>\n");
        b.append("</section>\n");

        b.append("</div>\n"); // .wrap
        b.append("<script>\n");
        b.append(JS);
        b.append("</script>\n");
        b.append("</body>\n</html>\n");
        return b.toString();
    }

    /** A small inline "copy chip": visible label + copyable raw value. */
    private static String chip(String label, String value) {
        return "<button class=\"chip copy\" type=\"button\" data-url=\"" + escAttr(value)
                + "\">" + esc(label) + "</button>\n";
    }

    private static final String CSS =
        ":root{color-scheme:dark}\n" +
        "*{box-sizing:border-box}\n" +
        "body{margin:0;background:#0e1116;color:#e6e9ef;" +
        "font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,Helvetica,Arial,sans-serif;" +
        "line-height:1.45;padding:16px}\n" +
        ".wrap{max-width:680px;margin:0 auto}\n" +
        "header{margin:8px 0 20px}\n" +
        "h1{font-size:24px;margin:0 0 12px;line-height:1.2}\n" +
        ".links{display:flex;gap:10px;flex-wrap:wrap}\n" +
        ".intro{margin:0 0 24px}\n" +
        ".intro p{margin:0 0 12px;font-size:14px;color:#cdd5e0}\n" +
        ".intro .warn{background:#2a1f12;border:1px solid #6b4a1f;border-radius:12px;padding:12px 14px;color:#f0d9b5}\n" +
        ".intro .info{background:#12233a;border:1px solid #2b4c78;border-radius:12px;padding:12px 14px;" +
        "font-size:14px;color:#cfe0f5;margin-top:12px}\n" +
        ".variant{margin:0 0 16px}\n" +
        ".card{background:#1a1f29;border:1px solid #262d3a;border-radius:14px;padding:16px}\n" +
        ".card h2{font-size:18px;margin:0 0 10px;line-height:1.25;color:#fff}\n" +
        ".card p{margin:0 0 10px;font-size:14px;color:#cdd5e0}\n" +
        ".hint{margin:8px 0 0;font-size:13px;color:#9aa4b2}\n" +
        ".step{border-top:1px solid #262d3a;padding-top:12px;margin-top:12px}\n" +
        ".step:first-of-type{border-top:0;padding-top:0;margin-top:0}\n" +
        ".steptitle{font-size:14px;font-weight:700;color:#2f81f7;margin-bottom:8px}\n" +
        ".btns{display:flex;gap:10px;margin:10px 0;flex-wrap:wrap}\n" +
        ".btn{flex:1 1 0;min-width:130px;min-height:44px;display:inline-flex;align-items:center;" +
        "justify-content:center;padding:0 16px;border-radius:11px;border:1px solid #303846;" +
        "background:#222a36;color:#e6e9ef;font-size:15px;font-weight:600;text-decoration:none;" +
        "cursor:pointer;-webkit-tap-highlight-color:transparent}\n" +
        ".btn:active{opacity:.7}\n" +
        ".btn.primary{background:#2f81f7;border-color:#2f81f7;color:#fff}\n" +
        ".copybox{display:flex;gap:8px;align-items:stretch;flex-wrap:wrap}\n" +
        ".copytext{flex:1 1 220px;min-width:0;background:#0e1116;color:#cdd5e0;border:1px solid #303846;" +
        "border-radius:9px;padding:8px 10px;font-size:13px;resize:none;" +
        "font-family:ui-monospace,SFMono-Regular,Menlo,Consolas,monospace}\n" +
        ".copytext:focus{outline:none;border-color:#2f81f7}\n" +
        ".copybox .btn{flex:0 0 auto;min-width:120px}\n" +
        ".chips{display:flex;gap:8px;flex-wrap:wrap;margin-top:6px}\n" +
        ".chip{min-height:40px;display:inline-flex;align-items:center;padding:0 12px;border-radius:10px;" +
        "border:1px solid #303846;background:#222a36;color:#e6e9ef;font-size:13px;font-weight:600;" +
        "cursor:pointer;-webkit-tap-highlight-color:transparent}\n" +
        ".chip:active{opacity:.7}\n" +
        ".row{background:#12161e;border:1px solid #262d3a;border-radius:11px;padding:9px 10px;margin-bottom:8px}\n" +
        ".rowhead{display:flex;align-items:baseline;gap:8px;flex-wrap:wrap;margin-bottom:6px}\n" +
        ".rlabel{font-weight:700;font-size:14px;word-break:break-all}\n" +
        ".rsub{color:#9aa4b2;font-size:12px;word-break:break-all}\n" +
        ".rowctl{display:flex;align-items:stretch;gap:6px}\n" +
        ".urlbox{flex:1 1 auto;min-width:0;min-height:40px;background:#0e1116;color:#cdd5e0;" +
        "border:1px solid #303846;border-radius:9px;padding:0 10px;font-size:13px;" +
        "font-family:ui-monospace,SFMono-Regular,Menlo,Consolas,monospace}\n" +
        ".urlbox:focus{outline:none;border-color:#2f81f7}\n" +
        ".ico{flex:0 0 auto;width:40px;min-height:40px;display:inline-flex;align-items:center;" +
        "justify-content:center;border-radius:9px;border:1px solid #303846;background:#222a36;" +
        "color:#e6e9ef;font-size:17px;text-decoration:none;cursor:pointer;" +
        "-webkit-tap-highlight-color:transparent}\n" +
        ".ico:active{opacity:.7}\n" +
        ".ico.open{background:#2f81f7;border-color:#2f81f7;color:#fff}\n";

    private static final String JS =
        "(function(){\n" +
        "function fallbackCopy(text){\n" +
        "  var ta=document.createElement('textarea');\n" +
        "  ta.value=text;\n" +
        "  ta.setAttribute('readonly','');\n" +
        "  ta.style.position='fixed';ta.style.top='-1000px';ta.style.opacity='0';\n" +
        "  document.body.appendChild(ta);\n" +
        "  ta.focus();ta.select();ta.setSelectionRange(0,text.length);\n" +
        "  var ok=false;\n" +
        "  try{ok=document.execCommand('copy');}catch(e){ok=false;}\n" +
        "  document.body.removeChild(ta);\n" +
        "  return ok;\n" +
        "}\n" +
        "function flash(btn){\n" +
        "  var old=btn.getAttribute('data-old');\n" +
        "  if(old===null){old=btn.textContent;btn.setAttribute('data-old',old);}\n" +
        "  btn.textContent=(btn.classList.contains('ico')||btn.classList.contains('chip'))?'✓':'Скопировано ✓';\n" +
        "  setTimeout(function(){btn.textContent=old;},1500);\n" +
        "}\n" +
        "function doCopy(btn){\n" +
        "  var text=btn.getAttribute('data-url')||'';\n" +
        "  try{\n" +
        "    if(navigator.clipboard&&navigator.clipboard.writeText){\n" +
        "      navigator.clipboard.writeText(text).then(function(){flash(btn);},function(){if(fallbackCopy(text))flash(btn);});\n" +
        "      return;\n" +
        "    }\n" +
        "  }catch(e){}\n" +
        "  if(fallbackCopy(text))flash(btn);\n" +
        "}\n" +
        "var btns=document.querySelectorAll('.copy[data-url]');\n" +
        "for(var i=0;i<btns.length;i++){\n" +
        "  btns[i].addEventListener('click',function(){doCopy(this);});\n" +
        "}\n" +
        "var sels=document.querySelectorAll('.ico.sel');\n" +
        "for(var j=0;j<sels.length;j++){\n" +
        "  sels[j].addEventListener('click',function(){\n" +
        "    var box=this.parentNode.querySelector('.urlbox');\n" +
        "    if(box){box.focus();box.select();try{box.setSelectionRange(0,box.value.length);}catch(e){}}\n" +
        "  });\n" +
        "}\n" +
        "})();\n";

    // ----------------------------------------------------------------------

    /** Escape text for HTML element content. */
    private static String esc(String s) {
        if (s == null) return "";
        StringBuilder b = new StringBuilder(s.length() + 16);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '&': b.append("&amp;"); break;
                case '<': b.append("&lt;"); break;
                case '>': b.append("&gt;"); break;
                case '"': b.append("&quot;"); break;
                case '\'': b.append("&#39;"); break;
                default: b.append(c);
            }
        }
        return b.toString();
    }

    /** Escape text for use inside a double-quoted HTML attribute. */
    private static String escAttr(String s) {
        if (s == null) return "";
        StringBuilder b = new StringBuilder(s.length() + 16);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '&': b.append("&amp;"); break;
                case '"': b.append("&quot;"); break;
                case '<': b.append("&lt;"); break;
                case '>': b.append("&gt;"); break;
                case '\'': b.append("&#39;"); break;
                default: b.append(c);
            }
        }
        return b.toString();
    }
}
