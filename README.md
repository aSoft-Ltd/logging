# Logging

![badge][badge-maven] ![badge][badge-mpp] ![badge][badge-android] ![badge][badge-js] ![badge][badge-jvm]

A kotlin multiplatform solution to logging

## Setup : Gradle

```kotlin
dependencies {
    implementation("tz.co.asoft:logging-console:0.0.21")
}
```

## Sample

```kotlin
Logging.init(ConsoleApender()) // Add an appender

val logger = logger()

logger.debug("Test Debug")
logger.info("Test Info")
logger.error("Test Error")
logger.failure("Test Failure")
```

[badge-maven]: https://img.shields.io/maven-central/v/tz.co.asoft/logging-core/0.0.21?style=flat

[badge-mpp]: https://img.shields.io/badge/kotlin-multiplatform-blue?style=flat

[badge-android]: http://img.shields.io/badge/platform-android-brightgreen.svg?style=flat

[badge-js]: http://img.shields.io/badge/platform-js-yellow.svg?style=flat

[badge-jvm]: http://img.shields.io/badge/platform-jvm-orange.svg?style=flat
