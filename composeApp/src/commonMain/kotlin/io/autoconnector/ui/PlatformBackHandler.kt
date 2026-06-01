package io.autoconnector.ui

import androidx.compose.runtime.Composable

/**
 * Intercepts the system back gesture / button. When [enabled], [onBack] is
 * invoked instead of the activity finishing — so back navigates our in-app
 * stack (close overlay / return to the main tab) rather than closing the app.
 */
@Composable
expect fun PlatformBackHandler(enabled: Boolean, onBack: () -> Unit)
