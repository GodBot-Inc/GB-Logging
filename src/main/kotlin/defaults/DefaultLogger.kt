package defaults

import Logger
import LoggingLevel
import com.andreapivetta.kolor.blue
import com.andreapivetta.kolor.lightRed
import com.andreapivetta.kolor.red

class DefaultLogger : Logger {
    override fun info(msg: String, lvl: LoggingLevel) {
        val info = "Info".blue()
        println("${getId()} | $info    | ${resolveLoggingLvl(lvl)}")
    }

    override fun warning(msg: String, lvl: LoggingLevel) {
        val warning = "Warning".lightRed()
        println("${getId()} | $warning | ${resolveLoggingLvl(lvl)}")
    }

    override fun error(msg: String, lvl: LoggingLevel) {
        val error = "Error".red()
        println("${getId()} | $error   | ${resolveLoggingLvl(lvl)}")
    }
}
