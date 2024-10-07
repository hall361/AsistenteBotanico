package com.poli.botanicalassistant

import android.app.Application
import com.poli.botanicalassistant.di.aboutUsModule
import com.poli.botanicalassistant.di.firebaseModule
import com.poli.botanicalassistant.di.frameworkModule
import com.poli.botanicalassistant.di.gardenModule
import com.poli.botanicalassistant.di.videoModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BotanicalAssistantApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BotanicalAssistantApplication)
            modules(
                aboutUsModule,
                firebaseModule,
                frameworkModule,
                gardenModule,
                videoModule
            )
        }
    }
}
