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
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.DoneAll
import androidx.compose.material.icons.filled.Dns
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.NetworkCheck
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material.icons.filled.PushPin
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material.icons.filled.SwapVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.launch
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.autoconnector.engine.CatalogItem
import io.autoconnector.i18n.LocalStrings
import io.autoconnector.i18n.Strings
import io.autoconnector.i18n.modeLabel
import io.autoconnector.ui.components.Caption
import io.autoconnector.ui.components.StatTable
import io.autoconnector.ui.components.cell
import io.autoconnector.ui.components.RatingBars
import io.autoconnector.ui.components.StatusDot
import io.autoconnector.ui.theme.AppColors
import io.autoconnector.ui.theme.monospaceFontFamily
import io.autoconnector.ui.theme.sansFontFamily

// Icon meaning is shared between the tile and the detail page so the icons on a
// tile are self-explanatory once the user opens a host.
private val ICON_CHECKED = Icons.Filled.Schedule   // когда последний раз проверен
private val ICON_TG = Icons.Filled.Send            // когда Telegram подключался
private val ICON_CHECKS = Icons.Filled.DoneAll      // успешно / всего проверок
private val ICON_TRAFFIC = Icons.Filled.SwapVert    // трафик через прокси

/** Catalog tiles (2 rows each), sorted by rating, emitted into the page LazyColumn. */
fun LazyListScope.catalogItems(items: List<CatalogItem>, modeLabel: String, onClick: (CatalogItem) -> Unit) {
    if (items.isEmpty()) {
        item { Caption(LocalStrings.current.catalogEmpty(modeLabel), Modifier.padding(16.dp)) }
        return
    }
    item { Spacer(Modifier.height(6.dp)) }
    items(items, key = { it.id }) { p ->
        Column(Modifier.padding(horizontal = 12.dp, vertical = 3.dp)) { CatalogTile(p) { onClick(p) } }
    }
    item { Spacer(Modifier.height(6.dp)) }
}

// The five selectable network modes shown as the catalog tab row.
private val CATALOG_MODES = listOf("vpn", "lte", "wifi", "ethernet", "wp")

/**
 * Catalog with a per-network-mode tab row on top (VPN | LTE | WiFi | WhitePages),
 * then the host tiles for the selected mode. Ratings are split per mode, so the
 * list swaps when a tab is selected. The tab equal to [activeMode] reuses the
 * already-loaded [items]; other tabs are pulled lazily via [catalogForMode].
 */
@Composable
fun CatalogContent(
    items: List<CatalogItem>,
    activeMode: String,
    catalogForMode: (String) -> List<CatalogItem>,
    onManageMode: (String) -> Unit,
    onClick: (CatalogItem) -> Unit,
) {
    val t = LocalStrings.current
    val initial = if (activeMode in CATALOG_MODES) activeMode else "vpn"
    var selected by remember { mutableStateOf(initial) }
    var showHelp by remember { mutableStateOf(false) }

    if (showHelp) {
        androidx.compose.material3.AlertDialog(
            onDismissRequest = { showHelp = false },
            confirmButton = {
                androidx.compose.material3.TextButton({ showHelp = false }) { Text(t.gotIt) }
            },
            title = { Text(t.catalogModeHelpTitle, fontWeight = FontWeight.Bold) },
            text = { Text(t.catalogModeHelp, fontSize = 15.sp) },
        )
    }
    // Always pull per-mode data so a per-mode reset is reflected even on the active
    // tab (the global aggregate [items] would mask it). [items] is kept in the
    // signature only to avoid breaking the caller.
    val shown = catalogForMode(selected)

    // A plain Column (not LazyColumn): this composable is hosted inside the page's
    // outer LazyColumn item, and a nested vertical LazyColumn would crash. The
    // catalog is capped (~50 tiles) so non-lazy rendering is fine.
    Column(Modifier.fillMaxWidth()) {
        // Row 1: the mode chips spanning the full width.
        Row(
            Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            for (code in CATALOG_MODES) {
                ModeChip(
                    label = modeLabel(code),
                    selected = selected == code,
                    modifier = Modifier.weight(1f),
                ) { selected = code }
            }
        }
        // Row 2: caption «which mode this TOP is for» on the left, the gear + (?)
        // buttons on the right (below the chips, not inline with them).
        Row(
            Modifier.fillMaxWidth().padding(start = 12.dp, end = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                "${t.catalogTopFor} ${modeLabel(selected)}",
                color = AppColors.onSurfaceMuted,
                fontSize = 12.sp,
                modifier = Modifier.weight(1f),
            )
            androidx.compose.material3.IconButton(
                onClick = { onManageMode(selected) },
                modifier = Modifier.size(32.dp),
            ) {
                Icon(Icons.Filled.Settings, contentDescription = t.manageModeTitle, tint = AppColors.onSurfaceMuted, modifier = Modifier.size(20.dp))
            }
            androidx.compose.material3.IconButton(
                onClick = { showHelp = true },
                modifier = Modifier.size(32.dp),
            ) {
                Text("(?)", color = AppColors.onSurfaceMuted, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            }
        }
        // Warning when the viewed section isn't the one currently collecting stats.
        if (selected != activeMode) {
            Text(
                t.catalogInactiveWarn(modeLabel(selected), modeLabel(activeMode)),
                color = AppColors.amber,
                fontSize = 12.sp,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp),
            )
        }
        if (shown.isEmpty()) {
            Text(
                t.catalogEmpty(modeLabel(selected)),
                color = AppColors.onSurfaceMuted,
                fontSize = 12.sp,
                modifier = Modifier.fillMaxWidth().padding(16.dp),
            )
        } else {
            Spacer(Modifier.height(6.dp))
            for (p in shown) {
                Column(Modifier.padding(horizontal = 12.dp, vertical = 3.dp)) { CatalogTile(p) { onClick(p) } }
            }
            Spacer(Modifier.height(6.dp))
        }
    }
}

/** A small selectable tab chip for the catalog mode row, styled like the tiles. */
@Composable
private fun ModeChip(label: String, selected: Boolean, modifier: Modifier, onClick: () -> Unit) {
    Box(
        modifier
            .clip(RoundedCornerShape(10.dp))
            .background(if (selected) AppColors.accent else AppColors.card)
            .border(
                1.dp,
                if (selected) AppColors.accent else AppColors.cardBorder,
                RoundedCornerShape(10.dp),
            )
            .clickable(onClick = onClick)
            .padding(horizontal = 2.dp, vertical = 7.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            label,
            color = if (selected) Color.White else AppColors.onSurfaceMuted,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Composable
private fun CatalogTile(p: CatalogItem, onClick: () -> Unit) {
    val t = LocalStrings.current
    Column(
        Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(AppColors.card)
            .border(1.dp, if (p.live) AppColors.green else AppColors.cardBorder, RoundedCornerShape(12.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 10.dp, vertical = 8.dp),
    ) {
        // Row 1: host takes all spare space (truncates last), alive badge, rating bars.
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text(
                p.host,
                Modifier.weight(1f),
                color = if (p.alive) AppColors.onSurface else AppColors.gray,
                fontFamily = monospaceFontFamily(),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(Modifier.width(8.dp))
            if (p.alive) Text(t.aliveShort, color = AppColors.green, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            else Text(t.deadShort, color = AppColors.red, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Spacer(Modifier.width(8.dp))
            RatingBars(p.rating)
        }

        Spacer(Modifier.height(5.dp))

        // Row 2: status dots + key stats with icons (no text labels), aligned columns.
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Row(Modifier.width(34.dp), verticalAlignment = Alignment.CenterVertically) {
                StatusDot(if (p.live) AppColors.green else AppColors.cardBorder, 9)
                Spacer(Modifier.width(4.dp))
                val relayColor = when {
                    p.pinned -> AppColors.amber
                    p.sticky -> AppColors.blue
                    p.everServed -> AppColors.green.copy(alpha = 0.5f)
                    else -> AppColors.cardBorder
                }
                StatusDot(relayColor, 9)
            }
            IconStat(ICON_CHECKED, fmtMins(p.checkedMinsAgo, t), Modifier.weight(0.9f))
            IconStat(ICON_TG, fmtMins(p.tgConnectMinsAgo, t), Modifier.weight(0.9f))
            // Telegram-connects / successful checks / total checks.
            IconStat(ICON_CHECKS, "${p.tgConnections}/${p.successes}/${p.successes + p.failures}", Modifier.weight(1.5f))
            IconStat(ICON_TRAFFIC, p.bytesRelayedHuman, Modifier.weight(1.1f))
        }
    }
}

@Composable
private fun IconStat(icon: ImageVector, value: String, modifier: Modifier) {
    Row(modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, contentDescription = null, tint = AppColors.onSurfaceMuted, modifier = Modifier.size(14.dp))
        Spacer(Modifier.width(3.dp))
        Text(value, color = AppColors.onSurface, fontSize = 14.sp, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
    }
}

private fun fmtMins(m: Long, t: Strings): String = when {
    m < 0 -> t.dash
    m < 60 -> "$m${t.agoMin}"
    m < 1440 -> "${m / 60}${t.agoHour}"
    else -> "${m / 1440}${t.agoDay}"
}

private fun p2(n: Int): String = if (n in 0..9) "0$n" else "$n"

/** Format an epoch-ms instant as local "DD/MM HH:MM" without kotlinx-datetime. */
private fun fmtStamp(ms: Long): String {
    val local = ms + io.autoconnector.ui.localOffsetMs(ms)
    val secs = local / 1000
    val min = ((secs / 60) % 60).toInt()
    val hour = ((secs / 3600) % 24).toInt()
    val days = secs / 86400                     // days since 1970-01-01
    // Civil-from-days (Howard Hinnant's algorithm).
    val z = days + 719468
    val era = (if (z >= 0) z else z - 146096) / 146097
    val doe = z - era * 146097
    val yoe = (doe - doe / 1460 + doe / 36524 - doe / 146096) / 365
    val doy = doe - (365 * yoe + yoe / 4 - yoe / 100)
    val mp = (5 * doy + 2) / 153
    val d = (doy - (153 * mp + 2) / 5 + 1).toInt()
    val mon = (if (mp < 10) mp + 3 else mp - 9).toInt()
    return "${p2(d)}/${p2(mon)} ${p2(hour)}:${p2(min)}"
}

private fun msOrDash(v: Int, t: Strings): String = if (v >= 0) "$v${t.unitMs}" else t.dash

private fun humanBytes(b: Long): String = when {
    b <= 0L -> "0"
    b < 1024L -> "${b}B"
    b < 1024L * 1024 -> "${b / 1024}K"
    b < 1024L * 1024 * 1024 -> "${b / (1024 * 1024)}M"
    else -> "${b / (1024L * 1024 * 1024)}G"
}

/** Compact duration/"ago" formatter for the history table, e.g. "3м20с", "45с",
 *  "2ч5м", "3д". Uses the locale's short units (с / м / ч / д). */
private fun fmtSecsShort(s: Long, t: Strings): String = when {
    s < 0 -> t.dash
    s < 60 -> "$s${t.secShort}"
    s < 3600 -> "${s / 60}${t.agoMin}${s % 60}${t.secShort}"
    s < 86400 -> "${s / 3600}${t.agoHour}${(s % 3600) / 60}${t.agoMin}"
    else -> "${s / 86400}${t.agoDay}"
}

/** Full-screen, scrollable per-host detail with icons (same as the tile) + actions. */
@OptIn(androidx.compose.foundation.ExperimentalFoundationApi::class)
@Composable
fun CatalogDetailPage(
    p: CatalogItem,
    history: List<io.autoconnector.engine.HistoryRecord>,
    onCopy: () -> Unit,
    onOpen: () -> Unit,
    onMakeRelay: () -> Unit,
    onTest: () -> Unit = {},
    onStopTest: () -> Unit = {},
    testingThis: Boolean = false,
    testRunning: Boolean = false,
    testSummary: String = "",
    onBack: () -> Unit,
) {
    val t = LocalStrings.current
    val scroll = rememberScrollState()
    val scope = rememberCoroutineScope()
    // Anchor placed just above the test-result / table block, so the "Тест" button
    // scrolls there (rather than to the very bottom).
    val testAnchor = remember { androidx.compose.foundation.relocation.BringIntoViewRequester() }
    Surface(Modifier.fillMaxSize(), color = AppColors.background) {
        Box(Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {
            // Top bar with back button.
            Box(Modifier.fillMaxWidth().background(Brush.horizontalGradient(listOf(AppColors.accent, AppColors.accentDark)))) {
                Row(Modifier.fillMaxWidth().height(54.dp).padding(horizontal = 4.dp), verticalAlignment = Alignment.CenterVertically) {
                    androidx.compose.material3.IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, t.back, tint = Color.White)
                    }
                    Text(p.host, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 15.sp, fontFamily = monospaceFontFamily(), maxLines = 2)
                }
            }

            Column(
                Modifier.fillMaxWidth().weight(1f).verticalScroll(scroll).padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp),
            ) {
                // Compact one-line actions: copy / open / make-relay.
                Row(Modifier.fillMaxWidth().padding(bottom = 8.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    CompactAction(Icons.Filled.ContentCopy, t.actCopy, Modifier.weight(1f), onCopy)
                    CompactAction(Icons.AutoMirrored.Filled.OpenInNew, t.actOpen, Modifier.weight(1f), onOpen)
                    CompactAction(Icons.Filled.PushPin, t.actRelay, Modifier.weight(1f), onMakeRelay)
                }

                // All fields are selectable text (long-press / drag to copy any of
                // them). Host:port and the secret sit on top as full, untruncated
                // copyable values.
                SelectionContainer {
                    Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(2.dp)) {
                        // p.host already contains "host:port" (+ optional →sni which
                        // is shown separately as the TLS domain) — don't re-append the port.
                        CopyField(t.host, p.host.substringBefore("→").trim())
                        p.secret?.let { CopyField(t.secret, it) }
                        p.tlsDomain?.let { CopyField(t.tlsDomain, it) }

                        DetailRow(Icons.Filled.CheckCircle, t.statusLabel, if (p.alive) t.live else t.deadW, if (p.alive) AppColors.green else AppColors.red)
                        DetailRow(Icons.Filled.Bolt, t.rating, "${p.rating} / 9")
                        DetailRow(Icons.Filled.Dns, t.type, p.typeLabel)
                        DetailRow(Icons.Filled.Speed, t.rttPing, if (p.rttMs >= 0) "${p.rttMs} ${t.unitMs}" else t.dash)
                        DetailRow(ICON_CHECKED, t.checkedField, if (p.checkedMinsAgo >= 0) t.agoFmt(fmtMins(p.checkedMinsAgo, t)) else t.dash)
                        DetailRow(ICON_CHECKS, t.okOfTotal, "${p.successes} / ${p.successes + p.failures}")
                        DetailRow(ICON_TG, t.tgConnectedField, if (p.tgConnectMinsAgo >= 0) t.agoFmt(fmtMins(p.tgConnectMinsAgo, t)) else t.dash)
                        DetailRow(Icons.Filled.Send, t.tgSessions, "${p.tgConnections}")
                        DetailRow(ICON_TRAFFIC, t.trafficThroughProxy, p.bytesRelayedHuman)
                        DetailRow(Icons.Filled.Schedule, t.sessionsTotal, p.sessionTotalHuman)
                        DetailRow(Icons.Filled.Bolt, t.relayNow, if (p.live) t.yes else t.no, if (p.live) AppColors.green else AppColors.onSurfaceMuted)
                        p.sourceNum?.let { DetailRow(Icons.Filled.Storage, t.sourceSub, "#$it") }
                        p.lastErrorShort?.let { DetailRow(Icons.Filled.CheckCircle, t.lastError, it, AppColors.red) }
                    }
                }

                // Scroll anchor: just above the test-result / history table.
                Spacer(
                    Modifier.height(1.dp).fillMaxWidth().bringIntoViewRequester(testAnchor),
                )

                // Live "test this host now" status + compact summary, shown while a
                // test is in progress (or has just produced a summary for this host).
                if (testingThis) {
                    Spacer(Modifier.height(12.dp))
                    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                        Text(t.testResult, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = AppColors.accent)
                        if (testRunning) {
                            Spacer(Modifier.width(8.dp))
                            androidx.compose.material3.CircularProgressIndicator(
                                modifier = Modifier.size(16.dp),
                                strokeWidth = 2.dp,
                                color = AppColors.accent,
                            )
                            Spacer(Modifier.width(6.dp))
                            Text(t.testingNow, color = AppColors.onSurfaceMuted, fontSize = 13.sp)
                            Spacer(Modifier.weight(1f))
                            androidx.compose.material3.TextButton(onClick = onStopTest) { Text(t.testStop) }
                        }
                    }
                    if (testSummary.isNotBlank()) {
                        Spacer(Modifier.height(4.dp))
                        Text(testSummary, fontSize = 13.sp, color = AppColors.onSurface)
                    }
                }

                // Last 25 attempts (checks + Telegram connects) with per-attempt
                // timings and bytes — the most recent first.
                if (history.isNotEmpty()) {
                    Spacer(Modifier.height(12.dp))
                    Text(t.recentAttempts, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = AppColors.accent)
                    Spacer(Modifier.height(6.dp))
                    // 8-column table: who (TG/scan) · when · TCP ms · TLS ms ·
                    // request ms (post-handshake = total−tcp−tls) · session · ↓in · ↑out.
                    val rows = buildList {
                        add(
                            listOf(
                                cell(t.histWho, bold = true), cell(t.histWhen, bold = true),
                                cell("TCP", bold = true), cell("TLS", bold = true),
                                cell(t.histReq, bold = true), cell(t.histSess, bold = true),
                                cell("↓", bold = true), cell("↑", bold = true),
                            ),
                        )
                        history.forEach { r ->
                            val reqMs = if (r.totalMs >= 0 && r.tcpMs >= 0 && r.tlsMs >= 0)
                                (r.totalMs - r.tcpMs - r.tlsMs).coerceAtLeast(0) else -1
                            val okColor = if (r.success) AppColors.green else AppColors.red
                            add(
                                listOf(
                                    cell(
                                        (if (r.success) "✓" else "✗") + " " + (if (r.isTelegram) "TG" else t.histScan),
                                        color = okColor, bold = true,
                                    ),
                                    cell(fmtSecsShort(r.secondsAgo, t), mono = true),
                                    cell(if (r.tcpMs >= 0) "${r.tcpMs}" else t.dash, mono = true),
                                    cell(if (r.tlsMs >= 0) "${r.tlsMs}" else t.dash, mono = true),
                                    cell(if (reqMs >= 0) "$reqMs" else t.dash, mono = true),
                                    cell(if (r.sessionMs > 0) fmtSecsShort(r.sessionMs / 1000, t) else t.dash, mono = true),
                                    cell(humanBytes(r.bytesIn), mono = true),
                                    cell(humanBytes(r.bytesOut), mono = true),
                                ),
                            )
                        }
                    }
                    StatTable(rows, fontSize = 11, weights = listOf(1.0f, 1.1f, 0.8f, 0.8f, 0.85f, 1.05f, 0.8f, 0.8f))
                    // Plain muted legend explaining the column names and units.
                    Spacer(Modifier.height(6.dp))
                    Text(t.histLegend, color = AppColors.onSurfaceMuted, fontSize = 11.sp, lineHeight = 15.sp)
                }
                // Extra bottom padding so the last rows aren't hidden behind the
                // sticky bottom action bar.
                Spacer(Modifier.height(76.dp))
            }
        }

        // Sticky bottom action bar: copy / open, pinned over the scrollable
        // content so it is always reachable without scrolling.
        Surface(
            modifier = Modifier.align(Alignment.BottomCenter).fillMaxWidth(),
            color = AppColors.card,
            shadowElevation = 8.dp,
        ) {
            Box(Modifier.fillMaxWidth()) {
                Box(Modifier.fillMaxWidth().height(1.dp).background(AppColors.cardBorder))
                Row(
                    Modifier.fillMaxWidth().padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    androidx.compose.material3.IconButton(onClick = onCopy) {
                        Icon(Icons.Filled.ContentCopy, contentDescription = t.actCopy, tint = AppColors.accent, modifier = Modifier.size(24.dp))
                    }
                    androidx.compose.material3.IconButton(onClick = onOpen) {
                        Icon(Icons.AutoMirrored.Filled.OpenInNew, contentDescription = t.actOpen, tint = AppColors.accent, modifier = Modifier.size(24.dp))
                    }
                    // Small "Тест" action: kick off an on-demand test and scroll to
                    // the test-result block (just above the history table).
                    Button(
                        onClick = { onTest(); scope.launch { testAnchor.bringIntoView() } },
                        contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 14.dp, vertical = 6.dp),
                    ) {
                        Icon(Icons.Filled.NetworkCheck, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(Modifier.width(4.dp))
                        Text(t.testShort, fontSize = 13.sp, maxLines = 1)
                    }
                }
            }
        }
        }
    }
}

/** A compact icon+label action button for the one-line action row. */
@Composable
private fun CompactAction(icon: ImageVector, label: String, modifier: Modifier, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 6.dp, vertical = 8.dp),
    ) {
        Icon(icon, null, Modifier.size(16.dp))
        Spacer(Modifier.width(4.dp))
        Text(label, fontSize = 13.sp, maxLines = 1)
    }
}

/** A full, untruncated, selectable label/value field (wrap freely so the whole
 *  value can be selected and copied). Lives inside a SelectionContainer. */
@Composable
private fun CopyField(label: String, value: String) {
    Column(Modifier.fillMaxWidth().padding(vertical = 6.dp)) {
        Text(label, color = AppColors.onSurfaceMuted, fontSize = 13.sp)
        Text(value, color = AppColors.onSurface, fontWeight = FontWeight.Bold, fontSize = 14.sp, fontFamily = monospaceFontFamily())
    }
    Box(Modifier.fillMaxWidth().height(1.dp).background(AppColors.cardBorder))
}

@Composable
private fun DetailRow(icon: ImageVector, label: String, value: String, color: Color = AppColors.onSurface, mono: Boolean = false) {
    Row(Modifier.fillMaxWidth().padding(vertical = 7.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, contentDescription = null, tint = AppColors.accent, modifier = Modifier.size(18.dp))
        Spacer(Modifier.width(10.dp))
        Text(label, Modifier.weight(1f), color = AppColors.onSurfaceMuted, fontSize = 14.sp)
        Text(value, color = color, fontWeight = FontWeight.Bold, fontSize = 14.sp, fontFamily = if (mono) monospaceFontFamily() else sansFontFamily(), maxLines = 1, overflow = TextOverflow.Ellipsis)
    }
    Box(Modifier.fillMaxWidth().height(1.dp).background(AppColors.cardBorder))
}

/** A pending confirm dialog spec for the mode-management actions. */
private data class ManageConfirm(val title: String, val body: String, val confirmLabel: String, val action: () -> Unit)

/**
 * Full-screen management page for a single network mode. All three actions operate
 * strictly on [mode] (the catalog tab the gear was opened from): reset the rating
 * (keeping hosts), wipe the mode entirely, or copy another mode's hosts+ratings here.
 */
@Composable
fun CatalogModeManagePage(
    mode: String,
    onBack: () -> Unit,
    onResetStats: () -> Unit,
    onForget: () -> Unit,
    onCopyFrom: (String) -> Unit,
) {
    val t = LocalStrings.current
    var pending by remember { mutableStateOf<ManageConfirm?>(null) }

    pending?.let { c ->
        androidx.compose.material3.AlertDialog(
            onDismissRequest = { pending = null },
            confirmButton = {
                androidx.compose.material3.TextButton({ pending = null; c.action() }) { Text(c.confirmLabel) }
            },
            dismissButton = {
                androidx.compose.material3.TextButton({ pending = null }) { Text(t.cancel) }
            },
            title = { Text(c.title, fontWeight = FontWeight.Bold) },
            text = { Text(c.body, fontSize = 15.sp) },
        )
    }

    Surface(Modifier.fillMaxSize(), color = AppColors.background) {
        Column(Modifier.fillMaxSize()) {
            // Top bar with back button (mirrors CatalogDetailPage).
            Box(Modifier.fillMaxWidth().background(Brush.horizontalGradient(listOf(AppColors.accent, AppColors.accentDark)))) {
                Row(Modifier.fillMaxWidth().height(54.dp).padding(horizontal = 4.dp), verticalAlignment = Alignment.CenterVertically) {
                    androidx.compose.material3.IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, t.back, tint = Color.White)
                    }
                    Text("${t.manageModeTitle}: ${modeLabel(mode)}", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 15.sp, maxLines = 2)
                }
            }

            Column(
                Modifier.fillMaxWidth().weight(1f).verticalScroll(rememberScrollState()).padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                // Every action names the mode it targets so it's unmistakable which
                // catalog section is affected.
                val ml = modeLabel(mode)

                // Reset rating, keep hosts.
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    val label = "${t.manageResetRating} $ml"
                    val hint = t.manageResetHint(ml)
                    Button(
                        onClick = { pending = ManageConfirm(label, hint, t.gotIt) { onResetStats() } },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDDDDDD), contentColor = Color.Black),
                    ) { Text(label) }
                    Text(hint, color = AppColors.onSurfaceMuted, fontSize = 13.sp)
                }

                androidx.compose.material3.HorizontalDivider(thickness = 1.dp, color = Color.Black)

                // Delete everything in this mode (destructive).
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    val label = "${t.manageDeleteAll} $ml"
                    val hint = t.manageDeleteHint(ml)
                    Button(
                        onClick = { pending = ManageConfirm(label, hint, t.delete) { onForget() } },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDDDDDD), contentColor = Color.Black),
                    ) { Text(label) }
                    Text(hint, color = AppColors.onSurfaceMuted, fontSize = 13.sp)
                }

                androidx.compose.material3.HorizontalDivider(thickness = 1.dp, color = Color.Black)

                // Copy hosts + ratings here from another mode.
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(t.manageCopyFrom(ml), color = AppColors.onSurface, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        for (code in CATALOG_MODES) {
                            if (code == mode) continue
                            ModeChip(
                                label = modeLabel(code),
                                selected = false,
                                modifier = Modifier.weight(1f),
                            ) {
                                pending = ManageConfirm(
                                    t.manageCopyFrom(ml),
                                    "${modeLabel(code)} → $ml",
                                    t.gotIt,
                                ) { onCopyFrom(code) }
                            }
                        }
                    }
                }
            }
        }
    }
}
