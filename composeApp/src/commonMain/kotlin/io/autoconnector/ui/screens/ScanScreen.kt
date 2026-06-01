package io.autoconnector.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.autoconnector.engine.EngineState
import io.autoconnector.i18n.LocalStrings
import io.autoconnector.ui.components.Caption
import io.autoconnector.ui.components.CheckRateSparkline
import io.autoconnector.ui.components.StatTable
import io.autoconnector.ui.components.cell
import io.autoconnector.ui.theme.AppColors

@Composable
fun ScanContent(s: EngineState) {
    val t = LocalStrings.current
    val checkedMin = s.checksOk60s + s.checksFail60s
    val checkedHour = s.checksOk60m + s.checksFail60m

    Column(
        Modifier.fillMaxWidth().padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        if (!s.scanEnabled) {
            StatTable(rows = listOf(listOf(cell(t.scanOff, AppColors.onSurfaceMuted))))
        }

        // Graph moved to the top of the tab.
        Text(t.checksMtproto, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            CheckRateSparkline(s.checkOkSec, s.checkFailSec, Modifier.weight(1f).height(48.dp))
            CheckRateSparkline(s.checkOkMin, s.checkFailMin, Modifier.weight(1f).height(48.dp))
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Caption(t.sec60, Modifier.weight(1f))
            Caption(t.min60, Modifier.weight(1f))
        }

        // Pool — labels in the header, numbers only in cells.
        Text(t.proxiesInBase, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        StatTable(
            rows = listOf(
                listOf(cell(t.total, AppColors.onSurfaceMuted), cell(t.alive, AppColors.onSurfaceMuted), cell(t.dead, AppColors.onSurfaceMuted)),
                listOf(cell("${s.totalCount}", bold = true), cell("${s.aliveCount}", AppColors.green, bold = true), cell("${s.deadCount}", AppColors.gray, bold = true)),
            ),
            fontSize = 14,
        )

        // Telegram connections.
        Text(t.tgConnectedTitle, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        StatTable(
            rows = listOf(
                listOf(cell(t.total, AppColors.onSurfaceMuted), cell(t.successful, AppColors.onSurfaceMuted)),
                listOf(cell("${s.tgSessAll}", bold = true), cell("${s.tgSessOk}", AppColors.green, bold = true)),
            ),
            fontSize = 14,
        )

        // Socket longevity — separate table.
        Text(t.socketsHeld, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        StatTable(
            rows = listOf(
                listOf(cell(t.over1m, AppColors.onSurfaceMuted), cell(t.over5m, AppColors.onSurfaceMuted), cell(t.over15m, AppColors.onSurfaceMuted)),
                listOf(cell("${s.sessOver1m}", bold = true), cell("${s.sessOver5m}", bold = true), cell("${s.sessOver15m}", bold = true)),
            ),
            fontSize = 14,
        )

        // Probe counts over time.
        Text(t.scanCountTitle, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        StatTable(
            rows = listOf(
                listOf(cell(t.checked, AppColors.onSurfaceMuted, bold = true), cell(t.total, AppColors.onSurfaceMuted), cell(t.alive, AppColors.onSurfaceMuted), cell(t.dead, AppColors.onSurfaceMuted)),
                listOf(cell(t.forAllTime), cell("${s.checkedAllTime}", bold = true), cell("${s.aliveAllTime}", AppColors.green), cell("${s.deadAllTime}", AppColors.gray)),
                listOf(cell(t.perMinute), cell("$checkedMin", bold = true), cell("${s.checksOk60s}", AppColors.green), cell("${s.checksFail60s}", AppColors.gray)),
                listOf(cell(t.perHour), cell("$checkedHour", bold = true), cell("${s.checksOk60m}", AppColors.green), cell("${s.checksFail60m}", AppColors.gray)),
            ),
            weights = listOf(1.3f, 1f, 1f, 1f),
            fontSize = 14,
        )

        // Subscription download pipeline.
        Text(t.subsCountTitle, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        StatTable(
            rows = listOf(
                listOf(cell(t.subscriptions, AppColors.onSurfaceMuted, bold = true), cell(t.perMinute, AppColors.onSurfaceMuted), cell(t.perHour, AppColors.onSurfaceMuted)),
                listOf(cell(t.downloaded), cell("${s.subsOkMin}", AppColors.green), cell("${s.subsOkHour}", AppColors.green)),
                listOf(cell(t.failed), cell("${s.subsFailMin}", AppColors.red), cell("${s.subsFailHour}", AppColors.red)),
                listOf(cell(t.scanTraffic), cell(s.scanBytesMin, bold = true), cell(s.scanBytesHour, bold = true)),
            ),
            weights = listOf(1.3f, 1f, 1f),
            fontSize = 14,
        )
    }
}
