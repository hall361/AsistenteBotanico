package com.poli.botanicalassistant.di

import com.poli.botanicalassistant.ui.about.AboutUsAdapter
import com.poli.botanicalassistant.ui.about.FeatureOfferedAdapter
import org.koin.dsl.module

val aboutUsModule = module {

    factory { FeatureOfferedAdapter() }

    factory {
        AboutUsAdapter(
            featureOfferedAdapter = get()
        )
    }
}
