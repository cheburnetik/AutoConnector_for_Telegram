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
import androidx.compose.material3.Icon
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
import io.autoconnector.ui.screens.CatalogDetailPage
import io.autoconnector.ui.screens.ConnectGuidePage
import io.autoconnector.ui.screens.ConnectorContent
import io.autoconnector.ui.screens.MoreCallbacks
import io.autoconnector.ui.screens.MoreDest
import io.autoconnector.ui.screens.MoreFullPage
import io.autoconnector.ui.screens.MoreScreen
import io.autoconnector.ui.screens.QuickSettingsPage
import io.autoconnector.ui.screens.ScanContent
import io.autoconnector.ui.screens.catalogItems
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
        var morePage by remember { mutableStateOf<MoreDest?>(null) }
        var quickSettings by remember { mutableStateOf(false) }
        var notifInfo by remember { mutableStateOf(false) }
        val listState = rememberLazyListState()
        val scope = rememberCoroutineScope()

      CompositionLocalProvider(LocalStrings provides stringsFor(settings.langCode)) {
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
            netLogPath = engine.netLogPath(),
            onOpenNetLogFolder = engine::openNetLogFolder,
            onUpdateSettings = engine::updateSettings,
            sources = sources,
            onAddSource = engine::addSource,
            onRemoveSource = engine::removeSource,
            onToggleSource = engine::setSourceEnabled,
            state = state,
            exportLinks = engine::exportAliveLinks,
            onCopy = engine::copyToClipboard,
            handshakeStats = engine::handshakeStats,
            onResetStats = engine::resetStats,
            onResetCatalogStats = engine::resetCatalogStats,
            onClearHosts = engine::clearDownloadedHosts,
            appInfo = engine.appInfo(),
            onOpenUrl = engine::openLink,
        )

        val detailItem = detail
        if (detailItem != null) {
            PlatformBackHandler(true) { detail = null }
            CatalogDetailPage(
                detailItem,
                onCopy = { engine.tgLink(detailItem.id)?.let(engine::copyToClipboard) },
                onOpen = { engine.tgLink(detailItem.id)?.let(engine::openLink) },
                onMakeRelay = { engine.pin(detailItem.id, true); detail = null },
                onBack = { detail = null },
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
            PlatformBackHandler(true) { morePage = null }
            MoreFullPage(mp, moreCallbacks()) { morePage = null }
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
            LazyColumn(Modifier.fillMaxSize(), state = listState) {
                item { TitleRow() }
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
                    Tabs.SCAN -> item { ScanContent(state) }
                    Tabs.CATALOG -> catalogItems(catalog, onClick = { detail = it })
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
                    Tabs.MORE -> item { MoreScreen(onOpen = { morePage = it }, onOpenGuide = { showGuide = true }) }
                }
            }
        }
      }
    }
}

// === Header pieces ======================================================

/** Row 1 — the app title, dressed up with a gradient badge instead of a bare dot. */
@Composable
private fun TitleRow() {
    Row(
        Modifier.fillMaxWidth().padding(start = 14.dp, end = 14.dp, top = 12.dp, bottom = 2.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            "AutoConnector for Telegram",
            fontWeight = FontWeight.Bold,
            fontSize = 19.sp,
            color = AppColors.onSurface,
        )
    }
}

/** Row 2 — single blinking line shown only while the relay isn't wired into Telegram. */
@Composable
private fun SetupLine(s: EngineState, onFix: () -> Unit) {
    val a = blinkAlpha(periodMs = 4200)
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
    val a = blinkAlpha(periodMs = 2000)
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
        BareSwitch("${tr.connector} ${tr.onOff(s.proxyEnabled)}", s.proxyEnabled, Modifier.weight(1f), alignEnd = false) { engine.setProxyEnabled(it) }
        BareSwitch("${tr.scan} ${tr.onOff(s.scanEnabled)}", s.scanEnabled, Modifier.weight(1f), alignEnd = true) { engine.setScanEnabled(it) }
    }
}

private fun onOff(v: Boolean) = if (v) "ON" else "OFF"

@Composable
private fun BareSwitch(label: String, value: Boolean, modifier: Modifier, alignEnd: Boolean, onChange: (Boolean) -> Unit) {
    Row(modifier, verticalAlignment = Alignment.CenterVertically) {
        if (alignEnd) Spacer(Modifier.weight(1f))
        val labelMod = if (alignEnd) Modifier else Modifier.weight(1f)
        Text(
            label,
            labelMod,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = if (value) AppColors.onSurface else AppColors.onSurfaceMuted,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Spacer(Modifier.size(6.dp))
        Switch(
            value,
            onChange,
            Modifier.scale(1.1f),
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = AppColors.accent,
            ),
        )
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
