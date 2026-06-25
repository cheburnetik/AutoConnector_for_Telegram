package io.autoconnector.i18n

object Am : Strings by En {
    override val tabConnector = "አያያዥ"; override val tabScan = "ቅኝት"
    override val tabCatalog = "ካታሎግ"; override val tabLogs = "መዝገቦች"; override val tabMore = "ተጨማሪ"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "ምዝገባዎች"; override val logTabScan = "ቅኝት"
    override val logGeneral = "አጠቃላይ"; override val logEmpty = "ለአሁኑ ባዶ ነው"
    override val logSessions = "ክፍለ ጊዜዎች"; override val logErrorsOnly = "ስህተት ያላቸው ብቻ"; override val logNoErrors = "የከሸፉ ክፍለ ጊዜዎች የሉም"
    override fun logSession(id: String, port: String) = "#${id} · :${port}"
    override val back = "ተመለስ"; override val copy = "ቅዳ"; override val gotIt = "ገባኝ"
    override val later = "በኋላ"; override val details = "ዝርዝሮች"; override val whatIsThis = "ይህ ምንድን ነው?"
    override val delete = "ሰርዝ"

    override val connector = "አያያዥ"; override val scan = "ቅኝት"
    override val notConfigured = "አልተዋቀረም! አስተካክል →"; override val howToSetup = "እንዴት እንደሚዋቀር"
    override val notifOff = "ማሳወቂያዎች ጠፍተዋል! አስተካክል →"; override val enable = "አንቃ"
    override fun fewProxies(n: Int) = "ሕያው ፕሮክሲዎች ${n}፣ እየፈለግሁ ነው፣ ~15 ደቂቃ ጠብቅ…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "ሕያው ፕሮክሲዎች: ${alive}  (15 ደቂቃ: ${within}) · ጠቅላላ: ${total}"
    override val notifWhyTitle = "ለምን ማሳወቂያ?"
    override val notifWhyBody = "ቋሚ የማሳወቂያ አዶ ማለት የAndroid ግንባር-ቀደም አገልግሎት ማለት ነው። " +
        "ያለ እሱ ስርዓቱ መተግበሪያውን ከማስታወሻ ያስወግደዋል፣ ፕሮክሲ መፈለግን እና ግንኙነቱን በጀርባ " +
        "መያዝን ያቆማል። ለዚህ ነው AutoConnector እንዲሰራ ማሳወቂያዎች የሚያስፈልጉት።"
    override val notifEnableTitle = "ማሳወቂያዎችን አንቃ"
    override val notifEnableBody = "ያለ የማሳወቂያ አዶ Android መተግበሪያውን እንደ ቦዝኖ ይቆጥረዋል እና " +
        "ከማስታወሻ ያስወግደዋል። ከዚያም AutoConnector ፕሮክሲ መፈለግን እና ግንኙነቱን በጀርባ " +
        "መያዝን ያቆማል — Telegram ግንኙነቱን ያጣል።\n\n«አንቃ»ን ንካ እና ለAutoConnector " +
        "ማሳወቂያዎችን ፍቀድ።"
    override val notifPlea = "ማሳወቂያዎችን አንቃ! ያለ እነሱ መተግበሪያው በጀርባ መስራት አይችልም — " +
        "Android ያስወግደዋል፣ የፕሮክሲ ፍለጋ እና ግንኙነቱ ይቆማሉ።"

    override val statusConnected = "Telegram ተገናኝቷል"; override val statusConnecting = "በመገናኘት ላይ…"
    override val statusOffline = "Telegram አልተገናኘም"; override val statusIdle = "Telegram ዝም ብሏል"
    override val nobodyConnected = "ማንም ከአያያዡ ጋር አልተገናኘም። "; override val howToSetupArrow = "እንዴት እንደሚዋቀር →"
    override val directModeViaVpn = "ቀጥታ ሁነታ: VPN ንቁ ነው — ያለ ፕሮክሲ"
    override val directModeOff = "ቀጥታ ሁነታ: ፕሮክሲዎች ጠፍተዋል"
    override val directDpiSuffix = " · ጸረ-DPI"
    override val connections = "ግንኙነቶች"; override val sockets = "ሶኬቶች"; override val speed = "ፍጥነት"
    override val traffic = "ትራፊክ"; override val latency = "መዘግየት"
    override fun pcs(n: Int) = "${n} ቁ"
    override fun netNow(label: String) = "አውታረ መረብ: ${label}"
    override fun tgToConnector(n: Int) = "TG→ ${n}"
    override fun connectorToProxy(n: Int) = "ፕሮክሲ ${n}"
    override val trafficSec = "ትራፊክ · 60 ሰከንድ"; override val trafficMin = "ትራፊክ · 60 ደቂቃ"
    override val latencySec = "መዘግየት · 60 ሰከንድ"; override val latencyMin = "መዘግየት · 60 ደቂቃ"
    override val sec60 = "60 ሰከንድ"; override val min60 = "60 ደቂቃ"
    override val unitSec = "ሰ"; override val unitMin = "ደ"; override val unitHour = "ሰዓ"; override val dash = "—"
    override val currentProxy = "የአሁኑ ፕሮክሲ"; override val noActiveProxy = "ንቁ ፕሮክሲ የለም (Telegram አልተገናኘም)"
    override val host = "ሆስት"; override val type = "ዓይነት"; override val secret = "ሚስጥር"; override val antiDpi = "ጸረ-DPI"; override val obfEngine = "የማደበቅ ሞተር"
    override fun activeSockets(n: Int) = "ንቁ የTelegram ሶኬቶች: ${n}"
    override val noConnections = "ንቁ ግንኙነቶች የሉም"; override val colHost = "ሆስት"; override val colTime = "ሰዓት"
    override val modeWord = "ሁነታ"; override val directViaVpnLine = "ወደ Telegram ቀጥታ ጥያቄዎች (VPN ንቁ)"
    override val connModeHelp = "ሁነታዎች (VPN, Wi-Fi, LTE, Ethernet, White) የቅኝት ጥንካሬን በተለያየ መንገድ እንድታስተካክል እና የተለያዩ የሆስት ደረጃዎች/ስታቲስቲክስ እንዲቆዩ ያስችላሉ። የአውታረ መረብ ካርዱ በራስ-ሰር ይታወቃል፤ ሁነታው በቅንብሮች ውስጥ በእጅ ሊዋቀር ይችላል።"

    override val scanOff = "ቅኝት ጠፍቷል"; override val proxiesInBase = "በመረጃ ቋት ውስጥ ያሉ ፕሮክሲዎች"
    override val total = "ጠቅላላ"; override val alive = "ሕያው"; override val dead = "ሞተ"
    override val tgConnectedTitle = "Telegram የተገናኘበት"; override val successful = "ተሳክቷል"
    override val socketsHeld = "የሶኬት ቆይታ"; override val over1m = ">1 ደቂቃ"; override val over5m = ">5 ደቂቃ"; override val over15m = ">15 ደቂቃ"
    override val scanCountTitle = "የፕሮክሲ ቼክ ብዛት"; override val checked = "ተፈትሿል"
    override val forAllTime = "ሁልጊዜ"; override val perMinute = "በደቂቃ"; override val perHour = "በሰዓት"
    override val subsCountTitle = "የምዝገባ ማውረድ ብዛት"; override val downloaded = "ወርዷል"; override val failed = "ከሸፈ"; override val scanTraffic = "የቅኝት ትራፊክ"; override val subTraffic = "የምዝገባ ትራፊክ"; override val subTrafficGraph = "የምዝገባ ትራፊክ"
    override val checksMtproto = "MTProto ቼኮች (↑ ok · ↓ fail)"

    override fun catalogEmpty(mode: String) = "ካታሎግ ${mode} ለአሁኑ ባዶ ነው። ምንም ሆስት አልተገኘም፣ ወይም መተግበሪያው በዚህ ሁነታ ፈጽሞ አልሰራም። ሁነታውን በቅንብሮች ውስጥ መቀየር ትችላለህ። ሁነታዎች ለተለያዩ የበይነመረብ ግንኙነት ዓይነቶች ሆስቶችን ለየብቻ ለመሰብሰብ ተፈጥረዋል።"
    override val aliveShort = "✓ ሕያው"; override val deadShort = "✗ ሞተ"
    override val statusLabel = "ሁኔታ"; override val rating = "ደረጃ"; override val port = "ፖርት"
    override val rttPing = "RTT (ping)"; override val checkedField = "ተፈትሿል"; override val okOfTotal = "ስኬታማ / ጠቅላላ ቼኮች"
    override val tgConnectedField = "Telegram ተገናኝቷል"; override val tgSessions = "የTelegram ክፍለ ጊዜዎች"; override val trafficThroughProxy = "በፕሮክሲ በኩል ትራፊክ"
    override val sessionsTotal = "ጠቅላላ ክፍለ ጊዜዎች"; override val relayNow = "አሁን ማስተላለፍ"; override val tlsDomain = "TLS ጎራ (SNI)"
    override val sourceSub = "ምንጭ (ምዝገባ)"; override val lastError = "የመጨረሻ ስህተት"; override val yes = "አዎ"; override val no = "አይ"
    override val copyAsLink = "እንደ ሊንክ ቅዳ"; override val openInTelegram = "ሆስትን በTelegram ክፈት"; override val makeNextRelay = "ቀጣይ ማስተላለፊያ አድርግ"
    override val actCopy = "ቅዳ"; override val actOpen = "ክፈት"; override val actRelay = "ማስተላለፍ"
    override fun agoFmt(v: String) = "ከ${v} በፊት"
    override val catalogTopFor = "የፕሮክሲ ዝርዝር/ደረጃ ለ"
    override val catalogModeHelpTitle = "ሁነታዎች እና ደረጃዎች"
    override val catalogModeHelp = "መተግበሪያው ሕያው ሆስቶችን እና ደረጃቸውን በእያንዳንዱ የአውታረ መረብ ሁነታ (VPN, Wi-Fi, LTE, Ethernet እና White) ለየብቻ ይቆጥራል። «White» ለነጭ ዝርዝሮች የተለየ በእጅ የሚሰራ ሁነታ ነው፤ ራስ-ሰር ፈጽሞ ወደ እሱ አይቀየርም። ስለዚህ አንድ ሆስት በአንዱ ሁነታ ሕያው በሌላው ሙት ሊሆን ይችላል።"
    override fun catalogInactiveWarn(section: String, active: String) =
        "ቦዝኖ ያለውን ክፍል ${section} እየተመለከትክ ነው — አሁን ሁሉም ስታቲስቲክስ ወደ ${active} ይሄዳል እንጂ ወደዚህ አይደለም።"
    override val manageModeTitle = "ሁነታ አስተዳድር"
    override val manageResetRating = "ደረጃ ዳግም አስጀምር"
    override fun manageResetHint(mode: String) = "ለ${mode} በተለይ የሕያው ሆስቶችን ደረጃ እና የአጠቃቀም ስታቲስቲክስ ዳግም ማስጀመር ትችላለህ። ይህ ፍጹም የተለየ VPN ወይም LTE ጋር በተገናኘህ ጊዜ አሮጌ ስታቲስቲክስ እንዳይጣላ ጠቃሚ ነው። ወይም የፕሮክሲ ቅኝት ሁሉንም ከባዶ ምን ያህል በፍጥነት እንደገና እንደሚፈትሽ ለመመልከት።"
    override val manageDeleteAll = "ሆስቶችን ሰርዝ በ"
    override fun manageDeleteHint(mode: String) = "ከ${mode} ሁለቱንም ደረጃ እና ሆስቶቹን ራሳቸውን ማጽዳት ትችላለህ። «ፕሮክሲ ቅኝት» ባህሪ እንደገና ይሰበስባቸዋል። ይህ የምዝገባ ዳግም ማስጀመር አይደለም — ልትነካው ትችላለህ፣ ከዚያ ለድጋሚ ቅኝት ~15 ደቂቃ ጠብቅ።"
    override fun manageCopyFrom(mode: String) = "ሁሉንም ሆስቶች እና ደረጃዎች ከሌላ ሁነታ ወደዚህ ሁነታ (${mode}) ቅዳ:"
    override val live = "ሕያው"; override val deadW = "ሞተ"; override val unitMs = "ሚሰ"
    override val agoMin = "ደ"; override val agoHour = "ሰ"; override val agoDay = "ቀ"

    override val connectTelegram = "Telegram በመገናኘት ላይ"; override val readCarefully = "በጥንቃቄ አንብብ!"
    override val guideIntro = "ይህ መተግበሪያ ያለ ማዋቀር አይሰራም። ከታች ካሉት 3 አማራጮች ማንኛውንም አንዱን " +
        "ምረጥ እና መመሪያውን በጥንቃቄ ተከተል።"
    override val variant1 = "አማራጭ #1 — ቁልፎች"
    override val variant1Body = "«ፕሮክሲ {A}»ን ንካ — Telegram ይከፈታል፣ ፕሮክሲ መጨመርን አረጋግጥ። ወደዚህ " +
        "ማያ ተመለስ እና «ፕሮክሲ {B}»ን ንካ — ለሁለተኛ ጊዜ መጨመርን አረጋግጥ።\n\nበTelegram ውስጥ ማንኛውንም " +
        "ሌሎች አሮጌ ፕሮክሲዎችን አሰናክል። በትክክል 2 ፕሮክሲዎች መቅረት አለባቸው — ፖርቶች {A} እና {B}። " +
        "በማንኛውም ሌላ ስብስብ AutoConnector አይሰራም።"
    override val variant2 = "አማራጭ #2 — ሊንኮች"
    override val variant2Body = "ከታች ያለውን ጽሑፍ በTelegram ውስጥ ወደ Saved Messages (ወይም ማንኛውም ውይይት) ቅዳ — " +
        "ማለትም ለራስህ ላከው። በመልእክትህ ውስጥ የመጀመሪያውን ሊንክ ንካ — የመጀመሪያው ፕሮክሲ ተጨመረ። " +
        "ሁለተኛውን ሊንክ ንካ — ሁለተኛው ተጨመረ። ከዚያ ሁሉንም አሮጌ ፕሮክሲዎች አሰናክል።"
    override val variant3 = "አማራጭ #3 — በእጅ"
    override val variant3Body = "SOCKS5 ፕሮክሲ በእጅ ጨምር: ሰርቨር localhost (127.0.0.1)፣ ፖርት {A}። " +
        "ከዚያ ሁለተኛ ፕሮክሲ: localhost፣ ፖርት {B}። ማንኛውንም አሮጌ ፕሮክሲዎች ሰርዝ።"
    override val whatNext = "ቀጥሎ ምን?"
    override val whatNextBody = "በTelegram ውስጥ «ፕሮክሲ ራስ-ቀያሪ» አንቃ — 5 ሰከንድ። ንቁ ያልሆነ ወይም " +
        "«አይገኝም» ተብሎ የተሰየመ ፕሮክሲ (በTelegram ውስጥ) በእጅ በመንካት Telegram እንዲገናኝ መርዳት ትችላለህ — " +
        "ይህ Telegram ለመገናኘት የበለጠ እንዲጥር ያደርጋል።\n\nከ{A} እና {B} በስተቀር ሌሎች ሁሉም አሮጌ " +
        "ፕሮክሲዎች መወገዳቸውን አረጋግጥ። በTelegram ውስጥ " +
        "«ፕሮክሲ ተጠቀም»ን ንካ።\n\nመተግበሪያው በቂ ፕሮክሲዎችን እስኪያገኝ እና እስኪያወርድ ጠብቅ " +
        "(5–15 ደቂቃ)። ከዚያ Telegram በራሱ ከAutoConnector ጋር ይገናኛል፣ እሱም Telegram በምርጥ " +
        "ፕሮክሲዎች በኩል ማስተላለፉን ይቀጥላል: የተፈተሹ፣ ሕያው እና ፈጣን።\n\nመመሪያው አስቸጋሪ " +
        "ቢመስል — ይቅርታ፣ መተግበሪያውን መጠቀም አትችልም: ሁሉንም ነገር በራስ-ሰር ማዋቀር " +
        "የማይቻል ነው፣ እና ሕያው ፕሮክሲ መፈለግ ጊዜ ይወስዳል።\n\nመተግበሪያውን ከረጅም ጊዜ በፊት " +
        "አውርደህ ምንም ሕያው ፕሮክሲ ካልተገኘ — መተግበሪያውን ወይም የምዝገባ ዝርዝሩን አዘምን። ይህ መተግበሪያ " +
        "የራሱን ፕሮክሲ አይፈጥርም ወይም አያቀርብም፣ በደርዘን የሚቆጠሩ ቡድኖችን እና ገጾችን " +
        "በበይነመረብ ላይ ብቻ ይፈልጋል።"
    override fun proxyBtn(port: Int) = "ፕሮክሲ ${port}"

    override val setupPortsTitle = "በTelegram ውስጥ ፖርቶችን አዋቅር"
    override val setupPortsSub = "Telegram ከአያያዡ ጋር እንዴት እንደሚገናኝ (ፖርቶች 55001/55002)"
    override val settings = "ቅንብሮች"; override val settingsSub = "ፖርቶች፣ ጸረ-DPI፣ ቅኝት፣ አውታረ መረብ፣ ባትሪ"
    override val subscriptions = "ምዝገባዎች"; override val subscriptionsSub = "ለቅኝት የፕሮክሲ ምንጮች"
    override val statistics = "ስታቲስቲክስ"; override val statisticsSub = "የፕሮክሲ መረጃ ቋት + ጸረ-DPI ዘዴዎች"
    override val export = "ላክ"; override val exportSub = "የሕያው ፕሮክሲዎች tg:// ሊንኮች"
    override val about = "ስለ"; override val aboutSub = "ስሪት፣ ግንባታ፣ ማውረድ፣ አስተያየት"
    override val hotkeys = "ቁልፍ አቋራጮች"
    override val hotkeysSub = "ዓለም አቀፍ ቁልፎች: ፕሮክሲ ቅዳ / ክፈት"
    override val hotkeysIntro = "ዓለም አቀፍ ቁልፍ አቋራጮች የመተግበሪያው መስኮት ትኩረት ላይ ባይሆንም እንኳ " +
        "ይሰራሉ። ከመረጃ ቋቱ ውስጥ የዘፈቀደ ሕያው ፕሮክሲ ሊንክ (tg://) ይመርጣሉ — መተግበሪያውን ሳትከፍት " +
        "ፕሮክሲዎችን በፍጥነት ለመቀየር ምቹ ናቸው።"
    override val hotkeysNote = "በmacOS ቁልፎችን መያዝ የAccessibility ፍቃድ ሊጠይቅ ይችላል " +
        "(System Settings → Privacy & Security → Accessibility)።"
    override val hotkeyCopyTitle = "የፕሮክሲ ሊንክ ቅዳ"
    override val hotkeyCopyDesc = "የዘፈቀደ ሕያው tg:// ሊንክ በቅንጥብ ሰሌዳ ላይ ያስቀምጣል።"
    override val hotkeyEnable = "ቁልፍ አቋራጮችን አንቃ"; override val hotkeyLetterLabel = "ፊደል"; override val hotkeySet = "አስቀምጥ"; override val hotkeyReset = "ዳግም አስጀምር"
    override val hotkeyOpenTitle = "ፕሮክሲን በTelegram ክፈት"
    override val hotkeyOpenDesc = "የዘፈቀደ ሕያው ሊንክ ይከፍታል — Telegram ይይዘውና ፕሮክሲ ለመገናኘት ይጠይቃል።"

    override val relayPorts = "የማስተላለፊያ ፖርቶች"
    override val relayPortsHelp = "አያያዡ የሚያዳምጥባቸው አካባቢያዊ ፖርቶች። እነዚህኑ በትክክል " +
        "በTelegram ውስጥ እንደ SOCKS5 ፕሮክሲ (127.0.0.1 : ፖርት) ታስገባለህ። ለአስተማማኝነት ሁለት ፖርቶች ይጠቀማሉ — Telegram " +
        "ለሁለቱም ግንኙነት ይይዛል።"
    override val portA = "ፖርት A"; override val portB = "ፖርት B"
    override val antiDpiTrick = "ጸረ-DPI ዘዴ"
    override val antiDpiHelp = "ISP/DPI እንዳያውቅ እና እንዳይዘጋው ግንኙነቱን ለመደበቅ የሚያስችል መንገድ።" +
        "\n• «ራስ-ማሽከርከር» ራሱ የሚሰራ ዘዴ ይመርጣል።\n• «የDPI ዘዴዎች የሉም» — ተራ " +
        "ግንኙነት።\n• ሌሎቹ የተወሰኑ ቴክኒኮች ናቸው (የአሳሽ መምሰል፣ የፓኬት መከፋፈል ወዘተ)።"
    override val onlyFakeTls = "FakeTLS ብቻ (ee)"
    override val applyDpiTo = "ጸረ-DPI ተግብር በ"
    override val applyDpiHelp = "የተመረጠውን ጸረ-DPI ዘዴ ለምን መተግበር:\n• Telegram ማስተላለፍ — በአያያዡ በኩል ለሚሰራ " +
        "ሕያው የTelegram ግንኙነት።\n• ፕሮክሲ ምርመራዎች — ለጀርባ ፕሮክሲ ቼኮች " +
        "(ከዚያ ቼኩ ልክ እንደ እውነተኛ ግንኙነት ይሰራል፣ የዘዴ ስታቲስቲክስ የበለጠ ትክክለኛ ይሆናል)።\n" +
        "• በቀጥታ ሲገናኝ — ፕሮክሲዎች ሲጠፉ (ወይም VPN ሲነቃ ሲዘለሉ) እና Telegram " +
        "በቀጥታ ወደ ሰርቨሮቹ ሲሄድ: እዚህ ፕሮክሲ የለም፣ ስለዚህ ዘዴው የመጀመሪያውን TCP ፓኬት " +
        "(handshake) DPI በአንድ ንባብ እንዳያዛምድ ወደ ብዙ ትናንሽ ክፍሎች መከፋፈል ይሆናል።"
    override val toRelay = "Telegram ማስተላለፍ"; override val toProbes = "ፕሮክሲ ምርመራዎች"
    override val toDirect = "በቀጥታ ሲገናኝ"
    override val vpnSection = "VPN ሲነቃ"
    override val vpnHelp = "በመሣሪያው ላይ VPN ንቁ ሲሆን ምን ማድረግ:\n• በMTProto ፕሮክሲ — " +
        "Telegram እንደተለመደው በተገኙት ፕሮክሲዎች ይሄዳል (በVPN ላይ)።\n• በቀጥታ — " +
        "አያያዡ ፕሮክሲ አይጠቀምም እና Telegram በቀጥታ ከTelegram ሰርቨሮች ጋር ያገናኛል: " +
        "VPN አስቀድሞ መዳረሻ ይሰጣል፣ ተጨማሪ የፕሮክሲ ንብርብር አያስፈልግም (ፈጣን እና የተረጋጋ)። " +
        "ያለ VPN ፕሮክሲዎች እንደተለመደው ይጠቀማሉ።"
    override val linkFormat = "የፕሮክሲ ሊንክ ቅርጸት"
    override val linkFormatHelp = "ፕሮክሲዎችን እንዴት መቅዳት እና መክፈት እንደሚቻል። tg:// Telegram በቀጥታ ይከፍታል (የተጫነ Telegram Desktop ይፈልጋል)። http (t.me) በአሳሽ በኩል ይከፍታል እና በTelegram ለመክፈት ይጠይቃል — tg:// ካልተመዘገበ ምቹ ነው።"
    override val linkTg = "tg:// (Telegram በቀጥታ ክፈት)"; override val linkTgSub = "tg://proxy?… — Telegram ይከፍታል"
    override val linkHttp = "http (t.me, በአሳሽ)"; override val linkHttpSub = "https://t.me/proxy?… — አሳሽ ይከፍታል"
    override val viaMtproto = "ፕሮክሲ በMTProto"; override val viaMtprotoSub = "በVPN ጊዜም ቢሆን ትራፊክ በፕሮክሲዎች ይሄዳል"
    override val directly = "በቀጥታ ተገናኝ"; override val directlySub = "VPN ንቁ ሲሆን — ፕሮክሲዎችን አልፎ፣ በቀጥታ ወደ Telegram"
    override val notifications = "ማሳወቂያዎች"
    override val scanCheck = "ቅኝት እና ቼክ"
    override val scanCheckHelp = "• ቅኝት፣ ደቂቃ — የፕሮክሲ ዝርዝሮችን ከምዝገባዎች ምን ያህል ጊዜ ማውረድ።\n" +
        "• ቼክ፣ ደቂቃ — በመረጃ ቋቱ ውስጥ ያሉ ፕሮክሲዎችን ለሕያውነት ምን ያህል ጊዜ መፈተሽ።\n• የጥቅል መጠን — " +
        "በአንድ ሩጫ ስንት ፕሮክሲ መፈተሽ።\n• ትይዩ — በአንድ ጊዜ ስንት ቼክ ማካሄድ (ብዙ = " +
        "ፈጣን፣ ግን ከፍተኛ የአውታረ መረብ እና ባትሪ ጫና)።"
    override val scanMin = "ቅኝት፣ ደቂቃ"; override val checkMin = "ቼክ፣ ደቂቃ"; override val batchSize = "የጥቅል መጠን"; override val parallel = "ትይዩ"
    override val speedByNet = "የቅኝት ጥንካሬ በአውታረ መረብ"
    override val speedByNetHelp = "እንደ የአሁኑ አውታረ መረብ ፕሮክሲዎችን ምን ያህል ጊዜ መፈተሽ። " +
        "«መደበኛ» = መሰረታዊ ክፍተት። ወደ ቀኝ አንሸራትት ለአልፎ አልፎ (ቀርፋፋ፣ ለትራፊክ/ባትሪ ለስለስ ያለ)፣ " +
        "ወደ ግራ ለበለጠ ጊዜ (ፈጣን፣ የበለጠ ጨካኝ)። ሎጋሪዝም ሚዛን፣ እስከ ×100 በእያንዳንዱ አቅጣጫ።\n" +
        "• VPN — ውጫዊ VPN ንቁ ሲሆን።\n• Wi-Fi — በWi-Fi አውታረ መረብ።\n• LTE — በሞባይል አውታረ መረብ።"
    override val intensStandard = "መደበኛ"
    override val intensSlower = "ቀርፋፋ"
    override val intensFaster = "ፈጣን"
    override val maintenance = "ውሂብ ዳግም አስጀምር"
    override val maintenanceHelp = "• «ካታሎግ እና ስታቲስቲክስ ዳግም አስጀምር» — ደረጃዎችን፣ ቆጣሪዎችን፣ ትራፊክ " +
        "እና የቼክ መዝገቦችን ያዜራል፣ ግን የወረዱ ሆስቶችን እና ምዝገባዎችን ይይዛል (ሁሉም በሚቀጥለው ቅኝት እንደገና ይገመገማል)።\n" +
        "• «የወረዱ ሆስቶችን አጽዳ» — ሙሉውን የፕሮክሲ ስብስብ ይሰርዛል ግን ምዝገባዎችን ይይዛል " +
        "ስለዚህ ቅኝት ስብስቡን እንደገና ይሞላል። ምዝገባዎች በማንኛውም መንገድ አይነኩም።"
    override val backupTitle = "ላክ / አስገባ"
    override val backupHelp = "የመተግበሪያ ውሂብ እንደ JSON አስቀምጥ ወይም መልስ። ምን እንደሚካተት " +
        "ምልክት አድርግ — ማንኛውም ጥምረት:\n• ቅንብሮች — ሁሉም የመተግበሪያ ግቤቶች።\n• ምዝገባዎች — የምንጭ " +
        "ዝርዝር (URL + አብራ/አጥፋ)።\n• የሕያው ሆስት ካታሎግ — እያንዳንዱ ሕያው ፕሮክሲ ከደረጃዎቹ እና ስታቲስቲክሱ ጋር " +
        "በእያንዳንዱ የአውታረ መረብ ሁነታ።\n\n«ላክ» ዝግጁ JSON ያለበትን ገጽ ይከፍታል — ቅዳው ወይም ወደ ፋይል አስቀምጥ። " +
        "«አስገባ» — JSON ለጥፍ (ወይም ፋይል ጫን) እና በውስጡ ያሉትን ምልክት የተደረገባቸውን ክፍሎች ብቻ ይተገብራል። " +
        "ማስገባት ወደ የአሁኑ ውሂብ ይጨምራል (ምንም አይደመስስም)።"
    override val backupSettings = "ቅንብሮች"
    override val backupSubs = "ምዝገባዎች"
    override val backupHosts = "የሕያው ሆስት ካታሎግ (በሁነታ)"
    override val exportWord = "ላክ"
    override val importWord = "አስገባ"
    override val backupExportTitle = "ውሂብ ላክ"
    override val backupImportTitle = "ውሂብ አስገባ"
    override val backupSelectExport = "ምን እንደሚላክ:"
    override val backupSelectImport = "ምን እንደሚገባ:"
    override val backupCopyBtn = "ቅዳ"
    override val backupSaveFile = "ወደ ፋይል አስቀምጥ"
    override val backupLoadFile = "ከፋይል ጫን"
    override val backupDoImport = "አስገባ"
    override val backupPasteLabel = "የመጠባበቂያ JSON እዚህ ለጥፍ"
    override val backupJsonLabel = "የመጠባበቂያ JSON"
    override val backupAndroidFileNote = "ፋይሎች እዚህ አይገኙም — ቅዳ / ለጥፍ ተጠቀም።"
    override val eraseAllHosts = "ሁሉንም ሆስቶች ደምስስ"
    override val factoryReset = "ሁሉንም ዳግም አስጀምር (እንደ መጀመሪያ ማስጀመር)"
    override val factoryResetConfirm = "መተግበሪያውን ሙሉ በሙሉ ወደ ፋብሪካ ሁኔታ ዳግም ማስጀመር? ሁሉም ቅንብሮች እና ሙሉ " +
        "የሆስት ካታሎግ ይደመሰሳሉ፣ ምዝገባዎች ወደ ነባሪ ይመለሳሉ። ልክ እንደ መጀመሪያ ማስጀመር።"
    override val resetCatalog = "ካታሎግ እና ስታቲስቲክስ ዳግም አስጀምር"
    override val resetCatalogConfirm = "ሁሉንም ደረጃዎች፣ ቆጣሪዎች እና የቼክ መዝገቦች ዜሮ ማድረግ? " +
        "የወረዱ ሆስቶች እና ምዝገባዎች ይቆያሉ እና በሚቀጥለው ቅኝት እንደገና ይገመገማሉ።"
    override val clearHosts = "የወረዱ ሆስቶችን አጽዳ"
    override val clearHostsConfirm = "ሙሉውን የወረዱ ሆስቶች (ፕሮክሲዎች) ዝርዝር መሰረዝ? " +
        "ምዝገባዎች ይቆያሉ እና ቅኝት ስብስቡን እንደገና ይሞላል።"
    override val doReset = "ዳግም አስጀምር"
    override val doCancel = "ሰርዝ"
    override val adaptiveSpeed = "ተለማማጅ ፍጥነት"
    override val adaptiveHelp = "የሕያውነት ቼኮች በመሰረታዊ ክፍተት ይሰራሉ (ከ«ቅኝት እና ቼክ»፣ እንዲሁም " +
        "በአውታረ መረብ አባዢ ተባዝቶ)። «ተለማማጅ ፍጥነት» አሁን ስንት ፕሮክሲ ሕያው እንደሆነ መሰረት አድርጎ " +
        "በራስ-ሰር ያፋጥናቸዋል ወይም ያቀዝዛቸዋል።\n\n" +
        "• ሕያው ጥቂት (ከ«ጥቂት» ገደብ በታች) → ክፍተት × «ማፍጠን»። ከ1 በታች አባዢ = ብዙ ጊዜ: " +
        "0.5 — ሁለት እጥፍ ጊዜ፣ 0.25 — 4×። ስብስቡን በፍጥነት ይሞላል።\n" +
        "• ሕያው ብዙ (ከ«ብዙ» ገደብ በላይ) → ክፍተት × «ማቀዝቀዝ»። ከ1 በላይ = አልፎ አልፎ: 2 — " +
        "ግማሽ ጊዜ፣ 4 — ሩብ። ባትሪ እና ትራፊክ ይቆጥባል።\n" +
        "• በገደቦቹ መካከል — መሰረታዊ ፍጥነት (×1)።\n\n" +
        "ምሳሌዎች:\n" +
        "— ፕሮክሲዎችን በፍጥነት መሰብሰብ: «ማፍጠን» 0.25 እና/ወይም «ጥቂት» ገደብ 40።\n" +
        "— በቂ ሲኖርህ ባትሪ መቆጠብ: «ማቀዝቀዝ» 8 እና/ወይም «ብዙ» ገደብ 30።\n" +
        "— ተለማማጅነትን አጥፋ: ሁለቱንም አባዢዎች 1 አድርግ።\n\n" +
        "ነባሪዎች: ጥቂት 20፣ ማፍጠን 0.5፣ ብዙ 50፣ ማቀዝቀዝ 4።"
    override val threshMany = "«ብዙ» ገደብ"; override val threshFew = "«ጥቂት» ገደብ"; override val mulFast = "ማፍጠን ×"; override val mulLazy = "ማቀዝቀዝ ×"
    override val subIntensityTitle = "የምዝገባ ጥንካሬ"
    override val subIntensityHint = "በምዝገባ ማውረዶች መካከል ያለ ቆም: የፕሮክሲ ዝርዝሮችን እንደገና ከማውረዱ በፊት ስንት ደቂቃ (በእያንዳንዱ የአውታረ መረብ ሁነታ ለየብቻ)።"
    override val baseScanTitle = "መሰረታዊ የቅኝት ፍጥነት"
    override val baseScanHelp = "የማመሳከሪያ የሕያውነት-ቼክ ፍጥነት። «ተለማማጅ ፍጥነት» እና «በሁነታ ፍጥነት» " +
        "አባዢዎች ከእሱ አንጻር ይሰላሉ።\n\n" +
        "• ምን ያህል ጊዜ መሮጥ፣ ደቂቃ — በቼክ ማለፊያዎች መካከል ያለ ክፍተት።\n" +
        "• በክር ጥቅል፣ ሆስቶች — እያንዳንዱ ክር በማለፊያ ስንት ሆስት ይፈትሻል።\n" +
        "• ክሮች — በአንድ ጊዜ ስንት ቼክ ይሮጣል። ማለፊያ «ጥቅል × ክሮች» ሆስቶችን ይመረምራል።\n" +
        "• ሆስትን ከN ደቂቃ በበለጠ ጊዜ እንደገና አታስስ — ጸረ-ጎርፍ: በቅርቡ የተፈተሸ ሆስት " +
        "በዚህ ማለፊያ ይዘለላል።\n\n" +
        "ብዙ ክሮች እና ትልቅ ጥቅል = ፈጣን የስብስብ እድገት፣ ግን ከባድ የአውታረ መረብ እና ባትሪ ጫና።"
    override val baseScanPeriod = "ምን ያህል ጊዜ መሮጥ፣ ደቂቃ"
    override val baseScanBatch = "በክር ጥቅል፣ ሆስቶች"; override val baseScanThreads = "የክር ብዛት"
    override val adaptiveDesc = "ሕያው ፕሮክሲዎች ከ«ጥቂት» ያነሱ ወይም ከ«ብዙ» የበለጡ ከሆኑ ተጨማሪ አባዢ ተግብር።"
    override val fewWord = "ጥቂት"; override val manyWord = "ብዙ"
    override fun fasterX(x: String) = "${x}× ፈጣን"
    override fun slowerX(x: String) = "${x}× ቀርፋፋ"
    override fun ifAliveLt(n: Int) = "ሕያው ፕሮክሲዎች < ${n} ከሆኑ፣ ከዚያ:"
    override fun ifAliveGt(n: Int) = "ሕያው ፕሮክሲዎች > ${n} ከሆኑ፣ ከዚያ:"
    override val disabledWord = "ጠፍቷል"
    override val speedByModeTitle = "በሁነታ ፍጥነት"
    override val speedByModeHelp = "ለእያንዳንዱ የአውታረ መረብ ሁነታ የቅኝት-ፍጥነት አባዢ፣ ከመሰረታዊ " +
        "ፍጥነት በላይ። «መደበኛ» (×1) = መሰረታዊ ክፍተት። ቀኝ — አልፎ አልፎ (ቀርፋፋ፣ ለትራፊክ/" +
        "ባትሪ ለስለስ ያለ)፣ ግራ — ብዙ ጊዜ (ፈጣን፣ የበለጠ ጨካኝ)። ሎጋሪዝም ሚዛን፣ እስከ ×100 በእያንዳንዱ " +
        "አቅጣጫ።\n\n" +
        "በእያንዳንዱ ተንሸራታች ስር ተለማማጅ ፍጥነት የተተገበረባቸው የውጤት ማለፊያ ግቤቶች — " +
        "ለ«ጥቂት ሕያው» (× «ማፍጠን») እና «ብዙ ሕያው» (× «ማቀዝቀዝ») ለየብቻ ይታያሉ።\n\n" +
        "ሁነታዎች:\n• VPN — ውጫዊ VPN ንቁ ነው።\n• LTE — ሞባይል አውታረ መረብ።\n• Wi-Fi — Wi-Fi አውታረ መረብ።\n" +
        "• Ethernet — ባለ ገመድ ግንኙነት።\n• White — በእጅ የሚሰራ «ነጭ» ፕሮክሲ ሁነታ።"
    override val aliveLt = "ሕያው <"; override val aliveGt = "ሕያው >"
    override val periodWord = "ክፍለ ጊዜ"; override val nonstopWord = "ያለማቋረጥ"
    override val batchWord = "ጥቅል"; override val threadsWord = "ክሮች"; override val scanModeOff = "ቅኝት ጠፍቷል"
    override val netBattery = "አውታረ መረብ እና ባትሪ"
    override val netBatteryHelp = "• Wi-Fi ብቻ — በሞባይል አውታረ መረቦች ላይ አታስስ (ውሂብ ይቆጥባል)።\n• በመሙላት " +
        "ላይ ብቻ — ስልኩ በሚሞላበት ጊዜ ብቻ ስራ።\n• ባትሪ ሲቀንስ ዝለል — ባትሪው ዝቅተኛ ሲሆን " +
        "ቅኝትን አቁም።"
    override val onlyWifi = "Wi-Fi ብቻ"; override val onlyCharging = "በመሙላት ላይ ብቻ"; override val skipLowBattery = "ባትሪ ሲቀንስ ዝለል"
    override val autosaved = "ቅንብሮች በራስ-ሰር ይቀመጣሉ።"
    override val dpiAutoLabel = "የDPI ዘዴዎችን ራስ-ማሽከርከር"; override val dpiNoneLabel = "የDPI ዘዴዎች የሉም (ተራ)"
    override val experimental = "ሙከራዊ"
    override val experimentalHelp = "ከMTProto upstream አማራጭ የፕሮክሲ ሞተሮች እና የምርመራ መዝገብ። " +
        "ወደ «ጠፍቷል» ሲዋቀር የማመሳከሪያው (የሚሰራው) መንገድ አይለወጥም። የተመሰጠረው ዥረት ወደ " +
        "upstream TCP ሶኬት የሚጻፍበት መንገድ ብቻ ይለወጣል (የክፍል መጠኖች፣ ጊዜ፣ TLS-record ድንበሮች) — ዥረቱ ራሱ ባይት-በ-ባይት ተመሳሳይ ይቆያል። " +
        "ለሕያው ፕሮክሲ ማስተላለፍ ብቻ ይተገበራል (ለምርመራዎች ወይም ለቀጥታ መንገድ አይደለም)።"
    override val expEngineTitle = "የፕሮክሲ ሞተር (የሶኬት ማደበቅ)"
    override val expConnectTitle = "የግንኙነት ሞተር (upstream ምርጫ)"
    override val expEngineWarn = "⚠ ሙከራዊ ሁነታ። ግንኙነቱ ከባሰ፣ ወደ «ጠፍቷል (የማመሳከሪያ መንገድ)» ተመለስ።"
    override val netLog = "የአውታረ መረብ-ልውውጥ መዝገብ አንቃ"
    override val netLogSub = "ማን-ለማን-መቼ እና የፓኬት መጠኖችን ወደ ፋይል ይጽፋል (ምንም የክፍያ ጭነት ውሂብ የለም) — " +
        "የልውውጥ ስርዓቱን ከVPN ጋር እና ያለ VPN ለማወዳደር።"
    override val openLogFolder = "የመዝገብ አቃፊ ክፈት"; override val copyPath = "መንገድ ቅዳ"
    override val helpShow = "እገዛ"; override val helpHide = "እገዛ ደብቅ"
    override val quickSwitchIntro = "እዚህ የእገዳ-ማለፊያ ዘዴ መምረጥ ትችላለህ። Telegram " +
        "«The proxy you are using is not configured correctly and will be disabled. Please find another " +
        "one» የሚል ስህተት ካሳየ፣ Telegram ማሳየቱን እንዲያቆም የትኛው የትራፊክ-ማደበቂያ ዓይነት እንደሚሰራ ሞክር። " +
        "በsplit* ሁነታዎች ጀምር። coalesce* ሁነታዎችም ይሰራሉ፣ ግን ከእነሱ ጋር ምስሎች/ቪዲዮዎች በTelegram በደንብ አይጫኑም።"
    override val quickSwitchTitle ="የእገዳ ማለፊያ"; override val quickSwitchSub = "ቅርጽ መስጠት፣ ግንኙነት፣ ጸረ-DPI"

    override val sourceUrl = "የምንጭ URL"
    override fun sourceAlive(alive: Int, total: Int) = "ሕያው ${alive}/${total}"
    override val open = "ክፈት"; override val active = "ንቁ"; override val inactive = "ቦዝኗል"
    override val lastDownloaded = "ወርዷል"; override val notDownloaded = "ገና አልወረደም"
    override fun sourceCounts(dead: Int, total: Int) =
        " ሕያው፣ ${dead} ሙት፣ ${total} ጠቅላላ"

    override val proxyBase = "የፕሮክሲ መረጃ ቋት"
    override val totalInBase = "በመረጃ ቋት ጠቅላላ"; override val aliveNow = "አሁን ሕያው"; override val deadStat = "ሙት"
    override val aliveIn15 = "በ15 ደቂቃ ሕያው"; override val checksAllTime = "ሁልጊዜ ቼኮች"
    override val antiDpiTricks = "ጸረ-DPI ዘዴዎች"; override val noStatsYet = "ገና ውሂብ የለም — ዘዴዎች ቼኮች/ግንኙነቶች ሲከሰቱ ይከማቻሉ"
    override val attempts = "ሙከራዎች"; override val handshake = "Handshake"; override val score = "ነጥብ"
    override val tgConnect = "TG ግንኙነት"; override val socketsOver1m = "ሶኬቶች >1ደቂቃ"
    override val over10kb = "ሶኬቶች >10KB"; override val over100kb = ">100KB"; override val workTime = "የስራ ጊዜ"
    override val statsLegend = "Handshake — ስኬታማ handshake-ዎች (% ከሙከራዎች) · ነጥብ — ዋጋ · " +
        "«የስራ ጊዜ» — በሶኬቶች ≥5KB እና ከ1 ደቂቃ በላይ ድምር።"
    override val resetStats = "የዘዴ ስታቲስቲክስ ዳግም አስጀምር"

    override fun aliveLinks(n: Int) = "ሕያው ሊንኮች: ${n}"
    override val copyAll = "ሁሉንም ቅዳ"
    override val openRandom = "የዘፈቀደ ክፈት"; override val copyRandom = "የዘፈቀደ ቅዳ"; override val allShort = "ሁሉም"
    override val copyTop = "TOP ቅዳ"; override val randomHost = "የዘፈቀደ ሆስት"
    override val exportToFile = "ወደ ፋይል ላክ"; override val exportSaved = "ወደ ፋይል ተቀምጧል:"
    override val dlNow = "አሁን አውርድ"
    override fun downloadingFmt(sec: Long) = "በማውረድ ላይ… ${sec}ሰ"
    override val cancel = "ሰርዝ"
    override val deleteConfirmTitle = "ምዝገባ ይሰረዝ?"
    override val subscriptionsAddHint = "ምዝገባዎችን ወይም ፕሮክሲ ሊንኮችን ጨምር →"
    override val addSourcesTitle = "ጨምር"
    override val addSubsLabel = "ምዝገባዎች (በመስመር አንድ URL)"
    override val addSubsHelp = "ትክክለኛ URL ያለው እያንዳንዱ መስመር የራሱ ምዝገባ ይሆናል እና በየጊዜው ይወርዳል።"
    override val addProxiesLabel = "ዝግጁ ፕሮክሲ ሊንኮች (ቋሚ ዝርዝር)"
    override val addProxiesHelp = "ወደ ተወሰኑ ፕሮክሲዎች የሊንኮች ስብስብ ለጥፍ (tg://proxy, https://t.me/proxy, …)። ይህ ምዝገባ አይደለም — ዝርዝሩ ፈጽሞ አይወርድም፣ ፕሮክሲዎች ወደ ካታሎጉ ብቻ ይጨመራሉ።"
    override val addButton = "ጨምር"
    override fun addedFmt(subs: Int, proxies: Int) = "ተጨምሯል: ${subs} ምዝገባዎች፣ ${proxies} ፕሮክሲዎች"
    override val perSecond = "በሰከንድ"
    override val graphSpeed = "ፍጥነት"
    override val graphVolume = "መጠን"
    override val graphLatency = "Ping"
    override val graphConnects = "ግንኙነቶች"
    override val scanNow = "አሁን አስስ"; override val scanOnShort = "ቅኝት በርቷል"
    override val scanRunning = "ቅኝት እየሮጠ ነው"; override val scanIdle = "ቅኝት ስራ ፈት"; override val scanOffState = "ቅኝት ጠፍቷል"; override val scanBatchPerThread = "ጥቅል/ክር"; override val scanPassHosts = "በማለፊያ ሆስቶች"; override val minRescanLabel = "ሆስትን ከN ደቂቃ በበለጠ ጊዜ እንደገና አታስስ"
    override val scanPlanTitle = "ዕቅድ"; override val scanNowTitle = "አሁን"; override val currentScheduleTitle = "የአሁኑ መርሐ ግብር"
    override val scheduleWord = "መርሐ ግብር"; override val unitPcsPerSec = "ቁ/ሰ"
    override val scanNowThreadsLabel = "አሁን እየሮጡ ያሉ ክሮች"; override val scanNowPerThreadLabel = "በክር ቼኮች (ዕቅድ)"; override val scanNowElapsedLabel = "የሩጫ ጊዜ"
    override val scanOkGraph = "ስኬታማ ቅኝቶች"; override val scanFailGraph = "የከሸፉ ቅኝቶች"; override val scanTrafficGraph = "የቅኝት ትራፊክ"; override val scanAliveGraph = "ጠቅላላ ሕያው ፕሮክሲዎች"; override val scanPingGraph = "Ping"; override val threadsGraph = "ክሮች"
    override val scanEvery = "በየ"; override val scanNextRun = "ቀጣይ ሩጫ"
    override val scanThreads = "ክሮች"; override val scanBatch = "ጥቅል"
    override val scanElapsed = "እየሮጠ"; override val scanIdleNow = "—"
    override val effForFew = "ጥቂት ሲሆን"; override val effForMany = "ብዙ ሲሆን"
    override val effCheck = "ቼክ"; override val effBatch = "ጥቅል"; override val effPar = "ትይዩ"
    override val effContinuous = "ቀጣይነት ያለው"; override val secShort = "ሰ"; override val minShort = "ደቂቃ"

    override val appTagline = "ባለ ብዙ መድረክ ራስ-አያያዥ: Telegram የሚሰራባቸውን MTProto ፕሮክሲዎች " +
        "ይፈልጋል፣ ይፈትሻል እና ያስኬዳል።"
    override val version = "ስሪት"; override val buildDate = "የግንባታ ቀን"
    override val downloadSources = "ማውረድ እና ምንጮች"; override val openOnGithub = "በGitHub ክፈት"
    override val feedbackBugs = "አስተያየት እና የሳንካ ሪፖርቶች"; override val writeTelegram = "በTelegram ጻፍ"

    override val language = "ቋንቋ"; override val langAuto = "ራስ-ሰር (ስርዓት)"
    override val langWord = "ቋንቋ"
    override val raceWidthTitle = "ትይዩ ግንኙነቶች"
    override val connectionSection = "ግንኙነት እና የእገዳ ማለፊያ"
    override val connectionSectionHelp = "የግንኙነት ሞተር፣ ትይዩ upstream-ዎች፣ የፕሮክሲ ሞተር እና ጸረ-DPI ዘዴዎች — ሁሉም በአንድ ክፍል።"
    override val netLogSection = "የአውታረ መረብ ልውውጥ መዝገብ"
    override val platform = "መድረክ"

    override val scanModeTitle = "የአውታረ መረብ ሁነታ"; override val scanModeAuto = "ራስ-ሰር"; override val scanModeManualLabel = "በእጅ"
    override val activeModeLabel = "ንቁ ሁነታ"; override val formingListLabel = "ዝርዝር በመገንባት ላይ"; override val catalogModeTabs = "ሁነታ"
    override val resetModeRatings = "የሆስት ደረጃዎችን ዳግም አስጀምር"; override val forgetModeHosts = "የሁነታ ሆስቶችን እርሳ"
    override val exportModeTitle = "በሁነታ ላክ"; override val modePickerTitle = "ሁነታ"
    override val modeHelp = "እያንዳንዱ የአውታረ መረብ ሁነታ የራሱን የፕሮክሲ ደረጃዎች እና የራሱን የቅኝት + ምዝገባ-ማውረድ ጥንካሬ ይይዛል። «ራስ-ሰር» ሁነታውን ከንቁ አውታረ መረብ ይመርጣል። «በእጅ» ማንኛውንም ሁነታ ራስህ እንድትመርጥ ያስችላል (ራስ-ሰር ፈጽሞ የማይመርጠውን White ጨምሮ)።"
    override val autoSelect = "ራስ-ሰር ምረጥ"; override val manualSelect = "በእጅ ምረጥ"
    override val connStatsTitle = "አሁን ግንኙነቶች"; override val connOnPort = "በፖርት ግንኙነቶች"; override val outgoingConns = "ወጪ ግንኙነቶች"
    override val modeChoice = "ሁነታ ምርጫ"; override val autoChoice = "ራስ-ሰር ምርጫ"; override val manualChoice = "በእጅ ቋሚ"
    override val directOnVpn = "VPN ላይ ወደ TG ቀጥታ ግንኙነት"; override val onWord = "በርቷል"; override val offWord = "ጠፍቷል"
    override val directStateActive = "ንቁ"; override val directStateOff = "በቅንብሮች ጠፍቷል"; override val directStateIdle = "በቅንብሮች በርቷል፣ ግን ንቁ አይደለም"
    override val wpHintTitle = "White ምንድን ነው?"
    override val wpHint = "White — WhitePages: በእጅ የሚሰራ የአውታረ መረብ መገለጫ። የሚነቃው በእጅ ብቻ ነው (ራስ-ሰር ምርጫ ፈጽሞ አይመርጠውም)። " +
        "የራሱን የሆስት ደረጃዎች ይይዛል፣ ምዝገባዎችን ያወርዳል እና ከVPN/Wi-Fi/LTE ነጻ ሆኖ ያስሳል።"

    // tray
    override val trayOpenWindow = "መስኮት ክፈት"
    override val trayRefreshSubs = "ምዝገባዎችን አድስ"
    override val trayExit = "ውጣ"
    override fun trayConnectorLabel(on: Boolean) =
        if (on) "አያያዥ: በርቷል (አጥፋ)" else "አያያዥ: ጠፍቷል (አብራ)"
    override fun trayScanLabel(on: Boolean) =
        if (on) "ቅኝት: በርቷል (አጥፋ)" else "ቅኝት: ጠፍቷል (አብራ)"
    override fun trayLive(n: Int) = "ሕያው ፕሮክሲዎች: ${n}"
    override val appearance = "መልክ"
    override val themeLabel = "ገጽታ"
    override val themeAuto = "ራስ-ሰር (ከስርዓቱ ጋር)"
    override val themeLight = "ብሩህ"
    override val themeDark = "ጨለማ"
    override val drawGraphsLabel = "ግራፎችን ሣል"
    override val drawGraphsSub = "በአገናኝ እና በቅኝት ትሮች ላይ ቀጥታ ግራፎች — ባትሪ ለመቆጠብ ያጥፉት"
}
