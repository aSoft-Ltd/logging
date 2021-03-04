plugins {
    kotlin("multiplatform")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    multiplatformLib()
}

aSoftOSSLibrary(
    version = vers.asoft.logging,
    description = "A multiplatform logging solution"
)