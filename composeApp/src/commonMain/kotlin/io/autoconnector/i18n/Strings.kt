package io.autoconnector.i18n

import androidx.compose.runtime.staticCompositionLocalOf

/**
 * All user-facing UI text, localised. Add a member here and implement it in both
 * [Ru] and [En]. Parameterised text uses functions. Engine-produced runtime
 * strings (log lines, status sub-text with durations) are not covered here.
 */
interface Strings {
    // tabs / common
    val tabConnector: String; val tabScan: String; val tabCatalog: String
    val tabLogs: String; val tabMore: String
    // Logs sub-tabs
    val logTabTelegram: String; val logTabSubs: String; val logTabScan: String
    val logGeneral: String; val logEmpty: String
    val logSessions: String; val logErrorsOnly: String; val logNoErrors: String
    fun logSession(id: String, port: String): String
    val back: String; val copy: String; val gotIt: String; val later: String
    val details: String; val whatIsThis: String; val delete: String
    fun onOff(on: Boolean) = if (on) "ON" else "OFF"

    // header
    val connector: String; val scan: String
    val notConfigured: String; val howToSetup: String
    val notifOff: String; val enable: String
    fun fewProxies(n: Int): String
    fun alivePool(alive: Int, within: Int, total: Int): String
    val notifWhyTitle: String; val notifWhyBody: String
    val notifEnableTitle: String; val notifEnableBody: String
    val notifPlea: String

    // connector tab
    val statusConnected: String; val statusConnecting: String
    val statusOffline: String; val statusIdle: String
    val nobodyConnected: String; val howToSetupArrow: String
    // Direct ("bypass") mode — single-line note on the Connector tab.
    val directModeViaVpn: String; val directModeOff: String; val directDpiSuffix: String
    val connections: String; val sockets: String; val speed: String
    val traffic: String; val latency: String
    fun pcs(n: Int): String
    fun netNow(label: String): String
    fun tgToConnector(n: Int): String
    fun connectorToProxy(n: Int): String
    val trafficSec: String; val trafficMin: String
    val latencySec: String; val latencyMin: String
    val sec60: String; val min60: String
    val unitSec: String; val unitMin: String; val unitHour: String; val dash: String
    val currentProxy: String; val noActiveProxy: String
    val host: String; val type: String; val secret: String; val antiDpi: String; val obfEngine: String
    fun activeSockets(n: Int): String
    val noConnections: String; val colHost: String; val colTime: String
    // active-mode indicator on the connector header + its help dialog
    val modeWord: String; val connModeHelp: String; val directViaVpnLine: String

    // scan tab
    val scanOff: String; val proxiesInBase: String
    val total: String; val alive: String; val dead: String
    val tgConnectedTitle: String; val successful: String
    val socketsHeld: String; val over1m: String; val over5m: String; val over15m: String
    val scanCountTitle: String; val checked: String
    val forAllTime: String; val perMinute: String; val perHour: String
    val subsCountTitle: String; val downloaded: String; val failed: String; val scanTraffic: String; val subTraffic: String; val subTrafficGraph: String
    val checksMtproto: String
    // transposed «Сейчас» rows
    val scanNowThreadsLabel: String; val scanNowPerThreadLabel: String; val scanNowElapsedLabel: String
    // scan-tab live graphs (mirror the connector graphs)
    val scanOkGraph: String; val scanFailGraph: String; val scanTrafficGraph: String; val scanAliveGraph: String; val scanPingGraph: String; val threadsGraph: String

    // catalog
    fun catalogEmpty(mode: String): String; val aliveShort: String; val deadShort: String
    val statusLabel: String; val rating: String; val port: String
    val rttPing: String; val checkedField: String; val okOfTotal: String
    val tgConnectedField: String; val tgSessions: String; val trafficThroughProxy: String
    val sessionsTotal: String; val relayNow: String; val tlsDomain: String
    val sourceSub: String; val lastError: String; val yes: String; val no: String
    val live: String; val deadW: String; val unitMs: String
    val agoMin: String; val agoHour: String; val agoDay: String
    val copyAsLink: String; val openInTelegram: String; val makeNextRelay: String
    val actCopy: String; val actOpen: String; val actRelay: String
    fun agoFmt(v: String): String
    // host detail history + selection sliders (English defaults; languages may override)
    val recentAttempts: String get() = "Recent connects & checks"
    val kindCheck: String get() = "check"
    val kindTg: String get() = "telegram"
    // History table column headers + short "scan" kind label.
    val histWho: String get() = "Who"
    val histWhen: String get() = "When"
    val histReq: String get() = "Req"
    val histSess: String get() = "Session"
    val histScan: String get() = "scan"
    // On-demand "test this host now" UX on the host-detail page.
    val testNow: String get() = "Test now"
    val testShort: String get() = "Test"
    val testResult: String get() = "Test result"
    val testStop: String get() = "Stop"
    val testingNow: String get() = "testing…"
    // Experimental pre-warm standby-sockets feature.
    val prewarmTitle: String get() = "Pre-warm sockets (experimental)"
    val prewarmHelp: String get() = "Hold a few upstream proxy sockets connected in " +
        "advance so a new Telegram connection can skip the connect/handshake. Experimental: it " +
        "keeps reconnecting in the background, so it spends traffic and a little CPU. No fake " +
        "traffic is sent (that would corrupt the real session) — sockets are just rotated. Most " +
        "useful with FakeTLS proxies."
    val prewarmEnable: String get() = "Enable pre-warm"
    val prewarmModeDeferred: String get() = "Deferred (TLS only)"
    val prewarmModeDeferredSub: String get() = "Hold TCP + FakeTLS; finish the init at hand-off. No DC committed — most realistic."
    val prewarmModeFull: String get() = "Full handshake"
    val prewarmModeFullSub: String get() = "Hold fully-connected sockets across DCs; reused only on a DC/tag match. Shorter-lived."
    val prewarmPoolLabel: String get() = "Standby sockets"
    val prewarmHoldLabel: String get() = "Hold each, s"
    val prewarmNote: String get() = "Rotation only (no app-level keepalive). A socket lasts seconds to ~a minute depending on the proxy/DC."
    // Connector-tab pre-warm status + footnote.
    val prewarmStatus: String get() = "Pre-warm"
    fun prewarmStatusVal(ready: Int, holdSecs: Int): String = "$ready ready · hold ${holdSecs}s"
    val prewarmStar: String get() = "Bold orange = socket handed over warm from the pre-warm pool (skipped connect/handshake)"
    // Connector-tab pre-warm table (bottom).
    fun prewarmTableTitle(holdSecs: Int): String = "Pre-warm sockets (hold ${holdSecs}s)"
    val prewarmTableHelp: String get() = "\"Pre-warm sockets\" opens a few proxy sockets in advance so a new " +
        "Telegram connection can skip the connect/handshake. This table lists the sockets being warmed: how long " +
        "each has lived, whether Telegram is using it, and traffic. Turn it on/off and configure it (mode, number " +
        "of sockets, hold time) in More → Settings → \"Pre-warm sockets (experimental)\"."
    val prewarmNoneWarming: String get() = "no sockets warming yet"
    val prewarmColAge: String get() = "age"
    val prewarmColUse: String get() = "in TG?"
    val prewarmInUse: String get() = "in TG"
    val prewarmNew: String get() = "new"
    // LAN sharing / web portal (Settings).
    val lanShareTitle: String get() = "Share over LAN (web portal)"
    val lanShareDesc: String get() = "Let other devices on this Wi-Fi use this AutoConnector as a proxy; a browser opening the address below gets a page of the best proxies."
    val lanShareUrlsLabel: String get() = "Neighbours connect at:"
    val lanShareNoIp: String get() = "no local-network address — connect to Wi-Fi"
    val lanFirewallTitle: String get() = "Allow on the local network"
    val lanFirewallBody: String get() = "Enabling this opens the relay ports to your local network. Windows (or another) firewall may now ask whether to allow AutoConnector — choose Allow / Yes. If you deny it, neighbours' traffic to AutoConnector will be blocked and the page/proxy won't be reachable."
    val lanFirewallConfirm: String get() = "Enable"
    // "What is this for?" info dialog for LAN sharing.
    val lanInfoTitle: String get() = "What is this for?"
    val lanInfoBody: String get() = "Run AutoConnector on ONE computer or phone on your Wi-Fi, and every other device on the same network — including an iPhone, which this app does not support directly — can just open the address in a browser and use it: a page of the best proxies to add to their Telegram, or this device itself as a SOCKS proxy. One device finds and holds the proxies; the rest borrow it over the LAN."
    // Android volume-button pattern trigger (Hotkeys page, Android variant).
    val volTriggerTitle: String get() = "Volume-button trigger"
    val volTriggerSub: String get() = "Switch proxy with a fast volume-key pattern"
    val volEnableLabel: String get() = "Watch volume buttons"
    val volHelpTitle: String get() = "What is this?"
    val volHelpBody: String get() = "On Android there are no global keyboard hotkeys, so this uses the VOLUME buttons instead. While enabled, AutoConnector watches for a fast pattern of Volume-Up/Down presses (e.g. up-up-down-down) in the background. When it recognises one, it opens a tg:// link of a random good, alive proxy so Telegram picks it up and switches — a quick, discreet way to rotate proxy without opening the app. Volume keeps working normally (the presses aren't swallowed). This needs Accessibility access (to read the volume keys in the background and to launch the link); nothing is requested until you enable the toggle. Set the max time between presses below; the recognised patterns are listed at the bottom."
    val volGrantTitle: String get() = "Enable Accessibility (important)"
    val volGrantBody: String get() = "Android (especially 13+) blocks Accessibility for apps NOT installed from Google Play — that's why AutoConnector is greyed out and says \"Restricted setting\" / \"access not allowed\".\n\nHow to unblock:\n1. Open \"App info\" (button below, or Settings → Apps → AutoConnector for Telegram).\n2. Tap the ⋮ menu (top-right) → \"Allow restricted settings\" → confirm.\n3. Go back: Settings → Accessibility → AutoConnector for Telegram → turn it on.\n\nIf you don't see \"Allow restricted settings\", first try toggling it on once in Accessibility (you'll get the blocked message), then step 2 appears.\n\nOn Xiaomi/MIUI, Samsung, etc. the path can differ slightly — look for the same ⋮ in \"App info\". On Android 12 and older there is usually no restriction — just enable it in Accessibility.\n\nVolume keys are only observed, never blocked."
    val volOpenAppInfo: String get() = "Open App info"
    val volAccessOn: String get() = "Accessibility: granted"
    val volAccessOff: String get() = "Accessibility: not granted"
    val volOpenAccess: String get() = "Open Accessibility settings"
    val volGapLabel: String get() = "Max ms between presses"
    val volPatternsTitle: String get() = "Recognised patterns"
    val volPatternPick: String get() = "Pattern"
    val volPatternsLegend: String get() = "↑ = volume up, ↓ = volume down"
    val volNoRights: String get() = "The app does NOT yet have permission to handle the volume buttons — grant access using the steps at the bottom of this page."
    val volGrantShort: String get() = "No Accessibility access yet. Read the detailed steps at the bottom of this page, then tap \"Check\"."
    val volCheck: String get() = "Check"
    val volCheckOk: String get() = "✓ Done — access granted, the trigger works."
    val volCheckFail: String get() = "✗ Still no access — complete the steps above."
    val volPatternsList: String get() = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = volume up, ↓ = volume down)"
    // Volume-trigger page: top intro + "AI fallback" advice block.
    val volIntro: String get() = "Press a volume up/down combination a few times and AutoConnector simulates a tap on the next alive proxy — Telegram opens on your phone and offers to add that proxy. This way you don't have to open AutoConnector to copy a proxy. This mode suits people who keep AutoConnector just for the catalogue, don't turn on relay mode, and only want to grab a proxy."
    val volAiTitle: String get() = "Still doesn't work?"
    val volAiBody: String get() = "If the permission steps above didn't help, open ChatGPT or Gemini and send this prompt — it will give you the exact steps for your phone model:"
    val volAiPrompt: String get() = "How do I grant the Accessibility permission on Android to an app that was NOT installed from Google Play (an unsigned app from an APK file)? Android blocks it as a \"restricted setting\". Walk me through, step by step, how to remove that block and enable the accessibility service for the app. My phone: [enter your make, model and Android version], skin: [MIUI / One UI / ColorOS / stock Android — if you know]. The app is called \"AutoConnector for Telegram\". Describe the exact steps for my specific model and version."
    val volAiCopy: String get() = "Copy prompt"
    // Catalog host-card history: legend explaining the columns / units.
    val histLegend: String get() = "Columns — Who: ✓/✗ TG = real Telegram connect, scan = background check. When: time ago. TCP/TLS/Req: handshake & first-request latency, ms. Session: how long the relay session lasted. ↓/↑: bytes received / sent through the host."
    val tgOkTotalHint: String get() = "Telegram connects / successful / total checks"
    val breadthTitle: String get() = "Host selection breadth"
    val breadthHelp: String get() = "Left = stick to the best proven hosts; right = try as widely as possible across all alive hosts. When Telegram keeps switching relay ports the app widens the search automatically."
    val breadthNarrow: String get() = "proven"
    val breadthWide: String get() = "widest"
    val connTimeoutTitle: String get() = "Per-host connect timeout"
    val connTimeoutHelp: String get() = "How long to wait for one upstream (TCP + TLS + first MTProto reply) before moving on to the next proxy."
    // per-mode catalog captions + mode-management page
    val catalogTopFor: String
    val catalogModeHelpTitle: String; val catalogModeHelp: String
    fun catalogInactiveWarn(section: String, active: String): String
    val manageModeTitle: String
    val manageResetRating: String; fun manageResetHint(mode: String): String
    val manageDeleteAll: String; fun manageDeleteHint(mode: String): String
    fun manageCopyFrom(mode: String): String

    // guide
    val connectTelegram: String; val readCarefully: String
    val guideIntro: String
    val variant1: String; val variant1Body: String
    val variant2: String; val variant2Body: String
    val variant3: String; val variant3Body: String
    val whatNext: String; val whatNextBody: String
    fun proxyBtn(port: Int): String

    // more menu
    val setupPortsTitle: String; val setupPortsSub: String
    val settings: String; val settingsSub: String
    val subscriptions: String; val subscriptionsSub: String
    val statistics: String; val statisticsSub: String
    val export: String; val exportSub: String
    val about: String; val aboutSub: String
    // hotkeys (desktop)
    val hotkeys: String; val hotkeysSub: String; val hotkeysIntro: String; val hotkeysNote: String
    val hotkeyCopyTitle: String; val hotkeyCopyDesc: String
    val hotkeyOpenTitle: String; val hotkeyOpenDesc: String
    val hotkeyEnable: String; val hotkeyLetterLabel: String; val hotkeySet: String; val hotkeyReset: String

    // settings
    val relayPorts: String; val relayPortsHelp: String
    val portA: String; val portB: String
    val antiDpiTrick: String; val antiDpiHelp: String
    val onlyFakeTls: String
    val applyDpiTo: String; val applyDpiHelp: String
    val toRelay: String; val toProbes: String; val toDirect: String
    val vpnSection: String; val vpnHelp: String
    val linkFormat: String; val linkFormatHelp: String
    val linkTg: String; val linkTgSub: String; val linkHttp: String; val linkHttpSub: String
    val viaMtproto: String; val viaMtprotoSub: String
    val directly: String; val directlySub: String
    val notifications: String
    val scanCheck: String; val scanCheckHelp: String
    val scanMin: String; val checkMin: String; val batchSize: String; val parallel: String
    val speedByNet: String; val speedByNetHelp: String
    val intensStandard: String; val intensSlower: String; val intensFaster: String
    // reset / maintenance
    val maintenance: String; val maintenanceHelp: String
    val backupTitle: String; val backupHelp: String
    val backupSettings: String; val backupSubs: String; val backupHosts: String
    val exportWord: String; val importWord: String
    // New backup-page strings: English defaults so untranslated locales still
    // compile; Ru/En override them. Translate in other locales as needed.
    val backupExportTitle: String get() = "Export data"
    val backupImportTitle: String get() = "Import data"
    val backupSelectExport: String get() = "What to export:"
    val backupSelectImport: String get() = "What to import:"
    val backupCopyBtn: String get() = "Copy"
    val backupSaveFile: String get() = "Save to file"
    val backupLoadFile: String get() = "Load from file"
    val backupDoImport: String get() = "Import"
    val backupPasteLabel: String get() = "Paste backup JSON here"
    val backupJsonLabel: String get() = "Backup JSON"
    val backupAndroidFileNote: String get() = "Files aren't available here — use Copy / Paste."
    val eraseAllHosts: String; val factoryReset: String; val factoryResetConfirm: String
    // Shown after a factory reset. Default English; languages may override.
    val factoryResetDone: String get() = "Everything has been reset. Please close the app and open it again."
    val resetCatalog: String; val resetCatalogConfirm: String
    val clearHosts: String; val clearHostsConfirm: String
    val doReset: String; val doCancel: String
    val adaptiveSpeed: String; val adaptiveHelp: String
    val threshMany: String; val threshFew: String; val mulFast: String; val mulLazy: String
    // restructured intensity sections
    val subIntensityTitle: String; val subIntensityHint: String
    val baseScanTitle: String; val baseScanHelp: String; val baseScanPeriod: String
    val baseScanBatch: String; val baseScanThreads: String
    val adaptiveDesc: String; val fewWord: String; val manyWord: String
    fun fasterX(x: String): String; fun slowerX(x: String): String
    fun ifAliveLt(n: Int): String; fun ifAliveGt(n: Int): String
    val disabledWord: String
    val speedByModeTitle: String; val speedByModeHelp: String
    val aliveLt: String; val aliveGt: String
    val periodWord: String; val nonstopWord: String
    val batchWord: String; val threadsWord: String; val scanModeOff: String
    val netBattery: String; val netBatteryHelp: String
    val onlyWifi: String; val onlyCharging: String; val skipLowBattery: String
    val autosaved: String
    val dpiAutoLabel: String; val dpiNoneLabel: String
    // experimental section
    val experimental: String; val experimentalHelp: String
    val expEngineTitle: String; val expEngineWarn: String
    val expConnectTitle: String
    val raceWidthTitle: String
    val connectionSection: String; val connectionSectionHelp: String
    val netLogSection: String
    val netLog: String; val netLogSub: String
    val openLogFolder: String; val copyPath: String
    val quickSwitchTitle: String; val quickSwitchSub: String
    val quickSwitchIntro: String
    val helpShow: String; val helpHide: String

    // sources
    val sourceUrl: String
    fun sourceAlive(alive: Int, total: Int): String
    val open: String; val active: String; val inactive: String
    val lastDownloaded: String; val notDownloaded: String
    fun sourceCounts(dead: Int, total: Int): String

    // stats
    val proxyBase: String
    val totalInBase: String; val aliveNow: String; val deadStat: String
    val aliveIn15: String; val checksAllTime: String
    val antiDpiTricks: String; val noStatsYet: String
    val attempts: String; val handshake: String; val score: String
    val tgConnect: String; val socketsOver1m: String
    val over10kb: String; val over100kb: String; val workTime: String
    val statsLegend: String; val resetStats: String

    // export
    fun aliveLinks(n: Int): String
    val copyAll: String
    val openRandom: String; val copyRandom: String; val allShort: String
    val copyTop: String; val randomHost: String
    val exportToFile: String; val exportSaved: String
    val dlNow: String
    fun downloadingFmt(sec: Long): String
    // subscriptions page + bulk-add page
    val cancel: String
    val deleteConfirmTitle: String
    val subscriptionsAddHint: String
    val addSourcesTitle: String
    val addSubsLabel: String; val addSubsHelp: String
    val addProxiesLabel: String; val addProxiesHelp: String
    val addButton: String
    fun addedFmt(subs: Int, proxies: Int): String
    // connector graphs
    val perSecond: String
    val graphSpeed: String; val graphVolume: String; val graphLatency: String; val graphConnects: String
    // scan tab + intensity preview
    val scanNow: String; val scanOnShort: String
    val scanRunning: String; val scanIdle: String; val scanOffState: String; val scanBatchPerThread: String; val scanPassHosts: String; val minRescanLabel: String
    // scan plan vs. live "now" panel
    val scanPlanTitle: String; val scanNowTitle: String; val currentScheduleTitle: String
    val scheduleWord: String; val unitPcsPerSec: String
    val scanEvery: String; val scanNextRun: String; val scanThreads: String; val scanBatch: String
    val scanElapsed: String; val scanIdleNow: String
    val effForFew: String; val effForMany: String
    val effCheck: String; val effBatch: String; val effPar: String
    val effContinuous: String; val secShort: String; val minShort: String

    // per-network-mode (VPN / Wi-Fi / LTE / WhitePages)
    val scanModeTitle: String; val scanModeAuto: String; val scanModeManualLabel: String
    val activeModeLabel: String; val formingListLabel: String; val catalogModeTabs: String
    val resetModeRatings: String; val forgetModeHosts: String
    val exportModeTitle: String; val modePickerTitle: String; val modeHelp: String
    val autoSelect: String; val manualSelect: String
    // connections-now panel on the scan tab
    val connStatsTitle: String; val connOnPort: String; val outgoingConns: String
    val modeChoice: String; val autoChoice: String; val manualChoice: String
    val directOnVpn: String; val onWord: String; val offWord: String
    val directStateActive: String; val directStateOff: String; val directStateIdle: String
    val wpHintTitle: String; val wpHint: String

    // about
    val appTagline: String
    val version: String; val buildDate: String; val platform: String
    val downloadSources: String; val openOnGithub: String
    val feedbackBugs: String; val writeTelegram: String

    // language setting
    val language: String; val langAuto: String; val langRu: String; val langEn: String
    // additional languages (endonyms — same in every locale)
    val langFa: String; val langZh: String; val langAr: String; val langUr: String
    val langTr: String; val langId: String; val langHi: String; val langBn: String; val langMy: String
    /** The word "language" in THIS locale (for the collapsed language-picker button). */
    val langWord: String

    // desktop system-tray menu (defaulted to English so every locale compiles and
    // falls back gracefully; translated per-locale where provided).
    val trayOpenWindow: String get() = "Open window"
    val trayRefreshSubs: String get() = "Refresh subscriptions"
    val trayExit: String get() = "Exit"
    fun trayConnectorLabel(on: Boolean): String =
        if (on) "Connector: ON (turn off)" else "Connector: OFF (turn on)"
    fun trayScanLabel(on: Boolean): String =
        if (on) "Scan: ON (turn off)" else "Scan: OFF (turn on)"
    fun trayLive(n: Int): String = "Live proxies: $n"

    // appearance: light/dark theme + graph drawing (defaulted to English so every
    // locale compiles; translated per-locale where provided).
    val appearance: String get() = "Appearance"
    val themeLabel: String get() = "Theme"
    val themeAuto: String get() = "Auto"
    val themeLight: String get() = "Light"
    val themeDark: String get() = "Dark"
    val drawGraphsLabel: String get() = "Draw graphs"
    val drawGraphsSub: String get() = "Live charts on the Connector and Scan tabs — turn off to save battery"
}

/** Short display caption for a network-mode code, independent of locale. */
fun modeLabel(code: String): String = when (code) {
    "vpn" -> "VPN"; "wifi" -> "Wi-Fi"; "lte" -> "LTE"; "ethernet" -> "Ethernet"; "wp" -> "White"; "auto" -> "Auto"; else -> "—"
}

val LocalStrings = staticCompositionLocalOf<Strings> { Ru }

/** Languages that lay out right-to-left. */
val RTL_LANGS = setOf("fa", "ar", "ur")

/** Whether the effective UI language (resolved from a stored code) is RTL. */
fun isRtl(code: String): Boolean {
    val eff = if (code == "auto") deviceLanguage() else code
    return eff in RTL_LANGS
}

private fun byCode(code: String): Strings? = when (code) {
    "ru" -> Ru; "en" -> En; "fa" -> Fa; "zh" -> Zh; "ar" -> Ar; "ur" -> Ur
    "tr" -> Tr; "id" -> Id; "hi" -> Hi; "bn" -> Bn; "my" -> My
    "es" -> Es; "fr" -> Fr; "pt" -> Pt; "de" -> De; "ja" -> Ja; "ko" -> Ko
    "vi" -> Vi; "it" -> It; "pl" -> Pl; "uk" -> Uk; "th" -> Th
    "ta" -> Ta; "te" -> Te; "mr" -> Mr; "pa" -> Pa
    // Censorship-priority additions: Central Asia, Afghanistan, Ethiopia, Nigeria.
    "uz" -> Uz; "az" -> Az; "kk" -> Kk; "ps" -> Ps; "prs" -> Prs
    "am" -> Am; "ti" -> Ti; "ha" -> Ha
    else -> null
}

/** Resolve the active Strings from a stored code ("auto" or a 2-letter code). */
fun stringsFor(code: String): Strings =
    byCode(code) ?: byCode(deviceLanguage()) ?: En
