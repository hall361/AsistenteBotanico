package com.poli.botanicalassistant.ui.garden.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.poli.botanicalassistant.R
import com.poli.botanicalassistant.databinding.ItemPlantLifeCycleBinding
import com.poli.botanicalassistant.ui.garden.ui.GardenTextUiUtils.getProfileTextValue

class PlantLifeCycleViewHolder(
    private val binding: ItemPlantLifeCycleBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(lifeCycle: PlantProfileUi.LifeCycleInfo) {
        with(lifeCycle) {
            setupGrowthSpeedText(growthSpeed)
            setupSeasonalityText(seasonality)
        }
    }

    private fun setupGrowthSpeedText(growthSpeed: String) {
        binding.growthSpeedText.text = getLifeCycleText(growthSpeed, R.string.plant_profile_growth_speed)
    }

    private fun setupSeasonalityText(seasonality: String) {
        binding.seasonalityText.text = getLifeCycleText(seasonality, R.string.plant_profile_seasonality)
    }

    private fun getLifeCycleText(lifeCycleText: String, resourceId: Int) = binding.root
        .context
        .getProfileTextValue(lifeCycleText, resourceId)

    companion object{
        fun create(parent: ViewGroup): PlantLifeCycleViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemPlantLifeCycleBinding.inflate(layoutInflater, parent, false)
            return PlantLifeCycleViewHolder(binding)
        }
    }
}
