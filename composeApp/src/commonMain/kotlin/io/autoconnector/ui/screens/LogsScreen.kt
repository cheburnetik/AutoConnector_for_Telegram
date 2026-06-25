package io.autoconnector.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.autoconnector.engine.LogCat
import io.autoconnector.engine.LogLevel
import io.autoconnector.engine.LogLine
import io.autoconnector.i18n.LocalStrings
import io.autoconnector.ui.localOffsetMs
import io.autoconnector.ui.theme.AppColors
import io.autoconnector.ui.theme.monospaceFontFamily

/** Which Logs sub-tab is selected. */
enum class LogTab { TELEGRAM, SUBS, SCAN }

/** A grouped Telegram connection. */
private class Sess(val key: String, val lines: List<LogLine>) {
    val port: String get() = key.substringBefore('#', "?")
    val id: String get() = key.substringAfter('#', key)
    // lines are newest-first.
    val failed: Boolean get() = lines.any { it.level == LogLevel.FAIL }
    val level: LogLevel get() = when {
        failed -> LogLevel.FAIL
        lines.any { it.text.trimStart().startsWith("→") || it.text.contains("закрыта") } -> LogLevel.OK
        else -> LogLevel.INFO
    }
    /** Most informative single line: the error, else the chosen upstream, else
     *  the latest line. */
    fun summary(): String =
        (lines.firstOrNull { it.level == LogLevel.FAIL }
            ?: lines.firstOrNull { it.text.trimStart().startsWith("→") }
            ?: lines.lastOrNull())?.text?.trim() ?: ""
}

/**
 * Logs tab — Telegram / Subscriptions / Scan. Telegram opens many short
 * connections at once, so each session is shown as a single compact, status-
 * coloured row (id · port + a one-line summary). Tap to expand the full per-
 * session log. Every rendered line is prefixed with its HH:MM:SS timestamp.
 */
fun LazyListScope.logsItems(
    logs: List<LogLine>,
    logTab: LogTab,
    onLogTab: (LogTab) -> Unit,
    expanded: Set<String>,
    onToggleSession: (String) -> Unit,
) {
    item { LogSubTabs(logTab, onLogTab) }

    when (logTab) {
        LogTab.SUBS -> flat(logs.filter { it.cat == LogCat.SUBS })
        LogTab.SCAN -> flat(logs.filter { it.cat == LogCat.SCAN })
        LogTab.TELEGRAM -> telegram(logs, expanded, onToggleSession)
    }
}

private fun LazyListScope.telegram(
    logs: List<LogLine>,
    expanded: Set<String>,
    onToggleSession: (String) -> Unit,
) {
    val tele = logs.filter { it.cat == LogCat.TELEGRAM || it.cat == LogCat.OTHER }
    // Build session groups (newest first) + a "general" (null-session) bucket.
    val order = ArrayList<String?>()
    val groups = HashMap<String?, MutableList<LogLine>>()
    for (l in tele) {
        val k = l.session
        if (!groups.containsKey(k)) { groups[k] = ArrayList(); order.add(k) }
        groups[k]!!.add(l)
    }
    val general = groups[null].orEmpty()
    val sessions = order.filterNotNull().map { Sess(it, groups[it]!!) }
    val failed = sessions.count { it.failed }

    if (tele.isEmpty()) { item { EmptyHint() }; return }

    item { SessionsBar(sessions.size, failed) }

    // General relay/app lines (port open/close, errors) — always on top.
    if (general.isNotEmpty()) items(general) { LogText(it) }

    // All sessions, newest first. Tap a row to expand its full per-line log.
    for (s in sessions) {
        val open = s.key in expanded
        item { SessionRow(s, open) { onToggleSession(s.key) } }
        if (open) items(s.lines.asReversed()) { LogText(it, indent = true) }
    }
}

private fun LazyListScope.flat(lines: List<LogLine>) {
    if (lines.isEmpty()) item { EmptyHint() } else items(lines) { LogText(it) }
}

@Composable
private fun LogSubTabs(sel: LogTab, onSel: (LogTab) -> Unit) {
    val t = LocalStrings.current
    Row(
        Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        SubTab(t.logTabTelegram, sel == LogTab.TELEGRAM) { onSel(LogTab.TELEGRAM) }
        SubTab(t.logTabSubs, sel == LogTab.SUBS) { onSel(LogTab.SUBS) }
        SubTab(t.logTabScan, sel == LogTab.SCAN) { onSel(LogTab.SCAN) }
    }
}

@Composable
private fun androidx.compose.foundation.layout.RowScope.SubTab(label: String, on: Boolean, onClick: () -> Unit) {
    Text(
        label,
        color = if (on) Color.White else AppColors.onSurfaceMuted,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .weight(1f)
            .background(if (on) AppColors.accent else AppColors.card, RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp),
    )
}

/** Header: total session count + a muted failed-session count (no filter). */
@Composable
private fun SessionsBar(total: Int, failed: Int) {
    val t = LocalStrings.current
    Row(
        Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text("${t.logSessions}: $total", color = AppColors.onSurfaceMuted, fontSize = 13.sp)
        if (failed > 0) {
            Spacer(Modifier.weight(1f))
            Text(
                "${t.failed}: $failed",
                color = AppColors.red,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
            )
        }
    }
}

/** One collapsed session: status bar + id·port + one-line summary. */
@Composable
private fun SessionRow(s: Sess, open: Boolean, onClick: () -> Unit) {
    val t = LocalStrings.current
    val c = colorFor(s.level)
    Row(
        Modifier.fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 3.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(Modifier.width(3.dp).height(16.dp).background(c, RoundedCornerShape(2.dp)))
        Spacer(Modifier.width(6.dp))
        Text(if (open) "▾" else "▸", color = AppColors.onSurfaceMuted, fontSize = 12.sp)
        Spacer(Modifier.width(4.dp))
        Text(t.logSession(s.id, s.port), color = c, fontWeight = FontWeight.Bold, fontSize = 13.sp)
        Spacer(Modifier.width(8.dp))
        Text(
            s.summary(),
            color = AppColors.onSurfaceMuted,
            fontFamily = monospaceFontFamily(),
            fontSize = 12.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f),
        )
    }
}

@Composable
private fun LogText(line: LogLine, indent: Boolean = false) {
    val ts = hms(line.ts)
    val text = buildAnnotatedString {
        if (ts.isNotEmpty()) {
            // Timestamp a touch smaller than the message and in a narrower
            // proportional sans (vs. the wide monospace), tightened a touch.
            withStyle(SpanStyle(
                color = AppColors.onSurfaceMuted,
                fontSize = 12.3.sp,
                fontFamily = FontFamily.SansSerif,
                letterSpacing = (-0.3).sp,
            )) { append(ts) }
            append(" ")
        }
        withStyle(SpanStyle(color = colorFor(line.level))) { append(line.text) }
    }
    Text(
        text,
        fontFamily = monospaceFontFamily(),
        fontSize = 14.sp,
        lineHeight = 18.sp,
        modifier = Modifier.padding(start = if (indent) 22.dp else 12.dp, end = 12.dp),
    )
}

/** Format an epoch-ms timestamp as LOCAL-of-day "HH:MM:SS" (empty when unset).
 *  Uses the computer's/device's timezone offset (incl. DST) via the platform
 *  [localOffsetMs] expect/actual, so the time matches the local clock, not UTC. */
private fun hms(ts: Long): String {
    if (ts <= 0L) return ""
    val local = ts + localOffsetMs(ts)
    val s = ((local / 1000) % 86400 + 86400) % 86400
    fun p(n: Long): String = if (n < 10) "0$n" else "$n"
    return "${p(s / 3600)}:${p((s % 3600) / 60)}:${p(s % 60)}"
}

@Composable
private fun EmptyHint(text: String = LocalStrings.current.logEmpty) {
    Text(text, color = AppColors.onSurfaceMuted, fontSize = 14.sp,
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp))
}

private fun colorFor(level: LogLevel): Color = when (level) {
    LogLevel.OK -> AppColors.green
    LogLevel.FAIL -> AppColors.red
    LogLevel.WARN -> AppColors.amber
    LogLevel.ROUTE -> AppColors.onSurface
    LogLevel.INFO -> AppColors.blue
    LogLevel.MUTED -> AppColors.onSurfaceMuted
}
