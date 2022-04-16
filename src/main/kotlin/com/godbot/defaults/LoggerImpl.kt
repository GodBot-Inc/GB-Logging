package com.godbot.defaults

import com.godbot.Logger
import com.godbot.LoggingLevel
import com.godbot.database.models.LogImpl
import com.godbot.lowestLoggingLevel

open class LoggerImpl: Logger {
    override fun info(msg: String, lvl: LoggingLevel) {
        if (lvl >= lowestLoggingLevel)
            println(LogImpl(getId(), "info", lvl, msg))
    }

    override fun warning(msg: String, lvl: LoggingLevel) {
        if (lvl >= lowestLoggingLevel)
            println(LogImpl(getId(), "warning", lvl, msg))
    }

    override fun error(msg: String, lvl: LoggingLevel) {
        if (lvl >= lowestLoggingLevel)
            println(LogImpl(getId(), "error", lvl, msg))
    }

    override fun fatal(msg: String, lvl: LoggingLevel) {
        if (lvl >= lowestLoggingLevel)
            println(LogImpl(getId(), "fatal", lvl, msg))
    }
}