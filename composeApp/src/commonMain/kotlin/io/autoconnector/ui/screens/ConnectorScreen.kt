package io.autoconnector.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.autoconnector.engine.ConnState
import io.autoconnector.engine.EngineState
import io.autoconnector.engine.ProxyInfo
import io.autoconnector.ui.components.Caption
import io.autoconnector.ui.components.Cell
import io.autoconnector.ui.components.PulseCircle
import io.autoconnector.ui.components.StatTable
import io.autoconnector.ui.components.TrafficSparkline
import io.autoconnector.ui.components.cell
import io.autoconnector.ui.theme.AppColors

@Composable
fun ConnectorContent(s: EngineState, onOpenGuide: () -> Unit) {
    Column(
        Modifier.fillMaxWidth().padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        // Compact connection indicator: small pulsing circle on the left,
        // status text (max 2 lines) on the right.
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            PulseCircle(statusColor(s.connState), 46)
            Spacer(Modifier.width(12.dp))
            Column {
                Text(
                    s.statusText,
                    color = statusColor(s.connState),
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    maxLines = 1,
                )
                if (s.statusSub.isNotEmpty()) {
                    Text(s.statusSub, color = AppColors.onSurfaceMuted, fontSize = 14.sp, maxLines = 1)
                }
            }
        }

        if (s.setupNeeded && s.proxyEnabled) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Никто не подключился к Коннектору. ", color = AppColors.onSurfaceMuted, fontSize = 14.sp)
                Text(
                    "Как настроить →",
                    color = AppColors.accent,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    modifier = Modifier.clickableText(onOpenGuide),
                )
            }
        }

        // Live metrics table (replaces the old grey cards).
        StatTable(
            rows = listOf(
                listOf(cell("Подключений", AppColors.onSurfaceMuted), cell("${s.connCount} шт", bold = true), cell(fmtSec(s.connSeconds))),
                listOf(cell("Сокеты", AppColors.onSurfaceMuted), cell("TG→ ${s.socketsTgToConnector}"), cell("прокси ${s.socketsConnectorToProxy}")),
                listOf(cell("Скорость", AppColors.onSurfaceMuted), cell(s.speedDown, AppColors.blue, bold = true), cell(s.speedUp, AppColors.green, bold = true)),
                listOf(cell("Трафик", AppColors.onSurfaceMuted), cell(s.totalDown, AppColors.blue), cell(s.totalUp, AppColors.green)),
                listOf(cell("Латенси", AppColors.onSurfaceMuted), cell(s.latency, bold = true), cell("")),
            ),
            weights = listOf(1.1f, 1f, 1f),
        )

        // Traffic sparklines 60s | 60m — caption sits right under the graph.
        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                TrafficSparkline(s.trafficSec, AppColors.green, Modifier.weight(1f).height(44.dp))
                TrafficSparkline(s.trafficMin, AppColors.green, Modifier.weight(1f).height(44.dp))
            }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Caption("трафик · 60 секунд", Modifier.weight(1f))
                Caption("трафик · 60 минут", Modifier.weight(1f))
            }
        }

        // Latency sparklines.
        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                TrafficSparkline(s.latencySec, AppColors.gray, Modifier.weight(1f).height(36.dp))
                TrafficSparkline(s.latencyMin, AppColors.gray, Modifier.weight(1f).height(36.dp))
            }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Caption("латенси · 60 секунд", Modifier.weight(1f))
                Caption("латенси · 60 минут", Modifier.weight(1f))
            }
        }

        // Current upstream proxy.
        Text("Текущий прокси", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        CurrentProxyTable(s.currentProxy)

        // Active Telegram sockets.
        Text("Активные сокеты Telegram: ${s.sessions.size}", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        if (s.sessions.isEmpty()) {
            Caption("нет активных соединений")
        } else {
            val rows = ArrayList<List<Cell>>()
            rows.add(listOf(cell("Хост", AppColors.onSurfaceMuted, bold = true), cell("Время", AppColors.onSurfaceMuted, bold = true), cell("↓↑", AppColors.onSurfaceMuted, bold = true)))
            for (c in s.sessions) {
                rows.add(listOf(
                    cell(c.host, if (c.alive) AppColors.green else AppColors.blue, mono = true),
                    cell(c.connectedFor, mono = true),
                    cell(c.traffic, mono = true),
                ))
            }
            StatTable(rows = rows, weights = listOf(2.2f, 1f, 1f), fontSize = 14)
        }
        Spacer(Modifier.height(8.dp))
    }
}

@Composable
private fun CurrentProxyTable(p: ProxyInfo?) {
    if (p == null) {
        StatTable(rows = listOf(listOf(cell("нет активного прокси (Telegram не подключён)", AppColors.onSurfaceMuted))))
        return
    }
    val rows = ArrayList<List<Cell>>()
    rows.add(listOf(cell("Хост", AppColors.onSurfaceMuted), cell("${p.host}:${p.port}", mono = true)))
    rows.add(listOf(cell("Тип", AppColors.onSurfaceMuted), cell(p.typeLabel, mono = true)))
    p.tls?.let { rows.add(listOf(cell("FakeTLS / SNI", AppColors.onSurfaceMuted), cell(it, mono = true))) }
    p.secret?.let { rows.add(listOf(cell("Секрет", AppColors.onSurfaceMuted), cell(it, mono = true))) }
    rows.add(listOf(cell("Анти-DPI", AppColors.onSurfaceMuted), cell(p.dpi, mono = true)))
    StatTable(rows = rows, weights = listOf(1f, 2f))
}

private fun fmtSec(sec: Long): String = when {
    sec <= 0 -> "—"
    sec < 60 -> "$sec сек"
    sec < 3600 -> "${sec / 60} мин ${sec % 60} сек"
    else -> "${sec / 3600} ч ${(sec % 3600) / 60} мин"
}

private fun statusColor(c: ConnState): Color = when (c) {
    ConnState.CONNECTED -> AppColors.green
    ConnState.CONNECTING -> AppColors.blue
    ConnState.IDLE_SILENT -> AppColors.amber
    ConnState.OFFLINE -> AppColors.gray
}

/** Tiny helper so an inline text can act as a link without a full Button. */
private fun Modifier.clickableText(onClick: () -> Unit): Modifier =
    this.clickable(
        interactionSource = MutableInteractionSource(),
        indication = null,
        onClick = onClick,
    )
