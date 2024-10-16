package com.poli.botanicalassistant.data.plant.mapper

import com.poli.botanicalassistant.data.plant.model.LifeCycle
import com.poli.botanicalassistant.domain.plant.LifeCycle as LifeCycleDomain

fun LifeCycle.toDomain() = LifeCycleDomain(
    growthSpeed = this.growthSpeed,
    seasonality = this.seasonality
)
