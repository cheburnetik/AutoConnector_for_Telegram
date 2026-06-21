package io.autoconnector.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Terminal
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.launch
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.autoconnector.engine.CatalogItem
import io.autoconnector.engine.Engine
import io.autoconnector.engine.EngineState
import io.autoconnector.i18n.LocalStrings
import io.autoconnector.i18n.stringsFor
import io.autoconnector.ui.components.blinkAlpha
import io.autoconnector.ui.components.keyPageScroll
import io.autoconnector.ui.screens.CatalogDetailPage
import io.autoconnector.ui.screens.CatalogModeManagePage
import io.autoconnector.ui.screens.ConnectGuidePage
import io.autoconnector.ui.screens.ConnectorContent
import io.autoconnector.ui.screens.MoreCallbacks
import io.autoconnector.ui.screens.MoreDest
import io.autoconnector.ui.screens.MoreFullPage
import io.autoconnector.ui.screens.MoreScreen
import io.autoconnector.ui.screens.QuickSettingsPage
import io.autoconnector.ui.screens.ScanContent
import io.autoconnector.ui.screens.CatalogContent
import io.autoconnector.ui.screens.logsItems
import io.autoconnector.ui.theme.AppColors
import io.autoconnector.ui.theme.AppTheme

private enum class Tabs(val label: String, val icon: ImageVector) {
    CONNECTOR("Коннектор", Icons.Filled.Bolt),
    SCAN("Скан", Icons.Filled.Search),
    CATALOG("Каталог", Icons.AutoMirrored.Filled.List),
    LOGS("Логи", Icons.Filled.Terminal),
    MORE("Ещё", Icons.Filled.Menu),
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun App(engine: Engine) {
    AppTheme {
        val state by engine.state.collectAsState()
        val logs by engine.logs.collectAsState()
        val catalog by engine.catalog.collectAsState()
        val sources by engine.sources.collectAsState()
        val settings by engine.settings.collectAsState()
        var tab by remember { mutableStateOf(Tabs.CONNECTOR) }
        var logTab by remember { mutableStateOf(io.autoconnector.ui.screens.LogTab.TELEGRAM) }
        var logErrorsOnly by remember { mutableStateOf(false) }
        val expandedSessions = remember { androidx.compose.runtime.mutableStateListOf<String>() }
        var showGuide by remember { mutableStateOf(false) }
        var detail by remember { mutableStateOf<CatalogItem?>(null) }
        var manageMode by remember { mutableStateOf<String?>(null) }
        var morePage by remember { mutableStateOf<MoreDest?>(null) }
        var quickSettings by remember { mutableStateOf(false) }
        var notifInfo by remember { mutableStateOf(false) }
        val listState = rememberLazyListState()
        val scope = rememberCoroutineScope()

      val layoutDir = if (io.autoconnector.i18n.isRtl(settings.langCode))
          androidx.compose.ui.unit.LayoutDirection.Rtl
      else androidx.compose.ui.unit.LayoutDirection.Ltr
      CompositionLocalProvider(
          LocalStrings provides stringsFor(settings.langCode),
          androidx.compose.ui.platform.LocalLayoutDirection provides layoutDir,
      ) {
        val t = LocalStrings.current

        if (notifInfo) {
            androidx.compose.material3.AlertDialog(
                onDismissRequest = { notifInfo = false },
                confirmButton = {
                    androidx.compose.material3.TextButton({ notifInfo = false; engine.requestNotifications() }) { Text(t.enable) }
                },
                dismissButton = {
                    androidx.compose.material3.TextButton({ notifInfo = false }) { Text(t.later) }
                },
                title = { Text(t.notifEnableTitle, fontWeight = FontWeight.Bold) },
                text = { Text(t.notifEnableBody, fontSize = 15.sp) },
            )
        }

        fun moreCallbacks() = MoreCallbacks(
            settings = settings,
            handshakeOptions = engine.handshakeOptions(),
            expEngineOptions = engine.expEngineOptions(),
            connectEngineOptions = engine.connectEngineOptions(),
            scanParamsFor = engine::scanParamsFor,
            netLogPath = engine.netLogPath(),
            onOpenNetLogFolder = engine::openNetLogFolder,
            dataDirPath = engine.dataDirPath(),
            onOpenDataFolder = engine::openDataFolder,
            onUpdateSettings = engine::updateSettings,
            sources = sources,
            onAddSource = engine::addSource,
            onAddSourcesBulk = engine::addSourcesBulk,
            onAddManualProxies = engine::addManualProxies,
            onRemoveSource = engine::removeSource,
            onToggleSource = engine::setSourceEnabled,
            onRefreshSource = engine::refreshSource,
            onOpenDest = { morePage = it },
            state = state,
            exportLinks = engine::exportAliveLinks,
            onExportToFile = engine::exportLinksToFile,
            onBuildBackup = { st, su, ho -> engine.buildBackupJson(st, su, ho) },
            onImportText = { txt, st, su, ho -> engine.importBackupText(txt, st, su, ho) },
            onSaveToFile = { name, txt -> engine.saveTextToFile(name, txt) },
            onPickFile = { engine.pickTextFile() },
            fileIoSupported = engine.fileIoSupported(),
            onSetScanMode = { engine.setScanMode(it) },
            onResetModeStats = { engine.resetModeStats(it) },
            onForgetModeHosts = { engine.forgetModeHosts(it) },
            onExportLinksForMode = { engine.exportAliveLinksForMode(it) },
            onExportFileForMode = { engine.exportLinksToFileForMode(it) },
            onCopy = engine::copyToClipboard,
            handshakeStats = engine::handshakeStats,
            onResetStats = engine::resetStats,
            onResetCatalogStats = engine::resetCatalogStats,
            onClearHosts = engine::clearDownloadedHosts,
            onFactoryReset = engine::factoryReset,
            hotkeyCopyLabel = engine.hotkeyCopyLabel(),
            hotkeyOpenLabel = engine.hotkeyOpenLabel(),
            hotkeysEnabled = engine.hotkeysEnabled(),
            hotkeyLetter = engine.hotkeyLetter(),
            onSetHotkeysEnabled = engine::setHotkeysEnabled,
            onSetHotkeyLetter = engine::setHotkeyLetter,
            onSetLanShareEnabled = engine::setLanShareEnabled,
            onSetVolPatternEnabled = engine::setVolPatternEnabled,
            onSetVolPatternGapMs = engine::setVolPatternGapMs,
            onSetVolPatternIndex = engine::setVolPatternIndex,
            onOpenAccessibilitySettings = engine::openAccessibilitySettings,
            onOpenAppInfo = engine::openAppInfo,
            appInfo = engine.appInfo(),
            onOpenUrl = engine::openLink,
        )

        val detailItem = detail
        if (detailItem != null) {
            PlatformBackHandler(true) { detail = null }
            // Load this host's last attempts once when the card opens (re-keyed if
            // a different host is opened); refreshes on the periodic state tick.
            val history = remember(detailItem.id, state) { engine.hostHistory(detailItem.id, 25) }
            CatalogDetailPage(
                detailItem,
                history = history,
                onCopy = { engine.tgLink(detailItem.id)?.let(engine::copyToClipboard) },
                onOpen = { engine.tgLink(detailItem.id)?.let(engine::openLink) },
                onMakeRelay = { engine.pin(detailItem.id, true); detail = null },
                onTest = { engine.testHostNow(detailItem.id) },
                onStopTest = { engine.stopHostTest() },
                testingThis = state.testHostId == detailItem.id,
                testRunning = state.testRunning,
                testSummary = state.testSummary,
                onBack = { detail = null },
            )
            return@CompositionLocalProvider
        }

        val manageModeCode = manageMode
        if (manageModeCode != null) {
            PlatformBackHandler(true) { manageMode = null }
            CatalogModeManagePage(
                manageModeCode,
                onBack = { manageMode = null },
                onResetStats = { engine.resetModeStats(manageModeCode) },
                onForget = { engine.forgetModeHosts(manageModeCode) },
                onCopyFrom = { src -> engine.copyModeStats(src, manageModeCode) },
            )
            return@CompositionLocalProvider
        }

        // Full-screen guide overlays everything else.
        if (showGuide) {
            PlatformBackHandler(true) { showGuide = false }
            ConnectGuidePage(
                state,
                onCopy = engine::copyToClipboard,
                onOpen = engine::openLink,
                onBack = { showGuide = false },
            )
            return@CompositionLocalProvider
        }

        // Full-screen "Ещё" sub-pages.
        val mp = morePage
        if (mp != null) {
            // Back from the bulk-add page returns to the subscriptions list, not the menu.
            val back: () -> Unit = { morePage = if (mp == MoreDest.ADD_SOURCES) MoreDest.SOURCES else null }
            PlatformBackHandler(true) { back() }
            MoreFullPage(mp, moreCallbacks(), back)
            return@CompositionLocalProvider
        }

        // Full-screen quick-switch page (reached from the Connector tab button).
        if (quickSettings) {
            PlatformBackHandler(true) { quickSettings = false }
            QuickSettingsPage(moreCallbacks()) { quickSettings = false }
            return@CompositionLocalProvider
        }

        // On any non-main tab, the system back returns to the Connector tab
        // instead of closing the app.
        PlatformBackHandler(tab != Tabs.CONNECTOR) { tab = Tabs.CONNECTOR }

        Surface(Modifier.fillMaxSize(), color = AppColors.background) {
            // One global scroll for the whole window; the tab bar sticks to the
            // top once the header scrolls past it.
            LazyColumn(Modifier.fillMaxSize().keyPageScroll(listState), state = listState) {
                item { TitleRow(settings.langCode) { code -> engine.updateSettings(settings.copy(langCode = code)) } }
                if (state.setupNeeded && state.proxyEnabled) item { SetupLine(state) { showGuide = true } }
                if (!state.notificationsOk) item {
                    NotifLine(onInfo = { notifInfo = true }, onFix = { engine.requestNotifications() })
                }
                item { ToggleRow(state, engine) }
                item { PoolLine(state) }

                stickyHeader {
                    TabBar(tab) {
                        tab = it
                        scope.launch { listState.animateScrollToItem(0) }
                    }
                }

                when (tab) {
                    Tabs.CONNECTOR -> item {
                        ConnectorContent(state, onOpenGuide = { showGuide = true }, onOpenQuick = { quickSettings = true })
                    }
                    Tabs.SCAN -> item { ScanContent(state, onScanNow = engine::scanNow, onSetScanMode = engine::setScanMode) }
                    Tabs.CATALOG -> item {
                        CatalogContent(
                            items = catalog,
                            activeMode = state.activeMode,
                            catalogForMode = { code -> engine.catalogForMode(code) },
                            onManageMode = { manageMode = it },
                            onClick = { detail = it },
                        )
                    }
                    Tabs.LOGS -> logsItems(
                        logs = logs,
                        logTab = logTab,
                        onLogTab = { logTab = it },
                        expanded = expandedSessions.toSet(),
                        onToggleSession = { k ->
                            if (k in expandedSessions) expandedSessions.remove(k) else expandedSessions.add(k)
                        },
                        errorsOnly = logErrorsOnly,
                        onErrorsOnly = { logErrorsOnly = it },
                    )
                    Tabs.MORE -> item { MoreScreen(onOpen = { morePage = it }, onOpenGuide = { showGuide = true }, hotkeysSupported = engine.hotkeysSupported(), volPatternSupported = engine.volPatternSupported()) }
                }
            }
        }
      }
    }
}

// === Header pieces ======================================================

/** Row 1 — the app title + a language switcher (globe) on the right, so the UI
 *  language can be changed without opening Settings. */
@Composable
private fun TitleRow(langCode: String, onPickLang: (String) -> Unit) {
    Row(
        Modifier.fillMaxWidth().padding(start = 14.dp, end = 8.dp, top = 12.dp, bottom = 2.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            "AutoConnector for Telegram",
            fontWeight = FontWeight.Bold,
            fontSize = 19.sp,
            color = AppColors.onSurface,
        )
        Spacer(Modifier.weight(1f))
        var expanded by remember { mutableStateOf(false) }
        // Flags + English + native, from the shared registry — same list as Settings.
        val langs = listOf("auto" to (LocalStrings.current.langAuto + "  🌐")) +
            io.autoconnector.i18n.LANGUAGES.map { it.code to io.autoconnector.i18n.langMenuLabel(it) }
        Box {
            // Compact (33dp vs the default 40dp) so the language button doesn't
            // inflate the title row height (~7px back).
            IconButton(onClick = { expanded = true }, modifier = Modifier.size(33.dp)) {
                Icon(Icons.Filled.Language, contentDescription = "Language", tint = AppColors.accent, modifier = Modifier.size(22.dp))
            }
            // Bounded height + built-in scroll so the 26-language list stays on screen.
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.heightIn(max = 420.dp),
            ) {
                langs.forEach { (code, label) ->
                    DropdownMenuItem(
                        text = { Text(if (code == langCode) "✓ $label" else label) },
                        onClick = { onPickLang(code); expanded = false },
                    )
                }
            }
        }
    }
}

/** Row 2 — single blinking line shown only while the relay isn't wired into Telegram. */
@Composable
private fun SetupLine(s: EngineState, onFix: () -> Unit) {
    val a = 1f  // static (was a non-stop blink that redrew at 60 fps → idle CPU)
    Row(
        Modifier.fillMaxWidth().clickable(onClick = onFix).padding(horizontal = 14.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val tr = LocalStrings.current
        Text(
            tr.notConfigured,
            color = AppColors.red,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            modifier = Modifier.weight(1f).alpha(a),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Spacer(Modifier.size(8.dp))
        Box(
            Modifier
                .background(AppColors.background, RoundedCornerShape(8.dp))
                .border(1.5.dp, AppColors.accent, RoundedCornerShape(8.dp))
                .clickable(onClick = onFix)
                .padding(horizontal = 14.dp, vertical = 6.dp),
        ) {
            Text(tr.howToSetup, color = AppColors.accent, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
    }
}

/** Notifications-off warning — blinking red line + a button to fix it. */
@Composable
private fun NotifLine(onInfo: () -> Unit, onFix: () -> Unit) {
    val a = 1f  // static (was a non-stop blink that redrew at 60 fps → idle CPU)
    Row(
        Modifier.fillMaxWidth().clickable(onClick = onInfo).padding(horizontal = 14.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val tr = LocalStrings.current
        Text(
            tr.notifOff,
            color = AppColors.red,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            modifier = Modifier.weight(1f).alpha(a),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Spacer(Modifier.size(8.dp))
        Box(
            Modifier
                .background(AppColors.background, RoundedCornerShape(8.dp))
                .border(1.5.dp, AppColors.accent, RoundedCornerShape(8.dp))
                .clickable(onClick = onFix)
                .padding(horizontal = 14.dp, vertical = 6.dp),
        ) {
            Text(tr.enable, color = AppColors.accent, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
    }
}

/** Row 3 — the two master toggles, no card chrome around them. */
@Composable
private fun ToggleRow(s: EngineState, engine: Engine) {
    Row(
        Modifier.fillMaxWidth().padding(start = 14.dp, end = 14.dp, top = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        val tr = LocalStrings.current
        // Connector: switch on the LEFT, then label. Scan: label then switch (right).
        // Connector gets 60% of the row width, Scan 40%.
        BareSwitch("${tr.connector} ${tr.onOff(s.proxyEnabled)}", s.proxyEnabled, Modifier.weight(0.6f), switchFirst = true) { engine.setProxyEnabled(it) }
        BareSwitch("${tr.scan} ${tr.onOff(s.scanEnabled)}", s.scanEnabled, Modifier.weight(0.4f), switchFirst = false) { engine.setScanEnabled(it) }
    }
}

private fun onOff(v: Boolean) = if (v) "ON" else "OFF"

@Composable
private fun BareSwitch(label: String, value: Boolean, modifier: Modifier, switchFirst: Boolean, onChange: (Boolean) -> Unit) {
    val sw = @Composable {
        Switch(
            value,
            onChange,
            Modifier.scale(1.05f),
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = AppColors.accent,
            ),
        )
    }
    val lbl = @Composable { m: Modifier ->
        Text(
            label, m,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = if (value) AppColors.onSurface else AppColors.onSurfaceMuted,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
    Row(modifier, verticalAlignment = Alignment.CenterVertically) {
        if (switchFirst) {
            sw(); Spacer(Modifier.size(8.dp)); lbl(Modifier.weight(1f))
        } else {
            Spacer(Modifier.weight(1f)); lbl(Modifier); Spacer(Modifier.size(8.dp)); sw()
        }
    }
}

/** Row 4 — proxy-pool health; turns into a red alarm when the pool runs dry. */
@Composable
private fun PoolLine(s: EngineState) {
    val tr = LocalStrings.current
    if (s.aliveCount < 10) {
        Text(
            tr.fewProxies(s.aliveCount),
            color = AppColors.red,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            modifier = Modifier.fillMaxWidth().padding(start = 14.dp, end = 14.dp, top = 8.dp, bottom = 2.dp),
        )
    } else {
        Text(
            tr.alivePool(s.aliveCount, s.aliveWithin15, s.totalCount),
            color = AppColors.onSurface,
            fontSize = 14.sp,
            modifier = Modifier.fillMaxWidth().padding(start = 14.dp, end = 14.dp, top = 8.dp, bottom = 2.dp),
        )
    }
}

// === Sticky tab bar =====================================================

@Composable
private fun TabBar(selected: Tabs, onSelect: (Tabs) -> Unit) {
    // Opaque background so scrolled content passes cleanly beneath it.
    Surface(color = AppColors.background, modifier = Modifier.fillMaxWidth()) {
        Column {
            Spacer(Modifier.height(6.dp))
            Row(Modifier.fillMaxWidth().padding(horizontal = 3.dp)) {
                Tabs.entries.forEach { t -> TabCell(t, t == selected, Modifier.weight(1f)) { onSelect(t) } }
            }
            Spacer(Modifier.height(4.dp))
            // Hairline under the whole bar so it reads as a pinned strip.
            Box(Modifier.fillMaxWidth().height(1.dp).background(AppColors.cardBorder))
        }
    }
}

@Composable
private fun TabCell(t: Tabs, active: Boolean, modifier: Modifier, onClick: () -> Unit) {
    val shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
    val tint = if (active) AppColors.accent else AppColors.onSurfaceMuted
    Column(
        modifier
            .padding(horizontal = 2.dp)
            .clip(shape)
            .then(
                if (active) Modifier.background(AppColors.card).border(1.dp, AppColors.accent, shape)
                else Modifier,
            )
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Accent line across the very top of the active tab.
        Box(
            Modifier.fillMaxWidth().height(3.dp)
                .background(if (active) AppColors.accent else Color.Transparent),
        )
        val tr = LocalStrings.current
        val label = when (t) {
            Tabs.CONNECTOR -> tr.tabConnector
            Tabs.SCAN -> tr.tabScan
            Tabs.CATALOG -> tr.tabCatalog
            Tabs.LOGS -> tr.tabLogs
            Tabs.MORE -> tr.tabMore
        }
        Spacer(Modifier.height(2.dp))
        Icon(t.icon, label, tint = tint, modifier = Modifier.size(18.dp))
        Text(
            label,
            color = tint,
            fontSize = 14.sp,
            fontWeight = if (active) FontWeight.Bold else FontWeight.Normal,
            maxLines = 1,
            softWrap = false,
        )
        Spacer(Modifier.height(4.dp))
    }
}
