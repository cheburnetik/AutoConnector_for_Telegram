package io.autoconnector.ui.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.autoconnector.ui.theme.AppColors

@Composable
fun StatusDot(color: Color, sizeDp: Int = 12, modifier: Modifier = Modifier) {
    Canvas(modifier.size(sizeDp.dp)) {
        drawCircle(color)
    }
}

/**
 * Slow "breathing" opacity that completes one full cycle every [periodMs]
 * (default 2 s) — used for the setup warning and the connection circle.
 */
/**
 * True while the app window is on-screen. When false (minimised / hidden to
 * tray) animated composables render a STATIC frame instead of driving the
 * 60 fps frame clock — the desktop sets it from windowState.isMinimized. Default
 * true (Android always "active").
 */
val LocalUiActive = staticCompositionLocalOf { true }

@Composable
fun blinkAlpha(periodMs: Int = 2000, min: Float = 0.25f): Float {
    // Window not visible → no infinite transition, no 60 fps redraw.
    if (!LocalUiActive.current) return 1f
    val t = rememberInfiniteTransition(label = "blink")
    val a by t.animateFloat(
        initialValue = 1f,
        targetValue = min,
        animationSpec = infiniteRepeatable(tween(periodMs / 2), RepeatMode.Reverse),
        label = "blinkAlpha",
    )
    return a
}

/** Big filled circle — the connection indicator. Pulses only while [pulse] is
 *  true (i.e. actively connecting); otherwise it's STATIC. A non-stop infinite
 *  transition redraws at 60 fps and, under software rendering, burns CPU at idle
 *  — so we don't animate unless something is genuinely happening. */
@Composable
fun PulseCircle(color: Color, sizeDp: Int, modifier: Modifier = Modifier, pulse: Boolean = true) {
    val a = if (pulse) blinkAlpha(min = 0.3f) else 1f
    Canvas(modifier.size(sizeDp.dp)) {
        drawCircle(color.copy(alpha = 0.18f * a))
        drawCircle(color.copy(alpha = a), radius = size.minDimension / 2f * 0.62f)
    }
}

@Composable
fun Caption(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        modifier = modifier,
        color = AppColors.onSurfaceMuted,
        fontSize = 11.sp,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}

/** Soft "card" surface used across the screens. */
@Composable
fun CardBox(
    modifier: Modifier = Modifier,
    padding: PaddingValues = PaddingValues(12.dp),
    content: @Composable () -> Unit,
) {
    Surface(
        modifier = modifier,
        color = AppColors.card,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, AppColors.cardBorder),
    ) {
        Box(Modifier.padding(padding)) { content() }
    }
}
