package io.autoconnector

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Tray
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberTrayState
import androidx.compose.ui.window.rememberWindowState
import io.autoconnector.i18n.deviceLanguage
import io.autoconnector.ui.App
import java.awt.Toolkit
import java.io.File

/**
 * Per-user data directory for the SQLite proxy store and preferences. Mirrors
 * what an Android app gets for free under its private files dir.
 */
private fun appDataDir(): File {
    val os = System.getProperty("os.name", "").lowercase()
    val base = when {
        os.contains("win") -> System.getenv("APPDATA") ?: System.getProperty("user.home")
        os.contains("mac") -> System.getProperty("user.home") + "/Library/Application Support"
        else -> System.getenv("XDG_DATA_HOME") ?: (System.getProperty("user.home") + "/.local/share")
    }
    return File(base, "AutoConnector").apply { mkdirs() }
}

/** First-launch window size: phone-width, height 10% less than the screen height. */
private fun initialWindowSize(): DpSize {
    val screenH = try { Toolkit.getDefaultToolkit().screenSize.height } catch (_: Throwable) { 900 }
    val h = (screenH * 0.9f).coerceIn(480f, 1100f)
    return DpSize(400.dp, h.dp)
}

fun main() = application {
    val engine = remember { DesktopEngine(appDataDir()).also { it.start() } }
    // On platforms with a system tray (Windows, KDE, …) closing the window
    // minimises to the tray and the relay keeps running. On tray-less desktops
    // (many GNOME/Wayland setups, minimal WMs) hiding the window would leave an
    // invisible, unrecoverable process — so there we just exit on close.
    val traySupported = remember {
        try { java.awt.SystemTray.isSupported() } catch (_: Throwable) { false }
    }
    var windowVisible by remember { mutableStateOf(true) }
    val trayState = rememberTrayState()
    val state = rememberWindowState(size = initialWindowSize())
    val icon = painterResource("icons/tray.png")

    val ru = deviceLanguage() == "ru"
    val openLabel = if (ru) "Открыть" else "Open"
    val exitLabel = if (ru) "Выход" else "Exit"

    if (traySupported) {
        Tray(
            icon = icon,
            state = trayState,
            tooltip = "AutoConnector for Telegram",
            onAction = { windowVisible = true }, // left-click the tray icon → restore
            menu = {
                Item(openLabel, onClick = { windowVisible = true })
                Item(exitLabel, onClick = ::exitApplication)
            },
        )
    }

    Window(
        // With a tray: close → minimise to tray. Without: close → quit.
        onCloseRequest = { if (traySupported) windowVisible = false else exitApplication() },
        visible = windowVisible,
        state = state,
        icon = icon,
        title = "AutoConnector for Telegram",
    ) {
        // Desktop-only: shrink every sp-based font 20% vs Android (the shared UI
        // is tuned for phones). dp sizes are untouched, so layout stays intact.
        val d = androidx.compose.ui.platform.LocalDensity.current
        androidx.compose.runtime.CompositionLocalProvider(
            androidx.compose.ui.platform.LocalDensity provides
                androidx.compose.ui.unit.Density(d.density, d.fontScale * 0.88f),
        ) {
            App(engine)
        }
    }
}
