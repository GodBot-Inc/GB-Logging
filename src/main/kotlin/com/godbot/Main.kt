package com.godbot

import com.godbot.defaults.LoggerImpl

fun main() {
    val logger = LoggerImpl()
    logger.info("Hello Test", LoggingLevel.LOW)
    logger.warning("Hello Warning", LoggingLevel.MEDIUM)
    logger.error("Hello Error", LoggingLevel.HIGH)
}
