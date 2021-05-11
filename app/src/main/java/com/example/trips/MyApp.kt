package com.example.trips


import android.app.Application
import com.example.trips.Lists.koin.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MyApp : Application() {
    companion object {
        var instance: MyApp? = null
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(appModule))
        }
        instance = this
    }
}