package com.godbot.defaults

import com.andreapivetta.kolor.green
import com.andreapivetta.kolor.lightGray
import com.godbot.*
import com.godbot.database.models.DefaultGroupLog
import com.godbot.database.models.DefaultLog
import com.godbot.database.models.GroupLog

open class DefaultChildLogger(
    private val loggingLevel: LoggingLevel,
    private val indents: Int,
    override val groupLog: GroupLog
): ChildLogger {
    val childLoggers: ArrayList<DefaultChildLogger> = ArrayList()
    override var readyToClose = false

    open override fun info(msg: String) {
        if (collectedLogging)
            groupLog.childLogs.add(DefaultLog(getId(), "info", loggingLevel, msg, indents))
        else
            println(DefaultLog(getId(), "info", loggingLevel, msg, indents))
    }
    open override fun warning(msg: String) {
        if (collectedLogging)
            groupLog.childLogs.add(DefaultLog(getId(), "warning", loggingLevel, msg, indents))
        else
            println(DefaultLog(getId(), "warning", loggingLevel, msg, indents))
    }
    open override fun error(msg: String) {
        if (collectedLogging)
            groupLog.childLogs.add(DefaultLog(getId(), "error", loggingLevel, msg, indents))
        else
            println(DefaultLog(getId(), "error", loggingLevel, msg, indents))
    }
    open override fun fatal(msg: String) {
        if (collectedLogging)
            groupLog.childLogs.add(DefaultLog(getId(), "fatal", loggingLevel, msg, indents))
        else
            println(DefaultLog(getId(), "fatal", loggingLevel, msg, indents))
    }

    open override fun openGroup(
        groupTitle: String,
        lvl: LoggingLevel
    ): DefaultChildLogger {
        val groupId = getId()
        val holdingChildLogger = DefaultChildLogger(
            lvl,
            indents + 1,
            DefaultGroupLog(
                groupId,
                "newgroup",
                lvl,
                groupTitle
            )
        )

        if (!collectedLogging) {
            var standard = "${getDate().lightGray()} | ${"New Group".green()} | $groupTitle"
            if (showId)
                standard = "${groupId.lightGray()} | $standard"
            println("  ".repeat(indents) + standard)
        }

        childLoggers.add(holdingChildLogger)
        return holdingChildLogger
    }

    open override fun provideClosingMessage(): String {
        val msg = StringBuilder("$groupLog\n")
        for (logger: ChildLogger in childLoggers) {
            while (!logger.readyToClose) {
                Thread.sleep(100)
            }
            msg.append(logger.provideClosingMessage())
        }
        return msg.toString()
    }

    open override fun provideNonBlockingClosingMessage(): String {
        val msg = StringBuilder("$groupLog\n")
        for (logger: ChildLogger in childLoggers) {
            msg.append(logger.provideNonBlockingClosingMessage())
        }
        return msg.toString()
    }

    open override fun readyToClose() {
        readyToClose = true
    }
}
