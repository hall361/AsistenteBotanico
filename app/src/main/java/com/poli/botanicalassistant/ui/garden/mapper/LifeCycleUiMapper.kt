package com.poli.botanicalassistant.ui.garden.mapper

import com.poli.botanicalassistant.domain.plant.LifeCycle
import com.poli.botanicalassistant.ui.garden.model.LifeCycleUi

fun LifeCycle.toUi() = LifeCycleUi(
    growthSpeed = this.growthSpeed,
    seasonality = this.seasonality
)
