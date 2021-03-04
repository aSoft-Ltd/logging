plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

android {
    configureAndroid("src/androidMain")
    defaultConfig {
        minSdk = 8
    }
}

kotlin {
    multiplatformLib(forAndroid = true)
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":logging-core"))
            }
        }
        val commonTest by getting {
            dependencies {
                api(asoft("expect-core", vers.asoft.expect))
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.logging,
    description = "A multiplatform solution to logging on the console"
)