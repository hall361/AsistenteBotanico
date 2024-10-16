package com.poli.botanicalassistant.data.plant.mapper

import com.poli.botanicalassistant.data.plant.model.Plant
import com.poli.botanicalassistant.domain.plant.PlantType
import com.poli.botanicalassistant.domain.plant.Plant as PlantDomain

fun Plant.toDomain() = PlantDomain(
    id = this.id,
    commonName = this.commonName,
    scientificName = this.scientificName,
    imageUrl = this.imageUrl,
    classification = PlantType.fromString(this.classification),
    careInfo = this.careInfo.toDomain(),
    lifeCycle = this.lifeCycle.toDomain(),
    isOwned = this.isOwned,
)
