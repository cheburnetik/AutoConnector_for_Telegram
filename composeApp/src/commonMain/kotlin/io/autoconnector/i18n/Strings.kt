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
    fun tgToConnector(n: Int): String
    fun connectorToProxy(n: Int): String
    val trafficSec: String; val trafficMin: String
    val latencySec: String; val latencyMin: String
    val sec60: String; val min60: String
    val unitSec: String; val unitMin: String; val unitHour: String; val dash: String
    val currentProxy: String; val noActiveProxy: String
    val host: String; val type: String; val secret: String; val antiDpi: String
    fun activeSockets(n: Int): String
    val noConnections: String; val colHost: String; val colTime: String

    // scan tab
    val scanOff: String; val proxiesInBase: String
    val total: String; val alive: String; val dead: String
    val tgConnectedTitle: String; val successful: String
    val socketsHeld: String; val over1m: String; val over5m: String; val over15m: String
    val scanCountTitle: String; val checked: String
    val forAllTime: String; val perMinute: String; val perHour: String
    val subsCountTitle: String; val downloaded: String; val failed: String; val scanTraffic: String
    val checksMtproto: String

    // catalog
    val catalogEmpty: String; val aliveShort: String; val deadShort: String
    val statusLabel: String; val rating: String; val port: String
    val rttPing: String; val checkedField: String; val okOfTotal: String
    val tgConnectedField: String; val tgSessions: String; val trafficThroughProxy: String
    val sessionsTotal: String; val relayNow: String; val tlsDomain: String
    val sourceSub: String; val lastError: String; val yes: String; val no: String
    val live: String; val deadW: String; val unitMs: String
    val agoMin: String; val agoHour: String; val agoDay: String
    val copyAsLink: String; val openInTelegram: String; val makeNextRelay: String
    fun agoFmt(v: String): String

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

    // settings
    val relayPorts: String; val relayPortsHelp: String
    val portA: String; val portB: String
    val antiDpiTrick: String; val antiDpiHelp: String
    val onlyFakeTls: String
    val applyDpiTo: String; val applyDpiHelp: String
    val toRelay: String; val toProbes: String; val toDirect: String
    val vpnSection: String; val vpnHelp: String
    val viaMtproto: String; val viaMtprotoSub: String
    val directly: String; val directlySub: String
    val notifications: String
    val scanCheck: String; val scanCheckHelp: String
    val scanMin: String; val checkMin: String; val batchSize: String; val parallel: String
    val speedByNet: String; val speedByNetHelp: String
    val adaptiveSpeed: String; val adaptiveHelp: String
    val threshMany: String; val threshFew: String; val mulFast: String; val mulLazy: String
    val netBattery: String; val netBatteryHelp: String
    val onlyWifi: String; val onlyCharging: String; val skipLowBattery: String
    val autosaved: String
    val dpiAutoLabel: String; val dpiNoneLabel: String

    // sources
    val sourceUrl: String
    fun sourceAlive(alive: Int, total: Int): String

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

    // about
    val appTagline: String
    val version: String; val buildDate: String
    val downloadSources: String; val openOnGithub: String
    val feedbackBugs: String; val writeTelegram: String

    // language setting
    val language: String; val langAuto: String; val langRu: String; val langEn: String
}

val LocalStrings = staticCompositionLocalOf<Strings> { Ru }

/** Resolve the active Strings from a stored code ("auto"/"ru"/"en"). */
fun stringsFor(code: String): Strings = when (code) {
    "ru" -> Ru
    "en" -> En
    else -> if (deviceLanguage() == "ru") Ru else En
}
