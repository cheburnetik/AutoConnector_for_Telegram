package io.autoconnector.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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

/**
 * TG-blue accent over a "card" surface. The palette is now theme-aware: the
 * colour properties are Compose snapshot state, so the ~290 call-sites that read
 * `AppColors.green` / `.background` / … recompose (and Canvas draws redraw)
 * automatically when [apply] swaps the light/dark values — no call-site changes.
 * The accent (TG blue) is identical in both themes.
 */
object AppColors {
    /** Immutable colour set for one theme. */
    class Palette(
        val accent: Color, val accentDark: Color, val background: Color, val card: Color,
        val cardBorder: Color, val onSurface: Color, val onSurfaceMuted: Color,
        val green: Color, val amber: Color, val blue: Color, val red: Color, val gray: Color,
    )

    val Light = Palette(
        accent = Color(0xFF229ED9), accentDark = Color(0xFF0088CC),
        background = Color(0xFFFFFFFF), card = Color(0xFFF5F7FA), cardBorder = Color(0xFFE3E8EF),
        onSurface = Color(0xFF1A1D21),
        // Muted but still readable at small sizes (darker than a typical grey).
        onSurfaceMuted = Color(0xFF44505F),
        green = Color(0xFF12862F), amber = Color(0xFFC77F00), blue = Color(0xFF1565C0),
        red = Color(0xFFD32F2F), gray = Color(0xFF6B7280),
    )

    // Dark theme: near-black surfaces, brighter status hues so green/red/amber
    // stay legible on a dark background; the TG-blue accent is unchanged.
    val Dark = Palette(
        accent = Color(0xFF2AA3DC), accentDark = Color(0xFF49B6E8),
        background = Color(0xFF14171C), card = Color(0xFF1D2228), cardBorder = Color(0xFF2E353E),
        onSurface = Color(0xFFE7ECF2), onSurfaceMuted = Color(0xFF98A4B2),
        green = Color(0xFF35C667), amber = Color(0xFFE0A53A), blue = Color(0xFF5AA0F0),
        red = Color(0xFFF0564E), gray = Color(0xFF8A94A0),
    )

    // Live palette — Compose snapshot state, defaults to Light (declared above).
    var accent by mutableStateOf(Light.accent); private set
    var accentDark by mutableStateOf(Light.accentDark); private set
    var background by mutableStateOf(Light.background); private set
    var card by mutableStateOf(Light.card); private set
    var cardBorder by mutableStateOf(Light.cardBorder); private set
    var onSurface by mutableStateOf(Light.onSurface); private set
    var onSurfaceMuted by mutableStateOf(Light.onSurfaceMuted); private set
    var green by mutableStateOf(Light.green); private set
    var amber by mutableStateOf(Light.amber); private set
    var blue by mutableStateOf(Light.blue); private set
    var red by mutableStateOf(Light.red); private set
    var gray by mutableStateOf(Light.gray); private set

    /** Swap the live palette. Writing the same values is a structural no-op, so
     *  this is safe to call on every recomposition. */
    internal fun apply(dark: Boolean) {
        val p = if (dark) Dark else Light
        accent = p.accent; accentDark = p.accentDark; background = p.background; card = p.card
        cardBorder = p.cardBorder; onSurface = p.onSurface; onSurfaceMuted = p.onSurfaceMuted
        green = p.green; amber = p.amber; blue = p.blue; red = p.red; gray = p.gray
    }
}

private fun schemeFor(p: AppColors.Palette, dark: Boolean): ColorScheme {
    // Build from the matching factory (so the many colours we don't override get
    // sane light/dark defaults) and override the ones that define our look.
    return if (dark) darkColorScheme(
        primary = p.accent,
        onPrimary = Color.White,
        primaryContainer = Color(0xFF15384B),
        onPrimaryContainer = p.accentDark,
        secondary = p.accent,
        background = p.background,
        onBackground = p.onSurface,
        surface = p.background,
        onSurface = p.onSurface,
        surfaceVariant = p.card,
        onSurfaceVariant = p.onSurfaceMuted,
        outline = p.cardBorder,
        error = p.red,
    ) else lightColorScheme(
        primary = p.accent,
        onPrimary = Color.White,
        primaryContainer = Color(0xFFD6ECF8),
        onPrimaryContainer = p.accentDark,
        secondary = p.accent,
        background = p.background,
        onBackground = p.onSurface,
        surface = p.background,
        onSurface = p.onSurface,
        surfaceVariant = p.card,
        onSurfaceVariant = p.onSurfaceMuted,
        outline = p.cardBorder,
        error = p.red,
    )
}

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
fun AppTheme(dark: Boolean = false, content: @Composable () -> Unit) {
    // Swap the global palette BEFORE composing children so the first frame already
    // renders in the right theme (children read the fresh snapshot values).
    AppColors.apply(dark)
    val ff = defaultFontFamily()
    val typography = if (ff != null) appTypography.withFontFamily(ff) else appTypography
    MaterialTheme(
        colorScheme = schemeFor(if (dark) AppColors.Dark else AppColors.Light, dark),
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
