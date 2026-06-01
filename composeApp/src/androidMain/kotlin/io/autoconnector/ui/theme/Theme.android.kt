package io.autoconnector.ui.theme

import androidx.compose.ui.text.font.FontFamily

/** Android keeps the system font (Roboto) — no bundled override needed. */
actual fun defaultFontFamily(): FontFamily? = null

actual fun monospaceFontFamily(): FontFamily = FontFamily.Monospace
