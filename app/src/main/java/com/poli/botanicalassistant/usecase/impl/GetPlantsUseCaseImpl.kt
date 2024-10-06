package com.poli.botanicalassistant.usecase.impl

import com.poli.botanicalassistant.data.plant.repository.PlantRepository
import com.poli.botanicalassistant.usecase.GetPlantsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn

class GetPlantsUseCaseImpl(
    private val plantRepository: PlantRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : GetPlantsUseCase {

    override fun invoke() = plantRepository
        .getPlants()
        .flowOn(dispatcher)
}
