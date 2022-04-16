package com.godbot

import com.godbot.database.models.GroupLog

interface ChildLogger: Logger {
    val parentLogger: Logger
    val groupLog: GroupLog
}