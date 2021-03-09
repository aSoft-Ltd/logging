package logging

fun ConsoleAppender(level: LogLevel = LogLevel.DEBUG, verbose: Boolean = true) = ConsoleAppender(
    ConsoleAppenderOptions(level, verbose)
)