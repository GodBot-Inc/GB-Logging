package com.godbot

interface ChildLogger: Logger {
    val parentLogger: Logger
}