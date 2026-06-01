plugins {
    `java-library`
}

// The desktop build of the relay engine. We do NOT copy any engine source — we
// point javac straight at the existing Android source tree and compile the exact
// same .java files against the small android.* shim in src/main/java. Only the
// Android app-lifecycle classes (foreground Service, WorkManager workers, boot
// receiver) are excluded: on desktop their job is done by DesktopEngine instead.
sourceSets {
    main {
        java {
            // The android.* shim lives here.
            srcDir("src/main/java")
            // …and the reused engine sources live in the Android module.
            srcDir("../composeApp/src/androidMain/java")
            exclude("io/autoconnector/engine/relay/RelayService.java")
            exclude("io/autoconnector/engine/relay/BootReceiver.java")
            exclude("io/autoconnector/engine/work/**")
        }
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    // Backs the android.database.sqlite.* shim with a real embedded SQLite.
    api("org.xerial:sqlite-jdbc:3.45.3.0")
}
