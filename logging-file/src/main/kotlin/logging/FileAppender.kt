package logging

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import java.io.File

class FileAppender(var options: FileAppenderOptions) : Appender {
    init {
        options.rootDir.also { if (!it.exists()) it.mkdirs() }
    }

    private val now get() = Clock.System.now().toLocalDateTime(TimeZone.UTC)

    private val dir get() = File(options.rootDir, now.toDirFormat()).also { if (!it.exists()) it.mkdirs() }

    private val file get() = File(dir, now.hour.to2digits() + ".log").also { if (!it.exists()) it.createNewFile() }

    private fun Int.to2digits() = if (this <= 9) "0$this" else "$this"

    private fun LocalDateTime.toDirFormat() = "$year/${monthNumber.to2digits()}/${dayOfMonth.to2digits()}"

    override fun append(level: LogLevel, msg: String, vararg data: Pair<String, Any?>) {
        if (level > options.level) file.apply {
            appendText("---->\n")
            appendText("${level.name}: $msg\n")
            data.forEach {
                appendText("${it.first}: ${it.second.toString()}\n")
            }
        }
    }

    override fun append(vararg o: Any?) = o.forEach { append(LogLevel.DEBUG, msg = it.toString()) }
}