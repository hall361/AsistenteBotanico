package com.poli.botanicalassistant.data.plant.mapper

import com.poli.botanicalassistant.data.plant.model.CareInfo
import com.poli.botanicalassistant.domain.plant.CareInfo as CareInfoDomain

fun CareInfo.toDomain() = CareInfoDomain(
    waterAmount = this.waterAmount,
    light = this.light,
    temperature = this.temperature,
    humidity = this.humidity,
)
