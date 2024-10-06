package com.poli.botanicalassistant.usecase

import com.poli.botanicalassistant.domain.plant.Plant
import kotlinx.coroutines.flow.Flow

interface GetPlantsUseCase {

    operator fun invoke(): Flow<List<Plant>>
}
