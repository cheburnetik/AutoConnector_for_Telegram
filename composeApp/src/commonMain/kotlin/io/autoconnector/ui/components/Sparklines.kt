package io.autoconnector.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import io.autoconnector.ui.theme.AppColors
import kotlin.math.ln
import kotlin.math.max

private fun DrawScope.bars(
    values: LongArray,
    color: Color,
) {
    val n = values.size
    if (n == 0) return
    var maxV = 1L
    for (v in values) if (v > maxV) maxV = v
    val denom = max(1e-6, ln((maxV + 1).toDouble()))
    val barW = size.width / n
    for (i in 0 until n) {
        val v = values[i]
        if (v <= 0) continue
        val frac = (ln((v + 1).toDouble()) / denom).toFloat()
        val bh = frac * (size.height - 2f)
        drawRect(
            color = color,
            topLeft = Offset(i * barW, size.height - bh),
            size = Size(max(1f, barW - 0.5f), bh),
        )
    }
}

/** Log-scale traffic/latency sparkline inside a bordered card. */
@Composable
fun TrafficSparkline(
    values: LongArray,
    color: Color = AppColors.green,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier
            .clip(RoundedCornerShape(8.dp()))
            .border(1.dp(), AppColors.cardBorder, RoundedCornerShape(8.dp()))
    ) {
        Canvas(Modifier.fillMaxSize()) { bars(values, color) }
    }
}

/** Two-sided check-rate sparkline: ok up (green), fail down (gray). */
@Composable
fun CheckRateSparkline(
    ok: IntArray,
    fail: IntArray,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier
            .clip(RoundedCornerShape(8.dp()))
            .border(1.dp(), AppColors.cardBorder, RoundedCornerShape(8.dp()))
    ) {
        Canvas(Modifier.fillMaxSize()) {
            val n = minOf(ok.size, fail.size)
            if (n == 0) return@Canvas
            var maxOk = 0; var maxFail = 0
            for (i in 0 until n) {
                if (ok[i] > maxOk) maxOk = ok[i]
                if (fail[i] > maxFail) maxFail = fail[i]
            }
            val normOk = max(1, maxOk)
            val normFail = max(1, maxFail)
            val zeroY = size.height / 2f
            val halfH = size.height / 2f - 2f
            val barW = size.width / n
            for (i in 0 until n) {
                val x = i * barW
                val bw = max(1f, barW - 0.5f)
                if (ok[i] > 0) {
                    val bh = ok[i] / normOk.toFloat() * halfH
                    drawRect(AppColors.green, Offset(x, zeroY - bh), Size(bw, bh))
                }
                if (fail[i] > 0) {
                    val bh = fail[i] / normFail.toFloat() * halfH
                    drawRect(AppColors.gray, Offset(x, zeroY), Size(bw, bh))
                }
            }
            drawLine(
                Color(0x55000000),
                Offset(0f, zeroY),
                Offset(size.width, zeroY),
                strokeWidth = 1f,
            )
        }
    }
}

// local dp helpers to keep imports tidy
private fun Int.dp() = androidx.compose.ui.unit.Dp(this.toFloat())
