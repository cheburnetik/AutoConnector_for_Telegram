import org.jetbrains.kotlin.gradle.dsl.JvmTarget

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

    defaultConfig {
        applicationId = "io.autoconnector"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    packaging {
        resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
}
