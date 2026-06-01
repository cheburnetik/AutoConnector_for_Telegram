plugins {
    // Versions chosen to match what is already cached on this machine:
    // Kotlin 2.0.21, AGP 8.5.2; Compose Multiplatform 1.6.11 is the stable
    // line compatible with Kotlin 2.0.x.
    id("com.android.application") version "8.5.2" apply false
    id("org.jetbrains.kotlin.multiplatform") version "2.0.21" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.21" apply false
    id("org.jetbrains.compose") version "1.6.11" apply false
}
