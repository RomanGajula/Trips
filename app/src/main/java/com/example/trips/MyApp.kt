package com.example.trips


import android.app.Application
import com.example.trips.detailsLocaties.koin.detailsAppModule
import com.example.trips.list.koin.appModule
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
            modules(listOf(appModule, detailsAppModule))
        }
        instance = this
    }
}