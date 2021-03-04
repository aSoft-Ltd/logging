package logging

fun Appender.log(vararg o: Any?) = obj(*o)
fun Appender.log(msg: String, vararg data: Pair<String, Any?>) = append(level = LogLevel.DEBUG, msg = msg, data = *data)
fun Appender.debug(msg: String, vararg data: Pair<String, Any?>) = append(level = LogLevel.DEBUG, msg = msg, data = *data)
fun Appender.info(msg: String, vararg data: Pair<String, Any?>) = append(level = LogLevel.INFO, msg = msg, data = *data)
fun Appender.warn(msg: String, vararg data: Pair<String, Any?>) = append(level = LogLevel.WARNING, msg = msg, data = *data)
fun Appender.error(msg: String, c: Throwable?, vararg data: Pair<String, Any?>) = append(level = LogLevel.ERROR, msg = msg, data = *data)
fun Appender.error(msg: String, vararg data: Pair<String, Any?>) = append(level = LogLevel.ERROR, msg = msg, data = *data)
fun Appender.error(c: Throwable?) = error(c?.message ?: "Unknown Error", c)
fun Appender.failure(msg: String, c: Throwable?, vararg data: Pair<String, Any?>) = append(level = LogLevel.FAILURE, msg = msg, data = *data)
fun Appender.failure(msg: String, vararg data: Pair<String, Any?>) = append(level = LogLevel.FAILURE, msg = msg, data = *data)
fun Appender.failure(c: Throwable?) = failure(c?.message ?: "Unknown Error", c)
fun Appender.obj(vararg obj: Any?) = append(*obj)