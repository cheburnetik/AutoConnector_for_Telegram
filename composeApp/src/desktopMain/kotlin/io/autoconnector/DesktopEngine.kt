package io.autoconnector

import android.content.Context
import io.autoconnector.engine.AppInfo
import io.autoconnector.engine.CatalogItem
import io.autoconnector.engine.ConnState
import io.autoconnector.engine.Engine
import io.autoconnector.engine.EngineSettings
import io.autoconnector.engine.EngineState
import io.autoconnector.engine.ExpEngineOption
import io.autoconnector.engine.ScanParams
import io.autoconnector.engine.HandshakeOption
import io.autoconnector.engine.HandshakeStatRow
import io.autoconnector.engine.LogCat
import io.autoconnector.engine.LogLevel
import io.autoconnector.engine.LogLine
import io.autoconnector.engine.ProxyInfo
import io.autoconnector.engine.Session
import io.autoconnector.engine.SourceItem
import io.autoconnector.engine.check.CheckRunner
import io.autoconnector.engine.core.Durations
import io.autoconnector.engine.core.NetworkMode
import io.autoconnector.engine.core.NetworkMonitor
import io.autoconnector.engine.core.Prefs
import io.autoconnector.engine.db.ProxyStore
import io.autoconnector.engine.model.ProxyEntry
import io.autoconnector.engine.model.ProxyType
import io.autoconnector.engine.net.FakeTlsClient
import io.autoconnector.engine.net.HandshakeMode
import io.autoconnector.engine.net.HandshakeStats
import io.autoconnector.engine.relay.NetLog
import io.autoconnector.engine.relay.RelayConnectMode
import io.autoconnector.engine.relay.RelayLog
import io.autoconnector.engine.relay.RelayManager
import io.autoconnector.engine.relay.WireShaper
import io.autoconnector.engine.relay.RelayServer
import io.autoconnector.engine.relay.RelayStats
import io.autoconnector.engine.scan.PageScanner
import io.autoconnector.engine.scan.ProxyParser
import io.autoconnector.engine.traffic.CheckRateBuffer
import io.autoconnector.engine.traffic.ConnectBuffer
import io.autoconnector.engine.traffic.LatencyBuffer
import io.autoconnector.engine.traffic.ScanMetrics
import io.autoconnector.engine.traffic.SparkBuffer
import io.autoconnector.engine.traffic.TrafficMeter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.io.File

private const val IDLE_THRESHOLD_MS = 30_000L
private const val MATURE_BYTES = 4096L
private const val CONNECTED_MIN_BYTES = 1024L
private const val MAINS_CHECK_INTERVAL_MS = 2 * 60_000L
private const val LOG_CAP_TELE = 500
private const val LOG_CAP_SCAN = 300
private const val LOG_CAP_SUBS = 150

/**
 * Desktop implementation of [Engine]. It reuses the very same Java relay engine
 * the Android app runs (via the :engineDesktop module + android.* shim), and
 * plays the role the Android foreground service plays there: it owns the
 * [RelayManager] (the two loopback SOCKS5 ports) and drives the periodic
 * mains-check / spark-ingest loops itself — here with coroutines instead of a
 * HandlerThread + WorkManager.
 */
class DesktopEngine(private val dataDir: File) : Engine {

    private val ctx = Context(dataDir)
    private val store = ProxyStore.get(ctx)
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    private val _state = MutableStateFlow(EngineState())
    override val state: StateFlow<EngineState> = _state.asStateFlow()
    private val _logs = MutableStateFlow<List<LogLine>>(emptyList())
    override val logs: StateFlow<List<LogLine>> = _logs.asStateFlow()
    private val _catalog = MutableStateFlow<List<CatalogItem>>(emptyList())
    override val catalog: StateFlow<List<CatalogItem>> = _catalog.asStateFlow()
    private val _sources = MutableStateFlow<List<SourceItem>>(emptyList())
    override val sources: StateFlow<List<SourceItem>> = _sources.asStateFlow()
    private val _settings = MutableStateFlow(EngineSettings())
    override val settings: StateFlow<EngineSettings> = _settings.asStateFlow()

    private var prevUp = 0L
    private var prevDown = 0L
    private var lastDataAt = 0L

    @Volatile private var relayManager: RelayManager? = null

    // Desktop network label (Android's ConnectivityManager shim can't detect it),
    // derived from java.net.NetworkInterface and cached so we don't enumerate
    // every poll tick.
    @Volatile private var cachedNetLabel = ""
    private var netLabelStamp = 0L

    // source id -> epoch ms when a manual out-of-queue download started.
    private val downloadingSince = java.util.concurrent.ConcurrentHashMap<Long, Long>()

    private fun netLabel(): String {
        val now = System.currentTimeMillis()
        if (now - netLabelStamp < 5_000L) return cachedNetLabel
        netLabelStamp = now
        cachedNetLabel = try {
            // Find the interface that ACTUALLY carries the default route by asking
            // the OS which local address it would use to reach a public IP. A UDP
            // "connect" sends no packets — it just resolves the egress interface.
            // This ignores installed-but-inactive VPN adapters (the old name-scan
            // wrongly reported VPN whenever a TAP/WireGuard adapter merely existed).
            val local = java.net.DatagramSocket().use { s ->
                s.connect(java.net.InetAddress.getByName("8.8.8.8"), 53)
                s.localAddress
            }
            if (local == null || local.isAnyLocalAddress || local.isLoopbackAddress) {
                ""
            } else {
                val ni = java.net.NetworkInterface.getByInetAddress(local)
                val n = ((ni?.name ?: "") + " " + (ni?.displayName ?: "")).lowercase()
                when {
                    listOf("tun", "tap", "ppp", "wg", "utun", "vpn", "wireguard",
                        "openvpn", "nordlynx", "proton").any { n.contains(it) } -> "🔒 VPN"
                    listOf("wlan", "wlp", "wi-fi", "wifi", "wireless", "wlo").any { n.contains(it) } -> "📶 Wi-Fi"
                    else -> "🌐 Ethernet"
                }
            }
        } catch (_: Throwable) { "" }
        return cachedNetLabel
    }

    override fun start() {
        HandshakeStats.init(ctx)
        NetworkMonitor.init(ctx)
        NetLog.init(dataDir)
        // Default proxying/obfuscation engine is OFF (user request 2026-06-08) —
        // the relay's plain path works, anti-DPI is handled by the «Авто» DPI
        // trick instead. Was «Сплит первого пакета ×3» (code 14).
        Prefs.SHIPPED_EXP_ENGINE = 0
        Prefs(ctx).applyShippedDefaultsOnce()
        RelayLog.register { session, line -> appendLog(line, LogCat.TELEGRAM, session) }
        loadSettings()
        // Apply the saved network-mode override on top of auto-detection, and
        // react to future mode changes (desktop feeds detection from netLabel()
        // in pollLoop — see feedDetectedMode()).
        run {
            val mc = Prefs(ctx).scanModeOverride()
            NetworkMonitor.setManualMode(if (mc == "auto") null else NetworkMode.fromCode(mc))
            lastBypass = Prefs(ctx).shouldBypassProxies()
            NetworkMonitor.get()?.addListener(object : NetworkMonitor.Listener {
                override fun onModeChanged(newMode: NetworkMode) {
                    scope.launch(Dispatchers.IO) {
                        // Direct-on-VPN must flip PROMPTLY: a VPN coming up/down
                        // changes shouldBypassProxies(), but live Telegram sockets
                        // would keep their old routing until they happen to
                        // reconnect. Drop them so they reconnect and re-evaluate
                        // in the new mode right away.
                        val bypass = Prefs(ctx).shouldBypassProxies()
                        if (bypass != lastBypass) {
                            lastBypass = bypass
                            val pr = Prefs(ctx)
                            RelayStats.closeOnPort(pr.relayPortA())
                            RelayStats.closeOnPort(pr.relayPortB())
                            appendLog(
                                if (bypass) "🔌 VPN активен — прямой режим (без прокси)"
                                else "🔌 прокси-режим восстановлен", LogCat.TELEGRAM,
                            )
                            pushImmediate()
                        }
                        onModeSwitched(newMode)
                    }
                }
            })
        }
        NetLog.setEnabled(Prefs(ctx).netLogEnabled())
        prevUp = RelayStats.bytesUp.get()
        prevDown = RelayStats.bytesDown.get()
        applyRelayState()
        scope.launch { pollLoop() }
        scope.launch { sparkLoop() }
        scope.launch { mainsLoop() }
        scope.launch { probePauseWatcher() }
        scope.launch(Dispatchers.IO) { sourcesLoop() }
        scope.launch(Dispatchers.IO) { autoRefreshOnce() }
        // Arm global hotkeys to whatever was last enabled (default: off).
        runCatching { hotkeys.apply(Prefs(ctx).hotkeysEnabled(), Prefs(ctx).hotkeyLetter()) }
    }

    override fun dispose() {
        runCatching { hotkeys.apply(false, "P") }
        relayManager?.let { try { it.stop() } catch (_: Throwable) {} }
        relayManager = null
        scope.cancel()
    }

    // === toggles =========================================================

    override fun setProxyEnabled(on: Boolean) {
        Prefs(ctx).setAppEnabled(on)
        appendLog(if (on) "⏻ прокси включён — открываю порты" else "⏻ прокси отключён — закрываю порты")
        applyRelayState()
        pushImmediate()
    }

    override fun setScanEnabled(on: Boolean) {
        Prefs(ctx).setScanEnabled(on)
        // Abort in-flight subscription downloads / host probes at once when scan
        // is turned off (CheckRunner + PageScanner poll ScanGate); clear when on.
        // Flip the gate + push the UI BEFORE anything else so OFF reacts instantly
        // instead of waiting for the next mainsLoop tick.
        io.autoconnector.engine.core.ScanGate.setAborted(!on)
        if (!on) {
            // Clear the ping / threads gauges promptly so the graphs drop to 0
            // instead of holding stale values after scanning stops.
            io.autoconnector.engine.traffic.ScanPingBuffer.INSTANCE.reset()
            io.autoconnector.engine.traffic.ThreadsBuffer.INSTANCE.reset()
        }
        appendLog(if (on) "✓ фоновое сканирование включено" else "⏸ фоновое сканирование отключено — останавливаю фоновые задачи", LogCat.SCAN)
        applyRelayState()
        pushImmediate()
        // On enable: don't wait for the scheduled loop — kick an immediate pass so
        // the schedule loads and probing starts right away.
        if (on) scope.launch(Dispatchers.IO) { try { checkMains() } catch (_: Throwable) {} }
    }

    /** Starts/stops the relay to match Prefs — the desktop equivalent of
     *  Android's RelayService.applyPrefs(). Idempotent. */
    @Synchronized
    private fun applyRelayState() {
        val p = Prefs(ctx)
        val proxyOn = p.appEnabled()
        if (proxyOn && relayManager == null) {
            try {
                val a = p.relayPortA()
                val b = p.relayPortB()
                RelayStats.reset()
                val m = RelayManager(a, b, store,
                    RelayServer.Listener { /* status lines already flow via RelayLog */ }, ctx)
                m.start()
                relayManager = m
                RelayLog.emit("⏻ релей запущен, порты $a/$b")
            } catch (e: Throwable) {
                appendLog("⚠ ошибка запуска релея: ${e.message}")
                relayManager = null
            }
        } else if (!proxyOn && relayManager != null) {
            try { relayManager?.stop() } catch (_: Throwable) {}
            relayManager = null
            RelayStats.reset()
            RelayLog.emit("⏻ релей остановлен, порты закрыты")
        }
    }

    // === settings ========================================================

    private fun loadSettings() {
        val p = Prefs(ctx)
        _settings.value = EngineSettings(
            portA = p.relayPortA(),
            portB = p.relayPortB(),
            handshakeMode = p.handshakeMode(),
            notificationsEnabled = p.notificationsEnabled(),
            onlyFakeTls = p.onlyFakeTls(),
            proxyModeCode = p.proxyMode().code,
            scanIntervalMin = p.scanIntervalMin(),
            checkIntervalMin = p.checkIntervalMin(),
            checkBatch = p.checkBatch(),
            checkConcurrency = p.checkConcurrency(),
            minRescanMin = p.minRescanMin(),
            speedVpn = p.speedMultiplier(NetworkMode.VPN),
            speedWifi = p.speedMultiplier(NetworkMode.WIFI),
            speedLte = p.speedMultiplier(NetworkMode.LTE),
            speedEthernet = p.speedMultiplier(NetworkMode.ETHERNET),
            speedWp = p.speedMultiplier(NetworkMode.WHITEPAGES),
            subIntervalVpn = p.subIntervalMin(NetworkMode.VPN),
            subIntervalWifi = p.subIntervalMin(NetworkMode.WIFI),
            subIntervalLte = p.subIntervalMin(NetworkMode.LTE),
            subIntervalEthernet = p.subIntervalMin(NetworkMode.ETHERNET),
            subIntervalWp = p.subIntervalMin(NetworkMode.WHITEPAGES),
            scanMode = p.scanModeOverride(),
            adaptiveAliveThreshold = p.adaptiveAliveThreshold(),
            fastSpeedMultiplier = p.fastSpeedMultiplier(),
            lazyAliveThreshold = p.lazyAliveThreshold(),
            lazySpeedMultiplier = p.lazySpeedMultiplier(),
            wifiOnly = p.wifiOnly(),
            chargingOnly = p.chargingOnly(),
            skipLowBattery = p.skipLowBattery(),
            dpiApplyRelay = p.dpiApplyRelay(),
            dpiApplyProbes = p.dpiApplyProbes(),
            dpiApplyDirect = p.dpiApplyDirect(),
            proxyLinkHttp = p.proxyLinkHttp(),
            langCode = p.lang(),
            expEngineMode = p.expEngineMode(),
            netLogEnabled = p.netLogEnabled(),
            relayConnectMode = p.relayConnectMode(),
        )
    }

    override fun updateSettings(s: EngineSettings) {
        val p = Prefs(ctx)
        val old = _settings.value
        val scanModeChanged = old.scanMode != s.scanMode
        // Did anything that affects scan intensity (period/batch/threads) change?
        // If so we abort the in-flight pass below so the new — often LOWER —
        // intensity takes effect at once instead of the old high-thread batch
        // grinding on for minutes.
        val scanTuningChanged = old.checkBatch != s.checkBatch || old.checkConcurrency != s.checkConcurrency ||
            old.checkIntervalMin != s.checkIntervalMin || old.scanIntervalMin != s.scanIntervalMin ||
            old.speedVpn != s.speedVpn || old.speedWifi != s.speedWifi || old.speedLte != s.speedLte ||
            old.speedEthernet != s.speedEthernet || old.speedWp != s.speedWp ||
            old.adaptiveAliveThreshold != s.adaptiveAliveThreshold || old.fastSpeedMultiplier != s.fastSpeedMultiplier ||
            old.lazyAliveThreshold != s.lazyAliveThreshold || old.lazySpeedMultiplier != s.lazySpeedMultiplier ||
            old.minRescanMin != s.minRescanMin
        p.setRelayPortA(s.portA)
        p.setRelayPortB(s.portB)
        p.setHandshakeMode(s.handshakeMode)
        p.setNotificationsEnabled(s.notificationsEnabled)
        p.setOnlyFakeTls(s.onlyFakeTls)
        Prefs.ProxyMode.fromCode(s.proxyModeCode)?.let { p.setProxyMode(it) }
        p.setScanIntervalMin(s.scanIntervalMin)
        p.setCheckIntervalMin(s.checkIntervalMin)
        p.setCheckBatch(s.checkBatch)
        p.setCheckConcurrency(s.checkConcurrency)
        p.setMinRescanMin(s.minRescanMin)
        p.setSpeedMultiplier(NetworkMode.VPN, s.speedVpn)
        p.setSpeedMultiplier(NetworkMode.WIFI, s.speedWifi)
        p.setSpeedMultiplier(NetworkMode.LTE, s.speedLte)
        p.setSpeedMultiplier(NetworkMode.ETHERNET, s.speedEthernet)
        p.setSpeedMultiplier(NetworkMode.WHITEPAGES, s.speedWp)
        p.setSubIntervalMin(NetworkMode.VPN, s.subIntervalVpn)
        p.setSubIntervalMin(NetworkMode.WIFI, s.subIntervalWifi)
        p.setSubIntervalMin(NetworkMode.LTE, s.subIntervalLte)
        p.setSubIntervalMin(NetworkMode.ETHERNET, s.subIntervalEthernet)
        p.setSubIntervalMin(NetworkMode.WHITEPAGES, s.subIntervalWp)
        p.setScanModeOverride(s.scanMode)
        p.setAdaptiveAliveThreshold(s.adaptiveAliveThreshold)
        p.setFastSpeedMultiplier(s.fastSpeedMultiplier)
        p.setLazyAliveThreshold(s.lazyAliveThreshold)
        p.setLazySpeedMultiplier(s.lazySpeedMultiplier)
        p.setWifiOnly(s.wifiOnly)
        p.setChargingOnly(s.chargingOnly)
        p.setSkipLowBattery(s.skipLowBattery)
        p.setDpiApplyRelay(s.dpiApplyRelay)
        p.setDpiApplyProbes(s.dpiApplyProbes)
        p.setDpiApplyDirect(s.dpiApplyDirect)
        p.setProxyLinkHttp(s.proxyLinkHttp)
        p.setLang(s.langCode)
        p.setExpEngineMode(s.expEngineMode)
        p.setNetLogEnabled(s.netLogEnabled)
        p.setRelayConnectMode(s.relayConnectMode)
        NetLog.setEnabled(s.netLogEnabled)
        // Re-apply the manual mode override when the user changed it here, and
        // seed-scan the freshly selected mode if its pool is thin.
        if (scanModeChanged) {
            NetworkMonitor.setManualMode(if (s.scanMode == "auto") null else NetworkMode.fromCode(s.scanMode))
            scope.launch(Dispatchers.IO) { onModeSwitched(NetworkMonitor.currentMode()) }
        }
        loadSettings()
        // Intensity changed → abort the running probe pass so the next one (≈1 s
        // later) picks up the new period/batch/threads. Otherwise the old, often
        // much larger, batch keeps its threads busy for a long time.
        if (scanTuningChanged) {
            scope.launch(Dispatchers.IO) {
                io.autoconnector.engine.core.ScanGate.setProbesPaused(true)
                kotlinx.coroutines.delay(400)
                io.autoconnector.engine.core.ScanGate.setProbesPaused(false)
                appendLog("⚙ интенсивность изменена — текущий проход прерван, перезапуск", LogCat.SCAN)
            }
        }
        // Ports may have changed — restart the relay if it's running.
        if (p.appEnabled()) {
            try { relayManager?.stop() } catch (_: Throwable) {}
            relayManager = null
            applyRelayState()
        }
        appendLog("⚙ настройки сохранены")
    }

    override fun handshakeModeLabels(): List<String> =
        HandshakeMode.values().map { it.label }

    override fun handshakeOptions(): List<HandshakeOption> {
        val auto = HandshakeMode.AUTO_RANDOM
        val normal = HandshakeMode.NORMAL
        val working = HandshakeMode.values().filter { it.isWorking }
        val rest = working.filter { it != auto && it != normal }
        val ordered = ArrayList<HandshakeMode>()
        ordered.add(auto); ordered.add(normal); ordered.addAll(rest)
        return ordered.map { m ->
            val label = when (m) {
                auto -> "Авто-перебор DPI-трюков"
                normal -> "Без DPI-трюков (обычный)"
                else -> m.label
            }
            HandshakeOption(m.ordinal, label, m == auto || m == normal)
        }
    }

    override fun expEngineOptions(): List<ExpEngineOption> =
        WireShaper.displayOrder().map { ExpEngineOption(it.code, it.label, it.description) }

    override fun connectEngineOptions(): List<ExpEngineOption> =
        RelayConnectMode.values().map { ExpEngineOption(it.code, it.label, it.description) }

    override fun scanParamsFor(checkMin: Int, batch: Int, concurrency: Int, mult: Float): ScanParams {
        val sec = Prefs.effectiveCheckSec(checkMin, mult)
        return ScanParams(
            intervalSec = sec,
            batch = Prefs.effectiveBatch(batch, mult),
            concurrency = Prefs.effectiveConcurrency(concurrency, mult),
            continuous = sec <= 0,
            disabled = Prefs.scanDisabledFor(mult),
        )
    }

    override fun netLogPath(): String? = NetLog.file()?.absolutePath

    override fun openNetLogFolder() {
        try {
            val f = NetLog.file() ?: return
            val dir = f.parentFile ?: return
            dir.mkdirs()
            java.awt.Desktop.getDesktop().open(dir)
        } catch (t: Throwable) {
            appendLog("⚠ не удалось открыть папку лога: ${t.message}")
        }
    }

    override fun handshakeStats(): List<HandshakeStatRow> =
        HandshakeMode.values()
            .filter { it.isWorking && HandshakeStats.attempts(it) > 0 }
            .sortedByDescending { HandshakeStats.score(it) }
            .map { m ->
                val att = HandshakeStats.attempts(m)
                val hsk = HandshakeStats.handshakes(m)
                HandshakeStatRow(
                    label = m.label,
                    attempts = att,
                    handshakes = hsk,
                    tgConnected = HandshakeStats.tgConnected(m),
                    over10k = HandshakeStats.over10k(m),
                    over100k = HandshakeStats.over100k(m),
                    over1m = HandshakeStats.over1min(m),
                    over5m = HandshakeStats.over5min(m),
                    activeHuman = Durations.human(HandshakeStats.qualifiedActiveMs(m) / 1000),
                    trafficHuman = TrafficMeter.human(HandshakeStats.totalBytes(m)),
                    score = HandshakeStats.score(m),
                    hsRatePct = if (att > 0) ((hsk * 100) / att).toInt() else 0,
                )
            }

    override fun resetStats() {
        HandshakeStats.resetAll()
        appendLog("⚙ статистика хитростей сброшена")
    }

    override fun resetCatalogStats() {
        store.resetCatalogStats()
        HandshakeStats.resetAll()
        appendLog("⚙ каталог и статистика сброшены (хосты и подписки сохранены)", LogCat.SCAN)
    }

    override fun clearDownloadedHosts() {
        store.clearDownloadedHosts()
        // Subscriptions are kept, but their download history is wiped so the UI
        // honestly shows "never / zeros" — and so the pool isn't considered
        // "already fetched". Then kick an immediate intensive re-download
        // instead of waiting for a restart (the pool is empty right now).
        store.resetSourceStats()
        appendLog("⚙ список скачанных хостов очищен — подписки обнулены, качаю заново", LogCat.SCAN)
        refreshCatalog(); refreshSources()
        scope.launch(Dispatchers.IO) {
            try { if (Prefs(ctx).scanEnabled()) aggressiveBootstrap() }
            catch (t: Throwable) { appendLog("⚠ re-bootstrap: ${t.message}", LogCat.SCAN) }
            finally { refreshCatalog(); refreshSources() }
        }
    }

    override fun appInfo(): AppInfo = AppInfo(
        version = DESKTOP_VERSION,
        // Stamped into the launcher (.bat passes -Dautoconnector.build=…, using
        // '_' for spaces to avoid batch quoting); shows when this portable build
        // was packaged. Falls back to "—" for dev runs.
        buildDate = System.getProperty("autoconnector.build")?.takeIf { it.isNotBlank() }
            ?.replace('_', ' ') ?: "—",
    )

    // === catalog actions =================================================

    override fun pin(id: Long, pinned: Boolean) {
        if (RelayManager.INSTANCE == null) {
            appendLog("⚠ релей не запущен — закрепление недоступно")
            return
        }
        val entry = store.proxiesByIds(listOf(id)).firstOrNull()
        RelayManager.pinUpstream(if (pinned) entry else null)
        refreshCatalog()
    }

    /** tg:// → https://t.me/… when the user picked the http link format. */
    private fun fmtLink(tg: String): String =
        if (Prefs(ctx).proxyLinkHttp()) tg.replaceFirst("tg://", "https://t.me/") else tg

    override fun tgLink(id: Long): String? =
        store.proxiesByIds(listOf(id)).firstOrNull()?.tgLink()?.let { fmtLink(it) }

    override fun copyToClipboard(text: String) {
        try {
            Toolkit.getDefaultToolkit().systemClipboard
                .setContents(StringSelection(text), null)
            appendLog("· скопировано в буфер")
        } catch (t: Throwable) {
            appendLog("⚠ не удалось скопировать")
        }
    }

    override fun openLink(url: String) {
        // Desktop.browse only handles http/https/mailto — a tg:// link would open
        // an empty browser. Launch the OS protocol handler so tg:// reaches the
        // registered Telegram client; https still opens the browser → t.me.
        val os = System.getProperty("os.name", "").lowercase()
        try {
            when {
                os.contains("win") -> ProcessBuilder("rundll32", "url.dll,FileProtocolHandler", url).start()
                os.contains("mac") -> ProcessBuilder("open", url).start()
                else -> ProcessBuilder("xdg-open", url).start()
            }
            appendLog("· открываю: $url")
        } catch (t: Throwable) {
            try { java.awt.Desktop.getDesktop().browse(java.net.URI(url)) }
            catch (_: Throwable) { appendLog("⚠ не удалось открыть: $url") }
        }
    }

    override fun requestNotifications() {
        // Desktop has no per-app notification permission to request.
    }

    // === sources =========================================================

    override fun addSource(url: String) {
        store.upsertSource(url)
        refreshSources()
        appendLog("✓ источник добавлен: $url", LogCat.SUBS)
    }

    override fun removeSource(id: Long) {
        store.deleteSource(id)
        refreshSources()
    }

    override fun addSourcesBulk(urls: String): Int {
        var n = 0
        urls.lines().map { it.trim() }
            .filter { it.startsWith("http://") || it.startsWith("https://") }
            .forEach { store.upsertSource(it); n++ }
        if (n > 0) { refreshSources(); appendLog("✓ добавлено подписок: $n", LogCat.SUBS) }
        return n
    }

    override fun addManualProxies(text: String): Int {
        val list = ProxyParser.parse(text, "manual:fixed", ProxyType.SOCKS5)
        val added = store.addAll(list)
        if (list.isNotEmpty()) {
            refreshSources()
            appendLog("✓ добавлено прокси (фикс-список): $added из ${list.size}", LogCat.SUBS)
        }
        return added
    }

    override fun setSourceEnabled(id: Long, enabled: Boolean) {
        store.setSourceEnabled(id, enabled)
        refreshSources()
    }

    override fun refreshSource(id: Long) {
        // Out-of-queue: its own IO coroutine, independent of the scan schedule.
        scope.launch(Dispatchers.IO) {
            val url = _sources.value.firstOrNull { it.id == id }?.url ?: return@launch
            io.autoconnector.engine.core.ScanGate.setAborted(false)
            downloadingSince[id] = System.currentTimeMillis()
            refreshSources()   // show "Загружаю…" at once
            appendLog("⤓ обновляю подписку: $url", LogCat.SUBS)
            try {
                val scanner = PageScanner(store, PageScanner.Log { line -> appendLog(line, LogCat.SUBS) })
                val r = scanner.scanPage(url)
                val sid = store.upsertSource(url)
                if (sid > 0) { store.markSourceRefreshed(sid); store.setSourceScanResult(sid, r.found, r.bytes, r.error) }
                appendLog("⤓ подписка обновлена: найдено ${r.found}" + (if (r.error != null) " (${r.error})" else ""), LogCat.SUBS)
            } catch (t: Throwable) { appendLog("⚠ обновление подписки: ${t.message}", LogCat.SUBS) }
            finally { downloadingSince.remove(id); refreshSources() }
        }
    }

    override fun exportAliveLinks(): List<String> =
        store.topAlive(2000).map { fmtLink(it.tgLink()) }

    override fun exportLinksToFile(): String? {
        val links = exportAliveLinks()
        if (links.isEmpty()) return null
        return try {
            val home = System.getProperty("user.home") ?: dataDir.absolutePath
            val f = java.io.File(home, "autoconnector_proxies.txt")
            f.writeText(links.joinToString("\n"))
            appendLog("⤓ экспортировано ${links.size} ссылок → ${f.absolutePath}")
            f.absolutePath
        } catch (e: Throwable) {
            appendLog("⚠ экспорт в файл не удался: ${e.message}")
            null
        }
    }

    // --- backup: export / import (universal JSON) --------------------------

    override fun exportBackup(settings: Boolean, subs: Boolean, hosts: Boolean): String {
        return try {
            val root = LinkedHashMap<String, Any?>()
            root["app"] = "AutoConnectorForTelegram"
            root["v"] = 1
            if (settings) root["settings"] = Prefs(ctx).exportSettings()
            if (subs) {
                val arr = ArrayList<Any?>()
                for (s in store.listSources()) {
                    val m = LinkedHashMap<String, Any?>()
                    m["url"] = s.url
                    m["enabled"] = s.enabled
                    arr.add(m)
                }
                root["subscriptions"] = arr
            }
            if (hosts) root["hosts"] = collectHostsForBackup()
            val json = io.autoconnector.engine.io.Json.encode(root)
            val f = chooseBackupFile("autoconnector_backup.json", true)
                ?: return "Экспорт отменён"
            f.writeText(json)
            val parts = ArrayList<String>()
            if (settings) parts.add("настройки")
            if (subs) parts.add("подписки")
            if (hosts) parts.add("хосты")
            appendLog("⤓ бэкап (${parts.joinToString(", ")}) → ${f.absolutePath}", LogCat.OTHER)
            "✓ Сохранено: ${f.name} — ${parts.joinToString(", ")}"
        } catch (t: Throwable) {
            "⚠ Ошибка экспорта: ${t.message}"
        }
    }

    private fun collectHostsForBackup(): List<Any?> {
        val out = ArrayList<Any?>()
        for (p in store.aliveHostsAnyMode()) {
            val h = LinkedHashMap<String, Any?>()
            h["host"] = p.host
            h["port"] = p.port
            h["type"] = p.type.name
            h["secret"] = p.secret
            h["source"] = p.source
            val modes = LinkedHashMap<String, Any?>()
            for ((mode, st) in store.modeStatsAll(p.id)) {
                if (st.lastCheck <= 0 && !st.alive) continue   // skip never-probed modes
                val ms = LinkedHashMap<String, Any?>()
                ms["alive"] = st.alive
                ms["rtt"] = st.rttMs
                ms["score"] = st.score
                ms["successes"] = st.successes
                ms["failures"] = st.failures
                ms["lastCheck"] = st.lastCheck
                ms["lastOk"] = st.lastOk
                ms["tg"] = st.tgConnections
                ms["sessionMs"] = st.totalSessionMs
                ms["bytes"] = st.bytesRelayed
                modes[mode.code] = ms
            }
            h["modes"] = modes
            out.add(h)
        }
        return out
    }

    override fun importBackup(settings: Boolean, subs: Boolean, hosts: Boolean): String {
        return try {
            val f = chooseBackupFile("autoconnector_backup.json", false)
                ?: return "Импорт отменён"
            val root = io.autoconnector.engine.io.Json.parseObject(f.readText())
            val done = ArrayList<String>()
            (root["settings"] as? Map<*, *>)?.let { m ->
                if (settings) {
                    val sm = LinkedHashMap<String, String>()
                    for ((k, v) in m) if (k != null) sm[k.toString()] = v?.toString() ?: ""
                    val n = Prefs(ctx).importSettings(sm)
                    done.add("настройки ($n)")
                }
            }
            (root["subscriptions"] as? List<*>)?.let { list ->
                if (subs) {
                    var n = 0
                    for (item in list) {
                        val mm = item as? Map<*, *> ?: continue
                        val url = mm["url"]?.toString() ?: continue
                        val id = store.upsertSource(url)
                        val en = mm["enabled"]
                        if (id > 0 && en is Boolean) store.setSourceEnabled(id, en)
                        n++
                    }
                    refreshSources()
                    done.add("подписки ($n)")
                }
            }
            (root["hosts"] as? List<*>)?.let { list ->
                if (hosts) {
                    var n = 0
                    for (item in list) {
                        val mm = item as? Map<*, *> ?: continue
                        val host = mm["host"]?.toString() ?: continue
                        val port = (mm["port"] as? Double)?.toInt() ?: continue
                        val type = try { ProxyType.valueOf(mm["type"]?.toString() ?: "MTPROTO") }
                            catch (_: Throwable) { ProxyType.MTPROTO }
                        val entry = ProxyEntry(type, host, port, mm["secret"]?.toString(), mm["source"]?.toString())
                        val id = store.importHost(entry)
                        if (id <= 0) continue
                        (mm["modes"] as? Map<*, *>)?.forEach { (mc, mv) ->
                            val ms = mv as? Map<*, *> ?: return@forEach
                            store.importModeStats(
                                id, mc.toString(),
                                (ms["alive"] as? Boolean) ?: false,
                                (ms["rtt"] as? Double)?.toInt() ?: -1,
                                (ms["score"] as? Double) ?: 0.0,
                                (ms["successes"] as? Double)?.toInt() ?: 0,
                                (ms["failures"] as? Double)?.toInt() ?: 0,
                                (ms["lastCheck"] as? Double)?.toLong() ?: 0L,
                                (ms["lastOk"] as? Double)?.toLong() ?: 0L,
                                (ms["tg"] as? Double)?.toLong() ?: 0L,
                                (ms["sessionMs"] as? Double)?.toLong() ?: 0L,
                                (ms["bytes"] as? Double)?.toLong() ?: 0L,
                            )
                        }
                        n++
                    }
                    refreshCatalog(); refreshSources()
                    done.add("хосты ($n)")
                }
            }
            if (done.isEmpty()) "⚠ В файле нет выбранных разделов"
            else { appendLog("⤒ импорт: ${done.joinToString(", ")}", LogCat.OTHER); "✓ Импортировано: ${done.joinToString(", ")}" }
        } catch (t: Throwable) {
            "⚠ Ошибка импорта: ${t.message}"
        }
    }

    /** Native save/open dialog; falls back to a fixed file in the user's home
     *  dir if no AWT dialog is available. Returns null only when cancelled. */
    private fun chooseBackupFile(defaultName: String, save: Boolean): java.io.File? {
        return try {
            val fd = java.awt.FileDialog(
                null as java.awt.Frame?,
                if (save) "Сохранить бэкап AutoConnector" else "Открыть бэкап AutoConnector",
                if (save) java.awt.FileDialog.SAVE else java.awt.FileDialog.LOAD,
            )
            if (save) fd.file = defaultName
            fd.isVisible = true
            val name = fd.file ?: return null
            java.io.File(fd.directory ?: ".", name)
        } catch (_: Throwable) {
            val home = System.getProperty("user.home") ?: dataDir.absolutePath
            java.io.File(home, defaultName)
        }
    }

    override fun factoryReset() {
        scope.launch(Dispatchers.IO) {
            try {
                appendLog("⚙ полный сброс к заводским настройкам…", LogCat.SCAN)
                io.autoconnector.engine.core.ScanGate.setAborted(true)
                // 1) settings → defaults
                Prefs(ctx).clearAll()
                Prefs.SHIPPED_EXP_ENGINE = 0
                Prefs(ctx).applyShippedDefaultsOnce()
                // 2) wipe host pool + restore the shipped subscription set, then
                //    re-seed the bundled starting pool so the Catalog isn't empty
                //    until the subscriptions finish downloading (same as first run).
                store.clearDownloadedHosts()
                for (s in store.listSources()) store.deleteSource(s.id)
                store.ensureDefaultSources()
                store.resetSourceStats()
                // 3) reset live graph buffers
                io.autoconnector.engine.traffic.ScanPingBuffer.INSTANCE.reset()
                io.autoconnector.engine.traffic.LatencyBuffer.INSTANCE.reset()
                io.autoconnector.engine.traffic.ScanMetrics.INSTANCE.reset()
                // 4) re-apply fresh state + refresh UI, then re-bootstrap
                io.autoconnector.engine.core.ScanGate.setAborted(false)
                loadSettings(); applyRelayState()
                refreshCatalog(); refreshSources(); pushImmediate()
                if (Prefs(ctx).scanEnabled()) aggressiveBootstrap()
                appendLog("✓ сброшено к заводским настройкам — как при первом запуске", LogCat.SCAN)
            } catch (t: Throwable) {
                appendLog("⚠ factory reset: ${t.message}", LogCat.SCAN)
            }
        }
    }

    override fun refreshNow() {
        scope.launch(Dispatchers.IO) { scanAndCheck() }
    }

    // === per-network-mode (VPN / Wi-Fi / LTE / WhitePages) ================

    /** Re-entrancy guard so overlapping mode switches don't stack seed-scans. */
    private val modeSwitchBusy = java.util.concurrent.atomic.AtomicBoolean(false)

    override fun setScanMode(mode: String) {
        Prefs(ctx).setScanModeOverride(mode)
        NetworkMonitor.setManualMode(if (mode == "auto") null else NetworkMode.fromCode(mode))
        loadSettings()
        pushImmediate()
        scope.launch(Dispatchers.IO) { onModeSwitched(NetworkMonitor.currentMode()) }
    }

    /** When the effective mode changes (auto-detected or user-forced) and that
     *  mode has a thin rated pool, run an intensive SEED scan: probe the best
     *  hosts known for the OTHER reportable modes (good candidates), then the
     *  per-mode due list — the probes auto-record under the now-current mode. */
    private fun onModeSwitched(mode: NetworkMode) {
        if (mode == NetworkMode.UNKNOWN) { refreshCatalog(); return }
        if (!modeSwitchBusy.compareAndSet(false, true)) return
        try {
            val alive = store.aliveCountForMode(mode)
            if (alive < 20) {
                appendLog("⟳ режим ${mode.label}: живых $alive (<20) — интенсивный сид-скан", LogCat.SCAN)
                io.autoconnector.engine.core.ScanGate.setAborted(false)
                // Seed candidates from the best hosts of every OTHER mode.
                val seed = LinkedHashMap<Long, ProxyEntry>()
                for (other in NetworkMode.reportable()) {
                    if (other == mode) continue
                    for (e in store.topAliveForMode(other, 80)) seed[e.id] = e
                }
                val p = Prefs(ctx)
                val runner = CheckRunner(store, CheckRunner.Log { line -> appendLog(line, LogCat.SCAN) }, 100)
                runner.setProbeMode(if (p.dpiApplyProbes()) HandshakeMode.fromOrdinal(p.handshakeMode()) else HandshakeMode.NORMAL)
                if (seed.isNotEmpty()) runner.runOn(ArrayList(seed.values), "seed-${mode.code}")
                runner.runOn(store.dueForCheckForMode(mode, 600), "due-${mode.code}")
                appendLog("⟳ сид-скан ${mode.label} готов: живых ${store.aliveCountForMode(mode)}", LogCat.SCAN)
            }
        } catch (t: Throwable) {
            appendLog("⚠ сид-скан режима ${mode.label}: ${t.message}", LogCat.SCAN)
        } finally {
            modeSwitchBusy.set(false)
            refreshCatalog()
        }
    }

    override fun catalogForMode(modeCode: String): List<CatalogItem> {
        // auto / unknown → the same global list refreshCatalog() shows.
        if (modeCode == "auto" || modeCode == "unk")
            return mapCatalogGlobal(store.top(50))
        val mode = NetworkMode.fromCode(modeCode)
        val now = System.currentTimeMillis()
        val nums = HashMap<Long, Int>()
        var i = 1
        for (s in store.listSources()) nums[s.id] = i++
        val liveIds = HashSet<Long>()
        for (c in RelayStats.liveConnections()) liveIds.add(c.upstreamProxyId)
        val sticky = RelayManager.currentStickyProxyIds()
        val pinnedId = RelayManager.currentPinnedId()
        return store.topForMode(mode, 50).map { p ->
            val ms = store.modeStatsOf(p.id, mode)
            val score = ms?.score ?: 0.0
            val mAlive = ms?.alive == true
            val lastChk = ms?.lastCheck ?: 0L
            val lastOk = ms?.lastOk ?: 0L
            val tgConns = ms?.tgConnections ?: 0L
            val bytes = ms?.bytesRelayed ?: 0L
            val sessMs = ms?.totalSessionMs ?: 0L
            val srcId = store.primarySourceId(p.id)
            val tls = if (p.isFakeTls) FakeTlsClient.domainFromSecret(p.secret) else null
            CatalogItem(
                id = p.id,
                host = hostLabel(p),
                typeLabel = typeLabel(p),
                rating = if (!mAlive || score <= 0.0) 0 else minOf(9, maxOf(1, (score / 10.0).toInt())),
                alive = lastChk > 0 && mAlive,
                live = liveIds.contains(p.id),
                pinned = pinnedId == p.id,
                sticky = pinnedId != p.id && sticky.contains(p.id),
                everServed = tgConns > 0,
                sourceNum = if (srcId > 0) nums[srcId] else null,
                checkedMinsAgo = if (lastChk > 0) (now - lastChk) / 60_000 else -1,
                tgConnectMinsAgo = if (lastOk > 0) (now - lastOk) / 60_000 else -1,
                successes = ms?.successes ?: 0,
                failures = ms?.failures ?: 0,
                tgConnections = tgConns,
                bytesRelayed = bytes,
                bytesRelayedHuman = TrafficMeter.human(bytes),
                sessionTotalHuman = if (sessMs > 0) Durations.human(sessMs / 1000) else "—",
                rttMs = ms?.rttMs ?: -1,
                secret = p.secret,
                tlsDomain = tls?.takeIf { it.isNotEmpty() },
                port = p.port,
                lastErrorShort = p.lastError?.takeIf { it.isNotBlank() }?.let { if (it.length > 40) it.substring(0, 39) + "…" else it },
            )
        }
    }

    override fun exportAliveLinksForMode(modeCode: String): List<String> {
        val list = if (modeCode == "auto" || modeCode == "unk")
            store.topAlive(2000)
        else store.topAliveForMode(NetworkMode.fromCode(modeCode), 2000)
        return list.map { fmtLink(it.tgLink()) }
    }

    override fun exportLinksToFileForMode(modeCode: String): String? {
        val links = exportAliveLinksForMode(modeCode)
        if (links.isEmpty()) return null
        return try {
            val home = System.getProperty("user.home") ?: dataDir.absolutePath
            val f = java.io.File(home, "autoconnector_proxies_$modeCode.txt")
            f.writeText(links.joinToString("\n"))
            appendLog("⤓ экспортировано ${links.size} ссылок ($modeCode) → ${f.absolutePath}")
            f.absolutePath
        } catch (e: Throwable) {
            appendLog("⚠ экспорт в файл не удался: ${e.message}")
            null
        }
    }

    override fun resetModeStats(modeCode: String) {
        store.resetModeStats(NetworkMode.fromCode(modeCode))
        appendLog("⚙ рейтинг хостов режима «$modeCode» обнулён", LogCat.SCAN)
        refreshCatalog()
        pushImmediate()
    }

    override fun forgetModeHosts(modeCode: String) {
        store.forgetModeHosts(NetworkMode.fromCode(modeCode))
        appendLog("⚙ хосты режима «$modeCode» забыты", LogCat.SCAN)
        refreshCatalog()
        pushImmediate()
    }

    override fun copyModeStats(fromCode: String, toCode: String) {
        store.copyModeStats(NetworkMode.fromCode(fromCode), NetworkMode.fromCode(toCode))
        appendLog("⚙ режим $toCode ← копия рейтинга из $fromCode", LogCat.SCAN)
        refreshCatalog()
        pushImmediate()
    }

    // --- global hotkeys ---------------------------------------------------
    private val hotkeys by lazy {
        DesktopHotkeys(
            onCopy = {
                val links = exportAliveLinks()
                if (links.isNotEmpty()) {
                    copyToClipboard(links.random())
                    appendLog("⌨ хоткей: tg-ссылка скопирована в буфер")
                }
            },
            onOpen = {
                val links = exportAliveLinks()
                if (links.isNotEmpty()) {
                    openLink(links.random())
                    appendLog("⌨ хоткей: открываю прокси в Telegram")
                }
            },
        )
    }

    private fun isMac() = System.getProperty("os.name", "").lowercase().contains("mac")

    override fun hotkeysSupported() = true
    override fun hotkeysEnabled() = Prefs(ctx).hotkeysEnabled()
    override fun setHotkeysEnabled(on: Boolean) {
        Prefs(ctx).setHotkeysEnabled(on)
        hotkeys.apply(on, Prefs(ctx).hotkeyLetter())
    }
    override fun hotkeyLetter() = Prefs(ctx).hotkeyLetter()
    override fun setHotkeyLetter(letter: String) {
        Prefs(ctx).setHotkeyLetter(letter)
        hotkeys.apply(Prefs(ctx).hotkeysEnabled(), Prefs(ctx).hotkeyLetter())
    }
    // ⌃ Control · ⇧ Shift · ⌥ Option · ⌘ Command on macOS; Windows uses words.
    override fun hotkeyCopyLabel() = (if (isMac()) "⌃⇧⌥ " else "Ctrl + Shift + Alt + ") + Prefs(ctx).hotkeyLetter()
    override fun hotkeyOpenLabel() = (if (isMac()) "⌃⌥⌘ " else "Ctrl + Win + Alt + ") + Prefs(ctx).hotkeyLetter()

    private val scanNowBusy = java.util.concurrent.atomic.AtomicBoolean(false)

    /** Epoch-ms the next scheduled mains pass is expected to start (for the
     *  Scan tab's "next run in N s" countdown). 0 until the loop arms it. */
    @Volatile private var nextCheckAtMs: Long = 0L

    /** Last computed bypass-proxies decision, so a VPN up/down that flips it can
     *  drop live sockets and switch direct-mode promptly. */
    @Volatile private var lastBypass: Boolean = false

    override fun scanNow() {
        // Re-entry guard: ignore extra taps while a manual scan is already in
        // flight, so hammering the button can't stack dozens of 500-host passes.
        if (!scanNowBusy.compareAndSet(false, true)) {
            appendLog("⚡ скан сейчас уже идёт — подождите завершения", LogCat.SCAN)
            return
        }
        scope.launch(Dispatchers.IO) {
            try {
                // Manual scan runs regardless of the toggle — clear any abort flag
                // that an earlier «scan off» may have left set.
                io.autoconnector.engine.core.ScanGate.setAborted(false)
                val list = store.dueForCheck(500)
                if (list.isEmpty()) {
                    appendLog("⚡ скан сейчас: в базе нет прокси — нечего проверять", LogCat.SCAN)
                    return@launch
                }
                appendLog("⚡ скан сейчас: ${list.size} прокси в 50 потоков", LogCat.SCAN)
                val p = Prefs(ctx)
                val runner = CheckRunner(store, CheckRunner.Log { line -> appendLog(line, LogCat.SCAN) }, 50)
                runner.setProbeMode(if (p.dpiApplyProbes()) HandshakeMode.fromOrdinal(p.handshakeMode()) else HandshakeMode.NORMAL)
                runner.runOn(list, "scan-now")
                appendLog("⚡ скан сейчас готов: живых ${store.countAlive()} / ${store.count()}", LogCat.SCAN)
            } catch (t: Throwable) {
                appendLog("⚠ скан сейчас: ${t.message}", LogCat.SCAN)
            } finally {
                scanNowBusy.set(false)
            }
        }
    }

    // === polling =========================================================

    private suspend fun pollLoop() {
        var i = 0
        while (true) {
            try {
                feedDetectedMode()
                pushState()
                if (i % 4 == 0) { refreshCatalog(); refreshSources() }
            } catch (_: Throwable) {
            }
            i++
            delay(2000)   // graph advances strictly once per 2 s
        }
    }

    /** Desktop has no ConnectivityManager — derive the detected transport from
     *  the [netLabel] emoji string and feed it to [NetworkMonitor] (which only
     *  notifies on an effective-mode change). netLabel() is cached ≥5 s. */
    private fun feedDetectedMode() {
        val detected = when (netLabel()) {
            "🔒 VPN" -> NetworkMode.VPN
            "📶 Wi-Fi" -> NetworkMode.WIFI
            "🌐 Ethernet" -> NetworkMode.ETHERNET
            else -> NetworkMode.UNKNOWN
        }
        NetworkMonitor.setDetectedMode(detected)
    }

    /** Once-a-second ingest so the live sparklines keep filling. */
    private suspend fun sparkLoop() {
        while (true) {
            try {
                val p = Prefs(ctx)
                if (p.appEnabled() || p.scanEnabled()) {
                    SparkBuffer.INSTANCE.tickFromRelay()
                    LatencyBuffer.INSTANCE.tick()
                    CheckRateBuffer.INSTANCE.tick()
                    ConnectBuffer.INSTANCE.tick()
                    io.autoconnector.engine.traffic.ScanPingBuffer.INSTANCE.tick()
                    io.autoconnector.engine.traffic.AliveHistBuffer.INSTANCE.tick(store.aliveCount().toLong())
                    io.autoconnector.engine.traffic.ThreadsBuffer.INSTANCE.tick(io.autoconnector.engine.core.ScanState.probing.size.toLong())
                }
            } catch (_: Throwable) {}
            delay(1000)
        }
    }

    /** Periodic priority probe of the sticky upstreams + an exploration batch,
     *  mirroring RelayService.checkMains() / dynamicCheckInterval(). */
    private suspend fun mainsLoop() {
        // Small initial delay so the first bootstrap pass goes first.
        delay(10_000)
        while (true) {
            try {
                // checkMains() itself early-returns when intensity is disabled.
                if (Prefs(ctx).scanEnabled()) checkMains()
            } catch (_: Throwable) {}
            // Sleep toward the target interval in 1 s steps, recomputing the
            // target each step. Changing scan intensity then takes effect within
            // ~1 s instead of only after the current (possibly long) sleep ends.
            var slept = 0L
            var target = dynamicCheckInterval()
            nextCheckAtMs = System.currentTimeMillis() + target
            while (slept < target) {
                delay(1000)
                slept += 1000
                target = dynamicCheckInterval()
                nextCheckAtMs = System.currentTimeMillis() + (target - slept).coerceAtLeast(0)
            }
        }
    }

    /**
     * Concurrent watcher that pauses ONLY the host-probe passes the moment scan
     * intensity for the current mode crosses past the OFF threshold (schedule
     * «период — отключено, потоки 0»), so an in-flight [checkMains] pass — which
     * runs blocking on the mains loop — collapses within ~1 s instead of running
     * to completion. It sets [io.autoconnector.engine.core.ScanGate.setProbesPaused],
     * which is read by [io.autoconnector.engine.check.CheckRunner] but NOT by the
     * subscription downloader, so subscriptions keep their own cadence and never
     * show "сканирование отключено" just because the host pool is full. The
     * master «Сканирование» toggle still stops everything via ScanGate.aborted.
     */
    private suspend fun probePauseWatcher() {
        while (true) {
            delay(1000)
            val pause = try {
                Prefs(ctx).scanEnabled() && scanIntensityDisabled()
            } catch (_: Throwable) { false }
            io.autoconnector.engine.core.ScanGate.setProbesPaused(pause)
        }
    }

    /** True when the combined scan intensity for the current network / alive
     *  count has been pushed past the OFF threshold (the schedule shows
     *  «период — отключено»). Mirrors [dynamicCheckInterval]. */
    private fun scanIntensityDisabled(): Boolean {
        val prefs = Prefs(ctx)
        val net = NetworkMonitor.currentMode()
        val alive = if (net != NetworkMode.UNKNOWN)
            store.aliveCountForMode(net) else store.aliveCount()
        return Prefs.scanDisabledFor(prefs.currentScanMult(net, alive))
    }

    private fun dynamicCheckInterval(): Long {
        val prefs = Prefs(ctx)
        val net = NetworkMonitor.currentMode()
        val alive = if (net != NetworkMode.UNKNOWN)
            store.aliveCountForMode(net) else store.aliveCount()
        // Base interval is «Проверка, мин», scaled by combined intensity; at
        // max intensity it collapses to 0 → scan continuously (1 s yield loop).
        val mult = prefs.currentScanMult(net, alive)
        // Intensity pushed past the OFF threshold → idle this loop entirely.
        if (Prefs.scanDisabledFor(mult)) return 60_000L
        val sec = Prefs.effectiveCheckSec(prefs.checkIntervalMin(), mult)
        return if (sec <= 0) 1_000L else sec * 1_000L
    }

    /** Periodically re-downloads the enabled subscriptions so a pool that has
     *  drained (deaths, or a manual «очистить хосты») refills on its own. The
     *  cadence shrinks sharply when few proxies are alive — "мало хостов →
     *  качать чаще" — and relaxes once the base is healthy. */
    private suspend fun sourcesLoop() {
        delay(40_000)  // let the first-start bootstrap go first
        while (true) {
            try {
                if (Prefs(ctx).scanEnabled() && store.enabledSourceUrls().isNotEmpty())
                    refreshAllSources()
            } catch (_: Throwable) {}
            var slept = 0L
            val target = sourcesInterval()
            while (slept < target) { delay(2000); slept += 2000 }
        }
    }

    /** Re-download interval (ms), driven by the PER-MODE configured subscription
     *  interval for the CURRENT network mode (vpn/wifi/lte/wp). Floored at 60 s. */
    private fun sourcesInterval(): Long {
        val m = NetworkMonitor.currentMode()
        val min = Prefs(ctx).subIntervalMin(m)
        return maxOf(60_000L, min * 60_000L)
    }

    /**
     * Downloads the given subscription URLs CONCURRENTLY (was strictly
     * sequential — a fresh start with ~30 sources spent minutes before a single
     * host arrived). Each URL still goes through PageScanner's own
     * mirror → direct → anonymizer cascade. Returns the URLs that yielded
     * nothing (every route failed, or no proxies parsed) so the caller can run a
     * retry pass over just those.
     */
    private fun downloadSourcesParallel(urls: List<String>, threads: Int): List<String> {
        if (urls.isEmpty()) return emptyList()
        val scanner = PageScanner(store, PageScanner.Log { line -> appendLog(line, LogCat.SUBS) })
        val failed = java.util.concurrent.CopyOnWriteArrayList<String>()
        val pool = java.util.concurrent.Executors.newFixedThreadPool(threads.coerceIn(1, 24))
        try {
            val futures = urls.map { url ->
                pool.submit(Runnable {
                    if (io.autoconnector.engine.core.ScanGate.isAborted()) {
                        failed.add(url)
                    } else try {
                        val r = scanner.scanPage(url)
                        val id = store.upsertSource(url)
                        if (id > 0) {
                            store.setSourceScanResult(id, r.found, r.bytes, r.error)
                            // Mark "refreshed" ONLY on a real success. Marking it on a
                            // failed/empty download poisoned the never-downloaded flag,
                            // so a fresh install whose first pull failed was treated as
                            // "already fetched" and never re-attempted aggressively.
                            if (r.found > 0 && r.error == null) store.markSourceRefreshed(id)
                        }
                        if (r.found == 0 || r.error != null) failed.add(url)
                    } catch (t: Throwable) {
                        appendLog("⚠ $url — ${t.message}", LogCat.SUBS)
                        failed.add(url)
                    }
                })
            }
            futures.forEach { runCatching { it.get() } }
        } finally {
            pool.shutdownNow()
        }
        return failed.toList()
    }

    /** Keeps re-downloading the subscriptions that have NOT yet yielded anything,
     *  round after round, many threads at a time, through the whole
     *  direct→anonymizer cascade — until they all land, scanning is turned off,
     *  the pass is aborted, or we hit the round cap. A short escalating backoff
     *  between rounds avoids spinning a dead network / rate-limiting anonymizers. */
    private fun downloadAllSourcesPersistently() {
        var pending = store.enabledSourceUrls()
        var round = 0
        val maxRounds = 12
        while (pending.isNotEmpty()
                && Prefs(ctx).scanEnabled()
                && !io.autoconnector.engine.core.ScanGate.isAborted()
                && round < maxRounds) {
            round++
            val threads = if (round == 1) 12 else minOf(16, pending.size)
            appendLog("⇣ закачка подписок, проход $round: ${pending.size} шт × $threads потоков", LogCat.SUBS)
            pending = downloadSourcesParallel(pending, threads)
            appendLog("⇣ проход $round: в базе ${store.count()} прокси, не скачано ${pending.size} подписок", LogCat.SUBS)
            if (pending.isEmpty()) break
            val backoff = minOf(15_000L, 1500L * round)
            var slept = 0L
            while (slept < backoff
                    && !io.autoconnector.engine.core.ScanGate.isAborted()
                    && Prefs(ctx).scanEnabled()) { Thread.sleep(500); slept += 500 }
        }
        if (pending.isNotEmpty())
            appendLog("✗ после $round проходов не скачано ${pending.size} подписок — повторю при следующем запуске", LogCat.SUBS)
    }

    /** Downloads every enabled subscription, in parallel, then retries the ones
     *  that came back empty through the anonymizer chain once. */
    private fun refreshAllSources() {
        val failed = downloadSourcesParallel(store.enabledSourceUrls(), 6)
        if (failed.isNotEmpty() && !io.autoconnector.engine.core.ScanGate.isAborted()) {
            appendLog("↻ повтор ${failed.size} подписок через анонимайзеры", LogCat.SUBS)
            downloadSourcesParallel(failed, minOf(6, failed.size))
        }
        refreshSources()
    }

    private fun checkMains() {
        val ids = RelayManager.currentStickyProxyIds()
        val mains = if (ids.isEmpty()) ArrayList() else store.proxiesByIds(ids)
        // Batch + parallelism scale with the current scan intensity
        // («Размер пачки» / «Параллельно» × per-net × adaptive).
        val prefs = Prefs(ctx)
        val net = NetworkMonitor.currentMode()
        val aliveNow = if (net != NetworkMode.UNKNOWN) store.aliveCountForMode(net) else store.aliveCount()
        val mult = prefs.currentScanMult(net, aliveNow)
        // Intensity past the OFF threshold → skip this tick entirely.
        if (Prefs.scanDisabledFor(mult)) return
        // «Размер пачки» is now PER-THREAD: each of `conc` threads handles ~batch
        // hosts, so a pass probes batch × conc hosts in total.
        val batch = Prefs.effectiveBatch(prefs.checkBatch(), mult)
        val conc = Prefs.effectiveConcurrency(prefs.checkConcurrency(), mult)
        val total = batch * conc
        // Re-probe the hosts most worth checking FOR THE CURRENT MODE so ratings
        // accrue under the right transport; fall back to the global list if mode
        // is unknown. The sticky-ids merge below is preserved.
        // Anti-flood: exclude hosts checked more recently than «мин. период» so a
        // small pool isn't hammered — never-checked hosts always stay eligible.
        val minAgeMs = prefs.minRescanMin() * 60_000L
        val due = if (net != NetworkMode.UNKNOWN) store.dueForCheckForMode(net, total, minAgeMs) else store.dueForCheck(total, minAgeMs)
        val combined = ArrayList(mains)
        for (d in due) if (combined.none { it.id == d.id }) combined.add(d)
        if (combined.isEmpty()) return

        RelayLog.emit("⟳ проверка: главных ${mains.size} + новых ${combined.size - mains.size}")
        val runner = CheckRunner(store, CheckRunner.Log { line -> appendLog(line, LogCat.SCAN) }, minOf(conc, combined.size))
        runner.runOn(combined, "mains+due")

        val after = if (ids.isEmpty()) ArrayList() else store.proxiesByIds(ids)
        var aliveMains = 0
        for (p in after) if (p.alive) aliveMains++
        RelayLog.emit("⟳ главные: $aliveMains/${after.size} · в базе живых: ${store.aliveCount()}")

        relayManager?.refreshStickies()

        if (mains.isNotEmpty() && aliveMains == 0) {
            RelayLog.emit("⚠ все главные мертвы — широкая проверка топ-200")
            val wide = CheckRunner(store, CheckRunner.Log { line -> appendLog(line, LogCat.SCAN) }, 16)
            wide.runOn(store.top(200), "wide-after-cascade")
            relayManager?.refreshStickies()
            RelayLog.emit("⟳ широкая проверка готова · живых: ${store.aliveCount()}")
        }
    }

    private fun pushImmediate() = try { pushState() } catch (_: Throwable) {}

    private fun pushState() {
        val now = System.currentTimeMillis()
        val p = Prefs(ctx)
        val proxyOn = p.appEnabled()
        val scanOn = p.scanEnabled()

        val up = RelayStats.bytesUp.get()
        val down = RelayStats.bytesDown.get()
        val deltaUp = maxOf(0L, up - prevUp)
        val deltaDown = maxOf(0L, down - prevDown)
        prevUp = up; prevDown = down
        if (deltaUp + deltaDown > 0) lastDataAt = now

        val conns = RelayStats.liveConnections()
        // Clamp: a stray accept-counter underflow must never show as a negative
        // socket count or wedge the status in a perpetual "connecting" state.
        val pending = maxOf(0, RelayStats.accepting.get())
        var longestBytes = 0L
        var mostRecentDataAt = 0L
        var firstStart = Long.MAX_VALUE
        var bestConn: RelayStats.LiveConn? = null
        for (c in conns) {
            val b = c.bytesUp.get() + c.bytesDown.get()
            if (b >= longestBytes) { longestBytes = b; bestConn = c }
            val d = c.lastDataAt.get()
            if (d > mostRecentDataAt) mostRecentDataAt = d
            if (c.startedAt < firstStart) firstStart = c.startedAt
        }
        val anyMature = longestBytes >= MATURE_BYTES
        val sessionSec = if (firstStart != Long.MAX_VALUE) (now - firstStart) / 1000 else 0L

        val sessionBytes = up + down
        val tunnelWorks = sessionBytes >= CONNECTED_MIN_BYTES || anyMature
        val recentMs = if (lastDataAt > 0) now - lastDataAt else Long.MAX_VALUE

        val connState: ConnState
        val statusText: String
        val statusSub: String
        when {
            conns.isEmpty() && pending == 0 -> {
                connState = ConnState.OFFLINE
                statusText = "Telegram не подключён"
                val last = p.lastTelegramConnectMs()
                statusSub = if (last > 0) "был ${Durations.human((now - last) / 1000)} назад" else "ждём подключения"
            }
            conns.isNotEmpty() && (tunnelWorks || recentMs <= 20_000) -> {
                connState = ConnState.CONNECTED
                statusText = "Telegram подключён"
                statusSub = "идёт ${Durations.human(sessionSec)} · ${TrafficMeter.human(sessionBytes)}"
            }
            else -> {
                connState = ConnState.CONNECTING
                statusText = "Идёт коннект…"
                statusSub = if (sessionSec > 0) "${Durations.human(sessionSec)} · рукопожатие"
                    else "рукопожатие, сокетов ${conns.size + pending}"
            }
        }

        val latency = if (conns.isEmpty()) "—" else {
            var tot = 0; var n = 0
            for (c in conns) if (c.rttMs > 0) { tot += c.rttMs; n++ }
            if (n > 0) "~${tot / n} мс" else "—"
        }

        val sessions = conns.map { c ->
            val bytes = c.bytesUp.get() + c.bytesDown.get()
            val lastData = c.lastDataAt.get()
            var host = stripPort(c.upstream)
            if (!c.fakeTlsSni.isNullOrEmpty()) host += "→${c.fakeTlsSni}"
            if (host.length > 32) host = host.substring(0, 31) + "…"
            Session(
                host = host,
                connectedFor = Durations.compact((now - c.startedAt) / 1000),
                lastData = if (lastData > 0) Durations.compact((now - lastData) / 1000) else "—",
                traffic = TrafficMeter.human(bytes),
                alive = bytes >= MATURE_BYTES && (now - lastData) < IDLE_THRESHOLD_MS,
            )
        }

        val currentProxy = bestConn?.let { c -> buildProxyInfo(c, p) }
            ?: run {
                val id = RelayManager.currentPinnedId().takeIf { it > 0 }
                    ?: RelayManager.currentStickyProxyIds().firstOrNull()
                val entry = if (id != null && id > 0)
                    store.proxiesByIds(listOf(id)).firstOrNull()
                else store.topAlive(1).firstOrNull()
                entry?.let { buildProxyInfoFromEntry(it, p) }
            }

        val total = store.count()
        val alive = store.countAlive()
        val alive15 = store.countAliveWithinMin(15)
        val dead = store.countDead()
        val checkSums = store.sumCheckCounts()
        val sm = ScanMetrics.INSTANCE

        var srcMin = 0; var srcHour = 0; var srcTotal = 0
        for (src in store.listSources()) {
            srcTotal++
            if (src.lastRefreshAt <= 0) continue
            val age = now - src.lastRefreshAt
            if (age <= 60_000L) srcMin++
            if (age <= 3_600_000L) srcHour++
        }

        val connA = ConnectBuffer.INSTANCE.secondsSnapshotA()
        val connB = ConnectBuffer.INSTANCE.secondsSnapshotB()
        val connAMin = ConnectBuffer.INSTANCE.minutesSnapshotA()
        val connBMin = ConnectBuffer.INSTANCE.minutesSnapshotB()
        val cs = CheckRateBuffer.INSTANCE.secondsSnapshot()
        val cm = CheckRateBuffer.INSTANCE.minutesSnapshot()

        val aLastA = p.lastTelegramConnectPortAMs() > 0
        val bLastB = p.lastTelegramConnectPortBMs() > 0
        val setupNeeded = !(aLastA || bLastB)
        val cta = when {
            !aLastA && !bLastB -> "⚠ Релей ещё не настроен в Telegram"
            !aLastA -> "⚠ Порт ${p.relayPortA()} ещё не виден Telegram"
            !bLastB -> "⚠ Порт ${p.relayPortB()} ещё не виден Telegram"
            else -> null
        }

        // Scan plan (effective, intensity-scaled — the same maths the scheduler
        // uses in checkMains/dynamicCheckInterval) plus the live "now" snapshot.
        val scNet = NetworkMonitor.currentMode()
        val scAlive = if (scNet != NetworkMode.UNKNOWN) store.aliveCountForMode(scNet) else store.aliveCount()
        val scMult = p.currentScanMult(scNet, scAlive)
        val scanOff = Prefs.scanDisabledFor(scMult)
        val planIntervalSec = Prefs.effectiveCheckSec(p.checkIntervalMin(), scMult)
        val planBatch = Prefs.effectiveBatch(p.checkBatch(), scMult)
        val planConc = Prefs.effectiveConcurrency(p.checkConcurrency(), scMult)
        val planNextSec = if (scanOn && nextCheckAtMs > 0)
            ((nextCheckAtMs - now) / 1000L).coerceAtLeast(0L).toInt() else 0
        val scStart = io.autoconnector.engine.core.ScanProgress.startedAtMs()
        val scNowSeconds = if (scStart > 0) ((now - scStart) / 1000L).coerceAtLeast(0L) else 0L

        // Per-mode pool snapshot for the active (effective) network mode. For an
        // unknown mode we fall back to the global alive/dead/total counts.
        val modeAgg = if (scNet != NetworkMode.UNKNOWN) store.aggregateForMode(scNet) else null
        val aliveModeNow = modeAgg?.alive ?: alive
        val deadModeNow = modeAgg?.deadProbed ?: dead
        val totalModeNow = modeAgg?.let { it.alive + it.deadProbed + it.neverProbed } ?: total

        _state.value = EngineState(
            proxyEnabled = proxyOn,
            scanEnabled = scanOn,
            scanRunning = io.autoconnector.engine.core.ScanState.probing.isNotEmpty(),
            netLabel = netLabel(),
            setupNeeded = setupNeeded,
            setupCta = cta,
            portA = p.relayPortA(),
            portB = p.relayPortB(),
            connLiveA = conns.count { it.localPort == p.relayPortA() },
            connLiveB = conns.count { it.localPort == p.relayPortB() },
            connLiveOut = conns.size,
            directOnVpnEnabled = p.proxyMode() == Prefs.ProxyMode.DISABLED_ON_VPN,
            connState = connState,
            statusText = statusText,
            statusSub = statusSub,
            modeBadge = modeBadge(p),
            directMode = p.shouldBypassProxies(),
            directViaVpn = p.proxyMode() == Prefs.ProxyMode.DISABLED_ON_VPN
                    && NetworkMonitor.currentMode() == NetworkMode.VPN,
            directAntiDpi = p.dpiApplyDirect(),
            aliveCount = aliveModeNow,
            aliveWithin15 = alive15,
            totalCount = totalModeNow,
            speedDown = "↓ ${rate(deltaDown)}",
            speedUp = "↑ ${rate(deltaUp)}",
            totalDown = "↓ ${TrafficMeter.human(down)}",
            totalUp = "↑ ${TrafficMeter.human(up)}",
            latency = latency,
            sessions = sessions,
            socketsTgToConnector = maxOf(0, conns.size + pending),
            socketsConnectorToProxy = conns.size,
            currentProxy = currentProxy,
            connCount = conns.size,
            connSeconds = sessionSec,
            deadCount = deadModeNow,
            sourcesRefMin = srcMin,
            sourcesRefHour = srcHour,
            sourcesTotal = srcTotal,
            checkedAllTime = checkSums[0] + checkSums[1],
            aliveAllTime = checkSums[0],
            deadAllTime = checkSums[1],
            subsOkMin = sm.subsOkMin().toInt(),
            subsOkHour = sm.subsOkHour().toInt(),
            subsFailMin = sm.subsFailMin().toInt(),
            subsFailHour = sm.subsFailHour().toInt(),
            scanBytesMin = TrafficMeter.human(sm.bytesMinSum()),
            scanBytesHour = TrafficMeter.human(sm.bytesHourSum()),
            subBytesMin = TrafficMeter.human(sm.subBytesMinSum()),
            subBytesHour = TrafficMeter.human(sm.subBytesHourSum()),
            tgSessAll = HandshakeStats.tgSessionsAll(),
            tgSessOk = HandshakeStats.tgSessionsOk(),
            sessOver1m = HandshakeStats.sessionsOver1m(),
            sessOver5m = HandshakeStats.sessionsOver5m(),
            sessOver15m = HandshakeStats.sessionsOver15m(),
            notificationsOk = true,
            checksOk60s = cs.ok.sum(),
            checksFail60s = cs.fail.sum(),
            checksOk60m = cm.ok.sum(),
            checksFail60m = cm.fail.sum(),
            trafficSec = SparkBuffer.INSTANCE.secondsSnapshot(),
            trafficMin = SparkBuffer.INSTANCE.minutesSnapshot(),
            latencySec = LatencyBuffer.INSTANCE.secondsSnapshot(),
            latencyMin = LatencyBuffer.INSTANCE.minutesSnapshot(),
            connectsASec = connA,
            connectsBSec = connB,
            connectsAMin = connAMin,
            connectsBMin = connBMin,
            connectsPortA = ConnectBuffer.INSTANCE.portA(),
            connectsPortB = ConnectBuffer.INSTANCE.portB(),
            nowSec = now / 1000L,
            nowMin = now / 60000L,
            checkOkSec = cs.ok,
            checkFailSec = cs.fail,
            checkOkMin = cm.ok,
            checkFailMin = cm.fail,
            scanTrafficSec = ScanMetrics.INSTANCE.bytesSecSnapshot(),
            scanTrafficMin = ScanMetrics.INSTANCE.bytesMinSnapshot(),
            subTrafficSec = ScanMetrics.INSTANCE.subBytesSecSnapshot(),
            subTrafficMin = ScanMetrics.INSTANCE.subBytesMinSnapshot(),
            aliveHistSec = io.autoconnector.engine.traffic.AliveHistBuffer.INSTANCE.secondsSnapshot(),
            aliveHistMin = io.autoconnector.engine.traffic.AliveHistBuffer.INSTANCE.minutesSnapshot(),
            scanPingSec = io.autoconnector.engine.traffic.ScanPingBuffer.INSTANCE.secondsSnapshot(),
            scanPingMin = io.autoconnector.engine.traffic.ScanPingBuffer.INSTANCE.minutesSnapshot(),
            threadsSec = io.autoconnector.engine.traffic.ThreadsBuffer.INSTANCE.secondsSnapshot(),
            threadsMin = io.autoconnector.engine.traffic.ThreadsBuffer.INSTANCE.minutesSnapshot(),
            scanPlanIntervalSec = if (scanOff) -1 else planIntervalSec,
            scanPlanNextSec = planNextSec,
            scanPlanConcurrency = if (scanOff) 0 else planConc,
            scanPlanBatch = if (scanOff) 0 else planBatch,
            scanNowThreads = io.autoconnector.engine.core.ScanState.probing.size,
            scanNowBatch = io.autoconnector.engine.core.ScanProgress.currentBatch(),
            scanNowSeconds = scNowSeconds,
            activeMode = scNet.code,
            scanModeManual = !NetworkMonitor.isAuto(),
            aliveMode = aliveModeNow,
            deadMode = deadModeNow,
            totalMode = totalModeNow,
        )
    }

    private fun buildProxyInfo(c: RelayStats.LiveConn, p: Prefs): ProxyInfo {
        val entry = if (c.upstreamProxyId > 0)
            store.proxiesByIds(listOf(c.upstreamProxyId)).firstOrNull() else null
        val host = entry?.host ?: stripPort(c.upstream)
        val port = entry?.port ?: portOf(c.upstream)
        val type = when {
            entry != null && entry.type == ProxyType.MTPROTO -> "MTProto"
            entry != null && entry.type == ProxyType.SOCKS5 -> "SOCKS5"
            c.upstreamMtproto -> "MTProto"
            else -> "SOCKS5"
        }
        val secret = entry?.secret?.let { if (it.length > 20) it.substring(0, 18) + "…" else it }
        val dpi = if (c.upstreamMtproto) {
            val user = HandshakeMode.fromOrdinal(p.handshakeMode())
            if (user == HandshakeMode.AUTO_RANDOM)
                "Авто" + (HandshakeStats.lastUsed()?.let { " → ${it.label}" } ?: "")
            else user.label
        } else "—"
        val obf = obfEngineLabel(entry, c.upstreamMtproto, c.fakeTlsSni?.isNotEmpty() == true)
        return ProxyInfo(host, port, type, c.fakeTlsSni?.takeIf { it.isNotEmpty() }, secret, dpi, obf)
    }

    /** Transport obfuscation engine actually carrying the traffic — distinct
     *  from the anti-DPI TLS-fingerprint trick. ee→FakeTLS, dd→secure-padded,
     *  bare MTProto, or none for SOCKS5. */
    private fun obfEngineLabel(entry: ProxyEntry?, mtproto: Boolean, hasTls: Boolean): String {
        if (entry != null) {
            if (entry.type != ProxyType.MTPROTO) return "нет (SOCKS5)"
            return when {
                entry.isFakeTls -> "FakeTLS (ee)"
                entry.isDdSecret -> "Secure (dd)"
                else -> "MTProto (обычный)"
            }
        }
        if (!mtproto) return "нет (SOCKS5)"
        return if (hasTls) "FakeTLS (ee)" else "MTProto"
    }

    private fun buildProxyInfoFromEntry(entry: ProxyEntry, p: Prefs): ProxyInfo {
        val type = if (entry.type == ProxyType.MTPROTO) "MTProto" else "SOCKS5"
        val tls = if (entry.isFakeTls) FakeTlsClient.domainFromSecret(entry.secret)?.takeIf { it.isNotEmpty() } else null
        val secret = entry.secret?.let { if (it.length > 20) it.substring(0, 18) + "…" else it }
        val dpi = if (entry.type == ProxyType.MTPROTO) {
            val user = HandshakeMode.fromOrdinal(p.handshakeMode())
            if (user == HandshakeMode.AUTO_RANDOM)
                "Авто" + (HandshakeStats.lastUsed()?.let { " → ${it.label}" } ?: "")
            else user.label
        } else "—"
        val obf = obfEngineLabel(entry, entry.type == ProxyType.MTPROTO, tls != null)
        return ProxyInfo(entry.host, entry.port, type, tls, secret, dpi, obf)
    }

    private fun portOf(hp: String?): Int {
        if (hp == null) return 0
        val c = hp.lastIndexOf(':')
        return if (c > 0) hp.substring(c + 1).toIntOrNull() ?: 0 else 0
    }

    private fun modeBadge(p: Prefs): String {
        val net = NetworkMonitor.currentMode()
        if (p.shouldBypassProxies())
            return "Сеть: ${net.label} · прямой выход" + (if (p.dpiApplyDirect()) " · анти-DPI" else "")
        val user = HandshakeMode.fromOrdinal(p.handshakeMode())
        val dpi = if (user == HandshakeMode.AUTO_RANDOM) {
            val last = HandshakeStats.lastUsed()
            "Авто" + (if (last != null) " → ${last.label}" else "")
        } else user.label
        return "Сеть: ${net.label} · Анти-DPI: $dpi"
    }

    // === catalog / sources refresh ======================================

    private fun refreshCatalog() {
        _catalog.value = mapCatalogGlobal(store.top(50))
    }

    /** Maps global proxy rows to [CatalogItem]s (per-mode variant lives in
     *  [catalogForMode]). Pure — no state mutation. */
    private fun mapCatalogGlobal(list: List<ProxyEntry>): List<CatalogItem> {
        val now = System.currentTimeMillis()
        val nums = HashMap<Long, Int>()
        var i = 1
        for (s in store.listSources()) nums[s.id] = i++
        val liveIds = HashSet<Long>()
        for (c in RelayStats.liveConnections()) liveIds.add(c.upstreamProxyId)
        val sticky = RelayManager.currentStickyProxyIds()
        val pinnedId = RelayManager.currentPinnedId()
        return list.map { p ->
            val srcId = store.primarySourceId(p.id)
            val tls = if (p.isFakeTls) FakeTlsClient.domainFromSecret(p.secret) else null
            CatalogItem(
                id = p.id,
                host = hostLabel(p),
                typeLabel = typeLabel(p),
                rating = if (!p.alive || p.score <= 0.0) 0 else minOf(9, maxOf(1, (p.score / 10.0).toInt())),
                alive = p.lastCheck > 0 && p.alive,
                live = liveIds.contains(p.id),
                pinned = pinnedId == p.id,
                sticky = pinnedId != p.id && sticky.contains(p.id),
                everServed = p.lastTgConnectAt > 0 || p.tgConnections > 0,
                sourceNum = if (srcId > 0) nums[srcId] else null,
                checkedMinsAgo = if (p.lastCheck > 0) (now - p.lastCheck) / 60_000 else -1,
                tgConnectMinsAgo = if (p.lastTgConnectAt > 0) (now - p.lastTgConnectAt) / 60_000 else -1,
                successes = p.successes,
                failures = p.failures,
                tgConnections = p.tgConnections,
                bytesRelayed = p.bytesRelayed,
                bytesRelayedHuman = TrafficMeter.human(p.bytesRelayed),
                sessionTotalHuman = if (p.totalSessionMs > 0) Durations.human(p.totalSessionMs / 1000) else "—",
                rttMs = p.rttMs,
                secret = p.secret,
                tlsDomain = tls?.takeIf { it.isNotEmpty() },
                port = p.port,
                lastErrorShort = p.lastError?.takeIf { it.isNotBlank() }?.let { if (it.length > 40) it.substring(0, 39) + "…" else it },
            )
        }
    }

    private fun refreshSources() {
        val now = System.currentTimeMillis()
        _sources.value = store.listSources().mapIndexed { i, s ->
            SourceItem(
                id = s.id,
                seq = i + 1,
                url = s.url,
                enabled = s.enabled,
                alive = s.aliveCount,
                dead = s.deadCount,
                total = s.totalCount,
                bytesHuman = if (s.lastBytes > 0) TrafficMeter.human(s.lastBytes) else "—",
                lastRefreshMinsAgo = if (s.lastRefreshAt > 0) (now - s.lastRefreshAt) / 60000 else -1,
                lastError = s.lastError?.takeIf { it.isNotBlank() },
                downloading = downloadingSince.containsKey(s.id),
                downloadingSec = downloadingSince[s.id]?.let { (now - it) / 1000 } ?: 0,
            )
        }
    }

    private fun hostLabel(p: ProxyEntry): String {
        var h = "${p.host}:${p.port}"
        if (p.isFakeTls) {
            val sni = FakeTlsClient.domainFromSecret(p.secret)
            if (!sni.isNullOrEmpty()) h += "→$sni"
        }
        return h
    }

    private fun typeLabel(p: ProxyEntry): String =
        if (p.type == ProxyType.MTPROTO) {
            if (p.isFakeTls) "ee" else if (p.isDdSecret) "dd" else "MT"
        } else "S5"

    // === bootstrap =======================================================

    private fun autoRefreshOnce() {
        try {
            // Idempotent (CONFLICT_IGNORE on the unique url) — runs every start so
            // newly-shipped default subscriptions reach existing installs too.
            store.ensureDefaultSources()
            val hostBase = store.count()
            // "Never downloaded" = no enabled source has EVER delivered hosts (only
            // a real success sets the refresh timestamp now). A clean install, a
            // post-reset start, or an empty pool → pull the subscriptions HARD and
            // keep retrying through every anonymizer instead of trickling them in.
            val neverDownloaded = store.listSources().none { it.lastRefreshAt > 0 }
            if (neverDownloaded || hostBase < 500) {
                appendLog("— ПЕРВЫЙ ЗАПУСК: агрессивная закачка подписок (хостов в базе $hostBase) —", LogCat.SCAN)
                aggressiveBootstrap()
            } else {
                appendLog("— автозапуск: скан и проверка —", LogCat.SCAN)
                scanAndCheck()
            }
        } catch (t: Throwable) {
            appendLog("⚠ bootstrap: ${t.message}", LogCat.SCAN)
        }
    }

    private fun scanAndCheck() {
        val failed = downloadSourcesParallel(store.enabledSourceUrls(), 6)
        if (failed.isNotEmpty() && !io.autoconnector.engine.core.ScanGate.isAborted()) {
            appendLog("↻ повтор ${failed.size} подписок через анонимайзеры", LogCat.SUBS)
            downloadSourcesParallel(failed, minOf(6, failed.size))
        }
        refreshSources()
        val p = Prefs(ctx)
        val runner = CheckRunner(store, CheckRunner.Log { line -> appendLog(line, LogCat.SCAN) }, p.checkConcurrency())
        runner.setProbeMode(if (p.dpiApplyProbes()) HandshakeMode.fromOrdinal(p.handshakeMode()) else HandshakeMode.NORMAL)
        runner.runBatch(p.checkBatch())
        appendLog("— проверка готова —", LogCat.SCAN)
    }

    /** Fresh start (subscriptions never downloaded AND host base < 2000): pull
     *  every subscription HARD and in parallel, retry whatever failed through the
     *  anonymizer chain, then mass-check whatever landed — so a clean install /
     *  post-reset fills the pool in seconds instead of minutes. */
    private fun aggressiveBootstrap() {
        // Persistent, multi-threaded download: keep retrying whatever STILL hasn't
        // yielded anything — through the full direct→anonymizer cascade — round
        // after round, with a short escalating backoff, until every subscription
        // lands or we run out of rounds. A single retry pass (the old behaviour)
        // gave up after one failure, so a fresh install on a flaky/blocked network
        // ended up with 0 hosts and "silence". This hammers instead.
        downloadAllSourcesPersistently()
        refreshSources()
        val pp = Prefs(ctx)
        val afterScan = store.count()
        appendLog("— bootstrap: собрано $afterScan прокси, массовая проверка —", LogCat.SCAN)
        // Sustained aggressive check: keep probing at near-pool concurrency, in
        // big passes, until the pool has a healthy number of LIVE hosts (or we
        // run out of rounds). Each runBatch takes the next most-overdue hosts, so
        // successive rounds sweep through the whole pool instead of one short
        // burst. This is what the user expects from a fresh start — "мало живых"
        // → hammer the checks — rather than a couple of threads for two minutes.
        val target = pp.adaptiveAliveThreshold()
        val conc = maxOf(24, minOf(Prefs.CONCURRENCY_CAP, store.count() / 40))
        val probeMode = if (pp.dpiApplyProbes()) HandshakeMode.fromOrdinal(pp.handshakeMode()) else HandshakeMode.NORMAL
        var round = 0
        while (round < 8
                && Prefs(ctx).scanEnabled()
                && !io.autoconnector.engine.core.ScanGate.isAborted()
                && store.countAlive() < target
                && store.count() > 0) {
            val runner = CheckRunner(store, CheckRunner.Log { line -> appendLog(line, LogCat.SCAN) }, conc)
            runner.setProbeMode(probeMode)
            runner.runBatch(minOf(store.count(), 600))
            round++
            appendLog("— bootstrap раунд $round: живых ${store.countAlive()} / ${store.count()} —", LogCat.SCAN)
        }
        appendLog("— bootstrap готов: живых ${store.countAlive()} / ${store.count()} —", LogCat.SCAN)
    }

    // === log =============================================================

    // Separate, independently-capped buffers per Logs tab — a flood of Telegram
    // session lines must not evict subscription/scan history (and vice-versa).
    private val teleLog = ArrayDeque<LogLine>()   // TELEGRAM + general (newest-first)
    private val subsLog = ArrayDeque<LogLine>()
    private val scanLog = ArrayDeque<LogLine>()

    @Synchronized
    private fun appendLog(line: String, cat: LogCat = LogCat.OTHER, session: String? = null) {
        val entry = LogLine(line, classify(line), cat, session, ts = System.currentTimeMillis())
        val (dq, cap) = when (cat) {
            LogCat.SUBS -> subsLog to LOG_CAP_SUBS
            LogCat.SCAN -> scanLog to LOG_CAP_SCAN
            else -> teleLog to LOG_CAP_TELE   // TELEGRAM + OTHER
        }
        dq.addFirst(entry)
        while (dq.size > cap) dq.removeLast()
        _logs.value = ArrayList<LogLine>(teleLog.size + subsLog.size + scanLog.size).apply {
            addAll(teleLog); addAll(subsLog); addAll(scanLog)
        }
    }

    private fun classify(line: String): LogLevel {
        val c = line.firstOrNull() ?: ' '
        return when (c) {
            '✓', '≈', '→' -> LogLevel.OK
            '✗', '⨂' -> LogLevel.FAIL
            '↪' -> LogLevel.ROUTE
            '·' -> LogLevel.MUTED
            '⟳', '⚠', '⏸' -> LogLevel.WARN
            else -> LogLevel.INFO
        }
    }

    private fun rate(bps: Long) = "${TrafficMeter.human(bps)}/с"

    private fun stripPort(hp: String?): String {
        if (hp == null) return ""
        val c = hp.lastIndexOf(':')
        return if (c > 0) hp.substring(0, c) else hp
    }

    companion object {
        // Single dotted-semver version line for the desktop build (matches the
        // GitHub release tag vX.Y.Z). Build date is injected at launch — see appInfo().
        private const val DESKTOP_VERSION = "1.0.61"
    }
}
