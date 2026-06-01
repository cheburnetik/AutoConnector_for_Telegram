package io.autoconnector.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.autoconnector.engine.LogLevel
import io.autoconnector.engine.LogLine
import io.autoconnector.ui.theme.AppColors

/** Log lines emitted into the page's single LazyColumn. */
fun LazyListScope.logsItems(logs: List<LogLine>) {
    items(logs) { line ->
        Text(
            line.text,
            color = colorFor(line.level),
            fontFamily = FontFamily.Monospace,
            fontSize = 14.sp,
            lineHeight = 18.sp,
            modifier = Modifier.padding(horizontal = 12.dp),
        )
    }
}

private fun colorFor(level: LogLevel): Color = when (level) {
    LogLevel.OK -> AppColors.green
    LogLevel.FAIL -> AppColors.red
    LogLevel.WARN -> AppColors.amber
    LogLevel.ROUTE -> AppColors.onSurface
    LogLevel.INFO -> AppColors.blue
    LogLevel.MUTED -> AppColors.onSurfaceMuted
}
