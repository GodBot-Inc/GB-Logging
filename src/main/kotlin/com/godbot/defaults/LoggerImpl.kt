package com.godbot.defaults

import com.andreapivetta.kolor.green
import com.godbot.ChildLogger
import com.godbot.Logger
import com.godbot.LoggingLevel
import com.godbot.database.models.LogImpl
import com.godbot.resolveLoggingLvl

open class LoggerImpl : Logger {
    protected val newGroup = "New Group".green()

    override fun info(msg: String, lvl: LoggingLevel) {
        println(LogImpl(getId(), "info", lvl, msg).toString())
    }

    override fun warning(msg: String, lvl: LoggingLevel) {
        println(LogImpl(getId(), "warning", lvl, msg).toString())
    }

    override fun error(msg: String, lvl: LoggingLevel) {
        println(LogImpl(getId(), "error", lvl, msg).toString())
    }

    open fun openGroup(operationTitle: String, lvl: LoggingLevel): ChildLogger {
        val groupId = getId()
        println("$newGroup | ${resolveLoggingLvl(lvl)} | $operationTitle | $groupId")
        return ChildLoggerImpl(groupId)
    }
}
