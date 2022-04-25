package com.godbot.database.models

import com.andreapivetta.kolor.green
import com.andreapivetta.kolor.lightGray
import com.godbot.LoggingLevel
import com.godbot.getDate
import com.godbot.showId

class DefaultGroupLog(
    override val id: String,
    override val type: String,
    override val lvl: LoggingLevel,
    override val msg: String,
    val indents: Int = 0,
    override val childLogs: ArrayList<Log> = ArrayList(),
): GroupLogImpl(id, type, lvl, msg) {
    override fun toString(): String {
        var groupIndent = indents - 1
        if (groupIndent < 0)
            groupIndent = 0
        var standard = "  ".repeat(groupIndent) + "${getDate().lightGray()} | ${"New Group".green()} | $msg"
        if (showId)
            standard = "${id.lightGray()} | $standard"
        val msg = StringBuilder()
        for (log: Log in childLogs) {
            msg.append("\n$log")
        }
        return "$standard$msg"
    }

    override fun printToString() {
        println(this.toString())
    }
}
