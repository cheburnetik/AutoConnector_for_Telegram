import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.io.File
import java.io.FileInputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Properties
import java.util.TimeZone

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.kotlin.plugin.compose")
    id("org.jetbrains.compose")
}

// Desktop has no Android-style BuildConfig, so the About page's build date used
// to be empty unless the portable launcher passed -Dautoconnector.build=…. Bake
// the date into a generated Kotlin constant at build time (same UTC format as the
// Android BUILD_DATE below), so even a plain `gradle` desktop build shows a real
// date. The output dir is registered as a desktopMain Kotlin source dir; passing
// the task to kotlin.srcDir(...) makes the desktop compile depend on it.
val generateDesktopBuildStamp = tasks.register("generateDesktopBuildStamp") {
    val outDir = layout.buildDirectory.dir("generated/buildStamp/desktop")
    val stamp = SimpleDateFormat("yyyy-MM-dd HH:mm 'UTC'")
        .apply { timeZone = TimeZone.getTimeZone("UTC") }
        .format(Date())
    inputs.property("stamp", stamp)
    outputs.dir(outDir)
    doLast {
        val pkgDir = File(outDir.get().asFile, "io/autoconnector").apply { mkdirs() }
        File(pkgDir, "BuildStamp.kt").writeText(
            """
            package io.autoconnector

            /** Generated at desktop build time — do not edit. */
            internal object BuildStamp {
                const val BUILD_DATE = "$stamp"
            }
            """.trimIndent() + "\n"
        )
    }
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    // Desktop (Windows / Linux / macOS) JVM target. The shared Compose UI in
    // commonMain renders here unchanged — that's how the desktop window stays a
    // 1:1 copy of the phone screen. The relay engine is reused via :engineDesktop.
    jvm("desktop") {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
                implementation(compose.ui)
                implementation(compose.components.uiToolingPreview)
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
            }
        }
        val desktopMain by getting {
            // Generated BuildStamp.kt (build date constant). Passing the task itself
            // wires the compile→generate dependency automatically.
            kotlin.srcDir(generateDesktopBuildStamp)
            dependencies {
                implementation(compose.desktop.currentOs)
                // The reused relay engine, compiled for a plain JVM (+ android.* shim).
                implementation(project(":engineDesktop"))
                // Swing dispatcher for Compose Desktop's event loop.
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.8.1")
                // Global (system-wide) hotkeys for the desktop hotkeys page.
                // Self-extracts per-OS native libs from this jar at runtime.
                implementation("com.github.kwhat:jnativehook:2.2.2")
            }
        }
        val androidMain by getting {
            // The reused Java relay engine lives in src/androidMain/java.
            // Register it as a Kotlin source dir so Kotlin resolves the
            // io.autoconnector.engine symbols; javac (configured in the android block
            // below) is what actually emits their bytecode.
            kotlin.srcDir("src/androidMain/java")
            dependencies {
                implementation("androidx.activity:activity-compose:1.9.2")
                implementation("androidx.core:core-ktx:1.13.1")
                implementation("androidx.work:work-runtime:2.9.1")
                implementation("androidx.annotation:annotation:1.8.2")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")
            }
        }
    }
}

android {
    namespace = "io.autoconnector"
    compileSdk = 34

    // Make javac compile the reused Java engine so its classes are emitted
    // into the APK (Kotlin only analyses .java, it doesn't produce bytecode).
    sourceSets.getByName("main").java.srcDirs("src/androidMain/java")

    buildFeatures {
        buildConfig = true
    }

    // Baked at build time so the About page can show when the APK was built.
    val buildDate = SimpleDateFormat("yyyy-MM-dd HH:mm 'UTC'")
        .apply { timeZone = TimeZone.getTimeZone("UTC") }
        .format(Date())

    defaultConfig {
        applicationId = "io.autoconnector"
        minSdk = 24
        targetSdk = 34
        versionCode = 79
        versionName = "1.1.22"
        buildConfigField("String", "BUILD_DATE", "\"$buildDate\"")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    // Release signing. Credentials live in keystore.properties (git-ignored, see
    // .gitignore) so the private key is never committed. If the file is absent
    // — e.g. a third party building from source — the release APK is left
    // unsigned instead of breaking the build. All three signature schemes
    // (v1 JAR + v2 + v3) are enabled for the widest install compatibility, which
    // minimises "package invalid / app not installed" warnings on Android.
    val keystorePropsFile = rootProject.file("keystore.properties")
    val hasKeystore = keystorePropsFile.exists()
    val keystoreProps = Properties().apply {
        if (hasKeystore) FileInputStream(keystorePropsFile).use { load(it) }
    }
    // Signing source resolution (the file never holds secrets when env is used):
    //  1) keystore.properties (legacy, git-ignored) if present, else
    //  2) environment variables ACTG_STORE_FILE / ACTG_STORE_PASSWORD /
    //     ACTG_KEY_ALIAS / ACTG_KEY_PASSWORD — lets a release APK be built+signed
    //     on a server WITHOUT ever writing credentials to a file on disk.
    val envStoreFile = System.getenv("ACTG_STORE_FILE")
    val hasEnvSigning = !hasKeystore && envStoreFile != null && envStoreFile.isNotBlank()
    val signStoreFile = if (hasKeystore) keystoreProps.getProperty("storeFile") else envStoreFile
    val signStorePw = if (hasKeystore) keystoreProps.getProperty("storePassword") else System.getenv("ACTG_STORE_PASSWORD")
    val signKeyAlias = if (hasKeystore) keystoreProps.getProperty("keyAlias") else System.getenv("ACTG_KEY_ALIAS")
    val signKeyPw = if (hasKeystore) keystoreProps.getProperty("keyPassword") else System.getenv("ACTG_KEY_PASSWORD")
    val canSign = hasKeystore || hasEnvSigning

    signingConfigs {
        if (canSign) {
            create("release") {
                storeFile = file(signStoreFile)
                storePassword = signStorePw
                keyAlias = signKeyAlias
                keyPassword = signKeyPw
                enableV1Signing = true
                enableV2Signing = true
                enableV3Signing = true
            }
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            if (canSign) signingConfig = signingConfigs.getByName("release")
        }
    }

    packaging {
        resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
}

// Collects the full desktop runtime (all dependency jars + the compiled app jar)
// into build/desktopRuntime so it can be run under a Windows JVM in Wine. The
// Linux skiko jar is swapped for the Windows one out-of-band (see run script).
tasks.register<Sync>("collectDesktopRuntime") {
    dependsOn("desktopJar")
    from(configurations.named("desktopRuntimeClasspath"))
    from(tasks.named("desktopJar"))
    into(layout.buildDirectory.dir("desktopRuntime"))
}

compose.desktop {
    application {
        mainClass = "io.autoconnector.MainKt"
        // Cap the JVM footprint. Without an explicit -Xmx the HotSpot ergonomics
        // pick a max heap of ~1/4 of the host's physical RAM (≈2 GB on an 8 GB
        // machine) and the process happily grows toward it before ever collecting,
        // so a tiny relay UI was sitting at ~1 GB RSS. The real working set (10k
        // hosts live in SQLite on disk, a 50-row UI catalog, small graph ring
        // buffers, capped logs, transient handshake buffers) fits comfortably in a
        // few hundred MB, so cap the heap and metaspace and let G1 hand committed
        // pages back to the OS. Result: RSS drops to roughly a third.
        jvmArgs += listOf(
            "-Djava.awt.headless=false",
            "-Xmx384m",
            "-XX:MaxMetaspaceSize=192m",
            "-XX:+UseG1GC",
            "-XX:MaxGCPauseMillis=200",
            "-XX:G1PeriodicGCInterval=30000",
            "-XX:+G1PeriodicGCInvokesConcurrent",
            // The minimise-time System.gc() (DesktopEngine.setUiActive) runs as a
            // concurrent G1 cycle — low pause, and it hands committed pages back.
            "-XX:+ExplicitGCInvokesConcurrent",
        )
        nativeDistributions {
            targetFormats(
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Exe,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Msi,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Deb,
            )
            packageName = "AutoConnector"
            packageVersion = "1.0.0"
            description = "AutoConnector for Telegram"
            modules("java.sql", "jdk.unsupported")

            // Application icon for the native launcher / installer of each OS.
            // Without these jpackage embeds its own generic Compose placeholder —
            // that's why AutoConnector.exe showed the wrong icon in Explorer and on
            // the shortcut. The window title-bar and tray already use icons/tray.png
            // (the same logo); these files are .ico/.icns/.png renders of it.
            val iconsDir = project.file("src/desktopMain/resources/icons")
            windows {
                iconFile.set(iconsDir.resolve("app.ico"))
            }
            macOS {
                iconFile.set(iconsDir.resolve("app.icns"))
                bundleID = "io.autoconnector"
            }
            linux {
                iconFile.set(iconsDir.resolve("app.png"))
            }
        }
    }
}
