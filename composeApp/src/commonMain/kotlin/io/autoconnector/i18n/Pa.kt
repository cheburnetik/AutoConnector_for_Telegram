package io.autoconnector.i18n

object Pa : Strings {
    override val tabConnector = "ਕਨੈਕਟਰ"; override val tabScan = "ਸਕੈਨ"
    override val tabCatalog = "ਕੈਟਾਲਾਗ"; override val tabLogs = "ਲਾਗ"; override val tabMore = "ਹੋਰ"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "ਸਬਸਕ੍ਰਿਪਸ਼ਨਾਂ"; override val logTabScan = "ਸਕੈਨ"
    override val logGeneral = "ਆਮ"; override val logEmpty = "ਹਾਲੇ ਖਾਲੀ"
    override val logSessions = "ਸੈਸ਼ਨ"; override val logErrorsOnly = "ਸਿਰਫ਼ ਗਲਤੀਆਂ"; override val logNoErrors = "ਕੋਈ ਅਸਫਲ ਸੈਸ਼ਨ ਨਹੀਂ"
    override fun logSession(id: String, port: String) = "#${id} · :${port}"
    override val back = "ਵਾਪਸ"; override val copy = "ਕਾਪੀ"; override val gotIt = "ਸਮਝ ਗਿਆ"
    override val later = "ਬਾਅਦ ਵਿੱਚ"; override val details = "ਵੇਰਵੇ"; override val whatIsThis = "ਇਹ ਕੀ ਹੈ?"
    override val delete = "ਮਿਟਾਓ"

    override val connector = "ਕਨੈਕਟਰ"; override val scan = "ਸਕੈਨ"
    override val notConfigured = "ਸੈੱਟ ਨਹੀਂ ਕੀਤਾ! ਠੀਕ ਕਰੋ →"; override val howToSetup = "ਸੈੱਟ ਅੱਪ ਕਿਵੇਂ ਕਰੀਏ"
    override val notifOff = "ਨੋਟੀਫਿਕੇਸ਼ਨ ਬੰਦ ਹਨ! ਠੀਕ ਕਰੋ →"; override val enable = "ਚਾਲੂ ਕਰੋ"
    override fun fewProxies(n: Int) = "ਚਾਲੂ ਪ੍ਰੌਕਸੀਆਂ ${n}, ਖੋਜ ਜਾਰੀ ਹੈ, ~15 ਮਿੰਟ ਉਡੀਕੋ…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "ਚਾਲੂ ਪ੍ਰੌਕਸੀਆਂ: ${alive}  (15 ਮਿੰਟ: ${within}) · ਕੁੱਲ: ${total}"
    override val notifWhyTitle = "ਨੋਟੀਫਿਕੇਸ਼ਨ ਕਿਉਂ?"
    override val notifWhyBody = "ਇੱਕ ਸਥਾਈ ਨੋਟੀਫਿਕੇਸ਼ਨ ਆਈਕਨ ਦਾ ਮਤਲਬ ਹੈ ਇੱਕ Android ਫੋਰਗ੍ਰਾਊਂਡ ਸੇਵਾ। " +
        "ਇਸ ਤੋਂ ਬਿਨਾਂ ਸਿਸਟਮ ਐਪ ਨੂੰ ਮੈਮੋਰੀ ਤੋਂ ਹਟਾ ਦਿੰਦਾ ਹੈ ਅਤੇ ਇਹ ਪ੍ਰੌਕਸੀਆਂ ਦੀ ਖੋਜ ਕਰਨੀ ਅਤੇ " +
        "ਬੈਕਗ੍ਰਾਊਂਡ ਵਿੱਚ ਕਨੈਕਸ਼ਨ ਬਣਾਈ ਰੱਖਣਾ ਬੰਦ ਕਰ ਦਿੰਦੀ ਹੈ। ਇਸੇ ਕਰਕੇ AutoConnector ਦੇ ਕੰਮ ਕਰਨ ਲਈ " +
        "ਨੋਟੀਫਿਕੇਸ਼ਨ ਜ਼ਰੂਰੀ ਹਨ।"
    override val notifEnableTitle = "ਨੋਟੀਫਿਕੇਸ਼ਨ ਚਾਲੂ ਕਰੋ"
    override val notifEnableBody = "ਨੋਟੀਫਿਕੇਸ਼ਨ ਆਈਕਨ ਤੋਂ ਬਿਨਾਂ, Android ਐਪ ਨੂੰ ਅਕਿਰਿਆਸ਼ੀਲ ਮੰਨਦਾ ਹੈ ਅਤੇ " +
        "ਇਸਨੂੰ ਮੈਮੋਰੀ ਤੋਂ ਹਟਾ ਦਿੰਦਾ ਹੈ। ਫਿਰ AutoConnector ਪ੍ਰੌਕਸੀਆਂ ਦੀ ਖੋਜ ਕਰਨੀ ਅਤੇ ਬੈਕਗ੍ਰਾਊਂਡ ਵਿੱਚ " +
        "ਕਨੈਕਸ਼ਨ ਬਣਾਈ ਰੱਖਣਾ ਬੰਦ ਕਰ ਦਿੰਦਾ ਹੈ — Telegram ਦਾ ਲਿੰਕ ਟੁੱਟ ਜਾਂਦਾ ਹੈ।\n\n\"ਚਾਲੂ ਕਰੋ\" 'ਤੇ ਟੈਪ ਕਰੋ ਅਤੇ " +
        "AutoConnector ਲਈ ਨੋਟੀਫਿਕੇਸ਼ਨ ਦੀ ਆਗਿਆ ਦਿਓ।"
    override val notifPlea = "ਨੋਟੀਫਿਕੇਸ਼ਨ ਚਾਲੂ ਕਰੋ! ਇਨ੍ਹਾਂ ਤੋਂ ਬਿਨਾਂ ਐਪ ਬੈਕਗ੍ਰਾਊਂਡ ਵਿੱਚ ਨਹੀਂ ਚੱਲ ਸਕਦੀ — " +
        "Android ਇਸਨੂੰ ਹਟਾ ਦੇਵੇਗਾ ਅਤੇ ਪ੍ਰੌਕਸੀ ਖੋਜ ਤੇ ਕਨੈਕਸ਼ਨ ਰੁਕ ਜਾਣਗੇ।"

    override val statusConnected = "Telegram ਜੁੜ ਗਿਆ"; override val statusConnecting = "ਜੁੜ ਰਿਹਾ ਹੈ…"
    override val statusOffline = "Telegram ਨਹੀਂ ਜੁੜਿਆ"; override val statusIdle = "Telegram ਵਿਹਲਾ"
    override val nobodyConnected = "ਕੋਈ ਵੀ ਕਨੈਕਟਰ ਨਾਲ ਨਹੀਂ ਜੁੜਿਆ। "; override val howToSetupArrow = "ਸੈੱਟ ਅੱਪ ਕਿਵੇਂ ਕਰੀਏ →"
    override val directModeViaVpn = "ਸਿੱਧਾ ਮੋਡ: VPN ਚਾਲੂ — ਕੋਈ ਪ੍ਰੌਕਸੀ ਨਹੀਂ"
    override val directModeOff = "ਸਿੱਧਾ ਮੋਡ: ਪ੍ਰੌਕਸੀਆਂ ਬੰਦ"
    override val directDpiSuffix = " · ਐਂਟੀ-DPI"
    override val connections = "ਕਨੈਕਸ਼ਨ"; override val sockets = "ਸਾਕਟ"; override val speed = "ਗਤੀ"
    override val traffic = "ਟ੍ਰੈਫਿਕ"; override val latency = "ਲੇਟੈਂਸੀ"
    override fun pcs(n: Int) = "${n} ਨਗ"
    override fun netNow(label: String) = "ਨੈੱਟਵਰਕ: ${label}"
    override fun tgToConnector(n: Int) = "TG→ ${n}"
    override fun connectorToProxy(n: Int) = "ਪ੍ਰੌਕਸੀ ${n}"
    override val trafficSec = "ਟ੍ਰੈਫਿਕ · 60 ਸਕਿੰਟ"; override val trafficMin = "ਟ੍ਰੈਫਿਕ · 60 ਮਿੰਟ"
    override val latencySec = "ਲੇਟੈਂਸੀ · 60 ਸਕਿੰਟ"; override val latencyMin = "ਲੇਟੈਂਸੀ · 60 ਮਿੰਟ"
    override val sec60 = "60 ਸਕਿੰਟ"; override val min60 = "60 ਮਿੰਟ"
    override val unitSec = "ਸ"; override val unitMin = "ਮਿੰ"; override val unitHour = "ਘੰ"; override val dash = "—"
    override val currentProxy = "ਮੌਜੂਦਾ ਪ੍ਰੌਕਸੀ"; override val noActiveProxy = "ਕੋਈ ਚਾਲੂ ਪ੍ਰੌਕਸੀ ਨਹੀਂ (Telegram ਨਹੀਂ ਜੁੜਿਆ)"
    override val host = "ਹੋਸਟ"; override val type = "ਕਿਸਮ"; override val secret = "ਸੀਕ੍ਰੇਟ"; override val antiDpi = "ਐਂਟੀ-DPI"; override val obfEngine = "ਅਸਪਸ਼ਟੀਕਰਨ ਇੰਜਣ"
    override fun activeSockets(n: Int) = "ਚਾਲੂ Telegram ਸਾਕਟ: ${n}"
    override val noConnections = "ਕੋਈ ਚਾਲੂ ਕਨੈਕਸ਼ਨ ਨਹੀਂ"; override val colHost = "ਹੋਸਟ"; override val colTime = "ਸਮਾਂ"
    override val modeWord = "ਮੋਡ"; override val directViaVpnLine = "Telegram ਨੂੰ ਸਿੱਧੀਆਂ ਬੇਨਤੀਆਂ (VPN ਚਾਲੂ)"
    override val connModeHelp = "ਮੋਡ (VPN, Wi-Fi, LTE, Ethernet, White) ਤੁਹਾਨੂੰ ਸਕੈਨ ਦੀ ਤੀਬਰਤਾ ਵੱਖ-ਵੱਖ ਢੰਗ ਨਾਲ ਸੈੱਟ ਕਰਨ ਅਤੇ ਵੱਖਰੀਆਂ ਹੋਸਟ ਰੇਟਿੰਗਾਂ/ਅੰਕੜੇ ਰੱਖਣ ਦਿੰਦੇ ਹਨ। ਨੈੱਟਵਰਕ ਕਾਰਡ ਆਪਣੇ-ਆਪ ਪਛਾਣਿਆ ਜਾਂਦਾ ਹੈ; ਮੋਡ ਸੈਟਿੰਗਾਂ ਵਿੱਚ ਹੱਥੀਂ ਸੈੱਟ ਕੀਤਾ ਜਾ ਸਕਦਾ ਹੈ।"

    override val scanOff = "ਸਕੈਨਿੰਗ ਬੰਦ ਹੈ"; override val proxiesInBase = "ਡੇਟਾਬੇਸ ਵਿੱਚ ਪ੍ਰੌਕਸੀਆਂ"
    override val total = "ਕੁੱਲ"; override val alive = "ਚਾਲੂ"; override val dead = "ਮਰੀਆਂ"
    override val tgConnectedTitle = "Telegram ਜੁੜਿਆ ਇਸ ਰਾਹੀਂ"; override val successful = "ਸਫਲ"
    override val socketsHeld = "ਸਾਕਟ ਜੀਵਨ-ਕਾਲ"; override val over1m = ">1 ਮਿੰਟ"; override val over5m = ">5 ਮਿੰਟ"; override val over15m = ">15 ਮਿੰਟ"
    override val scanCountTitle = "ਪ੍ਰੌਕਸੀ ਜਾਂਚਾਂ ਦੀ ਗਿਣਤੀ"; override val checked = "ਜਾਂਚੀਆਂ"
    override val forAllTime = "ਹਰ ਸਮੇਂ"; override val perMinute = "ਪ੍ਰਤੀ ਮਿੰਟ"; override val perHour = "ਪ੍ਰਤੀ ਘੰਟਾ"
    override val subsCountTitle = "ਸਬਸਕ੍ਰਿਪਸ਼ਨ ਡਾਊਨਲੋਡਾਂ ਦੀ ਗਿਣਤੀ"; override val downloaded = "ਡਾਊਨਲੋਡ ਕੀਤੀਆਂ"; override val failed = "ਅਸਫਲ"; override val scanTraffic = "ਸਕੈਨ ਟ੍ਰੈਫਿਕ"; override val subTraffic = "ਸਬਸਕ੍ਰਿਪਸ਼ਨ ਟ੍ਰੈਫਿਕ"; override val subTrafficGraph = "ਸਬਸਕ੍ਰਿਪਸ਼ਨ ਟ੍ਰੈਫਿਕ"
    override val checksMtproto = "MTProto ਜਾਂਚਾਂ (↑ ਠੀਕ · ↓ ਅਸਫਲ)"

    override fun catalogEmpty(mode: String) = "ਕੈਟਾਲਾਗ ${mode} ਹਾਲੇ ਖਾਲੀ ਹੈ। ਜਾਂ ਤਾਂ ਕੋਈ ਹੋਸਟ ਨਹੀਂ ਮਿਲਿਆ, ਜਾਂ ਐਪ ਕਦੇ ਇਸ ਮੋਡ ਵਿੱਚ ਨਹੀਂ ਚੱਲੀ। ਤੁਸੀਂ ਸੈਟਿੰਗਾਂ ਵਿੱਚ ਮੋਡ ਬਦਲ ਸਕਦੇ ਹੋ। ਮੋਡ ਇਸ ਲਈ ਹਨ ਕਿ ਵੱਖ-ਵੱਖ ਕਿਸਮ ਦੇ ਇੰਟਰਨੈੱਟ ਕਨੈਕਸ਼ਨ ਲਈ ਹੋਸਟ ਵੱਖਰੇ ਇਕੱਠੇ ਕੀਤੇ ਜਾ ਸਕਣ।"
    override val aliveShort = "✓ ਚਾਲੂ"; override val deadShort = "✗ ਮਰੀ"
    override val statusLabel = "ਸਥਿਤੀ"; override val rating = "ਰੇਟਿੰਗ"; override val port = "ਪੋਰਟ"
    override val rttPing = "RTT (ਪਿੰਗ)"; override val checkedField = "ਜਾਂਚੀ"; override val okOfTotal = "ਸਫਲ / ਕੁੱਲ ਜਾਂਚਾਂ"
    override val tgConnectedField = "Telegram ਜੁੜਿਆ"; override val tgSessions = "Telegram ਸੈਸ਼ਨ"; override val trafficThroughProxy = "ਪ੍ਰੌਕਸੀ ਰਾਹੀਂ ਟ੍ਰੈਫਿਕ"
    override val sessionsTotal = "ਕੁੱਲ ਸੈਸ਼ਨ"; override val relayNow = "ਹੁਣ ਰੀਲੇ"; override val tlsDomain = "TLS ਡੋਮੇਨ (SNI)"
    override val sourceSub = "ਸਰੋਤ (ਸਬਸਕ੍ਰਿਪਸ਼ਨ)"; override val lastError = "ਆਖਰੀ ਗਲਤੀ"; override val yes = "ਹਾਂ"; override val no = "ਨਹੀਂ"
    override val copyAsLink = "ਲਿੰਕ ਵਜੋਂ ਕਾਪੀ ਕਰੋ"; override val openInTelegram = "ਹੋਸਟ Telegram ਵਿੱਚ ਖੋਲ੍ਹੋ"; override val makeNextRelay = "ਅਗਲਾ ਰੀਲੇ ਬਣਾਓ"
    override val actCopy = "ਕਾਪੀ"; override val actOpen = "ਖੋਲ੍ਹੋ"; override val actRelay = "ਰੀਲੇ"
    override fun agoFmt(v: String) = "${v} ਪਹਿਲਾਂ"
    override val catalogTopFor = "ਇਸ ਲਈ ਪ੍ਰੌਕਸੀ ਸੂਚੀ/ਰੇਟਿੰਗ"
    override val catalogModeHelpTitle = "ਮੋਡ ਤੇ ਰੇਟਿੰਗਾਂ"
    override val catalogModeHelp = "ਐਪ ਚਾਲੂ ਹੋਸਟਾਂ ਅਤੇ ਉਨ੍ਹਾਂ ਦੀਆਂ ਰੇਟਿੰਗਾਂ ਨੂੰ ਹਰ ਨੈੱਟਵਰਕ ਮੋਡ (VPN, Wi-Fi, LTE, Ethernet ਅਤੇ White) ਲਈ ਵੱਖਰੇ ਤੌਰ 'ਤੇ ਗਿਣਦੀ ਹੈ। \"White\" ਵਾਈਟਲਿਸਟਾਂ ਲਈ ਇੱਕ ਵੱਖਰਾ ਹੱਥੀਂ ਮੋਡ ਹੈ; ਆਟੋ ਕਦੇ ਇਸ 'ਤੇ ਨਹੀਂ ਬਦਲਦਾ। ਇਸ ਲਈ ਉਹੀ ਹੋਸਟ ਇੱਕ ਮੋਡ ਵਿੱਚ ਚਾਲੂ ਅਤੇ ਦੂਜੇ ਵਿੱਚ ਮਰੀ ਹੋ ਸਕਦੀ ਹੈ।"
    override fun catalogInactiveWarn(section: String, active: String) =
        "ਤੁਸੀਂ ਅਕਿਰਿਆਸ਼ੀਲ ਸੈਕਸ਼ਨ ${section} ਵੇਖ ਰਹੇ ਹੋ — ਇਸ ਵੇਲੇ ਸਾਰੇ ਅੰਕੜੇ ${active} ਵਿੱਚ ਜਾ ਰਹੇ ਹਨ, ਇੱਥੇ ਨਹੀਂ।"
    override val manageModeTitle = "ਮੋਡ ਪ੍ਰਬੰਧਿਤ ਕਰੋ"
    override val manageResetRating = "ਰੇਟਿੰਗ ਰੀਸੈੱਟ ਕਰੋ"
    override fun manageResetHint(mode: String) = "ਖਾਸ ਤੌਰ 'ਤੇ ${mode} ਲਈ ਤੁਸੀਂ ਚਾਲੂ ਹੋਸਟਾਂ ਦੀ ਰੇਟਿੰਗ ਅਤੇ ਵਰਤੋਂ ਅੰਕੜੇ ਰੀਸੈੱਟ ਕਰ ਸਕਦੇ ਹੋ। ਇਹ ਉਦੋਂ ਕੰਮ ਆਉਂਦਾ ਹੈ ਜਦੋਂ ਤੁਸੀਂ ਕਿਸੇ ਬਿਲਕੁਲ ਵੱਖਰੇ VPN ਜਾਂ LTE ਨਾਲ ਜੁੜੇ ਹੋ, ਤਾਂ ਕਿ ਪੁਰਾਣੇ ਅੰਕੜੇ ਰੁਕਾਵਟ ਨਾ ਪਾਉਣ। ਜਾਂ ਇਹ ਵੇਖਣ ਲਈ ਕਿ ਪ੍ਰੌਕਸੀ ਸਕੈਨ ਕਿੰਨੀ ਜਲਦੀ ਸਭ ਕੁਝ ਮੁੜ ਜਾਂਚਦਾ ਹੈ।"
    override val manageDeleteAll = "ਇਸ ਵਿੱਚ ਹੋਸਟ ਮਿਟਾਓ"
    override fun manageDeleteHint(mode: String) = "ਤੁਸੀਂ ${mode} ਵਿੱਚੋਂ ਰੇਟਿੰਗ ਅਤੇ ਹੋਸਟ ਦੋਵੇਂ ਸਾਫ਼ ਕਰ ਸਕਦੇ ਹੋ। \"ਪ੍ਰੌਕਸੀਆਂ ਸਕੈਨ ਕਰੋ\" ਫੀਚਰ ਇਨ੍ਹਾਂ ਨੂੰ ਮੁੜ ਇਕੱਠਾ ਕਰੇਗਾ। ਇਹ ਸਬਸਕ੍ਰਿਪਸ਼ਨ ਰੀਸੈੱਟ ਨਹੀਂ ਹੈ — ਤੁਸੀਂ ਇਸ 'ਤੇ ਟੈਪ ਕਰ ਸਕਦੇ ਹੋ, ਫਿਰ ਮੁੜ-ਸਕੈਨ ਲਈ ~15 ਮਿੰਟ ਉਡੀਕੋ।"
    override fun manageCopyFrom(mode: String) = "ਕਿਸੇ ਹੋਰ ਮੋਡ ਤੋਂ ਸਾਰੇ ਹੋਸਟ ਅਤੇ ਰੇਟਿੰਗਾਂ ਇਸ ਮੋਡ (${mode}) ਵਿੱਚ ਕਾਪੀ ਕਰੋ:"
    override val live = "ਚਾਲੂ"; override val deadW = "ਮਰੀ"; override val unitMs = "ਮਿਸ"
    override val agoMin = "ਮਿੰ"; override val agoHour = "ਘੰ"; override val agoDay = "ਦਿ"

    override val connectTelegram = "Telegram ਜੋੜਨਾ"; override val readCarefully = "ਧਿਆਨ ਨਾਲ ਪੜ੍ਹੋ!"
    override val guideIntro = "ਇਹ ਐਪ ਸੈੱਟ ਅੱਪ ਤੋਂ ਬਿਨਾਂ ਕੰਮ ਨਹੀਂ ਕਰੇਗੀ। ਹੇਠਾਂ ਦਿੱਤੇ 3 ਵਿਕਲਪਾਂ ਵਿੱਚੋਂ ਕੋਈ ਇੱਕ ਚੁਣੋ " +
        "ਅਤੇ ਹਦਾਇਤਾਂ ਨੂੰ ਧਿਆਨ ਨਾਲ ਪਾਲੋ।"
    override val variant1 = "ਵਿਕਲਪ #1 — ਬਟਨ"
    override val variant1Body = "\"ਪ੍ਰੌਕਸੀ {A}\" 'ਤੇ ਟੈਪ ਕਰੋ — Telegram ਖੁੱਲ੍ਹਦਾ ਹੈ, ਪ੍ਰੌਕਸੀ ਜੋੜਨ ਦੀ ਪੁਸ਼ਟੀ ਕਰੋ। ਇਸ " +
        "ਸਕਰੀਨ 'ਤੇ ਵਾਪਸ ਆਓ ਅਤੇ \"ਪ੍ਰੌਕਸੀ {B}\" 'ਤੇ ਟੈਪ ਕਰੋ — ਦੂਜੀ ਵਾਰ ਜੋੜਨ ਦੀ ਪੁਸ਼ਟੀ ਕਰੋ।\n\nTelegram ਵਿੱਚ ਕੋਈ ਵੀ " +
        "ਹੋਰ ਪੁਰਾਣੀਆਂ ਪ੍ਰੌਕਸੀਆਂ ਬੰਦ ਕਰ ਦਿਓ। ਠੀਕ 2 ਪ੍ਰੌਕਸੀਆਂ ਰਹਿਣੀਆਂ ਚਾਹੀਦੀਆਂ ਹਨ — ਪੋਰਟ {A} ਅਤੇ {B} ਨਾਲ। " +
        "ਕਿਸੇ ਹੋਰ ਸੈੱਟ ਨਾਲ AutoConnector ਕੰਮ ਨਹੀਂ ਕਰੇਗਾ।"
    override val variant2 = "ਵਿਕਲਪ #2 — ਲਿੰਕ"
    override val variant2Body = "ਹੇਠਲੀ ਲਿਖਤ ਨੂੰ Telegram ਵਿੱਚ Saved Messages (ਜਾਂ ਕਿਸੇ ਵੀ ਚੈਟ) ਵਿੱਚ ਕਾਪੀ ਕਰੋ — " +
        "ਯਾਨੀ ਇਸਨੂੰ ਆਪਣੇ-ਆਪ ਨੂੰ ਭੇਜੋ। ਆਪਣੇ ਸੁਨੇਹੇ ਵਿੱਚ ਪਹਿਲੇ ਲਿੰਕ 'ਤੇ ਟੈਪ ਕਰੋ — ਪਹਿਲੀ ਪ੍ਰੌਕਸੀ ਜੁੜ ਜਾਂਦੀ ਹੈ। " +
        "ਦੂਜੇ ਲਿੰਕ 'ਤੇ ਟੈਪ ਕਰੋ — ਦੂਜੀ ਜੁੜ ਜਾਂਦੀ ਹੈ। ਫਿਰ ਸਾਰੀਆਂ ਪੁਰਾਣੀਆਂ ਪ੍ਰੌਕਸੀਆਂ ਬੰਦ ਕਰ ਦਿਓ।"
    override val variant3 = "ਵਿਕਲਪ #3 — ਹੱਥੀਂ"
    override val variant3Body = "ਹੱਥੀਂ ਇੱਕ SOCKS5 ਪ੍ਰੌਕਸੀ ਜੋੜੋ: ਸਰਵਰ localhost (127.0.0.1), ਪੋਰਟ {A}। " +
        "ਫਿਰ ਦੂਜੀ ਪ੍ਰੌਕਸੀ: localhost, ਪੋਰਟ {B}। ਕੋਈ ਵੀ ਪੁਰਾਣੀ ਪ੍ਰੌਕਸੀ ਮਿਟਾਓ।"
    override val whatNext = "ਅੱਗੇ ਕੀ?"
    override val whatNextBody = "Telegram ਵਿੱਚ, \"ਆਟੋ-ਸਵਿੱਚ ਪ੍ਰੌਕਸੀ\" ਚਾਲੂ ਕਰੋ — 5 ਸਕਿੰਟ। ਤੁਸੀਂ ਕਿਸੇ ਅਜਿਹੀ ਪ੍ਰੌਕਸੀ " +
        "(Telegram ਅੰਦਰ) 'ਤੇ ਹੱਥੀਂ ਟੈਪ ਕਰਕੇ Telegram ਨੂੰ ਜੁੜਨ ਵਿੱਚ ਮਦਦ ਕਰ ਸਕਦੇ ਹੋ ਜੋ ਚਾਲੂ ਨਹੀਂ ਹੈ ਜਾਂ " +
        "\"ਉਪਲਬਧ ਨਹੀਂ\" ਮਾਰਕ ਹੈ — ਇਸ ਨਾਲ Telegram ਜੁੜਨ ਲਈ ਜ਼ਿਆਦਾ ਜ਼ੋਰ ਲਾਉਂਦਾ ਹੈ।\n\nਯਕੀਨੀ ਬਣਾਓ ਕਿ ਹੋਰ ਸਾਰੀਆਂ ਪੁਰਾਣੀਆਂ " +
        "ਪ੍ਰੌਕਸੀਆਂ ਹਟਾ ਦਿੱਤੀਆਂ ਗਈਆਂ ਹਨ, {A} ਅਤੇ {B} ਤੋਂ ਬਿਨਾਂ। Telegram ਵਿੱਚ " +
        "\"ਪ੍ਰੌਕਸੀ ਵਰਤੋ\" 'ਤੇ ਟੈਪ ਕਰੋ।\n\nਉਡੀਕੋ ਜਦ ਤੱਕ ਐਪ ਕਾਫ਼ੀ ਪ੍ਰੌਕਸੀਆਂ ਲੱਭ ਕੇ ਡਾਊਨਲੋਡ ਨਹੀਂ ਕਰ ਲੈਂਦੀ " +
        "(5–15 ਮਿੰਟ)। ਫਿਰ Telegram ਆਪਣੇ-ਆਪ AutoConnector ਨਾਲ ਜੁੜ ਜਾਂਦਾ ਹੈ, ਜੋ Telegram ਨੂੰ ਸਭ ਤੋਂ ਵਧੀਆ " +
        "ਪ੍ਰੌਕਸੀਆਂ ਰਾਹੀਂ ਚਲਾਉਂਦਾ ਰਹੇਗਾ: ਪ੍ਰਮਾਣਿਤ, ਚਾਲੂ ਅਤੇ ਤੇਜ਼।\n\nਜੇ ਹਦਾਇਤਾਂ ਔਖੀਆਂ ਲੱਗਣ " +
        "— ਮਾਫ਼ ਕਰਨਾ, ਤੁਸੀਂ ਐਪ ਨਹੀਂ ਵਰਤ ਸਕੋਗੇ: ਸਭ ਕੁਝ ਆਪਣੇ-ਆਪ ਸੈੱਟ ਕਰਨਾ ਅਸੰਭਵ ਹੈ, " +
        "ਅਤੇ ਚਾਲੂ ਪ੍ਰੌਕਸੀਆਂ ਲੱਭਣ ਵਿੱਚ ਸਮਾਂ ਲੱਗਦਾ ਹੈ।\n\nਜੇ ਤੁਸੀਂ ਐਪ ਬਹੁਤ ਪਹਿਲਾਂ ਡਾਊਨਲੋਡ ਕੀਤੀ ਸੀ " +
        "ਅਤੇ ਕੋਈ ਚਾਲੂ ਪ੍ਰੌਕਸੀ ਨਹੀਂ ਲੱਭੀ — ਜਾਂ ਤਾਂ ਐਪ ਜਾਂ ਸਬਸਕ੍ਰਿਪਸ਼ਨ ਸੂਚੀ ਅੱਪਡੇਟ ਕਰੋ। ਇਹ ਐਪ " +
        "ਆਪਣੀਆਂ ਪ੍ਰੌਕਸੀਆਂ ਨਹੀਂ ਬਣਾਉਂਦੀ ਜਾਂ ਦਿੰਦੀ, ਇਹ ਸਿਰਫ਼ ਦਰਜਨਾਂ " +
        "ਗਰੁੱਪਾਂ ਅਤੇ ਪੰਨਿਆਂ ਵਿੱਚ ਇੰਟਰਨੈੱਟ 'ਤੇ ਖੋਜ ਕਰਦੀ ਹੈ।"
    override fun proxyBtn(port: Int) = "ਪ੍ਰੌਕਸੀ ${port}"

    override val setupPortsTitle = "Telegram ਵਿੱਚ ਪੋਰਟ ਸੈੱਟ ਅੱਪ ਕਰੋ"
    override val setupPortsSub = "Telegram ਨੂੰ ਕਨੈਕਟਰ ਨਾਲ ਕਿਵੇਂ ਜੋੜੀਏ (ਪੋਰਟ 55001/55002)"
    override val settings = "ਸੈਟਿੰਗਾਂ"; override val settingsSub = "ਪੋਰਟ, ਐਂਟੀ-DPI, ਸਕੈਨ, ਨੈੱਟਵਰਕ, ਬੈਟਰੀ"
    override val subscriptions = "ਸਬਸਕ੍ਰਿਪਸ਼ਨਾਂ"; override val subscriptionsSub = "ਸਕੈਨ ਕਰਨ ਲਈ ਪ੍ਰੌਕਸੀ ਸਰੋਤ"
    override val statistics = "ਅੰਕੜੇ"; override val statisticsSub = "ਪ੍ਰੌਕਸੀ ਡੇਟਾਬੇਸ + ਐਂਟੀ-DPI ਤਰੀਕੇ"
    override val export = "ਐਕਸਪੋਰਟ"; override val exportSub = "ਚਾਲੂ ਪ੍ਰੌਕਸੀਆਂ ਦੇ tg:// ਲਿੰਕ"
    override val about = "ਬਾਰੇ"; override val aboutSub = "ਵਰਜਨ, ਬਿਲਡ, ਡਾਊਨਲੋਡ, ਫੀਡਬੈਕ"
    override val hotkeys = "ਹਾਟਕੀਜ਼"
    override val hotkeysSub = "ਗਲੋਬਲ ਕੀਜ਼: ਪ੍ਰੌਕਸੀ ਕਾਪੀ / ਖੋਲ੍ਹੋ"
    override val hotkeysIntro = "ਗਲੋਬਲ ਹਾਟਕੀਜ਼ ਉਦੋਂ ਵੀ ਚੱਲਦੀਆਂ ਹਨ ਜਦੋਂ ਐਪ ਵਿੰਡੋ ਫੋਕਸ ਵਿੱਚ ਨਾ ਹੋਵੇ। ਇਹ ਪੂਲ ਵਿੱਚੋਂ ਇੱਕ " +
        "ਬੇਤਰਤੀਬ ਚਾਲੂ ਪ੍ਰੌਕਸੀ ਲਿੰਕ (tg://) ਚੁਣਦੀਆਂ ਹਨ — ਐਪ ਖੋਲ੍ਹੇ ਬਿਨਾਂ ਪ੍ਰੌਕਸੀ ਜਲਦੀ ਬਦਲਣ ਲਈ ਸੌਖਾ।"
    override val hotkeysNote = "macOS 'ਤੇ, ਕੀਜ਼ ਕੈਪਚਰ ਕਰਨ ਲਈ Accessibility ਆਗਿਆ ਦੀ ਲੋੜ ਪੈ ਸਕਦੀ ਹੈ " +
        "(System Settings → Privacy & Security → Accessibility)।"
    override val hotkeyCopyTitle = "ਪ੍ਰੌਕਸੀ ਲਿੰਕ ਕਾਪੀ ਕਰੋ"
    override val hotkeyCopyDesc = "ਇੱਕ ਬੇਤਰਤੀਬ ਚਾਲੂ tg:// ਲਿੰਕ ਕਲਿੱਪਬੋਰਡ 'ਤੇ ਰੱਖਦਾ ਹੈ।"
    override val hotkeyEnable = "ਹਾਟਕੀਜ਼ ਚਾਲੂ ਕਰੋ"; override val hotkeyLetterLabel = "ਅੱਖਰ"; override val hotkeySet = "ਸੈੱਟ"; override val hotkeyReset = "ਰੀਸੈੱਟ"
    override val hotkeyOpenTitle = "ਪ੍ਰੌਕਸੀ Telegram ਵਿੱਚ ਖੋਲ੍ਹੋ"
    override val hotkeyOpenDesc = "ਇੱਕ ਬੇਤਰਤੀਬ ਚਾਲੂ ਲਿੰਕ ਖੋਲ੍ਹਦਾ ਹੈ — Telegram ਇਸਨੂੰ ਫੜ ਲੈਂਦਾ ਹੈ ਅਤੇ ਪ੍ਰੌਕਸੀ ਜੋੜਨ ਦੀ ਪੇਸ਼ਕਸ਼ ਕਰਦਾ ਹੈ।"

    override val relayPorts = "ਰੀਲੇ ਪੋਰਟ"
    override val relayPortsHelp = "ਉਹ ਲੋਕਲ ਪੋਰਟ ਜਿਨ੍ਹਾਂ 'ਤੇ ਕਨੈਕਟਰ ਸੁਣਦਾ ਹੈ। ਤੁਸੀਂ ਠੀਕ ਇਹੀ Telegram ਵਿੱਚ " +
        "SOCKS5 ਪ੍ਰੌਕਸੀ ਵਜੋਂ ਪਾਉਂਦੇ ਹੋ (127.0.0.1 : ਪੋਰਟ)। ਭਰੋਸੇਯੋਗਤਾ ਲਈ ਦੋ ਪੋਰਟ ਵਰਤੇ ਜਾਂਦੇ ਹਨ — Telegram " +
        "ਦੋਵਾਂ ਨਾਲ ਕਨੈਕਸ਼ਨ ਬਣਾਈ ਰੱਖਦਾ ਹੈ।"
    override val portA = "ਪੋਰਟ A"; override val portB = "ਪੋਰਟ B"
    override val antiDpiTrick = "ਐਂਟੀ-DPI ਤਰੀਕਾ"
    override val antiDpiHelp = "ਕਨੈਕਸ਼ਨ ਨੂੰ ਛੁਪਾਉਣ ਦਾ ਇੱਕ ਤਰੀਕਾ ਤਾਂ ਕਿ ISP/DPI ਇਸਨੂੰ ਪਛਾਣ ਕੇ " +
        "ਬਲਾਕ ਨਾ ਕਰ ਸਕੇ।\n• \"ਆਟੋ-ਰੋਟੇਟ\" ਆਪ ਇੱਕ ਕੰਮ ਕਰਦਾ ਤਰੀਕਾ ਚੁਣਦਾ ਹੈ।\n• \"ਕੋਈ DPI ਤਰੀਕਾ ਨਹੀਂ\" — ਇੱਕ ਸਾਦਾ " +
        "ਕਨੈਕਸ਼ਨ।\n• ਬਾਕੀ ਖਾਸ ਤਕਨੀਕਾਂ ਹਨ (ਬ੍ਰਾਊਜ਼ਰ ਦੀ ਨਕਲ, ਪੈਕਟ ਵੰਡਣਾ, ਆਦਿ)।"
    override val onlyFakeTls = "ਸਿਰਫ਼ FakeTLS (ee)"
    override val applyDpiTo = "ਐਂਟੀ-DPI ਇੱਥੇ ਲਾਗੂ ਕਰੋ"
    override val applyDpiHelp = "ਚੁਣੇ ਐਂਟੀ-DPI ਤਰੀਕੇ ਨੂੰ ਕਿਸ 'ਤੇ ਲਾਗੂ ਕਰਨਾ ਹੈ:\n• Telegram ਰੀਲੇ — ਕਨੈਕਟਰ ਰਾਹੀਂ " +
        "ਚਾਲੂ Telegram ਕਨੈਕਸ਼ਨ 'ਤੇ।\n• ਪ੍ਰੌਕਸੀ ਪ੍ਰੋਬ — ਬੈਕਗ੍ਰਾਊਂਡ ਪ੍ਰੌਕਸੀ ਜਾਂਚਾਂ 'ਤੇ " +
        "(ਫਿਰ ਜਾਂਚ ਅਸਲ ਕਨੈਕਸ਼ਨ ਵਾਂਗ ਵਿਹਾਰ ਕਰਦੀ ਹੈ, ਅਤੇ ਤਰੀਕੇ ਦੇ ਅੰਕੜੇ ਜ਼ਿਆਦਾ ਸਹੀ ਹੁੰਦੇ ਹਨ)।\n" +
        "• ਜਦੋਂ ਸਿੱਧਾ ਜੁੜਨਾ ਹੋਵੇ — ਜਦੋਂ ਪ੍ਰੌਕਸੀਆਂ ਬੰਦ ਹੋਣ (ਜਾਂ VPN ਚਾਲੂ ਹੋਣ 'ਤੇ ਛੱਡ ਦਿੱਤੀਆਂ ਜਾਣ) ਅਤੇ Telegram " +
        "ਸਿੱਧਾ ਆਪਣੇ ਸਰਵਰਾਂ ਨਾਲ ਜੁੜਦਾ ਹੈ: ਇੱਥੇ ਕੋਈ ਪ੍ਰੌਕਸੀ ਨਹੀਂ, ਇਸ ਲਈ ਤਰੀਕਾ ਸਿਰਫ਼ ਪਹਿਲੇ TCP ਪੈਕਟ " +
        "(ਹੈਂਡਸ਼ੇਕ) ਨੂੰ ਕਈ ਛੋਟੇ ਟੁਕੜਿਆਂ ਵਿੱਚ ਵੰਡਣ ਤੱਕ ਸੀਮਤ ਰਹਿੰਦਾ ਹੈ ਤਾਂ ਕਿ DPI ਇਸਨੂੰ ਇੱਕ ਰੀਡ ਵਿੱਚ ਮੈਚ ਨਾ ਕਰ ਸਕੇ।"
    override val toRelay = "Telegram ਰੀਲੇ"; override val toProbes = "ਪ੍ਰੌਕਸੀ ਪ੍ਰੋਬ"
    override val toDirect = "ਜਦੋਂ ਸਿੱਧਾ ਜੁੜਨਾ ਹੋਵੇ"
    override val vpnSection = "ਜਦੋਂ VPN ਚਾਲੂ ਹੋਵੇ"
    override val vpnHelp = "ਜਦੋਂ ਡਿਵਾਈਸ 'ਤੇ VPN ਚਾਲੂ ਹੋਵੇ ਤਾਂ ਕੀ ਕਰਨਾ ਹੈ:\n• MTProto ਪ੍ਰੌਕਸੀ ਰਾਹੀਂ — " +
        "Telegram ਆਮ ਵਾਂਗ ਲੱਭੀਆਂ ਪ੍ਰੌਕਸੀਆਂ ਰਾਹੀਂ ਜਾਂਦਾ ਹੈ (VPN ਦੇ ਉੱਪਰ)।\n• ਸਿੱਧਾ — " +
        "ਕਨੈਕਟਰ ਪ੍ਰੌਕਸੀਆਂ ਨਹੀਂ ਵਰਤਦਾ ਅਤੇ Telegram ਨੂੰ ਸਿੱਧਾ Telegram ਦੇ ਸਰਵਰਾਂ ਨਾਲ ਜੋੜਦਾ ਹੈ: " +
        "VPN ਪਹਿਲਾਂ ਹੀ ਪਹੁੰਚ ਦਿੰਦਾ ਹੈ, ਵਾਧੂ ਪ੍ਰੌਕਸੀ ਪਰਤ ਦੀ ਲੋੜ ਨਹੀਂ (ਤੇਜ਼ ਅਤੇ ਜ਼ਿਆਦਾ ਸਥਿਰ)। " +
        "VPN ਤੋਂ ਬਿਨਾਂ ਪ੍ਰੌਕਸੀਆਂ ਆਮ ਵਾਂਗ ਵਰਤੀਆਂ ਜਾਂਦੀਆਂ ਹਨ।"
    override val linkFormat = "ਪ੍ਰੌਕਸੀ ਲਿੰਕ ਫਾਰਮੈਟ"
    override val linkFormatHelp = "ਪ੍ਰੌਕਸੀਆਂ ਕਿਵੇਂ ਕਾਪੀ ਅਤੇ ਖੋਲ੍ਹਣੀਆਂ ਹਨ। tg:// Telegram ਨੂੰ ਸਿੱਧਾ ਖੋਲ੍ਹਦਾ ਹੈ (Telegram Desktop ਇੰਸਟਾਲ ਹੋਣਾ ਚਾਹੀਦਾ ਹੈ)। http (t.me) ਬ੍ਰਾਊਜ਼ਰ ਰਾਹੀਂ ਖੋਲ੍ਹਦਾ ਹੈ ਅਤੇ Telegram ਵਿੱਚ ਖੋਲ੍ਹਣ ਦੀ ਪੇਸ਼ਕਸ਼ ਕਰਦਾ ਹੈ — ਜੇ tg:// ਰਜਿਸਟਰ ਨਾ ਹੋਵੇ ਤਾਂ ਸੌਖਾ।"
    override val linkTg = "tg:// (Telegram ਸਿੱਧਾ ਖੋਲ੍ਹੋ)"; override val linkTgSub = "tg://proxy?… — Telegram ਖੋਲ੍ਹਦਾ ਹੈ"
    override val linkHttp = "http (t.me, ਬ੍ਰਾਊਜ਼ਰ ਰਾਹੀਂ)"; override val linkHttpSub = "https://t.me/proxy?… — ਬ੍ਰਾਊਜ਼ਰ ਖੋਲ੍ਹਦਾ ਹੈ"
    override val viaMtproto = "MTProto ਰਾਹੀਂ ਪ੍ਰੌਕਸੀ"; override val viaMtprotoSub = "VPN ਨਾਲ ਵੀ, ਟ੍ਰੈਫਿਕ ਪ੍ਰੌਕਸੀਆਂ ਰਾਹੀਂ ਜਾਂਦਾ ਹੈ"
    override val directly = "ਸਿੱਧਾ ਜੁੜੋ"; override val directlySub = "VPN ਚਾਲੂ ਹੋਣ 'ਤੇ — ਪ੍ਰੌਕਸੀਆਂ ਛੱਡੋ, ਸਿੱਧਾ Telegram ਨੂੰ"
    override val notifications = "ਨੋਟੀਫਿਕੇਸ਼ਨ"
    override val scanCheck = "ਸਕੈਨ ਤੇ ਜਾਂਚ"
    override val scanCheckHelp = "• ਸਕੈਨ, ਮਿੰਟ — ਸਬਸਕ੍ਰਿਪਸ਼ਨਾਂ ਤੋਂ ਪ੍ਰੌਕਸੀ ਸੂਚੀਆਂ ਕਿੰਨੀ ਵਾਰ ਡਾਊਨਲੋਡ ਕਰਨੀਆਂ ਹਨ।\n" +
        "• ਜਾਂਚ, ਮਿੰਟ — ਡੇਟਾਬੇਸ ਵਿੱਚ ਪ੍ਰੌਕਸੀਆਂ ਦੀ ਜੀਵੰਤਤਾ ਕਿੰਨੀ ਵਾਰ ਮੁੜ ਜਾਂਚਣੀ ਹੈ।\n• ਬੈਚ ਆਕਾਰ — " +
        "ਪ੍ਰਤੀ ਚਲਨ ਕਿੰਨੀਆਂ ਪ੍ਰੌਕਸੀਆਂ ਜਾਂਚਣੀਆਂ ਹਨ।\n• ਸਮਾਨਾਂਤਰ — ਇੱਕੋ ਵਾਰ ਕਿੰਨੀਆਂ ਜਾਂਚਾਂ ਚਲਾਉਣੀਆਂ ਹਨ (ਜ਼ਿਆਦਾ = " +
        "ਤੇਜ਼, ਪਰ ਜ਼ਿਆਦਾ ਨੈੱਟਵਰਕ ਅਤੇ ਬੈਟਰੀ ਭਾਰ)।"
    override val scanMin = "ਸਕੈਨ, ਮਿੰਟ"; override val checkMin = "ਜਾਂਚ, ਮਿੰਟ"; override val batchSize = "ਬੈਚ ਆਕਾਰ"; override val parallel = "ਸਮਾਨਾਂਤਰ"
    override val speedByNet = "ਨੈੱਟਵਰਕ ਅਨੁਸਾਰ ਸਕੈਨ ਤੀਬਰਤਾ"
    override val speedByNetHelp = "ਮੌਜੂਦਾ ਨੈੱਟਵਰਕ ਅਨੁਸਾਰ ਪ੍ਰੌਕਸੀਆਂ ਕਿੰਨੀ ਵਾਰ ਜਾਂਚਣੀਆਂ ਹਨ। " +
        "\"ਮਿਆਰੀ\" = ਅਧਾਰ ਅੰਤਰਾਲ। ਘੱਟ ਵਾਰ (ਹੌਲੀ, ਟ੍ਰੈਫਿਕ/ਬੈਟਰੀ 'ਤੇ ਨਰਮ) ਲਈ ਸੱਜੇ ਸਰਕਾਓ, " +
        "ਜ਼ਿਆਦਾ ਵਾਰ (ਤੇਜ਼, ਜ਼ਿਆਦਾ ਹਮਲਾਵਰ) ਲਈ ਖੱਬੇ। ਲਾਗਰਿਥਮਿਕ ਪੈਮਾਨਾ, ਹਰ ਪਾਸੇ ×100 ਤੱਕ।\n" +
        "• VPN — ਜਦੋਂ ਬਾਹਰੀ VPN ਚਾਲੂ ਹੋਵੇ।\n• Wi-Fi — Wi-Fi ਨੈੱਟਵਰਕ 'ਤੇ।\n• LTE — ਮੋਬਾਈਲ ਨੈੱਟਵਰਕ 'ਤੇ।"
    override val intensStandard = "ਮਿਆਰੀ"
    override val intensSlower = "ਹੌਲੀ"
    override val intensFaster = "ਤੇਜ਼"
    override val maintenance = "ਡੇਟਾ ਰੀਸੈੱਟ ਕਰੋ"
    override val maintenanceHelp = "• \"ਕੈਟਾਲਾਗ ਤੇ ਅੰਕੜੇ ਰੀਸੈੱਟ ਕਰੋ\" — ਰੇਟਿੰਗਾਂ, ਕਾਊਂਟਰ, ਟ੍ਰੈਫਿਕ " +
        "ਅਤੇ ਜਾਂਚ ਲਾਗ ਨੂੰ ਸਿਫ਼ਰ ਕਰਦਾ ਹੈ, ਪਰ ਡਾਊਨਲੋਡ ਕੀਤੇ ਹੋਸਟ ਅਤੇ ਸਬਸਕ੍ਰਿਪਸ਼ਨਾਂ ਰੱਖਦਾ ਹੈ (ਸਭ ਕੁਝ " +
        "ਅਗਲੇ ਸਕੈਨ 'ਤੇ ਮੁੜ-ਰੇਟ ਹੋ ਜਾਂਦਾ ਹੈ)।\n• \"ਡਾਊਨਲੋਡ ਕੀਤੇ ਹੋਸਟ ਸਾਫ਼ ਕਰੋ\" — ਪੂਰਾ ਪ੍ਰੌਕਸੀ ਪੂਲ ਮਿਟਾਉਂਦਾ ਹੈ ਪਰ " +
        "ਸਬਸਕ੍ਰਿਪਸ਼ਨਾਂ ਰੱਖਦਾ ਹੈ ਤਾਂ ਕਿ ਸਕੈਨ ਪੂਲ ਮੁੜ ਭਰ ਦੇਵੇ। ਕਿਸੇ ਵੀ ਤਰੀਕੇ ਨਾਲ ਸਬਸਕ੍ਰਿਪਸ਼ਨਾਂ ਨੂੰ ਕਦੇ ਨਹੀਂ ਛੂਹਿਆ ਜਾਂਦਾ।"
    override val backupTitle = "ਐਕਸਪੋਰਟ / ਇੰਪੋਰਟ"
    override val backupHelp = "ਐਪ ਡੇਟਾ ਨੂੰ JSON ਵਜੋਂ ਸੰਭਾਲੋ ਜਾਂ ਮੁੜ-ਬਹਾਲ ਕਰੋ। ਜੋ ਸ਼ਾਮਲ ਕਰਨਾ ਹੈ ਉਸ 'ਤੇ ਨਿਸ਼ਾਨ ਲਾਓ — " +
        "ਕੋਈ ਵੀ ਮਿਸ਼ਰਣ:\n• ਸੈਟਿੰਗਾਂ — ਸਾਰੇ ਐਪ ਪੈਰਾਮੀਟਰ।\n• ਸਬਸਕ੍ਰਿਪਸ਼ਨਾਂ — ਸਰੋਤ " +
        "ਸੂਚੀ (URL + ਚਾਲੂ/ਬੰਦ)।\n• ਚਾਲੂ-ਹੋਸਟ ਕੈਟਾਲਾਗ — ਹਰ ਚਾਲੂ ਪ੍ਰੌਕਸੀ ਉਸਦੀਆਂ ਰੇਟਿੰਗਾਂ ਅਤੇ ਅੰਕੜਿਆਂ ਨਾਲ " +
        "ਹਰ ਨੈੱਟਵਰਕ ਮੋਡ ਅਨੁਸਾਰ।\n\n\"ਐਕਸਪੋਰਟ\" ਤਿਆਰ JSON ਵਾਲਾ ਪੰਨਾ ਖੋਲ੍ਹਦਾ ਹੈ — ਇਸਨੂੰ ਕਾਪੀ ਕਰੋ ਜਾਂ ਫਾਈਲ ਵਿੱਚ ਸੰਭਾਲੋ। " +
        "\"ਇੰਪੋਰਟ\" — JSON ਪੇਸਟ ਕਰੋ (ਜਾਂ ਫਾਈਲ ਲੋਡ ਕਰੋ) ਅਤੇ ਇਹ ਸਿਰਫ਼ ਉਸ ਵਿੱਚ ਮੌਜੂਦ ਨਿਸ਼ਾਨ ਲੱਗੇ ਸੈਕਸ਼ਨ ਲਾਗੂ ਕਰਦਾ ਹੈ। " +
        "ਇੰਪੋਰਟ ਮੌਜੂਦਾ ਡੇਟਾ ਵਿੱਚ ਜੋੜਦਾ ਹੈ (ਕੁਝ ਮਿਟਾਉਂਦਾ ਨਹੀਂ)।"
    override val backupSettings = "ਸੈਟਿੰਗਾਂ"
    override val backupSubs = "ਸਬਸਕ੍ਰਿਪਸ਼ਨਾਂ"
    override val backupHosts = "ਚਾਲੂ-ਹੋਸਟ ਕੈਟਾਲਾਗ (ਪ੍ਰਤੀ ਮੋਡ)"
    override val exportWord = "ਐਕਸਪੋਰਟ"
    override val importWord = "ਇੰਪੋਰਟ"
    override val backupExportTitle = "ਡੇਟਾ ਐਕਸਪੋਰਟ ਕਰੋ"
    override val backupImportTitle = "ਡੇਟਾ ਇੰਪੋਰਟ ਕਰੋ"
    override val backupSelectExport = "ਕੀ ਐਕਸਪੋਰਟ ਕਰਨਾ ਹੈ:"
    override val backupSelectImport = "ਕੀ ਇੰਪੋਰਟ ਕਰਨਾ ਹੈ:"
    override val backupCopyBtn = "ਕਾਪੀ"
    override val backupSaveFile = "ਫਾਈਲ ਵਿੱਚ ਸੰਭਾਲੋ"
    override val backupLoadFile = "ਫਾਈਲ ਤੋਂ ਲੋਡ ਕਰੋ"
    override val backupDoImport = "ਇੰਪੋਰਟ"
    override val backupPasteLabel = "ਬੈਕਅੱਪ JSON ਇੱਥੇ ਪੇਸਟ ਕਰੋ"
    override val backupJsonLabel = "ਬੈਕਅੱਪ JSON"
    override val backupAndroidFileNote = "ਫਾਈਲਾਂ ਇੱਥੇ ਉਪਲਬਧ ਨਹੀਂ — ਕਾਪੀ / ਪੇਸਟ ਵਰਤੋ।"
    override val eraseAllHosts = "ਸਾਰੇ ਹੋਸਟ ਮਿਟਾਓ"
    override val factoryReset = "ਸਭ ਕੁਝ ਰੀਸੈੱਟ ਕਰੋ (ਪਹਿਲੀ ਵਾਰ ਵਾਂਗ)"
    override val factoryResetConfirm = "ਐਪ ਨੂੰ ਪੂਰੀ ਤਰ੍ਹਾਂ ਫੈਕਟਰੀ ਸਥਿਤੀ 'ਤੇ ਰੀਸੈੱਟ ਕਰਨਾ ਹੈ? ਸਾਰੀਆਂ ਸੈਟਿੰਗਾਂ ਅਤੇ ਪੂਰਾ " +
        "ਹੋਸਟ ਕੈਟਾਲਾਗ ਮਿਟਾ ਦਿੱਤਾ ਜਾਵੇਗਾ, ਸਬਸਕ੍ਰਿਪਸ਼ਨਾਂ ਮੂਲ ਰੂਪ ਵਿੱਚ ਮੁੜ-ਬਹਾਲ ਹੋਣਗੀਆਂ। ਠੀਕ ਪਹਿਲੀ ਵਾਰ ਵਾਂਗ।"
    override val resetCatalog = "ਕੈਟਾਲਾਗ ਤੇ ਅੰਕੜੇ ਰੀਸੈੱਟ ਕਰੋ"
    override val resetCatalogConfirm = "ਸਾਰੀਆਂ ਰੇਟਿੰਗਾਂ, ਕਾਊਂਟਰ ਅਤੇ ਜਾਂਚ ਲਾਗ ਸਿਫ਼ਰ ਕਰਨੇ ਹਨ? " +
        "ਡਾਊਨਲੋਡ ਕੀਤੇ ਹੋਸਟ ਅਤੇ ਸਬਸਕ੍ਰਿਪਸ਼ਨਾਂ ਰੱਖੀਆਂ ਜਾਂਦੀਆਂ ਹਨ ਅਤੇ ਅਗਲੇ ਸਕੈਨ 'ਤੇ ਮੁੜ-ਰੇਟ ਹੁੰਦੀਆਂ ਹਨ।"
    override val clearHosts = "ਡਾਊਨਲੋਡ ਕੀਤੇ ਹੋਸਟ ਸਾਫ਼ ਕਰੋ"
    override val clearHostsConfirm = "ਡਾਊਨਲੋਡ ਕੀਤੇ ਹੋਸਟਾਂ (ਪ੍ਰੌਕਸੀਆਂ) ਦੀ ਪੂਰੀ ਸੂਚੀ ਮਿਟਾਉਣੀ ਹੈ? " +
        "ਸਬਸਕ੍ਰਿਪਸ਼ਨਾਂ ਰੱਖੀਆਂ ਜਾਂਦੀਆਂ ਹਨ ਅਤੇ ਸਕੈਨ ਪੂਲ ਮੁੜ ਭਰ ਦੇਵੇਗਾ।"
    override val doReset = "ਰੀਸੈੱਟ"
    override val doCancel = "ਰੱਦ ਕਰੋ"
    override val adaptiveSpeed = "ਅਨੁਕੂਲ ਗਤੀ"
    override val adaptiveHelp = "ਜੀਵੰਤਤਾ ਜਾਂਚਾਂ ਇੱਕ ਅਧਾਰ ਅੰਤਰਾਲ 'ਤੇ ਚੱਲਦੀਆਂ ਹਨ (\"ਸਕੈਨ ਤੇ ਜਾਂਚ\" ਤੋਂ, ਨੈੱਟਵਰਕ " +
        "ਗੁਣਕ ਨਾਲ ਵੀ ਗੁਣਾ ਹੋ ਕੇ)। \"ਅਨੁਕੂਲ ਗਤੀ\" ਇਨ੍ਹਾਂ ਨੂੰ ਇਸ ਅਧਾਰ 'ਤੇ ਆਪਣੇ-ਆਪ ਤੇਜ਼ ਜਾਂ ਹੌਲੀ ਕਰਦੀ ਹੈ " +
        "ਕਿ ਇਸ ਵੇਲੇ ਕਿੰਨੀਆਂ ਪ੍ਰੌਕਸੀਆਂ ਚਾਲੂ ਹਨ।\n\n" +
        "• ਘੱਟ ਚਾਲੂ (\"ਘੱਟ\" ਹੱਦ ਤੋਂ ਹੇਠਾਂ) → ਅੰਤਰਾਲ × \"ਤੇਜ਼ੀ\"। 1 ਤੋਂ ਘੱਟ ਗੁਣਕ = ਜ਼ਿਆਦਾ " +
        "ਵਾਰ: 0.5 — ਦੁੱਗਣਾ ਵਾਰ, 0.25 — 4×। ਪੂਲ ਜਲਦੀ ਭਰਦਾ ਹੈ।\n" +
        "• ਬਹੁਤ ਚਾਲੂ (\"ਬਹੁਤ\" ਹੱਦ ਤੋਂ ਉੱਪਰ) → ਅੰਤਰਾਲ × \"ਹੌਲੀ\"। 1 ਤੋਂ ਉੱਪਰ = ਘੱਟ ਵਾਰ: 2 — " +
        "ਅੱਧਾ ਵਾਰ, 4 — ਚੌਥਾਈ। ਬੈਟਰੀ ਅਤੇ ਟ੍ਰੈਫਿਕ ਬਚਾਉਂਦਾ ਹੈ।\n" +
        "• ਹੱਦਾਂ ਦੇ ਵਿਚਕਾਰ — ਅਧਾਰ ਗਤੀ (×1)।\n\n" +
        "ਉਦਾਹਰਣਾਂ:\n" +
        "— ਪ੍ਰੌਕਸੀਆਂ ਤੇਜ਼ ਇਕੱਠੀਆਂ ਕਰੋ: \"ਤੇਜ਼ੀ\" 0.25 ਅਤੇ/ਜਾਂ \"ਘੱਟ\" ਹੱਦ 40।\n" +
        "— ਜਦੋਂ ਕਾਫ਼ੀ ਹੋਣ ਤਾਂ ਬੈਟਰੀ ਬਚਾਓ: \"ਹੌਲੀ\" 8 ਅਤੇ/ਜਾਂ \"ਬਹੁਤ\" ਹੱਦ 30।\n" +
        "— ਅਨੁਕੂਲਨ ਬੰਦ ਕਰੋ: ਦੋਵੇਂ ਗੁਣਕ 1 ਸੈੱਟ ਕਰੋ।\n\n" +
        "ਮੂਲ: ਘੱਟ 20, ਤੇਜ਼ੀ 0.5, ਬਹੁਤ 50, ਹੌਲੀ 4।"
    override val threshMany = "\"ਬਹੁਤ\" ਹੱਦ"; override val threshFew = "\"ਘੱਟ\" ਹੱਦ"; override val mulFast = "ਤੇਜ਼ੀ ×"; override val mulLazy = "ਹੌਲੀ ×"
    override val subIntensityTitle = "ਸਬਸਕ੍ਰਿਪਸ਼ਨ ਤੀਬਰਤਾ"
    override val subIntensityHint = "ਸਬਸਕ੍ਰਿਪਸ਼ਨ ਡਾਊਨਲੋਡਾਂ ਵਿਚਕਾਰ ਵਿਰਾਮ: ਪ੍ਰੌਕਸੀ ਸੂਚੀਆਂ ਮੁੜ-ਡਾਊਨਲੋਡ ਕਰਨ ਤੋਂ ਪਹਿਲਾਂ ਕਿੰਨੇ ਮਿੰਟ (ਹਰ ਨੈੱਟਵਰਕ ਮੋਡ ਅਨੁਸਾਰ ਵੱਖਰੇ)।"
    override val baseScanTitle = "ਅਧਾਰ ਸਕੈਨ ਗਤੀ"
    override val baseScanHelp = "ਹਵਾਲਾ ਜੀਵੰਤਤਾ-ਜਾਂਚ ਗਤੀ। \"ਅਨੁਕੂਲ ਗਤੀ\" ਅਤੇ \"ਮੋਡ ਅਨੁਸਾਰ ਗਤੀ\" " +
        "ਗੁਣਕ ਇਸ ਦੇ ਮੁਕਾਬਲੇ ਗਿਣੇ ਜਾਂਦੇ ਹਨ।\n\n" +
        "• ਕਿੰਨੀ ਵਾਰ ਚਲਾਉਣਾ, ਮਿੰਟ — ਜਾਂਚ ਚਲਨਾਂ ਵਿਚਕਾਰ ਅੰਤਰਾਲ।\n" +
        "• ਪ੍ਰਤੀ ਥ੍ਰੈੱਡ ਬੈਚ, ਹੋਸਟ — ਹਰ ਥ੍ਰੈੱਡ ਪ੍ਰਤੀ ਚਲਨ ਕਿੰਨੇ ਹੋਸਟ ਜਾਂਚਦਾ ਹੈ।\n" +
        "• ਥ੍ਰੈੱਡ — ਇੱਕੋ ਵਾਰ ਕਿੰਨੀਆਂ ਜਾਂਚਾਂ ਚੱਲਦੀਆਂ ਹਨ। ਇੱਕ ਚਲਨ \"ਬੈਚ × ਥ੍ਰੈੱਡ\" ਹੋਸਟਾਂ ਨੂੰ ਪ੍ਰੋਬ ਕਰਦਾ ਹੈ।\n" +
        "• ਇੱਕ ਹੋਸਟ ਨੂੰ ਹਰ N ਮਿੰਟ ਤੋਂ ਜ਼ਿਆਦਾ ਵਾਰ ਮੁੜ-ਸਕੈਨ ਨਾ ਕਰੋ — ਐਂਟੀ-ਫਲੱਡ: ਹਾਲ ਹੀ ਵਿੱਚ ਜਾਂਚਿਆ ਹੋਸਟ " +
        "ਇਸ ਚਲਨ ਵਿੱਚ ਛੱਡ ਦਿੱਤਾ ਜਾਂਦਾ ਹੈ।\n\n" +
        "ਜ਼ਿਆਦਾ ਥ੍ਰੈੱਡ ਅਤੇ ਵੱਡਾ ਬੈਚ = ਤੇਜ਼ ਪੂਲ ਵਾਧਾ, ਪਰ ਨੈੱਟਵਰਕ ਅਤੇ ਬੈਟਰੀ 'ਤੇ ਜ਼ਿਆਦਾ ਭਾਰ।"
    override val baseScanPeriod = "ਕਿੰਨੀ ਵਾਰ ਚਲਾਉਣਾ, ਮਿੰਟ"
    override val baseScanBatch = "ਪ੍ਰਤੀ ਥ੍ਰੈੱਡ ਬੈਚ, ਹੋਸਟ"; override val baseScanThreads = "ਥ੍ਰੈੱਡ ਗਿਣਤੀ"
    override val adaptiveDesc = "ਜੇ ਚਾਲੂ ਪ੍ਰੌਕਸੀਆਂ \"ਘੱਟ\" ਤੋਂ ਘੱਟ ਜਾਂ \"ਬਹੁਤ\" ਤੋਂ ਜ਼ਿਆਦਾ ਹੋਣ, ਤਾਂ ਇੱਕ ਵਾਧੂ ਗੁਣਕ ਲਾਗੂ ਕਰੋ।"
    override val fewWord = "ਘੱਟ"; override val manyWord = "ਬਹੁਤ"
    override fun fasterX(x: String) = "${x}× ਤੇਜ਼"
    override fun slowerX(x: String) = "${x}× ਹੌਲੀ"
    override fun ifAliveLt(n: Int) = "ਜੇ ਚਾਲੂ ਪ੍ਰੌਕਸੀਆਂ < ${n}, ਤਾਂ:"
    override fun ifAliveGt(n: Int) = "ਜੇ ਚਾਲੂ ਪ੍ਰੌਕਸੀਆਂ > ${n}, ਤਾਂ:"
    override val disabledWord = "ਬੰਦ"
    override val speedByModeTitle = "ਮੋਡ ਅਨੁਸਾਰ ਗਤੀ"
    override val speedByModeHelp = "ਅਧਾਰ ਗਤੀ ਦੇ ਉੱਪਰ ਹਰ ਨੈੱਟਵਰਕ ਮੋਡ ਲਈ ਇੱਕ ਸਕੈਨ-ਗਤੀ ਗੁਣਕ। " +
        "\"ਮਿਆਰੀ\" (×1) = ਅਧਾਰ ਅੰਤਰਾਲ। ਸੱਜੇ — ਘੱਟ ਵਾਰ (ਹੌਲੀ, ਟ੍ਰੈਫਿਕ/" +
        "ਬੈਟਰੀ 'ਤੇ ਨਰਮ), ਖੱਬੇ — ਜ਼ਿਆਦਾ ਵਾਰ (ਤੇਜ਼, ਜ਼ਿਆਦਾ ਹਮਲਾਵਰ)। ਲਾਗਰਿਥਮਿਕ ਪੈਮਾਨਾ, ਹਰ ਪਾਸੇ ×100 " +
        "ਤੱਕ।\n\n" +
        "ਹਰ ਸਲਾਈਡਰ ਹੇਠਾਂ ਅਨੁਕੂਲ ਗਤੀ ਲਾਗੂ ਹੋਣ ਨਾਲ ਨਤੀਜੇ ਵਾਲੇ ਚਲਨ ਪੈਰਾਮੀਟਰ ਹਨ — " +
        "\"ਘੱਟ ਚਾਲੂ\" (× \"ਤੇਜ਼ੀ\") ਅਤੇ \"ਬਹੁਤ ਚਾਲੂ\" (× \"ਹੌਲੀ\") ਲਈ ਵੱਖਰੇ ਵਿਖਾਏ ਗਏ।\n\n" +
        "ਮੋਡ:\n• VPN — ਇੱਕ ਬਾਹਰੀ VPN ਚਾਲੂ ਹੈ।\n• LTE — ਮੋਬਾਈਲ ਨੈੱਟਵਰਕ।\n• Wi-Fi — Wi-Fi ਨੈੱਟਵਰਕ।\n" +
        "• Ethernet — ਤਾਰ ਵਾਲਾ ਕਨੈਕਸ਼ਨ।\n• White — ਹੱਥੀਂ \"ਵਾਈਟ\" ਪ੍ਰੌਕਸੀ ਮੋਡ।"
    override val aliveLt = "ਚਾਲੂ <"; override val aliveGt = "ਚਾਲੂ >"
    override val periodWord = "ਅਵਧੀ"; override val nonstopWord = "ਲਗਾਤਾਰ"
    override val batchWord = "ਬੈਚ"; override val threadsWord = "ਥ੍ਰੈੱਡ"; override val scanModeOff = "ਸਕੈਨ ਬੰਦ"
    override val netBattery = "ਨੈੱਟਵਰਕ ਤੇ ਬੈਟਰੀ"
    override val netBatteryHelp = "• ਸਿਰਫ਼ Wi-Fi — ਮੋਬਾਈਲ ਨੈੱਟਵਰਕਾਂ 'ਤੇ ਸਕੈਨ ਨਾ ਕਰੋ (ਡੇਟਾ ਬਚਾਉਂਦਾ ਹੈ)।\n• ਸਿਰਫ਼ " +
        "ਚਾਰਜਿੰਗ — ਸਿਰਫ਼ ਉਦੋਂ ਕੰਮ ਕਰੋ ਜਦੋਂ ਫੋਨ ਚਾਰਜ ਹੋ ਰਿਹਾ ਹੋਵੇ।\n• ਘੱਟ ਬੈਟਰੀ 'ਤੇ ਛੱਡੋ — ਜਦੋਂ " +
        "ਬੈਟਰੀ ਘੱਟ ਹੋਵੇ ਤਾਂ ਸਕੈਨਿੰਗ ਰੋਕੋ।"
    override val onlyWifi = "ਸਿਰਫ਼ Wi-Fi"; override val onlyCharging = "ਸਿਰਫ਼ ਚਾਰਜਿੰਗ"; override val skipLowBattery = "ਘੱਟ ਬੈਟਰੀ 'ਤੇ ਛੱਡੋ"
    override val autosaved = "ਸੈਟਿੰਗਾਂ ਆਪਣੇ-ਆਪ ਸੰਭਾਲੀਆਂ ਜਾਂਦੀਆਂ ਹਨ।"
    override val dpiAutoLabel = "DPI ਤਰੀਕੇ ਆਟੋ-ਰੋਟੇਟ ਕਰੋ"; override val dpiNoneLabel = "ਕੋਈ DPI ਤਰੀਕਾ ਨਹੀਂ (ਸਾਦਾ)"
    override val experimental = "ਪ੍ਰਯੋਗਾਤਮਕ"
    override val experimentalHelp = "MTProto ਅੱਪਸਟ੍ਰੀਮ ਦੇ ਬਦਲਵੇਂ ਪ੍ਰੌਕਸੀਿੰਗ ਇੰਜਣ ਨਾਲ ਇੱਕ ਡਾਇਗਨੌਸਟਿਕ ਲਾਗ। " +
        "\"ਬੰਦ\" 'ਤੇ ਸੈੱਟ ਹੋਣ 'ਤੇ ਹਵਾਲਾ (ਕੰਮ ਕਰਦਾ) ਮਾਰਗ ਬਦਲਿਆ ਨਹੀਂ ਜਾਂਦਾ। ਸਿਰਫ਼ ਇਹ ਬਦਲਦਾ ਹੈ ਕਿ ਏਨਕ੍ਰਿਪਟ ਕੀਤੀ ਸਟ੍ਰੀਮ " +
        "ਅੱਪਸਟ੍ਰੀਮ TCP ਸਾਕਟ ਵਿੱਚ ਕਿਵੇਂ ਲਿਖੀ ਜਾਂਦੀ ਹੈ (ਸੈਗਮੈਂਟ ਆਕਾਰ, ਸਮਾਂ, TLS-ਰਿਕਾਰਡ ਹੱਦਾਂ) — ਸਟ੍ਰੀਮ ਆਪ ਬਾਈਟ-ਦਰ-ਬਾਈਟ ਇੱਕੋ ਜਿਹੀ ਰਹਿੰਦੀ ਹੈ। " +
        "ਸਿਰਫ਼ ਚਾਲੂ ਪ੍ਰੌਕਸੀ ਰੀਲੇ 'ਤੇ ਲਾਗੂ ਹੁੰਦਾ ਹੈ (ਪ੍ਰੋਬਾਂ 'ਤੇ ਨਹੀਂ, ਸਿੱਧੇ ਮਾਰਗ 'ਤੇ ਨਹੀਂ)।"
    override val expEngineTitle = "ਪ੍ਰੌਕਸੀਿੰਗ ਇੰਜਣ (ਸਾਕਟ ਅਸਪਸ਼ਟੀਕਰਨ)"
    override val expConnectTitle = "ਕਨੈਕਟ ਇੰਜਣ (ਅੱਪਸਟ੍ਰੀਮ ਚੋਣ)"
    override val expEngineWarn = "⚠ ਪ੍ਰਯੋਗਾਤਮਕ ਮੋਡ। ਜੇ ਕਨੈਕਟੀਵਿਟੀ ਖਰਾਬ ਹੋ ਜਾਵੇ, ਤਾਂ \"ਬੰਦ (ਹਵਾਲਾ ਮਾਰਗ)\" 'ਤੇ ਵਾਪਸ ਜਾਓ।"
    override val netLog = "ਨੈੱਟਵਰਕ-ਵਟਾਂਦਰਾ ਲਾਗ ਚਾਲੂ ਕਰੋ"
    override val netLogSub = "ਕੌਣ-ਨੂੰ-ਕਿਸ-ਕਦੋਂ ਅਤੇ ਪੈਕਟ ਆਕਾਰ ਨੂੰ ਇੱਕ ਫਾਈਲ ਵਿੱਚ ਲਿਖਦਾ ਹੈ (ਕੋਈ ਪੇਲੋਡ ਡੇਟਾ ਨਹੀਂ) — " +
        "VPN ਨਾਲ ਅਤੇ ਬਿਨਾਂ ਵਟਾਂਦਰਾ ਪੈਟਰਨ ਦੀ ਤੁਲਨਾ ਕਰਨ ਲਈ।"
    override val openLogFolder = "ਲਾਗ ਫੋਲਡਰ ਖੋਲ੍ਹੋ"; override val copyPath = "ਪਾਥ ਕਾਪੀ ਕਰੋ"
    override val helpShow = "ਮਦਦ"; override val helpHide = "ਮਦਦ ਲੁਕਾਓ"
    override val quickSwitchIntro = "ਇੱਥੇ ਤੁਸੀਂ ਇੱਕ ਬਲਾਕ-ਬਾਈਪਾਸ ਤਰੀਕਾ ਚੁਣ ਸਕਦੇ ਹੋ। ਜੇ Telegram ਗਲਤੀ ਵਿਖਾਏ " +
        "“The proxy you are using is not configured correctly and will be disabled. Please find another " +
        "one”, ਤਾਂ ਪ੍ਰਯੋਗ ਕਰੋ ਕਿ ਕਿਹੜੀ ਟ੍ਰੈਫਿਕ-ਅਸਪਸ਼ਟੀਕਰਨ ਕਿਸਮ ਕੰਮ ਕਰਦੀ ਹੈ ਤਾਂ ਕਿ Telegram ਇਸਨੂੰ ਵਿਖਾਉਣਾ ਬੰਦ ਕਰੇ। " +
        "split* ਮੋਡ ਨਾਲ ਸ਼ੁਰੂ ਕਰੋ। coalesce* ਮੋਡ ਵੀ ਕੰਮ ਕਰਦੇ ਹਨ, ਪਰ ਇਨ੍ਹਾਂ ਨਾਲ Telegram ਵਿੱਚ ਤਸਵੀਰਾਂ/ਵੀਡੀਓ ਮਾੜੇ ਲੋਡ ਹੁੰਦੇ ਹਨ।"
    override val quickSwitchTitle ="ਬਲਾਕ ਬਾਈਪਾਸ"; override val quickSwitchSub = "ਸ਼ੇਪਿੰਗ, ਕਨੈਕਟ, ਐਂਟੀ-DPI"

    override val sourceUrl = "ਸਰੋਤ URL"
    override fun sourceAlive(alive: Int, total: Int) = "ਚਾਲੂ ${alive}/${total}"
    override val open = "ਖੋਲ੍ਹੋ"; override val active = "ਚਾਲੂ"; override val inactive = "ਅਕਿਰਿਆਸ਼ੀਲ"
    override val lastDownloaded = "ਡਾਊਨਲੋਡ ਕੀਤੀ"; override val notDownloaded = "ਹਾਲੇ ਡਾਊਨਲੋਡ ਨਹੀਂ ਹੋਈ"
    override fun sourceCounts(dead: Int, total: Int) =
        " ਚਾਲੂ, ${dead} ਮਰੀਆਂ, ${total} ਕੁੱਲ"

    override val proxyBase = "ਪ੍ਰੌਕਸੀ ਡੇਟਾਬੇਸ"
    override val totalInBase = "ਡੇਟਾਬੇਸ ਵਿੱਚ ਕੁੱਲ"; override val aliveNow = "ਹੁਣ ਚਾਲੂ"; override val deadStat = "ਮਰੀਆਂ"
    override val aliveIn15 = "15 ਮਿੰਟ ਵਿੱਚ ਚਾਲੂ"; override val checksAllTime = "ਹਰ ਸਮੇਂ ਦੀਆਂ ਜਾਂਚਾਂ"
    override val antiDpiTricks = "ਐਂਟੀ-DPI ਤਰੀਕੇ"; override val noStatsYet = "ਹਾਲੇ ਕੋਈ ਡੇਟਾ ਨਹੀਂ — ਜਾਂਚਾਂ/ਕਨੈਕਸ਼ਨ ਹੋਣ ਨਾਲ ਤਰੀਕੇ ਇਕੱਠੇ ਹੁੰਦੇ ਹਨ"
    override val attempts = "ਕੋਸ਼ਿਸ਼ਾਂ"; override val handshake = "ਹੈਂਡਸ਼ੇਕ"; override val score = "ਅੰਕ"
    override val tgConnect = "TG ਕਨੈਕਟ"; override val socketsOver1m = "ਸਾਕਟ >1ਮਿੰਟ"
    override val over10kb = "ਸਾਕਟ >10KB"; override val over100kb = ">100KB"; override val workTime = "ਕੰਮ ਸਮਾਂ"
    override val statsLegend = "ਹੈਂਡਸ਼ੇਕ — ਸਫਲ ਹੈਂਡਸ਼ੇਕ (ਕੋਸ਼ਿਸ਼ਾਂ ਦਾ %) · ਅੰਕ — ਮੁੱਲ · " +
        "\"ਕੰਮ ਸਮਾਂ\" — ≥5KB ਅਤੇ 1 ਮਿੰਟ ਤੋਂ ਲੰਮੇ ਸਾਕਟਾਂ ਉੱਤੇ ਕੁੱਲ।"
    override val resetStats = "ਤਰੀਕਾ ਅੰਕੜੇ ਰੀਸੈੱਟ ਕਰੋ"

    override fun aliveLinks(n: Int) = "ਚਾਲੂ ਲਿੰਕ: ${n}"
    override val copyAll = "ਸਭ ਕਾਪੀ ਕਰੋ"
    override val openRandom = "ਬੇਤਰਤੀਬ ਖੋਲ੍ਹੋ"; override val copyRandom = "ਬੇਤਰਤੀਬ ਕਾਪੀ ਕਰੋ"; override val allShort = "ਸਭ"
    override val copyTop = "TOP ਕਾਪੀ ਕਰੋ"; override val randomHost = "ਬੇਤਰਤੀਬ ਹੋਸਟ"
    override val exportToFile = "ਫਾਈਲ ਵਿੱਚ ਐਕਸਪੋਰਟ ਕਰੋ"; override val exportSaved = "ਫਾਈਲ ਵਿੱਚ ਸੰਭਾਲੀ:"
    override val dlNow = "ਹੁਣ ਡਾਊਨਲੋਡ ਕਰੋ"
    override fun downloadingFmt(sec: Long) = "ਡਾਊਨਲੋਡ ਹੋ ਰਿਹਾ…  ${sec}ਸ"
    override val cancel = "ਰੱਦ ਕਰੋ"
    override val deleteConfirmTitle = "ਸਬਸਕ੍ਰਿਪਸ਼ਨ ਮਿਟਾਉਣੀ ਹੈ?"
    override val subscriptionsAddHint = "ਸਬਸਕ੍ਰਿਪਸ਼ਨਾਂ ਜਾਂ ਪ੍ਰੌਕਸੀ ਲਿੰਕ ਜੋੜੋ →"
    override val addSourcesTitle = "ਜੋੜੋ"
    override val addSubsLabel = "ਸਬਸਕ੍ਰਿਪਸ਼ਨਾਂ (ਪ੍ਰਤੀ ਲਾਈਨ ਇੱਕ URL)"
    override val addSubsHelp = "ਇੱਕ ਵੈਧ URL ਵਾਲੀ ਹਰ ਲਾਈਨ ਆਪਣੀ ਖੁਦ ਦੀ ਸਬਸਕ੍ਰਿਪਸ਼ਨ ਬਣ ਜਾਂਦੀ ਹੈ ਅਤੇ ਸਮੇਂ-ਸਮੇਂ ਡਾਊਨਲੋਡ ਹੁੰਦੀ ਹੈ।"
    override val addProxiesLabel = "ਤਿਆਰ ਪ੍ਰੌਕਸੀ ਲਿੰਕ (ਸਥਿਰ ਸੂਚੀ)"
    override val addProxiesHelp = "ਖਾਸ ਪ੍ਰੌਕਸੀਆਂ ਦੇ ਲਿੰਕਾਂ ਦਾ ਇੱਕ ਬੈਚ ਪੇਸਟ ਕਰੋ (tg://proxy, https://t.me/proxy, …)। ਇਹ ਸਬਸਕ੍ਰਿਪਸ਼ਨ ਨਹੀਂ ਹੈ — ਸੂਚੀ ਕਦੇ ਡਾਊਨਲੋਡ ਨਹੀਂ ਹੁੰਦੀ, ਪ੍ਰੌਕਸੀਆਂ ਸਿਰਫ਼ ਕੈਟਾਲਾਗ ਵਿੱਚ ਜੋੜ ਦਿੱਤੀਆਂ ਜਾਂਦੀਆਂ ਹਨ।"
    override val addButton = "ਜੋੜੋ"
    override fun addedFmt(subs: Int, proxies: Int) = "ਜੋੜੀਆਂ: ${subs} ਸਬਸਕ੍ਰਿਪਸ਼ਨਾਂ, ${proxies} ਪ੍ਰੌਕਸੀਆਂ"
    override val perSecond = "ਪ੍ਰਤੀ ਸਕਿੰਟ"
    override val graphSpeed = "ਗਤੀ"
    override val graphVolume = "ਮਾਤਰਾ"
    override val graphLatency = "ਪਿੰਗ"
    override val graphConnects = "ਕਨੈਕਟ"
    override val scanNow = "ਹੁਣ ਸਕੈਨ ਕਰੋ"; override val scanOnShort = "ਸਕੈਨ ਚਾਲੂ"
    override val scanRunning = "ਸਕੈਨ ਚੱਲ ਰਿਹਾ"; override val scanIdle = "ਸਕੈਨ ਵਿਹਲਾ"; override val scanOffState = "ਸਕੈਨ ਬੰਦ"; override val scanBatchPerThread = "ਬੈਚ/ਥ੍ਰੈੱਡ"; override val scanPassHosts = "ਚਲਨ ਵਿੱਚ ਹੋਸਟ"; override val minRescanLabel = "ਇੱਕ ਹੋਸਟ ਨੂੰ ਹਰ N ਮਿੰਟ ਤੋਂ ਜ਼ਿਆਦਾ ਵਾਰ ਮੁੜ-ਸਕੈਨ ਨਾ ਕਰੋ"
    override val scanPlanTitle = "ਯੋਜਨਾ"; override val scanNowTitle = "ਹੁਣ"; override val currentScheduleTitle = "ਮੌਜੂਦਾ ਸ਼ੈਡਿਊਲ"
    override val scheduleWord = "ਸ਼ੈਡਿਊਲ"; override val unitPcsPerSec = "ਨਗ/ਸ"
    override val scanNowThreadsLabel = "ਹੁਣ ਚੱਲ ਰਹੇ ਥ੍ਰੈੱਡ"; override val scanNowPerThreadLabel = "ਪ੍ਰਤੀ ਥ੍ਰੈੱਡ ਜਾਂਚਾਂ (ਯੋਜਨਾ)"; override val scanNowElapsedLabel = "ਚਲਨ ਸਮਾਂ"
    override val scanOkGraph = "ਸਫਲ ਸਕੈਨ"; override val scanFailGraph = "ਅਸਫਲ ਸਕੈਨ"; override val scanTrafficGraph = "ਸਕੈਨ ਟ੍ਰੈਫਿਕ"; override val scanAliveGraph = "ਕੁੱਲ ਚਾਲੂ ਪ੍ਰੌਕਸੀਆਂ"; override val scanPingGraph = "ਪਿੰਗ"; override val threadsGraph = "ਥ੍ਰੈੱਡ"
    override val scanEvery = "ਹਰ"; override val scanNextRun = "ਅਗਲਾ ਚਲਨ"
    override val scanThreads = "ਥ੍ਰੈੱਡ"; override val scanBatch = "ਬੈਚ"
    override val scanElapsed = "ਚੱਲ ਰਿਹਾ"; override val scanIdleNow = "—"
    override val effForFew = "ਜਦੋਂ ਘੱਟ"; override val effForMany = "ਜਦੋਂ ਬਹੁਤ"
    override val effCheck = "ਜਾਂਚ"; override val effBatch = "ਬੈਚ"; override val effPar = "ਸਮਾਨਾਂਤਰ"
    override val effContinuous = "ਨਿਰੰਤਰ"; override val secShort = "ਸ"; override val minShort = "ਮਿੰਟ"

    override val appTagline = "ਕ੍ਰਾਸ-ਪਲੇਟਫਾਰਮ ਆਟੋ-ਕਨੈਕਟਰ: ਇਹ MTProto ਪ੍ਰੌਕਸੀਆਂ ਲੱਭਦਾ, ਜਾਂਚਦਾ ਅਤੇ ਚਲਾਉਂਦਾ ਹੈ " +
        "ਜਿਨ੍ਹਾਂ ਰਾਹੀਂ Telegram ਕੰਮ ਕਰਦਾ ਹੈ।"
    override val version = "ਵਰਜਨ"; override val buildDate = "ਬਿਲਡ ਮਿਤੀ"
    override val downloadSources = "ਡਾਊਨਲੋਡ ਤੇ ਸਰੋਤ"; override val openOnGithub = "GitHub 'ਤੇ ਖੋਲ੍ਹੋ"
    override val feedbackBugs = "ਫੀਡਬੈਕ ਤੇ ਬੱਗ ਰਿਪੋਰਟ"; override val writeTelegram = "Telegram 'ਤੇ ਲਿਖੋ"

    override val language = "ਭਾਸ਼ਾ"; override val langAuto = "ਆਟੋ (ਸਿਸਟਮ)"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "ਭਾਸ਼ਾ"
    override val raceWidthTitle = "ਸਮਾਨਾਂਤਰ ਕਨੈਕਟ"
    override val connectionSection = "ਕਨੈਕਸ਼ਨ ਤੇ ਬਲਾਕ ਬਾਈਪਾਸ"
    override val connectionSectionHelp = "ਕਨੈਕਟ ਇੰਜਣ, ਸਮਾਨਾਂਤਰ ਅੱਪਸਟ੍ਰੀਮ, ਪ੍ਰੌਕਸੀਿੰਗ ਇੰਜਣ ਅਤੇ ਐਂਟੀ-DPI ਤਰੀਕੇ — ਸਭ ਇੱਕੋ ਸੈਕਸ਼ਨ ਵਿੱਚ।"
    override val netLogSection = "ਨੈੱਟਵਰਕ ਵਟਾਂਦਰਾ ਲਾਗ"
    override val platform = "ਪਲੇਟਫਾਰਮ"

    override val scanModeTitle = "ਨੈੱਟਵਰਕ ਮੋਡ"; override val scanModeAuto = "ਆਟੋ"; override val scanModeManualLabel = "ਹੱਥੀਂ"
    override val activeModeLabel = "ਚਾਲੂ ਮੋਡ"; override val formingListLabel = "ਸੂਚੀ ਬਣ ਰਹੀ ਹੈ"; override val catalogModeTabs = "ਮੋਡ"
    override val resetModeRatings = "ਹੋਸਟ ਰੇਟਿੰਗਾਂ ਰੀਸੈੱਟ ਕਰੋ"; override val forgetModeHosts = "ਮੋਡ ਦੇ ਹੋਸਟ ਭੁੱਲੋ"
    override val exportModeTitle = "ਮੋਡ ਅਨੁਸਾਰ ਐਕਸਪੋਰਟ"; override val modePickerTitle = "ਮੋਡ"
    override val modeHelp = "ਹਰ ਨੈੱਟਵਰਕ ਮੋਡ ਆਪਣੀਆਂ ਪ੍ਰੌਕਸੀ ਰੇਟਿੰਗਾਂ ਅਤੇ ਆਪਣੀ ਸਕੈਨ + ਸਬਸਕ੍ਰਿਪਸ਼ਨ-ਡਾਊਨਲੋਡ ਤੀਬਰਤਾ ਰੱਖਦਾ ਹੈ। \"ਆਟੋ\" ਚਾਲੂ ਨੈੱਟਵਰਕ ਤੋਂ ਮੋਡ ਚੁਣਦਾ ਹੈ। \"ਹੱਥੀਂ\" ਤੁਹਾਨੂੰ ਖੁਦ ਕੋਈ ਵੀ ਮੋਡ ਚੁਣਨ ਦਿੰਦਾ ਹੈ (White ਸਮੇਤ, ਜੋ ਆਟੋ ਕਦੇ ਨਹੀਂ ਚੁਣਦਾ)।"
    override val autoSelect = "ਆਟੋ ਚੋਣ"; override val manualSelect = "ਹੱਥੀਂ ਚੋਣ"
    override val connStatsTitle = "ਹੁਣ ਕਨੈਕਸ਼ਨ"; override val connOnPort = "ਪੋਰਟ 'ਤੇ ਕਨੈਕਸ਼ਨ"; override val outgoingConns = "ਬਾਹਰ ਜਾਣ ਵਾਲੇ ਕਨੈਕਸ਼ਨ"
    override val modeChoice = "ਮੋਡ ਚੋਣ"; override val autoChoice = "ਆਟੋ-ਚੋਣ"; override val manualChoice = "ਹੱਥੀਂ ਸਥਿਰ"
    override val directOnVpn = "VPN 'ਤੇ TG ਨੂੰ ਸਿੱਧਾ ਕਨੈਕਟ"; override val onWord = "ਚਾਲੂ"; override val offWord = "ਬੰਦ"
    override val directStateActive = "ਚਾਲੂ"; override val directStateOff = "ਸੈਟਿੰਗਾਂ ਵਿੱਚ ਬੰਦ"; override val directStateIdle = "ਸੈਟਿੰਗਾਂ ਵਿੱਚ ਚਾਲੂ, ਪਰ ਕਿਰਿਆਸ਼ੀਲ ਨਹੀਂ"
    override val wpHintTitle = "White ਕੀ ਹੈ?"
    override val wpHint = "White — WhitePages: ਇੱਕ ਹੱਥੀਂ ਨੈੱਟਵਰਕ ਪ੍ਰੋਫਾਈਲ। ਸਿਰਫ਼ ਹੱਥ ਨਾਲ ਚਾਲੂ ਹੁੰਦਾ ਹੈ (ਆਟੋ-ਚੋਣ ਇਸਨੂੰ ਕਦੇ ਨਹੀਂ ਚੁਣਦੀ)। " +
        "ਆਪਣੀਆਂ ਹੋਸਟ ਰੇਟਿੰਗਾਂ ਰੱਖਦਾ ਹੈ, ਸਬਸਕ੍ਰਿਪਸ਼ਨਾਂ ਡਾਊਨਲੋਡ ਕਰਦਾ ਹੈ ਅਤੇ VPN/Wi-Fi/LTE ਤੋਂ ਸੁਤੰਤਰ ਸਕੈਨ ਕਰਦਾ ਹੈ।"

    override val recentAttempts = "ਤਾਜ਼ਾ ਕਨੈਕਸ਼ਨ ਅਤੇ ਜਾਂਚਾਂ"
    override val kindCheck = "ਜਾਂਚ"
    override val kindTg = "ਟੈਲੀਗ੍ਰਾਮ"
    override val histWho = "ਕੌਣ"
    override val histWhen = "ਕਦੋਂ"
    override val histReq = "ਬੇਨਤੀ"
    override val histSess = "ਸੈਸ਼ਨ"
    override val histScan = "ਸਕੈਨ"
    override val testNow = "ਹੁਣ ਟੈਸਟ ਕਰੋ"
    override val testShort = "ਟੈਸਟ"
    override val testResult = "ਟੈਸਟ ਨਤੀਜਾ"
    override val testStop = "ਰੋਕੋ"
    override val testingNow = "ਟੈਸਟ ਚੱਲ ਰਿਹਾ…"

    override val prewarmTitle = "ਸਾਕਟ ਪ੍ਰੀਵਾਰਮ (ਪ੍ਰਯੋਗ)"
    override val prewarmHelp = "ਪ੍ਰੌਕਸੀ ਨਾਲ ਕੁਝ ਸਾਕਟ ਪਹਿਲਾਂ ਤੋਂ ਖੁੱਲ੍ਹੇ ਰੱਖੋ ਤਾਂ ਕਿ ਨਵਾਂ Telegram " +
        "ਕਨੈਕਸ਼ਨ ਕਨੈਕਟ/ਹੈਂਡਸ਼ੇਕ ਛੱਡ ਸਕੇ। ਪ੍ਰਯੋਗਾਤਮਕ: ਬੈਕਗ੍ਰਾਊਂਡ ਲਗਾਤਾਰ ਮੁੜ-ਜੁੜਦਾ ਹੈ → ਟ੍ਰੈਫਿਕ ਅਤੇ ਥੋੜ੍ਹਾ CPU " +
        "ਖਰਚ। ਨਕਲੀ ਟ੍ਰੈਫਿਕ ਨਹੀਂ ਭੇਜਿਆ ਜਾਂਦਾ (ਇਹ ਅਸਲ ਸੈਸ਼ਨ ਤੋੜ ਦਿੰਦਾ) — ਸਾਕਟ ਸਿਰਫ਼ ਰੋਟੇਟ ਹੁੰਦੇ ਹਨ। " +
        "FakeTLS ਪ੍ਰੌਕਸੀਆਂ ਨਾਲ ਸਭ ਤੋਂ ਵੱਧ ਲਾਭਦਾਇਕ।"
    override val prewarmEnable = "ਪ੍ਰੀਵਾਰਮ ਚਾਲੂ ਕਰੋ"
    override val prewarmModeDeferred = "ਮੁਲਤਵੀ (ਸਿਰਫ਼ TLS)"
    override val prewarmModeDeferredSub = "TCP + FakeTLS ਰੱਖਦੇ ਹਾਂ; obfuscated2-init ਡੇਟਾ ਭੇਜਣ ਵੇਲੇ ਮਗਰੋਂ ਭੇਜਿਆ ਜਾਂਦਾ ਹੈ। DC ਕਮਿਟ ਨਹੀਂ ਹੁੰਦਾ — ਸਭ ਤੋਂ ਵੱਧ ਅਸਲੀ।"
    override val prewarmModeFull = "ਪੂਰਾ ਹੈਂਡਸ਼ੇਕ"
    override val prewarmModeFullSub = "ਵੱਖ-ਵੱਖ DC ਲਈ ਪੂਰੀ ਤਰ੍ਹਾਂ ਜੁੜੇ ਸਾਕਟ ਰੱਖਦੇ ਹਾਂ; ਸਿਰਫ਼ DC/tag ਮੈਚ ਹੋਣ 'ਤੇ ਮੁੜ-ਵਰਤਦੇ ਹਾਂ। ਘੱਟ ਜਿਉਂਦੇ ਹਨ।"
    override val prewarmPoolLabel = "ਰਿਜ਼ਰਵ ਵਿੱਚ ਸਾਕਟ"
    override val prewarmHoldLabel = "ਰੱਖੋ, ਸ"
    override val prewarmNote = "ਸਿਰਫ਼ ਰੋਟੇਸ਼ਨ (ਐਪ ਪੱਧਰ 'ਤੇ ਕੋਈ keepalive ਨਹੀਂ)। ਸਾਕਟ ਸਕਿੰਟਾਂ…~ਇੱਕ ਮਿੰਟ ਜਿਉਂਦਾ ਹੈ, ਪ੍ਰੌਕਸੀ/DC 'ਤੇ ਨਿਰਭਰ।"
    override val prewarmStatus = "ਪ੍ਰੀਵਾਰਮ"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "${ready} ਤਿਆਰ · ${holdSecs}ਸ ਰੱਖੇ"
    override val prewarmStar = "ਮੋਟਾ ਸੰਤਰੀ = ਸਾਕਟ ਪ੍ਰੀਵਾਰਮ ਪੂਲ ਤੋਂ ਗਰਮ ਦਿੱਤਾ ਗਿਆ (ਕਨੈਕਟ/ਹੈਂਡਸ਼ੇਕ ਤੋਂ ਬਿਨਾਂ)"
    override fun prewarmTableTitle(holdSecs: Int) = "ਸਾਕਟ ਪ੍ਰੀਵਾਰਮ (${holdSecs}ਸ ਰੱਖੇ)"
    override val prewarmTableHelp = "\"ਸਾਕਟ ਪ੍ਰੀਵਾਰਮ\" ਪ੍ਰੌਕਸੀ ਨਾਲ ਕੁਝ ਸਾਕਟ ਪਹਿਲਾਂ ਤੋਂ ਖੋਲ੍ਹ ਦਿੰਦਾ ਹੈ ਤਾਂ ਕਿ ਨਵਾਂ " +
        "Telegram ਕਨੈਕਸ਼ਨ ਕਨੈਕਟ/ਹੈਂਡਸ਼ੇਕ ਛੱਡ ਸਕੇ। ਇਸ ਟੇਬਲ ਵਿੱਚ ਪ੍ਰੀਵਾਰਮ ਹੋਸਟ ਦਿਖਾਏ ਗਏ ਹਨ: ਸਾਕਟ ਕਿੰਨੇ ਸਕਿੰਟ " +
        "ਜਿਉਂਦਾ ਹੈ, ਕੀ Telegram ਇਸਨੂੰ ਵਰਤ ਰਿਹਾ ਹੈ, ਅਤੇ ਟ੍ਰੈਫਿਕ। ਚਾਲੂ/ਬੰਦ ਅਤੇ ਸੈੱਟ (ਮੋਡ, ਸਾਕਟ ਗਿਣਤੀ, " +
        "ਰੱਖਣ ਦਾ ਸਮਾਂ) \"ਹੋਰ → ਸੈਟਿੰਗਾਂ → 'ਸਾਕਟ ਪ੍ਰੀਵਾਰਮ (ਪ੍ਰਯੋਗ)'\" ਵਿੱਚ ਕਰ ਸਕਦੇ ਹੋ।"
    override val prewarmNoneWarming = "ਹਾਲੇ ਕੋਈ ਪ੍ਰੀਵਾਰਮ ਸਾਕਟ ਨਹੀਂ"
    override val prewarmColAge = "ਜਿਉਂਦਾ"
    override val prewarmColUse = "TG ਵਿੱਚ?"
    override val prewarmInUse = "TG ਵਿੱਚ"
    override val prewarmNew = "ਨਵਾਂ"
    override val lanShareTitle = "ਲੋਕਲ ਨੈੱਟਵਰਕ 'ਤੇ ਸਾਂਝਾ (ਵੈੱਬ ਪੋਰਟਲ)"
    override val lanShareDesc = "ਇਸ Wi-Fi ਵਿਚਲੇ ਹੋਰ ਡਿਵਾਈਸਾਂ ਨੂੰ ਇਸ AutoConnector ਨੂੰ ਪ੍ਰੌਕਸੀ ਵਜੋਂ ਵਰਤਣ ਦਿਓ; ਹੇਠਲੇ ਪਤੇ 'ਤੇ ਬ੍ਰਾਊਜ਼ਰ ਨੂੰ ਸਭ ਤੋਂ ਵਧੀਆ ਪ੍ਰੌਕਸੀਆਂ ਵਾਲਾ ਪੰਨਾ ਮਿਲੇਗਾ।"
    override val lanShareUrlsLabel = "ਨੈੱਟਵਰਕ ਗੁਆਂਢੀ ਇੰਝ ਜੁੜਦੇ ਹਨ:"
    override val lanShareNoIp = "ਲੋਕਲ ਨੈੱਟਵਰਕ ਵਿੱਚ ਕੋਈ ਪਤਾ ਨਹੀਂ — Wi-Fi ਨਾਲ ਜੁੜੋ"
    override val lanFirewallTitle = "ਲੋਕਲ ਨੈੱਟਵਰਕ ਵਿੱਚ ਆਗਿਆ ਦਿਓ"
    override val lanFirewallBody = "ਚਾਲੂ ਕਰਨ 'ਤੇ ਰੀਲੇ ਪੋਰਟ ਲੋਕਲ ਨੈੱਟਵਰਕ ਵਿੱਚ ਖੁੱਲ੍ਹ ਜਾਣਗੇ। ਹੁਣ Windows ਫਾਇਰਵਾਲ (ਜਾਂ ਕੋਈ ਹੋਰ) ਪੁੱਛ ਸਕਦਾ ਹੈ ਕਿ AutoConnector ਨੂੰ ਆਗਿਆ ਦੇਣੀ ਹੈ ਜਾਂ ਨਹੀਂ — \"ਆਗਿਆ ਦਿਓ\"/\"ਹਾਂ\" ਚੁਣੋ। ਜੇ ਮਨ੍ਹਾ ਕਰੋ, ਤਾਂ ਗੁਆਂਢੀਆਂ ਦਾ AutoConnector ਵੱਲ ਟ੍ਰੈਫਿਕ ਬਲਾਕ ਹੋ ਜਾਵੇਗਾ, ਅਤੇ ਪੰਨਾ/ਪ੍ਰੌਕਸੀ ਉਪਲਬਧ ਨਹੀਂ ਹੋਣਗੇ।"
    override val lanFirewallConfirm = "ਚਾਲੂ ਕਰੋ"
    override val lanInfoTitle = "ਇਹ ਕਿਉਂ?"
    override val lanInfoBody = "ਆਪਣੇ Wi-Fi ਵਿੱਚ ਕਿਸੇ ਇੱਕ ਕੰਪਿਊਟਰ ਜਾਂ ਫੋਨ 'ਤੇ AutoConnector ਚਲਾਓ — ਅਤੇ ਉਸੇ ਨੈੱਟਵਰਕ ਦੇ ਬਾਕੀ ਸਾਰੇ ਡਿਵਾਈਸ, iPhone ਸਮੇਤ (ਜਿਸਨੂੰ ਐਪ ਸਿੱਧਾ ਸਮਰਥਨ ਨਹੀਂ ਦਿੰਦੀ), ਸਿਰਫ਼ ਬ੍ਰਾਊਜ਼ਰ ਵਿੱਚ ਪਤਾ ਖੋਲ੍ਹ ਕੇ ਵਰਤ ਸਕਦੇ ਹਨ: ਉਨ੍ਹਾਂ ਦੇ Telegram ਵਿੱਚ ਜੋੜਨ ਲਈ ਸਭ ਤੋਂ ਵਧੀਆ ਪ੍ਰੌਕਸੀਆਂ ਵਾਲਾ ਪੰਨਾ, ਜਾਂ ਇਹ ਡਿਵਾਈਸ ਖੁਦ ਇੱਕ SOCKS ਪ੍ਰੌਕਸੀ ਵਜੋਂ। ਇੱਕ ਡਿਵਾਈਸ ਪ੍ਰੌਕਸੀਆਂ ਲੱਭ ਕੇ ਰੱਖਦਾ ਹੈ, ਬਾਕੀ ਉਨ੍ਹਾਂ ਨੂੰ ਲੋਕਲ ਨੈੱਟਵਰਕ ਰਾਹੀਂ ਵਰਤਦੇ ਹਨ।"
    override val volTriggerTitle = "ਵਾਲੀਅਮ ਬਟਨ ਟ੍ਰਿਗਰ"
    override val volTriggerSub = "ਵਾਲੀਅਮ ਕੁੰਜੀਆਂ ਦੇ ਤੇਜ਼ ਪੈਟਰਨ ਨਾਲ ਪ੍ਰੌਕਸੀ ਬਦਲੋ"
    override val volEnableLabel = "ਵਾਲੀਅਮ ਬਟਨਾਂ 'ਤੇ ਨਜ਼ਰ ਰੱਖੋ"
    override val volHelpTitle = "ਇਹ ਕੀ ਹੈ?"
    override val volHelpBody = "Android 'ਤੇ ਗਲੋਬਲ ਕੀਬੋਰਡ ਹਾਟਕੀਜ਼ ਨਹੀਂ ਹਨ, ਇਸ ਲਈ ਵਾਲੀਅਮ ਬਟਨ ਵਰਤੇ ਜਾਂਦੇ ਹਨ। ਜਦੋਂ ਚਾਲੂ ਹੋਵੇ, AutoConnector ਬੈਕਗ੍ਰਾਊਂਡ ਵਿੱਚ ਵਾਲੀਅਮ-ਉੱਪਰ/ਹੇਠਾਂ ਦਬਾਉਣ ਦੇ ਤੇਜ਼ ਪੈਟਰਨ (ਜਿਵੇਂ ਉੱਪਰ-ਉੱਪਰ-ਹੇਠਾਂ-ਹੇਠਾਂ) 'ਤੇ ਨਜ਼ਰ ਰੱਖਦਾ ਹੈ। ਇਸਨੂੰ ਪਛਾਣ ਕੇ, ਇਹ ਕਿਸੇ ਬੇਤਰਤੀਬ ਚੰਗੀ ਚਾਲੂ ਪ੍ਰੌਕਸੀ ਦਾ tg:// ਲਿੰਕ ਖੋਲ੍ਹਦਾ ਹੈ — Telegram ਇਸਨੂੰ ਫੜ ਕੇ ਬਦਲ ਜਾਂਦਾ ਹੈ। ਐਪ ਖੋਲ੍ਹੇ ਬਿਨਾਂ ਪ੍ਰੌਕਸੀ ਘੁੰਮਾਉਣ ਦਾ ਇੱਕ ਤੇਜ਼ ਅਣਦਿਸਦਾ ਤਰੀਕਾ। ਵਾਲੀਅਮ ਆਮ ਵਾਂਗ ਕੰਮ ਕਰਦਾ ਹੈ (ਦਬਾਉਣ ਫੜੇ ਨਹੀਂ ਜਾਂਦੇ)। Accessibility ਪਹੁੰਚ ਦੀ ਲੋੜ ਹੈ (ਬੈਕਗ੍ਰਾਊਂਡ ਵਿੱਚ ਕੁੰਜੀਆਂ ਪੜ੍ਹਨ ਅਤੇ ਲਿੰਕ ਖੋਲ੍ਹਣ ਲਈ); ਜਦ ਤੱਕ ਤੁਸੀਂ ਚੈੱਕਬਾਕਸ ਚਾਲੂ ਨਹੀਂ ਕਰਦੇ, ਕੁਝ ਨਹੀਂ ਮੰਗਿਆ ਜਾਂਦਾ। ਹੇਠਾਂ ਦਬਾਉਣ ਵਿਚਕਾਰ ਵੱਧ ਤੋਂ ਵੱਧ ਸਮਾਂ ਸੈੱਟ ਕਰੋ; ਪਛਾਣੇ ਜਾਣ ਵਾਲੇ ਪੈਟਰਨ ਹੇਠਾਂ ਦਿੱਤੇ ਹਨ।"
    override val volGrantTitle = "Accessibility ਚਾਲੂ ਕਰੋ (ਜ਼ਰੂਰੀ)"
    override val volGrantBody = "Android (ਖਾਸ ਕਰਕੇ 13+) Google Play ਤੋਂ ਬਾਹਰ ਇੰਸਟਾਲ ਕੀਤੀਆਂ ਐਪਾਂ ਲਈ Accessibility ਬਲਾਕ ਕਰਦਾ ਹੈ — ਇਸੇ ਕਰਕੇ AutoConnector ਸਲੇਟੀ ਹੈ ਅਤੇ ਲਿਖਦਾ ਹੈ \"ਐਪ ਲਈ ਪਹੁੰਚ ਮਨ੍ਹਾ ਹੈ\"।\n\nਅਨਬਲਾਕ ਕਿਵੇਂ ਕਰੀਏ:\n1. \"ਐਪ ਬਾਰੇ\" ਖੋਲ੍ਹੋ (ਹੇਠਲਾ ਬਟਨ, ਜਾਂ: ਸੈਟਿੰਗਾਂ → ਐਪਾਂ → AutoConnector for Telegram)।\n2. ⋮ (ਉੱਪਰ ਸੱਜੇ ਤਿੰਨ ਬਿੰਦੀਆਂ) ਦਬਾਓ → \"ਸੀਮਤ ਸੈਟਿੰਗਾਂ ਦੀ ਆਗਿਆ ਦਿਓ\" → ਪੁਸ਼ਟੀ ਕਰੋ।\n3. ਵਾਪਸ ਜਾਓ: ਸੈਟਿੰਗਾਂ → Accessibility → AutoConnector for Telegram → ਚਾਲੂ ਕਰੋ।\n\nਜੇ \"ਸੀਮਤ ਸੈਟਿੰਗਾਂ ਦੀ ਆਗਿਆ ਦਿਓ\" ਨਹੀਂ ਹੈ — ਪਹਿਲਾਂ ਇੱਕ ਵਾਰ Accessibility ਵਿੱਚ ਟੌਗਲ ਚਾਲੂ ਕਰਨ ਦੀ ਕੋਸ਼ਿਸ਼ ਕਰੋ (ਮਨ੍ਹਾ ਦਾ ਸੁਨੇਹਾ ਆਵੇਗਾ), ਫਿਰ ਕਦਮ 2 ਉਪਲਬਧ ਹੋ ਜਾਵੇਗਾ।\n\nXiaomi/MIUI, Samsung ਆਦਿ 'ਤੇ ਰਾਹ ਥੋੜ੍ਹਾ ਵੱਖਰਾ ਹੋ ਸਕਦਾ ਹੈ — \"ਐਪ ਬਾਰੇ\" ਵਿੱਚ ਉਹੀ ⋮ ਲੱਭੋ। Android 12 ਅਤੇ ਪੁਰਾਣੇ 'ਤੇ ਆਮ ਤੌਰ 'ਤੇ ਕੋਈ ਪਾਬੰਦੀ ਨਹੀਂ — ਸਿੱਧਾ ਚਾਲੂ ਕਰੋ।\n\nਵਾਲੀਅਮ ਕੁੰਜੀਆਂ ਸਿਰਫ਼ ਪੜ੍ਹੀਆਂ ਜਾਂਦੀਆਂ ਹਨ, ਕਦੇ ਬਲਾਕ ਨਹੀਂ ਹੁੰਦੀਆਂ।"
    override val volOpenAppInfo = "\"ਐਪ ਬਾਰੇ\" ਖੋਲ੍ਹੋ"
    override val volAccessOn = "Accessibility: ਚਾਲੂ"
    override val volAccessOff = "Accessibility: ਬੰਦ"
    override val volOpenAccess = "Accessibility ਸੈਟਿੰਗਾਂ ਖੋਲ੍ਹੋ"
    override val volGapLabel = "ਦਬਾਉਣ ਵਿਚਕਾਰ ਵੱਧ ਤੋਂ ਵੱਧ ਮਿਸ"
    override val volPatternsTitle = "ਪਛਾਣੇ ਜਾਣ ਵਾਲੇ ਪੈਟਰਨ"
    override val volPatternPick = "ਪੈਟਰਨ"
    override val volPatternsLegend = "↑ = ਵਾਲੀਅਮ ਉੱਪਰ, ↓ = ਹੇਠਾਂ"
    override val volNoRights = "ਐਪ ਕੋਲ ਹਾਲੇ ਵਾਲੀਅਮ ਬਟਨ ਵਰਤਣ ਦੇ ਅਧਿਕਾਰ ਨਹੀਂ ਹਨ — ਪੰਨੇ ਦੇ ਹੇਠਾਂ ਦਿੱਤੀ ਹਦਾਇਤ ਅਨੁਸਾਰ ਪਹੁੰਚ ਦਿਓ।"
    override val volGrantShort = "Accessibility ਪਹੁੰਚ ਹਾਲੇ ਨਹੀਂ ਹੈ। ਇਸ ਪੰਨੇ ਦੇ ਹੇਠਾਂ ਵਿਸਥਾਰਤ ਹਦਾਇਤ ਪੜ੍ਹੋ ਅਤੇ \"ਜਾਂਚੋ\" ਦਬਾਓ।"
    override val volCheck = "ਜਾਂਚੋ"
    override val volCheckOk = "✓ ਹੋ ਗਿਆ — ਪਹੁੰਚ ਮਿਲ ਗਈ, ਟ੍ਰਿਗਰ ਕੰਮ ਕਰਦਾ ਹੈ।"
    override val volCheckFail = "✗ ਪਹੁੰਚ ਹਾਲੇ ਨਹੀਂ — ਉੱਪਰਲੇ ਕਦਮ ਪੂਰੇ ਕਰੋ।"
    override val volPatternsList = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = ਵਾਲੀਅਮ ਉੱਪਰ, ↓ = ਹੇਠਾਂ)"
    override val histLegend = "ਕਾਲਮ — ਕੌਣ: ✓/✗ TG = ਅਸਲ Telegram ਕਨੈਕਟ, ਸਕੈਨ = ਬੈਕਗ੍ਰਾਊਂਡ ਜਾਂਚ। ਕਦੋਂ: ਕਿੰਨਾ ਚਿਰ ਪਹਿਲਾਂ। TCP/TLS/ਬੇਨਤੀ: ਹੈਂਡਸ਼ੇਕ ਅਤੇ ਪਹਿਲੀ ਬੇਨਤੀ ਦੀ ਦੇਰੀ, ਮਿਸ। ਸੈਸ਼ਨ: ਰੀਲੇ ਸੈਸ਼ਨ ਕਿੰਨਾ ਚੱਲਿਆ। ↓/↑: ਹੋਸਟ ਰਾਹੀਂ ਪ੍ਰਾਪਤ / ਭੇਜੇ ਬਾਈਟ।"
    override val tgOkTotalHint = "Telegram ਕਨੈਕਸ਼ਨ / ਸਫਲ / ਕੁੱਲ ਜਾਂਚਾਂ"
    override val breadthTitle = "ਹੋਸਟ ਚੋਣ ਦੀ ਚੌੜਾਈ"
    override val breadthHelp = "ਖੱਬੇ — ਸਭ ਤੋਂ ਵਧੀਆ ਪ੍ਰਮਾਣਿਤ ਹੋਸਟਾਂ ਨਾਲ ਚਿੰਬੜੇ ਰਹੋ; ਸੱਜੇ — ਵੱਖ-ਵੱਖ ਚਾਲੂ ਹੋਸਟ ਜਿੰਨੇ ਵੀ ਵੱਧ ਅਜ਼ਮਾਓ। ਜਦੋਂ Telegram ਰੀਲੇ ਪੋਰਟਾਂ 'ਤੇ ਭਟਕਦਾ ਹੈ, ਪ੍ਰੋਗਰਾਮ ਆਪਣੇ-ਆਪ ਚੋਣ ਵਧਾ ਦਿੰਦਾ ਹੈ।"
    override val breadthNarrow = "ਪ੍ਰਮਾਣਿਤ"
    override val breadthWide = "ਚੌੜਾ"
    override val connTimeoutTitle = "ਹੋਸਟ ਕਨੈਕਟ ਟਾਈਮਆਊਟ"
    override val connTimeoutHelp = "ਅਗਲੀ ਪ੍ਰੌਕਸੀ ਅਜ਼ਮਾਉਣ ਤੋਂ ਪਹਿਲਾਂ ਇੱਕ ਅੱਪਸਟ੍ਰੀਮ (TCP + TLS + ਪਹਿਲਾ MTProto ਜਵਾਬ) ਲਈ ਕਿੰਨਾ ਉਡੀਕਣਾ ਹੈ।"
    override val factoryResetDone = "ਸਭ ਕੁਝ ਰੀਸੈੱਟ ਹੋ ਗਿਆ। ਐਪ ਬੰਦ ਕਰਕੇ ਮੁੜ ਚਾਲੂ ਕਰੋ।"

    // tray
    override val trayOpenWindow = "ਵਿੰਡੋ ਖੋਲ੍ਹੋ"
    override val trayRefreshSubs = "ਸਬਸਕ੍ਰਿਪਸ਼ਨਾਂ ਤਾਜ਼ਾ ਕਰੋ"
    override val trayExit = "ਬਾਹਰ ਜਾਓ"
    override fun trayConnectorLabel(on: Boolean) =
        if (on) "ਕਨੈਕਟਰ: ਚਾਲੂ (ਬੰਦ ਕਰੋ)" else "ਕਨੈਕਟਰ: ਬੰਦ (ਚਾਲੂ ਕਰੋ)"
    override fun trayScanLabel(on: Boolean) =
        if (on) "ਸਕੈਨ: ਚਾਲੂ (ਬੰਦ ਕਰੋ)" else "ਸਕੈਨ: ਬੰਦ (ਚਾਲੂ ਕਰੋ)"
    override fun trayLive(n: Int) = "ਚਾਲੂ ਪ੍ਰੌਕਸੀਆਂ: ${n}"
    override val appearance = "ਦਿੱਖ"
    override val themeLabel = "ਥੀਮ"
    override val themeAuto = "ਆਟੋ (ਸਿਸਟਮ ਨਾਲ ਮੇਲ)"
    override val themeLight = "ਹਲਕਾ"
    override val themeDark = "ਗੂੜ੍ਹਾ"
    override val drawGraphsLabel = "ਗ੍ਰਾਫ਼ ਬਣਾਓ"
    override val drawGraphsSub = "ਕਨੈਕਟਰ ਅਤੇ ਸਕੈਨ ਟੈਬਾਂ 'ਤੇ ਲਾਈਵ ਚਾਰਟ — ਬੈਟਰੀ ਬਚਾਉਣ ਲਈ ਬੰਦ ਕਰੋ"
}
