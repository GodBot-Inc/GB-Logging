import defaults.DefaultLogger

fun main() {
    val logger = DefaultLogger()
    logger.info("Hello Test", LoggingLevel.LOW)
    logger.warning("Hello Warning", LoggingLevel.MEDIUM)
    logger.error("Hello Error", LoggingLevel.HIGH)
    logger.openGroup("Play Command", LoggingLevel.HIGH).info("Group Test", LoggingLevel.MEDIUM)
}
