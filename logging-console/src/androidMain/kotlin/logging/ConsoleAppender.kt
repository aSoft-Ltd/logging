package logging

import android.util.Log

actual class ConsoleAppender actual constructor(var options: ConsoleAppenderOptions) : Appender {
    override fun append(level: LogLevel, msg: String, vararg data: Pair<String, Any?>) {
        if (level >= options.level) {
            val printer: (String, String) -> Unit = when (level) {
                LogLevel.DEBUG -> { tag, txt -> Log.d(tag, txt) }
                LogLevel.INFO -> { tag, txt -> Log.i(tag, txt) }
                LogLevel.WARNING -> { tag, txt -> Log.w(tag, txt) }
                LogLevel.ERROR -> { tag, txt -> Log.e(tag, txt) }
                LogLevel.FAILURE -> { tag, txt -> Log.wtf(tag, txt) }
            }
            val src = data.toMap()["source"]?.toString() ?: "Unknown"
            printer(src, msg)
            if (options.verbose && data.isNotEmpty()) {
                printer(src, "= = = = = = = = = = = = D = A = T = A = = = = = = = = = = = =")
                data.forEach { printer(src, it.first + ": " + it.second) }
                printer(src, "= ".repeat(31))
            }
        }
    }

    override fun append(vararg o: Any?) = o.forEach { Log.i("anonymous", it.toString()) }
}