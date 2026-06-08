package io.autoconnector

import com.github.kwhat.jnativehook.GlobalScreen
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener
import java.util.logging.Level
import java.util.logging.Logger

/**
 * Global (system-wide) hotkeys for desktop, via jnativehook — they fire even
 * when the app window isn't focused. Two chords, both with one configurable
 * letter (default P):
 *
 *  - Ctrl + Shift + Alt + <letter>        → [onCopy]  (copy a random alive tg:// link)
 *  - Ctrl + Alt + Meta(Win/⌘) + <letter>  → [onOpen]  (open one so Telegram grabs it)
 *
 * Every native call is guarded so a hook failure degrades to "hotkeys don't
 * fire" instead of crashing. The native hook is registered only while enabled.
 */
class DesktopHotkeys(
    private val onCopy: () -> Unit,
    private val onOpen: () -> Unit,
) : NativeKeyListener {

    @Volatile private var enabled = false
    @Volatile private var keyCode = vcFor("P")
    private var registered = false

    /** jnativehook VC code for a letter, via its VC_<L> constant (reflection). */
    private fun vcFor(letter: String): Int = try {
        val c = (letter.ifEmpty { "P" })[0].uppercaseChar()
        NativeKeyEvent::class.java.getField("VC_$c").getInt(null)
    } catch (_: Throwable) {
        NativeKeyEvent.VC_P
    }

    /** Apply the desired enabled state + trigger letter. Safe to call repeatedly. */
    @Synchronized
    fun apply(enabled: Boolean, letter: String) {
        this.enabled = enabled
        this.keyCode = vcFor(letter)
        if (enabled) register() else unregister()
    }

    @Synchronized
    private fun register() {
        if (registered) return
        try {
            Logger.getLogger(GlobalScreen::class.java.getPackage().name).apply {
                level = Level.OFF; useParentHandlers = false
            }
            GlobalScreen.registerNativeHook()
            GlobalScreen.addNativeKeyListener(this)
            registered = true
        } catch (_: Throwable) {
            registered = false
        }
    }

    @Synchronized
    private fun unregister() {
        if (!registered) return
        try {
            GlobalScreen.removeNativeKeyListener(this)
            GlobalScreen.unregisterNativeHook()
        } catch (_: Throwable) {
        }
        registered = false
    }

    override fun nativeKeyPressed(e: NativeKeyEvent) {
        if (!enabled || e.keyCode != keyCode) return
        val m = e.modifiers
        val ctrl = (m and NativeKeyEvent.CTRL_MASK) != 0
        val shift = (m and NativeKeyEvent.SHIFT_MASK) != 0
        val alt = (m and NativeKeyEvent.ALT_MASK) != 0
        val meta = (m and NativeKeyEvent.META_MASK) != 0
        when {
            ctrl && shift && alt && !meta -> safe(onCopy)   // Ctrl+Shift+Alt+<key>
            ctrl && alt && meta && !shift -> safe(onOpen)   // Ctrl+Alt+Meta+<key>
        }
    }

    override fun nativeKeyReleased(e: NativeKeyEvent) {}
    override fun nativeKeyTyped(e: NativeKeyEvent) {}

    private fun safe(f: () -> Unit) {
        try { f() } catch (_: Throwable) {}
    }
}
