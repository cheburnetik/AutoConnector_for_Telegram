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
    val eraseAllHosts: String; val factoryReset: String; val factoryResetConfirm: String
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
    val version: String; val buildDate: String
    val downloadSources: String; val openOnGithub: String
    val feedbackBugs: String; val writeTelegram: String

    // language setting
    val language: String; val langAuto: String; val langRu: String; val langEn: String
}

/** Short display caption for a network-mode code, independent of locale. */
fun modeLabel(code: String): String = when (code) {
    "vpn" -> "VPN"; "wifi" -> "Wi-Fi"; "lte" -> "LTE"; "ethernet" -> "Ethernet"; "wp" -> "White"; "auto" -> "Auto"; else -> "—"
}

val LocalStrings = staticCompositionLocalOf<Strings> { Ru }

/** Resolve the active Strings from a stored code ("auto"/"ru"/"en"). */
fun stringsFor(code: String): Strings = when (code) {
    "ru" -> Ru
    "en" -> En
    else -> if (deviceLanguage() == "ru") Ru else En
}
