package com.godbot.defaults

import com.godbot.Logger
import com.godbot.LoggingLevel
import com.godbot.database.models.LogImpl
import com.godbot.lowestLoggingLevel

open class LoggerImpl: Logger {

    private fun checkSend(type: String, msg: String, lvl: LoggingLevel) {
        if (lvl >= lowestLoggingLevel)
            println(LogImpl(getId(), type, lvl, msg))
    }
    fun info(msg: String, lvl: LoggingLevel) = checkSend("info", msg, lvl)
    override fun info(msg: String) = info(msg, LoggingLevel.HIGH)

    fun warning(msg: String, lvl: LoggingLevel) = checkSend("warning", msg, lvl)
    override fun warning(msg: String) = warning(msg, LoggingLevel.HIGH)

    fun error(msg: String, lvl: LoggingLevel) = checkSend("error", msg, lvl)
    override fun error(msg: String) = error(msg, LoggingLevel.HIGH)

    fun fatal(msg: String, lvl: LoggingLevel) = checkSend("fatal", msg, lvl)
    override fun fatal(msg: String) = fatal(msg, LoggingLevel.HIGH)
}
