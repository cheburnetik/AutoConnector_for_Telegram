package io.autoconnector.engine

import kotlinx.coroutines.flow.StateFlow

/** Connection state of Telegram through the local relay. */
enum class ConnState { OFFLINE, CONNECTING, CONNECTED, IDLE_SILENT }

enum class LogLevel { OK, FAIL, INFO, WARN, MUTED, ROUTE }

/** Which Logs sub-tab a line belongs to. */
enum class LogCat { TELEGRAM, SUBS, SCAN, OTHER }

/**
 * One log line. [cat] routes it to a Logs sub-tab; [session] (only for
 * [LogCat.TELEGRAM]) groups it under one Telegram connection — encoded as
 * "<port>#<id>", or null for general relay lines.
 */
data class LogLine(
    val text: String,
    val level: LogLevel,
    val cat: LogCat = LogCat.OTHER,
    val session: String? = null,
)

data class Session(
    val host: String,
    val connectedFor: String,
    val lastData: String,
    val traffic: String,
    val alive: Boolean,
)

/** Details of the upstream proxy currently carrying Telegram traffic. */
data class ProxyInfo(
    val host: String,
    val port: Int,
    val typeLabel: String,   // "MTProto" / "SOCKS5"
    val tls: String?,        // FakeTLS cover-domain (SNI) or null
    val secret: String?,     // MTProto secret, shortened for display
    val dpi: String,         // anti-DPI handshake actually used
)

data class CatalogItem(
    val id: Long,
    val host: String,          // host:port (+ →sni)
    val typeLabel: String,
    val rating: Int,           // 0..9
    val alive: Boolean,
    val live: Boolean,         // Telegram routed through it right now
    val pinned: Boolean,       // forced next relay
    val sticky: Boolean,
    val everServed: Boolean,
    val sourceNum: Int?,
    // row-2 / detail stats
    val checkedMinsAgo: Long = -1,   // -1 = never
    val tgConnectMinsAgo: Long = -1, // -1 = never
    val successes: Int = 0,
    val failures: Int = 0,
    val tgConnections: Long = 0,
    val bytesRelayed: Long = 0,
    val bytesRelayedHuman: String = "0 Б",
    val sessionTotalHuman: String = "—",
    val rttMs: Int = -1,
    val secret: String? = null,
    val tlsDomain: String? = null,
    val port: Int = 0,
    val lastErrorShort: String? = null,
)

data class SourceItem(
    val id: Long,
    val seq: Int,                  // 1-based position in the list
    val url: String,
    val enabled: Boolean,
    val alive: Int,
    val dead: Int,
    val total: Int,
    val bytesHuman: String,        // bytes of the last download ("—" if none/failed)
    val lastRefreshMinsAgo: Long,  // -1 = never downloaded
    val lastError: String?,
)

data class EngineSettings(
    val portA: Int = 0,
    val portB: Int = 0,
    val handshakeMode: Int = 0,
    val notificationsEnabled: Boolean = true,
    val onlyFakeTls: Boolean = false,
    val proxyModeCode: String = "auto",
    // Restored from the original app:
    val scanIntervalMin: Int = 15,
    val checkIntervalMin: Int = 10,
    val checkBatch: Int = 100,
    val checkConcurrency: Int = 16,
    val speedVpn: Float = 1f,
    val speedWifi: Float = 1f,
    val speedLte: Float = 1f,
    val adaptiveAliveThreshold: Int = 0,
    val fastSpeedMultiplier: Float = 1f,
    val lazyAliveThreshold: Int = 0,
    val lazySpeedMultiplier: Float = 1f,
    val wifiOnly: Boolean = false,
    val chargingOnly: Boolean = false,
    val skipLowBattery: Boolean = false,
    val dpiApplyRelay: Boolean = true,
    val dpiApplyProbes: Boolean = true,
    val dpiApplyDirect: Boolean = false,
    val langCode: String = "auto",
    // Experimental: alternative upstream proxying engine. Default 4 =
    // WireShaper.Mode.COALESCE_DELAY (coalescing/batching) — the shipped default.
    val expEngineMode: Int = 4,
    val netLogEnabled: Boolean = false,
    // Experimental: upstream-acquisition strategy (0 = OFF = serial reference).
    val relayConnectMode: Int = 0,
)

/** A selectable experimental upstream engine for the settings picker. */
data class ExpEngineOption(val code: Int, val label: String, val description: String)

/** Build/version info for the About page. */
data class AppInfo(val version: String, val buildDate: String)

/** A selectable anti-DPI handshake mode. [ordinal] is the persisted value. */
data class HandshakeOption(val ordinal: Int, val label: String, val special: Boolean)

/** One row of per-anti-DPI-trick statistics. */
data class HandshakeStatRow(
    val label: String,
    val attempts: Long,
    val handshakes: Long,
    val tgConnected: Long,
    val over10k: Long,
    val over100k: Long,
    val over1m: Long,
    val over5m: Long,
    val activeHuman: String,   // summed working time of "real" sockets
    val trafficHuman: String,
    val score: Double,
    val hsRatePct: Int,        // handshakes / attempts, %
)

/**
 * Full snapshot the UI renders. Recomputed on every poll tick. Array fields
 * are replaced wholesale each tick (reference inequality → recomposition),
 * which is the desired behaviour for live sparklines.
 */
data class EngineState(
    val proxyEnabled: Boolean = false,
    val scanEnabled: Boolean = false,

    val setupNeeded: Boolean = false,
    val setupCta: String? = null,
    val portA: Int = 0,
    val portB: Int = 0,

    val connState: ConnState = ConnState.OFFLINE,
    val statusText: String = "Telegram не подключён",
    val statusSub: String = "",
    val modeBadge: String = "",

    // Direct ("bypass") mode: the relay forwards Telegram straight to the DC,
    // not through any MTProto proxy. [directViaVpn] tells the two cases apart:
    // true = proxies are skipped because a VPN is active; false = proxies were
    // turned off outright. [directAntiDpi] = first-segment fragmentation is on.
    val directMode: Boolean = false,
    val directViaVpn: Boolean = false,
    val directAntiDpi: Boolean = false,

    val aliveCount: Int = 0,
    val aliveWithin15: Int = 0,
    val totalCount: Int = 0,

    val speedDown: String = "—",
    val speedUp: String = "—",
    val totalDown: String = "—",
    val totalUp: String = "—",
    val latency: String = "—",
    val sessions: List<Session> = emptyList(),

    // Connector tab: socket counts on each side of the relay + active upstream.
    val socketsTgToConnector: Int = 0,
    val socketsConnectorToProxy: Int = 0,
    val currentProxy: ProxyInfo? = null,
    val connCount: Int = 0,        // live Telegram connections
    val connSeconds: Long = 0,     // how long the current session has run

    // Scan tab counters.
    val deadCount: Int = 0,
    val sourcesRefMin: Int = 0,    // subscriptions refreshed in the last minute
    val sourcesRefHour: Int = 0,   // …in the last hour
    val sourcesTotal: Int = 0,
    // checked / alive-found / dead-found, all-time (per-min and per-hour are
    // derived in the UI from checksOk/Fail 60s/60m).
    val checkedAllTime: Long = 0,
    val aliveAllTime: Long = 0,
    val deadAllTime: Long = 0,
    // Subscription download pipeline.
    val subsOkMin: Int = 0,
    val subsOkHour: Int = 0,
    val subsFailMin: Int = 0,
    val subsFailHour: Int = 0,
    val scanBytesMin: String = "0 Б",
    val scanBytesHour: String = "0 Б",
    // Telegram session tallies (all-time).
    val tgSessAll: Long = 0,
    val tgSessOk: Long = 0,
    val sessOver1m: Long = 0,
    val sessOver5m: Long = 0,
    val sessOver15m: Long = 0,

    // OS-level notifications enabled (foreground service can run in background).
    val notificationsOk: Boolean = true,

    val checksOk60s: Int = 0,
    val checksFail60s: Int = 0,
    val checksOk60m: Int = 0,
    val checksFail60m: Int = 0,

    val trafficSec: LongArray = LongArray(60),
    val trafficMin: LongArray = LongArray(60),
    val latencySec: LongArray = LongArray(60),
    val latencyMin: LongArray = LongArray(60),
    val checkOkSec: IntArray = IntArray(60),
    val checkFailSec: IntArray = IntArray(60),
    val checkOkMin: IntArray = IntArray(60),
    val checkFailMin: IntArray = IntArray(60),
) {
    // Identity-based equals is fine and avoids the array-equals boilerplate;
    // every tick produces a fresh instance anyway.
    override fun equals(other: Any?) = this === other
    override fun hashCode() = System.identityHashCode(this)
}

/**
 * Platform-agnostic contract the Compose UI depends on. The Android build
 * supplies an implementation backed by the existing Java relay engine;
 * desktop / iOS will supply their own later.
 */
interface Engine {
    val state: StateFlow<EngineState>
    val logs: StateFlow<List<LogLine>>
    val catalog: StateFlow<List<CatalogItem>>
    val sources: StateFlow<List<SourceItem>>
    val settings: StateFlow<EngineSettings>

    fun setProxyEnabled(on: Boolean)
    fun setScanEnabled(on: Boolean)

    fun updateSettings(s: EngineSettings)
    fun handshakeModeLabels(): List<String>

    /** Anti-DPI options for the settings picker — AUTO/NONE first, then tricks. */
    fun handshakeOptions(): List<HandshakeOption>

    /** Experimental upstream-engine options for the settings picker (OFF first). */
    fun expEngineOptions(): List<ExpEngineOption>

    /** Experimental connect-strategy options for the settings picker (OFF first). */
    fun connectEngineOptions(): List<ExpEngineOption>

    /** Absolute path of the diagnostic network-exchange log file (or null). */
    fun netLogPath(): String?

    /** Reveal/open the folder holding the network-exchange log, if possible. */
    fun openNetLogFolder()

    /** Per-anti-DPI-trick statistics for the Stats table. */
    fun handshakeStats(): List<HandshakeStatRow>
    fun resetStats()

    /** Resets the working catalog + all statistics, keeping downloaded hosts and
     *  subscriptions (everything gets re-rated on the next scan). */
    fun resetCatalogStats()

    /** Forgets the whole downloaded-host pool but keeps subscriptions, so the
     *  next scan re-fills the pool from them. */
    fun clearDownloadedHosts()

    /** App version + build date for the About page. */
    fun appInfo(): AppInfo

    fun pin(id: Long, pinned: Boolean)
    fun tgLink(id: Long): String?
    fun copyToClipboard(text: String)

    /** Opens an external URL (e.g. a tg:// proxy link) in the platform handler. */
    fun openLink(url: String)

    /** Re-requests / opens OS settings so the user can enable notifications. */
    fun requestNotifications()

    fun addSource(url: String)
    fun removeSource(id: Long)
    fun setSourceEnabled(id: Long, enabled: Boolean)

    /** tg:// links of currently-alive proxies, for the Export page. */
    fun exportAliveLinks(): List<String>

    /** Writes all alive links to a text file in the user's home/pull-able dir
     *  and returns its absolute path, or null on failure. */
    fun exportLinksToFile(): String?

    fun refreshNow()

    fun start()
    fun dispose()
}
