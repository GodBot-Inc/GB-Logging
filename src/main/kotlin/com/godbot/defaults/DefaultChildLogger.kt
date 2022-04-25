package com.godbot.defaults

import com.andreapivetta.kolor.green
import com.andreapivetta.kolor.lightGray
import com.godbot.*
import com.godbot.database.models.DefaultGroupLog
import com.godbot.database.models.DefaultLog
import com.godbot.database.models.GroupLog

class DefaultChildLogger(
    private val loggingLevel: LoggingLevel,
    private val indents: Int,
    override val groupLog: GroupLog
): ChildLogger {
    protected val childLoggers: ArrayList<ChildLogger> = ArrayList()
    override var readyToClose = false

    private fun checkSend(type: String, msg: String) {
        if (loggingLevel >= lowestLoggingLevel) {
            if (collectiveLogging)
                groupLog.childLogs.add(DefaultLog(getId(), type, loggingLevel, msg, indents))
            else
                println(DefaultLog(getId(), type, loggingLevel, msg, indents))
        }
    }

    override fun info(msg: String) = checkSend("info", msg)

    override fun warning(msg: String) = checkSend("warning", msg)

    override fun error(msg: String) = checkSend("error", msg)

    override fun fatal(msg: String) = checkSend("fatal", msg)

    override fun openGroup(
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
                groupTitle,
                indents + 1
            )
        )

        if (!collectiveLogging) {
            var standard = "${getDate().lightGray()} | ${"New Group".green()} | ${resolveLoggingLvl(lvl)} | $groupTitle"
            if (showId)
                standard = "${groupId.lightGray()} | $standard"
            println("  ".repeat(indents) + standard)
        }

        childLoggers.add(holdingChildLogger)
        return holdingChildLogger
    }

    override fun provideClosingMessage(): String {
        val msg = StringBuilder("$groupLog\n")
        for (logger: ChildLogger in childLoggers) {
            while (!logger.readyToClose) {
                Thread.sleep(1)
            }
            msg.append(logger.provideClosingMessage())
        }
        return msg.toString()
    }

    override fun provideNonBlockingClosingMessage(): String {
        val msg = StringBuilder("$groupLog\n")
        for (logger: ChildLogger in childLoggers) {
            msg.append(logger.provideNonBlockingClosingMessage())
        }
        return msg.toString()
    }

    override fun readyToClose() {
        readyToClose = true
    }
}
