package io.autoconnector

import android.content.Context
import io.autoconnector.engine.AppInfo
import io.autoconnector.engine.CatalogItem
import io.autoconnector.engine.ConnState
import io.autoconnector.engine.Engine
import io.autoconnector.engine.EngineSettings
import io.autoconnector.engine.EngineState
import io.autoconnector.engine.ExpEngineOption
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
import io.autoconnector.engine.traffic.CheckRateBuffer
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

    override fun start() {
        HandshakeStats.init(ctx)
        NetworkMonitor.init(ctx)
        NetLog.init(dataDir)
        Prefs(ctx).applyShippedDefaultsOnce()
        RelayLog.register { session, line -> appendLog(line, LogCat.TELEGRAM, session) }
        loadSettings()
        NetLog.setEnabled(Prefs(ctx).netLogEnabled())
        prevUp = RelayStats.bytesUp.get()
        prevDown = RelayStats.bytesDown.get()
        applyRelayState()
        scope.launch { pollLoop() }
        scope.launch { sparkLoop() }
        scope.launch { mainsLoop() }
        scope.launch(Dispatchers.IO) { autoRefreshOnce() }
    }

    override fun dispose() {
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
        appendLog(if (on) "✓ фоновое сканирование включено" else "⏸ фоновое сканирование отключено", LogCat.SCAN)
        applyRelayState()
        pushImmediate()
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
            speedVpn = p.speedMultiplier(NetworkMode.VPN),
            speedWifi = p.speedMultiplier(NetworkMode.WIFI),
            speedLte = p.speedMultiplier(NetworkMode.LTE),
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
            langCode = p.lang(),
            expEngineMode = p.expEngineMode(),
            netLogEnabled = p.netLogEnabled(),
            relayConnectMode = p.relayConnectMode(),
        )
    }

    override fun updateSettings(s: EngineSettings) {
        val p = Prefs(ctx)
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
        p.setSpeedMultiplier(NetworkMode.VPN, s.speedVpn)
        p.setSpeedMultiplier(NetworkMode.WIFI, s.speedWifi)
        p.setSpeedMultiplier(NetworkMode.LTE, s.speedLte)
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
        p.setLang(s.langCode)
        p.setExpEngineMode(s.expEngineMode)
        p.setNetLogEnabled(s.netLogEnabled)
        p.setRelayConnectMode(s.relayConnectMode)
        NetLog.setEnabled(s.netLogEnabled)
        loadSettings()
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
        WireShaper.Mode.values().map { ExpEngineOption(it.code, it.label, it.description) }

    override fun connectEngineOptions(): List<ExpEngineOption> =
        RelayConnectMode.values().map { ExpEngineOption(it.code, it.label, it.description) }

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

    override fun tgLink(id: Long): String? =
        store.proxiesByIds(listOf(id)).firstOrNull()?.tgLink()

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
        try {
            val desktop = java.awt.Desktop.getDesktop()
            desktop.browse(java.net.URI(url))
        } catch (t: Throwable) {
            appendLog("⚠ не удалось открыть: $url")
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

    override fun setSourceEnabled(id: Long, enabled: Boolean) {
        store.setSourceEnabled(id, enabled)
        refreshSources()
    }

    override fun exportAliveLinks(): List<String> =
        store.topAlive(2000).map { it.tgLink() }

    override fun refreshNow() {
        scope.launch(Dispatchers.IO) { scanAndCheck() }
    }

    // === polling =========================================================

    private suspend fun pollLoop() {
        var i = 0
        while (true) {
            try {
                pushState()
                if (i % 3 == 0) { refreshCatalog(); refreshSources() }
            } catch (_: Throwable) {
            }
            i++
            delay(1500)
        }
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
                if (Prefs(ctx).scanEnabled()) checkMains()
            } catch (_: Throwable) {}
            delay(dynamicCheckInterval())
        }
    }

    private fun dynamicCheckInterval(): Long {
        val prefs = Prefs(ctx)
        val net = NetworkMonitor.currentMode()
        var mult = prefs.speedMultiplier(net)
        if (io.autoconnector.engine.core.BurstMode.isActive()) {
            mult = minOf(mult, 0.25f)
        } else {
            val alive = if (net != NetworkMode.UNKNOWN)
                store.aliveCountForMode(net) else store.aliveCount()
            if (alive < prefs.adaptiveAliveThreshold()) mult *= prefs.fastSpeedMultiplier()
            else if (alive > prefs.lazyAliveThreshold()) mult *= prefs.lazySpeedMultiplier()
        }
        val out = (MAINS_CHECK_INTERVAL_MS * maxOf(0.1f, mult)).toLong()
        return maxOf(15_000L, out)
    }

    private fun checkMains() {
        val ids = RelayManager.currentStickyProxyIds()
        val mains = if (ids.isEmpty()) ArrayList() else store.proxiesByIds(ids)
        val due = store.dueForCheck(80)
        val combined = ArrayList(mains)
        for (d in due) if (combined.none { it.id == d.id }) combined.add(d)
        if (combined.isEmpty()) return

        RelayLog.emit("⟳ проверка: главных ${mains.size} + новых ${combined.size - mains.size}")
        val runner = CheckRunner(store, CheckRunner.Log { line -> appendLog(line, LogCat.SCAN) }, minOf(12, combined.size))
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

        _state.value = EngineState(
            proxyEnabled = proxyOn,
            scanEnabled = scanOn,
            setupNeeded = setupNeeded,
            setupCta = cta,
            portA = p.relayPortA(),
            portB = p.relayPortB(),
            connState = connState,
            statusText = statusText,
            statusSub = statusSub,
            modeBadge = modeBadge(p),
            directMode = p.shouldBypassProxies(),
            directViaVpn = p.proxyMode() == Prefs.ProxyMode.DISABLED_ON_VPN
                    && NetworkMonitor.currentMode() == NetworkMode.VPN,
            directAntiDpi = p.dpiApplyDirect(),
            aliveCount = alive,
            aliveWithin15 = alive15,
            totalCount = total,
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
            deadCount = dead,
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
            checkOkSec = cs.ok,
            checkFailSec = cs.fail,
            checkOkMin = cm.ok,
            checkFailMin = cm.fail,
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
        return ProxyInfo(host, port, type, c.fakeTlsSni?.takeIf { it.isNotEmpty() }, secret, dpi)
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
        return ProxyInfo(entry.host, entry.port, type, tls, secret, dpi)
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
        val now = System.currentTimeMillis()
        val list = store.top(50)
        val nums = HashMap<Long, Int>()
        var i = 1
        for (s in store.listSources()) nums[s.id] = i++
        val liveIds = HashSet<Long>()
        for (c in RelayStats.liveConnections()) liveIds.add(c.upstreamProxyId)
        val sticky = RelayManager.currentStickyProxyIds()
        val pinnedId = RelayManager.currentPinnedId()
        _catalog.value = list.map { p ->
            val srcId = store.primarySourceId(p.id)
            val tls = if (p.isFakeTls) FakeTlsClient.domainFromSecret(p.secret) else null
            CatalogItem(
                id = p.id,
                host = hostLabel(p),
                typeLabel = typeLabel(p),
                rating = minOf(9, maxOf(0, (p.score / 10.0).toInt())),
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
            val known = store.count()
            if (known < 50) {
                appendLog("— ПЕРВЫЙ ЗАПУСК: интенсивный bootstrap ($known прокси) —", LogCat.SCAN)
                bootstrapIntensive()
            } else {
                appendLog("— автозапуск: скан и проверка —", LogCat.SCAN)
                scanAndCheck()
            }
        } catch (t: Throwable) {
            appendLog("⚠ bootstrap: ${t.message}", LogCat.SCAN)
        }
    }

    private fun scanAndCheck() {
        val scanner = PageScanner(store, PageScanner.Log { line -> appendLog(line, LogCat.SUBS) })
        for (url in store.enabledSourceUrls()) {
            val r = scanner.scanPage(url)
            val id = store.upsertSource(url)
            if (id > 0) {
                store.markSourceRefreshed(id)
                store.setSourceScanResult(id, r.found, r.bytes, r.error)
            }
        }
        val p = Prefs(ctx)
        val runner = CheckRunner(store, CheckRunner.Log { line -> appendLog(line, LogCat.SCAN) }, p.checkConcurrency())
        runner.setProbeMode(if (p.dpiApplyProbes()) HandshakeMode.fromOrdinal(p.handshakeMode()) else HandshakeMode.NORMAL)
        runner.runBatch(p.checkBatch())
        appendLog("— проверка готова —", LogCat.SCAN)
    }

    private fun bootstrapIntensive() {
        val scanner = PageScanner(store, PageScanner.Log { line -> appendLog(line, LogCat.SUBS) })
        for (url in store.enabledSourceUrls()) {
            try {
                val r = scanner.scanPage(url)
                val id = store.upsertSource(url)
                if (id > 0) {
                    store.markSourceRefreshed(id)
                    store.setSourceScanResult(id, r.found, r.bytes, r.error)
                }
            } catch (t: Throwable) {
                appendLog("⚠ $url — ${t.message}", LogCat.SUBS)
            }
        }
        val afterScan = store.count()
        appendLog("— bootstrap: собрано $afterScan прокси, массовая проверка —", LogCat.SCAN)
        val conc = maxOf(16, minOf(32, afterScan / 10))
        val runner = CheckRunner(store, CheckRunner.Log { line -> appendLog(line, LogCat.SCAN) }, conc)
        val pp = Prefs(ctx)
        runner.setProbeMode(if (pp.dpiApplyProbes()) HandshakeMode.fromOrdinal(pp.handshakeMode()) else HandshakeMode.NORMAL)
        runner.runBatch(minOf(afterScan, 600))
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
        val entry = LogLine(line, classify(line), cat, session)
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
        private const val DESKTOP_VERSION = "1.0.10"
    }
}
