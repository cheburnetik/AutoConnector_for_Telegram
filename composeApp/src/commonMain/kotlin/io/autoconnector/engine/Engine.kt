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
    val ts: Long = 0,
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
    val obfEngine: String = "—", // transport obfuscation engine (FakeTLS / dd / plain / SOCKS5)
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
    val downloading: Boolean = false,   // a manual out-of-queue download is in flight
    val downloadingSec: Long = 0,       // …for this many seconds
)

data class EngineSettings(
    val portA: Int = 0,
    val portB: Int = 0,
    val handshakeMode: Int = 0,
    val notificationsEnabled: Boolean = true,
    val onlyFakeTls: Boolean = false,
    val proxyModeCode: String = "auto",
    // Defaults mirror Prefs (the source of truth); these are pre-load fallbacks.
    val scanIntervalMin: Int = 30,
    val checkIntervalMin: Int = 5,
    val checkBatch: Int = 50,
    val checkConcurrency: Int = 10,
    // Anti-flood floor: don't re-probe the same host more often than this many
    // minutes (0 = no floor). Mirrors Prefs (the source of truth).
    val minRescanMin: Int = 2,
    val speedVpn: Float = 1f,
    val speedWifi: Float = 1f,
    val speedLte: Float = 1f,
    val speedEthernet: Float = 1f,
    val speedWp: Float = 0.2f,
    // Subscription re-download interval (minutes), separately per network mode.
    val subIntervalVpn: Int = 30,
    val subIntervalWifi: Int = 30,
    val subIntervalLte: Int = 30,
    val subIntervalEthernet: Int = 30,
    val subIntervalWp: Int = 30,
    // Manual network-mode override for scanning: auto|vpn|wifi|lte|wp.
    val scanMode: String = "auto",
    val adaptiveAliveThreshold: Int = 30,
    val fastSpeedMultiplier: Float = 0.1f,
    val lazyAliveThreshold: Int = 70,
    val lazySpeedMultiplier: Float = 5f,
    val wifiOnly: Boolean = false,
    val chargingOnly: Boolean = false,
    val skipLowBattery: Boolean = false,
    val dpiApplyRelay: Boolean = true,
    val dpiApplyProbes: Boolean = true,
    val dpiApplyDirect: Boolean = false,
    // Proxy-link format for copy/open: false = tg:// (opens Telegram directly),
    // true = https://t.me/… (opens via browser, useful if tg:// isn't registered).
    val proxyLinkHttp: Boolean = false,
    val langCode: String = "auto",
    // Experimental: alternative upstream proxying engine. Default 14 =
    // WireShaper.Mode.SPLIT_FIRST_X3 («Сплит первого пакета ×3») on desktop;
    // Android forces OFF. Pre-load fallback only — Prefs is the source of truth.
    val expEngineMode: Int = 14,
    val netLogEnabled: Boolean = false,
    // Experimental: upstream-acquisition strategy (0 = OFF = serial reference).
    val relayConnectMode: Int = 0,
    // Parallel-race connect mode: how many upstreams to dial at once (5/8/12).
    val relayRaceWidth: Int = 8,
    // Host-selection breadth 0..100: 0 = stick to the best proven hosts,
    // 100 = try as widely as possible across all alive hosts.
    val relayBreadth: Int = 30,
    // Per-upstream wait budget (ms) for TCP connect + TLS + first MTProto reply
    // before trying the next proxy. 100..15000, log-scaled slider.
    val relayConnectTimeoutMs: Int = 8000,
)

/** One past attempt against a host, for the detail card's history list. */
data class HistoryRecord(
    val ts: Long,             // epoch ms
    val isTelegram: Boolean,  // true = Telegram relay connect, false = background check probe
    val success: Boolean,
    val tcpMs: Int = -1,      // TCP socket connect time, -1 = unknown
    val tlsMs: Int = -1,      // TLS/handshake time, -1 = unknown
    val totalMs: Int = -1,    // total connect+handshake duration, -1 = unknown
    val bytesIn: Long = 0,
    val bytesOut: Long = 0,
)

/** A selectable experimental upstream engine for the settings picker. */
data class ExpEngineOption(val code: Int, val label: String, val description: String)

/** Effective scan parameters derived from a base trio + intensity multiplier,
 *  for the settings preview. [continuous] = interval collapsed to non-stop. */
data class ScanParams(
    val intervalSec: Int,
    val batch: Int,
    val concurrency: Int,
    val continuous: Boolean,
    // True when intensity is dialled to the minimum end → scan is OFF («выкл»).
    val disabled: Boolean = false,
)

/** Build/version info for the About page. [platform] = OS + CPU arch, e.g.
 *  "Windows x86-64" / "Android arm64-v8a". Defaults to "" for callers that
 *  don't supply it. */
data class AppInfo(val version: String, val buildDate: String, val platform: String = "")

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
    // True while a check pass is actively probing right now (manual button OR
    // the scheduled loop) — drives the «Скан идёт / idle» header indicator.
    val scanRunning: Boolean = false,

    val setupNeeded: Boolean = false,
    val setupCta: String? = null,
    val portA: Int = 0,
    val portB: Int = 0,

    val connState: ConnState = ConnState.OFFLINE,
    val statusText: String = "Telegram не подключён",
    val statusSub: String = "",
    val modeBadge: String = "",
    // Current detected network for the Connector header (Wi-Fi / LTE / VPN /
    // Ethernet), or "" when unknown.
    val netLabel: String = "",

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
    // Subscription-download traffic totals (separate from host-scan traffic).
    val subBytesMin: String = "0 Б",
    val subBytesHour: String = "0 Б",
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
    val scanTrafficSec: LongArray = LongArray(60),
    val scanTrafficMin: LongArray = LongArray(60),
    val subTrafficSec: LongArray = LongArray(60),
    val subTrafficMin: LongArray = LongArray(60),
    val aliveHistSec: LongArray = LongArray(60),
    val aliveHistMin: LongArray = LongArray(60),
    val scanPingSec: LongArray = LongArray(60),
    val scanPingMin: LongArray = LongArray(60),
    val threadsSec: LongArray = LongArray(60),
    val threadsMin: LongArray = LongArray(60),
    val connectsASec: LongArray = LongArray(60),   // new connects/sec on port A (lower, 55001) — inbound + outbound
    val connectsBSec: LongArray = LongArray(60),   // …on port B (higher, 55002)
    val connectsAMin: LongArray = LongArray(60),   // new connects/min on port A
    val connectsBMin: LongArray = LongArray(60),   // …on port B
    val connectsPortA: Int = 0,                    // 0 until first connect seen
    val connectsPortB: Int = 0,
    val connLiveA: Int = 0,            // live Telegram sockets on relay port A (55001) right now
    val connLiveB: Int = 0,            // …on port B (55002)
    val connLiveOut: Int = 0,          // live outbound sockets to upstream proxies right now
    val directOnVpnEnabled: Boolean = false,  // setting: bypass proxies when a VPN is active
    // Newest-bucket ids for the live graphs' animation trigger (epoch s / min).
    val nowSec: Long = 0,
    val nowMin: Long = 0,

    // Scan tab — schedule "plan" vs. live "now".
    val scanPlanIntervalSec: Int = 0,   // how often a scheduled pass runs
    val scanPlanNextSec: Int = 0,       // seconds until the next scheduled pass
    val scanPlanConcurrency: Int = 0,   // planned parallel probe threads
    val scanPlanBatch: Int = 0,         // planned probes per pass
    val scanNowThreads: Int = 0,        // probes in flight this instant
    val scanNowBatch: Int = 0,          // size of the pass running right now
    val scanNowSeconds: Long = 0,       // how long the current pass has run

    // Per-network-mode view: the relay rates proxies separately for each network
    // transport (VPN / Wi-Fi / LTE / WhitePages); these reflect the ACTIVE one.
    val activeMode: String = "unk",          // effective mode code now: vpn/wifi/lte/wp/unk
    val scanModeManual: Boolean = false,     // true if the user forced a mode (not auto)
    val aliveMode: Int = 0,                  // alive hosts for the ACTIVE mode
    val deadMode: Int = 0,
    val totalMode: Int = 0,
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

    /** Pure preview: effective scan params for a base trio scaled by [mult].
     *  Used by the settings screen to show the «мало/много» final numbers. */
    fun scanParamsFor(checkMin: Int, batch: Int, concurrency: Int, mult: Float): ScanParams

    /** Absolute path of the diagnostic network-exchange log file (or null). */
    fun netLogPath(): String?

    /** Reveal/open the folder holding the network-exchange log, if possible. */
    fun openNetLogFolder()

    /** Absolute path of the per-user data folder (settings + proxy DB live here). */
    fun dataDirPath(): String

    /** Open that data folder in the OS file manager (desktop); no-op where unsupported. */
    fun openDataFolder()

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

    /** Bulk-add subscriptions: each non-blank http(s) line becomes a source. Returns how many were added. */
    fun addSourcesBulk(urls: String): Int

    /** Parse a pasted batch of proxy links and add them as a fixed (non-downloadable) list. Returns how many new proxies were added. */
    fun addManualProxies(text: String): Int

    /** Immediately (out-of-schedule) re-download one subscription by id. */
    fun refreshSource(id: Long)

    /** tg:// links of currently-alive proxies, for the Export page. */
    fun exportAliveLinks(): List<String>

    /** Writes all alive links to a text file in the user's home/pull-able dir
     *  and returns its absolute path, or null on failure. */
    fun exportLinksToFile(): String?

    // --- Backup: settings / subscriptions / live-hosts-by-mode (universal JSON) --
    /** Builds the universal backup JSON for the selected sections. Pure — no file
     *  I/O — so the UI can show it in a text field to copy or save. */
    fun buildBackupJson(settings: Boolean, subs: Boolean, hosts: Boolean): String

    /** Applies a backup pasted/loaded as JSON text, importing only the requested
     *  sections that are actually present. Returns a status line. */
    fun importBackupText(text: String, settings: Boolean, subs: Boolean, hosts: Boolean): String

    /** Writes [text] to a file the user picks (desktop). Returns a status line;
     *  on platforms without file dialogs returns an "unsupported" message. */
    fun saveTextToFile(suggestedName: String, text: String): String

    /** Opens a file the user picks and returns its text, or null when cancelled
     *  or unsupported (e.g. Android, where there is no disk file dialog). */
    fun pickTextFile(): String?

    /** True on platforms with native file save/open dialogs (desktop), false on
     *  Android — the UI hides the file buttons and keeps copy/paste only. */
    fun fileIoSupported(): Boolean

    /** Full factory reset — wipes all settings AND the host pool, restores the
     *  default subscriptions and re-bootstraps. Same end state as a clean first
     *  launch. */
    fun factoryReset()

    // --- Per-network-mode operations (vpn/wifi/lte/wp; "auto"/"unk" = global) --
    /** Force a scan network-mode ("auto"|"vpn"|"wifi"|"lte"|"wp"); "auto" restores detection. */
    fun setScanMode(mode: String)

    /** Catalog rows rated for one specific mode (probed-but-dead hosts included). */
    fun catalogForMode(modeCode: String): List<CatalogItem>

    /** The host's most recent attempts (checks + Telegram connects), newest first. */
    fun hostHistory(id: Long, limit: Int = 25): List<HistoryRecord>

    /** tg:// links of proxies alive for one mode, for the Export page. */
    fun exportAliveLinksForMode(modeCode: String): List<String>

    /** Writes one mode's alive links to a file, returning its path or null. */
    fun exportLinksToFileForMode(modeCode: String): String?

    /** Zeroes every per-host rating recorded under one mode (keeps the hosts). */
    fun resetModeStats(modeCode: String)

    /** Forgets all per-host rows recorded under one mode (re-rated on next scan). */
    fun forgetModeHosts(modeCode: String)

    /** Copies one mode's per-host ratings/alive into another (target inherits source). */
    fun copyModeStats(fromCode: String, toCode: String)

    fun refreshNow()

    /** Immediate, settings-ignoring probe of up to 500 pool proxies at 50
     *  threads — what the Scan tab's «Сканировать сейчас» button triggers.
     *  Skips the subscription download and the scan-enabled / intensity gates. */
    fun scanNow()

    // --- Desktop global hotkeys (no-op / false on Android) ---------------
    /** Whether this platform offers the global-hotkeys page (desktop only). */
    fun hotkeysSupported(): Boolean
    /** Master on/off for both global hotkeys. */
    fun hotkeysEnabled(): Boolean
    fun setHotkeysEnabled(on: Boolean)
    /** The single configurable trigger letter (e.g. "P"). */
    fun hotkeyLetter(): String
    fun setHotkeyLetter(letter: String)
    /** The copy / open chord rendered in the current OS's notation, incl. the letter. */
    fun hotkeyCopyLabel(): String
    fun hotkeyOpenLabel(): String

    fun start()
    fun dispose()
}
