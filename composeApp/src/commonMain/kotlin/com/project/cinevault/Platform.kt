package com.project.cinevault

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform