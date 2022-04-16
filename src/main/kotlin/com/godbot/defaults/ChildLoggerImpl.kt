package com.godbot.defaults

import com.godbot.*
import com.godbot.database.models.DefaultLog
import com.godbot.database.models.GroupLog

open class ChildLoggerImpl(
    override val parentLogger: Logger,
    override val groupLog: GroupLog
): ChildLogger {

    override fun info(msg: String, lvl: LoggingLevel) {
        if (!collectiveLogging && lvl >= lowestLoggingLevel)
            println(DefaultLog(getId(), "info", lvl, msg, 1))
        else if (collectiveLogging && lvl >= lowestLoggingLevel)
            groupLog.childLogs.add(DefaultLog(getId(), "info", lvl, msg, 1))
    }

    override fun warning(msg: String, lvl: LoggingLevel) {
        if (!collectiveLogging && lvl >= lowestLoggingLevel)
            println(DefaultLog(getId(), "warning", lvl, msg, 1))
        else if (collectiveLogging && lvl >= lowestLoggingLevel)
            groupLog.childLogs.add(DefaultLog(getId(), "warning", lvl, msg, 1))
    }

    override fun error(msg: String, lvl: LoggingLevel) {
        if (!collectiveLogging && lvl >= lowestLoggingLevel)
            println(DefaultLog(getId(), "error", lvl, msg, 1))
        else if (collectiveLogging && lvl >= lowestLoggingLevel)
            groupLog.childLogs.add(DefaultLog(getId(), "error", lvl, msg, 1))
    }

    override fun fatal(msg: String, lvl: LoggingLevel) {
        if (!collectiveLogging && lvl >= lowestLoggingLevel)
            println(DefaultLog(getId(), "fatal", lvl, msg, 1))
        else if (collectiveLogging && lvl >= lowestLoggingLevel)
            groupLog.childLogs.add(DefaultLog(getId(), "fatal", lvl, msg, 1))
    }
}