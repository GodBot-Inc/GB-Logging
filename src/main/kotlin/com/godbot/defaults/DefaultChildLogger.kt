package com.godbot.defaults

import com.godbot.LoggingLevel
import com.godbot.collectiveLogging
import com.godbot.database.models.DefaultLog
import com.godbot.lowestLoggingLevel

class DefaultChildLogger(
    override val parentLogger: DefaultLogger,
    private val loggingLevel: LoggingLevel
) : ChildLoggerImpl(parentLogger) {
    fun info(msg: String) {
        if (!collectiveLogging && loggingLevel >= lowestLoggingLevel)
            super.info(msg, loggingLevel)
        else if (collectiveLogging && loggingLevel >= lowestLoggingLevel)
            parentLogger.saveLog(this, DefaultLog(getId(), "info", loggingLevel, msg, 1))
    }
    fun warning(msg: String) {
        if (!collectiveLogging && loggingLevel >= lowestLoggingLevel)
            super.warning(msg, loggingLevel)
        else if (collectiveLogging && loggingLevel >= lowestLoggingLevel)
            parentLogger.saveLog(this, DefaultLog(getId(), "warning", loggingLevel, msg, 1))
    }
    fun error(msg: String) {
        if (!collectiveLogging && loggingLevel >= lowestLoggingLevel)
            super.error(msg, loggingLevel)
        else if (collectiveLogging && loggingLevel >= lowestLoggingLevel)
            parentLogger.saveLog(this, DefaultLog(getId(), "error", loggingLevel, msg, 1))
    }
    fun fatal(msg: String) {
        if (!collectiveLogging && loggingLevel >= lowestLoggingLevel)
            super.fatal(msg, loggingLevel)
        else if (collectiveLogging && loggingLevel >= lowestLoggingLevel)
            parentLogger.saveLog(this, DefaultLog(getId(), "fatal", loggingLevel, msg, 1))
    }
}
