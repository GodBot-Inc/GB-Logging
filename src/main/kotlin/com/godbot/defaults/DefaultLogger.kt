package com.godbot.defaults

import com.andreapivetta.kolor.green
import com.andreapivetta.kolor.lightGray
import com.godbot.*
import com.godbot.database.models.DefaultGroupLog
import com.godbot.database.models.Log

open class DefaultLogger(
    private val defaultLoggingLevel: LoggingLevel = LoggingLevel.HIGH
): LoggerImpl() {
    protected val childLoggers: ArrayList<DefaultChildLogger> = ArrayList()
    protected val childLogs: HashMap<DefaultChildLogger, DefaultGroupLog> = HashMap()

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

    fun saveLog(logger: Logger, log: Log) {
        childLogs[logger]?.childLogs?.add(log)
    }

    fun openGroup(
        groupTitle: String,
        lvl: LoggingLevel = LoggingLevel.LOW,
        ): DefaultChildLogger {
        val groupId = getId()
        val holdingChildLogger = DefaultChildLogger(this, lvl)

        childLogs[holdingChildLogger] = DefaultGroupLog(
            groupId,
            "newgroup",
            lvl,
            groupTitle
        )

        if (!collectiveLogging) {
            var standard = "${getDate().lightGray()} | ${"New Group".green()} | $groupTitle"
            if (showId)
                standard = "${groupId.lightGray()} | $standard"
            println(standard)
        }

        childLoggers.add(holdingChildLogger)
        return holdingChildLogger
    }

    fun closeGroup(logger: Logger) {
        childLoggers.remove(logger)
        if (collectiveLogging)
            childLogs[logger]?.printWholeLog()
    }
}
