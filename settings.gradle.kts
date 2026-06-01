rootProject.name = "AutoConnector"

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

include(":composeApp")
// Plain-JVM build of the reused relay engine for the desktop (Windows/Linux/macOS)
// target. It re-compiles the very same engine .java sources the Android build uses
// (see engineDesktop/build.gradle.kts) against a tiny android.* shim, so the engine
// stays single-sourced and the Android build is left completely untouched.
include(":engineDesktop")
