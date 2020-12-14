plugins {
    kotlin("jvm")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

repositories {
    maven(url = "https://kotlin.bintray.com/kotlinx/")
}

targetJava("1.8")

kotlin {
    sourceSets {
        val main by getting {
            dependencies {
                api(project(":logging-core"))
                api("org.jetbrains.kotlinx:kotlinx-datetime:${vers.kotlinx.datetime}")
            }
        }

        val test by getting {
            dependencies {
                api(asoft("test", vers.asoft.test))
            }
        }
    }
}

aSoftLibrary(
    version = vers.asoft.logging,
    description = "A jvm solution to logging on to a file"
)