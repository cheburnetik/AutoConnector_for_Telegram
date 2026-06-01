package io.autoconnector.ui

import androidx.compose.runtime.Composable

/**
 * Desktop has no system "back" gesture, so this is a no-op: in-app navigation
 * (closing overlays, returning to the Connector tab) is driven by the on-screen
 * back buttons that already exist in the shared UI. Keeping the same expect/actual
 * shape lets the phone UI render here verbatim.
 */
@Composable
actual fun PlatformBackHandler(enabled: Boolean, onBack: () -> Unit) {
    // no-op
}
