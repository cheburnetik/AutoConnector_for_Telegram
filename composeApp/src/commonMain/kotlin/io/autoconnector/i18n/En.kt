package io.autoconnector.i18n

object En : Strings {
    override val tabConnector = "Connector"; override val tabScan = "Scan"
    override val tabCatalog = "Catalog"; override val tabLogs = "Logs"; override val tabMore = "More"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "Subscriptions"; override val logTabScan = "Scan"
    override val logGeneral = "General"; override val logEmpty = "empty for now"
    override val logSessions = "Sessions"; override val logErrorsOnly = "errors only"; override val logNoErrors = "no failed sessions"
    override fun logSession(id: String, port: String) = "#$id · :$port"
    override val back = "Back"; override val copy = "Copy"; override val gotIt = "Got it"
    override val later = "Later"; override val details = "Details"; override val whatIsThis = "What's this?"
    override val delete = "Delete"

    override val connector = "Connector"; override val scan = "Scan"
    override val notConfigured = "Not set up! Fix →"; override val howToSetup = "How to set up"
    override val notifOff = "Notifications are off! Fix →"; override val enable = "Enable"
    override fun fewProxies(n: Int) = "Live proxies $n, searching, wait ~15 min…"
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
    override val directModeViaVpn = "Direct mode: VPN active — no proxy"
    override val directModeOff = "Direct mode: proxies off"
    override val directDpiSuffix = " · anti-DPI"
    override val connections = "Connections"; override val sockets = "Sockets"; override val speed = "Speed"
    override val traffic = "Traffic"; override val latency = "Latency"
    override fun pcs(n: Int) = "$n pcs"
    override fun netNow(label: String) = "Network: $label"
    override fun tgToConnector(n: Int) = "TG→ $n"
    override fun connectorToProxy(n: Int) = "proxy $n"
    override val trafficSec = "traffic · 60 sec"; override val trafficMin = "traffic · 60 min"
    override val latencySec = "latency · 60 sec"; override val latencyMin = "latency · 60 min"
    override val sec60 = "60 sec"; override val min60 = "60 min"
    override val unitSec = "s"; override val unitMin = "m"; override val unitHour = "h"; override val dash = "—"
    override val currentProxy = "Current proxy"; override val noActiveProxy = "no active proxy (Telegram not connected)"
    override val host = "Host"; override val type = "Type"; override val secret = "Secret"; override val antiDpi = "Anti-DPI"; override val obfEngine = "Obfuscation engine"
    override fun activeSockets(n: Int) = "Active Telegram sockets: $n"
    override val noConnections = "no active connections"; override val colHost = "Host"; override val colTime = "Time"
    override val modeWord = "Mode"; override val directViaVpnLine = "Direct requests to Telegram (VPN active)"
    override val connModeHelp = "Modes (VPN, Wi-Fi, LTE, Ethernet, White) let you tune scan intensity differently and keep separate host ratings/stats. The network card is detected automatically; the mode can be set manually in settings."

    override val scanOff = "Scanning is off"; override val proxiesInBase = "Proxies in database"
    override val total = "total"; override val alive = "live"; override val dead = "dead"
    override val tgConnectedTitle = "Telegram connected via"; override val successful = "successful"
    override val socketsHeld = "Socket lifetime"; override val over1m = ">1 min"; override val over5m = ">5 min"; override val over15m = ">15 min"
    override val scanCountTitle = "Proxy checks count"; override val checked = "Checked"
    override val forAllTime = "all time"; override val perMinute = "per minute"; override val perHour = "per hour"
    override val subsCountTitle = "Subscription downloads count"; override val downloaded = "downloaded"; override val failed = "failed"; override val scanTraffic = "scan traffic"; override val subTraffic = "subscription traffic"; override val subTrafficGraph = "Subscription traffic"
    override val checksMtproto = "MTProto checks (↑ ok · ↓ fail)"

    override fun catalogEmpty(mode: String) = "Catalog $mode is empty for now. Either no host was found, or the app has never run in this mode. You can switch the mode in Settings. Modes exist to collect hosts separately for different kinds of internet connection."
    override val aliveShort = "✓ live"; override val deadShort = "✗ dead"
    override val statusLabel = "Status"; override val rating = "Rating"; override val port = "Port"
    override val rttPing = "RTT (ping)"; override val checkedField = "Checked"; override val okOfTotal = "Successful / total checks"
    override val tgConnectedField = "Telegram connected"; override val tgSessions = "Telegram sessions"; override val trafficThroughProxy = "Traffic through proxy"
    override val sessionsTotal = "Sessions total"; override val relayNow = "Relay now"; override val tlsDomain = "TLS domain (SNI)"
    override val sourceSub = "Source (subscription)"; override val lastError = "Last error"; override val yes = "yes"; override val no = "no"
    override val copyAsLink = "Copy as link"; override val openInTelegram = "Open host in Telegram"; override val makeNextRelay = "Make next relay"
    override val actCopy = "Copy"; override val actOpen = "Open"; override val actRelay = "Relay"
    override fun agoFmt(v: String) = "$v ago"
    override val catalogTopFor = "Proxy list/rating for"
    override val catalogModeHelpTitle = "Modes & ratings"
    override val catalogModeHelp = "The app counts live hosts and their ratings SEPARATELY per network mode (VPN, Wi-Fi, LTE, Ethernet and White). \"White\" is a separate MANUAL mode for whitelists; auto never switches to it. So the same host can be live in one mode and dead in another."
    override fun catalogInactiveWarn(section: String, active: String) =
        "You're viewing the inactive section $section — all stats right now go to $active, not here."
    override val manageModeTitle = "Manage mode"
    override val manageResetRating = "Reset rating"
    override fun manageResetHint(mode: String) = "For $mode specifically you can reset the rating and usage statistics of live hosts. This is handy when you've connected to a fundamentally different VPN or LTE, so old statistics don't interfere. Or to watch how fast the proxy scan re-checks everything from scratch."
    override val manageDeleteAll = "Delete hosts in"
    override fun manageDeleteHint(mode: String) = "You can clear both the rating and the hosts themselves from $mode. The \"Scan proxies\" feature will gather them again. This is not a subscription reset — you can tap it, then wait ~15 minutes for a rescan."
    override fun manageCopyFrom(mode: String) = "Copy all hosts and ratings into this mode ($mode) from another mode:"
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
    override val whatNextBody = "In Telegram, enable \"auto-switch proxy\" — 5 seconds. You can help " +
        "Telegram connect by manually tapping a proxy (inside Telegram) that is NOT active or marked " +
        "\"unavailable\" — that makes Telegram try harder to connect.\n\nMake sure all other old " +
        "proxies are removed, except {A} and {B}. Tap " +
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
    override val hotkeys = "Hotkeys"
    override val hotkeysSub = "Global keys: copy / open a proxy"
    override val hotkeysIntro = "Global hotkeys fire even when the app window isn't focused. They pick a " +
        "random alive proxy link (tg://) from the pool — handy for quickly switching proxies without " +
        "opening the app."
    override val hotkeysNote = "On macOS, capturing keys may require the Accessibility permission " +
        "(System Settings → Privacy & Security → Accessibility)."
    override val hotkeyCopyTitle = "Copy proxy link"
    override val hotkeyCopyDesc = "Puts a random alive tg:// link on the clipboard."
    override val hotkeyEnable = "Enable hotkeys"; override val hotkeyLetterLabel = "Letter"; override val hotkeySet = "Set"; override val hotkeyReset = "Reset"
    override val hotkeyOpenTitle = "Open proxy in Telegram"
    override val hotkeyOpenDesc = "Opens a random alive link — Telegram grabs it and offers to connect the proxy."

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
    override val linkFormat = "Proxy link format"
    override val linkFormatHelp = "How to copy and open proxies. tg:// opens Telegram directly (needs Telegram Desktop installed). http (t.me) opens via browser and offers to open in Telegram — handy if tg:// is not registered."
    override val linkTg = "tg:// (open Telegram directly)"; override val linkTgSub = "tg://proxy?… — opens Telegram"
    override val linkHttp = "http (t.me, via browser)"; override val linkHttpSub = "https://t.me/proxy?… — opens browser"
    override val viaMtproto = "Proxy via MTProto"; override val viaMtprotoSub = "even with VPN, traffic goes through proxies"
    override val directly = "Connect directly"; override val directlySub = "with VPN active — bypass proxies, straight to Telegram"
    override val notifications = "Notifications"
    override val scanCheck = "Scan & check"
    override val scanCheckHelp = "• Scan, min — how often to download proxy lists from subscriptions.\n" +
        "• Check, min — how often to re-check proxies in the database for liveness.\n• Batch size — " +
        "how many proxies to check per run.\n• Parallel — how many checks to run at once (more = " +
        "faster, but higher network and battery load)."
    override val scanMin = "Scan, min"; override val checkMin = "Check, min"; override val batchSize = "Batch size"; override val parallel = "Parallel"
    override val speedByNet = "Scan intensity by network"
    override val speedByNetHelp = "How often to check proxies depending on the current network. " +
        "\"Standard\" = base interval. Slide right for rarer (slower, gentler on traffic/battery), " +
        "left for more often (faster, more aggressive). Logarithmic scale, up to ×100 each way.\n" +
        "• VPN — when an external VPN is active.\n• Wi-Fi — on a Wi-Fi network.\n• LTE — on a mobile network."
    override val intensStandard = "standard"
    override val intensSlower = "slower"
    override val intensFaster = "faster"
    override val maintenance = "Reset data"
    override val maintenanceHelp = "• \"Reset catalog & statistics\" — zeroes ratings, counters, traffic " +
        "and check logs, but keeps the downloaded hosts and subscriptions (everything is re-rated on " +
        "the next scan).\n• \"Clear downloaded hosts\" — deletes the whole proxy pool but keeps " +
        "subscriptions so the scan refills the pool. Subscriptions are never touched either way."
    override val backupTitle = "Export / Import"
    override val backupHelp = "Save or restore app data as JSON. Tick what to " +
        "include — any combination:\n• Settings — all app parameters.\n• Subscriptions — the source " +
        "list (URL + on/off).\n• Live-host catalog — every live proxy with its ratings and stats " +
        "PER network mode.\n\n\"Export\" opens a page with the ready JSON — copy it or save to a file. " +
        "\"Import\" — paste JSON (or load a file) and it applies only the ticked sections present in " +
        "it. Import ADDS to current data (no wipe)."
    override val backupSettings = "Settings"
    override val backupSubs = "Subscriptions"
    override val backupHosts = "Live-host catalog (per mode)"
    override val exportWord = "Export"
    override val importWord = "Import"
    override val backupExportTitle = "Export data"
    override val backupImportTitle = "Import data"
    override val backupSelectExport = "What to export:"
    override val backupSelectImport = "What to import:"
    override val backupCopyBtn = "Copy"
    override val backupSaveFile = "Save to file"
    override val backupLoadFile = "Load from file"
    override val backupDoImport = "Import"
    override val backupPasteLabel = "Paste backup JSON here"
    override val backupJsonLabel = "Backup JSON"
    override val backupAndroidFileNote = "Files aren't available here — use Copy / Paste."
    override val eraseAllHosts = "Erase all hosts"
    override val factoryReset = "Reset everything (like first launch)"
    override val factoryResetConfirm = "Fully reset the app to factory state? ALL settings and the entire " +
        "host catalog will be wiped, subscriptions restored to defaults. Just like a first launch."
    override val resetCatalog = "Reset catalog & statistics"
    override val resetCatalogConfirm = "Zero all ratings, counters and check logs? " +
        "Downloaded hosts and subscriptions are kept and re-rated on the next scan."
    override val clearHosts = "Clear downloaded hosts"
    override val clearHostsConfirm = "Delete the entire list of downloaded hosts (proxies)? " +
        "Subscriptions are kept and the scan will refill the pool."
    override val doReset = "Reset"
    override val doCancel = "Cancel"
    override val adaptiveSpeed = "Adaptive speed"
    override val adaptiveHelp = "Liveness checks run at a base interval (from \"Scan & check\", also " +
        "multiplied by the network multiplier). \"Adaptive speed\" speeds them up or slows them down " +
        "automatically based on how many proxies are currently live.\n\n" +
        "• FEW live (below the \"Few\" threshold) → interval × \"Speed-up\". A multiplier below 1 = more " +
        "often: 0.5 — twice as often, 0.25 — 4×. Refills the pool faster.\n" +
        "• MANY live (above the \"Many\" threshold) → interval × \"Slow-down\". Above 1 = rarer: 2 — " +
        "half as often, 4 — a quarter. Saves battery and traffic.\n" +
        "• Between the thresholds — base speed (×1).\n\n" +
        "Examples:\n" +
        "— Gather proxies faster: \"Speed-up\" 0.25 and/or \"Few\" threshold 40.\n" +
        "— Save battery when you have enough: \"Slow-down\" 8 and/or \"Many\" threshold 30.\n" +
        "— Disable adaptation: set both multipliers to 1.\n\n" +
        "Defaults: Few 20, Speed-up 0.5, Many 50, Slow-down 4."
    override val threshMany = "\"Many\" threshold"; override val threshFew = "\"Few\" threshold"; override val mulFast = "Speed-up ×"; override val mulLazy = "Slow-down ×"
    override val subIntensityTitle = "Subscription intensity"
    override val subIntensityHint = "Pause between subscription downloads: how many minutes before re-downloading the proxy lists (separately per network mode)."
    override val baseScanTitle = "Base scan speed"
    override val baseScanHelp = "The reference liveness-check speed. \"Adaptive speed\" and the \"Speed by " +
        "mode\" multipliers are computed relative to it.\n\n" +
        "• How often to run, min — interval between check passes.\n" +
        "• Batch per thread, hosts — how many hosts each thread checks per pass.\n" +
        "• Threads — how many checks run at once. A pass probes \"batch × threads\" hosts.\n" +
        "• Don't rescan a host more often than every N min — anti-flood: a recently checked host is " +
        "skipped this pass.\n\n" +
        "More threads and a bigger batch = faster pool growth, but heavier load on network and battery."
    override val baseScanPeriod = "How often to run, min"
    override val baseScanBatch = "Batch per thread, hosts"; override val baseScanThreads = "Thread count"
    override val adaptiveDesc = "If alive proxies are fewer than \"few\" or more than \"many\", apply an extra multiplier."
    override val fewWord = "Few"; override val manyWord = "Many"
    override fun fasterX(x: String) = "$x× faster"
    override fun slowerX(x: String) = "$x× slower"
    override fun ifAliveLt(n: Int) = "If alive proxies < $n, then:"
    override fun ifAliveGt(n: Int) = "If alive proxies > $n, then:"
    override val disabledWord = "off"
    override val speedByModeTitle = "Speed by mode"
    override val speedByModeHelp = "A scan-speed multiplier for each network mode, on top of the base " +
        "speed. \"Standard\" (×1) = the base interval. Right — rarer (slower, gentler on traffic/" +
        "battery), left — more often (faster, more aggressive). Logarithmic scale, up to ×100 each " +
        "way.\n\n" +
        "Under each slider are the resulting pass parameters with the adaptive speed applied — " +
        "shown separately for \"few alive\" (× \"Speed-up\") and \"many alive\" (× \"Slow-down\").\n\n" +
        "Modes:\n• VPN — an external VPN is active.\n• LTE — mobile network.\n• Wi-Fi — Wi-Fi network.\n" +
        "• Ethernet — wired connection.\n• White — manual \"white\" proxy mode."
    override val aliveLt = "alive <"; override val aliveGt = "alive >"
    override val periodWord = "period"; override val nonstopWord = "nonstop"
    override val batchWord = "batch"; override val threadsWord = "threads"; override val scanModeOff = "scan off"
    override val netBattery = "Network & battery"
    override val netBatteryHelp = "• Wi-Fi only — don't scan on mobile networks (saves data).\n• Charging " +
        "only — work only while the phone is charging.\n• Skip on low battery — pause scanning when the " +
        "battery is low."
    override val onlyWifi = "Wi-Fi only"; override val onlyCharging = "Charging only"; override val skipLowBattery = "Skip on low battery"
    override val autosaved = "Settings are saved automatically."
    override val dpiAutoLabel = "Auto-rotate DPI tricks"; override val dpiNoneLabel = "No DPI tricks (plain)"
    override val experimental = "Experimental"
    override val experimentalHelp = "Alternative proxying engines to the MTProto upstream plus a diagnostic log. " +
        "The reference (working) path is unchanged when set to \"Off\". Only HOW the encrypted stream is written to " +
        "the upstream TCP socket changes (segment sizes, timing, TLS-record boundaries) — the stream itself stays byte-for-byte identical. " +
        "Applies to the live proxy relay only (not probes, not the direct path)."
    override val expEngineTitle = "Proxying engine (socket obfuscation)"
    override val expConnectTitle = "Connect engine (upstream selection)"
    override val expEngineWarn = "⚠ Experimental mode. If connectivity gets worse, switch back to \"Off (reference path)\"."
    override val netLog = "Enable network-exchange log"
    override val netLogSub = "Writes WHO-TO-WHOM-WHEN and packet sizes to a file (NO payload data) — " +
        "to compare the exchange pattern with vs. without a VPN."
    override val openLogFolder = "Open log folder"; override val copyPath = "Copy path"
    override val helpShow = "Help"; override val helpHide = "Hide help"
    override val quickSwitchIntro = "Here you can pick a block-bypass trick. If Telegram shows the error " +
        "“The proxy you are using is not configured correctly and will be disabled. Please find another " +
        "one”, experiment with which traffic-obfuscation type works so Telegram stops showing it. Start " +
        "with the split* modes. The coalesce* modes also work, but images/videos load poorly in Telegram with them."
    override val quickSwitchTitle ="Block bypass"; override val quickSwitchSub = "Shaping, connect, anti-DPI"

    override val sourceUrl = "Source URL"
    override fun sourceAlive(alive: Int, total: Int) = "live $alive/$total"
    override val open = "Open"; override val active = "Active"; override val inactive = "Inactive"
    override val lastDownloaded = "Downloaded"; override val notDownloaded = "not downloaded yet"
    override fun sourceCounts(dead: Int, total: Int) =
        " live, $dead dead, $total total"

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
    override val openRandom = "Open random"; override val copyRandom = "Copy random"; override val allShort = "ALL"
    override val copyTop = "Copy TOP"; override val randomHost = "Random host"
    override val exportToFile = "Export to file"; override val exportSaved = "Saved to file:"
    override val dlNow = "Download now"
    override fun downloadingFmt(sec: Long) = "Downloading… ${sec}s"
    override val cancel = "Cancel"
    override val deleteConfirmTitle = "Delete subscription?"
    override val subscriptionsAddHint = "Add subscriptions or proxy links →"
    override val addSourcesTitle = "Add"
    override val addSubsLabel = "Subscriptions (one URL per line)"
    override val addSubsHelp = "Each line with a valid URL becomes its own subscription and is fetched periodically."
    override val addProxiesLabel = "Ready proxy links (fixed list)"
    override val addProxiesHelp = "Paste a batch of links to specific proxies (tg://proxy, https://t.me/proxy, …). This is NOT a subscription — the list is never downloaded, the proxies are just added to the catalog."
    override val addButton = "Add"
    override fun addedFmt(subs: Int, proxies: Int) = "Added: $subs subscriptions, $proxies proxies"
    override val perSecond = "per sec"
    override val graphSpeed = "Speed"
    override val graphVolume = "Volume"
    override val graphLatency = "Ping"
    override val graphConnects = "Connects"
    override val scanNow = "Scan now"; override val scanOnShort = "Scan on"
    override val scanRunning = "Scan running"; override val scanIdle = "Scan idle"; override val scanOffState = "Scan OFF"; override val scanBatchPerThread = "Batch/thread"; override val scanPassHosts = "Hosts in pass"; override val minRescanLabel = "Don't rescan a host more often than every N min"
    override val scanPlanTitle = "Plan"; override val scanNowTitle = "Now"; override val currentScheduleTitle = "Current schedule"
    override val scheduleWord = "Schedule"; override val unitPcsPerSec = "pcs/s"
    override val scanNowThreadsLabel = "Threads running now"; override val scanNowPerThreadLabel = "Checks per thread (plan)"; override val scanNowElapsedLabel = "Running time"
    override val scanOkGraph = "Successful scans"; override val scanFailGraph = "Failed scans"; override val scanTrafficGraph = "Scan traffic"; override val scanAliveGraph = "Alive proxies total"; override val scanPingGraph = "Ping"; override val threadsGraph = "Threads"
    override val scanEvery = "Every"; override val scanNextRun = "Next run"
    override val scanThreads = "Threads"; override val scanBatch = "Batch"
    override val scanElapsed = "Running"; override val scanIdleNow = "—"
    override val effForFew = "When few"; override val effForMany = "When many"
    override val effCheck = "Check"; override val effBatch = "Batch"; override val effPar = "Parallel"
    override val effContinuous = "continuous"; override val secShort = "s"; override val minShort = "min"

    override val appTagline = "Cross-platform auto-connector: it finds, checks and runs MTProto proxies " +
        "that Telegram works through."
    override val version = "Version"; override val buildDate = "Build date"
    override val downloadSources = "Download & sources"; override val openOnGithub = "Open on GitHub"
    override val feedbackBugs = "Feedback & bug reports"; override val writeTelegram = "Write on Telegram"

    override val language = "Language"; override val langAuto = "Auto (system)"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "Language"
    override val raceWidthTitle = "Parallel connects"
    override val connectionSection = "Connection & block bypass"
    override val connectionSectionHelp = "Connect engine, parallel upstreams, proxying engine and anti-DPI tricks — all in one section."
    override val netLogSection = "Network exchange log"
    override val platform = "Platform"

    override val scanModeTitle = "Network mode"; override val scanModeAuto = "Auto"; override val scanModeManualLabel = "Manual"
    override val activeModeLabel = "Active mode"; override val formingListLabel = "Building list"; override val catalogModeTabs = "Mode"
    override val resetModeRatings = "Reset host ratings"; override val forgetModeHosts = "Forget mode hosts"
    override val exportModeTitle = "Export by mode"; override val modePickerTitle = "Mode"
    override val modeHelp = "Each network mode keeps its own proxy ratings and its own scan + subscription-download intensity. \"Auto\" picks the mode from the active network. \"Manual\" lets you choose any mode yourself (including White, which auto never selects)."
    override val autoSelect = "Auto select"; override val manualSelect = "Manual select"
    override val connStatsTitle = "Connections now"; override val connOnPort = "Connections on port"; override val outgoingConns = "Outgoing connections"
    override val modeChoice = "Mode selection"; override val autoChoice = "auto-select"; override val manualChoice = "manual fixed"
    override val directOnVpn = "Direct connect to TG on VPN"; override val onWord = "on"; override val offWord = "off"
    override val directStateActive = "active"; override val directStateOff = "off in settings"; override val directStateIdle = "on in settings, but not active"
    override val wpHintTitle = "What is White?"
    override val wpHint = "White — WhitePages: a manual network profile. Enabled only by hand (auto-select never picks it). " +
        "Keeps its own host ratings, downloads subscriptions and scans independently of VPN/Wi-Fi/LTE."
}
