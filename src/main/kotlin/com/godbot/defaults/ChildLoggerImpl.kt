package com.godbot.defaults

import com.godbot.ChildLogger
import com.godbot.Logger
import com.godbot.LoggingLevel
import com.godbot.database.models.LogImpl

open class ChildLoggerImpl(
    override val parentLogger: Logger,
): ChildLogger {

    override fun info(msg: String, lvl: LoggingLevel) {
        println("  " + LogImpl(getId(), "info", lvl, msg))
    }

    override fun warning(msg: String, lvl: LoggingLevel) {
        println("  " + LogImpl(getId(), "warning", lvl, msg))
    }

    override fun error(msg: String, lvl: LoggingLevel) {
        println("  " + LogImpl(getId(), "error", lvl, msg))
    }

    override fun fatal(msg: String, lvl: LoggingLevel) {
        println("  " + LogImpl(getId(), "fatal", lvl, msg))
    }
}