package com.poli.botanicalassistant.ui.garden.mapper

import com.poli.botanicalassistant.domain.plant.CareInfo
import com.poli.botanicalassistant.ui.garden.model.CareInfoUi

fun CareInfo.toUi() = CareInfoUi(
    waterAmount = this.waterAmount,
    light = this.light,
    temperature = this.temperature,
    humidity = this.humidity,
)
