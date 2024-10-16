package com.poli.botanicalassistant.ui.garden.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.poli.botanicalassistant.R
import com.poli.botanicalassistant.databinding.ItemPlantBinding
import com.poli.botanicalassistant.framework.ImageManager
import com.poli.botanicalassistant.ui.garden.model.PlantTypeUi
import com.poli.botanicalassistant.ui.garden.model.PlantUi
import com.poli.botanicalassistant.ui.garden.util.GardenDrawableUiUtils
import com.poli.botanicalassistant.ui.garden.util.GardenTextUiUtils

class PlantViewHolder(
    private val listener: OnPlantClickListener,
    private val binding: ItemPlantBinding,
    private val imageManager: ImageManager,
    private val gardenDrawableUiUtils: GardenDrawableUiUtils,
    private val gardenTextUiUtils: GardenTextUiUtils
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(plant: PlantUi) {
        with(plant) {
            binding.plantCommonName.text = commonName
            loadImage(imageUrl)
            loadClassification(classification)
            configLoadOwnedIcon(isOwned)
            configListeners(this)
        }
    }

    private fun loadImage(imageUrl: String) {
        imageManager.loadCircleImage(binding.plantImage, imageUrl, R.drawable.ic_garden_placeholder)
    }

    private fun configListeners(plant: PlantUi) {
        binding.root.setOnClickListener {
            listener.onPlantClick(plant)
        }
    }

    private fun configLoadOwnedIcon(isOwned: Boolean) {
        if (isOwned) {
            binding.ownedIcon.setImageResource(R.drawable.ic_favorite_selected)
        } else {
            binding.ownedIcon.setImageResource(R.drawable.ic_favorite_unselected)
        }
    }

    private fun loadClassification(classification: PlantTypeUi) {
        binding.plantClassification.text = gardenTextUiUtils.getPlantClassificationText(classification)
        gardenDrawableUiUtils.getPlantClassificationIcon(classification)?.let { icon ->
            binding
                .plantClassification
                .setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null)
        }
    }

    companion object {
        fun create(
            listener: OnPlantClickListener,
            parent: ViewGroup,
            imageManager: ImageManager,
            gardenDrawableUiUtils: GardenDrawableUiUtils,
            gardenTextUiUtils: GardenTextUiUtils
        ): PlantViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemPlantBinding.inflate(layoutInflater, parent, false)
            return PlantViewHolder(listener, binding, imageManager, gardenDrawableUiUtils, gardenTextUiUtils)
        }
    }
}
