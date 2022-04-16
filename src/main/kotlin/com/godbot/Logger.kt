package com.godbot
import java.util.*

interface Logger {
    fun getId() = UUID.randomUUID().toString()
    fun info(msg: String)
    fun warning(msg: String)
    fun error(msg: String)
    fun fatal(msg: String)
}
