package io.autoconnector.i18n

object En : Strings {
    override val tabConnector = "Connector"; override val tabScan = "Scan"
    override val tabCatalog = "Catalog"; override val tabLogs = "Logs"; override val tabMore = "More"
    override val back = "Back"; override val copy = "Copy"; override val gotIt = "Got it"
    override val later = "Later"; override val details = "Details"; override val whatIsThis = "What's this?"
    override val delete = "Delete"

    override val connector = "Connector"; override val scan = "Scan"
    override val notConfigured = "Not set up! Fix →"; override val howToSetup = "How to set up"
    override val notifOff = "Notifications are off! Fix →"; override val enable = "Enable"
    override fun fewProxies(n: Int) = "Few live proxies: $n! Searching… wait ~15 min"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "Live proxies: $alive  (15 min: $within) · total: $total"
    override val notifWhyTitle = "Why notifications?"
    override val notifWhyBody = "A persistent notification icon means an Android foreground service. " +
        "Without it the system unloads the app from memory and it stops searching for proxies and " +
        "holding the connection in the background. That's why notifications are required for " +
        "AutoConnector to work."
    override val notifEnableTitle = "Enable notifications"
    override val notifEnableBody = "Without a notification icon, Android treats the app as inactive and " +
        "unloads it from memory. Then AutoConnector stops searching for proxies and holding the " +
        "connection in the background — Telegram loses its link.\n\nTap \"Enable\" and allow " +
        "notifications for AutoConnector."
    override val notifPlea = "Enable notifications! Without them the app can't run in the background — " +
        "Android will unload it and proxy search and the connection will stop."

    override val statusConnected = "Telegram connected"; override val statusConnecting = "Connecting…"
    override val statusOffline = "Telegram not connected"; override val statusIdle = "Telegram idle"
    override val nobodyConnected = "Nobody connected to the Connector. "; override val howToSetupArrow = "How to set up →"
    override val directModeTitle = "Direct mode (no proxy)"
    override val directModeViaVpn = "VPN is active — Telegram goes straight to Telegram's servers, " +
        "bypassing proxies. The VPN already provides access, so the extra proxy layer is off."
    override val directModeOff = "Proxies are off — Telegram connects directly to Telegram's servers, " +
        "without an MTProto proxy."
    override val directDpiOn = "Anti-DPI: the first packet is split into segments."
    override val directDpiOff = "Anti-DPI is not applied to the direct connection."
    override val connections = "Connections"; override val sockets = "Sockets"; override val speed = "Speed"
    override val traffic = "Traffic"; override val latency = "Latency"
    override fun pcs(n: Int) = "$n pcs"
    override fun tgToConnector(n: Int) = "TG→ $n"
    override fun connectorToProxy(n: Int) = "proxy $n"
    override val trafficSec = "traffic · 60 sec"; override val trafficMin = "traffic · 60 min"
    override val latencySec = "latency · 60 sec"; override val latencyMin = "latency · 60 min"
    override val sec60 = "60 sec"; override val min60 = "60 min"
    override val unitSec = "s"; override val unitMin = "m"; override val unitHour = "h"; override val dash = "—"
    override val currentProxy = "Current proxy"; override val noActiveProxy = "no active proxy (Telegram not connected)"
    override val host = "Host"; override val type = "Type"; override val secret = "Secret"; override val antiDpi = "Anti-DPI"
    override fun activeSockets(n: Int) = "Active Telegram sockets: $n"
    override val noConnections = "no active connections"; override val colHost = "Host"; override val colTime = "Time"

    override val scanOff = "Scanning is off"; override val proxiesInBase = "Proxies in database"
    override val total = "total"; override val alive = "live"; override val dead = "dead"
    override val tgConnectedTitle = "Telegram connected via"; override val successful = "successful"
    override val socketsHeld = "Socket lifetime"; override val over1m = ">1 min"; override val over5m = ">5 min"; override val over15m = ">15 min"
    override val scanCountTitle = "Proxy checks count"; override val checked = "Checked"
    override val forAllTime = "all time"; override val perMinute = "per minute"; override val perHour = "per hour"
    override val subsCountTitle = "Subscription downloads count"; override val downloaded = "downloaded"; override val failed = "failed"; override val scanTraffic = "scan traffic"
    override val checksMtproto = "MTProto checks (↑ ok · ↓ fail)"

    override val catalogEmpty = "Catalog is empty — initial proxy collection in progress…"
    override val aliveShort = "✓ live"; override val deadShort = "✗ dead"
    override val statusLabel = "Status"; override val rating = "Rating"; override val port = "Port"
    override val rttPing = "RTT (ping)"; override val checkedField = "Checked"; override val okOfTotal = "Successful / total checks"
    override val tgConnectedField = "Telegram connected"; override val tgSessions = "Telegram sessions"; override val trafficThroughProxy = "Traffic through proxy"
    override val sessionsTotal = "Sessions total"; override val relayNow = "Relay now"; override val tlsDomain = "TLS domain (SNI)"
    override val sourceSub = "Source (subscription)"; override val lastError = "Last error"; override val yes = "yes"; override val no = "no"
    override val copyAsLink = "Copy as link"; override val openInTelegram = "Open host in Telegram"; override val makeNextRelay = "Make next relay"
    override fun agoFmt(v: String) = "$v ago"
    override val live = "live"; override val deadW = "dead"; override val unitMs = "ms"
    override val agoMin = "m"; override val agoHour = "h"; override val agoDay = "d"

    override val connectTelegram = "Connecting Telegram"; override val readCarefully = "Read carefully!"
    override val guideIntro = "This app won't work without setup. Pick any one of the 3 options below " +
        "and follow the instructions carefully."
    override val variant1 = "Option #1 — buttons"
    override val variant1Body = "Tap \"Proxy {A}\" — Telegram opens, confirm adding the proxy. Come " +
        "back to this screen and tap \"Proxy {B}\" — confirm adding a second time.\n\nDisable any " +
        "other old proxies in Telegram. Exactly 2 proxies must remain — with ports {A} and {B}. " +
        "With any other set AutoConnector won't work."
    override val variant2 = "Option #2 — links"
    override val variant2Body = "Copy the text below into Saved Messages (or any chat) in Telegram — " +
        "i.e. send it to yourself. Tap the first link in your message — the first proxy is added. " +
        "Tap the second link — the second is added. Then disable all old proxies."
    override val variant3 = "Option #3 — manually"
    override val variant3Body = "Manually add a SOCKS5 proxy: server localhost (127.0.0.1), port {A}. " +
        "Then a second proxy: localhost, port {B}. Delete any old proxies."
    override val whatNext = "What's next?"
    override val whatNextBody = "Make sure all other old proxies are removed, except {A} and {B}. Tap " +
        "\"Use proxy\" in Telegram.\n\nWait while the app finds and downloads enough proxies " +
        "(5–15 minutes). Then Telegram connects to AutoConnector by itself, which will keep routing " +
        "Telegram through the best proxies: verified, live and fast.\n\nIf the instructions seem " +
        "hard — sorry, you won't be able to use the app: it's impossible to set everything up " +
        "automatically, and finding live proxies takes time.\n\nIf you downloaded the app long ago " +
        "and no live proxies were found — update either the app or the subscription list. This app " +
        "doesn't invent or provide its own proxies, it only searches the internet across dozens of " +
        "groups and pages."
    override fun proxyBtn(port: Int) = "Proxy $port"

    override val setupPortsTitle = "Set up ports in Telegram"
    override val setupPortsSub = "How to connect Telegram to the Connector (ports 55001/55002)"
    override val settings = "Settings"; override val settingsSub = "Ports, anti-DPI, scan, network, battery"
    override val subscriptions = "Subscriptions"; override val subscriptionsSub = "Proxy sources to scan"
    override val statistics = "Statistics"; override val statisticsSub = "Proxy database + anti-DPI tricks"
    override val export = "Export"; override val exportSub = "tg:// links of live proxies"
    override val about = "About"; override val aboutSub = "Version, build, download, feedback"

    override val relayPorts = "Relay ports"
    override val relayPortsHelp = "Local ports the Connector listens on. You enter exactly these in " +
        "Telegram as a SOCKS5 proxy (127.0.0.1 : port). Two ports are used for reliability — Telegram " +
        "keeps connections to both."
    override val portA = "Port A"; override val portB = "Port B"
    override val antiDpiTrick = "Anti-DPI trick"
    override val antiDpiHelp = "A way to disguise the connection so the ISP/DPI doesn't recognise and " +
        "block it.\n• \"Auto-rotate\" picks a working trick itself.\n• \"No DPI tricks\" — a plain " +
        "connection.\n• The rest are specific techniques (browser mimicry, packet splitting, etc.)."
    override val onlyFakeTls = "FakeTLS only (ee)"
    override val applyDpiTo = "Apply anti-DPI to"
    override val applyDpiHelp = "What to apply the chosen anti-DPI trick to:\n• Telegram relay — to the " +
        "live Telegram connection through the Connector.\n• Proxy probes — to background proxy checks " +
        "(then a check behaves just like a real connection, and trick stats are more accurate).\n" +
        "• When connecting directly — when proxies are off (or skipped while a VPN is on) and Telegram " +
        "goes straight to its servers: there is no proxy here, so the trick reduces to splitting the " +
        "first TCP packet (the handshake) into several small segments so DPI can't match it in one read."
    override val toRelay = "Telegram relay"; override val toProbes = "Proxy probes"
    override val toDirect = "When connecting directly"
    override val vpnSection = "When VPN is on"
    override val vpnHelp = "What to do when a VPN is active on the device:\n• Via MTProto proxy — " +
        "Telegram goes through the found proxies as usual (on top of the VPN).\n• Directly — the " +
        "Connector does NOT use proxies and connects Telegram straight to Telegram's servers: the " +
        "VPN already provides access, the extra proxy layer isn't needed (faster and more stable). " +
        "Without a VPN proxies are used as usual."
    override val viaMtproto = "Proxy via MTProto"; override val viaMtprotoSub = "even with VPN, traffic goes through proxies"
    override val directly = "Connect directly"; override val directlySub = "with VPN active — bypass proxies, straight to Telegram"
    override val notifications = "Notifications"
    override val scanCheck = "Scan & check"
    override val scanCheckHelp = "• Scan, min — how often to download proxy lists from subscriptions.\n" +
        "• Check, min — how often to re-check proxies in the database for liveness.\n• Batch size — " +
        "how many proxies to check per run.\n• Parallel — how many checks to run at once (more = " +
        "faster, but higher network and battery load)."
    override val scanMin = "Scan, min"; override val checkMin = "Check, min"; override val batchSize = "Batch size"; override val parallel = "Parallel"
    override val speedByNet = "Speed by network"
    override val speedByNetHelp = "Check-speed multipliers depending on the current network. 1.0 = base " +
        "speed. Lower — gentler on traffic/battery, higher — more aggressive.\n• VPN — when an external " +
        "VPN is active.\n• Wi-Fi — on a Wi-Fi network.\n• LTE — on a mobile network."
    override val adaptiveSpeed = "Adaptive speed"
    override val adaptiveHelp = "Auto-tunes intensity by the number of live proxies:\n• \"Many\" threshold " +
        "— if there are more live than this, checks slow down by the \"fast\" multiplier (the base is " +
        "already good, save resources).\n• \"Few\" threshold — if fewer, checks speed up by the \"lazy\" " +
        "multiplier to gather live ones faster."
    override val threshMany = "\"Many\" threshold"; override val threshFew = "\"Few\" threshold"; override val mulFast = "fast mult."; override val mulLazy = "lazy mult."
    override val netBattery = "Network & battery"
    override val netBatteryHelp = "• Wi-Fi only — don't scan on mobile networks (saves data).\n• Charging " +
        "only — work only while the phone is charging.\n• Skip on low battery — pause scanning when the " +
        "battery is low."
    override val onlyWifi = "Wi-Fi only"; override val onlyCharging = "Charging only"; override val skipLowBattery = "Skip on low battery"
    override val autosaved = "Settings are saved automatically."
    override val dpiAutoLabel = "Auto-rotate DPI tricks"; override val dpiNoneLabel = "No DPI tricks (plain)"

    override val sourceUrl = "Source URL"
    override fun sourceAlive(alive: Int, total: Int) = "live $alive/$total"

    override val proxyBase = "Proxy database"
    override val totalInBase = "Total in database"; override val aliveNow = "Live now"; override val deadStat = "Dead"
    override val aliveIn15 = "Live in 15 min"; override val checksAllTime = "Checks all time"
    override val antiDpiTricks = "Anti-DPI tricks"; override val noStatsYet = "no data yet — tricks accumulate as checks/connections happen"
    override val attempts = "Attempts"; override val handshake = "Handshake"; override val score = "Score"
    override val tgConnect = "TG connect"; override val socketsOver1m = "Sockets >1min"
    override val over10kb = "Sockets >10KB"; override val over100kb = ">100KB"; override val workTime = "Work time"
    override val statsLegend = "Handshake — successful handshakes (% of attempts) · Score — value · " +
        "\"Work time\" — total over sockets ≥5KB and longer than 1 minute."
    override val resetStats = "Reset trick statistics"

    override fun aliveLinks(n: Int) = "Live links: $n"
    override val copyAll = "Copy all"

    override val appTagline = "Cross-platform auto-connector: it finds, checks and runs MTProto proxies " +
        "that Telegram works through."
    override val version = "Version"; override val buildDate = "Build date"
    override val downloadSources = "Download & sources"; override val openOnGithub = "Open on GitHub"
    override val feedbackBugs = "Feedback & bug reports"; override val writeTelegram = "Write on Telegram"

    override val language = "Language"; override val langAuto = "Auto (system)"; override val langRu = "Русский"; override val langEn = "English"
}
