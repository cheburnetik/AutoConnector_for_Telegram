package io.autoconnector.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.autoconnector.engine.ConnState
import io.autoconnector.engine.EngineState
import io.autoconnector.engine.ProxyInfo
import io.autoconnector.i18n.LocalStrings
import io.autoconnector.i18n.Strings
import io.autoconnector.i18n.modeLabel
import io.autoconnector.ui.components.Caption
import io.autoconnector.ui.components.Cell
import io.autoconnector.ui.components.HelpDialog
import io.autoconnector.ui.components.LiveBarGraph
import io.autoconnector.ui.components.PulseCircle
import io.autoconnector.ui.components.StatTable
import io.autoconnector.ui.components.cell
import io.autoconnector.ui.components.fmtLatency
import io.autoconnector.ui.components.fmtLatencyPair
import io.autoconnector.ui.components.fmtSpeed
import io.autoconnector.ui.components.fmtSpeedPair
import io.autoconnector.ui.theme.AppColors

@Composable
fun ConnectorContent(s: EngineState, onOpenGuide: () -> Unit, onOpenQuick: () -> Unit) {
    val t = LocalStrings.current
    var showModeHelp by remember { mutableStateOf(false) }
    if (showModeHelp) {
        HelpDialog(title = t.modeWord, body = t.connModeHelp, onDismiss = { showModeHelp = false })
    }
    Column(
        Modifier.fillMaxWidth().padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        // Compact connection indicator: small pulsing circle on the left,
        // localised status label on the right. The sub-line (durations/bytes)
        // comes from the engine and stays as produced. A small "quick switch"
        // button sits on the far right, mirroring the experimental settings.
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            PulseCircle(statusColor(s.connState), 46, pulse = s.connState == ConnState.CONNECTING)
            Spacer(Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                Text(
                    statusLabel(s.connState, t),
                    color = statusColor(s.connState),
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    maxLines = 1,
                )
                if (s.statusSub.isNotEmpty()) {
                    Text(s.statusSub, color = AppColors.onSurfaceMuted, fontSize = 14.sp, maxLines = 1)
                }
                // Line 1: detected network card (grey).
                if (s.netLabel.isNotEmpty()) {
                    Text(
                        t.netNow(s.netLabel),
                        color = AppColors.onSurfaceMuted, fontSize = 13.sp, fontWeight = FontWeight.Bold, maxLines = 1,
                    )
                }
                // Line 2: the mode actually in effect (accent) + a "(?)" explainer.
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        "${t.modeWord}: ${modeLabel(s.activeMode)}",
                        color = AppColors.accent, fontSize = 13.sp, fontWeight = FontWeight.Bold, maxLines = 1,
                    )
                    Text(
                        " (?)",
                        color = AppColors.accent, fontSize = 13.sp, fontWeight = FontWeight.Bold, maxLines = 1,
                        modifier = Modifier.clickableText { showModeHelp = true },
                    )
                }
                // Line 3: only when the VPN-bypass is actually engaging direct mode.
                if (s.directViaVpn) {
                    Text(
                        t.directViaVpnLine,
                        color = AppColors.amber, fontSize = 13.sp, fontWeight = FontWeight.Bold, maxLines = 2,
                    )
                }
            }
            Spacer(Modifier.width(8.dp))
            QuickSwitchButton(onOpenQuick)
        }

        // Metric rows: left label + the two current readings, then the
        // per-second (2 s buckets) and per-minute graphs.
        Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
            val sec = s.nowSec
            val secTick = sec / 2
            // Column captions sit tight above the first graph row, aligned to the
            // two graph columns (the left label column is just a spacer).
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                Spacer(Modifier.weight(0.30f))
                GraphHeader(t.perSecond, Modifier.weight(0.35f))
                GraphHeader(t.perMinute, Modifier.weight(0.35f))
            }
            // Speed: 2 s average rate (B/s); minute series is the per-minute rate.
            val spdSec = ds2(s.trafficSec, sec, avg = true)
            val spdMin = LongArray(s.trafficMin.size) { s.trafficMin[it] / 60 }
            GraphRow(
                t.graphSpeed, ::fmtSpeedPair,
                spdSec, spdMin, secTick, s.nowMin,
                AppColors.green, minScale = 1024, logBase = 1.0, ::fmtSpeed,
            )
            // Ping: latency averaged per 2 s bucket / per minute.
            val pingSec = ds2(s.latencySec, sec, avg = true)
            GraphRow(
                t.graphLatency, ::fmtLatencyPair,
                pingSec, s.latencyMin, secTick, s.nowMin,
                AppColors.accent, minScale = 50, logBase = 5.0, ::fmtLatency,
            )
            // Connects: one row per port — title is the port itself, counts in «шт».
            val pA = if (s.connectsPortA != 0) s.connectsPortA else 55001
            val pB = if (s.connectsPortB != 0) s.connectsPortB else 55002
            val caSec = ds2(s.connectsASec, sec, avg = false)
            val cbSec = ds2(s.connectsBSec, sec, avg = false)
            GraphRow(
                "${t.port} $pA", { a, b -> "$a · ${t.pcs(b.toInt())}" },
                caSec, s.connectsAMin, secTick, s.nowMin,
                AppColors.amber, minScale = 4, logBase = 1.0, { t.pcs(it.toInt()) },
            )
            GraphRow(
                "${t.port} $pB", { a, b -> "$a · ${t.pcs(b.toInt())}" },
                cbSec, s.connectsBMin, secTick, s.nowMin,
                AppColors.amber, minScale = 4, logBase = 1.0, { t.pcs(it.toInt()) },
            )
        }

        Text(t.currentProxy, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        CurrentProxyTable(s.currentProxy, t)

        // Live connection counts + the active network profile. Rendered as a
        // manual wrapping table (not StatTable) so long left-column phrases like
        // «Прямой коннект к Telegram при VPN» wrap instead of being truncated.
        Text(t.connStatsTitle, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        ConnNowTable(
            rows = listOf(
                "${t.connOnPort} ${s.portA}" to t.pcs(s.connLiveA),
                "${t.connOnPort} ${s.portB}" to t.pcs(s.connLiveB),
                t.outgoingConns to t.pcs(s.connLiveOut),
                t.activeModeLabel to modeLabel(s.activeMode),
                t.modeChoice to (if (s.scanModeManual) t.manualChoice else t.autoChoice),
                t.directOnVpn to when {
                    !s.directOnVpnEnabled -> t.directStateOff
                    s.directViaVpn -> t.directStateActive
                    else -> t.directStateIdle
                },
            ),
        )

        ActiveSocketsTable(s, t)

        // Experimental pre-warm pool — the very bottom table.
        PrewarmTable(s, t)

        Spacer(Modifier.height(8.dp))
    }
}

/**
 * Bottom-most table on the Connector tab: standby ("pre-warm") sockets. Each row
 * is a host being kept warm — how long the socket has lived, whether Telegram is
 * already using it (vs an idle/new standby), and the traffic carried once in use.
 * Shown only when the experimental pre-warm feature is enabled.
 */
@Composable
internal fun PrewarmTable(s: EngineState, t: Strings) {
    if (!s.prewarmEnabled) return
    var showPrewarmHelp by remember { mutableStateOf(false) }
    if (showPrewarmHelp) {
        HelpDialog(title = t.prewarmTitle, body = t.prewarmTableHelp, onDismiss = { showPrewarmHelp = false })
    }
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(t.prewarmTableTitle(s.prewarmHoldSecs), Modifier.weight(1f), fontWeight = FontWeight.Bold, fontSize = 14.sp)
        IconButton(onClick = { showPrewarmHelp = true }, modifier = Modifier.size(26.dp)) {
            Icon(Icons.Filled.Info, t.prewarmTitle, tint = AppColors.accent, modifier = Modifier.size(20.dp))
        }
    }
    if (s.prewarmRows.isEmpty()) {
        Caption(t.prewarmNoneWarming)
    } else {
        val rows = ArrayList<List<Cell>>()
        rows.add(listOf(
            cell(t.colHost, AppColors.onSurfaceMuted, bold = true),
            cell(t.prewarmColAge, AppColors.onSurfaceMuted, bold = true),
            cell(t.prewarmColUse, AppColors.onSurfaceMuted, bold = true),
            cell("↓↑", AppColors.onSurfaceMuted, bold = true),
        ))
        for (r in s.prewarmRows) {
            rows.add(listOf(
                cell(r.host, AppColors.amber, bold = true, mono = true),
                cell("${r.ageSecs}${t.secShort}", mono = true),
                cell(if (r.inUse) t.prewarmInUse else t.prewarmNew, if (r.inUse) AppColors.green else AppColors.onSurfaceMuted),
                cell(r.traffic, mono = true),
            ))
        }
        StatTable(rows = rows, weights = listOf(2.2f, 0.9f, 1f, 1.3f), fontSize = 13, bg = Color.White, border = Color(0xFF999999))
    }
}

/**
 * Small chip on the status row that opens the full-screen quick-switch page
 * (proxying shaping / connect engine / anti-DPI). Just the tune icon to keep
 * it unobtrusive next to the connection status.
 */
@Composable
private fun QuickSwitchButton(onClick: () -> Unit) {
    val t = LocalStrings.current
    Box(
        Modifier
            .clip(RoundedCornerShape(10.dp))
            .border(1.5.dp, AppColors.accent, RoundedCornerShape(10.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 10.dp, vertical = 8.dp),
    ) {
        Icon(
            Icons.Filled.Tune,
            t.quickSwitchTitle,
            tint = AppColors.accent,
            modifier = Modifier.size(20.dp),
        )
    }
}

/**
 * One-line note on the Connector tab whenever the relay is in direct ("bypass")
 * mode — proxies skipped because a VPN is on, or turned off outright. Anti-DPI
 * state (first-packet fragmentation) is folded in as a short suffix.
 */
@Composable
internal fun ActiveSocketsTable(s: EngineState, t: Strings) {
    Text(t.activeSockets(s.sessions.size), fontWeight = FontWeight.Bold, fontSize = 14.sp)
    if (s.sessions.isEmpty()) {
        Caption(t.noConnections)
    } else {
        val rows = ArrayList<List<Cell>>()
        rows.add(listOf(cell(t.colHost, AppColors.onSurfaceMuted, bold = true), cell(t.colTime, AppColors.onSurfaceMuted, bold = true), cell("↓↑", AppColors.onSurfaceMuted, bold = true)))
        for (c in s.sessions) {
            // Pre-warmed sockets (handed over warm from the pool) are shown bold + orange.
            val pw = c.fromPrewarm
            rows.add(listOf(
                cell(c.host, if (pw) AppColors.amber else if (c.alive) AppColors.green else AppColors.blue, bold = pw, mono = true),
                cell(c.connectedFor, mono = true),
                cell(c.traffic, mono = true),
            ))
        }
        StatTable(rows = rows, weights = listOf(2.2f, 1f, 1f), fontSize = 14, bg = Color.White, border = Color(0xFF999999))
        // Footnote explaining the * marker (only when a warm socket is present).
        if (s.sessions.any { it.fromPrewarm }) Caption(t.prewarmStar)
    }
}

/**
 * Two-column label/value table for the «Соединения сейчас» block. Unlike
 * [StatTable] (single-line, ellipsised cells), the first column here wraps to
 * multiple lines so long phrases stay fully readable. Styled to match StatTable:
 * card background, rounded border, thin row dividers.
 */
@Composable
private fun ConnNowTable(rows: List<Pair<String, String>>) {
    Box(
        Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .border(1.dp, Color(0xFF999999), RoundedCornerShape(10.dp)),
    ) {
        Column {
            rows.forEachIndexed { i, (label, value) ->
                if (i > 0) Box(Modifier.fillMaxWidth().height(1.dp).background(Color(0xFF999999)))
                Row(
                    Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        label,
                        Modifier.weight(1.5f),
                        softWrap = true,
                        fontSize = 14.sp,
                        color = AppColors.onSurfaceMuted,
                    )
                    Text(value, Modifier.weight(1f), fontSize = 14.sp)
                }
            }
        }
    }
}

@Composable
internal fun CurrentProxyTable(p: ProxyInfo?, t: Strings) {
    if (p == null) {
        StatTable(rows = listOf(listOf(cell(t.noActiveProxy, AppColors.onSurfaceMuted))), bg = Color.White, border = Color(0xFF999999))
        return
    }
    val rows = ArrayList<List<Cell>>()
    rows.add(listOf(cell(t.host, AppColors.onSurfaceMuted), cell("${p.host}:${p.port}", mono = true)))
    rows.add(listOf(cell(t.type, AppColors.onSurfaceMuted), cell(p.typeLabel, mono = true)))
    rows.add(listOf(cell(t.obfEngine, AppColors.onSurfaceMuted), cell(p.obfEngine, mono = true)))
    p.tls?.let { rows.add(listOf(cell("FakeTLS / SNI", AppColors.onSurfaceMuted), cell(it, mono = true))) }
    p.secret?.let { rows.add(listOf(cell(t.secret, AppColors.onSurfaceMuted), cell(it, mono = true))) }
    rows.add(listOf(cell(t.antiDpi, AppColors.onSurfaceMuted), cell(p.dpi, mono = true)))
    StatTable(rows = rows, weights = listOf(1f, 2f), bg = Color.White, border = Color(0xFF999999))
}

private fun statusLabel(c: ConnState, t: Strings): String = when (c) {
    ConnState.CONNECTED -> t.statusConnected
    ConnState.CONNECTING -> t.statusConnecting
    ConnState.IDLE_SILENT -> t.statusIdle
    ConnState.OFFLINE -> t.statusOffline
}

private fun statusColor(c: ConnState): Color = when (c) {
    ConnState.CONNECTED -> AppColors.green
    ConnState.CONNECTING -> AppColors.blue
    ConnState.IDLE_SILENT -> AppColors.amber
    ConnState.OFFLINE -> AppColors.gray
}

/**
 * One metric row: left column (title + the CURRENT per-second and per-minute
 * readings, formatted with their units) followed by the per-second and
 * per-minute live graphs. [secTick]/[minTick] are the newest-bucket ids that
 * drive each graph's slide animation.
 */
@Composable
internal fun GraphRow(
    title: String,
    pairFmt: (Long, Long) -> String,
    secValues: LongArray,
    minValues: LongArray,
    secTick: Long,
    minTick: Long,
    color: Color,
    minScale: Long,
    logBase: Double,
    gridFmt: (Long) -> String,
) {
    // Value line is read from the SAME buckets the graph draws — the newest
    // COMPLETED bucket (size − 2), not the still-filling current one (last).
    val sv = secValues.getOrElse(secValues.size - 2) { secValues.lastOrNull() ?: 0L }
    val mv = minValues.getOrElse(minValues.size - 2) { minValues.lastOrNull() ?: 0L }
    val valueLine = pairFmt(sv, mv)
    // Settings toggle: when graphs are off, keep the numeric readings but drop the
    // two animated Canvas charts (no per-frame redraw → less battery).
    val drawGraphs = io.autoconnector.ui.components.LocalDrawGraphs.current
    Row(
        Modifier.fillMaxWidth().height(50.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(Modifier.weight(if (drawGraphs) 0.30f else 1f)) {
            Text(title, fontWeight = FontWeight.Bold, fontSize = 12.sp, color = AppColors.onSurface, maxLines = 1)
            // two current readings «за сек · за минуту» on one line, shared unit.
            Text(valueLine, fontWeight = FontWeight.Bold, fontSize = 11.sp, color = color, maxLines = 1)
        }
        if (drawGraphs) {
            LiveBarGraph(secValues, color, secTick, Modifier.weight(0.35f).fillMaxHeight(), minScale, logBase, gridFmt)
            LiveBarGraph(minValues, color, minTick, Modifier.weight(0.35f).fillMaxHeight(), minScale, logBase, gridFmt)
        }
    }
}

/**
 * Downsamples a 60×1-second series into 30×2-second buckets (newest at the end),
 * aligned to even seconds so the newest bucket stays put for a full 2 s — that
 * is what makes the graph advance strictly once every 2 s. [avg] averages
 * (rates / latency); otherwise the two seconds are summed (volumes / counts).
 * Missing seconds simply contribute 0.
 */
internal fun ds2(arr: LongArray, newestSec: Long, avg: Boolean): LongArray {
    val m = arr.size / 2
    val out = LongArray(m); val cnt = IntArray(m)
    val newestBucket = newestSec / 2
    for (i in arr.indices) {
        val secAt = newestSec - (arr.size - 1 - i)
        if (secAt < 0) continue
        val b = (newestBucket - secAt / 2).toInt()   // 0 = newest 2 s bucket
        if (b in 0 until m) { val idx = m - 1 - b; out[idx] += arr[i]; cnt[idx]++ }
    }
    if (avg) for (k in out.indices) if (cnt[k] > 0) out[k] = out[k] / cnt[k]
    return out
}

@Composable
internal fun GraphHeader(text: String, modifier: Modifier) {
    Text(text, modifier, color = AppColors.onSurfaceMuted, fontSize = 10.sp, textAlign = TextAlign.Center, maxLines = 1)
}

/** Tiny helper so an inline text can act as a link without a full Button. */
private fun Modifier.clickableText(onClick: () -> Unit): Modifier =
    this.clickable(
        interactionSource = MutableInteractionSource(),
        indication = null,
        onClick = onClick,
    )
