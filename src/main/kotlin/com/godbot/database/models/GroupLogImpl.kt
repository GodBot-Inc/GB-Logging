package com.godbot.database.models

import com.godbot.LoggingLevel
import com.godbot.getDate
import com.godbot.resolveLoggingLvl
import com.godbot.resolveLoggingType

open class GroupLogImpl(
    override val id: String,
    override val type: String,
    override val lvl: LoggingLevel,
    override val msg: String,
    override val childLogs: ArrayList<Log> = ArrayList(),
): GroupLog {
    override fun toString(): String {
        val childLogStr = StringBuilder("Closest")
        for (log: Log in childLogs) {
            childLogStr.append("$log\n")
        }
        childLogStr.append("]")
        return "${getDate()} | $msg | ${resolveLoggingType(type)} | ${resolveLoggingLvl(lvl)} | $childLogStr"
    }
}
