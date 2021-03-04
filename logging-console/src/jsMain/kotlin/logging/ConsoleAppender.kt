package logging

import kotlin.js.Console

actual class ConsoleAppender actual constructor(var options: ConsoleAppenderOptions) : Appender, Console by kotlin.js.console {
    override fun append(level: LogLevel, msg: String, vararg data: Pair<String, Any?>) {
        if (level >= options.level) {
            val printer: (Array<out Any?>) -> Unit = when (level) {
                LogLevel.INFO -> { ar -> kotlin.js.console.info(*ar) }
                LogLevel.DEBUG -> { ar -> kotlin.js.console.log(*ar) }
                LogLevel.WARNING -> { ar -> kotlin.js.console.warn(*ar) }
                LogLevel.ERROR -> { ar -> kotlin.js.console.error(*ar) }
                LogLevel.FAILURE -> { ar -> kotlin.js.console.error(*ar) }
            }

            if (options.verbose) {
                val args = mutableListOf<Any?>("${level.name}: $msg")
                data.forEach {
                    args += "\n${it.first}"
                    args += it.second
                }
                printer(args.toTypedArray())
            } else {
                printer(arrayOf("${level.name}: $msg"))
            }
        }
    }

    override fun append(vararg o: Any?) = kotlin.js.console.log(*o)

    fun table(obj: Any) = kotlin.js.console.asDynamic().table(obj)
}