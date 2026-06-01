package io.autoconnector.ui.screens

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
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
import io.autoconnector.engine.EngineSettings
import io.autoconnector.engine.EngineState
import io.autoconnector.engine.HandshakeOption
import io.autoconnector.engine.HandshakeStatRow
import io.autoconnector.engine.SourceItem
import io.autoconnector.ui.components.CardBox
import io.autoconnector.ui.components.Caption
import io.autoconnector.ui.components.Cell
import io.autoconnector.ui.components.StatTable
import io.autoconnector.ui.components.cell
import io.autoconnector.ui.theme.AppColors

enum class MoreDest(val title: String) {
    SETTINGS("Настройки"), SOURCES("Подписки"), STATS("Статистика"), EXPORT("Экспорт")
}

class MoreCallbacks(
    val settings: EngineSettings,
    val handshakeOptions: List<HandshakeOption>,
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
)

/** The "Ещё" tab body — just the menu. Entries open full-screen via [onOpen]. */
@Composable
fun MoreScreen(onOpen: (MoreDest) -> Unit) {
    Column(Modifier.fillMaxSize().padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        MenuEntry("Настройки", "Порты, анти-DPI, скан, сеть, батарея") { onOpen(MoreDest.SETTINGS) }
        MenuEntry("Подписки", "Источники прокси для скана") { onOpen(MoreDest.SOURCES) }
        MenuEntry("Статистика", "База прокси + анти-DPI хитрости") { onOpen(MoreDest.STATS) }
        MenuEntry("Экспорт", "tg:// ссылки живых прокси") { onOpen(MoreDest.EXPORT) }
    }
}

/** Full-screen page (with a back top-bar) for one [MoreDest]. */
@Composable
fun MoreFullPage(dest: MoreDest, cb: MoreCallbacks, onBack: () -> Unit) {
    androidx.compose.material3.Surface(Modifier.fillMaxSize(), color = AppColors.background) {
        Column(Modifier.fillMaxSize()) {
            TopBar(dest.title, onBack)
            when (dest) {
                MoreDest.SETTINGS -> SettingsPage(cb)
                MoreDest.SOURCES -> SourcesPage(cb)
                MoreDest.STATS -> StatsPage(cb)
                MoreDest.EXPORT -> ExportPage(cb)
            }
        }
    }
}

@Composable
private fun TopBar(title: String, onBack: () -> Unit) {
    Box(Modifier.fillMaxWidth().background(Brush.horizontalGradient(listOf(AppColors.accent, AppColors.accentDark)))) {
        Row(Modifier.fillMaxWidth().height(54.dp).padding(horizontal = 4.dp), verticalAlignment = Alignment.CenterVertically) {
            IconButton(onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, "Назад", tint = Color.White) }
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
    var vpnMode by remember { mutableStateOf(s.proxyModeCode) }
    var hsExpanded by remember { mutableStateOf(false) }
    var help by remember { mutableStateOf<Pair<String, String>?>(null) }

    // Auto-save: build settings from the current field values and persist.
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
            )
        )
    }
    // Persist whatever the user typed when leaving the page.
    androidx.compose.runtime.DisposableEffect(Unit) { onDispose { save() } }

    help?.let { (t, b) ->
        AlertDialog(
            onDismissRequest = { help = null },
            confirmButton = { TextButton({ help = null }) { Text("Понятно") } },
            title = { Text(t, fontWeight = FontWeight.Bold) },
            text = { Text(b, fontSize = 15.sp) },
        )
    }

    Column(
        Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Section("Порты релея") {
            help = "Порты релея" to "Локальные порты, которые слушает Коннектор. Именно их вы " +
                "указываете в Telegram как SOCKS5-прокси (127.0.0.1 : порт). Два порта нужны " +
                "для надёжности — Telegram держит соединения к обоим."
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            NumField(portA, { portA = it }, "Порт A", Modifier.weight(1f))
            NumField(portB, { portB = it }, "Порт B", Modifier.weight(1f))
        }

        Section("Анти-DPI хитрость") {
            help = "Анти-DPI хитрость" to
                "Способ маскировки соединения, чтобы провайдер/DPI не распознал и не " +
                "заблокировал его.\n• «Авто-перебор» сам подбирает рабочий трюк.\n" +
                "• «Без DPI-трюков» — обычное соединение.\n• Остальные — конкретные приёмы " +
                "(имитация браузеров, дробление пакетов и т.п.)."
        }
        HandshakePicker(cb.handshakeOptions, hs, hsExpanded, { hsExpanded = it }) { hs = it; save() }
        SwitchRow("Только FakeTLS (ee)", fakeTls) { fakeTls = it; save() }

        Section("Применять анти-DPI к") {
            help = "Применять анти-DPI к" to
                "К чему применять выбранный анти-DPI трюк:\n" +
                "• Релею Telegram — к живому соединению Telegram через Коннектор.\n" +
                "• Пробам прокси — к фоновым проверкам прокси (тогда проверка ведёт себя " +
                "так же, как реальное подключение, и статистика хитростей точнее)."
        }
        SwitchRow("Релею Telegram", dpiRelay) { dpiRelay = it; save() }
        SwitchRow("Пробам прокси", dpiProbes) { dpiProbes = it; save() }

        Section("При включённом VPN") {
            help = "При включённом VPN" to
                "Что делать, когда на устройстве активен VPN:\n" +
                "• Через MTProto-прокси — Telegram, как обычно, идёт через найденные " +
                "прокси (поверх VPN).\n" +
                "• Напрямую — Коннектор НЕ использует прокси и соединяет Telegram напрямую " +
                "с серверами Telegram: VPN уже даёт доступ, лишний прокси-слой не нужен " +
                "(быстрее и стабильнее). Без VPN прокси используются как обычно."
        }
        ChoiceRow(
            "Проксировать через MTProto",
            "даже при VPN трафик идёт через прокси",
            selected = vpnMode != "vpn_only",
        ) { vpnMode = "use"; save() }
        ChoiceRow(
            "Проксировать напрямую",
            "при активном VPN — в обход прокси, прямо к Telegram",
            selected = vpnMode == "vpn_only",
        ) { vpnMode = "vpn_only"; save() }

        // Notifications.
        var showNotifInfo by remember { mutableStateOf(false) }
        if (showNotifInfo) {
            AlertDialog(
                onDismissRequest = { showNotifInfo = false },
                confirmButton = { TextButton({ showNotifInfo = false }) { Text("Понятно") } },
                title = { Text("Зачем уведомления?", fontWeight = FontWeight.Bold) },
                text = {
                    Text(
                        "Уведомление с постоянным значком — это foreground-сервис Android. " +
                            "Без него система выгрузит приложение из памяти, и оно перестанет " +
                            "искать прокси и держать соединение в фоне. Поэтому уведомления " +
                            "обязательны для работы AutoConnector.",
                        fontSize = 15.sp,
                    )
                },
            )
        }
        Section("Уведомления", null)
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Row(Modifier.weight(1f).clickable { showNotifInfo = true }, verticalAlignment = Alignment.CenterVertically) {
                Text("Уведомления", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Spacer(Modifier.width(6.dp))
                Icon(Icons.Filled.Info, "Подробнее", tint = AppColors.accent, modifier = Modifier.size(20.dp))
            }
            Switch(notif, { notif = it; save() })
        }
        if (!notif) {
            Text(
                "Включите уведомления! Без них приложение не сможет работать в фоновом " +
                    "режиме — Android выгрузит его, поиск прокси и соединение остановятся.",
                color = AppColors.red,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
            )
        }

        Section("Скан и проверка") {
            help = "Скан и проверка" to
                "• Скан, мин — как часто скачивать списки прокси из подписок.\n" +
                "• Проверка, мин — как часто перепроверять прокси из базы на живость.\n" +
                "• Размер пачки — сколько прокси проверять за один прогон.\n" +
                "• Параллельно — сколько проверок выполнять одновременно (больше = быстрее, " +
                "но выше нагрузка на сеть и батарею)."
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            NumField(scanInt, { scanInt = it }, "Скан, мин", Modifier.weight(1f))
            NumField(checkInt, { checkInt = it }, "Проверка, мин", Modifier.weight(1f))
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            NumField(batch, { batch = it }, "Размер пачки", Modifier.weight(1f))
            NumField(conc, { conc = it }, "Параллельно", Modifier.weight(1f))
        }

        Section("Скорость по сети") {
            help = "Скорость по сети" to
                "Множители скорости проверок в зависимости от текущей сети. 1.0 = базовая " +
                "скорость. Меньше — бережнее к трафику/батарее, больше — агрессивнее.\n" +
                "• VPN — когда активен внешний VPN.\n• Wi-Fi — в Wi-Fi сети.\n• LTE — в мобильной сети."
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            NumField(spVpn, { spVpn = it }, "VPN", Modifier.weight(1f), decimal = true)
            NumField(spWifi, { spWifi = it }, "Wi-Fi", Modifier.weight(1f), decimal = true)
            NumField(spLte, { spLte = it }, "LTE", Modifier.weight(1f), decimal = true)
        }

        Section("Адаптивная скорость") {
            help = "Адаптивная скорость" to
                "Авто-регулировка интенсивности по числу живых прокси:\n" +
                "• Порог «много» — если живых больше этого числа, проверки замедляются " +
                "множителем «fast» (база уже хорошая, экономим ресурсы).\n" +
                "• Порог «мало» — если живых меньше, проверки ускоряются множителем «lazy», " +
                "чтобы быстрее набрать живых."
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            NumField(aliveThr, { aliveThr = it }, "Порог «много»", Modifier.weight(1f))
            NumField(fastMul, { fastMul = it }, "Множ. fast", Modifier.weight(1f), decimal = true)
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            NumField(lazyThr, { lazyThr = it }, "Порог «мало»", Modifier.weight(1f))
            NumField(lazyMul, { lazyMul = it }, "Множ. lazy", Modifier.weight(1f), decimal = true)
        }

        Section("Сеть и батарея") {
            help = "Сеть и батарея" to
                "• Только по Wi-Fi — не сканировать в мобильной сети (экономия трафика).\n" +
                "• Только при зарядке — работать, лишь когда телефон на зарядке.\n" +
                "• Пропускать при низком заряде — приостанавливать скан при низком заряде батареи."
        }
        SwitchRow("Только по Wi-Fi", wifiOnly) { wifiOnly = it; save() }
        SwitchRow("Только при зарядке", charging) { charging = it; save() }
        SwitchRow("Пропускать при низком заряде", skipLow) { skipLow = it; save() }

        Text(
            "Настройки сохраняются автоматически.",
            color = AppColors.onSurfaceMuted,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 4.dp),
        )
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
    val current = options.firstOrNull { it.ordinal == selectedOrdinal } ?: options.firstOrNull()
    OutlinedButton({ setExpanded(true) }, Modifier.fillMaxWidth()) {
        Text(current?.label ?: "—", fontSize = 15.sp, color = if (current?.special == true) AppColors.accent else AppColors.onSurface)
    }
    DropdownMenu(expanded, { setExpanded(false) }) {
        options.forEachIndexed { i, opt ->
            DropdownMenuItem(
                text = {
                    Text(
                        opt.label,
                        fontSize = 15.sp,
                        fontWeight = if (opt.special) FontWeight.Bold else FontWeight.Normal,
                        color = if (opt.special) AppColors.accent else AppColors.onSurface,
                    )
                },
                onClick = { onPick(opt.ordinal); setExpanded(false) },
            )
            // Divider after the two special entries (AUTO / NONE).
            if (opt.special && (i + 1 < options.size) && !options[i + 1].special) {
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
                Icon(Icons.Filled.HelpOutline, "Что это?", tint = AppColors.accent, modifier = Modifier.size(20.dp))
            }
        }
    }
}

@Composable
private fun NumField(value: String, onChange: (String) -> Unit, label: String, modifier: Modifier, decimal: Boolean = false) {
    OutlinedTextField(
        value,
        { v -> onChange(v.filter { it.isDigit() || (decimal && (it == '.' || it == ',')) }.replace(',', '.')) },
        modifier,
        label = { Text(label, fontSize = 14.sp) },
        textStyle = androidx.compose.ui.text.TextStyle(fontSize = 16.sp),
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
            Text(desc, color = AppColors.onSurfaceMuted, fontSize = 14.sp)
        }
    }
}

// === Sources ============================================================

@Composable
private fun SourcesPage(cb: MoreCallbacks) {
    var newUrl by remember { mutableStateOf("") }
    Column(Modifier.fillMaxSize().padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(newUrl, { newUrl = it }, Modifier.weight(1f), label = { Text("URL источника", fontSize = 14.sp) }, singleLine = true)
            Spacer(Modifier.width(8.dp))
            Button({ if (newUrl.isNotBlank()) { cb.onAddSource(newUrl.trim()); newUrl = "" } }) { Text("+", fontSize = 16.sp) }
        }
        Column(
            Modifier.fillMaxWidth().verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            for (src in cb.sources) {
                CardBox(Modifier.fillMaxWidth()) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Column(Modifier.weight(1f)) {
                            Text(src.url, fontSize = 14.sp, maxLines = 1, fontFamily = FontFamily.Monospace)
                            Text("живых ${src.alive}/${src.total}" + (src.lastError?.let { " · $it" } ?: ""), color = AppColors.onSurfaceMuted, fontSize = 14.sp, maxLines = 1)
                        }
                        Switch(src.enabled, { cb.onToggleSource(src.id, it) })
                        IconButton({ cb.onRemoveSource(src.id) }) {
                            Icon(Icons.Filled.Delete, "Удалить", tint = AppColors.red)
                        }
                    }
                }
            }
        }
    }
}

// === Stats ==============================================================

@Composable
private fun StatsPage(cb: MoreCallbacks) {
    val s = cb.state
    val hs = cb.handshakeStats()
    Column(
        Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        SubTitle("База прокси")
        StatTable(
            rows = listOf(
                listOf(cell("Всего в базе"), cell("${s.totalCount}", bold = true)),
                listOf(cell("Живых сейчас"), cell("${s.aliveCount}", AppColors.green, bold = true)),
                listOf(cell("Мёртвых"), cell("${s.deadCount}", AppColors.onSurface)),
                listOf(cell("Живых за 15 мин"), cell("${s.aliveWithin15}")),
                listOf(cell("Проверок за всё время"), cell("${s.checkedAllTime}")),
            ),
            weights = listOf(1.4f, 1f),
            fontSize = 14,
        )

        SubTitle("Анти-DPI хитрости")
        if (hs.isEmpty()) {
            Caption("ещё нет данных — хитрости накапливаются по мере проверок/подключений")
        } else {
            for (r in hs) {
                CardBox(Modifier.fillMaxWidth()) {
                    Column {
                        Text(r.label, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = AppColors.accent)
                        Spacer(Modifier.height(6.dp))
                        StatTable(
                            rows = listOf(
                                listOf(cell("Попыток"), cell("${r.attempts}", bold = true), cell("Handshake"), cell("${r.handshakes} (${r.hsRatePct}%)", AppColors.blue, bold = true)),
                                listOf(cell("TG-коннект"), cell("${r.tgConnected}", AppColors.green, bold = true), cell("Балл"), cell(if (r.score >= 0) fmt2(r.score) else "—", bold = true)),
                                listOf(cell("Сокеты >10КБ"), cell("${r.over10k}"), cell(">100КБ"), cell("${r.over100k}")),
                                listOf(cell("Сокеты >1мин"), cell("${r.over1m}"), cell(">5мин"), cell("${r.over5m}")),
                                listOf(cell("Время работы"), cell(r.activeHuman, bold = true), cell("Трафик"), cell(r.trafficHuman)),
                            ),
                            weights = listOf(1.3f, 1f, 1f, 1f),
                            fontSize = 14,
                        )
                    }
                }
            }
            Text(
                "Handshake — успешных рукопожатий (% от попыток) · Балл — выгодность · " +
                    "«Время работы» — суммарно по сокетам ≥5КБ и дольше 1 минуты.",
                color = AppColors.onSurfaceMuted,
                fontSize = 14.sp,
            )
            OutlinedButton(onClick = cb.onResetStats, modifier = Modifier.fillMaxWidth()) {
                Text("Сбросить статистику хитростей", fontSize = 15.sp)
            }
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
private fun SubTitle(t: String) {
    Text(t, color = AppColors.accent, fontWeight = FontWeight.Bold, fontSize = 15.sp, modifier = Modifier.padding(top = 4.dp))
}

private fun fmt2(v: Double): String {
    val x = (v * 100).toInt() / 100.0
    return x.toString()
}

// === Export =============================================================

@Composable
private fun ExportPage(cb: MoreCallbacks) {
    val links = remember { cb.exportLinks() }
    Column(Modifier.fillMaxSize().padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("Живых ссылок: ${links.size}", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Button(
            onClick = { cb.onCopy(links.joinToString("\n")) },
            modifier = Modifier.fillMaxWidth(),
            enabled = links.isNotEmpty(),
        ) { Text("Скопировать все", fontSize = 16.sp) }
        Column(
            Modifier.fillMaxWidth().verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            for (l in links) {
                Text(l, fontFamily = FontFamily.Monospace, fontSize = 14.sp, maxLines = 1)
            }
            Spacer(Modifier.height(8.dp))
        }
    }
}
