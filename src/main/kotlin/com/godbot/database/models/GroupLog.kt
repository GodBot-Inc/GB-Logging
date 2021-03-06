package com.godbot.database.models

interface GroupLog: Log {
    val childLogs: ArrayList<Log>
        get() = ArrayList()

    fun printToString()
}
