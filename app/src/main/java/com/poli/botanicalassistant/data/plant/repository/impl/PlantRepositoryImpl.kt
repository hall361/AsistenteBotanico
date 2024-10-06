package com.poli.botanicalassistant.data.plant.repository.impl

import com.poli.botanicalassistant.data.plant.datasource.PlantDataSource
import com.poli.botanicalassistant.data.plant.mapper.toDomain
import com.poli.botanicalassistant.data.plant.repository.PlantRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class PlantRepositoryImpl(
    private val plantDataSource: PlantDataSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : PlantRepository {

    override fun getPlants() = plantDataSource
        .getPlants()
        .map { plants -> plants.map { it.toDomain() } }
        .flowOn(dispatcher)
}
