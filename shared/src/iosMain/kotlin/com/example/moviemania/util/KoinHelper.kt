package com.example.moviemania.util

import com.example.moviemania.di.getSharedModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(getSharedModule())
    }
}
