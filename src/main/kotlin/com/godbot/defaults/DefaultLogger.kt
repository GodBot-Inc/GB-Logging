package com.godbot.defaults

import com.andreapivetta.kolor.green
import com.andreapivetta.kolor.lightGray
import com.godbot.LoggingLevel
import com.godbot.database.models.GroupLog
import com.godbot.database.models.GroupLogImpl
import com.godbot.getDate
import com.godbot.lowestLoggingLevel
import com.godbot.showId

open class DefaultLogger(
    private val defaultLoggingLevel: LoggingLevel = LoggingLevel.HIGH
): LoggerImpl() {
    protected var childLogs: GroupLog? = null
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

    fun openGroup(
        groupTitle: String,
        lvl: LoggingLevel = LoggingLevel.LOW,
        ): DefaultChildLogger {
        childLogger = DefaultChildLogger(this, lvl)
        val groupId = getId()
        childLogs = GroupLogImpl(
            groupId,
            "newgroup",
            lvl,
            groupTitle,
        )

        var standard = "${getDate().lightGray()} | ${"New Group".green()} | $groupTitle"
        if (showId)
            standard = groupId.lightGray() + " | " + standard
        println(standard)

        return childLogger!!
    }
}
