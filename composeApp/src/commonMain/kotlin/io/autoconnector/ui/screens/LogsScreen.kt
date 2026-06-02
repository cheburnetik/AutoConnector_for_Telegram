package io.autoconnector.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.autoconnector.engine.LogCat
import io.autoconnector.engine.LogLevel
import io.autoconnector.engine.LogLine
import io.autoconnector.i18n.LocalStrings
import io.autoconnector.ui.theme.AppColors
import io.autoconnector.ui.theme.monospaceFontFamily

/** Which Logs sub-tab is selected. */
enum class LogTab { TELEGRAM, SUBS, SCAN }

/**
 * The Logs tab, split into Telegram / Subscriptions / Scan. Telegram lines are
 * grouped into expandable per-connection sessions ("Session N · port P") so you
 * can read the full lifecycle of one Telegram connection in isolation — exactly
 * what's needed to see why Telegram drops a proxy.
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
        LogTab.TELEGRAM -> {
            // Telegram relay lines + general/app lines (cat OTHER) live here.
            val tele = logs.filter { it.cat == LogCat.TELEGRAM || it.cat == LogCat.OTHER }
            if (tele.isEmpty()) {
                item { EmptyHint() }
            } else {
                // logs are newest-first; build groups preserving that order.
                val order = ArrayList<String?>()
                val groups = HashMap<String?, MutableList<LogLine>>()
                for (l in tele) {
                    val k = l.session
                    if (!groups.containsKey(k)) { groups[k] = ArrayList(); order.add(k) }
                    groups[k]!!.add(l)
                }
                for (key in order) {
                    val lines = groups[key] ?: continue
                    if (key == null) {
                        // General relay/app lines — shown inline, newest first.
                        items(lines) { LogText(it) }
                    } else {
                        val open = key in expanded
                        item { SessionHeader(key, lines.size, open) { onToggleSession(key) } }
                        // Inside a session: oldest → newest, so it reads in order.
                        if (open) items(lines.asReversed()) { LogText(it, indent = true) }
                    }
                }
            }
        }
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
        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
        modifier = Modifier
            .weight(1f)
            .background(if (on) AppColors.accent else AppColors.card, androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp),
    )
}

@Composable
private fun SessionHeader(key: String, count: Int, open: Boolean, onClick: () -> Unit) {
    val t = LocalStrings.current
    val hash = key.indexOf('#')
    val port = if (hash > 0) key.substring(0, hash) else "?"
    val id = if (hash >= 0) key.substring(hash + 1) else key
    Row(
        Modifier.fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 2.dp)
            .background(AppColors.card, androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 8.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(if (open) "▾" else "▸", color = AppColors.accent, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Spacer(Modifier.width(6.dp))
        Text(t.logSession(id, port), color = AppColors.onSurface, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Spacer(Modifier.weight(1f))
        Text("$count", color = AppColors.onSurfaceMuted, fontSize = 13.sp)
    }
}

@Composable
private fun LogText(line: LogLine, indent: Boolean = false) {
    Text(
        line.text,
        color = colorFor(line.level),
        fontFamily = monospaceFontFamily(),
        fontSize = 14.sp,
        lineHeight = 18.sp,
        modifier = Modifier.padding(start = if (indent) 24.dp else 12.dp, end = 12.dp),
    )
}

@Composable
private fun EmptyHint() {
    Text(
        LocalStrings.current.logEmpty,
        color = AppColors.onSurfaceMuted,
        fontSize = 14.sp,
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
    )
}

private fun colorFor(level: LogLevel): Color = when (level) {
    LogLevel.OK -> AppColors.green
    LogLevel.FAIL -> AppColors.red
    LogLevel.WARN -> AppColors.amber
    LogLevel.ROUTE -> AppColors.onSurface
    LogLevel.INFO -> AppColors.blue
    LogLevel.MUTED -> AppColors.onSurfaceMuted
}
