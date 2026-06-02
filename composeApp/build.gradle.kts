import org.jetbrains.kotlin.gradle.dsl.JvmTarget
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
            dependencies {
                implementation(compose.desktop.currentOs)
                // The reused relay engine, compiled for a plain JVM (+ android.* shim).
                implementation(project(":engineDesktop"))
                // Swing dispatcher for Compose Desktop's event loop.
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.8.1")
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
        versionCode = 2
        versionName = "1.01"
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

    signingConfigs {
        if (hasKeystore) {
            create("release") {
                storeFile = file(keystoreProps.getProperty("storeFile"))
                storePassword = keystoreProps.getProperty("storePassword")
                keyAlias = keystoreProps.getProperty("keyAlias")
                keyPassword = keystoreProps.getProperty("keyPassword")
                enableV1Signing = true
                enableV2Signing = true
                enableV3Signing = true
            }
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            if (hasKeystore) signingConfig = signingConfigs.getByName("release")
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
        jvmArgs += listOf("-Djava.awt.headless=false")
        nativeDistributions {
            targetFormats(
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Exe,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Msi,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Deb,
            )
            packageName = "AutoConnector"
            packageVersion = "1.0.0"
            description = "AutoConnector for Telegram"
        }
    }
}
