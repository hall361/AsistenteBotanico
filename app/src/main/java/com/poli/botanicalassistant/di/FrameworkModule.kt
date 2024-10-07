package com.poli.botanicalassistant.di

import com.poli.botanicalassistant.framework.ImageManager
import com.poli.botanicalassistant.framework.impl.ImageManagerImp
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val frameworkModule = module {

    single<ImageManager> { ImageManagerImp(androidApplication()) }
}
