package com.poli.botanicalassistant.data.plant.datasource

import com.poli.botanicalassistant.data.plant.model.Plant
import kotlinx.coroutines.flow.Flow

interface PlantDataSource {

    fun getPlants(): Flow<List<Plant>>
}
