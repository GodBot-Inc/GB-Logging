package com.godbot.defaults

import com.godbot.Logger
import com.godbot.LoggingLevel
import com.godbot.lowestLoggingLevel

class DefaultChildLogger(
    override val parentLogger: Logger,
    private val loggingLevel: LoggingLevel
) : ChildLoggerImpl(parentLogger) {
    fun info(msg: String) {
        if (loggingLevel >= lowestLoggingLevel)
            super.info(msg, loggingLevel)
    }
    fun warning(msg: String) {
        if (loggingLevel >= lowestLoggingLevel)
            super.warning(msg, loggingLevel)
    }
    fun error(msg: String) {
        if (loggingLevel >= lowestLoggingLevel)
            super.error(msg, loggingLevel)
    }
    fun fatal(msg: String) {
        if (loggingLevel >= lowestLoggingLevel)
            super.fatal(msg, loggingLevel)
    }
}
