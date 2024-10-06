package com.poli.botanicalassistant.di

import com.google.firebase.firestore.FirebaseFirestore
import com.poli.botanicalassistant.data.plant.datasource.PlantDataSource
import com.poli.botanicalassistant.data.plant.datasource.impl.PlantDataSourceImpl
import com.poli.botanicalassistant.data.plant.repository.PlantRepository
import com.poli.botanicalassistant.data.plant.repository.impl.PlantRepositoryImpl
import com.poli.botanicalassistant.ui.garden.list.GardenViewModel
import com.poli.botanicalassistant.usecase.GetPlantsUseCase
import com.poli.botanicalassistant.usecase.impl.GetPlantsUseCaseImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val gardenModule = module {
    single { FirebaseFirestore.getInstance() }

    single<PlantDataSource> { PlantDataSourceImpl(get()) }

    single<PlantRepository> { PlantRepositoryImpl(get()) }

    factory<GetPlantsUseCase> { GetPlantsUseCaseImpl(get()) }

    viewModel { GardenViewModel(get()) }
}
