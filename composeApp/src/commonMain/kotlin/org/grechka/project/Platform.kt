package org.grechka.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform