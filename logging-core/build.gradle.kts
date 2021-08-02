plugins {
    kotlin("multiplatform")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    jvm { library() }
    js(IR) { library() }
    nativeTargets(false)
}

aSoftOSSLibrary(
    version = vers.asoft.logging,
    description = "A multiplatform logging solution"
)