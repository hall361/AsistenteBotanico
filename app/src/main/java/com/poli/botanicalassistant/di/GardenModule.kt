package com.poli.botanicalassistant.di

import com.poli.botanicalassistant.data.plant.datasource.PlantDataSource
import com.poli.botanicalassistant.data.plant.datasource.impl.PlantDataSourceImpl
import com.poli.botanicalassistant.data.plant.repository.PlantRepository
import com.poli.botanicalassistant.data.plant.repository.impl.PlantRepositoryImpl
import com.poli.botanicalassistant.ui.garden.list.GardenAdapter
import com.poli.botanicalassistant.ui.garden.list.GardenViewModel
import com.poli.botanicalassistant.ui.garden.profile.PlantProfileAdapter
import com.poli.botanicalassistant.ui.garden.util.GardenDrawableUiUtils
import com.poli.botanicalassistant.ui.garden.util.GardenTextUiUtils
import com.poli.botanicalassistant.ui.garden.util.impl.GardenDrawableUiUtilsImpl
import com.poli.botanicalassistant.ui.garden.util.impl.GardenTextUiUtilsImpl
import com.poli.botanicalassistant.usecase.GetPlantsUseCase
import com.poli.botanicalassistant.usecase.impl.GetPlantsUseCaseImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val gardenModule = module {

    single<PlantDataSource> {
        PlantDataSourceImpl(
            firestore = get()
        )
    }

    single<PlantRepository> {
        PlantRepositoryImpl(
            plantDataSource = get()
        )
    }

    factory<GetPlantsUseCase> {
        GetPlantsUseCaseImpl(
            plantRepository = get()
        )
    }

    viewModel {
        GardenViewModel(
            getPlantsUseCase = get()
        )
    }

    single<GardenDrawableUiUtils> {
        GardenDrawableUiUtilsImpl(
            application = androidApplication()
        )
    }

    single<GardenTextUiUtils> {
        GardenTextUiUtilsImpl(
            application = androidApplication()
        )
    }

    factory {
        GardenAdapter(
            imageManager = get(),
            gardenDrawableUiUtils = get(),
            gardenTextUiUtils = get(),
        )
    }

    factory {
        PlantProfileAdapter(
            imageManager = get(),
            gardenDrawableUiUtils = get(),
            gardenTextUiUtils = get(),
        )
    }
}
