package com.godbot.defaults

import com.andreapivetta.kolor.green
import com.andreapivetta.kolor.lightGray
import com.godbot.*
import com.godbot.database.models.DefaultGroupLog

open class DefaultLogger(
    private val defaultLoggingLevel: LoggingLevel = LoggingLevel.HIGH
): LoggerImpl() {
    protected val childLoggers: ArrayList<ChildLogger> = ArrayList()

    fun openGroup(
        groupTitle: String,
        lvl: LoggingLevel,
        ): DefaultChildLogger {
        val groupId = getId()
        val holdingChildLogger = DefaultChildLogger(
            lvl,
            1,
            DefaultGroupLog(
                groupId,
                "newgroup",
                lvl,
                groupTitle
            )
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

    fun nonBlockingCloseAllChildren() {
        val msg = StringBuilder()
        for (logger: ChildLogger in childLoggers) {
            msg.append(logger.provideClosingMessage())
        }
        print(msg)
    }

    fun closeAllChildren() {
        val msg = StringBuilder()
        for (logger: ChildLogger in childLoggers) {
            while (!logger.readyToClose) {
                Thread.sleep(1)
            }
            msg.append(logger.provideNonBlockingClosingMessage())
        }
        print(msg)
    }
}
