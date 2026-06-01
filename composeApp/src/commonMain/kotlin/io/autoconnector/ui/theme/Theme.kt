package io.autoconnector.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/** TG-blue accent over a clean light "card" surface. */
object AppColors {
    val accent = Color(0xFF229ED9)
    val accentDark = Color(0xFF0088CC)
    val background = Color(0xFFFFFFFF)
    val card = Color(0xFFF5F7FA)
    val cardBorder = Color(0xFFE3E8EF)
    val onSurface = Color(0xFF1A1D21)
    // Muted but still readable at small sizes (darker than a typical grey).
    val onSurfaceMuted = Color(0xFF44505F)

    val green = Color(0xFF12862F)
    val amber = Color(0xFFC77F00)
    val blue = Color(0xFF1565C0)
    val red = Color(0xFFD32F2F)
    val gray = Color(0xFF6B7280)
}

private val scheme = lightColorScheme(
    primary = AppColors.accent,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFD6ECF8),
    onPrimaryContainer = AppColors.accentDark,
    secondary = AppColors.accent,
    background = AppColors.background,
    onBackground = AppColors.onSurface,
    surface = AppColors.background,
    onSurface = AppColors.onSurface,
    surfaceVariant = AppColors.card,
    onSurfaceVariant = AppColors.onSurfaceMuted,
    outline = AppColors.cardBorder,
    error = AppColors.red,
)

private val appShapes = Shapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(16.dp),
)

private val appTypography = Typography(
    titleLarge = Typography().titleLarge.copy(fontWeight = FontWeight.Bold, fontSize = 22.sp),
    titleMedium = Typography().titleMedium.copy(fontWeight = FontWeight.Bold),
)

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = scheme,
        typography = appTypography,
        shapes = appShapes,
    ) {
        // Slightly condensed look app-wide: tighter letter-spacing + dark default
        // text colour (so small text never renders in unreadable grey).
        val base = androidx.compose.material3.LocalTextStyle.current
        androidx.compose.runtime.CompositionLocalProvider(
            androidx.compose.material3.LocalTextStyle provides base.copy(
                letterSpacing = (-0.4).sp,
                color = AppColors.onSurface,
            ),
            content = content,
        )
    }
}
