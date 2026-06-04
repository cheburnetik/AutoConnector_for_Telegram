package io.autoconnector.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.autoconnector.engine.ConnState
import io.autoconnector.engine.EngineState
import io.autoconnector.engine.ProxyInfo
import io.autoconnector.i18n.LocalStrings
import io.autoconnector.i18n.Strings
import io.autoconnector.ui.components.Caption
import io.autoconnector.ui.components.Cell
import io.autoconnector.ui.components.PulseCircle
import io.autoconnector.ui.components.StatTable
import io.autoconnector.ui.components.TrafficSparkline
import io.autoconnector.ui.components.cell
import io.autoconnector.ui.theme.AppColors

@Composable
fun ConnectorContent(s: EngineState, onOpenGuide: () -> Unit, onOpenQuick: () -> Unit) {
    val t = LocalStrings.current
    Column(
        Modifier.fillMaxWidth().padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        // Compact connection indicator: small pulsing circle on the left,
        // localised status label on the right. The sub-line (durations/bytes)
        // comes from the engine and stays as produced. A small "quick switch"
        // button sits on the far right, mirroring the experimental settings.
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            PulseCircle(statusColor(s.connState), 46)
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
            }
            Spacer(Modifier.width(8.dp))
            QuickSwitchButton(onOpenQuick)
        }

        if (s.directMode) {
            DirectModeBanner(s, t)
        }

        if (s.setupNeeded && s.proxyEnabled) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(t.nobodyConnected, color = AppColors.onSurfaceMuted, fontSize = 14.sp)
                Text(
                    t.howToSetupArrow,
                    color = AppColors.accent,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    modifier = Modifier.clickableText(onOpenGuide),
                )
            }
        }

        StatTable(
            rows = listOf(
                listOf(cell(t.connections, AppColors.onSurfaceMuted), cell(t.pcs(s.connCount), bold = true), cell(fmtSec(s.connSeconds, t))),
                listOf(cell(t.sockets, AppColors.onSurfaceMuted), cell(t.tgToConnector(s.socketsTgToConnector)), cell(t.connectorToProxy(s.socketsConnectorToProxy))),
                listOf(cell(t.speed, AppColors.onSurfaceMuted), cell(s.speedDown, AppColors.blue, bold = true), cell(s.speedUp, AppColors.green, bold = true)),
                listOf(cell(t.traffic, AppColors.onSurfaceMuted), cell(s.totalDown, AppColors.blue), cell(s.totalUp, AppColors.green)),
                listOf(cell(t.latency, AppColors.onSurfaceMuted), cell(s.latency, bold = true), cell("")),
            ),
            weights = listOf(1.1f, 1f, 1f),
        )

        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                TrafficSparkline(s.trafficSec, AppColors.green, Modifier.weight(1f).height(44.dp))
                TrafficSparkline(s.trafficMin, AppColors.green, Modifier.weight(1f).height(44.dp))
            }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Caption(t.trafficSec, Modifier.weight(1f))
                Caption(t.trafficMin, Modifier.weight(1f))
            }
        }

        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                TrafficSparkline(s.latencySec, AppColors.gray, Modifier.weight(1f).height(36.dp))
                TrafficSparkline(s.latencyMin, AppColors.gray, Modifier.weight(1f).height(36.dp))
            }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Caption(t.latencySec, Modifier.weight(1f))
                Caption(t.latencyMin, Modifier.weight(1f))
            }
        }

        Text(t.currentProxy, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        CurrentProxyTable(s.currentProxy, t)

        Text(t.activeSockets(s.sessions.size), fontWeight = FontWeight.Bold, fontSize = 14.sp)
        if (s.sessions.isEmpty()) {
            Caption(t.noConnections)
        } else {
            val rows = ArrayList<List<Cell>>()
            rows.add(listOf(cell(t.colHost, AppColors.onSurfaceMuted, bold = true), cell(t.colTime, AppColors.onSurfaceMuted, bold = true), cell("↓↑", AppColors.onSurfaceMuted, bold = true)))
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
private fun DirectModeBanner(s: EngineState, t: Strings) {
    val label = (if (s.directViaVpn) t.directModeViaVpn else t.directModeOff) +
        (if (s.directAntiDpi) t.directDpiSuffix else "")
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text("🔌", fontSize = 13.sp)
        Spacer(Modifier.width(6.dp))
        Text(label, color = AppColors.amber, fontWeight = FontWeight.Bold, fontSize = 13.sp, maxLines = 1)
    }
}

@Composable
private fun CurrentProxyTable(p: ProxyInfo?, t: Strings) {
    if (p == null) {
        StatTable(rows = listOf(listOf(cell(t.noActiveProxy, AppColors.onSurfaceMuted))))
        return
    }
    val rows = ArrayList<List<Cell>>()
    rows.add(listOf(cell(t.host, AppColors.onSurfaceMuted), cell("${p.host}:${p.port}", mono = true)))
    rows.add(listOf(cell(t.type, AppColors.onSurfaceMuted), cell(p.typeLabel, mono = true)))
    p.tls?.let { rows.add(listOf(cell("FakeTLS / SNI", AppColors.onSurfaceMuted), cell(it, mono = true))) }
    p.secret?.let { rows.add(listOf(cell(t.secret, AppColors.onSurfaceMuted), cell(it, mono = true))) }
    rows.add(listOf(cell(t.antiDpi, AppColors.onSurfaceMuted), cell(p.dpi, mono = true)))
    StatTable(rows = rows, weights = listOf(1f, 2f))
}

private fun fmtSec(sec: Long, t: Strings): String = when {
    sec <= 0 -> t.dash
    sec < 60 -> "$sec ${t.unitSec}"
    sec < 3600 -> "${sec / 60} ${t.unitMin} ${sec % 60} ${t.unitSec}"
    else -> "${sec / 3600} ${t.unitHour} ${(sec % 3600) / 60} ${t.unitMin}"
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

/** Tiny helper so an inline text can act as a link without a full Button. */
private fun Modifier.clickableText(onClick: () -> Unit): Modifier =
    this.clickable(
        interactionSource = MutableInteractionSource(),
        indication = null,
        onClick = onClick,
    )
