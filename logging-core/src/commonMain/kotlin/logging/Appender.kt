package logging

interface Appender {
    fun append(level: LogLevel, msg: String, vararg data: Pair<String, Any?>)
    fun append(vararg o: Any?)
}