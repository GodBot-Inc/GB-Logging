package com.godbot.defaults

import com.godbot.Logger
import com.godbot.LoggingLevel
import com.godbot.database.models.LogImpl
import com.godbot.lowestLoggingLevel

open class LoggerImpl: Logger {

    fun info(msg: String, lvl: LoggingLevel) {
        if (lvl >= lowestLoggingLevel)
            println(LogImpl(getId(), "info", lvl, msg))
    }

    override fun info(msg: String) {
        info(msg, LoggingLevel.HIGH)
    }

    fun warning(msg: String, lvl: LoggingLevel) {
        if (lvl >= lowestLoggingLevel)
            println(LogImpl(getId(), "warning", lvl, msg))
    }

    override fun warning(msg: String) {
        warning(msg, LoggingLevel.HIGH)
    }

    fun error(msg: String, lvl: LoggingLevel) {
        if (lvl >= lowestLoggingLevel)
            println(LogImpl(getId(), "error", lvl, msg))
    }
    override fun error(msg: String) {
        error(msg, LoggingLevel.HIGH)
    }

    fun fatal(msg: String, lvl: LoggingLevel) {
        if (lvl >= lowestLoggingLevel)
            println(LogImpl(getId(), "fatal", lvl, msg))
    }
    override fun fatal(msg: String) {
        fatal(msg, LoggingLevel.HIGH)
    }
}