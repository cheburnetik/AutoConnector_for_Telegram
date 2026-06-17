package io.autoconnector.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

/**
 * The app logo (bridge + castle + chat + shield) as a Painter, loaded from each
 * platform's own resources: the desktop tray PNG and the Android launcher
 * drawable. Used by the About page so the same artwork the OS shows for the app
 * also appears inside it.
 */
@Composable
expect fun appLogo(): Painter
