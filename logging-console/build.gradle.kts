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
    android { library() }
    jvm { library() }
    js(IR) { library() }
    val nativeTargets = nativeTargets(false)

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":logging-core"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(asoft("expect-core", vers.asoft.expect))
            }
        }

        val nativeMain by creating {
            dependsOn(commonMain)
        }

        val nativeTest by creating {
            dependsOn(nativeMain)
            dependsOn(commonTest)
        }

        for (target in nativeTargets) {
            val main by target.compilations.getting {
                defaultSourceSet {
                    dependsOn(nativeMain)
                }
            }

            val test by target.compilations.getting {
                defaultSourceSet {
//                    dependsOn(main.defaultSourceSet)
                    dependsOn(commonTest)
                }
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.logging,
    description = "A multiplatform solution to logging on the console"
)