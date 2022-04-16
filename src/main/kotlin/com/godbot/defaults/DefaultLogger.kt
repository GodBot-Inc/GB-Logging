package com.godbot.defaults

import com.godbot.LoggingLevel
import com.godbot.database.models.DefaultGroupLog
import com.godbot.database.models.Log
import com.godbot.lowestLoggingLevel

open class DefaultLogger(
    private val defaultLoggingLevel: LoggingLevel = LoggingLevel.HIGH
): LoggerImpl() {
    protected var childLogs: DefaultGroupLog? = null
    protected var childLogger: DefaultChildLogger? = null

    override fun info(msg: String, lvl: LoggingLevel) {
        if (lvl >= lowestLoggingLevel)
            super.info(msg, lvl)
    }
    fun info(msg: String) = apply { info(msg, defaultLoggingLevel) }

    override fun warning(msg: String, lvl: LoggingLevel) {
        if (lvl >= lowestLoggingLevel)
            super.warning(msg, lvl)
    }
    fun warning(msg: String) = apply { warning(msg, defaultLoggingLevel) }

    override fun error(msg: String, lvl: LoggingLevel) {
        if (lvl >= lowestLoggingLevel)
            super.error(msg, lvl)
    }
    fun error(msg: String) = apply { error(msg, defaultLoggingLevel) }

    override fun fatal(msg: String, lvl: LoggingLevel) {
        if (lvl >= lowestLoggingLevel)
            super.fatal(msg, lvl)
    }
    fun fatal(msg: String) = apply { fatal(msg, defaultLoggingLevel) }

    fun saveLog(log: Log) {
        childLogs?.childLogs?.add(log)
    }

    fun openGroup(
        groupTitle: String,
        lvl: LoggingLevel = LoggingLevel.LOW,
        ): DefaultChildLogger {
        closeGroup()
        childLogger = DefaultChildLogger(this, lvl)
        val groupId = getId()
        childLogs = DefaultGroupLog(
            groupId,
            "newgroup",
            lvl,
            groupTitle,
        )

        return childLogger!!
    }

    fun closeGroup() {
        val msg = childLogs?.printWholeLog()
        if (msg != null)
            println(msg)
        childLogger = null
        childLogs = null
    }
}
