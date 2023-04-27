package com.example.moviemania.android

import android.app.Application
import com.example.moviemania.android.di.appModule
import com.example.moviemania.di.getSharedModule
import org.koin.core.context.startKoin

class MovieManiaApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule + getSharedModule())
        }
    }
}
