package com.poli.botanicalassistant.ui.garden.mapper

import com.poli.botanicalassistant.domain.plant.Plant
import com.poli.botanicalassistant.ui.garden.model.PlantTypeUi
import com.poli.botanicalassistant.ui.garden.model.PlantUi

fun Plant.toUi() = PlantUi(
    id = this.id,
    commonName = this.commonName,
    scientificName = this.scientificName,
    imageUrl = this.imageUrl,
    classification = PlantTypeUi.fromString(this.classification.name),
    careInfo = this.careInfo.toUi(),
    lifeCycle = this.lifeCycle.toUi(),
    isOwned = this.isOwned,
)

fun List<Plant>.toUiList() = this.map { it.toUi() }
