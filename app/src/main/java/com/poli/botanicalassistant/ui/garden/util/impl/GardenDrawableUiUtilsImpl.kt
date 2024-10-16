package com.poli.botanicalassistant.ui.garden.util.impl

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.poli.botanicalassistant.R
import com.poli.botanicalassistant.ui.garden.model.PlantTypeUi
import com.poli.botanicalassistant.ui.garden.util.GardenDrawableUiUtils

class GardenDrawableUiUtilsImpl(
    private val application: Application
) : GardenDrawableUiUtils {

    override fun getPlantClassificationIcon(classification: PlantTypeUi): Drawable? {
        val iconResource = when (classification) {
            PlantTypeUi.INDOOR -> R.drawable.ic_plant_profile_classification_indoor
            PlantTypeUi.OUTDOOR -> R.drawable.ic_plant_profile_classification_outdoor
            PlantTypeUi.SUCCULENT -> R.drawable.ic_plant_profile_classification_succulent
            PlantTypeUi.OTHER -> R.drawable.ic_plant_profile_classification_other
        }

        return ContextCompat.getDrawable(application, iconResource)
    }
}
