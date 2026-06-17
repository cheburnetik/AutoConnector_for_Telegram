package io.autoconnector.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

@Composable
actual fun appLogo(): Painter = painterResource("icons/tray.png")
