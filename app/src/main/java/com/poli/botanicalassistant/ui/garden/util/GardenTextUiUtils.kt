package com.poli.botanicalassistant.ui.garden.util

import com.poli.botanicalassistant.ui.garden.model.PlantTypeUi

interface GardenTextUiUtils {

    fun getProfileTextValue(value: String, resourceId: Int): String

    fun getPlantClassificationText(classification: PlantTypeUi): String
}
