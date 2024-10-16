package com.poli.botanicalassistant.ui.garden.profile

import com.poli.botanicalassistant.ui.garden.model.PlantTypeUi

sealed class PlantProfileUi(val type: PlantProfileType) {
    data class BasicInfo(
        val commonName: String,
        val scientificName: String,
        val imageUrl: String,
        val classification: PlantTypeUi
    ) : PlantProfileUi(PlantProfileType.BASIC_INFO)

    data class CareInfo(
        val waterAmount: String,
        val light: String,
        val temperature: String,
        val humidity: String
    ) : PlantProfileUi(PlantProfileType.CARE_INFO)

    data class LifeCycleInfo(
        val growthSpeed: String,
        val seasonality: String
    ) : PlantProfileUi(PlantProfileType.LIFE_CYCLE_INFO)
}
