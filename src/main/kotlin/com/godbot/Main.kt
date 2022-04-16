package com.godbot

import com.godbot.defaults.DefaultLogger

fun main() {
    val logger = DefaultLogger()
    logger.info("test")
    logger.warning("warning test")
    logger.error("error test")
    logger.fatal("fatal test")
    val firstChildLogger = logger.openGroup("Test Group", LoggingLevel.MEDIUM)
    firstChildLogger.info("Info Test")
    firstChildLogger.readyToClose()
    logger.closeAllChildren()
    val firstFirstChildLogger = firstChildLogger.openGroup("Test Test Group", LoggingLevel.LOW)
    firstFirstChildLogger.info("Info Test")
    firstFirstChildLogger.readyToClose()
}
