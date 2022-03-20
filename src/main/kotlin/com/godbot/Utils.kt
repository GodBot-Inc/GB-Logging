package com.godbot

import com.andreapivetta.kolor.green
import com.andreapivetta.kolor.red
import com.andreapivetta.kolor.yellow

fun resolveLoggingLvl(lvl: LoggingLevel): String {
    return when(lvl) {
        LoggingLevel.LOW -> "Low   ".red()
        LoggingLevel.MEDIUM -> "Medium".yellow()
        LoggingLevel.HIGH -> "High  ".green()
    }
}