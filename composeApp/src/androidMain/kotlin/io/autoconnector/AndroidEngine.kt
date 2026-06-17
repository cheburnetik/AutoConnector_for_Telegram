package io.autoconnector

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.core.app.NotificationManagerCompat
import io.autoconnector.engine.AppInfo
import io.autoconnector.engine.CatalogItem
import io.autoconnector.engine.ConnState
import io.autoconnector.engine.Engine
import io.autoconnector.engine.EngineSettings
import io.autoconnector.engine.HistoryRecord
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
import io.autoconnector.engine.core.ScanGate
import io.autoconnector.engine.core.ScanState
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
import io.autoconnector.engine.relay.RelayService
import io.autoconnector.engine.relay.WireShaper
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

private const val IDLE_THRESHOLD_MS = 30_000L
private const val MATURE_BYTES = 4096L
// Once this many bytes have flowed through the relay this session, the tunnel
// is treated as working even during quiet periods.
private const val CONNECTED_MIN_BYTES = 1024L
// Per-tab log buffer caps. Telegram gets the most (it bursts dozens of session
// lines per connect); subscriptions the least (few sources).
private const val LOG_CAP_TELE = 500
private const val LOG_CAP_SCAN = 300
private const val LOG_CAP_SUBS = 150

/** Android implementation of [Engine], backed by the existing Java relay engine. */
class AndroidEngine(context: Context) : Engine {

    private val ctx = context.applicationContext
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

    // source id -> epoch ms when a manual out-of-queue download started.
    private val downloadingSince = java.util.concurrent.ConcurrentHashMap<Long, Long>()

    override fun start() {
        HandshakeStats.init(ctx)
        NetworkMonitor.init(ctx)
        // Net-log goes to the app's external files dir so the user can pull it
        // with a file manager (falls back to private files dir).
        NetLog.init(ctx.getExternalFilesDir(null) ?: ctx.filesDir)
        // On Android the native socket path works through the kernel VPN stack,
        // so the proxying-engine shaping defaults to OFF here (it caused media
        // stalls / instant "broken proxy" on phones). Desktop keeps coalescing.
        Prefs.SHIPPED_EXP_ENGINE = 0
        Prefs(ctx).applyShippedDefaultsOnce()
        RelayLog.register { session, line ->
            // RelayService tags subscription-download / scan lines with these
            // sentinel "sessions" so they land in the right log tab instead of
            // the Telegram tab.
            when (session) {
                "@subs" -> appendLog(line, LogCat.SUBS)
                "@scan" -> appendLog(line, LogCat.SCAN)
                else -> appendLog(line, LogCat.TELEGRAM, session)
            }
        }
        loadSettings()
        // Apply the persisted scan-mode override on top of auto-detection and
        // re-form the per-mode pool whenever the effective network changes.
        val mc = Prefs(ctx).scanModeOverride()
        NetworkMonitor.setManualMode(if (mc == "auto") null else NetworkMode.fromCode(mc))
        NetworkMonitor.get()?.addListener { newMode ->
            scope.launch(Dispatchers.IO) { onModeSwitched(newMode) }
        }
        NetLog.setEnabled(Prefs(ctx).netLogEnabled())
        prevUp = RelayStats.bytesUp.get()
        prevDown = RelayStats.bytesDown.get()
        syncService()
        scope.launch { pollLoop() }
        scope.launch(Dispatchers.IO) { autoRefreshOnce() }
    }

    override fun dispose() {
        scope.cancel()
    }

    // === toggles =========================================================

    override fun setProxyEnabled(on: Boolean) {
        Prefs(ctx).setAppEnabled(on)
        appendLog(if (on) "⏻ прокси включён — открываю порты" else "⏻ прокси отключён — закрываю порты")
        syncService()
        pushImmediate()
    }

    override fun setScanEnabled(on: Boolean) {
        Prefs(ctx).setScanEnabled(on)
        // Abort any in-flight subscription download / host probe immediately when
        // scanning is turned off (CheckRunner + PageScanner poll ScanGate); clear
        // it when turned back on.
        ScanGate.setAborted(!on)
        if (!on) {
            // Clear the ping / threads gauges promptly so the graphs drop to 0
            // instead of holding stale values after scanning stops.
            io.autoconnector.engine.traffic.ScanPingBuffer.INSTANCE.reset()
            io.autoconnector.engine.traffic.ThreadsBuffer.INSTANCE.reset()
        }
        appendLog(if (on) "✓ фоновое сканирование включено" else "⏸ фоновое сканирование отключено — останавливаю фоновые задачи", LogCat.SCAN)
        syncService()
        pushImmediate()
    }

    private fun syncService() {
        val p = Prefs(ctx)
        if (p.appEnabled() || p.scanEnabled()) RelayService.reconfigure(ctx)
        else RelayService.stop(ctx)
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
            relayRaceWidth = p.relayRaceWidth(),
            relayBreadth = p.relayBreadth(),
            relayConnectTimeoutMs = p.relayConnectTimeoutMs(),
        )
    }

    override fun updateSettings(s: EngineSettings) {
        val p = Prefs(ctx)
        val oldScanMode = p.scanModeOverride()
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
        p.setRelayRaceWidth(s.relayRaceWidth)
        p.setRelayBreadth(s.relayBreadth)
        p.setRelayConnectTimeoutMs(s.relayConnectTimeoutMs)
        NetLog.setEnabled(s.netLogEnabled)
        // Re-apply the override only when the mode picker actually changed, so a
        // plain settings-save doesn't kick the network monitor.
        if (s.scanMode != oldScanMode) {
            NetworkMonitor.setManualMode(if (s.scanMode == "auto") null else NetworkMode.fromCode(s.scanMode))
        }
        loadSettings()
        if (p.appEnabled() || p.scanEnabled()) RelayService.reconfigure(ctx)
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
        // Android has no folder-opener; surface the path so the user can pull
        // the file with a file manager from the app's external files dir.
        val p = NetLog.file()?.absolutePath
        appendLog(if (p != null) "· лог сетевого обмена: $p" else "⚠ путь лога недоступен")
    }

    override fun dataDirPath(): String = ctx.filesDir.absolutePath

    override fun openDataFolder() {
        // No generic folder-opener on Android; just surface the path in the log.
        appendLog("· папка данных: ${ctx.filesDir.absolutePath}")
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
        appendLog("⚙ каталог и статистика сброшены (хосты и подписки сохранены)")
    }

    override fun clearDownloadedHosts() {
        store.clearDownloadedHosts()
        store.resetSourceStats()   // subscriptions back to "never / zeros"
        appendLog("⚙ список скачанных хостов очищен — подписки обнулены, качаю заново")
        refreshCatalog(); refreshSources()
        // Pool is empty now — re-download + re-check instead of waiting.
        scope.launch(Dispatchers.IO) { try { scanAndCheck() } catch (_: Throwable) {} }
    }

    override fun appInfo(): AppInfo = AppInfo(
        version = "${BuildConfig.VERSION_NAME} (${BuildConfig.VERSION_CODE})",
        buildDate = BuildConfig.BUILD_DATE,
        // e.g. "Android arm64-v8a · API 34" — primary ABI + SDK level.
        platform = "Android ${Build.SUPPORTED_ABIS.firstOrNull() ?: "?"} · API ${Build.VERSION.SDK_INT}",
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

    private fun fmtLink(tg: String): String =
        if (Prefs(ctx).proxyLinkHttp()) tg.replaceFirst("tg://", "https://t.me/") else tg

    override fun tgLink(id: Long): String? =
        store.proxiesByIds(listOf(id)).firstOrNull()?.tgLink()?.let { fmtLink(it) }

    override fun copyToClipboard(text: String) {
        val cm = ctx.getSystemService(Context.CLIPBOARD_SERVICE) as? ClipboardManager ?: return
        cm.setPrimaryClip(ClipData.newPlainText("AutoConnector", text))
        appendLog("· скопировано в буфер")
    }

    override fun openLink(url: String) {
        try {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(url)).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            ctx.startActivity(i)
        } catch (t: Throwable) {
            appendLog("⚠ не удалось открыть: $url")
        }
    }

    override fun requestNotifications() {
        // Open the OS app-notification settings so the user can switch them on
        // (works even if the runtime permission was permanently denied).
        try {
            val i = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS)
                .putExtra(Settings.EXTRA_APP_PACKAGE, ctx.packageName)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            ctx.startActivity(i)
        } catch (t: Throwable) {
            appendLog("⚠ не удалось открыть настройки уведомлений")
        }
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
        scope.launch(Dispatchers.IO) {
            val url = _sources.value.firstOrNull { it.id == id }?.url ?: return@launch
            ScanGate.setAborted(false)
            downloadingSince[id] = System.currentTimeMillis()
            refreshSources()
            appendLog("⤓ обновляю подписку: $url", LogCat.SUBS)
            try {
                val scanner = PageScanner(store) { line -> appendLog(line, LogCat.SUBS) }
                val r = scanner.scanPage(url)
                val sid = store.upsertSource(url)
                if (sid > 0) {
                    store.setSourceScanResult(sid, r.found, r.bytes, r.error)
                    if (r.found > 0 && r.error == null) store.markSourceRefreshed(sid)
                }
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
            // App's external files dir is pull-able with a file manager and needs
            // no runtime permission — the same place the diagnostic net-log lives.
            val dir = ctx.getExternalFilesDir(null) ?: ctx.filesDir
            val f = java.io.File(dir, "autoconnector_proxies.txt")
            f.writeText(links.joinToString("\n"))
            appendLog("⤓ экспортировано ${links.size} ссылок → ${f.absolutePath}")
            f.absolutePath
        } catch (e: Throwable) {
            appendLog("⚠ экспорт в файл не удался: ${e.message}")
            null
        }
    }

    // Backup payload works on Android too (copy/paste); only disk file dialogs
    // are unavailable here, so save/pick are no-ops and fileIoSupported() = false.
    override fun buildBackupJson(settings: Boolean, subs: Boolean, hosts: Boolean): String =
        io.autoconnector.engine.io.BackupIo.build(store, Prefs(ctx), settings, subs, hosts)

    override fun importBackupText(text: String, settings: Boolean, subs: Boolean, hosts: Boolean): String {
        return try {
            val r = io.autoconnector.engine.io.BackupIo.importInto(store, Prefs(ctx), text, settings, subs, hosts)
            if (r.status == null) return "⚠ В тексте нет выбранных разделов"
            if (r.hostsChanged) { refreshCatalog(); refreshSources() }
            else if (r.subsChanged) refreshSources()
            appendLog("⤒ импорт: ${r.status}")
            "✓ Импортировано: ${r.status}"
        } catch (t: Throwable) {
            "⚠ Ошибка импорта: ${t.message}"
        }
    }

    override fun saveTextToFile(suggestedName: String, text: String): String =
        "На Android используйте «Скопировать»"
    override fun pickTextFile(): String? = null
    override fun fileIoSupported(): Boolean = false

    override fun factoryReset() {
        scope.launch(Dispatchers.IO) {
            try {
                ScanGate.setAborted(true)
                Prefs(ctx).clearAll()
                Prefs(ctx).applyShippedDefaultsOnce()
                store.clearDownloadedHosts()
                for (s in store.listSources()) store.deleteSource(s.id)
                store.ensureDefaultSources()
                store.resetSourceStats()
                ScanGate.setAborted(false)
                refreshCatalog(); refreshSources()
                // Empty pool now — re-pull the subscriptions hard, like a fresh install.
                // reconfigure() first so the running service drops its stale 30 s
                // subsRefill tick and re-posts it at t=0 (adaptive fast tick takes
                // over) — otherwise the wipe sat idle until the next 30 s tick.
                if (Prefs(ctx).appEnabled() || Prefs(ctx).scanEnabled()) RelayService.reconfigure(ctx)
                if (Prefs(ctx).scanEnabled()) bootstrapIntensive()
            } catch (_: Throwable) {}
            finally { refreshCatalog(); refreshSources() }
        }
    }

    override fun refreshNow() {
        scope.launch(Dispatchers.IO) { scanAndCheck() }
    }

    // === per-network-mode actions ========================================

    override fun setScanMode(mode: String) {
        Prefs(ctx).setScanModeOverride(mode)
        NetworkMonitor.setManualMode(if (mode == "auto") null else NetworkMode.fromCode(mode))
        loadSettings()
        pushImmediate()
        scope.launch(Dispatchers.IO) { onModeSwitched(NetworkMonitor.currentMode()) }
    }

    private val modeSwitchBusy = java.util.concurrent.atomic.AtomicBoolean(false)

    /** Re-forms the per-mode pool after the effective network changes. When the
     *  new mode has too few alive hosts, runs an intensive seed scan: first the
     *  best hosts known to work on the OTHER modes, then the due-for-check list
     *  for this mode. Probes auto-record under the now-current mode. */
    private fun onModeSwitched(mode: NetworkMode) {
        if (mode == NetworkMode.UNKNOWN) return
        if (!modeSwitchBusy.compareAndSet(false, true)) return
        try {
            if (store.aliveCountForMode(mode) < 20) {
                ScanGate.setAborted(false)
                appendLog("⟳ режим → ${mode.label}: формирую список (живых ${store.aliveCountForMode(mode)})", LogCat.SCAN)
                // Seed with the top hosts from the OTHER reportable modes —
                // good candidates that already work somewhere.
                val seed = LinkedHashMap<Long, ProxyEntry>()
                for (other in NetworkMode.reportable()) {
                    if (other == mode) continue
                    for (e in store.topAliveForMode(other, 80)) seed[e.id] = e
                }
                val p = Prefs(ctx)
                val runner = CheckRunner(store, { line -> appendLog(line, LogCat.SCAN) }, 100)
                runner.setProbeMode(if (p.dpiApplyProbes()) HandshakeMode.fromOrdinal(p.handshakeMode()) else HandshakeMode.NORMAL)
                if (seed.isNotEmpty()) runner.runOn(ArrayList(seed.values), "mode-seed:${mode.code}")
                runner.runOn(store.dueForCheckForMode(mode, 600), "mode-fill:${mode.code}")
                appendLog("⟳ режим ${mode.label}: живых ${store.aliveCountForMode(mode)} / ${store.count()}", LogCat.SCAN)
            }
        } catch (t: Throwable) {
            appendLog("⚠ смена режима: ${t.message}", LogCat.SCAN)
        } finally {
            modeSwitchBusy.set(false)
            refreshCatalog()
        }
    }

    override fun catalogForMode(modeCode: String): List<CatalogItem> {
        val now = System.currentTimeMillis()
        val mode = NetworkMode.fromCode(modeCode)
        val nums = HashMap<Long, Int>()
        var i = 1
        for (s in store.listSources()) nums[s.id] = i++
        val liveIds = HashSet<Long>()
        for (c in RelayStats.liveConnections()) liveIds.add(c.upstreamProxyId)
        val sticky = RelayManager.currentStickyProxyIds()
        val pinnedId = RelayManager.currentPinnedId()

        // auto / unknown → the global top-50 (same as the live catalog tab).
        if (mode == NetworkMode.UNKNOWN) {
            return store.top(50).map { p -> globalCatalogItem(p, now, nums, liveIds, sticky, pinnedId) }
        }

        return store.topForMode(mode, 50).map { p ->
            val srcId = store.primarySourceId(p.id)
            val tls = if (p.isFakeTls) FakeTlsClient.domainFromSecret(p.secret) else null
            val ms = store.modeStatsOf(p.id, mode)
            val alive = ms != null && ms.lastCheck > 0 && ms.alive
            val score = ms?.score ?: 0.0
            CatalogItem(
                id = p.id,
                host = hostLabel(p),
                typeLabel = typeLabel(p),
                rating = if (!alive || score <= 0.0) 0 else minOf(9, maxOf(1, (score / 10.0).toInt())),
                alive = alive,
                live = liveIds.contains(p.id),
                pinned = pinnedId == p.id,
                sticky = pinnedId != p.id && sticky.contains(p.id),
                // "Telegram connected" is meaningful regardless of network mode,
                // and the per-mode counter is rarely incremented — so show the
                // host's GLOBAL last-connect time and count (fixes the dashes the
                // per-mode catalog showed for "Telegram подключался").
                everServed = p.lastTgConnectAt > 0 || p.tgConnections > 0,
                sourceNum = if (srcId > 0) nums[srcId] else null,
                checkedMinsAgo = if (ms != null && ms.lastCheck > 0) (now - ms.lastCheck) / 60_000 else -1,
                tgConnectMinsAgo = if (p.lastTgConnectAt > 0) (now - p.lastTgConnectAt) / 60_000 else -1,
                successes = ms?.successes ?: 0,
                failures = ms?.failures ?: 0,
                tgConnections = p.tgConnections,
                bytesRelayed = ms?.bytesRelayed ?: 0L,
                bytesRelayedHuman = TrafficMeter.human(ms?.bytesRelayed ?: 0L),
                sessionTotalHuman = (ms?.totalSessionMs ?: 0L).let { if (it > 0) Durations.human(it / 1000) else "—" },
                rttMs = ms?.rttMs ?: -1,
                secret = p.secret,
                tlsDomain = tls?.takeIf { it.isNotEmpty() },
                port = p.port,
                lastErrorShort = p.lastError?.takeIf { it.isNotBlank() }?.let { if (it.length > 40) it.substring(0, 39) + "…" else it },
            )
        }
    }

    override fun hostHistory(id: Long, limit: Int): List<HistoryRecord> =
        store.hostHistory(id, limit).map { r ->
            HistoryRecord(
                ts = r.ts,
                isTelegram = r.kind == 1,
                success = r.success,
                tcpMs = r.tcpMs,
                tlsMs = r.tlsMs,
                totalMs = r.totalMs,
                bytesIn = r.bytesIn,
                bytesOut = r.bytesOut,
            )
        }

    override fun exportAliveLinksForMode(modeCode: String): List<String> {
        val mode = NetworkMode.fromCode(modeCode)
        val list = if (mode == NetworkMode.UNKNOWN) store.topAlive(2000)
                   else store.topAliveForMode(mode, 2000)
        return list.map { fmtLink(it.tgLink()) }
    }

    override fun exportLinksToFileForMode(modeCode: String): String? {
        val links = exportAliveLinksForMode(modeCode)
        if (links.isEmpty()) return null
        return try {
            val dir = ctx.getExternalFilesDir(null) ?: ctx.filesDir
            val code = if (NetworkMode.fromCode(modeCode) == NetworkMode.UNKNOWN) "auto" else modeCode
            val f = java.io.File(dir, "autoconnector_proxies_$code.txt")
            f.writeText(links.joinToString("\n"))
            appendLog("⤓ экспортировано ${links.size} ссылок ($code) → ${f.absolutePath}")
            f.absolutePath
        } catch (e: Throwable) {
            appendLog("⚠ экспорт в файл не удался: ${e.message}")
            null
        }
    }

    override fun resetModeStats(modeCode: String) {
        val mode = NetworkMode.fromCode(modeCode)
        store.resetModeStats(mode)
        refreshCatalog(); pushImmediate()
        appendLog("⚙ рейтинг хостов обнулён: ${mode.label}")
    }

    override fun forgetModeHosts(modeCode: String) {
        val mode = NetworkMode.fromCode(modeCode)
        store.forgetModeHosts(mode)
        refreshCatalog(); pushImmediate()
        appendLog("⚙ хосты режима забыты: ${mode.label}")
    }

    override fun copyModeStats(fromCode: String, toCode: String) {
        val from = NetworkMode.fromCode(fromCode)
        val to = NetworkMode.fromCode(toCode)
        store.copyModeStats(from, to)
        refreshCatalog(); pushImmediate()
        appendLog("⚙ режим ${to.label} ← копия рейтинга из ${from.label}")
    }

    // Global hotkeys are a desktop-only feature — no page/button on Android.
    override fun hotkeysSupported() = false
    override fun hotkeysEnabled() = false
    override fun setHotkeysEnabled(on: Boolean) {}
    override fun hotkeyLetter() = "P"
    override fun setHotkeyLetter(letter: String) {}
    override fun hotkeyCopyLabel() = ""
    override fun hotkeyOpenLabel() = ""

    private val scanNowBusy = java.util.concurrent.atomic.AtomicBoolean(false)

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
                ScanGate.setAborted(false)
                val list = store.dueForCheck(500)
                if (list.isEmpty()) {
                    appendLog("⚡ скан сейчас: в базе нет прокси — нечего проверять", LogCat.SCAN)
                    return@launch
                }
                appendLog("⚡ скан сейчас: ${list.size} прокси в 50 потоков", LogCat.SCAN)
                val p = Prefs(ctx)
                val runner = CheckRunner(store, { line -> appendLog(line, LogCat.SCAN) }, 50)
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
                pushState()
                if (i % 4 == 0) { refreshCatalog(); refreshSources() }
            } catch (_: Throwable) {
            }
            i++
            delay(2000)   // graph advances strictly once per 2 s
        }
    }

    private fun pushImmediate() = try { pushState() } catch (_: Throwable) {}

    private fun pushState() {
        val now = System.currentTimeMillis()
        val p = Prefs(ctx)
        val proxyOn = p.appEnabled()
        val scanOn = p.scanEnabled()

        // Fallback per-poll sample of the live-proxy count so the "total live"
        // graph fills even without a dedicated 1 s tick in RelayService. The
        // buffer overwrites each second/minute bucket with the latest sample.
        io.autoconnector.engine.traffic.AliveHistBuffer.INSTANCE.tick(store.aliveCount().toLong())
        io.autoconnector.engine.traffic.ScanPingBuffer.INSTANCE.tick()
        io.autoconnector.engine.traffic.ThreadsBuffer.INSTANCE.tick(ScanState.probing.size.toLong())

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
        val silenceMs = if (mostRecentDataAt > 0) now - mostRecentDataAt else Long.MAX_VALUE
        val anyMature = longestBytes >= MATURE_BYTES

        val sessionSec = if (firstStart != Long.MAX_VALUE) (now - firstStart) / 1000 else 0L

        // "Connected" is decided by whether real traffic has flowed through the
        // relay this session — Telegram can load content in a fast burst and
        // then go quiet, so we must NOT fall back to "connecting" on silence.
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
            // Live sockets + real bytes carried (or data within the last 20 s) →
            // a working tunnel, regardless of momentary silence.
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

        // Show the relay host ALWAYS: live connection if any, otherwise the
        // proxy the relay would use next (pinned → sticky → best alive).
        val currentProxy = bestConn?.let { c -> buildProxyInfo(c, p) }
            ?: run {
                val id = RelayManager.currentPinnedId().takeIf { it > 0 }
                    ?: RelayManager.currentStickyProxyIds().firstOrNull()
                val entry = if (id != null && id > 0)
                    store.proxiesByIds(listOf(id)).firstOrNull()
                else store.topAlive(1).firstOrNull()
                entry?.let { buildProxyInfoFromEntry(it, p) }
            }

        // Pool totals (compute once, reused below).
        val total = store.count()
        val alive = store.countAlive()
        val alive15 = store.countAliveWithinMin(15)
        val dead = store.countDead()
        val checkSums = store.sumCheckCounts()  // [successes, failures] all-time
        val sm = ScanMetrics.INSTANCE

        // Per-mode pool counters for the ACTIVE network (falls back to the
        // global pool when the mode can't be determined).
        val curMode = NetworkMonitor.currentMode()
        val aliveModeN: Int; val deadModeN: Int; val totalModeN: Int
        if (curMode == NetworkMode.UNKNOWN) {
            aliveModeN = alive; deadModeN = dead; totalModeN = total
        } else {
            val agg = store.aggregateForMode(curMode)
            aliveModeN = agg.alive
            deadModeN = agg.deadProbed
            totalModeN = agg.alive + agg.deadProbed + agg.neverProbed
        }

        // Subscription refresh activity.
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

        // Scan plan (effective, intensity-scaled — the same maths the scheduler
        // uses). When intensity disables scanning the plan reports the disabled
        // sentinels (-1 interval / 0 conc / 0 batch).
        val scNet = NetworkMonitor.currentMode()
        val scAlive = if (scNet != NetworkMode.UNKNOWN) store.aliveCountForMode(scNet) else store.aliveCount()
        val scMult = p.currentScanMult(scNet, scAlive)
        val scanOff = Prefs.scanDisabledFor(scMult)
        val planIntervalSec = Prefs.effectiveCheckSec(p.checkIntervalMin(), scMult)
        val planConc = Prefs.effectiveConcurrency(p.checkConcurrency(), scMult)
        val planBatch = Prefs.effectiveBatch(p.checkBatch(), scMult)

        val aLastA = p.lastTelegramConnectPortAMs() > 0
        val bLastB = p.lastTelegramConnectPortBMs() > 0
        // Setup is considered done once Telegram has connected to AT LEAST one
        // of the relay ports (no need to wait for both).
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
            scanRunning = ScanState.probing.isNotEmpty(),
            netLabel = NetworkMonitor.currentMode().let { if (it == NetworkMode.UNKNOWN) "" else it.label },
            activeMode = curMode.code,
            scanModeManual = !NetworkMonitor.isAuto(),
            aliveMode = aliveModeN,
            deadMode = deadModeN,
            totalMode = totalModeN,
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
            aliveCount = aliveModeN,
            aliveWithin15 = alive15,
            totalCount = totalModeN,
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
            deadCount = deadModeN,
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
            notificationsOk = NotificationManagerCompat.from(ctx).areNotificationsEnabled(),
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
            scanPlanConcurrency = if (scanOff) 0 else planConc,
            scanPlanBatch = if (scanOff) 0 else planBatch,
            scanNowThreads = ScanState.probing.size,
            scanNowBatch = io.autoconnector.engine.core.ScanProgress.currentBatch(),
            scanNowSeconds = io.autoconnector.engine.core.ScanProgress.startedAtMs().let {
                if (it > 0) ((now - it) / 1000L).coerceAtLeast(0L) else 0L
            },
        )
    }

    /** Resolves the upstream of [c] into a display-friendly [ProxyInfo]. */
    private fun buildProxyInfo(c: RelayStats.LiveConn, p: Prefs): ProxyInfo {
        val entry = if (c.upstreamProxyId > 0)
            store.proxiesByIds(listOf(c.upstreamProxyId)).firstOrNull() else null

        // host:port — prefer the catalog entry, fall back to the live socket label.
        val host = entry?.host ?: stripPort(c.upstream)
        val port = entry?.port ?: portOf(c.upstream)

        val type = when {
            entry != null && entry.type == ProxyType.MTPROTO -> "MTProto"
            entry != null && entry.type == ProxyType.SOCKS5 -> "SOCKS5"
            c.upstreamMtproto -> "MTProto"
            else -> "SOCKS5"
        }

        val secret = entry?.secret?.let { if (it.length > 20) it.substring(0, 18) + "…" else it }

        // Anti-DPI handshake actually in flight on this connection.
        val dpi = if (c.upstreamMtproto) {
            val user = HandshakeMode.fromOrdinal(p.handshakeMode())
            if (user == HandshakeMode.AUTO_RANDOM)
                "Авто" + (HandshakeStats.lastUsed()?.let { " → ${it.label}" } ?: "")
            else user.label
        } else "—"

        return ProxyInfo(
            host = host,
            port = port,
            typeLabel = type,
            tls = c.fakeTlsSni?.takeIf { it.isNotEmpty() },
            secret = secret,
            dpi = dpi,
            obfEngine = obfEngineLabel(entry, c.upstreamMtproto, c.fakeTlsSni?.isNotEmpty() == true),
        )
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

    /** Proxy info for the "would-be relay" when no live socket exists yet. */
    private fun buildProxyInfoFromEntry(entry: ProxyEntry, p: Prefs): ProxyInfo {
        val type = when {
            entry.type == ProxyType.MTPROTO -> "MTProto"
            else -> "SOCKS5"
        }
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
        val now = System.currentTimeMillis()
        // Cap at the 50 most profitable so the catalog list never lags.
        val list = store.top(50)
        val nums = HashMap<Long, Int>()
        var i = 1
        for (s in store.listSources()) nums[s.id] = i++
        val liveIds = HashSet<Long>()
        for (c in RelayStats.liveConnections()) liveIds.add(c.upstreamProxyId)
        val sticky = RelayManager.currentStickyProxyIds()
        val pinnedId = RelayManager.currentPinnedId()
        _catalog.value = list.map { p ->
            globalCatalogItem(p, now, nums, liveIds, sticky, pinnedId)
        }
    }

    /** Maps a global proxy row → [CatalogItem] using its global (mode-agnostic)
     *  rating columns. Shared by [refreshCatalog] and the auto/unknown branch of
     *  [catalogForMode]. */
    private fun globalCatalogItem(
        p: ProxyEntry, now: Long, nums: Map<Long, Int>,
        liveIds: Set<Long>, sticky: Set<Long>, pinnedId: Long,
    ): CatalogItem {
        val srcId = store.primarySourceId(p.id)
        val tls = if (p.isFakeTls) FakeTlsClient.domainFromSecret(p.secret) else null
        return CatalogItem(
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

    // === bootstrap (mirrors MainActivity.autoRefreshOnce) ================

    private fun autoRefreshOnce() {
        try {
            // Idempotent (CONFLICT_IGNORE on the unique url) — runs every start so
            // newly-shipped default subscriptions reach existing installs too.
            store.ensureDefaultSources()
            refreshSources(); refreshCatalog()
            // Subscription downloading + mass-checking are owned by RelayService
            // now (RelayService.subsRefillTask) so they run in the background too
            // and refill automatically whenever the pool is thin (<1000 hosts or
            // <10 alive). The service is already (re)started by syncService(), so
            // there's nothing to pull here — just make sure it's running.
            if (Prefs(ctx).appEnabled() || Prefs(ctx).scanEnabled()) RelayService.reconfigure(ctx)
        } catch (t: Throwable) {
            appendLog("⚠ bootstrap: ${t.message}", LogCat.SCAN)
        }
    }

    /** Downloads the given subscription URLs CONCURRENTLY through PageScanner's
     *  direct→anonymizer cascade. Marks a source "refreshed" ONLY on a real
     *  success. Returns the URLs that yielded nothing, for a retry pass. */
    private fun downloadSourcesParallel(urls: List<String>, threads: Int): List<String> {
        if (urls.isEmpty()) return emptyList()
        val scanner = PageScanner(store) { line -> appendLog(line, LogCat.SUBS) }
        val failed = java.util.concurrent.CopyOnWriteArrayList<String>()
        val pool = java.util.concurrent.Executors.newFixedThreadPool(threads.coerceIn(1, 48))
        try {
            val futures = urls.map { url ->
                pool.submit(Runnable {
                    if (ScanGate.isAborted()) { failed.add(url) }
                    else try {
                        val r = scanner.scanPage(url)
                        val id = store.upsertSource(url)
                        if (id > 0) {
                            store.setSourceScanResult(id, r.found, r.bytes, r.error)
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
        } finally { pool.shutdownNow() }
        return failed.toList()
    }

    /** Keeps re-downloading the subscriptions that have NOT yet yielded anything,
     *  round after round, many threads at a time, through every anonymizer —
     *  until they all land, scanning is off, the pass aborts, or the round cap
     *  is hit. Short escalating backoff between rounds. */
    private fun downloadAllSourcesPersistently() {
        var pending = store.enabledSourceUrls()
        var round = 0
        val maxRounds = 24
        while (pending.isNotEmpty() && Prefs(ctx).scanEnabled()
                && !ScanGate.isAborted() && round < maxRounds) {
            round++
            val threads = minOf(32, maxOf(16, pending.size))
            appendLog("⇣ закачка подписок, проход $round: ${pending.size} шт × $threads потоков", LogCat.SUBS)
            pending = downloadSourcesParallel(pending, threads)
            appendLog("⇣ проход $round: в базе ${store.count()} прокси, не скачано ${pending.size} подписок", LogCat.SUBS)
            if (pending.isEmpty()) break
            val backoff = minOf(15_000L, 1500L * round)
            var slept = 0L
            while (slept < backoff && !ScanGate.isAborted() && Prefs(ctx).scanEnabled()) {
                Thread.sleep(500); slept += 500
            }
        }
        if (pending.isNotEmpty())
            appendLog("✗ после $round проходов не скачано ${pending.size} подписок — повторю при следующем обновлении", LogCat.SUBS)
    }

    private fun scanAndCheck() {
        val failed = downloadSourcesParallel(store.enabledSourceUrls(), 6)
        if (failed.isNotEmpty() && !ScanGate.isAborted()) {
            appendLog("↻ повтор ${failed.size} подписок через анонимайзеры", LogCat.SUBS)
            downloadSourcesParallel(failed, minOf(6, failed.size))
        }
        refreshSources()
        val p = Prefs(ctx)
        val runner = CheckRunner(store, { line -> appendLog(line, LogCat.SCAN) }, p.checkConcurrency())
        runner.setProbeMode(if (p.dpiApplyProbes()) HandshakeMode.fromOrdinal(p.handshakeMode()) else HandshakeMode.NORMAL)
        runner.runBatch(p.checkBatch())
        appendLog("— проверка готова —", LogCat.SCAN)
    }

    private fun bootstrapIntensive() {
        downloadAllSourcesPersistently()
        refreshSources()
        val afterScan = store.count()
        appendLog("— bootstrap: собрано $afterScan прокси, массовая проверка —", LogCat.SCAN)
        if (afterScan == 0) { appendLog("— bootstrap: база пуста, проверять нечего —", LogCat.SCAN); return }
        val pp = Prefs(ctx)
        val target = pp.adaptiveAliveThreshold()
        val conc = maxOf(32, minOf(Prefs.CONCURRENCY_CAP, afterScan / 3))
        val probeMode = if (pp.dpiApplyProbes()) HandshakeMode.fromOrdinal(pp.handshakeMode()) else HandshakeMode.NORMAL
        var round = 0
        while (round < 8 && Prefs(ctx).scanEnabled() && !ScanGate.isAborted()
                && store.countAlive() < target && store.count() > 0) {
            val runner = CheckRunner(store, { line -> appendLog(line, LogCat.SCAN) }, conc)
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
        // The UI filters by category, so order across buffers doesn't matter.
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
    private fun plural(n: Int, one: String, few: String, many: String): String {
        val m10 = n % 10; val m100 = n % 100
        if (m100 in 11..14) return many
        if (m10 == 1) return one
        if (m10 in 2..4) return few
        return many
    }
}
