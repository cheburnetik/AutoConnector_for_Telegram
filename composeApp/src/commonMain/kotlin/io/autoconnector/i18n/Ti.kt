package io.autoconnector.i18n

object Ti : Strings by En {
    override val tabConnector = "መራኸቢ"; override val tabScan = "ምድህሳስ"
    override val tabCatalog = "ካታሎግ"; override val tabLogs = "መዝገብ"; override val tabMore = "ተወሳኺ"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "ምዝገባታት"; override val logTabScan = "ምድህሳስ"
    override val logGeneral = "ሓፈሻዊ"; override val logEmpty = "ንሕጂ ባዶ"
    override val logSessions = "ክፍለ-ግዜታት"; override val logErrorsOnly = "ጌጋታት ጥራይ"; override val logNoErrors = "ዝፈሸሉ ክፍለ-ግዜታት የለዉን"
    override fun logSession(id: String, port: String) = "#${id} · :${port}"
    override val back = "ተመለስ"; override val copy = "ቅዳሕ"; override val gotIt = "ተረዲኡኒ"
    override val later = "ጸኒሕካ"; override val details = "ዝርዝር"; override val whatIsThis = "እዚ እንታይ እዩ?"
    override val delete = "ሰርዝ"

    override val connector = "መራኸቢ"; override val scan = "ምድህሳስ"
    override val notConfigured = "ኣይተዳለወን! ኣዐርዮ →"; override val howToSetup = "ከመይ ጌርካ ከም እተዳሉ"
    override val notifOff = "ምልክታታት ጠፊኦም! ኣዐርዮ →"; override val enable = "ኣንቅሕ"
    override fun fewProxies(n: Int) = "ህያዋን ፕሮክሲ ${n}፣ ይደሊ ኣሎኹ፣ ~15 ደቒቕ ተጸበዩ…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "ህያዋን ፕሮክሲ: ${alive}  (15 ደቒቕ: ${within}) · ብድምር: ${total}"
    override val notifWhyTitle = "ስለምንታይ ምልክታታት?"
    override val notifWhyBody = "ቀዋሚ ናይ ምልክታ ምልክት ማለት ናይ Android foreground service ማለት እዩ። " +
        "ብዘይኡ ስርዓቱ ነቲ መተግበሪ ካብ ተዘክሮ የውጽኦ፣ ንፕሮክሲ ምድላይን ኣብ ድሕሪት ምትእስሳር ምሓዝን የቋርጽ። " +
        "ስለዚ AutoConnector ንኽሰርሕ ምልክታታት ግድን እዮም።"
    override val notifEnableTitle = "ምልክታታት ኣንቅሕ"
    override val notifEnableBody = "ብዘይ ናይ ምልክታ ምልክት፣ Android ነቲ መተግበሪ ከም ዘይንጡፍ ይቖጽሮ እሞ ካብ ተዘክሮ " +
        "የውጽኦ። ሽዑ AutoConnector ንፕሮክሲ ምድላይን ኣብ ድሕሪት ምትእስሳር ምሓዝን የቋርጽ — Telegram ርክቡ ይስእን።" +
        "\n\n«ኣንቅሕ» ጠውቑ እሞ ንAutoConnector ምልክታታት ፍቐዱ።"
    override val notifPlea = "ምልክታታት ኣንቅሑ! ብዘይኦም መተግበሪ ኣብ ድሕሪት ክሰርሕ ኣይክእልን — Android የውጽኦ እሞ " +
        "ምድላይ ፕሮክሲን ምትእስሳርን ይቋረጽ።"

    override val statusConnected = "Telegram ተራኺቡ"; override val statusConnecting = "ይራኸብ ኣሎ…"
    override val statusOffline = "Telegram ኣይተራኸበን"; override val statusIdle = "Telegram ህዱእ"
    override val nobodyConnected = "ናብ መራኸቢ ዝተራኸበ የለን። "; override val howToSetupArrow = "ከመይ ጌርካ ከም እተዳሉ →"
    override val directModeViaVpn = "ቀጥታዊ ኩነታት: VPN ንጡፍ — ብዘይ ፕሮክሲ"
    override val directModeOff = "ቀጥታዊ ኩነታት: ፕሮክሲ ጠፊኡ"
    override val directDpiSuffix = " · anti-DPI"
    override val connections = "ምትእስሳራት"; override val sockets = "ሶኬታት"; override val speed = "ቅልጣፈ"
    override val traffic = "ትራፊክ"; override val latency = "ዘገምታ"
    override fun pcs(n: Int) = "${n} ኣሃዱ"
    override fun netNow(label: String) = "መርበብ: ${label}"
    override fun tgToConnector(n: Int) = "TG→ ${n}"
    override fun connectorToProxy(n: Int) = "ፕሮክሲ ${n}"
    override val trafficSec = "ትራፊክ · 60 ሰከ"; override val trafficMin = "ትራፊክ · 60 ደቒቕ"
    override val latencySec = "ዘገምታ · 60 ሰከ"; override val latencyMin = "ዘገምታ · 60 ደቒቕ"
    override val sec60 = "60 ሰከ"; override val min60 = "60 ደቒቕ"
    override val unitSec = "ሰ"; override val unitMin = "ደ"; override val unitHour = "ሰዓ"; override val dash = "—"
    override val currentProxy = "ህልዊ ፕሮክሲ"; override val noActiveProxy = "ንጡፍ ፕሮክሲ የለን (Telegram ኣይተራኸበን)"
    override val host = "ሆስት"; override val type = "ዓይነት"; override val secret = "ምስጢር"; override val antiDpi = "Anti-DPI"; override val obfEngine = "ኤንጅን ምሕባእ"
    override fun activeSockets(n: Int) = "ንጡፋት ሶኬታት Telegram: ${n}"
    override val noConnections = "ንጡፋት ምትእስሳራት የለዉን"; override val colHost = "ሆስት"; override val colTime = "ግዜ"
    override val modeWord = "ኩነታት"; override val directViaVpnLine = "ቀጥታዊ ሕቶታት ናብ Telegram (VPN ንጡፍ)"
    override val connModeHelp = "ኩነታት (VPN, Wi-Fi, LTE, Ethernet, White) ንሓይሊ ምድህሳስ ብዝተፈላለየ መንገዲ ከተስተኻኽል የኽእሉኻን ፍሉያት ደረጃታት/ስታቲስቲክስ ሆስት ይሕዙን። ካርድ መርበብ ብኣውቶማቲክ ይልለ፤ ኩነታት ኣብ ቅጥዕታት ብኢድ ክስራዕ ይኽእል።"

    override val scanOff = "ምድህሳስ ጠፊኡ"; override val proxiesInBase = "ፕሮክሲታት ኣብ ዳታቤዝ"
    override val total = "ድምር"; override val alive = "ህያው"; override val dead = "ምዉት"
    override val tgConnectedTitle = "Telegram ዝተራኸበሉ"; override val successful = "ዕዉት"
    override val socketsHeld = "ዕድመ ሶኬት"; override val over1m = ">1 ደቒቕ"; override val over5m = ">5 ደቒቕ"; override val over15m = ">15 ደቒቕ"
    override val scanCountTitle = "ብዝሒ ምርመራ ፕሮክሲ"; override val checked = "ተመርሚሩ"
    override val forAllTime = "ብሙሉእ ግዜ"; override val perMinute = "ኣብ ደቒቕ"; override val perHour = "ኣብ ሰዓት"
    override val subsCountTitle = "ብዝሒ ምውራድ ምዝገባ"; override val downloaded = "ወሪዱ"; override val failed = "ፈሺሉ"; override val scanTraffic = "ትራፊክ ምድህሳስ"; override val subTraffic = "ትራፊክ ምዝገባ"; override val subTrafficGraph = "ትራፊክ ምዝገባ"
    override val checksMtproto = "ምርመራ MTProto (↑ ok · ↓ ፍሽለት)"

    override fun catalogEmpty(mode: String) = "ካታሎግ ${mode} ንሕጂ ባዶ እዩ። ወይ ሓደ ሆስት ኣይተረኽበን፣ ወይ መተግበሪ ኣብዚ ኩነታት ፈጺሙ ኣይሰርሐን። ኣብ ቅጥዕታት ነቲ ኩነታት ክትቕይሮ ትኽእል። ኩነታት ንዝተፈላለየ ዓይነት ምትእስሳር ኢንተርነት ሆስታት ብፍሉይ ንምእካብ እዮም ዘለዉ።"
    override val aliveShort = "✓ ህያው"; override val deadShort = "✗ ምዉት"
    override val statusLabel = "ኩነታት"; override val rating = "ደረጃ"; override val port = "ፖርት"
    override val rttPing = "RTT (ping)"; override val checkedField = "ተመርሚሩ"; override val okOfTotal = "ዕዉት / ብድምር ምርመራ"
    override val tgConnectedField = "Telegram ተራኺቡ"; override val tgSessions = "ክፍለ-ግዜታት Telegram"; override val trafficThroughProxy = "ትራፊክ ብፕሮክሲ"
    override val sessionsTotal = "ድምር ክፍለ-ግዜታት"; override val relayNow = "ሕጂ መመሓላለፊ"; override val tlsDomain = "TLS ዶሜን (SNI)"
    override val sourceSub = "ምንጪ (ምዝገባ)"; override val lastError = "ናይ መወዳእታ ጌጋ"; override val yes = "እወ"; override val no = "ኣይፋል"
    override val copyAsLink = "ከም መላግቦ ቅዳሕ"; override val openInTelegram = "ሆስት ኣብ Telegram ክፈት"; override val makeNextRelay = "ቀጻሊ መመሓላለፊ ግበሮ"
    override val actCopy = "ቅዳሕ"; override val actOpen = "ክፈት"; override val actRelay = "መመሓላለፊ"
    override fun agoFmt(v: String) = "ቅድሚ ${v}"
    override val catalogTopFor = "ዝርዝር/ደረጃ ፕሮክሲ ን"
    override val catalogModeHelpTitle = "ኩነታትን ደረጃታትን"
    override val catalogModeHelp = "መተግበሪ ህያዋን ሆስታትን ደረጃኦምን ብነፍሲ-ወከፍ ኩነታት መርበብ (VPN, Wi-Fi, LTE, Ethernet ከምኡ’ውን White) ብፍሉይ ይቖጽር። «White» ንጻዕዳ ዝርዝራት ዝኸውን ፍሉይ ናይ ኢድ ኩነታት እዩ፤ ኣውቶ ናብኡ ፈጺሙ ኣይቕይርን። ስለዚ ሓደ ዓይነት ሆስት ኣብ ሓደ ኩነታት ህያው ኣብ ካልእ ድማ ምዉት ክኸውን ይኽእል።"
    override fun catalogInactiveWarn(section: String, active: String) =
        "ኣብዚ ሕጂ ዘይንጡፍ ክፍሊ ${section} ትርእዩ ኣለኹም — ኩሉ ስታቲስቲክስ ሕጂ ናብ ${active} እምበር ናብዚ ኣይኣቱን።"
    override val manageModeTitle = "ኩነታት ኣመሓድር"
    override val manageResetRating = "ደረጃ ዳግም ኣስተኻኽል"
    override fun manageResetHint(mode: String) = "ብፍላይ ን${mode} ደረጃን ስታቲስቲክስ ኣጠቓቕማን ህያዋን ሆስታት ዳግም ከተስተኻኽል ትኽእል። እዚ ናብ ፍጹም ዝተፈልየ VPN ወይ LTE ምስ እትራኸብ፣ ኣረጊት ስታቲስቲክስ ከይጸልዎ ይጠቅም። ወይ ምድህሳስ ፕሮክሲ ብኽንደይ ቅልጣፈ ኩሉ ካብ መጀመርታ ከም ዝምርምሮ ንምርኣይ።"
    override val manageDeleteAll = "ሆስታት ሰርዝ ኣብ"
    override fun manageDeleteHint(mode: String) = "ካብ ${mode} ደረጃ ኮነ ባዕሎም ሆስታት ከተጽሪ ትኽእል። ባህሪ «ምድህሳስ ፕሮክሲ» ዳግም ይእክቦም። እዚ ዳግም ምስትኽኻል ምዝገባ ኣይኮነን — ጠዊቕካ፣ ድሕሪኡ ~15 ደቒቕ ንዳግም ምድህሳስ ተጸበ።"
    override fun manageCopyFrom(mode: String) = "ኩሎም ሆስታትን ደረጃታትን ናብዚ ኩነታት (${mode}) ካብ ካልእ ኩነታት ቅዳሕ:"
    override val live = "ህያው"; override val deadW = "ምዉት"; override val unitMs = "ሚሰ"
    override val agoMin = "ደ"; override val agoHour = "ሰዓ"; override val agoDay = "መዓ"

    override val connectTelegram = "Telegram ምትእስሳር"; override val readCarefully = "ብጥንቃቐ ኣንብቡ!"
    override val guideIntro = "እዚ መተግበሪ ብዘይ ምድላው ኣይሰርሕን። ካብቶም ኣብ ታሕቲ ዘለዉ 3 ኣማራጺታት ሓደ ምረጹ " +
        "እሞ መምርሒታት ብጥንቃቐ ስዓቡ።"
    override val variant1 = "ኣማራጺ #1 — መጥወቕታት"
    override val variant1Body = "«ፕሮክሲ {A}» ጠውቑ — Telegram ይኽፈት፣ ፕሮክሲ ምውሳኽ ኣረጋግጹ። ናብዚ መስኮት " +
        "ተመለሱ እሞ «ፕሮክሲ {B}» ጠውቑ — ንኻልኣይ ግዜ ምውሳኽ ኣረጋግጹ።\n\nኣብ Telegram ካልኦት ኣረገውቲ " +
        "ፕሮክሲታት ኣጥፍኡ። ልክዕ 2 ፕሮክሲታት ጥራይ ክተርፉ ኣለዎም — ብፖርታት {A}ን {B}ን። ብኻልእ ዝኾነ ኣሰራርዓ " +
        "AutoConnector ኣይሰርሕን።"
    override val variant2 = "ኣማራጺ #2 — መላግቦታት"
    override val variant2Body = "ነቲ ኣብ ታሕቲ ዘሎ ጽሑፍ ኣብ Telegram ናብ Saved Messages (ወይ ዝኾነ ቻት) ቅዳሕዎ — " +
        "ማለት ንባዕልኹም ስደድዎ። ኣብ መልእኽትኹም ቀዳማይ መላግቦ ጠውቑ — ቀዳማይ ፕሮክሲ ይውሰኽ። ካልኣይ መላግቦ " +
        "ጠውቑ — ካልኣይ ይውሰኽ። ድሕሪኡ ኩሎም ኣረገውቲ ፕሮክሲታት ኣጥፍኡ።"
    override val variant3 = "ኣማራጺ #3 — ብኢድ"
    override val variant3Body = "SOCKS5 ፕሮክሲ ብኢድ ወስኹ: ሰርቨር localhost (127.0.0.1)፣ ፖርት {A}። ድሕሪኡ ካልኣይ " +
        "ፕሮክሲ: localhost፣ ፖርት {B}። ዝኾኑ ኣረገውቲ ፕሮክሲታት ሰርዙ።"
    override val whatNext = "ቀጺሉ እንታይ?"
    override val whatNextBody = "ኣብ Telegram «ኣውቶማቲክ ምቅይያር ፕሮክሲ» ኣንቅሑ — 5 ሰከንድ። ኣብ Telegram ውሽጢ " +
        "ንዘይንጡፍ ወይ «ዘይርከብ» ተባሂሉ ዝተመልከተ ፕሮክሲ ብኢድ ብምጥዋቕ Telegram ክራኸብ ክትሕግዙ ትኽእሉ — እዚ " +
        "Telegram ንኽራኸብ ብዝያዳ ክፍትን ይገብሮ።\n\nብጀካ {A}ን {B}ን ኩሎም ካልኦት ኣረገውቲ ፕሮክሲታት ከም " +
        "እተኣለዩ ኣረጋግጹ። ኣብ Telegram «ፕሮክሲ ተጠቐም» ጠውቑ።\n\nመተግበሪ እኹል ፕሮክሲ ክሳዕ ዝረክብን ዘውርድን " +
        "ተጸበዩ (5–15 ደቒቕ)። ሽዑ Telegram ባዕሉ ናብ AutoConnector ይራኸብ፣ ንሱ ድማ ንTelegram ብቐጻሊ " +
        "ብናይ ዝበለጹ ፕሮክሲታት የመሓላልፎ: ዝተመርመሩ፣ ህያዋንን ቅልጡፋትን።\n\nመምርሒታት ከቢድ እንተ መሲሉ — ይቕረታ፣ " +
        "ነዚ መተግበሪ ክትጥቀምሉ ኣይትኽእሉን: ኩሉ ብኣውቶማቲክ ምድላው ዘይከኣል እዩ፣ ህያዋን ፕሮክሲ ምድላይ ድማ ግዜ " +
        "ይወስድ።\n\nመተግበሪ ካብ ነዊሕ እዋን ኣውሪድኩም ህያዋን ፕሮክሲ እንተ ዘይተረኺቡ — ወይ ነቲ መተግበሪ ወይ ዝርዝር " +
        "ምዝገባ ኣሕድሱ። እዚ መተግበሪ ናይ ገዛእ ርእሱ ፕሮክሲ ኣይፈጥርን ኣየቕርብን፣ ጥራይ ኣብ ኢንተርነት ኣብ ብዙሓት " +
        "ጉጅለታትን ገጻትን ይደሊ።"
    override fun proxyBtn(port: Int) = "ፕሮክሲ ${port}"

    override val setupPortsTitle = "ፖርታት ኣብ Telegram ኣዳሉ"
    override val setupPortsSub = "Telegram ናብ መራኸቢ ከመይ ጌርካ ከም እተራኽቦ (ፖርታት 55001/55002)"
    override val settings = "ቅጥዕታት"; override val settingsSub = "ፖርታት፣ anti-DPI፣ ምድህሳስ፣ መርበብ፣ ባተሪ"
    override val subscriptions = "ምዝገባታት"; override val subscriptionsSub = "ዝድህሰሱ ምንጪታት ፕሮክሲ"
    override val statistics = "ስታቲስቲክስ"; override val statisticsSub = "ዳታቤዝ ፕሮክሲ + ሜላታት anti-DPI"
    override val export = "ኣውጽእ"; override val exportSub = "tg:// መላግቦታት ህያዋን ፕሮክሲ"
    override val about = "ብዛዕባ"; override val aboutSub = "ቨርዥን፣ ህንጸት፣ ምውራድ፣ ርእይቶ"
    override val hotkeys = "ቀልጠፍቲ መፍትሕታት"
    override val hotkeysSub = "ሓፈሻዊ መፍትሕታት: ፕሮክሲ ቅዳሕ / ክፈት"
    override val hotkeysIntro = "ሓፈሻዊ ቀልጠፍቲ መፍትሕታት መስኮት መተግበሪ ኣብ ፎከስ ዘይኮነ እኳ ይሰርሑ። ካብቲ ፑል " +
        "ዘይተወሰነ ህያው መላግቦ ፕሮክሲ (tg://) ይመርጹ — መተግበሪ ከይከፈትካ ፕሮክሲ ብቕልጡፍ ንምቕያር ይጠቅም።"
    override val hotkeysNote = "ኣብ macOS፣ መፍትሕታት ንምሓዝ ፍቓድ Accessibility ከድሊ ይኽእል " +
        "(System Settings → Privacy & Security → Accessibility)።"
    override val hotkeyCopyTitle = "መላግቦ ፕሮክሲ ቅዳሕ"
    override val hotkeyCopyDesc = "ናይ ዘይተወሰነ ህያው tg:// መላግቦ ኣብ ክሊፕቦርድ የቐምጥ።"
    override val hotkeyEnable = "ቀልጠፍቲ መፍትሕታት ኣንቅሕ"; override val hotkeyLetterLabel = "ፊደል"; override val hotkeySet = "ኣቐምጥ"; override val hotkeyReset = "ዳግም ኣስተኻኽል"
    override val hotkeyOpenTitle = "ፕሮክሲ ኣብ Telegram ክፈት"
    override val hotkeyOpenDesc = "ዘይተወሰነ ህያው መላግቦ ይኸፍት — Telegram ይሕዞ እሞ ፕሮክሲ ንምትእስሳር የቕርብ።"

    override val relayPorts = "ፖርታት መመሓላለፊ"
    override val relayPortsHelp = "መራኸቢ ዝሰምዓሎም ናይ ከባቢ ፖርታት። ኣብ Telegram ከም SOCKS5 ፕሮክሲ " +
        "(127.0.0.1 : ፖርት) ልክዕ ነዚኦም ተእትዉ። ንተኣማንነት ክልተ ፖርታት ይጥቀሙ — Telegram ናብ ክልቲኦም " +
        "ምትእስሳር ይሕዝ።"
    override val portA = "ፖርት A"; override val portB = "ፖርት B"
    override val antiDpiTrick = "ሜላ Anti-DPI"
    override val antiDpiHelp = "ISP/DPI ከይልልዮን ከይዓግቶን ምትእስሳር ዝሕባእ ኣገባብ።\n• «ኣውቶ-ምዝውዋር» ባዕሉ ዝሰርሕ " +
        "ሜላ ይመርጽ።\n• «ብዘይ ሜላታት DPI» — ንቡር ምትእስሳር።\n• እቶም ካልኦት — ፍሉያት ኣገባባት እዮም (ምምሳል " +
        "ብራውዘር፣ ምክፍፋል ፓኬት ወዘተ)።"
    override val onlyFakeTls = "FakeTLS ጥራይ (ee)"
    override val applyDpiTo = "anti-DPI ኣብ ... ተግብር"
    override val applyDpiHelp = "ነቲ እተመረጸ ሜላ anti-DPI ኣበይ ከም ዝትግበር:\n• መመሓላለፊ Telegram — ናብቲ ብመራኸቢ " +
        "ዝሓልፍ ህያው ምትእስሳር Telegram።\n• ምርመራታት ፕሮክሲ — ናብ ድሕሪት ምርመራታት ፕሮክሲ (ሽዑ ምርመራ ልክዕ ከም " +
        "ሓቀኛ ምትእስሳር ይኸውን፣ ስታቲስቲክስ ሜላ ድማ ዝያዳ ትኽክለኛ ይኸውን)።\n• ብቐጥታ ክትራኸብ ከለኻ — ፕሮክሲ ጠፊኡ " +
        "ከሎ (ወይ VPN ኣብ ዝነጥፈሉ ዝሕለፍ) Telegram ቀጥታ ናብ ሰርቨራቱ ዝኸይድ: ኣብዚ ፕሮክሲ የለን፣ ስለዚ ሜላ ናብ " +
        "ምክፋል ቀዳማይ TCP ፓኬት (handshake) ናብ ብዙሓት ንኣሽቱ ቍርጽራጽ ይቕየር፣ DPI ኣብ ሓደ ንባብ ከይልልዮ።"
    override val toRelay = "መመሓላለፊ Telegram"; override val toProbes = "ምርመራታት ፕሮክሲ"
    override val toDirect = "ብቐጥታ ክትራኸብ ከለኻ"
    override val vpnSection = "VPN ኣብ ዝነጥፈሉ"
    override val vpnHelp = "ኣብ መሳርሒ VPN ንጡፍ ኣብ ዝኾነሉ እንታይ ክግበር:\n• ብMTProto ፕሮክሲ — Telegram ከም ልሙድ " +
        "ብናይ ዝተረኽቡ ፕሮክሲታት ይኸይድ (ኣብ ልዕሊ VPN)።\n• ብቐጥታ — መራኸቢ ፕሮክሲ ኣይጥቀምን Telegram ቀጥታ ናብ " +
        "ሰርቨራት Telegram የራኽቦ: VPN ድሮ መእተዊ ይህብ፣ ተወሳኺ ንብርብር ፕሮክሲ ኣየድልን (ቅልጡፍን ዝያዳ ርጉእን)። " +
        "ብዘይ VPN ፕሮክሲ ከም ልሙድ ይጥቀም።"
    override val linkFormat = "ቅርጺ መላግቦ ፕሮክሲ"
    override val linkFormatHelp = "ፕሮክሲ ከመይ ከም ዝቕዳሕን ዝኽፈትን። tg:// ቀጥታ ኣብ Telegram ይኽፈት (Telegram Desktop ተተኺሉ ከድሊ)። http (t.me) ብብራውዘር ይኽፈት እሞ ኣብ Telegram ክኽፈት የቕርብ — tg:// ዘይተመዝገበ እንተ ኾይኑ ይጠቅም።"
    override val linkTg = "tg:// (Telegram ብቐጥታ ክፈት)"; override val linkTgSub = "tg://proxy?… — Telegram ይኸፍት"
    override val linkHttp = "http (t.me፣ ብብራውዘር)"; override val linkHttpSub = "https://t.me/proxy?… — ብራውዘር ይኸፍት"
    override val viaMtproto = "ፕሮክሲ ብMTProto"; override val viaMtprotoSub = "ብVPN እኳ ትራፊክ ብፕሮክሲ ይሓልፍ"
    override val directly = "ብቐጥታ ተራኸብ"; override val directlySub = "VPN ንጡፍ ከሎ — ፕሮክሲ ሓሊፍካ፣ ቀጥታ ናብ Telegram"
    override val notifications = "ምልክታታት"
    override val scanCheck = "ምድህሳስን ምርመራን"
    override val scanCheckHelp = "• ምድህሳስ፣ ደቒቕ — ካብ ምዝገባታት ዝርዝራት ፕሮክሲ ክንደይ ግዜ ከም ዝውረዱ።\n" +
        "• ምርመራ፣ ደቒቕ — ኣብ ዳታቤዝ ዘለዉ ፕሮክሲታት ህያውነቶም ክንደይ ግዜ ከም ዝምርመሩ።\n• ዓቐን ጉጅለ — " +
        "ኣብ ሓደ ዙር ክንደይ ፕሮክሲ ከም ዝምርመር።\n• ጎኒ ንጎኒ — ብሓደ ግዜ ክንደይ ምርመራ ከም ዝካየድ (ብዙሕ = " +
        "ቅልጡፍ፣ ግን ዝለዓለ ጾር መርበብን ባተሪን)።"
    override val scanMin = "ምድህሳስ፣ ደቒቕ"; override val checkMin = "ምርመራ፣ ደቒቕ"; override val batchSize = "ዓቐን ጉጅለ"; override val parallel = "ጎኒ ንጎኒ"
    override val speedByNet = "ሓይሊ ምድህሳስ ብመርበብ"
    override val speedByNetHelp = "ኣብ ህልዊ መርበብ ተመርኲስካ ፕሮክሲ ክንደይ ግዜ ከም ዝምርመር። «ስታንዳርድ» = መሰረታዊ " +
        "ኣቦ ግዜ። ናብ የማን ምስ እትደፍኦ — ዝውሕድ (ዝሑል፣ ንትራፊክ/ባተሪ ዝሕሉ)፣ ናብ ጸጋም — ዝበዝሕ (ቅልጡፍ፣ ዝያዳ " +
        "ሓያል)። ሎጋሪዝማዊ መለክዒ፣ ክሳዕ ×100 ኣብ ነፍሲ-ወከፍ ሸነኽ።\n• VPN — ግዳማዊ VPN ኣብ ዝነጥፈሉ።\n" +
        "• Wi-Fi — ኣብ መርበብ Wi-Fi።\n• LTE — ኣብ ሞባይል መርበብ።"
    override val intensStandard = "ስታንዳርድ"
    override val intensSlower = "ዝሑል"
    override val intensFaster = "ቅልጡፍ"
    override val maintenance = "ዳታ ዳግም ኣስተኻኽል"
    override val maintenanceHelp = "• «ካታሎግን ስታቲስቲክስን ዳግም ኣስተኻኽል» — ደረጃታት፣ ቆጸርቲ፣ ትራፊክን መዛግብቲ " +
        "ምርመራን የባዶ፣ ግን ዝወረዱ ሆስታትን ምዝገባታትን ይዕቅብ (ኣብ ዝቕጽል ምድህሳስ ኩሉ ዳግም ይምዘን)።\n" +
        "• «ዝወረዱ ሆስታት ኣጽሪ» — ምሉእ ፑል ፕሮክሲ ይሰርዝ ግን ምዝገባታት ይዕቅብ ምድህሳስ ከም ዘመልኦ። ምዝገባታት " +
        "ብዝኾነ መንገዲ ኣይትንከፉን።"
    override val backupTitle = "ምውጻእ / ምእታው"
    override val backupHelp = "ዳታ መተግበሪ ከም JSON ዓቅብ ወይ መልስ። እንታይ ከም ዝካተት ምልክት ግበር — ዝኾነ " +
        "ጥምረት:\n• ቅጥዕታት — ኩሎም ፓራሜተራት መተግበሪ።\n• ምዝገባታት — ዝርዝር ምንጪ (URL + ንቕሓት/ጥፍኣት)።\n" +
        "• ካታሎግ ህያዋን ሆስት — ኩሎም ህያዋን ፕሮክሲታት ምስ ደረጃኦምን ስታቲስቲክሶምን ብነፍሲ-ወከፍ ኩነታት መርበብ።\n\n" +
        "«ምውጻእ» ምስ ድሉው JSON ገጽ ይኸፍት — ቅዳሕዎ ወይ ኣብ ፋይል ዓቅብዎ። «ምእታው» — JSON ለጥፍ (ወይ ፋይል " +
        "ጽዓን) ነቶም ኣብኡ ዘለዉ ምልክት ዝተገብሮም ክፍልታት ጥራይ ይትግብር። ምእታው ናብ ህልዊ ዳታ ይውስኽ (ኣይድምስስን)።"
    override val backupSettings = "ቅጥዕታት"
    override val backupSubs = "ምዝገባታት"
    override val backupHosts = "ካታሎግ ህያዋን ሆስት (ብኩነታት)"
    override val exportWord = "ምውጻእ"
    override val importWord = "ምእታው"
    override val backupExportTitle = "ዳታ ኣውጽእ"
    override val backupImportTitle = "ዳታ ኣእቱ"
    override val backupSelectExport = "እንታይ ከም ዝወጽእ:"
    override val backupSelectImport = "እንታይ ከም ዝኣቱ:"
    override val backupCopyBtn = "ቅዳሕ"
    override val backupSaveFile = "ናብ ፋይል ኣቐምጥ"
    override val backupLoadFile = "ካብ ፋይል ጽዓን"
    override val backupDoImport = "ኣእቱ"
    override val backupPasteLabel = "ናይ ባክኣፕ JSON ኣብዚ ለጥፍ"
    override val backupJsonLabel = "ባክኣፕ JSON"
    override val backupAndroidFileNote = "ፋይላት ኣብዚ የለዉን — ቅዳሕ / ለጥፍ ተጠቐም።"
    override val eraseAllHosts = "ኩሎም ሆስታት ደምስስ"
    override val factoryReset = "ኩሉ ዳግም ኣስተኻኽል (ከም ናይ መጀመርታ ጅማሮ)"
    override val factoryResetConfirm = "መተግበሪ ብምሉእ ናብ ናይ ፋብሪካ ኩነታት ይምለስ? ኩሎም ቅጥዕታትን ምሉእ " +
        "ካታሎግ ሆስትን ይድምሰሱ፣ ምዝገባታት ናብ ነባሪ ይምለሱ። ልክዕ ከም ናይ መጀመርታ ጅማሮ።"
    override val resetCatalog = "ካታሎግን ስታቲስቲክስን ዳግም ኣስተኻኽል"
    override val resetCatalogConfirm = "ኩሎም ደረጃታት፣ ቆጸርትን መዛግብቲ ምርመራን ይባደዱ? " +
        "ዝወረዱ ሆስታትን ምዝገባታትን ይዕቀቡ ኣብ ዝቕጽል ምድህሳስ ድማ ዳግም ይምዘኑ።"
    override val clearHosts = "ዝወረዱ ሆስታት ኣጽሪ"
    override val clearHostsConfirm = "ምሉእ ዝርዝር ዝወረዱ ሆስታት (ፕሮክሲ) ይሰረዝ? " +
        "ምዝገባታት ይዕቀቡ ምድህሳስ ድማ ፑል ዳግም የመልኦ።"
    override val doReset = "ዳግም ኣስተኻኽል"
    override val doCancel = "ኣቋርጽ"
    override val adaptiveSpeed = "ተጠዓማይ ቅልጣፈ"
    override val adaptiveHelp = "ምርመራታት ህያውነት ብመሰረታዊ ኣቦ ግዜ ይካየዱ (ካብ «ምድህሳስን ምርመራን»፣ ብመባዝሒ " +
        "መርበብ’ውን ይባዛሕ)። «ተጠዓማይ ቅልጣፈ» ሕጂ ክንደይ ፕሮክሲ ህያው ምዃኖም መሰረት ብምግባር ባዕሉ የቕልጥፎም ወይ " +
        "የዝሕሎም።\n\n" +
        "• ህያዋን ውሑዳት (ካብ ደረት «ውሑድ» ዝውሕዱ) → ኣቦ ግዜ × «ምቅልጣፍ»። ካብ 1 ዝውሕድ መባዝሒ = ዝበዝሕ: " +
        "0.5 — ዕጽፊ ዝበዝሕ፣ 0.25 — 4×። ፑል ብቕልጡፍ የመልኦ።\n" +
        "• ህያዋን ብዙሓት (ካብ ደረት «ብዙሕ» ዝበዝሑ) → ኣቦ ግዜ × «ምዝሓል»። ካብ 1 ዝበዝሕ = ዝውሕድ: 2 — ፍርቂ " +
        "ዝውሕድ፣ 4 — ርብዒ። ባተሪን ትራፊክን ይሕሉ።\n" +
        "• ኣብ መንጎ ደረታት — መሰረታዊ ቅልጣፈ (×1)።\n\n" +
        "ኣብነታት:\n" +
        "— ፕሮክሲ ቀልጢፍካ ምእካብ: «ምቅልጣፍ» 0.25 ከምኡ’ውን/ወይ ደረት «ውሑድ» 40።\n" +
        "— እኹል ምስ ዝህሉ ባተሪ ምሕላው: «ምዝሓል» 8 ከምኡ’ውን/ወይ ደረት «ብዙሕ» 30።\n" +
        "— ምልምማድ ምጥፋእ: ክልቲኦም መባዝሕቲ ናብ 1 ኣቐምጥ።\n\n" +
        "ነባሪ: ውሑድ 20፣ ምቅልጣፍ 0.5፣ ብዙሕ 50፣ ምዝሓል 4።"
    override val threshMany = "ደረት «ብዙሕ»"; override val threshFew = "ደረት «ውሑድ»"; override val mulFast = "ምቅልጣፍ ×"; override val mulLazy = "ምዝሓል ×"
    override val subIntensityTitle = "ሓይሊ ምዝገባ"
    override val subIntensityHint = "ኣቦ ግዜ ኣብ መንጎ ምውራድ ምዝገባ: ዝርዝራት ፕሮክሲ ድሕሪ ክንደይ ደቒቕ ዳግም ከም ዝውረዱ (ብፍሉይ ንነፍሲ-ወከፍ ኩነታት መርበብ)።"
    override val baseScanTitle = "መሰረታዊ ቅልጣፈ ምድህሳስ"
    override val baseScanHelp = "መወከሲ ቅልጣፈ ምርመራ ህያውነት። «ተጠዓማይ ቅልጣፈ»ን መባዝሕቲ «ቅልጣፈ ብኩነታት»ን " +
        "ካብኡ ይሕሰቡ።\n\n" +
        "• ክንደይ ግዜ ከም ዝስርሕ፣ ደቒቕ — ኣቦ ግዜ ኣብ መንጎ ዙራት ምርመራ።\n" +
        "• ጉጅለ ኣብ ስረ፣ ሆስታት — ነፍሲ-ወከፍ ስረ ኣብ ሓደ ዙር ክንደይ ሆስት ይምርምር።\n" +
        "• ስረታት — ብሓደ ግዜ ክንደይ ምርመራ ይካየድ። ሓደ ዙር «ጉጅለ × ስረታት» ሆስታት ይምርምር።\n" +
        "• ሆስት ካብ ነፍሲ-ወከፍ N ደቒቕ ንላዕሊ ዳግም ኣይትድህስስ — ጸረ-ፍሰት: ኣብ ቀረባ ዝተመርመረ ሆስት ኣብዚ ዙር " +
        "ይሕለፍ።\n\n" +
        "ብዙሓት ስረታትን ዓብዪ ጉጅለን = ቅልጡፍ ዕቤት ፑል፣ ግን ዝለዓለ ጾር ኣብ መርበብን ባተሪን።"
    override val baseScanPeriod = "ክንደይ ግዜ ከም ዝስርሕ፣ ደቒቕ"
    override val baseScanBatch = "ጉጅለ ኣብ ስረ፣ ሆስታት"; override val baseScanThreads = "ብዝሒ ስረታት"
    override val adaptiveDesc = "ህያዋን ፕሮክሲ ካብ «ውሑድ» ዝወሓዱ ወይ ካብ «ብዙሕ» ዝበዝሑ እንተኾይኖም፣ ተወሳኺ መባዝሒ ተግብር።"
    override val fewWord = "ውሑድ"; override val manyWord = "ብዙሕ"
    override fun fasterX(x: String) = "${x}× ቅልጡፍ"
    override fun slowerX(x: String) = "${x}× ዝሑል"
    override fun ifAliveLt(n: Int) = "ህያዋን ፕሮክሲ < ${n} እንተኾይኖም፣ ሽዑ:"
    override fun ifAliveGt(n: Int) = "ህያዋን ፕሮክሲ > ${n} እንተኾይኖም፣ ሽዑ:"
    override val disabledWord = "ጠፊኡ"
    override val speedByModeTitle = "ቅልጣፈ ብኩነታት"
    override val speedByModeHelp = "ናይ ምድህሳስ-ቅልጣፈ መባዝሒ ንነፍሲ-ወከፍ ኩነታት መርበብ፣ ኣብ ልዕሊ መሰረታዊ " +
        "ቅልጣፈ። «ስታንዳርድ» (×1) = መሰረታዊ ኣቦ ግዜ። የማን — ዝውሕድ (ዝሑል፣ ንትራፊክ/ባተሪ ዝሕሉ)፣ ጸጋም — " +
        "ዝበዝሕ (ቅልጡፍ፣ ዝያዳ ሓያል)። ሎጋሪዝማዊ መለክዒ፣ ክሳዕ ×100 ኣብ ነፍሲ-ወከፍ ሸነኽ።\n\n" +
        "ኣብ ትሕቲ ነፍሲ-ወከፍ ስላይደር ውጽኢታዊ ፓራሜተራት ዙር ምስ ተጠዓማይ ቅልጣፈ ይረኣዩ — ን«ህያዋን ውሑድ» " +
        "(× «ምቅልጣፍ») ከምኡ’ውን «ህያዋን ብዙሕ» (× «ምዝሓል») ብፍሉይ።\n\n" +
        "ኩነታት:\n• VPN — ግዳማዊ VPN ንጡፍ።\n• LTE — ሞባይል መርበብ።\n• Wi-Fi — መርበብ Wi-Fi።\n" +
        "• Ethernet — ብገመድ ምትእስሳር።\n• White — ናይ ኢድ «ጻዕዳ» ኩነታት ፕሮክሲ።"
    override val aliveLt = "ህያው <"; override val aliveGt = "ህያው >"
    override val periodWord = "ግዜ"; override val nonstopWord = "ብዘይምቁራጽ"
    override val batchWord = "ጉጅለ"; override val threadsWord = "ስረታት"; override val scanModeOff = "ምድህሳስ ጠፊኡ"
    override val netBattery = "መርበብን ባተሪን"
    override val netBatteryHelp = "• Wi-Fi ጥራይ — ኣብ ሞባይል መርበብ ኣይትድህስስ (ትራፊክ ይሕሉ)።\n• ኣብ ምስሓን ጥራይ — " +
        "ስልኪ ኣብ ዝስሕነሉ ጥራይ ስራሕ።\n• ባተሪ ምስ ዝውሕድ ሕለፍ — ባተሪ ምስ ዝውሕድ ምድህሳስ ኣቋርጽ።"
    override val onlyWifi = "Wi-Fi ጥራይ"; override val onlyCharging = "ኣብ ምስሓን ጥራይ"; override val skipLowBattery = "ባተሪ ምስ ዝውሕድ ሕለፍ"
    override val autosaved = "ቅጥዕታት ብኣውቶማቲክ ይዕቀቡ።"
    override val dpiAutoLabel = "ሜላታት DPI ብኣውቶ ኣዘውትር"; override val dpiNoneLabel = "ብዘይ ሜላታት DPI (ንቡር)"
    override val experimental = "ናይ ፈተነ"
    override val experimentalHelp = "ናብ MTProto ኣፕስትሪም ኣማራጺ ኤንጂናት ፕሮክሲን ናይ ምርመራ መዝገብን። እቲ መወከሲ " +
        "(ዝሰርሕ) መገዲ ኣብ «ጠፊኡ» ኣይቕየርን። ጥራይ እቲ እተኸብደ ውሒዝ ናብ ኣፕስትሪም TCP ሶኬት ከመይ ከም ዝጸሓፍ ይቕየር " +
        "(ዓቐን ቍርጽራጽ፣ ግዜ፣ ዶብ TLS-record) — እቲ ውሒዝ ባዕሉ ባይት-ብ-ባይት ሓደ ዓይነት ይተርፍ። " +
        "ኣብ ህያው መመሓላለፊ ፕሮክሲ ጥራይ ይትግበር (ኣይ ናብ ምርመራታት፣ ኣይ ናብ ቀጥታዊ መገዲ)።"
    override val expEngineTitle = "ኤንጅን ፕሮክሲ (ምሕባእ ሶኬት)"
    override val expConnectTitle = "ኤንጅን ምትእስሳር (ምረጻ ኣፕስትሪም)"
    override val expEngineWarn = "⚠ ናይ ፈተነ ኩነታት። ምትእስሳር እንተ ኸፊኡ፣ ናብ «ጠፊኡ (መወከሲ መገዲ)» ተመለስ።"
    override val netLog = "መዝገብ ልውውጥ መርበብ ኣንቅሕ"
    override val netLogSub = "ናብ ፋይል መን-ናብ-መን-መዓስን ዓቐን ፓኬታትን ይጽሕፍ (ብዘይ ትሕዝቶ ዳታ) — " +
        "ቅዲ ልውውጥ ምስ VPNን ብዘይ VPNን ንምውድዳር።"
    override val openLogFolder = "ፎልደር መዝገብ ክፈት"; override val copyPath = "መገዲ ቅዳሕ"
    override val helpShow = "ሓገዝ"; override val helpHide = "ሓገዝ ሕባእ"
    override val quickSwitchIntro = "ኣብዚ ሜላ ምሕላፍ ዕጽዋ ክትመርጹ ትኽእሉ። Telegram እቲ ጌጋ " +
        "“The proxy you are using is not configured correctly and will be disabled. Please find another " +
        "one” እንተ ኣርእዩ፣ Telegram ከየርእዮ ኣየናይ ዓይነት ምድብላቕ ትራፊክ ከም ዝሰርሕ ፈትኑ። ብ split* ኩነታት ጀምሩ። " +
        "እቶም coalesce* ኩነታት’ውን ይሰርሑ፣ ግን ብኣታቶም ኣብ Telegram ስእልታት/ቪድዮታት ብግቡእ ኣይጽዓኑን።"
    override val quickSwitchTitle ="ምሕላፍ ዕጽዋ"; override val quickSwitchSub = "ቅርጺ፣ ምትእስሳር፣ anti-DPI"

    override val sourceUrl = "URL ምንጪ"
    override fun sourceAlive(alive: Int, total: Int) = "ህያው ${alive}/${total}"
    override val open = "ክፈት"; override val active = "ንጡፍ"; override val inactive = "ዘይንጡፍ"
    override val lastDownloaded = "ወሪዱ"; override val notDownloaded = "ገና ኣይወረደን"
    override fun sourceCounts(dead: Int, total: Int) =
        " ህያው፣ ${dead} ምዉት፣ ${total} ድምር"

    override val proxyBase = "ዳታቤዝ ፕሮክሲ"
    override val totalInBase = "ድምር ኣብ ዳታቤዝ"; override val aliveNow = "ሕጂ ህያው"; override val deadStat = "ምዉት"
    override val aliveIn15 = "ህያው ኣብ 15 ደቒቕ"; override val checksAllTime = "ምርመራ ብሙሉእ ግዜ"
    override val antiDpiTricks = "ሜላታት Anti-DPI"; override val noStatsYet = "ገና ዳታ የለን — ሜላታት ምስ ምርመራ/ምትእስሳር ይእከቡ"
    override val attempts = "ፈተነታት"; override val handshake = "Handshake"; override val score = "ነጥቢ"
    override val tgConnect = "TG ምትእስሳር"; override val socketsOver1m = "ሶኬታት >1ደቒቕ"
    override val over10kb = "ሶኬታት >10KB"; override val over100kb = ">100KB"; override val workTime = "ግዜ ስራሕ"
    override val statsLegend = "Handshake — ዕዉታት handshakes (% ካብ ፈተነታት) · Score — ዋጋ · " +
        "«ግዜ ስራሕ» — ድምር ኣብ ሶኬታት ≥5KB ካብ 1 ደቒቕ ዝነውሑ።"
    override val resetStats = "ስታቲስቲክስ ሜላ ዳግም ኣስተኻኽል"

    override fun aliveLinks(n: Int) = "ህያዋን መላግቦታት: ${n}"
    override val copyAll = "ኩሉ ቅዳሕ"
    override val openRandom = "ዘይተወሰነ ክፈት"; override val copyRandom = "ዘይተወሰነ ቅዳሕ"; override val allShort = "ኩሉ"
    override val copyTop = "TOP ቅዳሕ"; override val randomHost = "ዘይተወሰነ ሆስት"
    override val exportToFile = "ናብ ፋይል ኣውጽእ"; override val exportSaved = "ናብ ፋይል ተዓቒቡ:"
    override val dlNow = "ሕጂ ኣውርድ"
    override fun downloadingFmt(sec: Long) = "ይወርድ ኣሎ… ${sec}ሰ"
    override val cancel = "ኣቋርጽ"
    override val deleteConfirmTitle = "ምዝገባ ይሰረዝ?"
    override val subscriptionsAddHint = "ምዝገባታት ወይ መላግቦታት ፕሮክሲ ወስኽ →"
    override val addSourcesTitle = "ወስኽ"
    override val addSubsLabel = "ምዝገባታት (ሓደ URL ኣብ ሕደ መስመር)"
    override val addSubsHelp = "ቅኑዕ URL ዘለዎ ነፍሲ-ወከፍ መስመር ናይ ገዛእ ርእሱ ምዝገባ ይኸውን ብየዕባ ድማ ይውረድ።"
    override val addProxiesLabel = "ድልዋት መላግቦታት ፕሮክሲ (ቀዋሚ ዝርዝር)"
    override val addProxiesHelp = "ናብ ፍሉያት ፕሮክሲታት ጥማር መላግቦታት ለጥፍ (tg://proxy, https://t.me/proxy, …)። እዚ ምዝገባ ኣይኮነን — ዝርዝሩ ኣይውረድን፣ ፕሮክሲታት ናብ ካታሎግ ጥራይ ይውሰኹ።"
    override val addButton = "ወስኽ"
    override fun addedFmt(subs: Int, proxies: Int) = "ተወሲኹ: ${subs} ምዝገባታት፣ ${proxies} ፕሮክሲታት"
    override val perSecond = "ኣብ ሰከ"
    override val graphSpeed = "ቅልጣፈ"
    override val graphVolume = "መጠን"
    override val graphLatency = "Ping"
    override val graphConnects = "ምትእስሳራት"
    override val scanNow = "ሕጂ ድህስስ"; override val scanOnShort = "ምድህሳስ ነቒሑ"
    override val scanRunning = "ምድህሳስ ይካየድ"; override val scanIdle = "ምድህሳስ ህዱእ"; override val scanOffState = "ምድህሳስ ጠፊኡ"; override val scanBatchPerThread = "ጉጅለ/ስረ"; override val scanPassHosts = "ሆስታት ኣብ ሓደ ዙር"; override val minRescanLabel = "ሆስት ካብ ነፍሲ-ወከፍ N ደቒቕ ንላዕሊ ኣይትድህስስ"
    override val scanPlanTitle = "መደብ"; override val scanNowTitle = "ሕጂ"; override val currentScheduleTitle = "ህልዊ መደብ-ግዜ"
    override val scheduleWord = "መደብ-ግዜ"; override val unitPcsPerSec = "ኣሃዱ/ሰ"
    override val scanNowThreadsLabel = "ሕጂ ዝሰርሑ ስረታት"; override val scanNowPerThreadLabel = "ምርመራ ኣብ ስረ (መደብ)"; override val scanNowElapsedLabel = "ግዜ ስራሕ"
    override val scanOkGraph = "ዕዉታት ምድህሳሳት"; override val scanFailGraph = "ዝፈሸሉ ምድህሳሳት"; override val scanTrafficGraph = "ትራፊክ ምድህሳስ"; override val scanAliveGraph = "ድምር ህያዋን ፕሮክሲ"; override val scanPingGraph = "Ping"; override val threadsGraph = "ስረታት"
    override val scanEvery = "ነፍሲ-ወከፍ"; override val scanNextRun = "ቀጻሊ ስራሕ"
    override val scanThreads = "ስረታት"; override val scanBatch = "ጉጅለ"
    override val scanElapsed = "ይሰርሕ"; override val scanIdleNow = "—"
    override val effForFew = "ምስ ውሑድ"; override val effForMany = "ምስ ብዙሕ"
    override val effCheck = "ምርመራ"; override val effBatch = "ጉጅለ"; override val effPar = "ጎኒ ንጎኒ"
    override val effContinuous = "ቀጻሊ"; override val secShort = "ሰ"; override val minShort = "ደቒቕ"

    override val appTagline = "መስቀላዊ-መድረኽ ኣውቶ-መራኸቢ: Telegram ዝሰርሓሎም MTProto ፕሮክሲታት ይደሊ፣ " +
        "ይምርምርን የልዕልን።"
    override val version = "ቨርዥን"; override val buildDate = "ዕለት ህንጸት"
    override val downloadSources = "ምውራድን ምንጪታትን"; override val openOnGithub = "ኣብ GitHub ክፈት"
    override val feedbackBugs = "ርእይቶን ጸብጻብ ጌጋን"; override val writeTelegram = "ኣብ Telegram ጽሓፍ"

    override val language = "ቋንቋ"; override val langAuto = "ኣውቶ (ስርዓት)"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "ቋንቋ"
    override val raceWidthTitle = "ጎኒ ንጎኒ ምትእስሳራት"
    override val connectionSection = "ምትእስሳርን ምሕላፍ ዕጽዋን"
    override val connectionSectionHelp = "ኤንጅን ምትእስሳር፣ ጎኒ ንጎኒ ኣፕስትሪማት፣ ኤንጅን ፕሮክሲን ሜላታት anti-DPIን — ኩሉ ኣብ ሓደ ክፍሊ።"
    override val netLogSection = "መዝገብ ልውውጥ መርበብ"
    override val platform = "ፕላትፎርም"

    override val scanModeTitle = "ኩነታት መርበብ"; override val scanModeAuto = "ኣውቶ"; override val scanModeManualLabel = "ብኢድ"
    override val activeModeLabel = "ንጡፍ ኩነታት"; override val formingListLabel = "ዝርዝር ይህነጽ"; override val catalogModeTabs = "ኩነታት"
    override val resetModeRatings = "ደረጃታት ሆስት ዳግም ኣስተኻኽል"; override val forgetModeHosts = "ሆስታት ኩነታት ረስዕ"
    override val exportModeTitle = "ብኩነታት ኣውጽእ"; override val modePickerTitle = "ኩነታት"
    override val modeHelp = "ነፍሲ-ወከፍ ኩነታት መርበብ ናይ ገዛእ ርእሱ ደረጃ ፕሮክሲን ናይ ገዛእ ርእሱ ሓይሊ ምድህሳስን ምውራድ ምዝገባን ይሕዝ። «ኣውቶ» ካብ ንጡፍ መርበብ ነቲ ኩነታት ይመርጽ። «ብኢድ» ዝኾነ ኩነታት ባዕልኹም ክትመርጹ የፍቅድ (White ሓዊሱ፣ ኣውቶ ፈጺሙ ዘይመርጾ)።"
    override val autoSelect = "ኣውቶ ምረጻ"; override val manualSelect = "ብኢድ ምረጻ"
    override val connStatsTitle = "ምትእስሳራት ሕጂ"; override val connOnPort = "ምትእስሳራት ኣብ ፖርት"; override val outgoingConns = "ወጻኢ ምትእስሳራት"
    override val modeChoice = "ምረጻ ኩነታት"; override val autoChoice = "ኣውቶ ምረጻ"; override val manualChoice = "ብኢድ ቀዋሚ"
    override val directOnVpn = "ቀጥታዊ ምትእስሳር ናብ TG ኣብ VPN"; override val onWord = "ነቒሑ"; override val offWord = "ጠፊኡ"
    override val directStateActive = "ንጡፍ"; override val directStateOff = "ኣብ ቅጥዕታት ጠፊኡ"; override val directStateIdle = "ኣብ ቅጥዕታት ነቒሑ፣ ግን ንጡፍ ኣይኮነን"
    override val wpHintTitle = "White እንታይ እዩ?"
    override val wpHint = "White — WhitePages: ናይ ኢድ መርበብ ፕሮፋይል። ብኢድ ጥራይ ይነቅሕ (ኣውቶ-ምረጻ ፈጺሙ ኣይመርጾን)። " +
        "ናይ ገዛእ ርእሱ ደረጃ ሆስት ይሕዝ፣ ምዝገባታት የውርድን ካብ VPN/Wi-Fi/LTE ብናጻ ይድህስስን።"
}
