package com.godbot.database.models

import com.godbot.LoggingLevel
import com.godbot.getDate
import com.godbot.resolveLoggingLvl
import com.godbot.resolveLoggingType

open class LogImpl(
    override val id: String,
    override val type: String,
    override val lvl: LoggingLevel,
    override val msg: String
): Log {
    override fun toString(): String {
        val type = resolveLoggingType(type)

        return "${getDate()} | $type | ${resolveLoggingLvl(lvl)} | $msg | $id"
    }
}