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
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material.icons.filled.PushPin
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Send
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.autoconnector.engine.CatalogItem
import io.autoconnector.i18n.LocalStrings
import io.autoconnector.i18n.Strings
import io.autoconnector.ui.components.Caption
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
fun LazyListScope.catalogItems(items: List<CatalogItem>, onClick: (CatalogItem) -> Unit) {
    if (items.isEmpty()) {
        item { Caption(LocalStrings.current.catalogEmpty, Modifier.padding(16.dp)) }
        return
    }
    item { Spacer(Modifier.height(6.dp)) }
    items(items, key = { it.id }) { p ->
        Column(Modifier.padding(horizontal = 12.dp, vertical = 3.dp)) { CatalogTile(p) { onClick(p) } }
    }
    item { Spacer(Modifier.height(6.dp)) }
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
            IconStat(ICON_CHECKED, fmtMins(p.checkedMinsAgo, t), Modifier.weight(1f))
            IconStat(ICON_TG, fmtMins(p.tgConnectMinsAgo, t), Modifier.weight(1f))
            IconStat(ICON_CHECKS, "${p.successes}/${p.successes + p.failures}", Modifier.weight(1.1f))
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

/** Full-screen, scrollable per-host detail with icons (same as the tile) + actions. */
@Composable
fun CatalogDetailPage(
    p: CatalogItem,
    onCopy: () -> Unit,
    onOpen: () -> Unit,
    onMakeRelay: () -> Unit,
    onBack: () -> Unit,
) {
    val t = LocalStrings.current
    Surface(Modifier.fillMaxSize(), color = AppColors.background) {
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
                Modifier.fillMaxWidth().weight(1f).verticalScroll(rememberScrollState()).padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp),
            ) {
                DetailRow(Icons.Filled.CheckCircle, t.statusLabel, if (p.alive) t.live else t.deadW, if (p.alive) AppColors.green else AppColors.red)
                DetailRow(Icons.Filled.Bolt, t.rating, "${p.rating} / 9")
                DetailRow(Icons.Filled.Dns, t.type, p.typeLabel)
                DetailRow(Icons.Filled.Numbers, t.port, "${p.port}")
                DetailRow(Icons.Filled.Speed, t.rttPing, if (p.rttMs >= 0) "${p.rttMs} ${t.unitMs}" else t.dash)
                DetailRow(ICON_CHECKED, t.checkedField, if (p.checkedMinsAgo >= 0) t.agoFmt(fmtMins(p.checkedMinsAgo, t)) else t.dash)
                DetailRow(ICON_CHECKS, t.okOfTotal, "${p.successes} / ${p.successes + p.failures}")
                DetailRow(ICON_TG, t.tgConnectedField, if (p.tgConnectMinsAgo >= 0) t.agoFmt(fmtMins(p.tgConnectMinsAgo, t)) else t.dash)
                DetailRow(Icons.Filled.Send, t.tgSessions, "${p.tgConnections}")
                DetailRow(ICON_TRAFFIC, t.trafficThroughProxy, p.bytesRelayedHuman)
                DetailRow(Icons.Filled.Schedule, t.sessionsTotal, p.sessionTotalHuman)
                DetailRow(Icons.Filled.Bolt, t.relayNow, if (p.live) t.yes else t.no, if (p.live) AppColors.green else AppColors.onSurfaceMuted)
                p.secret?.let { DetailRow(Icons.Filled.Lock, t.secret, if (it.length > 26) it.substring(0, 25) + "…" else it, mono = true) }
                p.tlsDomain?.let { DetailRow(Icons.Filled.Shield, t.tlsDomain, it, mono = true) }
                p.sourceNum?.let { DetailRow(Icons.Filled.Storage, t.sourceSub, "#$it") }
                p.lastErrorShort?.let { DetailRow(Icons.Filled.CheckCircle, t.lastError, it, AppColors.red) }

                Spacer(Modifier.height(16.dp))

                Button(
                    onClick = onCopy,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = AppColors.accent, contentColor = Color.White),
                ) {
                    Icon(Icons.Filled.ContentCopy, null, Modifier.size(18.dp)); Spacer(Modifier.width(8.dp)); Text(t.copyAsLink)
                }
                Spacer(Modifier.height(8.dp))
                OutlinedButton(onClick = onOpen, modifier = Modifier.fillMaxWidth()) {
                    Icon(Icons.AutoMirrored.Filled.OpenInNew, null, Modifier.size(18.dp)); Spacer(Modifier.width(8.dp)); Text(t.openInTelegram)
                }
                Spacer(Modifier.height(8.dp))
                OutlinedButton(onClick = onMakeRelay, modifier = Modifier.fillMaxWidth()) {
                    Icon(Icons.Filled.PushPin, null, Modifier.size(18.dp)); Spacer(Modifier.width(8.dp)); Text(t.makeNextRelay)
                }
                Spacer(Modifier.height(16.dp))
            }
        }
    }
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
