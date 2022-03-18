package defaults

import ChildLogger
import LoggingLevel
import com.andreapivetta.kolor.blue
import com.andreapivetta.kolor.lightRed
import com.andreapivetta.kolor.red

class DefaultChildLogger(override val groupId: String) : ChildLogger {
    private val tab = "    "
    override fun info(msg: String, lvl: LoggingLevel) {
        val info = "Info".blue()
        println("$tab$info     | ${resolveLoggingLvl(lvl)} | $msg | ${getId()} | $groupId")
    }

    override fun warning(msg: String, lvl: LoggingLevel) {
        val warning = "Warning".lightRed()
        println("$tab$warning     | ${resolveLoggingLvl(lvl)} | $msg | ${getId()} | $groupId")
    }

    override fun error(msg: String, lvl: LoggingLevel) {
        val error = "Error".red()
        println("$tab$error     | ${resolveLoggingLvl(lvl)} | $msg | ${getId()} | $groupId")
    }
}
