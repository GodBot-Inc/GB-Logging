
import com.andreapivetta.kolor.green
import com.andreapivetta.kolor.red
import com.andreapivetta.kolor.yellow
import java.util.*

interface Logger {
    fun getId() = UUID.randomUUID().toString()
    fun resolveLoggingLvl(lvl: LoggingLevel): String = when(lvl) {
        LoggingLevel.LOW -> "Low   ".red()
        LoggingLevel.MEDIUM -> "Medium".yellow()
        LoggingLevel.HIGH -> "High  ".green()
    }
    fun info(msg: String, lvl: LoggingLevel)
    fun warning(msg: String, lvl: LoggingLevel)
    fun error(msg: String, lvl: LoggingLevel)
}
