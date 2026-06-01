package io.autoconnector.ui.theme

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font

/**
 * Desktop bundles DejaVu Sans (regular/bold/italic) and uses it app-wide, so the
 * UI renders identically on any machine regardless of installed system fonts —
 * this is also what makes the app render under Wine, whose DirectWrite font
 * enumeration Skia can't read.
 */
private val bundled: FontFamily by lazy {
    FontFamily(
        Font("fonts/DejaVuSans.ttf", FontWeight.Normal, FontStyle.Normal),
        Font("fonts/DejaVuSans-Bold.ttf", FontWeight.Bold, FontStyle.Normal),
        Font("fonts/DejaVuSans-Oblique.ttf", FontWeight.Normal, FontStyle.Italic),
    )
}

private val bundledMono: FontFamily by lazy {
    FontFamily(
        Font("fonts/DejaVuSansMono.ttf", FontWeight.Normal, FontStyle.Normal),
        Font("fonts/DejaVuSansMono-Bold.ttf", FontWeight.Bold, FontStyle.Normal),
    )
}

actual fun defaultFontFamily(): FontFamily? = bundled

actual fun monospaceFontFamily(): FontFamily = bundledMono
