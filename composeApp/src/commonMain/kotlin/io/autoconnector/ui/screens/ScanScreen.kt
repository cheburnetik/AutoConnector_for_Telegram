package io.autoconnector.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.autoconnector.engine.EngineState
import io.autoconnector.i18n.LocalStrings
import io.autoconnector.i18n.modeLabel
import io.autoconnector.ui.components.StatTable
import io.autoconnector.ui.components.cell
import io.autoconnector.ui.components.fmtLatency
import io.autoconnector.ui.components.fmtLatencyPair
import io.autoconnector.ui.components.fmtSpeed
import io.autoconnector.ui.components.fmtSpeedPair
import io.autoconnector.ui.theme.AppColors

@Composable
fun ScanContent(s: EngineState, onScanNow: () -> Unit, onSetScanMode: (String) -> Unit) {
    val t = LocalStrings.current
    val checkedMin = s.checksOk60s + s.checksFail60s
    val checkedHour = s.checksOk60m + s.checksFail60m

    Column(
        Modifier.fillMaxWidth().padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        // Header line: scan state + time-to-next-pass + active mode on one row,
        // then a muted line with the schedule (period / batch / threads). The
        // refresh button still kicks an immediate pass regardless of the plan.
        // Sub-minute periods were shown as "0 мин" (integer ÷60). Render seconds
        // when < 1 min so an aggressive fresh-start plan reads e.g. "30 сек".
        fun durLabel(sec: Int): String =
            if (sec < 60) "$sec ${t.secShort}" else "${sec / 60} ${t.minShort}"
        val period = when {
            !s.scanEnabled || s.scanPlanIntervalSec < 0 -> t.disabledWord
            s.scanPlanIntervalSec == 0 -> t.nonstopWord
            else -> durLabel(s.scanPlanIntervalSec)
        }
        val head = when {
            !s.scanEnabled -> t.scanOffState
            s.scanRunning -> t.scanRunning
            else -> "${t.scanIdle}, ${t.scanNextRun} ${durLabel(s.scanPlanNextSec)}"
        }
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text(
                    "${head} · ${t.modeWord} — ${modeLabel(s.activeMode)}",
                    fontWeight = FontWeight.Bold, fontSize = 15.sp,
                )
                Text(
                    "${t.scheduleWord}: ${t.scanEvery} [${period}], ${t.scanBatchPerThread} [${s.scanPlanBatch}] шт, ${t.scanThreads} [${s.scanPlanConcurrency}] шт",
                    color = AppColors.onSurfaceMuted, fontSize = 13.sp,
                )
            }
            IconButton(onClick = onScanNow) {
                Icon(Icons.Filled.Refresh, t.scanNow, tint = AppColors.accent)
            }
        }

        // Live scan graphs (same look as the connector tab): successful / failed
        // checks, scan traffic rate and probe ping. Per-second (2 s buckets)
        // on the left, per-minute on the right.
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
            GraphRow(
                t.scanOkGraph, { a, b -> "$a · $b ${t.unitPcsPerSec}" },
                ds2(LongArray(60) { s.checkOkSec[it].toLong() }, sec, avg = false),
                LongArray(60) { s.checkOkMin[it].toLong() }, secTick, s.nowMin,
                AppColors.green, minScale = 5, logBase = 1.0, { "$it ${t.unitPcsPerSec}" },
            )
            GraphRow(
                t.scanFailGraph, { a, b -> "$a · $b ${t.unitPcsPerSec}" },
                ds2(LongArray(60) { s.checkFailSec[it].toLong() }, sec, avg = false),
                LongArray(60) { s.checkFailMin[it].toLong() }, secTick, s.nowMin,
                AppColors.red, minScale = 5, logBase = 1.0, { "$it ${t.unitPcsPerSec}" },
            )
            GraphRow(
                t.scanTrafficGraph,
                ::fmtSpeedPair,
                ds2(s.scanTrafficSec, sec, avg = true),
                LongArray(60) { s.scanTrafficMin[it] / 60 }, secTick, s.nowMin,
                AppColors.blue, minScale = 1024, logBase = 1.0, ::fmtSpeed,
            )
            GraphRow(
                t.subTrafficGraph,
                ::fmtSpeedPair,
                ds2(s.subTrafficSec, sec, avg = true),
                LongArray(60) { s.subTrafficMin[it] / 60 }, secTick, s.nowMin,
                AppColors.green, minScale = 1024, logBase = 1.0, ::fmtSpeed,
            )
            GraphRow(
                t.scanPingGraph,
                ::fmtLatencyPair,
                ds2(s.scanPingSec, sec, avg = true),
                s.scanPingMin, secTick, s.nowMin,
                AppColors.accent, minScale = 50, logBase = 5.0, ::fmtLatency,
            )
            GraphRow(
                t.threadsGraph,
                { a, b -> "$a · ${t.pcs(b.toInt())}" },
                ds2(s.threadsSec, sec, avg = true),
                s.threadsMin, secTick, s.nowMin,
                AppColors.amber, minScale = 5, logBase = 1.0, { t.pcs(it.toInt()) },
            )
        }

        // Live "now" snapshot, transposed to label:value rows.
        fun dur(sec: Long): String = if (sec >= 60) "${sec / 60}м ${sec % 60}с" else "${sec}с"
        Text(t.scanNowTitle, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        StatTable(
            rows = listOf(
                listOf(cell(t.scanNowThreadsLabel, AppColors.onSurfaceMuted), cell(t.pcs(s.scanNowThreads), if (s.scanRunning) AppColors.green else AppColors.onSurfaceMuted, bold = true)),
                listOf(cell(t.scanNowPerThreadLabel, AppColors.onSurfaceMuted), cell(t.pcs(s.scanPlanBatch), bold = true)),
                listOf(cell(t.scanNowElapsedLabel, AppColors.onSurfaceMuted), cell(dur(s.scanNowSeconds), bold = true)),
            ),
            weights = listOf(1.5f, 1f),
            fontSize = 14,
        )

        // Pool counts, scoped to the active network mode (ratings are split
        // per-mode, so "alive for VPN" can differ from "alive for LTE").
        Text("${t.proxiesInBase} · ${modeLabel(s.activeMode)}", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        StatTable(
            rows = listOf(
                listOf(cell(t.total, AppColors.onSurfaceMuted), cell(t.alive, AppColors.onSurfaceMuted), cell(t.dead, AppColors.onSurfaceMuted)),
                listOf(cell("${s.totalMode}", bold = true), cell("${s.aliveMode}", AppColors.green, bold = true), cell("${s.deadMode}", AppColors.gray, bold = true)),
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
                listOf(cell(t.subTraffic), cell(s.subBytesMin, bold = true), cell(s.subBytesHour, bold = true)),
            ),
            weights = listOf(1.3f, 1f, 1f),
            fontSize = 14,
        )
    }
}
