package logging

import logging.LogLevel

class ConsoleAppenderOptions(
    val level: LogLevel = LogLevel.DEBUG,
    val verbose: Boolean = true
)