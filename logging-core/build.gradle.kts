plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    universalLib()
}

aSoftLibrary(
    version = vers.asoft.logging,
    description = "A multiplatfrom logging solution"
)