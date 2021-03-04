package logging

import java.io.File

class FileAppenderOptions(
    val rootDir: File,
    val level: LogLevel = LogLevel.DEBUG
)