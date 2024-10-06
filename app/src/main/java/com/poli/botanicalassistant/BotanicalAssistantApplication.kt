package com.poli.botanicalassistant

import android.app.Application
import com.poli.botanicalassistant.di.gardenModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BotanicalAssistantApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BotanicalAssistantApplication)
            modules(gardenModule)
        }
    }
}
