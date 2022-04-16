package com.godbot.defaults

import com.godbot.ChildLogger
import com.godbot.Logger
import com.godbot.LoggingLevel
import com.godbot.database.models.DefaultLog

open class ChildLoggerImpl(
    override val parentLogger: Logger,
): ChildLogger {

    override fun info(msg: String, lvl: LoggingLevel) {
        println(DefaultLog(getId(), "info", lvl, msg, 1))
    }

    override fun warning(msg: String, lvl: LoggingLevel) {
        println(DefaultLog(getId(), "warning", lvl, msg, 1))
    }

    override fun error(msg: String, lvl: LoggingLevel) {
        println(DefaultLog(getId(), "error", lvl, msg, 1))
    }

    override fun fatal(msg: String, lvl: LoggingLevel) {
        println(DefaultLog(getId(), "fatal", lvl, msg, 1))
    }
}