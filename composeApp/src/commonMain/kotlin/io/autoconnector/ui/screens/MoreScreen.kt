package io.autoconnector.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.HelpOutline
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import io.autoconnector.ui.appLogo
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.layout
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.autoconnector.engine.AppInfo
import io.autoconnector.engine.EngineSettings
import io.autoconnector.engine.EngineState
import io.autoconnector.engine.ExpEngineOption
import io.autoconnector.engine.HandshakeOption
import io.autoconnector.engine.HandshakeStatRow
import io.autoconnector.engine.ScanParams
import io.autoconnector.engine.SourceItem
import io.autoconnector.i18n.LocalStrings
import io.autoconnector.i18n.modeLabel
import kotlin.math.log10
import kotlin.math.pow
import kotlin.math.roundToInt
import io.autoconnector.i18n.Strings
import io.autoconnector.ui.components.CardBox
import io.autoconnector.ui.components.keyPageScroll
import io.autoconnector.ui.components.Caption
import io.autoconnector.ui.components.StatTable
import io.autoconnector.ui.components.cell
import io.autoconnector.ui.theme.AppColors
import io.autoconnector.ui.theme.monospaceFontFamily
import io.autoconnector.ui.theme.sansFontFamily

enum class MoreDest { SETTINGS, SOURCES, ADD_SOURCES, STATS, EXPORT, BACKUP_EXPORT, BACKUP_IMPORT, HOTKEYS, ABOUT }

private fun titleFor(dest: MoreDest, t: Strings) = when (dest) {
    MoreDest.SETTINGS -> t.settings
    MoreDest.SOURCES -> t.subscriptions
    MoreDest.ADD_SOURCES -> t.addSourcesTitle
    MoreDest.STATS -> t.statistics
    MoreDest.EXPORT -> t.export
    MoreDest.BACKUP_EXPORT -> t.backupExportTitle
    MoreDest.BACKUP_IMPORT -> t.backupImportTitle
    MoreDest.HOTKEYS -> t.hotkeys
    MoreDest.ABOUT -> t.about
}

class MoreCallbacks(
    val settings: EngineSettings,
    val handshakeOptions: List<HandshakeOption>,
    val expEngineOptions: List<ExpEngineOption>,
    val connectEngineOptions: List<ExpEngineOption>,
    val scanParamsFor: (Int, Int, Int, Float) -> ScanParams,
    val netLogPath: String?,
    val onOpenNetLogFolder: () -> Unit,
    val dataDirPath: String,
    val onOpenDataFolder: () -> Unit,
    val onUpdateSettings: (EngineSettings) -> Unit,
    val sources: List<SourceItem>,
    val onAddSource: (String) -> Unit,
    val onAddSourcesBulk: (String) -> Int,
    val onAddManualProxies: (String) -> Int,
    val onRemoveSource: (Long) -> Unit,
    val onToggleSource: (Long, Boolean) -> Unit,
    val onRefreshSource: (Long) -> Unit,
    val onOpenDest: (MoreDest) -> Unit,
    val state: EngineState,
    val exportLinks: () -> List<String>,
    val onExportToFile: () -> String?,
    // Universal backup (settings/subs/hosts) — JSON shown in a text field.
    val onBuildBackup: (Boolean, Boolean, Boolean) -> String,
    val onImportText: (String, Boolean, Boolean, Boolean) -> String,
    val onSaveToFile: (String, String) -> String,
    val onPickFile: () -> String?,
    val fileIoSupported: Boolean,
    // Per-network-mode actions (wired in App.kt by these exact names).
    val onSetScanMode: (String) -> Unit,
    val onResetModeStats: (String) -> Unit,
    val onForgetModeHosts: (String) -> Unit,
    val onExportLinksForMode: (String) -> List<String>,
    val onExportFileForMode: (String) -> String?,
    val onCopy: (String) -> Unit,
    val handshakeStats: () -> List<HandshakeStatRow>,
    val onResetStats: () -> Unit,
    val onResetCatalogStats: () -> Unit,
    val onClearHosts: () -> Unit,
    val onFactoryReset: () -> Unit,
    // Desktop global hotkeys (unused on Android — page is hidden there).
    val hotkeyCopyLabel: String,
    val hotkeyOpenLabel: String,
    val hotkeysEnabled: Boolean,
    val hotkeyLetter: String,
    val onSetHotkeysEnabled: (Boolean) -> Unit,
    val onSetHotkeyLetter: (String) -> Unit,
    val appInfo: AppInfo,
    val onOpenUrl: (String) -> Unit,
)

/** The "More" tab body — just the menu. */
@Composable
fun MoreScreen(onOpen: (MoreDest) -> Unit, onOpenGuide: () -> Unit, hotkeysSupported: Boolean = false) {
    val t = LocalStrings.current
    Column(Modifier.fillMaxSize().padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        MenuEntry(t.setupPortsTitle, t.setupPortsSub, onOpenGuide)
        MenuEntry(t.settings, t.settingsSub) { onOpen(MoreDest.SETTINGS) }
        MenuEntry(t.subscriptions, t.subscriptionsSub) { onOpen(MoreDest.SOURCES) }
        MenuEntry(t.statistics, t.statisticsSub) { onOpen(MoreDest.STATS) }
        MenuEntry(t.export, t.exportSub) { onOpen(MoreDest.EXPORT) }
        // Desktop-only: global hotkeys page (no such thing on Android).
        if (hotkeysSupported) MenuEntry(t.hotkeys, t.hotkeysSub) { onOpen(MoreDest.HOTKEYS) }
        MenuEntry(t.about, t.aboutSub) { onOpen(MoreDest.ABOUT) }
    }
}

/** Full-screen page (with a back top-bar) for one [MoreDest]. */
@Composable
fun MoreFullPage(dest: MoreDest, cb: MoreCallbacks, onBack: () -> Unit) {
    val t = LocalStrings.current
    androidx.compose.material3.Surface(Modifier.fillMaxSize(), color = AppColors.background) {
        Column(Modifier.fillMaxSize()) {
            TopBar(titleFor(dest, t), onBack)
            when (dest) {
                MoreDest.SETTINGS -> SettingsPage(cb)
                MoreDest.SOURCES -> SourcesPage(cb)
                MoreDest.ADD_SOURCES -> AddSourcesPage(cb)
                MoreDest.STATS -> StatsPage(cb)
                MoreDest.EXPORT -> ExportPage(cb)
                MoreDest.BACKUP_EXPORT -> BackupExportPage(cb)
                MoreDest.BACKUP_IMPORT -> BackupImportPage(cb)
                MoreDest.HOTKEYS -> HotkeysPage(cb)
                MoreDest.ABOUT -> AboutPage(cb)
            }
        }
    }
}

/**
 * Full-screen "quick switch" page reachable from a small button on the
 * Connector tab. Three single-choice lists, in the order the user asked for:
 * proxying-engine shaping, connect engine, anti-DPI. Picking any item applies
 * that one setting immediately and closes the page (via [onBack]).
 */
@Composable
fun QuickSettingsPage(cb: MoreCallbacks, onBack: () -> Unit) {
    val t = LocalStrings.current
    val s = cb.settings
    var showHelp by remember { mutableStateOf(false) }
    androidx.compose.material3.Surface(Modifier.fillMaxSize(), color = AppColors.background) {
        Column(Modifier.fillMaxSize()) {
            TopBar(t.quickSwitchTitle, onBack)
            val qScroll = rememberScrollState()
            Column(
                Modifier.fillMaxSize().keyPageScroll(qScroll).verticalScroll(qScroll).padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                // Small toggle: collapsed by default (item names only); expand to
                // show the page intro + a description under every option.
                TextButton(onClick = { showHelp = !showHelp }, contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 6.dp, vertical = 4.dp)) {
                    Icon(Icons.AutoMirrored.Filled.HelpOutline, null, tint = AppColors.accent, modifier = Modifier.size(18.dp))
                    Spacer(Modifier.width(6.dp))
                    Text(if (showHelp) t.helpHide else t.helpShow, color = AppColors.accent, fontSize = 14.sp)
                }
                if (showHelp) {
                    Text(
                        t.quickSwitchIntro,
                        color = AppColors.onSurfaceMuted, fontSize = 13.sp,
                        modifier = Modifier.padding(bottom = 6.dp),
                    )
                }

                // 1) Дробление проксирования — socket wire shaping.
                SubTitle(t.expEngineTitle)
                cb.expEngineOptions.forEach { opt ->
                    QuickChoice(opt.label, if (showHelp) opt.description else "", s.expEngineMode == opt.code) {
                        cb.onUpdateSettings(s.copy(expEngineMode = opt.code)); onBack()
                    }
                }

                Spacer(Modifier.height(10.dp))

                // 2) Движок коннекта — how the relay finds a working upstream.
                SubTitle(t.expConnectTitle)
                cb.connectEngineOptions.forEach { opt ->
                    QuickChoice(opt.label, if (showHelp) opt.description else "", s.relayConnectMode == opt.code) {
                        cb.onUpdateSettings(s.copy(relayConnectMode = opt.code)); onBack()
                    }
                }

                Spacer(Modifier.height(10.dp))

                // 3) Анти-DPI — handshake trick (AUTO/NONE entries are special).
                SubTitle(t.antiDpiTrick)
                var seenSpecial = 0
                cb.handshakeOptions.forEach { opt ->
                    val label = when {
                        opt.special && seenSpecial++ == 0 -> t.dpiAutoLabel
                        opt.special -> t.dpiNoneLabel
                        else -> opt.label
                    }
                    QuickChoice(label, "", s.handshakeMode == opt.ordinal) {
                        cb.onUpdateSettings(s.copy(handshakeMode = opt.ordinal)); onBack()
                    }
                }
                Spacer(Modifier.height(16.dp))
            }
        }
    }
}

@Composable
private fun QuickChoice(title: String, desc: String, selected: Boolean, onSelect: () -> Unit) {
    Row(
        Modifier.fillMaxWidth().clickable(onClick = onSelect).padding(vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(checked = selected, onCheckedChange = { onSelect() })
        Spacer(Modifier.width(4.dp))
        Column(Modifier.weight(1f)) {
            Text(
                title,
                fontSize = 16.sp,
                fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
                color = if (selected) AppColors.accent else AppColors.onSurface,
            )
            if (desc.isNotEmpty()) Text(desc, color = AppColors.onSurfaceMuted, fontSize = 13.sp)
        }
    }
}

@Composable
private fun TopBar(title: String, onBack: () -> Unit) {
    Box(Modifier.fillMaxWidth().background(Brush.horizontalGradient(listOf(AppColors.accent, AppColors.accentDark)))) {
        Row(Modifier.fillMaxWidth().height(54.dp).padding(horizontal = 4.dp), verticalAlignment = Alignment.CenterVertically) {
            IconButton(onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, LocalStrings.current.back, tint = Color.White) }
            Text(title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }
    }
}

@Composable
private fun MenuEntry(title: String, sub: String, onClick: () -> Unit) {
    CardBox(Modifier.fillMaxWidth().clickable(onClick = onClick)) {
        Column {
            Text(title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(sub, color = AppColors.onSurfaceMuted, fontSize = 14.sp)
        }
    }
}

// === Settings ===========================================================

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun SettingsPage(cb: MoreCallbacks) {
    val t = LocalStrings.current
    val s = cb.settings
    var portA by remember { mutableStateOf(s.portA.toString()) }
    var portB by remember { mutableStateOf(s.portB.toString()) }
    var hs by remember { mutableStateOf(s.handshakeMode) }
    var notif by remember { mutableStateOf(s.notificationsEnabled) }
    var fakeTls by remember { mutableStateOf(s.onlyFakeTls) }
    var scanInt by remember { mutableStateOf(s.scanIntervalMin.toString()) }
    var checkInt by remember { mutableStateOf(s.checkIntervalMin.toString()) }
    var batch by remember { mutableStateOf(s.checkBatch.toString()) }
    var conc by remember { mutableStateOf(s.checkConcurrency.toString()) }
    var minRescan by remember { mutableStateOf(s.minRescanMin.toString()) }
    var spVpn by remember { mutableStateOf(s.speedVpn.toString()) }
    var spWifi by remember { mutableStateOf(s.speedWifi.toString()) }
    var spLte by remember { mutableStateOf(s.speedLte.toString()) }
    var spEth by remember { mutableStateOf(s.speedEthernet.toString()) }
    var spWp by remember { mutableStateOf(s.speedWp.toString()) }
    var subVpn by remember { mutableStateOf(s.subIntervalVpn.toString()) }
    var subWifi by remember { mutableStateOf(s.subIntervalWifi.toString()) }
    var subLte by remember { mutableStateOf(s.subIntervalLte.toString()) }
    var subEth by remember { mutableStateOf(s.subIntervalEthernet.toString()) }
    var subWp by remember { mutableStateOf(s.subIntervalWp.toString()) }
    // Scan-mode override: applied immediately via cb.onSetScanMode (NOT through
    // save()), so it is not part of the EngineSettings copy below.
    var scanMode by remember { mutableStateOf(s.scanMode) }
    var aliveThr by remember { mutableStateOf(s.adaptiveAliveThreshold.toString()) }
    var fastMul by remember { mutableStateOf(s.fastSpeedMultiplier.toString()) }
    var lazyThr by remember { mutableStateOf(s.lazyAliveThreshold.toString()) }
    var lazyMul by remember { mutableStateOf(s.lazySpeedMultiplier.toString()) }
    var wifiOnly by remember { mutableStateOf(s.wifiOnly) }
    var charging by remember { mutableStateOf(s.chargingOnly) }
    var skipLow by remember { mutableStateOf(s.skipLowBattery) }
    var dpiRelay by remember { mutableStateOf(s.dpiApplyRelay) }
    var dpiProbes by remember { mutableStateOf(s.dpiApplyProbes) }
    var dpiDirect by remember { mutableStateOf(s.dpiApplyDirect) }
    var linkHttp by remember { mutableStateOf(s.proxyLinkHttp) }
    var vpnMode by remember { mutableStateOf(s.proxyModeCode) }
    var lang by remember { mutableStateOf(s.langCode) }
    var expEngine by remember { mutableStateOf(s.expEngineMode) }
    var connEngine by remember { mutableStateOf(s.relayConnectMode) }
    var raceWidth by remember { mutableStateOf(s.relayRaceWidth) }
    var breadth by remember { mutableStateOf(s.relayBreadth) }
    var connTimeout by remember { mutableStateOf(s.relayConnectTimeoutMs) }
    var netLog by remember { mutableStateOf(s.netLogEnabled) }
    var hsExpanded by remember { mutableStateOf(false) }
    var expExpanded by remember { mutableStateOf(false) }
    var connExpanded by remember { mutableStateOf(false) }
    var help by remember { mutableStateOf<Pair<String, String>?>(null) }

    fun save() {
        cb.onUpdateSettings(
            s.copy(
                portA = portA.toIntOrNull() ?: s.portA,
                portB = portB.toIntOrNull() ?: s.portB,
                handshakeMode = hs,
                notificationsEnabled = notif,
                onlyFakeTls = fakeTls,
                proxyModeCode = vpnMode,
                scanIntervalMin = scanInt.toIntOrNull() ?: s.scanIntervalMin,
                checkIntervalMin = checkInt.toIntOrNull() ?: s.checkIntervalMin,
                checkBatch = batch.toIntOrNull() ?: s.checkBatch,
                checkConcurrency = conc.toIntOrNull() ?: s.checkConcurrency,
                speedVpn = spVpn.toFloatOrNull() ?: s.speedVpn,
                speedWifi = spWifi.toFloatOrNull() ?: s.speedWifi,
                speedLte = spLte.toFloatOrNull() ?: s.speedLte,
                speedEthernet = spEth.toFloatOrNull() ?: s.speedEthernet,
                speedWp = spWp.toFloatOrNull() ?: s.speedWp,
                subIntervalVpn = subVpn.toIntOrNull() ?: s.subIntervalVpn,
                subIntervalWifi = subWifi.toIntOrNull() ?: s.subIntervalWifi,
                subIntervalLte = subLte.toIntOrNull() ?: s.subIntervalLte,
                subIntervalEthernet = subEth.toIntOrNull() ?: s.subIntervalEthernet,
                subIntervalWp = subWp.toIntOrNull() ?: s.subIntervalWp,
                adaptiveAliveThreshold = aliveThr.toIntOrNull() ?: s.adaptiveAliveThreshold,
                fastSpeedMultiplier = fastMul.toFloatOrNull() ?: s.fastSpeedMultiplier,
                lazyAliveThreshold = lazyThr.toIntOrNull() ?: s.lazyAliveThreshold,
                lazySpeedMultiplier = lazyMul.toFloatOrNull() ?: s.lazySpeedMultiplier,
                wifiOnly = wifiOnly,
                chargingOnly = charging,
                skipLowBattery = skipLow,
                dpiApplyRelay = dpiRelay,
                dpiApplyProbes = dpiProbes,
                dpiApplyDirect = dpiDirect,
                proxyLinkHttp = linkHttp,
                langCode = lang,
                expEngineMode = expEngine,
                netLogEnabled = netLog,
                relayConnectMode = connEngine,
                relayRaceWidth = raceWidth,
                relayBreadth = breadth,
                relayConnectTimeoutMs = connTimeout,
                scanMode = scanMode,
                minRescanMin = minRescan.toIntOrNull() ?: s.minRescanMin,
            )
        )
    }
    androidx.compose.runtime.DisposableEffect(Unit) { onDispose { save() } }

    help?.let { (ht, hb) ->
        AlertDialog(
            onDismissRequest = { help = null },
            confirmButton = { TextButton({ help = null }) { Text(t.gotIt) } },
            title = { Text(ht, fontWeight = FontWeight.Bold) },
            text = {
                // Long help bodies must scroll — several overflow a phone height.
                Column(Modifier.heightIn(max = 420.dp).verticalScroll(rememberScrollState())) {
                    Text(hb, fontSize = 15.sp)
                }
            },
        )
    }

    val settingsScroll = rememberScrollState()
    Column(
        Modifier.fillMaxSize().keyPageScroll(settingsScroll).verticalScroll(settingsScroll).padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        // Language — collapsed behind a single button so the (now long) list of
        // languages doesn't inflate the settings page height.
        Section(t.language, null)
        var langExpanded by remember { mutableStateOf(false) }
        // Labels: English name first, then the native name in parentheses.
        val langOptions = listOf(
            "auto" to t.langAuto,
            "en" to "English",
            "ru" to "Russian (${t.langRu})",
            "fa" to "Persian (${t.langFa})",
            "zh" to "Simplified Chinese (${t.langZh})",
            "ar" to "Arabic (${t.langAr})",
            "ur" to "Urdu (${t.langUr})",
            "tr" to "Turkish (${t.langTr})",
            "id" to "Indonesian (${t.langId})",
            "hi" to "Hindi (${t.langHi})",
            "bn" to "Bengali (${t.langBn})",
            "my" to "Burmese (${t.langMy})",
        )
        val curLangLabel = langOptions.firstOrNull { it.first == lang }?.second ?: t.langAuto
        Box {
            OutlinedButton(onClick = { langExpanded = true }, modifier = Modifier.fillMaxWidth()) {
                Text("Language · ${t.langWord}: $curLangLabel", fontSize = 14.sp)
            }
            DropdownMenu(expanded = langExpanded, onDismissRequest = { langExpanded = false }) {
                langOptions.forEach { (code, label) ->
                    DropdownMenuItem(
                        text = { Text(if (code == lang) "✓ $label" else label) },
                        onClick = { lang = code; save(); langExpanded = false },
                    )
                }
            }
        }

        Section(t.relayPorts) { help = t.relayPorts to t.relayPortsHelp }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            NumField(portA, { portA = it }, t.portA, Modifier.weight(1f))
            NumField(portB, { portB = it }, t.portB, Modifier.weight(1f))
        }

        Section(t.vpnSection) { help = t.vpnSection to t.vpnHelp }
        ChoiceRow(t.viaMtproto, t.viaMtprotoSub, selected = vpnMode != "vpn_only") { vpnMode = "use"; save() }
        ChoiceRow(t.directly, t.directlySub, selected = vpnMode == "vpn_only") { vpnMode = "vpn_only"; save() }

        Section(t.linkFormat) { help = t.linkFormat to t.linkFormatHelp }
        ChoiceRow(t.linkTg, t.linkTgSub, selected = !linkHttp) { linkHttp = false; save() }
        ChoiceRow(t.linkHttp, t.linkHttpSub, selected = linkHttp) { linkHttp = true; save() }

        // Notifications.
        var showNotifInfo by remember { mutableStateOf(false) }
        if (showNotifInfo) {
            AlertDialog(
                onDismissRequest = { showNotifInfo = false },
                confirmButton = { TextButton({ showNotifInfo = false }) { Text(t.gotIt) } },
                title = { Text(t.notifWhyTitle, fontWeight = FontWeight.Bold) },
                text = { Text(t.notifWhyBody, fontSize = 15.sp) },
            )
        }
        Section(t.notifications, null)
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Row(Modifier.weight(1f).clickable { showNotifInfo = true }, verticalAlignment = Alignment.CenterVertically) {
                Text(t.notifications, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Spacer(Modifier.width(6.dp))
                Icon(Icons.Filled.Info, t.details, tint = AppColors.accent, modifier = Modifier.size(20.dp))
            }
            Switch(notif, { notif = it; save() })
        }
        if (!notif) {
            Text(t.notifPlea, color = AppColors.red, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }

        // Scan mode: Auto follows the detected transport, Manual pins a specific
        // network mode (each keeps its own ratings + scan/sub intensity).
        Section(t.modePickerTitle) { help = t.modePickerTitle to t.modeHelp }
        FlowRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            FilterChip(
                selected = scanMode == "auto",
                onClick = { scanMode = "auto"; cb.onSetScanMode("auto") },
                label = { Text(t.autoSelect, fontSize = 14.sp) },
            )
            FilterChip(
                selected = scanMode != "auto",
                onClick = {
                    val m = if (scanMode == "auto") "vpn" else scanMode
                    scanMode = m; cb.onSetScanMode(m)
                },
                label = { Text(t.manualSelect, fontSize = 14.sp) },
            )
        }
        // When Manual is active, a concrete mode can be picked below; hidden on Auto.
        if (scanMode != "auto") {
            FlowRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                listOf("vpn", "wifi", "lte", "ethernet", "wp").forEach { code ->
                    FilterChip(
                        selected = scanMode == code,
                        onClick = { scanMode = code; cb.onSetScanMode(code) },
                        label = { Text(modeLabel(code), fontSize = 14.sp) },
                    )
                }
            }
        }

        // 1) Subscription re-download intensity — minutes, separately per mode.
        Section(t.subIntensityTitle) { help = t.subIntensityTitle to t.subIntensityHint }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            LabeledNumField(subVpn, { subVpn = it; save() }, "${modeLabel("vpn")}, ${t.minShort}", Modifier.weight(1f))
            LabeledNumField(subLte, { subLte = it; save() }, "${modeLabel("lte")}, ${t.minShort}", Modifier.weight(1f))
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            LabeledNumField(subWifi, { subWifi = it; save() }, "${modeLabel("wifi")}, ${t.minShort}", Modifier.weight(1f))
            LabeledNumField(subEth, { subEth = it; save() }, "${modeLabel("ethernet")}, ${t.minShort}", Modifier.weight(1f))
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            LabeledNumField(subWp, { subWp = it; save() }, "${modeLabel("wp")}, ${t.minShort}", Modifier.weight(1f))
            Spacer(Modifier.weight(1f))
        }

        // 2) Base scan speed — period, batch-per-thread, threads. Each row is a
        // wrapping explanation on the left + a small number box on the right.
        Section(t.baseScanTitle) { help = t.baseScanTitle to t.baseScanHelp }
        LabeledNumField(checkInt, { checkInt = it; save() }, t.baseScanPeriod, Modifier.fillMaxWidth())
        LabeledNumField(batch, { batch = it; save() }, t.baseScanBatch, Modifier.fillMaxWidth())
        LabeledNumField(conc, { conc = it; save() }, t.baseScanThreads, Modifier.fillMaxWidth())
        // Anti-flood floor: never re-scan the same host more often than this.
        LabeledNumField(minRescan, { minRescan = it; save() }, t.minRescanLabel, Modifier.fillMaxWidth())

        // 3) Adaptive speed — threshold (compact field) + acceleration log slider.
        Section(t.adaptiveSpeed) { help = t.adaptiveSpeed to t.adaptiveHelp }
        Text(t.adaptiveDesc, color = AppColors.onSurfaceMuted, fontSize = 13.sp)
        AdaptiveRow(aliveThr, { aliveThr = it; save() }, t.fewWord,
            fastMul.toFloatOrNull() ?: 1f, slower = false) { fastMul = fmtMult(it); save() }
        AdaptiveRow(lazyThr, { lazyThr = it; save() }, t.manyWord,
            lazyMul.toFloatOrNull() ?: 1f, slower = true) { lazyMul = fmtMult(it); save() }

        // 4) Speed by mode — per-mode intensity slider, with the FINAL effective
        // numbers (base trio × this mode's speed × adaptive multiplier) below it.
        Section(t.speedByModeTitle) { help = t.speedByModeTitle to t.speedByModeHelp }
        val baseMin = checkInt.toIntOrNull() ?: s.checkIntervalMin
        val baseBatch = batch.toIntOrNull() ?: s.checkBatch
        val baseConc = conc.toIntOrNull() ?: s.checkConcurrency
        val fewThr = aliveThr.toIntOrNull() ?: s.adaptiveAliveThreshold
        val manyThr = lazyThr.toIntOrNull() ?: s.lazyAliveThreshold
        val fastM = fastMul.toFloatOrNull() ?: 1f
        val lazyM = lazyMul.toFloatOrNull() ?: 1f
        SpeedModeRow("VPN", spVpn.toFloatOrNull() ?: 1f, { spVpn = fmtMult(it); save() },
            fewThr, cb.scanParamsFor(baseMin, baseBatch, baseConc, (spVpn.toFloatOrNull() ?: 1f) * fastM),
            manyThr, cb.scanParamsFor(baseMin, baseBatch, baseConc, (spVpn.toFloatOrNull() ?: 1f) * lazyM))
        SpeedModeRow("LTE", spLte.toFloatOrNull() ?: 1f, { spLte = fmtMult(it); save() },
            fewThr, cb.scanParamsFor(baseMin, baseBatch, baseConc, (spLte.toFloatOrNull() ?: 1f) * fastM),
            manyThr, cb.scanParamsFor(baseMin, baseBatch, baseConc, (spLte.toFloatOrNull() ?: 1f) * lazyM))
        SpeedModeRow("Wi-Fi", spWifi.toFloatOrNull() ?: 1f, { spWifi = fmtMult(it); save() },
            fewThr, cb.scanParamsFor(baseMin, baseBatch, baseConc, (spWifi.toFloatOrNull() ?: 1f) * fastM),
            manyThr, cb.scanParamsFor(baseMin, baseBatch, baseConc, (spWifi.toFloatOrNull() ?: 1f) * lazyM))
        SpeedModeRow("Ethernet", spEth.toFloatOrNull() ?: 1f, { spEth = fmtMult(it); save() },
            fewThr, cb.scanParamsFor(baseMin, baseBatch, baseConc, (spEth.toFloatOrNull() ?: 1f) * fastM),
            manyThr, cb.scanParamsFor(baseMin, baseBatch, baseConc, (spEth.toFloatOrNull() ?: 1f) * lazyM))
        SpeedModeRow("White", spWp.toFloatOrNull() ?: 1f, { spWp = fmtMult(it); save() },
            fewThr, cb.scanParamsFor(baseMin, baseBatch, baseConc, (spWp.toFloatOrNull() ?: 1f) * fastM),
            manyThr, cb.scanParamsFor(baseMin, baseBatch, baseConc, (spWp.toFloatOrNull() ?: 1f) * lazyM))

        Section(t.netBattery) { help = t.netBattery to t.netBatteryHelp }
        SwitchRow(t.onlyWifi, wifiOnly) { wifiOnly = it; save() }
        SwitchRow(t.onlyCharging, charging) { charging = it; save() }
        SwitchRow(t.skipLowBattery, skipLow) { skipLow = it; save() }

        // --- Connection & block bypass — one merged section -------------
        // Connect engine + parallel-race width + proxying engine + anti-DPI
        // tricks, all under a single header (was four separate sections).
        Section(t.connectionSection) { help = t.connectionSection to t.connectionSectionHelp }

        SubTitle(t.expConnectTitle)
        ExpEnginePicker(cb.connectEngineOptions, connEngine, connExpanded, { connExpanded = it }) { connEngine = it; save() }
        cb.connectEngineOptions.firstOrNull { it.code == connEngine }?.description
            ?.takeIf { it.isNotBlank() }?.let {
                Text(
                    it + (if (connEngine != 0) "\n" + t.expEngineWarn else ""),
                    color = AppColors.onSurfaceMuted, fontSize = 13.sp,
                )
            }
        // Parallel-race width — only when the race connect engine (code 1) is on.
        // Slider over 1..30 upstreams dialed simultaneously.
        if (connEngine == 1) {
            SubTitle("${t.raceWidthTitle}: $raceWidth")
            Slider(
                value = raceWidth.toFloat(),
                onValueChange = { raceWidth = (it + 0.5f).toInt().coerceIn(1, 30) },
                onValueChangeFinished = { save() },
                valueRange = 1f..30f,
                steps = 28,
            )
        }

        // Host-selection breadth: proven (0) ↔ widest (100). Linear 0..100.
        SubTitle("${t.breadthTitle}: $breadth%")
        Slider(
            value = breadth.toFloat(),
            onValueChange = { breadth = it.toInt().coerceIn(0, 100) },
            onValueChangeFinished = { save() },
            valueRange = 0f..100f,
        )
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(t.breadthNarrow, color = AppColors.onSurfaceMuted, fontSize = 12.sp)
            Text(t.breadthWide, color = AppColors.onSurfaceMuted, fontSize = 12.sp)
        }
        Text(t.breadthHelp, color = AppColors.onSurfaceMuted, fontSize = 13.sp)

        // Per-host connect timeout, log-scaled 100 ms .. 15000 ms.
        SubTitle("${t.connTimeoutTitle}: " +
            (if (connTimeout >= 1000) "${connTimeout / 1000}.${(connTimeout % 1000) / 100} c" else "$connTimeout ${t.unitMs}"))
        Slider(
            value = (log10(connTimeout.coerceIn(100, 15000).toDouble() / 100.0) / log10(150.0)).toFloat(),
            onValueChange = { connTimeout = (100.0 * 150.0.pow(it.toDouble())).toInt().coerceIn(100, 15000) },
            onValueChangeFinished = { save() },
        )
        Text(t.connTimeoutHelp, color = AppColors.onSurfaceMuted, fontSize = 13.sp)

        SubTitle(t.expEngineTitle)
        ExpEnginePicker(cb.expEngineOptions, expEngine, expExpanded, { expExpanded = it }) { expEngine = it; save() }
        cb.expEngineOptions.firstOrNull { it.code == expEngine }?.description
            ?.takeIf { it.isNotBlank() }?.let {
                Text(
                    it + (if (expEngine != 0) "\n" + t.expEngineWarn else ""),
                    color = AppColors.onSurfaceMuted, fontSize = 13.sp,
                )
            }

        SubTitle(t.antiDpiTrick)
        HandshakePicker(cb.handshakeOptions, hs, hsExpanded, { hsExpanded = it }) { hs = it; save() }
        SwitchRow(t.onlyFakeTls, fakeTls) { fakeTls = it; save() }

        SubTitle(t.applyDpiTo)
        SwitchRow(t.toRelay, dpiRelay) { dpiRelay = it; save() }
        SwitchRow(t.toProbes, dpiProbes) { dpiProbes = it; save() }
        SwitchRow(t.toDirect, dpiDirect) { dpiDirect = it; save() }

        // --- Network exchange log — its own section (Section draws the rule) --
        Section(t.netLogSection)
        SwitchRow(t.netLog, netLog) { netLog = it; save() }
        Text(t.netLogSub, color = AppColors.onSurfaceMuted, fontSize = 13.sp)
        if (netLog && cb.netLogPath != null) {
            Text(
                cb.netLogPath,
                fontFamily = monospaceFontFamily(),
                fontSize = 12.sp,
                color = AppColors.onSurfaceMuted,
            )
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedButton(onClick = cb.onOpenNetLogFolder, modifier = Modifier.weight(1f)) {
                    Text(t.openLogFolder, fontSize = 14.sp)
                }
                OutlinedButton(onClick = { cb.onCopy(cb.netLogPath) }) { Text(t.copyPath, fontSize = 14.sp) }
            }
        }

        // --- Export / Import (universal JSON backup) — each opens its own page -
        Section(t.backupTitle) { help = t.backupTitle to t.backupHelp }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            OutlinedButton(
                onClick = { cb.onOpenDest(MoreDest.BACKUP_EXPORT) },
                modifier = Modifier.weight(1f),
            ) { Text(t.exportWord, fontSize = 15.sp) }
            OutlinedButton(
                onClick = { cb.onOpenDest(MoreDest.BACKUP_IMPORT) },
                modifier = Modifier.weight(1f),
            ) { Text(t.importWord, fontSize = 15.sp) }
        }
        // --- Reset / maintenance — ALL destructive buttons, one section -
        Section(t.maintenance) { help = t.maintenance to t.maintenanceHelp }
        var confirmCatalog by remember { mutableStateOf(false) }
        var confirmHosts by remember { mutableStateOf(false) }
        var confirmFactory by remember { mutableStateOf(false) }
        var resetDone by remember { mutableStateOf(false) }
        var confirmModeReset by remember { mutableStateOf<String?>(null) }
        var confirmModeForget by remember { mutableStateOf<String?>(null) }
        // Where settings + the proxy DB actually live (the location can fall back
        // off %APPDATA% if that's not writable, so always show the real path).
        Text("Data folder / Папка данных:", color = AppColors.onSurfaceMuted, fontSize = 13.sp)
        Text(cb.dataDirPath, fontFamily = monospaceFontFamily(), fontSize = 12.sp, color = AppColors.onSurfaceMuted)
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedButton(onClick = cb.onOpenDataFolder, modifier = Modifier.weight(1f)) { Text("Open folder", fontSize = 14.sp) }
            OutlinedButton(onClick = { cb.onCopy(cb.dataDirPath) }) { Text(t.copyPath, fontSize = 14.sp) }
        }
        // Catalog + global stats.
        OutlinedButton(onClick = { confirmCatalog = true }, modifier = Modifier.fillMaxWidth()) {
            Text(t.resetCatalog, fontSize = 15.sp)
        }
        // Per-mode: zero a mode's ratings / forget its host rows (ratings are
        // split per network mode in PMS).
        listOf("vpn", "wifi", "lte", "ethernet", "wp").forEach { code ->
            OutlinedButton(onClick = { confirmModeReset = code }, modifier = Modifier.fillMaxWidth()) {
                Text("${t.resetModeRatings}: ${modeLabel(code)}", fontSize = 15.sp)
            }
        }
        listOf("vpn", "wifi", "lte", "ethernet").forEach { code ->
            OutlinedButton(onClick = { confirmModeForget = code }, modifier = Modifier.fillMaxWidth()) {
                Text("${t.forgetModeHosts}: ${modeLabel(code)}", fontSize = 15.sp, color = AppColors.red)
            }
        }
        DarkRule()
        // Wipe every host / full factory reset.
        OutlinedButton(onClick = { confirmHosts = true }, modifier = Modifier.fillMaxWidth()) {
            Text(t.eraseAllHosts, fontSize = 15.sp, color = AppColors.red)
        }
        OutlinedButton(onClick = { confirmFactory = true }, modifier = Modifier.fillMaxWidth()) {
            Text(t.factoryReset, fontSize = 15.sp, color = AppColors.red)
        }
        // Confirm dialogs.
        if (confirmCatalog) {
            AlertDialog(
                onDismissRequest = { confirmCatalog = false },
                confirmButton = { TextButton({ cb.onResetCatalogStats(); confirmCatalog = false }) { Text(t.doReset) } },
                dismissButton = { TextButton({ confirmCatalog = false }) { Text(t.doCancel) } },
                title = { Text(t.resetCatalog, fontWeight = FontWeight.Bold) },
                text = { Text(t.resetCatalogConfirm, fontSize = 15.sp) },
            )
        }
        if (confirmHosts) {
            AlertDialog(
                onDismissRequest = { confirmHosts = false },
                confirmButton = { TextButton({ cb.onClearHosts(); confirmHosts = false }) { Text(t.doReset) } },
                dismissButton = { TextButton({ confirmHosts = false }) { Text(t.doCancel) } },
                title = { Text(t.eraseAllHosts, fontWeight = FontWeight.Bold) },
                text = { Text(t.clearHostsConfirm, fontSize = 15.sp) },
            )
        }
        if (confirmFactory) {
            AlertDialog(
                onDismissRequest = { confirmFactory = false },
                confirmButton = { TextButton({ cb.onFactoryReset(); confirmFactory = false; resetDone = true }) { Text(t.doReset) } },
                dismissButton = { TextButton({ confirmFactory = false }) { Text(t.doCancel) } },
                title = { Text(t.factoryReset, fontWeight = FontWeight.Bold) },
                text = { Text(t.factoryResetConfirm, fontSize = 15.sp) },
            )
        }
        if (resetDone) {
            AlertDialog(
                onDismissRequest = { resetDone = false },
                confirmButton = { TextButton({ resetDone = false }) { Text("OK") } },
                title = { Text(t.factoryReset, fontWeight = FontWeight.Bold) },
                text = { Text(t.factoryResetDone, fontSize = 15.sp) },
            )
        }
        confirmModeReset?.let { code ->
            AlertDialog(
                onDismissRequest = { confirmModeReset = null },
                confirmButton = { TextButton({ cb.onResetModeStats(code); confirmModeReset = null }) { Text(t.doReset) } },
                dismissButton = { TextButton({ confirmModeReset = null }) { Text(t.doCancel) } },
                title = { Text("${t.resetModeRatings}: ${modeLabel(code)}", fontWeight = FontWeight.Bold) },
                text = { Text(t.resetCatalogConfirm, fontSize = 15.sp) },
            )
        }
        confirmModeForget?.let { code ->
            AlertDialog(
                onDismissRequest = { confirmModeForget = null },
                confirmButton = { TextButton({ cb.onForgetModeHosts(code); confirmModeForget = null }) { Text(t.doReset) } },
                dismissButton = { TextButton({ confirmModeForget = null }) { Text(t.doCancel) } },
                title = { Text("${t.forgetModeHosts}: ${modeLabel(code)}", fontWeight = FontWeight.Bold) },
                text = { Text(t.clearHostsConfirm, fontSize = 15.sp) },
            )
        }

        Text(t.autosaved, color = AppColors.onSurfaceMuted, fontSize = 14.sp, modifier = Modifier.padding(top = 4.dp))
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
private fun HandshakePicker(
    options: List<HandshakeOption>,
    selectedOrdinal: Int,
    expanded: Boolean,
    setExpanded: (Boolean) -> Unit,
    onPick: (Int) -> Unit,
) {
    val t = LocalStrings.current
    // The two "special" entries are AUTO (first) and NONE (second); localise them.
    fun label(opt: HandshakeOption, specialIndex: Int): String = when {
        opt.special && specialIndex == 0 -> t.dpiAutoLabel
        opt.special -> t.dpiNoneLabel
        else -> opt.label
    }
    var seen = 0
    val current = options.firstOrNull { it.ordinal == selectedOrdinal } ?: options.firstOrNull()
    val curLabel = current?.let {
        if (it.special) (if (options.indexOf(it) == 0) t.dpiAutoLabel else t.dpiNoneLabel) else it.label
    } ?: t.dash
    OutlinedButton({ setExpanded(true) }, Modifier.fillMaxWidth()) {
        Text(curLabel, fontSize = 15.sp, color = if (current?.special == true) AppColors.accent else AppColors.onSurface)
    }
    DropdownMenu(expanded, { setExpanded(false) }) {
        options.forEachIndexed { i, opt ->
            val si = if (opt.special) seen++ else -1
            DropdownMenuItem(
                text = {
                    Text(
                        label(opt, si),
                        fontSize = 15.sp,
                        fontWeight = if (opt.special) FontWeight.Bold else FontWeight.Normal,
                        color = if (opt.special) AppColors.accent else AppColors.onSurface,
                    )
                },
                onClick = { onPick(opt.ordinal); setExpanded(false) },
            )
            if (opt.special && (i + 1 < options.size) && !options[i + 1].special) {
                Box(Modifier.fillMaxWidth().height(1.dp).background(AppColors.cardBorder))
            }
        }
    }
}

@Composable
private fun ExpEnginePicker(
    options: List<ExpEngineOption>,
    selectedCode: Int,
    expanded: Boolean,
    setExpanded: (Boolean) -> Unit,
    onPick: (Int) -> Unit,
) {
    val current = options.firstOrNull { it.code == selectedCode } ?: options.firstOrNull()
    val isOff = selectedCode == 0
    OutlinedButton({ setExpanded(true) }, Modifier.fillMaxWidth()) {
        Text(
            current?.label ?: "—",
            fontSize = 15.sp,
            color = if (isOff) AppColors.onSurface else AppColors.accent,
            fontWeight = if (isOff) FontWeight.Normal else FontWeight.Bold,
        )
    }
    DropdownMenu(expanded, { setExpanded(false) }) {
        options.forEachIndexed { i, opt ->
            DropdownMenuItem(
                text = {
                    Text(
                        opt.label,
                        fontSize = 15.sp,
                        fontWeight = if (opt.code == 0) FontWeight.Bold else FontWeight.Normal,
                        color = if (opt.code == 0) AppColors.accent else AppColors.onSurface,
                    )
                },
                onClick = { onPick(opt.code); setExpanded(false) },
            )
            if (opt.code == 0 && i + 1 < options.size) {
                Box(Modifier.fillMaxWidth().height(1.dp).background(AppColors.cardBorder))
            }
        }
    }
}

/** Full-window-width dark rule (escapes the 12.dp list padding like Section). */
@Composable
private fun DarkRule() {
    Box(
        Modifier
            .padding(vertical = 6.dp)
            .layout { measurable, constraints ->
                val extra = 12.dp.roundToPx() * 2
                val w = constraints.maxWidth + extra
                val p = measurable.measure(constraints.copy(minWidth = w, maxWidth = w))
                layout(p.width, p.height) { p.place(-12.dp.roundToPx(), 0) }
            }
            .height(1.dp)
            .background(Color(0xFF222222)),
    )
}

@Composable
private fun Section(title: String, onHelp: (() -> Unit)? = null) {
    Column(Modifier.fillMaxWidth()) {
        // A #777777 rule spanning the FULL window width before every section
        // header (visual breathing room). The settings list is inset by 12.dp,
        // so the line is stretched 12.dp past each edge to reach the window
        // borders regardless of that padding.
        Box(
            Modifier
                .padding(top = 8.dp)
                .layout { measurable, constraints ->
                    val extra = 12.dp.roundToPx() * 2
                    val w = constraints.maxWidth + extra
                    val placeable = measurable.measure(constraints.copy(minWidth = w, maxWidth = w))
                    layout(placeable.width, placeable.height) {
                        placeable.place(-12.dp.roundToPx(), 0)
                    }
                }
                .height(1.dp)
                .background(Color(0xFF777777)),
        )
        Row(Modifier.fillMaxWidth().padding(top = 6.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(title, color = AppColors.accent, fontWeight = FontWeight.Bold, fontSize = 15.sp)
            if (onHelp != null) {
                Spacer(Modifier.width(6.dp))
                IconButton(onClick = onHelp, modifier = Modifier.size(26.dp)) {
                    Icon(Icons.AutoMirrored.Filled.HelpOutline, LocalStrings.current.whatIsThis, tint = AppColors.accent, modifier = Modifier.size(20.dp))
                }
            }
        }
    }
}

/** Formats a scan-speed multiplier compactly: integers without a trailing ".0". */
private fun fmtMult(m: Float): String {
    val r = (m * 100f).roundToInt() / 100f
    return if (r == r.toInt().toFloat()) r.toInt().toString() else r.toString()
}

/** Like [fmtMult] but rounded to a single decimal — for the "Nx faster/slower" hint. */
private fun fmt1(v: Float): String {
    val r = (v * 10f).roundToInt() / 10f
    return if (r == r.toInt().toFloat()) r.toInt().toString() else r.toString()
}

// Shared log mapping for the intensity / adaptive sliders. The underlying value
// is the check-interval multiplier used by dynamicCheckInterval(): 1.0 =
// standard, >1 scans rarer (slower), <1 scans more often (faster). Log-scaled
// over [0.01 .. 100] so "standard" sits dead centre and each end is ×100.
private const val SLIDER_MIN_LOG = -2.0
private const val SLIDER_MAX_LOG = 2.0

private fun multToPos(mult: Float): Float =
    ((log10(mult.coerceIn(0.01f, 100f).toDouble()) - SLIDER_MIN_LOG) /
        (SLIDER_MAX_LOG - SLIDER_MIN_LOG)).coerceIn(0.0, 1.0).toFloat()

private fun posToMult(p: Float): Float =
    10.0.pow(SLIDER_MIN_LOG + p * (SLIDER_MAX_LOG - SLIDER_MIN_LOG)).toFloat()

private fun multCaption(mult: Float, t: Strings): String {
    val c = mult.coerceIn(0.01f, 100f)
    return when {
        c in 0.9f..1.1f -> t.intensStandard
        c > 1.1f -> t.intensSlower + " ×" + c.roundToInt()
        else -> t.intensFaster + " ×" + (1f / c).roundToInt()
    }
}

/** The log slider + its live caption, sized to fill the rest of a Row. */
@Composable
private fun RowScope.MultSlider(mult: Float, onChange: (Float) -> Unit) {
    val t = LocalStrings.current
    Slider(
        value = multToPos(mult),
        onValueChange = { onChange(posToMult(it)) },
        modifier = Modifier.weight(1f),
    )
    Spacer(Modifier.width(8.dp))
    Text(
        multCaption(mult, t),
        color = AppColors.accent, fontSize = 13.sp, fontWeight = FontWeight.Bold,
        textAlign = TextAlign.End, maxLines = 1,
        modifier = Modifier.widthIn(min = 88.dp),
    )
}

/** Scan-intensity slider — name, slider and value all on one line. */
@Composable
private fun IntensitySlider(label: String, mult: Float, onChange: (Float) -> Unit) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(label, fontWeight = FontWeight.Bold, fontSize = 12.sp, maxLines = 1,
            modifier = Modifier.width(52.dp))
        MultSlider(mult.coerceIn(0.01f, 100f), onChange)
    }
}

/** One adaptive-speed line: a compact threshold field + an acceleration slider,
 *  with an estimate of the effect below ("Nx faster"/"Nx slower", or "off" when
 *  the multiplier is dialled to the slow extreme). */
@Composable
private fun AdaptiveRow(
    thr: String, onThr: (String) -> Unit, thrLabel: String,
    mult: Float, slower: Boolean, onMult: (Float) -> Unit,
) {
    val t = LocalStrings.current
    val m = mult.coerceIn(0.01f, 100f)
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            NumField(thr, onThr, thrLabel, Modifier.width(104.dp))
            MultSlider(m, onMult)
        }
        // The "faster ×N / slower ×N" estimate is dropped here — the slider's own
        // caption to the right already shows it. Only the meaningful "off" state
        // (no analog on the right) is kept.
        if (m >= 48f) {
            Text(
                t.disabledWord,
                color = AppColors.accent, fontSize = 12.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 4.dp),
            )
        }
    }
}

/** Compact text of effective scan params for one adaptive end (or "off"). */
private fun fmtParams(p: ScanParams, t: Strings): String =
    if (p.disabled) t.disabledWord
    else "${t.periodWord} ${if (p.continuous) t.nonstopWord else "${p.intervalSec}${t.secShort}"}, " +
        "${t.batchWord} ${p.batch}, ${t.threadsWord} ${p.concurrency}"

/** One per-mode block: an intensity slider plus the two effective readouts, each
 *  split into a "when alive ≷ N" header line and the resulting params below it. */
@Composable
private fun SpeedModeRow(
    label: String,
    mult: Float,
    onChange: (Float) -> Unit,
    fewThreshold: Int,
    paramsFew: ScanParams,
    manyThreshold: Int,
    paramsMany: ScanParams,
) {
    val t = LocalStrings.current
    Column(verticalArrangement = Arrangement.spacedBy(1.dp)) {
        IntensitySlider(label, mult, onChange)
        Text(
            t.ifAliveLt(fewThreshold),
            color = AppColors.onSurfaceMuted, fontSize = 12.sp,
            modifier = Modifier.padding(start = 4.dp),
        )
        Text(
            fmtParams(paramsFew, t),
            color = AppColors.onSurfaceMuted, fontSize = 12.sp,
            modifier = Modifier.padding(start = 14.dp),
        )
        Text(
            t.ifAliveGt(manyThreshold),
            color = AppColors.onSurfaceMuted, fontSize = 12.sp,
            modifier = Modifier.padding(start = 4.dp),
        )
        Text(
            fmtParams(paramsMany, t),
            color = AppColors.onSurfaceMuted, fontSize = 12.sp,
            modifier = Modifier.padding(start = 14.dp),
        )
    }
}

@Composable
private fun NumField(value: String, onChange: (String) -> Unit, label: String, modifier: Modifier, decimal: Boolean = false) {
    OutlinedTextField(
        value,
        { v -> onChange(v.filter { it.isDigit() || (decimal && (it == '.' || it == ',')) }.replace(',', '.')) },
        modifier,
        label = { Text(label, fontSize = 14.sp) },
        // Explicit family: a bare TextStyle defaults to FontFamily.Default, which
        // the text field's heightInLines resolves eagerly — and that generic
        // family can't be loaded under Wine (Skia can't read system fonts there),
        // crashing the Settings page. Pin it to the bundled sans like everywhere else.
        textStyle = androidx.compose.ui.text.TextStyle(fontSize = 16.sp, fontFamily = sansFontFamily()),
        singleLine = true,
    )
}

/** A wrapping explanation on the left (takes the remaining width, multi-line) plus
 *  a small right-aligned numeric box — used by the scan-speed / subscription fields. */
@Composable
private fun LabeledNumField(value: String, onChange: (String) -> Unit, label: String, modifier: Modifier = Modifier) {
    Row(modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(label, Modifier.weight(1f), fontSize = 14.sp, color = AppColors.onSurface)
        Spacer(Modifier.width(8.dp))
        NumField(value, onChange, "", Modifier.width(72.dp))
    }
}

@Composable
private fun SwitchRow(label: String, value: Boolean, onChange: (Boolean) -> Unit) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(label, Modifier.weight(1f), fontSize = 16.sp)
        Switch(value, onChange)
    }
}

@Composable
private fun ChoiceRow(title: String, desc: String, selected: Boolean, onSelect: () -> Unit) {
    Row(
        Modifier.fillMaxWidth().clickable(onClick = onSelect),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        RadioButton(selected = selected, onClick = onSelect)
        Spacer(Modifier.width(4.dp))
        Column(Modifier.weight(1f)) {
            Text(title, fontSize = 16.sp, fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal)
            if (desc.isNotEmpty()) Text(desc, color = AppColors.onSurfaceMuted, fontSize = 14.sp)
        }
    }
}

// === Sources ============================================================

@Composable
private fun SourcesPage(cb: MoreCallbacks) {
    val t = LocalStrings.current
    Column(Modifier.fillMaxSize()) {
        // Header: a [+] opens the dedicated bulk-add page.
        Row(
            Modifier.fillMaxWidth().padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(t.subscriptionsAddHint, Modifier.weight(1f), color = AppColors.onSurfaceMuted, fontSize = 13.sp)
            Spacer(Modifier.width(8.dp))
            Button({ cb.onOpenDest(MoreDest.ADD_SOURCES) }) { Text("+", fontSize = 18.sp) }
        }
        // Only real http(s) subscriptions appear here. Manually-pasted proxies
        // (the "manual:fixed" sentinel source) are NOT subscriptions — they live
        // in the catalog only. Tiles are full-bleed with an edge-to-edge divider.
        val subs = cb.sources.filter { it.url.startsWith("http") }
        Column(Modifier.fillMaxWidth().weight(1f).verticalScroll(rememberScrollState())) {
            subs.forEachIndexed { i, src ->
                if (i > 0) HorizontalDivider(thickness = 2.dp, color = AppColors.gray)
                SourceTile(src, cb, t)
            }
        }
    }
}

/** One subscription tile — all-white background, edge-to-edge gray divider between tiles. */
@Composable
private fun SourceTile(src: SourceItem, cb: MoreCallbacks, t: Strings) {
    var confirmDelete by remember { mutableStateOf(false) }
    Column(
        Modifier.fillMaxWidth().background(AppColors.background).padding(horizontal = 8.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        // 1) Full URL in a read-only field: #DDDDDD background, bold mono text.
        OutlinedTextField(
            value = src.url,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),
            textStyle = androidx.compose.ui.text.TextStyle(
                fontFamily = monospaceFontFamily(), fontSize = 13.sp, fontWeight = FontWeight.Bold,
            ),
            colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFDDDDDD),
                focusedContainerColor = Color(0xFFDDDDDD),
            ),
        )
        // 2) Action buttons directly under the URL field + black On/Off + toggle.
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            IconButton({ cb.onRefreshSource(src.id) }) { Icon(Icons.Filled.Download, t.dlNow, tint = AppColors.accent) }
            IconButton({ cb.onOpenUrl(src.url) }) { Icon(Icons.Filled.OpenInNew, t.open, tint = AppColors.gray) }
            IconButton({ cb.onCopy(src.url) }) { Icon(Icons.Filled.ContentCopy, t.copy, tint = AppColors.gray) }
            IconButton({ confirmDelete = true }) { Icon(Icons.Filled.Delete, t.delete, tint = AppColors.gray) }
            Spacer(Modifier.weight(1f))
            Text(
                if (src.enabled) "On" else "Off",
                color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 12.sp,
            )
            Spacer(Modifier.width(2.dp))
            Switch(
                src.enabled, { cb.onToggleSource(src.id, it) },
                modifier = Modifier.scale(0.72f),
                colors = androidx.compose.material3.SwitchDefaults.colors(
                    checkedThumbColor = Color.White, checkedTrackColor = AppColors.gray,
                ),
            )
        }
        // 3) Big green alive count + "N мёртвых, N всего"; №seq on the right.
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text("${src.alive}", color = AppColors.green, fontWeight = FontWeight.Bold, fontSize = 22.sp)
            Text(t.sourceCounts(src.dead, src.total), color = AppColors.onSurfaceMuted, fontSize = 14.sp)
            Spacer(Modifier.weight(1f))
            Text("№${src.seq}", color = AppColors.onSurfaceMuted, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
        // 4) While a manual download runs: blue "Загружаю… Ns"; else when/size/error.
        if (src.downloading) {
            Text(t.downloadingFmt(src.downloadingSec), color = AppColors.blue, fontWeight = FontWeight.Bold, fontSize = 13.sp)
        } else {
            val whenTxt = if (src.lastRefreshMinsAgo >= 0) t.agoFmt(fmtAgo(src.lastRefreshMinsAgo, t)) else t.notDownloaded
            Row(Modifier.fillMaxWidth()) {
                Text("$whenTxt · ", color = AppColors.onSurfaceMuted, fontSize = 13.sp)
                if (src.lastError != null) {
                    Text(src.lastError, color = AppColors.red, fontSize = 13.sp)
                } else {
                    Text(src.bytesHuman, color = AppColors.onSurfaceMuted, fontSize = 13.sp)
                }
            }
        }
    }
    if (confirmDelete) {
        androidx.compose.material3.AlertDialog(
            onDismissRequest = { confirmDelete = false },
            title = { Text(t.deleteConfirmTitle) },
            text = { Text(src.url, fontSize = 13.sp, fontFamily = monospaceFontFamily()) },
            confirmButton = {
                TextButton({ confirmDelete = false; cb.onRemoveSource(src.id) }) { Text(t.delete, color = AppColors.red) }
            },
            dismissButton = { TextButton({ confirmDelete = false }) { Text(t.cancel) } },
        )
    }
}

/** Bulk-add page: paste many subscription URLs (one per line) and/or a batch of
 *  ready proxy links (a fixed list that is never downloaded). */
@Composable
private fun AddSourcesPage(cb: MoreCallbacks) {
    val t = LocalStrings.current
    var subsText by remember { mutableStateOf("") }
    var proxyText by remember { mutableStateOf("") }
    var result by remember { mutableStateOf<String?>(null) }
    Column(
        Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Text(t.addSubsLabel, fontWeight = FontWeight.Bold, fontSize = 15.sp)
        Text(t.addSubsHelp, color = AppColors.onSurfaceMuted, fontSize = 13.sp)
        OutlinedTextField(
            subsText, { subsText = it },
            Modifier.fillMaxWidth().height(150.dp),
            placeholder = { Text("https://…\nhttps://…", fontSize = 13.sp) },
            textStyle = androidx.compose.ui.text.TextStyle(fontFamily = monospaceFontFamily(), fontSize = 13.sp),
        )
        HorizontalDivider(thickness = 1.dp, color = AppColors.gray)
        Text(t.addProxiesLabel, fontWeight = FontWeight.Bold, fontSize = 15.sp)
        Text(t.addProxiesHelp, color = AppColors.onSurfaceMuted, fontSize = 13.sp)
        OutlinedTextField(
            proxyText, { proxyText = it },
            Modifier.fillMaxWidth().height(150.dp),
            placeholder = { Text("tg://proxy?server=…\nhttps://t.me/proxy?…", fontSize = 13.sp) },
            textStyle = androidx.compose.ui.text.TextStyle(fontFamily = monospaceFontFamily(), fontSize = 13.sp),
        )
        Button(
            {
                val a = if (subsText.isNotBlank()) cb.onAddSourcesBulk(subsText) else 0
                val b = if (proxyText.isNotBlank()) cb.onAddManualProxies(proxyText) else 0
                result = t.addedFmt(a, b)
                subsText = ""; proxyText = ""
            },
            Modifier.fillMaxWidth(),
        ) { Text(t.addButton, fontSize = 16.sp) }
        result?.let { Text(it, color = AppColors.green, fontWeight = FontWeight.Bold, fontSize = 14.sp) }
    }
}

/** minutes-ago → short "Nм/Nч/Nд" (paired with [Strings.agoFmt]). */
private fun fmtAgo(m: Long, t: Strings): String = when {
    m < 60 -> "$m${t.agoMin}"
    m < 1440 -> "${m / 60}${t.agoHour}"
    else -> "${m / 1440}${t.agoDay}"
}

// === Stats ==============================================================

@Composable
private fun StatsPage(cb: MoreCallbacks) {
    val t = LocalStrings.current
    val s = cb.state
    val hs = cb.handshakeStats()
    Column(
        Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        SubTitle(t.proxyBase)
        StatTable(
            rows = listOf(
                listOf(cell(t.totalInBase), cell("${s.totalCount}", bold = true)),
                listOf(cell(t.aliveNow), cell("${s.aliveCount}", AppColors.green, bold = true)),
                listOf(cell(t.deadStat), cell("${s.deadCount}", AppColors.onSurface)),
                listOf(cell(t.aliveIn15), cell("${s.aliveWithin15}")),
                listOf(cell(t.checksAllTime), cell("${s.checkedAllTime}")),
            ),
            weights = listOf(1.4f, 1f),
            fontSize = 14,
        )

        SubTitle(t.antiDpiTricks)
        if (hs.isEmpty()) {
            Caption(t.noStatsYet)
        } else {
            for (r in hs) {
                CardBox(Modifier.fillMaxWidth()) {
                    Column {
                        Text(r.label, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = AppColors.accent)
                        Spacer(Modifier.height(6.dp))
                        StatTable(
                            rows = listOf(
                                listOf(cell(t.attempts), cell("${r.attempts}", bold = true), cell(t.handshake), cell("${r.handshakes} (${r.hsRatePct}%)", AppColors.blue, bold = true)),
                                listOf(cell(t.tgConnect), cell("${r.tgConnected}", AppColors.green, bold = true), cell(t.score), cell(if (r.score >= 0) fmt2(r.score) else "—", bold = true)),
                                listOf(cell(t.over10kb), cell("${r.over10k}"), cell(t.over100kb), cell("${r.over100k}")),
                                listOf(cell(t.socketsOver1m), cell("${r.over1m}"), cell(t.over5m), cell("${r.over5m}")),
                                listOf(cell(t.workTime), cell(r.activeHuman, bold = true), cell(t.traffic), cell(r.trafficHuman)),
                            ),
                            weights = listOf(1.3f, 1f, 1f, 1f),
                            fontSize = 14,
                        )
                    }
                }
            }
            Text(t.statsLegend, color = AppColors.onSurfaceMuted, fontSize = 14.sp)
            OutlinedButton(onClick = cb.onResetStats, modifier = Modifier.fillMaxWidth()) {
                Text(t.resetStats, fontSize = 15.sp)
            }
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
private fun SubTitle(title: String) {
    Text(title, color = AppColors.accent, fontWeight = FontWeight.Bold, fontSize = 15.sp, modifier = Modifier.padding(top = 4.dp))
}

private fun fmt2(v: Double): String {
    val x = (v * 100).toInt() / 100.0
    return x.toString()
}

// === About ==============================================================

@Composable
private fun AboutPage(cb: MoreCallbacks) {
    val t = LocalStrings.current
    val github = "https://github.com/cheburnetik/AutoConnector_for_Telegram"
    val tg = "https://t.me/AutoConnector_for_Telegram"
    Column(
        Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        // App logo, shown square (1:1) and centred at the top of the page.
        Image(
            painter = appLogo(),
            contentDescription = "AutoConnector for Telegram",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(128.dp)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(24.dp)),
        )
        Text(
            "AutoConnector for Telegram",
            fontWeight = FontWeight.Bold,
            fontSize = 19.sp,
            color = AppColors.accent,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
        Text(t.appTagline, fontSize = 15.sp)

        StatTable(
            rows = buildList {
                add(listOf(cell(t.version), cell(cb.appInfo.version, bold = true)))
                add(listOf(cell(t.buildDate), cell(cb.appInfo.buildDate, bold = true)))
                if (cb.appInfo.platform.isNotBlank())
                    add(listOf(cell(t.platform), cell(cb.appInfo.platform, bold = true)))
            },
            weights = listOf(1f, 1.6f),
            fontSize = 15,
        )

        SubTitle(t.downloadSources)
        Text(github, color = AppColors.accent, fontSize = 14.sp, fontFamily = monospaceFontFamily())
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Button(onClick = { cb.onOpenUrl(github) }, modifier = Modifier.weight(1f)) {
                Text(t.openOnGithub, fontSize = 15.sp)
            }
            OutlinedButton(onClick = { cb.onCopy(github) }) { Text(t.copy) }
        }

        SubTitle(t.feedbackBugs)
        Text(tg, color = AppColors.accent, fontSize = 14.sp, fontFamily = monospaceFontFamily())
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Button(onClick = { cb.onOpenUrl(tg) }, modifier = Modifier.weight(1f)) {
                Text(t.writeTelegram, fontSize = 15.sp)
            }
            OutlinedButton(onClick = { cb.onCopy(tg) }) { Text(t.copy) }
        }
        Spacer(Modifier.height(16.dp))
    }
}

// === Hotkeys (desktop only) =============================================

@Composable
private fun HotkeysPage(cb: MoreCallbacks) {
    val t = LocalStrings.current
    var enabled by remember { mutableStateOf(cb.hotkeysEnabled) }
    var letter by remember { mutableStateOf(cb.hotkeyLetter) }
    // Live chord text: take the saved label and swap its trailing letter.
    fun withLetter(base: String) = if (letter.isEmpty()) base else base.trimEnd().dropLast(1) + letter

    Column(
        Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(t.hotkeysIntro, fontSize = 14.sp, color = AppColors.onSurface)

        // Master on/off.
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text(t.hotkeyEnable, Modifier.weight(1f), fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(if (enabled) "ON" else "OFF", color = if (enabled) AppColors.green else AppColors.gray, fontWeight = FontWeight.Bold, fontSize = 12.sp)
            Spacer(Modifier.width(4.dp))
            Switch(enabled, { enabled = it; cb.onSetHotkeysEnabled(it) })
        }

        // Currently-set chords (live with the letter field).
        Text(t.hotkeyCopyTitle, fontWeight = FontWeight.Bold, fontSize = 15.sp)
        Text(withLetter(cb.hotkeyCopyLabel), fontFamily = monospaceFontFamily(), color = AppColors.accent, fontWeight = FontWeight.Bold, fontSize = 15.sp)
        Text(t.hotkeyCopyDesc, color = AppColors.onSurfaceMuted, fontSize = 13.sp)
        Text(t.hotkeyOpenTitle, fontWeight = FontWeight.Bold, fontSize = 15.sp, modifier = Modifier.padding(top = 4.dp))
        Text(withLetter(cb.hotkeyOpenLabel), fontFamily = monospaceFontFamily(), color = AppColors.accent, fontWeight = FontWeight.Bold, fontSize = 15.sp)
        Text(t.hotkeyOpenDesc, color = AppColors.onSurfaceMuted, fontSize = 13.sp)

        // Letter field + set / reset.
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedTextField(
                letter,
                { v -> letter = v.filter { it.isLetter() }.take(1).uppercase() },
                Modifier.width(78.dp),
                label = { Text(t.hotkeyLetterLabel, fontSize = 12.sp) },
                singleLine = true,
                textStyle = androidx.compose.ui.text.TextStyle(fontSize = 18.sp, fontFamily = sansFontFamily()),
            )
            Button(onClick = { if (letter.isNotEmpty()) cb.onSetHotkeyLetter(letter) }) { Text(t.hotkeySet, fontSize = 14.sp) }
            OutlinedButton(onClick = { letter = "P"; cb.onSetHotkeyLetter("P") }) { Text(t.hotkeyReset, fontSize = 14.sp) }
        }

        Text(t.hotkeysNote, fontSize = 13.sp, color = AppColors.onSurfaceMuted)
        Spacer(Modifier.height(16.dp))
    }
}

// === Export =============================================================

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ExportPage(cb: MoreCallbacks) {
    val t = LocalStrings.current
    val links = remember { cb.exportLinks() }
    val allText = remember(links) { links.joinToString("\n") }
    var savedPath by remember { mutableStateOf<String?>(null) }
    // Per-mode alive counts: pulled once (each call hits the DB).
    val modeCounts = remember { listOf("vpn", "wifi", "lte", "ethernet", "wp").associateWith { cb.onExportLinksForMode(it).size } }
    var modeSavedPath by remember { mutableStateOf<String?>(null) }
    fun copyN(n: Int) { if (links.isNotEmpty()) cb.onCopy(links.take(n).joinToString("\n")) }
    Column(Modifier.fillMaxSize().padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(t.aliveLinks(links.size), fontWeight = FontWeight.Bold, fontSize = 16.sp)

        // Copy ТОП — narrow 1 / 10 / 100 / ВСЕ buttons in one row (not stretched).
        Text(t.copyTop, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            CountCopyButton("1", links.isNotEmpty()) { copyN(1) }
            CountCopyButton("10", links.isNotEmpty()) { copyN(10) }
            CountCopyButton("100", links.isNotEmpty()) { copyN(100) }
            CountCopyButton(t.allShort, links.isNotEmpty()) { copyN(links.size) }
        }

        // Random host + its 2 actions on one line.
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(4.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(t.randomHost, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            IconButton(onClick = { if (links.isNotEmpty()) cb.onCopy(links.random()) }, enabled = links.isNotEmpty()) {
                Icon(Icons.Filled.ContentCopy, t.copyRandom, tint = AppColors.accent)
            }
            IconButton(onClick = { if (links.isNotEmpty()) cb.onOpenUrl(links.random()) }, enabled = links.isNotEmpty()) {
                Icon(Icons.Filled.OpenInNew, t.openRandom, tint = AppColors.accent)
            }
        }

        // Export to file: "Экспорт в файл:" + a mode dropdown (ВСЕ / per-mode,
        // with counts) + an OK button, all on one line. "ВСЕ" = the global alive
        // count shown in the header above; the per-mode counts are tracked
        // separately PER TRANSPORT (so e.g. Wi-Fi can differ from the header).
        val exportOptions = remember(modeCounts) {
            listOf("all" to links.size) + listOf("vpn", "wifi", "lte", "ethernet", "wp").map { it to (modeCounts[it] ?: 0) }
        }
        var selMode by remember { mutableStateOf("all") }
        var modeExpanded by remember { mutableStateOf(false) }
        fun optLabel(code: String, cnt: Int) =
            (if (code == "all") t.allShort else modeLabel(code)) + " " + t.pcs(cnt)
        val selCount = if (selMode == "all") links.size else (modeCounts[selMode] ?: 0)
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(t.exportToFile, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Box(Modifier.weight(1f)) {
                OutlinedButton(onClick = { modeExpanded = true }, modifier = Modifier.fillMaxWidth()) {
                    Text(optLabel(selMode, selCount), fontSize = 14.sp, maxLines = 1)
                }
                DropdownMenu(modeExpanded, { modeExpanded = false }) {
                    exportOptions.forEach { (code, cnt) ->
                        DropdownMenuItem(text = { Text(optLabel(code, cnt)) }, onClick = { selMode = code; modeExpanded = false })
                    }
                }
            }
            Button(
                onClick = { modeSavedPath = if (selMode == "all") cb.onExportToFile() else cb.onExportFileForMode(selMode) },
                enabled = selCount > 0,
            ) { Text("OK", fontSize = 14.sp) }
        }
        modeSavedPath?.let {
            Text(
                "${t.exportSaved} $it",
                color = AppColors.onSurfaceMuted, fontSize = 12.sp,
                fontFamily = monospaceFontFamily(),
            )
        }

        // All links in one big selectable/read-only text field.
        OutlinedTextField(
            value = allText,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.fillMaxWidth().weight(1f),
            textStyle = androidx.compose.ui.text.TextStyle(fontSize = 13.sp, fontFamily = monospaceFontFamily()),
            label = { Text(t.aliveLinks(links.size), fontSize = 13.sp) },
        )
    }
}

// === Backup export / import (universal JSON: settings / subs / hosts) =====

/** One backup-section checkbox row (Settings / Subscriptions / Live-hosts). */
@Composable
private fun BackupCheck(label: String, checked: Boolean, onChange: (Boolean) -> Unit) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checked, onCheckedChange = onChange)
        Text(label, fontSize = 14.sp)
    }
}

/** Export page: pick sections → ready JSON in a big field → Copy / Save-to-file. */
@Composable
private fun BackupExportPage(cb: MoreCallbacks) {
    val t = LocalStrings.current
    var bkSettings by remember { mutableStateOf(true) }
    var bkSubs by remember { mutableStateOf(true) }
    var bkHosts by remember { mutableStateOf(true) }
    var status by remember { mutableStateOf("") }
    val any = bkSettings || bkSubs || bkHosts
    // Rebuilt only when the selection changes (each build hits the DB once).
    val json = remember(bkSettings, bkSubs, bkHosts) {
        if (bkSettings || bkSubs || bkHosts) cb.onBuildBackup(bkSettings, bkSubs, bkHosts) else ""
    }
    Column(Modifier.fillMaxSize().padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(t.backupSelectExport, fontWeight = FontWeight.Bold, fontSize = 15.sp)
        BackupCheck(t.backupSettings, bkSettings) { bkSettings = it }
        BackupCheck(t.backupSubs, bkSubs) { bkSubs = it }
        BackupCheck(t.backupHosts, bkHosts) { bkHosts = it }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Button(
                onClick = { if (json.isNotEmpty()) { cb.onCopy(json); status = "✓ ${t.backupCopyBtn}" } },
                enabled = any && json.isNotEmpty(),
                modifier = Modifier.weight(1f),
            ) { Text(t.backupCopyBtn, fontSize = 15.sp) }
            if (cb.fileIoSupported) {
                OutlinedButton(
                    onClick = { if (json.isNotEmpty()) status = cb.onSaveToFile("autoconnector_backup.json", json) },
                    enabled = any && json.isNotEmpty(),
                    modifier = Modifier.weight(1f),
                ) { Text(t.backupSaveFile, fontSize = 15.sp) }
            }
        }
        if (status.isNotEmpty()) {
            Text(status, color = AppColors.onSurfaceMuted, fontSize = 13.sp)
        }
        OutlinedTextField(
            value = json,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.fillMaxWidth().weight(1f),
            textStyle = androidx.compose.ui.text.TextStyle(fontSize = 12.sp, fontFamily = monospaceFontFamily()),
            label = { Text(t.backupJsonLabel, fontSize = 13.sp) },
        )
    }
}

/** Import page: paste JSON (or load a file) → pick sections → Import. */
@Composable
private fun BackupImportPage(cb: MoreCallbacks) {
    val t = LocalStrings.current
    var bkSettings by remember { mutableStateOf(true) }
    var bkSubs by remember { mutableStateOf(true) }
    var bkHosts by remember { mutableStateOf(true) }
    var text by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    val any = bkSettings || bkSubs || bkHosts
    Column(Modifier.fillMaxSize().padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(t.backupSelectImport, fontWeight = FontWeight.Bold, fontSize = 15.sp)
        BackupCheck(t.backupSettings, bkSettings) { bkSettings = it }
        BackupCheck(t.backupSubs, bkSubs) { bkSubs = it }
        BackupCheck(t.backupHosts, bkHosts) { bkHosts = it }
        if (cb.fileIoSupported) {
            OutlinedButton(
                onClick = { cb.onPickFile()?.let { text = it } },
                modifier = Modifier.fillMaxWidth(),
            ) { Text(t.backupLoadFile, fontSize = 15.sp) }
        } else {
            Text(t.backupAndroidFileNote, color = AppColors.onSurfaceMuted, fontSize = 13.sp)
        }
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.fillMaxWidth().weight(1f),
            textStyle = androidx.compose.ui.text.TextStyle(fontSize = 12.sp, fontFamily = monospaceFontFamily()),
            label = { Text(t.backupPasteLabel, fontSize = 13.sp) },
        )
        Button(
            onClick = { if (text.isNotBlank() && any) status = cb.onImportText(text, bkSettings, bkSubs, bkHosts) },
            enabled = text.isNotBlank() && any,
            modifier = Modifier.fillMaxWidth(),
        ) { Text(t.backupDoImport, fontSize = 15.sp) }
        if (status.isNotEmpty()) {
            Text(status, color = AppColors.onSurfaceMuted, fontSize = 13.sp)
        }
    }
}

/** A small button that copies a slice of the export list (label spells "copy N"). */
@Composable
private fun CountCopyButton(label: String, enabled: Boolean, modifier: Modifier = Modifier, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 4.dp, vertical = 8.dp),
    ) {
        Text(label, fontSize = 13.sp, maxLines = 1)
    }
}
