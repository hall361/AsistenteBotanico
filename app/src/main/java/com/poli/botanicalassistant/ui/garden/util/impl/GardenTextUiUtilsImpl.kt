package com.poli.botanicalassistant.ui.garden.util.impl

import android.app.Application
import com.poli.botanicalassistant.R
import com.poli.botanicalassistant.ui.garden.model.PlantTypeUi
import com.poli.botanicalassistant.ui.garden.util.GardenTextUiUtils

class GardenTextUiUtilsImpl(
    private val application: Application
) : GardenTextUiUtils {

    override fun getProfileTextValue(value: String, resourceId: Int): String {
        return StringBuilder().apply {
            append("${application.getString(resourceId)}:")
            append(LINE_BREAK)
            append(value)
        }.toString()
    }

    override fun getPlantClassificationText(classification: PlantTypeUi): String {
        val plantClassification = when (classification) {
            PlantTypeUi.INDOOR -> R.string.plant_classification_indoor
            PlantTypeUi.OUTDOOR -> R.string.plant_classification_outdoor
            PlantTypeUi.SUCCULENT -> R.string.plant_classification_succulent
            PlantTypeUi.OTHER -> R.string.plant_classification_other
        }
        return with(application) {
            "${getString(R.string.plant_classification)}: ${getString(plantClassification)}"
        }
    }

    companion object {
        private const val LINE_BREAK = "\n"
    }
}
