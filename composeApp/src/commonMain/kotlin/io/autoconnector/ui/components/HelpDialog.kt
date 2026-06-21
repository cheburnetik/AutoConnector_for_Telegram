package io.autoconnector.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import io.autoconnector.i18n.LocalStrings
import io.autoconnector.ui.theme.AppColors

/**
 * Wide, scrollable help dialog used for long "(?)" / Info bodies.
 *
 * Unlike the narrow default [androidx.compose.material3.AlertDialog] this fills
 * ~95% of the window width (small side margins) so long text has room, and it
 * draws an ALWAYS-VISIBLE scrollbar thumb on the right of the body so users
 * notice there is more to scroll — on both Android and desktop (commonMain, so
 * no desktop-only VerticalScrollbar).
 */
@Composable
fun HelpDialog(title: String, body: String, onDismiss: () -> Unit) {
    val t = LocalStrings.current
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false),
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(0.95f).heightIn(max = 560.dp),
            shape = RoundedCornerShape(16.dp),
            color = AppColors.card,
        ) {
            Column(Modifier.padding(20.dp)) {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = AppColors.onSurface)
                Box(Modifier.weight(1f, fill = false).padding(top = 14.dp)) {
                    val scroll = rememberScrollState()
                    BoxWithConstraints(Modifier.fillMaxWidth()) {
                        Column(
                            Modifier.fillMaxWidth().verticalScroll(scroll).padding(end = 10.dp),
                        ) {
                            Text(
                                body,
                                fontSize = 15.sp,
                                lineHeight = 21.sp,
                                color = AppColors.onSurface,
                            )
                        }
                        // Always-visible scrollbar: a faint track plus an accent
                        // thumb whose size ∝ viewport/content and whose offset ∝
                        // scroll position. Hidden only when nothing can scroll.
                        if (scroll.maxValue > 0) {
                            val viewportPx = constraints.maxHeight.toFloat()
                            val contentPx = viewportPx + scroll.maxValue.toFloat()
                            val frac = (viewportPx / contentPx).coerceIn(0.08f, 1f)
                            val progress = scroll.value.toFloat() / scroll.maxValue.toFloat()
                            // Track.
                            Box(
                                Modifier
                                    .align(Alignment.TopEnd)
                                    .width(4.dp)
                                    .fillMaxHeight()
                                    .clip(RoundedCornerShape(2.dp))
                                    .background(AppColors.onSurfaceMuted.copy(alpha = 0.12f)),
                            )
                            // Thumb.
                            BoxWithConstraints(
                                Modifier.align(Alignment.TopEnd).width(4.dp).fillMaxHeight(),
                            ) {
                                val trackH = this.maxHeight
                                val thumbH = (trackH * frac).coerceAtLeast(24.dp).coerceAtMost(trackH)
                                val offsetY = (trackH - thumbH) * progress
                                Box(
                                    Modifier
                                        .padding(top = offsetY)
                                        .width(4.dp)
                                        .height(thumbH)
                                        .clip(RoundedCornerShape(2.dp))
                                        .background(AppColors.accent.copy(alpha = 0.5f)),
                                )
                            }
                        }
                    }
                }
                Row(Modifier.fillMaxWidth().padding(top = 8.dp), horizontalArrangement = Arrangement.End) {
                    TextButton(onClick = onDismiss) { Text(t.gotIt) }
                }
            }
        }
    }
}
