package logging

interface Appender {
    fun append(level: LogLevel, msg: String, vararg data: Pair<String, Any?>)
    fun append(vararg o: Any?)

    fun log(vararg o: Any?) = obj(*o)
    fun log(msg: String, vararg data: Pair<String, Any?>) =
        append(level = LogLevel.DEBUG, msg = msg, data = *data)

    fun debug(msg: String, vararg data: Pair<String, Any?>) =
        append(level = LogLevel.DEBUG, msg = msg, data = *data)

    fun info(msg: String, vararg data: Pair<String, Any?>) =
        append(level = LogLevel.INFO, msg = msg, data = *data)

    fun warn(msg: String, vararg data: Pair<String, Any?>) =
        append(level = LogLevel.WARNING, msg = msg, data = *data)

    fun error(msg: String, c: Throwable?, vararg data: Pair<String, Any?>) =
        append(level = LogLevel.ERROR, msg = msg, data = *data)

    fun error(msg: String, vararg data: Pair<String, Any?>) =
        append(level = LogLevel.ERROR, msg = msg, data = *data)

    fun error(c: Throwable?) = error(c?.message ?: "Unknown Error", c)
    fun failure(msg: String, c: Throwable?, vararg data: Pair<String, Any?>) =
        append(level = LogLevel.FAILURE, msg = msg, data = *data)

    fun failure(msg: String, vararg data: Pair<String, Any?>) =
        append(level = LogLevel.FAILURE, msg = msg, data = *data)

    fun failure(c: Throwable?) = failure(c?.message ?: "Unknown Error", c)
    fun obj(vararg obj: Any?) = append(*obj)
}