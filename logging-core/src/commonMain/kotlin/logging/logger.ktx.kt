package logging

inline fun <reified T> T.logger(source: String = T::class.simpleName ?: "anonymous") = Logger.of(source)