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
    override val childLogs: ArrayList<Log> = ArrayList(),
): GroupLogImpl(id, type, lvl, msg) {
    fun printWholeLog() {
        var standard = "${getDate().lightGray()} | ${"New Group".green()} | $msg"
        if (showId)
            standard = "${id.lightGray()} | $standard"
        val msg = StringBuilder()
        for (log: Log in childLogs) {
            msg.append("\n$log")
        }
        println("$standard$msg")
    }

    fun printChildLogs() {
        val msg = StringBuilder()
        for(log: Log in childLogs) {
            msg.append(log.toString() + "\n")
        }
        println(msg)
    }
}
