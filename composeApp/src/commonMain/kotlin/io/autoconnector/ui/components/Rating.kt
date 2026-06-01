package io.autoconnector.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
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
import io.autoconnector.ui.theme.AppColors

/** Colour ramp from red (0) → amber (≈4-5) → green (9). */
fun ratingColor(rating: Int): Color {
    val t = (rating.coerceIn(0, 9)) / 9f
    return if (t < 0.5f) {
        // red → amber
        lerp(Color(0xFFD32F2F), Color(0xFFE89A00), t / 0.5f)
    } else {
        // amber → green
        lerp(Color(0xFFE89A00), Color(0xFF1B9E3F), (t - 0.5f) / 0.5f)
    }
}

private fun lerp(a: Color, b: Color, t: Float): Color = Color(
    red = a.red + (b.red - a.red) * t,
    green = a.green + (b.green - a.green) * t,
    blue = a.blue + (b.blue - a.blue) * t,
    alpha = 1f,
)

/**
 * Rating shown as up to 9 thin vertical bars (filled = rating, coloured by
 * level) plus the numeric value.
 */
@Composable
fun RatingBars(rating: Int, modifier: Modifier = Modifier, barHeight: Int = 14) {
    val r = rating.coerceIn(0, 9)
    val color = ratingColor(r)
    Row(modifier, verticalAlignment = Alignment.CenterVertically) {
        Canvas(Modifier.width(38.dp).height(barHeight.dp)) {
            val n = 9
            val gap = size.width * 0.18f / n
            val bw = (size.width - gap * (n - 1)) / n
            for (i in 0 until n) {
                val x = i * (bw + gap)
                val filled = i < r
                drawRect(
                    color = if (filled) color else AppColors.cardBorder,
                    topLeft = androidx.compose.ui.geometry.Offset(x, 0f),
                    size = androidx.compose.ui.geometry.Size(bw, size.height),
                )
            }
        }
        Text(
            " $r",
            color = color,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
        )
    }
}
