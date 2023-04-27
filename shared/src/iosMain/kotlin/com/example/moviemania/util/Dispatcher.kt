package com.example.moviemania.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal class iOSDispatcher : Dispatcher {
    override val io: CoroutineDispatcher
        get() = Dispatchers.Default
}

internal actual fun provideDispatcher(): Dispatcher = iOSDispatcher()
