package defaults

import ChildLogger
import Logger
import LoggingLevel
import com.andreapivetta.kolor.blue
import com.andreapivetta.kolor.green
import com.andreapivetta.kolor.red
import com.andreapivetta.kolor.yellow

class DefaultLogger : Logger {
    override fun info(msg: String, lvl: LoggingLevel) {
        val info = "Info".blue()
        println("$info      | ${resolveLoggingLvl(lvl)} | $msg | ${getId()}")
    }

    override fun warning(msg: String, lvl: LoggingLevel) {
        val warning = "Warning".yellow()
        println("$warning   | ${resolveLoggingLvl(lvl)} | $msg | ${getId()}")
    }

    override fun error(msg: String, lvl: LoggingLevel) {
        val error = "Error".red()
        println("$error     | ${resolveLoggingLvl(lvl)} | $msg | ${getId()}")
    }

    fun openGroup(operationTitle: String, lvl: LoggingLevel): ChildLogger {
        val newGroup = "New Group".green()
        val groupId = getId()
        println("$newGroup | ${resolveLoggingLvl(lvl)} | $operationTitle | $groupId")
        return DefaultChildLogger(groupId)
    }
}
