package logging

actual class ConsoleAppender actual constructor(var options: ConsoleAppenderOptions) : Appender {
    override fun append(level: LogLevel, msg: String, vararg data: Pair<String, Any?>) {
        if (level >= options.level) {
            if (options.verbose) {
                println("\n" + "= ".repeat(31))
                println("${level.name}: $msg")
                data.forEach {
                    println("${it.first}: ${it.second}")
                }
                println("= ".repeat(31))
            } else {
                println("${level.name}: $msg")
            }
        }
    }

    override fun append(vararg o: Any?) = o.forEach { println(it) }
}