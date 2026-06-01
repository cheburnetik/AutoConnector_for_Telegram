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
import io.autoconnector.ui.components.Caption
import io.autoconnector.ui.components.RatingBars
import io.autoconnector.ui.components.StatusDot
import io.autoconnector.ui.theme.AppColors

// Icon meaning is shared between the tile and the detail page so the icons on a
// tile are self-explanatory once the user opens a host.
private val ICON_CHECKED = Icons.Filled.Schedule   // когда последний раз проверен
private val ICON_TG = Icons.Filled.Send            // когда Telegram подключался
private val ICON_CHECKS = Icons.Filled.DoneAll      // успешно / всего проверок
private val ICON_TRAFFIC = Icons.Filled.SwapVert    // трафик через прокси

/** Catalog tiles (2 rows each), sorted by rating, emitted into the page LazyColumn. */
fun LazyListScope.catalogItems(items: List<CatalogItem>, onClick: (CatalogItem) -> Unit) {
    if (items.isEmpty()) {
        item { Caption("Каталог пуст — идёт первичный сбор прокси…", Modifier.padding(16.dp)) }
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
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(Modifier.width(8.dp))
            if (p.alive) Text("✓ жив", color = AppColors.green, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            else Text("✗ мёртв", color = AppColors.red, fontWeight = FontWeight.Bold, fontSize = 14.sp)
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
            IconStat(ICON_CHECKED, fmtMins(p.checkedMinsAgo), Modifier.weight(1f))
            IconStat(ICON_TG, fmtMins(p.tgConnectMinsAgo), Modifier.weight(1f))
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

private fun fmtMins(m: Long): String = when {
    m < 0 -> "—"
    m < 60 -> "${m}м"
    m < 1440 -> "${m / 60}ч"
    else -> "${m / 1440}д"
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
    Surface(Modifier.fillMaxSize(), color = AppColors.background) {
        Column(Modifier.fillMaxSize()) {
            // Top bar with back button.
            Box(Modifier.fillMaxWidth().background(Brush.horizontalGradient(listOf(AppColors.accent, AppColors.accentDark)))) {
                Row(Modifier.fillMaxWidth().height(54.dp).padding(horizontal = 4.dp), verticalAlignment = Alignment.CenterVertically) {
                    androidx.compose.material3.IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Назад", tint = Color.White)
                    }
                    Text(p.host, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 15.sp, fontFamily = FontFamily.Monospace, maxLines = 2)
                }
            }

            Column(
                Modifier.fillMaxWidth().weight(1f).verticalScroll(rememberScrollState()).padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp),
            ) {
                DetailRow(Icons.Filled.CheckCircle, "Статус", if (p.alive) "жив" else "мёртв", if (p.alive) AppColors.green else AppColors.red)
                DetailRow(Icons.Filled.Bolt, "Рейтинг", "${p.rating} / 9")
                DetailRow(Icons.Filled.Dns, "Тип", p.typeLabel)
                DetailRow(Icons.Filled.Numbers, "Порт", "${p.port}")
                DetailRow(Icons.Filled.Speed, "RTT (пинг)", if (p.rttMs >= 0) "${p.rttMs} мс" else "—")
                DetailRow(ICON_CHECKED, "Проверен", if (p.checkedMinsAgo >= 0) "${fmtMins(p.checkedMinsAgo)} назад" else "—")
                DetailRow(ICON_CHECKS, "Успешно / всего проверок", "${p.successes} / ${p.successes + p.failures}")
                DetailRow(ICON_TG, "Telegram подключался", if (p.tgConnectMinsAgo >= 0) "${fmtMins(p.tgConnectMinsAgo)} назад" else "—")
                DetailRow(Icons.Filled.Send, "Сессий Telegram", "${p.tgConnections}")
                DetailRow(ICON_TRAFFIC, "Трафик через прокси", p.bytesRelayedHuman)
                DetailRow(Icons.Filled.Schedule, "Суммарно сессий", p.sessionTotalHuman)
                DetailRow(Icons.Filled.Bolt, "Релей сейчас", if (p.live) "да" else "нет", if (p.live) AppColors.green else AppColors.onSurfaceMuted)
                p.secret?.let { DetailRow(Icons.Filled.Lock, "Секрет", if (it.length > 26) it.substring(0, 25) + "…" else it, mono = true) }
                p.tlsDomain?.let { DetailRow(Icons.Filled.Shield, "TLS-домен (SNI)", it, mono = true) }
                p.sourceNum?.let { DetailRow(Icons.Filled.Storage, "Источник (подписка)", "#$it") }
                p.lastErrorShort?.let { DetailRow(Icons.Filled.CheckCircle, "Последняя ошибка", it, AppColors.red) }

                Spacer(Modifier.height(16.dp))

                Button(
                    onClick = onCopy,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = AppColors.accent, contentColor = Color.White),
                ) {
                    Icon(Icons.Filled.ContentCopy, null, Modifier.size(18.dp)); Spacer(Modifier.width(8.dp)); Text("Скопировать как ссылку")
                }
                Spacer(Modifier.height(8.dp))
                OutlinedButton(onClick = onOpen, modifier = Modifier.fillMaxWidth()) {
                    Icon(Icons.AutoMirrored.Filled.OpenInNew, null, Modifier.size(18.dp)); Spacer(Modifier.width(8.dp)); Text("Открыть хост в Telegram")
                }
                Spacer(Modifier.height(8.dp))
                OutlinedButton(onClick = onMakeRelay, modifier = Modifier.fillMaxWidth()) {
                    Icon(Icons.Filled.PushPin, null, Modifier.size(18.dp)); Spacer(Modifier.width(8.dp)); Text("Сделать следующим релеем")
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
        Text(value, color = color, fontWeight = FontWeight.Bold, fontSize = 14.sp, fontFamily = if (mono) FontFamily.Monospace else FontFamily.Default, maxLines = 1, overflow = TextOverflow.Ellipsis)
    }
    Box(Modifier.fillMaxWidth().height(1.dp).background(AppColors.cardBorder))
}
