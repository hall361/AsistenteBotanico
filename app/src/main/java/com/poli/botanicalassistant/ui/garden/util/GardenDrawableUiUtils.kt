package com.poli.botanicalassistant.ui.garden.util

import android.graphics.drawable.Drawable
import com.poli.botanicalassistant.ui.garden.model.PlantTypeUi

interface GardenDrawableUiUtils {

    fun getPlantClassificationIcon(classification: PlantTypeUi): Drawable?
}
