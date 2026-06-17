package io.autoconnector.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import io.autoconnector.R

@Composable
actual fun appLogo(): Painter = painterResource(R.drawable.app_logo)
