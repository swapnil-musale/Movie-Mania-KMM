package com.example.moviemania

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform