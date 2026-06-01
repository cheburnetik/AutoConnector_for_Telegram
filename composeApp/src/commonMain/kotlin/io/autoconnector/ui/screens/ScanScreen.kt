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
import io.autoconnector.ui.components.Caption
import io.autoconnector.ui.components.CheckRateSparkline
import io.autoconnector.ui.components.StatTable
import io.autoconnector.ui.components.cell
import io.autoconnector.ui.theme.AppColors

@Composable
fun ScanContent(s: EngineState) {
    val checkedMin = s.checksOk60s + s.checksFail60s
    val checkedHour = s.checksOk60m + s.checksFail60m

    Column(
        Modifier.fillMaxWidth().padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        if (!s.scanEnabled) {
            StatTable(rows = listOf(listOf(cell("Сканирование выключено", AppColors.onSurfaceMuted))))
        }

        // Graph moved to the top of the tab.
        Text("Проверки MTProto (↑ ok · ↓ fail)", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            CheckRateSparkline(s.checkOkSec, s.checkFailSec, Modifier.weight(1f).height(48.dp))
            CheckRateSparkline(s.checkOkMin, s.checkFailMin, Modifier.weight(1f).height(48.dp))
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Caption("60 секунд", Modifier.weight(1f))
            Caption("60 минут", Modifier.weight(1f))
        }

        // Pool — labels in the header, numbers only in cells.
        Text("Прокси в базе", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        StatTable(
            rows = listOf(
                listOf(cell("всего", AppColors.onSurfaceMuted), cell("живых", AppColors.onSurfaceMuted), cell("мёртвых", AppColors.onSurfaceMuted)),
                listOf(cell("${s.totalCount}", bold = true), cell("${s.aliveCount}", AppColors.green, bold = true), cell("${s.deadCount}", AppColors.gray, bold = true)),
            ),
            fontSize = 14,
        )

        // Telegram connections.
        Text("Telegram подключался", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        StatTable(
            rows = listOf(
                listOf(cell("всего", AppColors.onSurfaceMuted), cell("успешно", AppColors.onSurfaceMuted)),
                listOf(cell("${s.tgSessAll}", bold = true), cell("${s.tgSessOk}", AppColors.green, bold = true)),
            ),
            fontSize = 14,
        )

        // Socket longevity — separate table.
        Text("Сколько держались сокеты", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        StatTable(
            rows = listOf(
                listOf(cell(">1 мин", AppColors.onSurfaceMuted), cell(">5 мин", AppColors.onSurfaceMuted), cell(">15 мин", AppColors.onSurfaceMuted)),
                listOf(cell("${s.sessOver1m}", bold = true), cell("${s.sessOver5m}", bold = true), cell("${s.sessOver15m}", bold = true)),
            ),
            fontSize = 14,
        )

        // Probe counts over time.
        Text("Кол-во сканов прокси", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        StatTable(
            rows = listOf(
                listOf(cell("Проверено", AppColors.onSurfaceMuted, bold = true), cell("всего", AppColors.onSurfaceMuted), cell("живых", AppColors.onSurfaceMuted), cell("мёртвых", AppColors.onSurfaceMuted)),
                listOf(cell("за всё время"), cell("${s.checkedAllTime}", bold = true), cell("${s.aliveAllTime}", AppColors.green), cell("${s.deadAllTime}", AppColors.gray)),
                listOf(cell("за минуту"), cell("$checkedMin", bold = true), cell("${s.checksOk60s}", AppColors.green), cell("${s.checksFail60s}", AppColors.gray)),
                listOf(cell("за час"), cell("$checkedHour", bold = true), cell("${s.checksOk60m}", AppColors.green), cell("${s.checksFail60m}", AppColors.gray)),
            ),
            weights = listOf(1.3f, 1f, 1f, 1f),
            fontSize = 14,
        )

        // Subscription download pipeline.
        Text("Кол-во загрузок подписок", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        StatTable(
            rows = listOf(
                listOf(cell("Подписки", AppColors.onSurfaceMuted, bold = true), cell("за минуту", AppColors.onSurfaceMuted), cell("за час", AppColors.onSurfaceMuted)),
                listOf(cell("скачано"), cell("${s.subsOkMin}", AppColors.green), cell("${s.subsOkHour}", AppColors.green)),
                listOf(cell("неудачно"), cell("${s.subsFailMin}", AppColors.red), cell("${s.subsFailHour}", AppColors.red)),
                listOf(cell("трафик скана"), cell(s.scanBytesMin, bold = true), cell(s.scanBytesHour, bold = true)),
            ),
            weights = listOf(1.3f, 1f, 1f),
            fontSize = 14,
        )
    }
}
