package com.poli.botanicalassistant.data.plant.repository

import com.poli.botanicalassistant.domain.plant.Plant
import kotlinx.coroutines.flow.Flow

interface PlantRepository {

    fun getPlants(): Flow<List<Plant>>
}
