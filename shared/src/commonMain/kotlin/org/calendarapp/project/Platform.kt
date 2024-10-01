package org.calendarapp.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform