package io.autoconnector

import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import io.autoconnector.i18n.deviceLanguage
import io.autoconnector.i18n.stringsFor
import io.autoconnector.ui.App
import io.autoconnector.ui.components.LocalUiActive
import java.awt.Font
import java.awt.SystemTray
import java.awt.Toolkit
import java.awt.TrayIcon
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.io.File
import javax.swing.BorderFactory
import javax.swing.JMenuItem
import javax.swing.JPopupMenu
import javax.swing.JSeparator
import javax.swing.JWindow
import javax.swing.SwingUtilities
import javax.swing.event.PopupMenuEvent
import javax.swing.event.PopupMenuListener
import kotlin.system.exitProcess

/**
 * Per-user data directory for the SQLite proxy store and preferences. Mirrors
 * what an Android app gets for free under its private files dir.
 */
private fun appDataDir(): File {
    val os = System.getProperty("os.name", "").lowercase()
    val home = System.getProperty("user.home")
    // Try several locations and RETURN THE FIRST that is actually creatable AND
    // writable. On some hosts %APPDATA% can't be created (redirected/locked
    // roaming profile, AV, permissions) — that used to crash the engine
    // constructor during composition, so no window ever appeared. The fallbacks
    // guarantee a usable data dir instead of a dead app.
    val candidates = ArrayList<File>()
    if (os.contains("win")) {
        System.getenv("APPDATA")?.takeIf { it.isNotBlank() }?.let { candidates.add(File(it, "AutoConnector")) }
        System.getenv("LOCALAPPDATA")?.takeIf { it.isNotBlank() }?.let { candidates.add(File(it, "AutoConnector")) }
        candidates.add(File(home, "AutoConnector"))
    } else if (os.contains("mac")) {
        candidates.add(File(home, "Library/Application Support/AutoConnector"))
    } else {
        val xdg = System.getenv("XDG_DATA_HOME")?.takeIf { it.isNotBlank() } ?: "$home/.local/share"
        candidates.add(File(xdg, "AutoConnector"))
    }
    candidates.add(File(home, ".autoconnector"))
    candidates.add(File(System.getProperty("java.io.tmpdir"), "AutoConnector"))
    for (d in candidates) {
        try {
            d.mkdirs()
            if (d.isDirectory) {
                val probe = File(d, ".wtest")
                probe.writeText("ok"); probe.delete()  // confirm we can actually write
                return d
            }
        } catch (_: Throwable) { /* try the next candidate */ }
    }
    // Absolute last resort — temp dir (best-effort).
    return File(System.getProperty("java.io.tmpdir"), "AutoConnector").apply { runCatching { mkdirs() } }
}

/** First-launch window size: phone-width, height 10% less than the screen height. */
private fun initialWindowSize(): DpSize {
    val screenH = try { Toolkit.getDefaultToolkit().screenSize.height } catch (_: Throwable) { 900 }
    val h = (screenH * 0.9f).coerceIn(480f, 1100f)
    return DpSize(400.dp, h.dp)
}

fun main() = application {
    val engine = remember { DesktopEngine(appDataDir()) }
    // Crash diagnostics: the GUI launcher has no console, so route any uncaught
    // exception (composition / EDT / coroutine) to a log file in the user's home.
    remember {
        val prev = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler { t, e ->
            runCatching {
                java.io.File(System.getProperty("user.home"), "autoconnector-crash.log")
                    .appendText("[" + java.util.Date() + "] thread=" + t.name + "\n" + e.stackTraceToString() + "\n\n")
            }
            e.printStackTrace()
            prev?.uncaughtException(t, e)
        }
        0
    }
    // Start the engine OFF the composition thread so the window always appears,
    // even if start() blocks (global-hotkey native hook, relay bind, first DB
    // open). Guarded so a startup error can't crash the UI.
    LaunchedEffect(Unit) { runCatching { engine.start() } }
    // On platforms with a system tray (Windows, KDE, …) closing the window
    // minimises to the tray and the relay keeps running. On tray-less desktops
    // (many GNOME/Wayland setups, minimal WMs) hiding the window would leave an
    // invisible, unrecoverable process — so there we just exit on close.
    val traySupported = remember {
        try { SystemTray.isSupported() } catch (_: Throwable) { false }
    }
    var windowVisible by remember { mutableStateOf(true) }
    val state = rememberWindowState(size = initialWindowSize())
    // Tell the engine when the UI is actually on-screen so its UI-only loops
    // (state poll, sparkline ingest) back off while minimised or hidden to tray.
    LaunchedEffect(windowVisible, state.isMinimized) {
        engine.setUiActive(windowVisible && !state.isMinimized)
    }
    // Live handle to the underlying AWT window, captured once the Compose Window
    // is on screen. The tray needs it to raise an ALREADY-visible window above
    // other apps — toggling `windowVisible` alone is a no-op in that case.
    val windowRef = remember { java.util.concurrent.atomic.AtomicReference<java.awt.Window?>() }
    val icon = painterResource("icons/tray.png")
    val ru = deviceLanguage() == "ru"

    // Full teardown. The engine spawns non-daemon worker pools (AppExecutors),
    // a relay server and a global-hotkey native hook — none of which die on
    // exitApplication() alone, so the process used to linger in Task Manager.
    // dispose() stops what it can; exitProcess() then guarantees the JVM dies.
    fun quit() {
        try { engine.dispose() } catch (_: Throwable) {}
        try {
            val t = SystemTray.getSystemTray()
            t.trayIcons.forEach { t.remove(it) }
        } catch (_: Throwable) {}
        exitProcess(0)
    }

    // Show the window AND raise it above whatever is covering it. Setting
    // windowVisible/un-minimising handles the "hidden in tray" and "minimised"
    // cases; the AWT toFront()/requestFocus() handles the "already open but
    // buried under other windows" case (where the state flag doesn't change, so
    // recomposition does nothing). Windows refuses to let a background process
    // steal the foreground, so we momentarily flip always-on-top to force the
    // raise, then drop it on the next EDT tick so the window doesn't stay pinned.
    fun showWindow() {
        windowVisible = true
        if (state.isMinimized) state.isMinimized = false
        SwingUtilities.invokeLater {
            val w = windowRef.get() ?: return@invokeLater
            runCatching {
                w.isVisible = true
                val prev = w.isAlwaysOnTop
                w.isAlwaysOnTop = true
                w.toFront()
                w.requestFocus()
                SwingUtilities.invokeLater { runCatching { w.isAlwaysOnTop = prev } }
            }
        }
    }

    // --- System tray (Swing JPopupMenu) ---------------------------------
    // A Swing popup (not Compose's Tray nor an AWT PopupMenu) so we control the
    // font size AND the per-item spacing — neither is adjustable on the native
    // AWT menu.
    if (traySupported) {
        // Static menu items kept so their labels can be re-translated when the UI
        // language changes at runtime. Indices: 0 open-window, 1 connector,
        // 2 scan, 3 live-count, 4 copy-random, 5 open-random, 6 scan-now,
        // 7 refresh-subs, 8 settings, 9 exit. (The brand header never translates.)
        val items = remember { arrayOfNulls<JMenuItem>(10) }
        val st by engine.state.collectAsState()
        val settings by engine.settings.collectAsState()
        val langCode = settings.langCode

        DisposableEffect(Unit) {
            // CRITICAL: build the tray entirely ON THE EDT. Creating Swing
            // windows/popups off the AWT event thread can grab the AWT tree-lock
            // and deadlock the toolkit, so the main Compose window never paints —
            // that was the "no window + two hung AutoConnector processes" bug on
            // some hosts. Everything here is best-effort: if the tray can't be
            // built the app still runs via its window.
            val created = arrayOfNulls<Any>(2) // [TrayIcon, JWindow owner]
            SwingUtilities.invokeLater {
                try {
                    val tray = SystemTray.getSystemTray()
                    val url = object {}.javaClass.getResource("/icons/tray.png") ?: return@invokeLater
                    val img = Toolkit.getDefaultToolkit().createImage(url)
                    val menuFont = Font(Font.SANS_SERIF, Font.PLAIN, 14)   // 20% smaller than 18
                    val headFont = Font(Font.SANS_SERIF, Font.BOLD, 14)
                    val pad = BorderFactory.createEmptyBorder(5, 16, 5, 16) // ~30% more row spacing
                    val popup = JPopupMenu()

                    fun item(label: String, bold: Boolean = false, action: (() -> Unit)? = null): JMenuItem {
                        val mi = JMenuItem(label)
                        mi.font = if (bold) headFont else menuFont
                        mi.border = pad
                        mi.isBorderPainted = false
                        if (action != null) mi.addActionListener { action() } else mi.isEnabled = false
                        popup.add(mi)
                        return mi
                    }

                    val tr0 = stringsFor(langCode)
                    item("AutoConnector for Telegram", bold = true) // brand header (never translated)
                    popup.add(JSeparator())
                    items[0] = item(tr0.trayOpenWindow) { showWindow() }
                    popup.add(JSeparator())
                    items[1] = item("…") { engine.setProxyEnabled(!engine.state.value.proxyEnabled) }
                    items[2] = item("…") { engine.setScanEnabled(!engine.state.value.scanEnabled) }
                    items[3] = item("…") // alive-count status (disabled)
                    popup.add(JSeparator())
                    items[4] = item(tr0.copyRandom) {
                        val links = engine.exportAliveLinks()
                        if (links.isNotEmpty()) engine.copyToClipboard(links[(System.nanoTime() % links.size).toInt()])
                    }
                    items[5] = item(tr0.openRandom) {
                        val links = engine.exportAliveLinks()
                        if (links.isNotEmpty()) engine.openLink(links[(System.nanoTime() % links.size).toInt()])
                    }
                    popup.add(JSeparator())
                    items[6] = item(tr0.scanNow) { engine.scanNow() }
                    items[7] = item(tr0.trayRefreshSubs) { engine.refreshNow() }
                    items[8] = item(tr0.settings) { showWindow() }
                    popup.add(JSeparator())
                    items[9] = item(tr0.trayExit) { quit() }

                    val owner = JWindow().apply { isAlwaysOnTop = true }
                    popup.addPopupMenuListener(object : PopupMenuListener {
                        override fun popupMenuWillBecomeVisible(e: PopupMenuEvent) {}
                        override fun popupMenuWillBecomeInvisible(e: PopupMenuEvent) { owner.isVisible = false }
                        override fun popupMenuCanceled(e: PopupMenuEvent) { owner.isVisible = false }
                    })

                    val trayIcon = TrayIcon(img, "AutoConnector for Telegram")
                    trayIcon.isImageAutoSize = true
                    trayIcon.addMouseListener(object : MouseAdapter() {
                        private fun maybePopup(e: MouseEvent): Boolean {
                            if (!e.isPopupTrigger) return false
                            val ps = popup.preferredSize
                            owner.setLocation(e.x, (e.y - ps.height).coerceAtLeast(0))
                            owner.isVisible = true
                            popup.show(owner, 0, 0)
                            owner.toFront()
                            return true
                        }
                        override fun mousePressed(e: MouseEvent) { maybePopup(e) }
                        override fun mouseReleased(e: MouseEvent) { maybePopup(e) }
                        // Single or double LEFT click opens the window.
                        override fun mouseClicked(e: MouseEvent) {
                            if (e.button == MouseEvent.BUTTON1) showWindow()
                        }
                    })
                    tray.add(trayIcon)
                    created[0] = trayIcon; created[1] = owner
                } catch (_: Throwable) {
                    // Tray unavailable on this host — fine, the window still works.
                }
            }

            onDispose {
                SwingUtilities.invokeLater {
                    try { (created[0] as? TrayIcon)?.let { SystemTray.getSystemTray().remove(it) } } catch (_: Throwable) {}
                    try { (created[1] as? JWindow)?.dispose() } catch (_: Throwable) {}
                }
                items.fill(null)
            }
        }

        // Re-translate every tray label whenever the UI language OR the relevant
        // state changes — so the tray follows the language picked in the app.
        LaunchedEffect(langCode, st.proxyEnabled, st.scanEnabled, st.aliveCount) {
            val tr = stringsFor(langCode)
            SwingUtilities.invokeLater {
                items[0]?.let { it.text = tr.trayOpenWindow }
                items[1]?.let { it.text = tr.trayConnectorLabel(st.proxyEnabled) }
                items[2]?.let { it.text = tr.trayScanLabel(st.scanEnabled) }
                items[3]?.let { it.text = tr.trayLive(st.aliveCount) }
                items[4]?.let { it.text = tr.copyRandom }
                items[5]?.let { it.text = tr.openRandom }
                items[6]?.let { it.text = tr.scanNow }
                items[7]?.let { it.text = tr.trayRefreshSubs }
                items[8]?.let { it.text = tr.settings }
                items[9]?.let { it.text = tr.trayExit }
            }
        }
    }

    Window(
        // With a tray: close → minimise to tray. Without: close → fully quit.
        onCloseRequest = { if (traySupported) windowVisible = false else quit() },
        visible = windowVisible,
        state = state,
        icon = icon,
        title = "AutoConnector for Telegram",
    ) {
        // Hand the live AWT window to the tray so it can raise it on demand.
        LaunchedEffect(window) { windowRef.set(window) }
        // Desktop-only: shrink every sp-based font 20% vs Android (the shared UI
        // is tuned for phones). dp sizes are untouched, so layout stays intact.
        val d = androidx.compose.ui.platform.LocalDensity.current
        androidx.compose.runtime.CompositionLocalProvider(
            androidx.compose.ui.platform.LocalDensity provides
                androidx.compose.ui.unit.Density(d.density, d.fontScale * 0.88f),
            // Minimised → animated composables go static (no 60 fps frame clock).
            LocalUiActive provides !state.isMinimized,
        ) {
            App(engine)
        }
    }
}
