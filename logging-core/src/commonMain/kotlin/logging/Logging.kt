package logging

object Logging {
    internal val appenders = mutableListOf<Appender>()
    fun init(vararg appender: Appender) {
        appenders.addAll(appender)
    }
}