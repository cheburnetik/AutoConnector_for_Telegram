package io.autoconnector.ui.components

import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.focusTarget
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import kotlinx.coroutines.launch

/**
 * Makes a scroll container respond to the keyboard (PageUp/PageDown, arrows,
 * Home/End) on desktop. Compose only routes those keys to a scrollable that
 * holds focus, so this grabs focus once on first composition and listens for
 * key events bubbling up from the focused subtree (so clicking a child control
 * doesn't kill keyboard scrolling). No-op effect on touch platforms.
 *
 * Works for both [androidx.compose.foundation.ScrollState] and
 * [androidx.compose.foundation.lazy.LazyListState] — both are [ScrollableState].
 */
@Composable
fun Modifier.keyPageScroll(state: ScrollableState): Modifier {
    val fr = remember { FocusRequester() }
    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit) { runCatching { fr.requestFocus() } }
    return this
        .focusRequester(fr)
        .focusTarget()   // focusable for key events, but draws NO focus indicator
        .onKeyEvent { e ->
            if (e.type != KeyEventType.KeyDown) return@onKeyEvent false
            val delta = when (e.key) {
                Key.PageDown -> 700f
                Key.PageUp -> -700f
                Key.DirectionDown -> 140f
                Key.DirectionUp -> -140f
                Key.MoveEnd -> 1_000_000f
                Key.MoveHome -> -1_000_000f
                else -> return@onKeyEvent false
            }
            scope.launch { state.animateScrollBy(delta) }
            true
        }
}
