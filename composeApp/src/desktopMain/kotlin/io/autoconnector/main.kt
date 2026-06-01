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
    // Closing the window hides it to the tray instead of quitting; the tray menu
    // restores it or exits for good.
    var windowVisible by remember { mutableStateOf(true) }
    val trayState = rememberTrayState()
    val state = rememberWindowState(size = initialWindowSize())
    val icon = painterResource("icons/tray.png")

    val ru = deviceLanguage() == "ru"
    val openLabel = if (ru) "Открыть" else "Open"
    val exitLabel = if (ru) "Выход" else "Exit"

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

    Window(
        onCloseRequest = { windowVisible = false }, // close button → minimise to tray
        visible = windowVisible,
        state = state,
        icon = icon,
        title = "AutoConnector for Telegram",
    ) {
        App(engine)
    }
}
