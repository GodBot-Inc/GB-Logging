package com.godbot.database.models

import com.andreapivetta.kolor.blue
import com.andreapivetta.kolor.lightGray
import com.andreapivetta.kolor.red
import com.andreapivetta.kolor.yellow
import com.godbot.LoggingLevel
import com.godbot.resolveLoggingLvl

open class LogImpl(
    override val id: String,
    override val type: String,
    override val lvl: LoggingLevel,
    override val msg: String
): Log {
    override fun toString(): String {
        val type = when(type) {
            "info" -> "Info     ".blue()
            "warning" -> "Warning  ".yellow()
            "error" -> "Error    ".red()
            else -> "unknown  ".lightGray()
        }

        return "$type | ${resolveLoggingLvl(lvl)} | $msg | $id"
    }
}