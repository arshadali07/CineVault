package com.project.core.data

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform