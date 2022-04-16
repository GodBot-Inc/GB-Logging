package com.godbot

import com.andreapivetta.kolor.*
import com.godbot.database.models.GroupLog
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun resolveLoggingLvl(lvl: LoggingLevel): String {
    return when(lvl) {
        LoggingLevel.LOW -> "Low   ".red()
        LoggingLevel.MEDIUM -> "Medium".yellow()
        LoggingLevel.HIGH -> "High  ".green()
    }
}

fun resolveLoggingType(type: String): String {
    return when(type) {
        "info" -> "Info     ".blue()
        "warning" -> "Warning  ".yellow()
        "error" -> "Error    ".lightRed()
        "fatal" -> "FATAL    ".red()
        "newgroup" -> "New Group".green()
        else -> "unknown  "
    }
}

fun getDate(): String {
    val current = LocalDateTime.now()
    val format = when(timeFormatLanguage) {
        Languages.DE -> "dd.MM HH:mm:ss"
        Languages.US -> "MM.dd HH:mm:ss"
    }
    return DateTimeFormatter.ofPattern(format).format(current)
}

fun formatStackLog(logs: List<GroupLog>) {

}
