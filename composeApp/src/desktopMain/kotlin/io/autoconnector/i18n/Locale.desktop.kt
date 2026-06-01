package io.autoconnector.i18n

import java.util.Locale

actual fun deviceLanguage(): String = Locale.getDefault().language.lowercase()
