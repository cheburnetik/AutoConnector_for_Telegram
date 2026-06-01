package io.autoconnector.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import io.autoconnector.ui.theme.AppColors
import io.autoconnector.ui.theme.monospaceFontFamily
import io.autoconnector.ui.theme.sansFontFamily

/** A single table cell. */
data class Cell(
    val text: String,
    val color: Color = AppColors.onSurface,
    val bold: Boolean = false,
    val mono: Boolean = false,
)

fun cell(text: String, color: Color = AppColors.onSurface, bold: Boolean = false, mono: Boolean = false) =
    Cell(text, color, bold, mono)

/**
 * Compact bordered table. All rows must have the same number of cells (pad with
 * empty cells). [weights] sizes the columns; defaults to equal widths.
 */
@Composable
fun StatTable(
    rows: List<List<Cell>>,
    modifier: Modifier = Modifier,
    weights: List<Float>? = null,
    fontSize: Int = 14,
) {
    if (rows.isEmpty()) return
    val cols = rows.maxOf { it.size }
    val w = weights ?: List(cols) { 1f }

    Box(
        modifier.fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(AppColors.card)
            .border(1.dp, AppColors.cardBorder, RoundedCornerShape(10.dp)),
    ) {
        Column {
            rows.forEachIndexed { ri, row ->
                if (ri > 0) Box(Modifier.fillMaxWidth().height(1.dp).background(AppColors.cardBorder))
                Row(Modifier.fillMaxWidth().height(intrinsicRowHeight(fontSize))) {
                    for (ci in 0 until cols) {
                        if (ci > 0) Box(Modifier.fillMaxHeight().width(1.dp).background(AppColors.cardBorder))
                        val c = row.getOrNull(ci) ?: Cell("")
                        Box(Modifier.weight(w.getOrElse(ci) { 1f }).fillMaxHeight().padding(horizontal = 8.dp, vertical = 6.dp)) {
                            Text(
                                c.text,
                                color = c.color,
                                fontSize = fontSize.sp,
                                fontWeight = if (c.bold) FontWeight.Bold else FontWeight.Normal,
                                fontFamily = if (c.mono) monospaceFontFamily() else sansFontFamily(),
                                maxLines = 1,
                            )
                        }
                    }
                }
            }
        }
    }
}

private fun intrinsicRowHeight(fontSize: Int) = (fontSize + 18).dp
