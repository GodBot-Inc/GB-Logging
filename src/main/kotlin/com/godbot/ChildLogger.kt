package com.godbot

import com.godbot.database.models.GroupLog

interface ChildLogger: Logger {
    val groupLog: GroupLog
    var readyToClose: Boolean
    fun openGroup(groupTitle: String, lvl: LoggingLevel = LoggingLevel.LOW): ChildLogger
    fun provideClosingMessage(): String
    fun provideNonBlockingClosingMessage(): String
    fun readyToClose()
}
