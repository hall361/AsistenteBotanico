package com.poli.botanicalassistant.ui.garden.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.poli.botanicalassistant.R
import com.poli.botanicalassistant.databinding.ItemPlantCareInfoBinding
import com.poli.botanicalassistant.ui.garden.ui.GardenTextUiUtils.getProfileTextValue

class PlantCareInfoViewHolder(
    private val binding: ItemPlantCareInfoBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(careInfo: PlantProfileUi.CareInfo) {
        with(careInfo) {
            setupLightText(light)
            setupWaterAmountText(waterAmount)
            setupHumidityText(humidity)
            setupTemperatureText(temperature)
        }
    }

    private fun setupLightText(light: String) {
        binding.lightText.text = getCareInfoText(light, R.string.plant_profile_lightning)
    }

    private fun setupWaterAmountText(waterAmount: String) {
        binding.waterAmountText.text = getCareInfoText(waterAmount, R.string.plant_profile_water_amount)
    }

    private fun setupHumidityText(humidity: String) {
        binding.humidityProgress.text = humidity
        binding.humidityProgress.progress = getProgressValue(humidity, HUMIDITY_SUFFIX_PERCENTAGE)
    }

    private fun setupTemperatureText(temperature: String) {
        binding.temperatureProgress.text = temperature
        binding.temperatureProgress.suffixText = TEMPERATURE_SUFFIX_GRADES
        binding.temperatureProgress.progress = getProgressValue(temperature, TEMPERATURE_SUFFIX_GRADES)
    }

    private fun getProgressValue(text: String, valueToReplace: String) = text
        .replace(valueToReplace, "")
        .split(PROGRESS_SPLIT_DELIMITER)[MAX_PROGRESS_INDEX_POSITION]
        .toFloat()

    private fun getCareInfoText(careInfoText: String, resourceId: Int): String = binding.root
        .context
        .getProfileTextValue(careInfoText, resourceId)

    companion object {
        private const val HUMIDITY_SUFFIX_PERCENTAGE = "%"
        private const val TEMPERATURE_SUFFIX_GRADES = "°C"
        private const val PROGRESS_SPLIT_DELIMITER = "-"
        private const val MAX_PROGRESS_INDEX_POSITION = 1

        fun create(parent: ViewGroup): PlantCareInfoViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemPlantCareInfoBinding.inflate(layoutInflater, parent, false)
            return PlantCareInfoViewHolder(binding)
        }
    }
}
