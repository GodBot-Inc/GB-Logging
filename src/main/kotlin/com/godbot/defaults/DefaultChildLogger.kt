package com.godbot.defaults

import com.godbot.Logger
import com.godbot.LoggingLevel

class DefaultChildLogger(
    override val parentLogger: Logger,
    private val loggingLevel: LoggingLevel
) : ChildLoggerImpl(parentLogger) {
    fun info(msg: String) = apply { super.info(msg, loggingLevel) }
    fun warning(msg: String) = apply { super.warning(msg, loggingLevel) }
    fun error(msg: String) = apply { super.error(msg, loggingLevel) }
    fun fatal(msg: String) = apply { super.fatal(msg, loggingLevel) }
}
