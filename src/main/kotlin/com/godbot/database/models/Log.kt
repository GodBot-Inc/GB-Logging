package com.godbot.database.models

import com.godbot.LoggingLevel

interface Log {
    val id: String
    val type: String
    val lvl: LoggingLevel
    val msg: String

    override fun toString(): String
}