package com.godbot.database.models

import com.andreapivetta.kolor.lightGray
import com.godbot.*

open class LogImpl(
    override val id: String,
    override val type: String,
    override val lvl: LoggingLevel,
    override val msg: String
): Log {
    override fun toString(): String {
        var standard = "${getDate().lightGray()} | ${resolveLoggingType(type)} | ${resolveLoggingLvl(lvl)} | $msg"
        if (showId)
            standard = id.lightGray() + " | " + standard
        return standard
    }
}
