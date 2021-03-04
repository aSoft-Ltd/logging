plugins {
    kotlin("jvm")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    target {
        targetJava("1.8")
    }

    sourceSets {
        val main by getting {
            dependencies {
                api(project(":logging-core"))
                api("org.jetbrains.kotlinx:kotlinx-datetime:${vers.kotlinx.datetime}")
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.logging,
    description = "A jvm solution to logging on to a file"
)