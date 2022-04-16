package com.godbot.database.models

import com.godbot.LoggingLevel

class DefaultLog(
    override val id: String,
    override val type: String,
    override val lvl: LoggingLevel,
    override val msg: String,
    private val indents: Int
): LogImpl(id, type, lvl, msg) {
    override fun toString(): String {
        val output = super.toString()
        return "  ".repeat(indents) + output
    }
}