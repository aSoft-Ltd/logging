import logging.*
import tz.co.asoft.*
import kotlin.test.Test

class ConsoleAppenderTest {
    @Test
    fun `api should look good`() {
        logging.console.info("Testing again", "first" to 1, "second" to 2)
        logging.console.error("This is a test error", "correct" to false)
    }

    @Test
    fun `should be able to take the logger of test class`() {
        val logger = logger()
        logger.debug("Debug test")
        logger.info("Info test")
        logger.warn("Warning test")
        logger.error("Error test")
        logger.failure("Failure test")
    }

    @Test
    fun `should print less verbose errors`() {
        val logger = ConsoleAppender(verbose = false)
        logger.debug("Debug test")
        logger.info("Info test")
        logger.warn("Warning test")
        logger.error("Error test")
        logger.failure("Failure test")
    }

    @Test
    fun `should print by levels`() {
        val logger = ConsoleAppender(level = LogLevel.ERROR)
        logger.debug("Debug test")
        logger.info("Info test")
        logger.warn("Warning test")
        logger.error("Error test")
        logger.failure("Failure test")
    }
}