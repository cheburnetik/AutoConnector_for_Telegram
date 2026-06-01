package io.autoconnector.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Platform default font family. Android returns null → the system font is used
 * (unchanged behaviour). Desktop returns a font bundled with the app, so text
 * rendering never depends on which fonts the host machine happens to have
 * installed — important for a portable Windows .exe and for parity with the
 * phone build.
 */
expect fun defaultFontFamily(): FontFamily?

/**
 * Monospace family for code/host/log text. Android uses the system monospace;
 * desktop uses a bundled one (the generic {@code FontFamily.Monospace} can't be
 * resolved on a host without a registered monospace font, e.g. under Wine).
 */
expect fun monospaceFontFamily(): FontFamily

/** Convenience for call-sites that previously hard-coded {@code FontFamily.Default}. */
fun sansFontFamily(): FontFamily = defaultFontFamily() ?: FontFamily.Default

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

/** Stamps [ff] onto every Material text style so no style resolves to the
 *  platform default family (which is what fails on a font-stripped host). */
private fun Typography.withFontFamily(ff: FontFamily) = copy(
    displayLarge = displayLarge.copy(fontFamily = ff),
    displayMedium = displayMedium.copy(fontFamily = ff),
    displaySmall = displaySmall.copy(fontFamily = ff),
    headlineLarge = headlineLarge.copy(fontFamily = ff),
    headlineMedium = headlineMedium.copy(fontFamily = ff),
    headlineSmall = headlineSmall.copy(fontFamily = ff),
    titleLarge = titleLarge.copy(fontFamily = ff),
    titleMedium = titleMedium.copy(fontFamily = ff),
    titleSmall = titleSmall.copy(fontFamily = ff),
    bodyLarge = bodyLarge.copy(fontFamily = ff),
    bodyMedium = bodyMedium.copy(fontFamily = ff),
    bodySmall = bodySmall.copy(fontFamily = ff),
    labelLarge = labelLarge.copy(fontFamily = ff),
    labelMedium = labelMedium.copy(fontFamily = ff),
    labelSmall = labelSmall.copy(fontFamily = ff),
)

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    val ff = defaultFontFamily()
    val typography = if (ff != null) appTypography.withFontFamily(ff) else appTypography
    MaterialTheme(
        colorScheme = scheme,
        typography = typography,
        shapes = appShapes,
    ) {
        // Slightly condensed look app-wide: tighter letter-spacing + dark default
        // text colour (so small text never renders in unreadable grey).
        val base = androidx.compose.material3.LocalTextStyle.current
        androidx.compose.runtime.CompositionLocalProvider(
            androidx.compose.material3.LocalTextStyle provides base.copy(
                letterSpacing = (-0.4).sp,
                color = AppColors.onSurface,
                fontFamily = ff ?: base.fontFamily,
            ),
            content = content,
        )
    }
}
