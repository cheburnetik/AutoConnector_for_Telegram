package io.autoconnector.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.HelpOutline
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.autoconnector.engine.AppInfo
import io.autoconnector.engine.EngineSettings
import io.autoconnector.engine.EngineState
import io.autoconnector.engine.ExpEngineOption
import io.autoconnector.engine.HandshakeOption
import io.autoconnector.engine.HandshakeStatRow
import io.autoconnector.engine.SourceItem
import io.autoconnector.i18n.LocalStrings
import kotlin.math.log10
import kotlin.math.pow
import kotlin.math.roundToInt
import io.autoconnector.i18n.Strings
import io.autoconnector.ui.components.CardBox
import io.autoconnector.ui.components.Caption
import io.autoconnector.ui.components.StatTable
import io.autoconnector.ui.components.cell
import io.autoconnector.ui.theme.AppColors
import io.autoconnector.ui.theme.monospaceFontFamily
import io.autoconnector.ui.theme.sansFontFamily

enum class MoreDest { SETTINGS, SOURCES, STATS, EXPORT, ABOUT }

private fun titleFor(dest: MoreDest, t: Strings) = when (dest) {
    MoreDest.SETTINGS -> t.settings
    MoreDest.SOURCES -> t.subscriptions
    MoreDest.STATS -> t.statistics
    MoreDest.EXPORT -> t.export
    MoreDest.ABOUT -> t.about
}

class MoreCallbacks(
    val settings: EngineSettings,
    val handshakeOptions: List<HandshakeOption>,
    val expEngineOptions: List<ExpEngineOption>,
    val connectEngineOptions: List<ExpEngineOption>,
    val netLogPath: String?,
    val onOpenNetLogFolder: () -> Unit,
    val onUpdateSettings: (EngineSettings) -> Unit,
    val sources: List<SourceItem>,
    val onAddSource: (String) -> Unit,
    val onRemoveSource: (Long) -> Unit,
    val onToggleSource: (Long, Boolean) -> Unit,
    val state: EngineState,
    val exportLinks: () -> List<String>,
    val onCopy: (String) -> Unit,
    val handshakeStats: () -> List<HandshakeStatRow>,
    val onResetStats: () -> Unit,
    val onResetCatalogStats: () -> Unit,
    val onClearHosts: () -> Unit,
    val appInfo: AppInfo,
    val onOpenUrl: (String) -> Unit,
)

/** The "More" tab body — just the menu. */
@Composable
fun MoreScreen(onOpen: (MoreDest) -> Unit, onOpenGuide: () -> Unit) {
    val t = LocalStrings.current
    Column(Modifier.fillMaxSize().padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        MenuEntry(t.setupPortsTitle, t.setupPortsSub, onOpenGuide)
        MenuEntry(t.settings, t.settingsSub) { onOpen(MoreDest.SETTINGS) }
        MenuEntry(t.subscriptions, t.subscriptionsSub) { onOpen(MoreDest.SOURCES) }
        MenuEntry(t.statistics, t.statisticsSub) { onOpen(MoreDest.STATS) }
        MenuEntry(t.export, t.exportSub) { onOpen(MoreDest.EXPORT) }
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
                MoreDest.STATS -> StatsPage(cb)
                MoreDest.EXPORT -> ExportPage(cb)
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
    androidx.compose.material3.Surface(Modifier.fillMaxSize(), color = AppColors.background) {
        Column(Modifier.fillMaxSize()) {
            TopBar(t.quickSwitchTitle, onBack)
            Column(
                Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                // 1) Дробление проксирования — socket wire shaping.
                SubTitle(t.expEngineTitle)
                cb.expEngineOptions.forEach { opt ->
                    QuickChoice(opt.label, opt.description, s.expEngineMode == opt.code) {
                        cb.onUpdateSettings(s.copy(expEngineMode = opt.code)); onBack()
                    }
                }

                Spacer(Modifier.height(10.dp))

                // 2) Движок коннекта — how the relay finds a working upstream.
                SubTitle(t.expConnectTitle)
                cb.connectEngineOptions.forEach { opt ->
                    QuickChoice(opt.label, opt.description, s.relayConnectMode == opt.code) {
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
    var spVpn by remember { mutableStateOf(s.speedVpn.toString()) }
    var spWifi by remember { mutableStateOf(s.speedWifi.toString()) }
    var spLte by remember { mutableStateOf(s.speedLte.toString()) }
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
    var vpnMode by remember { mutableStateOf(s.proxyModeCode) }
    var lang by remember { mutableStateOf(s.langCode) }
    var expEngine by remember { mutableStateOf(s.expEngineMode) }
    var connEngine by remember { mutableStateOf(s.relayConnectMode) }
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
                langCode = lang,
                expEngineMode = expEngine,
                netLogEnabled = netLog,
                relayConnectMode = connEngine,
            )
        )
    }
    androidx.compose.runtime.DisposableEffect(Unit) { onDispose { save() } }

    help?.let { (ht, hb) ->
        AlertDialog(
            onDismissRequest = { help = null },
            confirmButton = { TextButton({ help = null }) { Text(t.gotIt) } },
            title = { Text(ht, fontWeight = FontWeight.Bold) },
            text = { Text(hb, fontSize = 15.sp) },
        )
    }

    Column(
        Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        // Language.
        Section(t.language, null)
        ChoiceRow(t.langAuto, "", selected = lang == "auto") { lang = "auto"; save() }
        ChoiceRow(t.langRu, "", selected = lang == "ru") { lang = "ru"; save() }
        ChoiceRow(t.langEn, "", selected = lang == "en") { lang = "en"; save() }

        Section(t.relayPorts) { help = t.relayPorts to t.relayPortsHelp }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            NumField(portA, { portA = it }, t.portA, Modifier.weight(1f))
            NumField(portB, { portB = it }, t.portB, Modifier.weight(1f))
        }

        Section(t.antiDpiTrick) { help = t.antiDpiTrick to t.antiDpiHelp }
        HandshakePicker(cb.handshakeOptions, hs, hsExpanded, { hsExpanded = it }) { hs = it; save() }
        SwitchRow(t.onlyFakeTls, fakeTls) { fakeTls = it; save() }

        Section(t.applyDpiTo) { help = t.applyDpiTo to t.applyDpiHelp }
        SwitchRow(t.toRelay, dpiRelay) { dpiRelay = it; save() }
        SwitchRow(t.toProbes, dpiProbes) { dpiProbes = it; save() }
        SwitchRow(t.toDirect, dpiDirect) { dpiDirect = it; save() }

        Section(t.vpnSection) { help = t.vpnSection to t.vpnHelp }
        ChoiceRow(t.viaMtproto, t.viaMtprotoSub, selected = vpnMode != "vpn_only") { vpnMode = "use"; save() }
        ChoiceRow(t.directly, t.directlySub, selected = vpnMode == "vpn_only") { vpnMode = "vpn_only"; save() }

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

        Section(t.scanCheck) { help = t.scanCheck to t.scanCheckHelp }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            NumField(scanInt, { scanInt = it }, t.scanMin, Modifier.weight(1f))
            NumField(checkInt, { checkInt = it }, t.checkMin, Modifier.weight(1f))
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            NumField(batch, { batch = it }, t.batchSize, Modifier.weight(1f))
            NumField(conc, { conc = it }, t.parallel, Modifier.weight(1f))
        }

        Section(t.speedByNet) { help = t.speedByNet to t.speedByNetHelp }
        IntensitySlider("VPN", spVpn.toFloatOrNull() ?: 1f) { spVpn = fmtMult(it); save() }
        IntensitySlider("Wi-Fi", spWifi.toFloatOrNull() ?: 1f) { spWifi = fmtMult(it); save() }
        IntensitySlider("LTE", spLte.toFloatOrNull() ?: 1f) { spLte = fmtMult(it); save() }

        Section(t.adaptiveSpeed) { help = t.adaptiveSpeed to t.adaptiveHelp }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            NumField(aliveThr, { aliveThr = it }, t.threshMany, Modifier.weight(1f))
            NumField(fastMul, { fastMul = it }, t.mulFast, Modifier.weight(1f), decimal = true)
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            NumField(lazyThr, { lazyThr = it }, t.threshFew, Modifier.weight(1f))
            NumField(lazyMul, { lazyMul = it }, t.mulLazy, Modifier.weight(1f), decimal = true)
        }

        Section(t.netBattery) { help = t.netBattery to t.netBatteryHelp }
        SwitchRow(t.onlyWifi, wifiOnly) { wifiOnly = it; save() }
        SwitchRow(t.onlyCharging, charging) { charging = it; save() }
        SwitchRow(t.skipLowBattery, skipLow) { skipLow = it; save() }

        // --- Experimental ------------------------------------------------
        Section(t.experimental) { help = t.experimental to t.experimentalHelp }

        // Connect engine — how fast the relay finds a working upstream.
        Text(t.expConnectTitle, fontWeight = FontWeight.Bold, fontSize = 15.sp)
        ExpEnginePicker(cb.connectEngineOptions, connEngine, connExpanded, { connExpanded = it }) { connEngine = it; save() }
        cb.connectEngineOptions.firstOrNull { it.code == connEngine }?.let { opt ->
            Text(opt.description, color = AppColors.onSurfaceMuted, fontSize = 13.sp)
        }
        if (connEngine != 0) {
            Text(t.expEngineWarn, color = AppColors.red, fontSize = 13.sp)
        }
        Spacer(Modifier.height(8.dp))

        // Proxying engine — socket-level wire shaping (obfuscation).
        Text(t.expEngineTitle, fontWeight = FontWeight.Bold, fontSize = 15.sp)
        ExpEnginePicker(cb.expEngineOptions, expEngine, expExpanded, { expExpanded = it }) { expEngine = it; save() }
        cb.expEngineOptions.firstOrNull { it.code == expEngine }?.let { opt ->
            Text(opt.description, color = AppColors.onSurfaceMuted, fontSize = 13.sp)
        }
        if (expEngine != 0) {
            Text(t.expEngineWarn, color = AppColors.red, fontSize = 13.sp)
        }
        Spacer(Modifier.height(4.dp))
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

        // --- Reset / maintenance ----------------------------------------
        Section(t.maintenance) { help = t.maintenance to t.maintenanceHelp }
        var confirmCatalog by remember { mutableStateOf(false) }
        var confirmHosts by remember { mutableStateOf(false) }
        OutlinedButton(onClick = { confirmCatalog = true }, modifier = Modifier.fillMaxWidth()) {
            Text(t.resetCatalog, fontSize = 15.sp)
        }
        OutlinedButton(onClick = { confirmHosts = true }, modifier = Modifier.fillMaxWidth()) {
            Text(t.clearHosts, fontSize = 15.sp, color = AppColors.red)
        }
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
                title = { Text(t.clearHosts, fontWeight = FontWeight.Bold) },
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

@Composable
private fun Section(title: String, onHelp: (() -> Unit)? = null) {
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

/** Formats a scan-speed multiplier compactly: integers without a trailing ".0". */
private fun fmtMult(m: Float): String {
    val r = (m * 100f).roundToInt() / 100f
    return if (r == r.toInt().toFloat()) r.toInt().toString() else r.toString()
}

/**
 * Logarithmic scan-intensity slider. The underlying value is the check-interval
 * multiplier used by dynamicCheckInterval(): 1.0 = standard, >1 scans rarer
 * (slower), <1 scans more often (faster). The slider is log-scaled over
 * [0.01 .. 100] so "standard" sits dead centre and each end is ×100. A live
 * caption translates the raw multiplier into «стандарт / медленнее ×N / быстрее ×N».
 */
@Composable
private fun IntensitySlider(label: String, mult: Float, onChange: (Float) -> Unit) {
    val t = LocalStrings.current
    val minLog = -2.0; val maxLog = 2.0     // 0.01 .. 100
    val clamped = mult.coerceIn(0.01f, 100f)
    val pos = ((log10(clamped.toDouble()) - minLog) / (maxLog - minLog))
        .coerceIn(0.0, 1.0).toFloat()
    val caption = when {
        clamped in 0.9f..1.1f -> t.intensStandard
        clamped > 1.1f -> t.intensSlower + " ×" + clamped.roundToInt()
        else -> t.intensFaster + " ×" + (1f / clamped).roundToInt()
    }
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text(label, fontWeight = FontWeight.Bold, fontSize = 15.sp, modifier = Modifier.weight(1f))
            Text(caption, color = AppColors.accent, fontSize = 14.sp, fontWeight = FontWeight.Bold)
        }
        Slider(
            value = pos,
            onValueChange = { p ->
                val m = 10.0.pow(minLog + p * (maxLog - minLog)).toFloat()
                onChange(m)
            },
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
    var newUrl by remember { mutableStateOf("") }
    Column(Modifier.fillMaxSize().padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(newUrl, { newUrl = it }, Modifier.weight(1f), label = { Text(t.sourceUrl, fontSize = 14.sp) }, singleLine = true)
            Spacer(Modifier.width(8.dp))
            Button({ if (newUrl.isNotBlank()) { cb.onAddSource(newUrl.trim()); newUrl = "" } }) { Text("+", fontSize = 16.sp) }
        }
        Column(
            Modifier.fillMaxWidth().verticalScroll(rememberScrollState()),
        ) {
            for (src in cb.sources) {
                SourceTile(src, cb, t)
                HorizontalDivider(color = AppColors.cardBorder)
            }
        }
    }
}

/** One subscription row: no card background, separated by dividers. */
@Composable
private fun SourceTile(src: SourceItem, cb: MoreCallbacks, t: Strings) {
    Column(
        Modifier.fillMaxWidth().padding(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        // 1) Full URL, multi-line, in a read-only field (selectable/copyable).
        OutlinedTextField(
            value = src.url,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),
            textStyle = androidx.compose.ui.text.TextStyle(
                fontFamily = monospaceFontFamily(), fontSize = 13.sp,
            ),
        )
        // 2) Big green alive count + "живых, N мёртвых, N всего"; №seq on the right.
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text("${src.alive}", color = AppColors.green, fontWeight = FontWeight.Bold, fontSize = 22.sp)
            Text(t.sourceCounts(src.dead, src.total), color = AppColors.onSurfaceMuted, fontSize = 14.sp)
            Spacer(Modifier.weight(1f))
            Text("№${src.seq}", color = AppColors.onSurfaceMuted, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
        // 3) When downloaded, and either the size or the error.
        val whenTxt = if (src.lastRefreshMinsAgo >= 0) t.agoFmt(fmtAgo(src.lastRefreshMinsAgo, t)) else t.notDownloaded
        Row(Modifier.fillMaxWidth()) {
            Text("$whenTxt · ", color = AppColors.onSurfaceMuted, fontSize = 13.sp)
            if (src.lastError != null) {
                Text(src.lastError, color = AppColors.red, fontSize = 13.sp)
            } else {
                Text(src.bytesHuman, color = AppColors.onSurfaceMuted, fontSize = 13.sp)
            }
        }
        // 4) Gray icon actions + enabled toggle.
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            IconButton({ cb.onOpenUrl(src.url) }) { Icon(Icons.Filled.OpenInNew, t.open, tint = AppColors.gray) }
            IconButton({ cb.onCopy(src.url) }) { Icon(Icons.Filled.ContentCopy, t.copy, tint = AppColors.gray) }
            IconButton({ cb.onRemoveSource(src.id) }) { Icon(Icons.Filled.Delete, t.delete, tint = AppColors.gray) }
            Spacer(Modifier.weight(1f))
            Switch(src.enabled, { cb.onToggleSource(src.id, it) })
        }
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
        Text("AutoConnector for Telegram", fontWeight = FontWeight.Bold, fontSize = 19.sp, color = AppColors.accent)
        Text(t.appTagline, fontSize = 15.sp)

        StatTable(
            rows = listOf(
                listOf(cell(t.version), cell(cb.appInfo.version, bold = true)),
                listOf(cell(t.buildDate), cell(cb.appInfo.buildDate, bold = true)),
            ),
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

// === Export =============================================================

@Composable
private fun ExportPage(cb: MoreCallbacks) {
    val t = LocalStrings.current
    val links = remember { cb.exportLinks() }
    val allText = remember(links) { links.joinToString("\n") }
    fun copyN(n: Int) { if (links.isNotEmpty()) cb.onCopy(links.take(n).joinToString("\n")) }
    Column(Modifier.fillMaxSize().padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(t.aliveLinks(links.size), fontWeight = FontWeight.Bold, fontSize = 16.sp)

        // Copy the first 1 / 10 / 30 / 100 / all links.
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            CountCopyButton("1", links.isNotEmpty(), Modifier.weight(1f)) { copyN(1) }
            CountCopyButton("10", links.isNotEmpty(), Modifier.weight(1f)) { copyN(10) }
            CountCopyButton("30", links.isNotEmpty(), Modifier.weight(1f)) { copyN(30) }
            CountCopyButton("100", links.isNotEmpty(), Modifier.weight(1f)) { copyN(100) }
            CountCopyButton(t.allShort, links.isNotEmpty(), Modifier.weight(1f)) { copyN(links.size) }
        }

        // Open / copy a random link from the list.
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedButton(
                onClick = { if (links.isNotEmpty()) cb.onOpenUrl(links.random()) },
                enabled = links.isNotEmpty(), modifier = Modifier.weight(1f),
                contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 6.dp, vertical = 8.dp),
            ) {
                Icon(Icons.Filled.OpenInNew, null, Modifier.size(16.dp))
                Spacer(Modifier.width(6.dp)); Text(t.openRandom, fontSize = 13.sp, maxLines = 1)
            }
            OutlinedButton(
                onClick = { if (links.isNotEmpty()) cb.onCopy(links.random()) },
                enabled = links.isNotEmpty(), modifier = Modifier.weight(1f),
                contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 6.dp, vertical = 8.dp),
            ) {
                Icon(Icons.Filled.ContentCopy, null, Modifier.size(16.dp))
                Spacer(Modifier.width(6.dp)); Text(t.copyRandom, fontSize = 13.sp, maxLines = 1)
            }
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

/** A small fixed-label button that copies a slice of the export list. */
@Composable
private fun CountCopyButton(label: String, enabled: Boolean, modifier: Modifier, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 2.dp, vertical = 8.dp),
    ) {
        Text(label, fontSize = 13.sp, maxLines = 1)
    }
}
