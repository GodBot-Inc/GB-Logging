package com.godbot.defaults

import com.godbot.LoggingException
import com.godbot.LoggingLevel
import com.godbot.database.LoggerDBC
import com.godbot.database.models.Log
import com.godbot.database.models.LogImpl
import com.godbot.resolveLoggingLvl

open class DefaultDBLogger(private val dbc: LoggerDBC): LoggerImpl() {
    private var currentChildLogger: DefaultChildDBLogger? = null
    private val childLogSaves = ArrayList<Log>()
    private var operationTitle: String = ""


    override fun info(msg: String, lvl: LoggingLevel) {
        val log = LogImpl(getId(), "info", lvl, msg)
        println(log.toString())
        dbc.saveLog(log)
    }

    override fun warning(msg: String, lvl: LoggingLevel) {
        val log = LogImpl(getId(), "warning", lvl, msg)
        println(log.toString())
        dbc.saveLog(log)
    }

    override fun error(msg: String, lvl: LoggingLevel) {
        val log = LogImpl(getId(), "error", lvl, msg)
        println(log.toString())
        dbc.saveLog(log)
    }

    override fun openGroup(operationTitle: String, lvl: LoggingLevel): DefaultChildDBLogger {
        childLogSaves.clear()
        val groupId = getId()
        this.operationTitle = operationTitle
        println("$newGroup | ${resolveLoggingLvl(lvl)} | $operationTitle | $groupId")
        val defaultChildLogger = DefaultChildDBLogger(groupId, this)
        currentChildLogger = defaultChildLogger
        return defaultChildLogger
    }

    fun save(log: Log) {
        childLogSaves.add(log)
    }

    fun closeGroup(logger: DefaultChildDBLogger) {
        if (logger != currentChildLogger) {
            throw LoggingException()
        }
        currentChildLogger = null
        // Save Log to DB
    }
}