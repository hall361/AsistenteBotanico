package com.poli.botanicalassistant.ui.garden.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.poli.botanicalassistant.R
import com.poli.botanicalassistant.databinding.ItemPlantBasicInfoBinding
import com.poli.botanicalassistant.framework.ImageManager
import com.poli.botanicalassistant.ui.garden.model.PlantTypeUi
import com.poli.botanicalassistant.ui.garden.util.GardenDrawableUiUtils
import com.poli.botanicalassistant.ui.garden.util.GardenTextUiUtils

class PlantBasicInfoViewHolder(
    private val binding: ItemPlantBasicInfoBinding,
    private val imageManager: ImageManager,
    private val gardenTextUiUtils: GardenTextUiUtils,
    private val gardenDrawableUiUtils: GardenDrawableUiUtils
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(basicInfo: PlantProfileUi.BasicInfo) {
        with(basicInfo) {
            setupImage(imageUrl)
            setupCommonName(commonName)
            setupScientificName(scientificName)
            setupClassification(classification)
        }
    }

    private fun setupImage(imageUrl: String) {
        imageManager.loadCircleImage(
            binding.plantImage,
            imageUrl,
            R.drawable.ic_garden_placeholder
        )
    }

    private fun setupCommonName(commonName: String) {
        binding.commonNameText.text = commonName
    }

    private fun setupScientificName(scientificName: String) {
        binding.scientificNameText.text = scientificName
    }

    private fun setupClassification(classification: PlantTypeUi) {
        with(classification) {
            binding.classificationText.text = gardenTextUiUtils.getPlantClassificationText(this)
            gardenDrawableUiUtils.getPlantClassificationIcon(this)?.let { icon ->
                binding.classificationText
                    .setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null)
            }
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            imageManager: ImageManager,
            gardenTextUiUtils: GardenTextUiUtils,
            gardenDrawableUiUtils: GardenDrawableUiUtils
        ): PlantBasicInfoViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemPlantBasicInfoBinding.inflate(layoutInflater, parent, false)
            return PlantBasicInfoViewHolder(
                binding,
                imageManager,
                gardenTextUiUtils,
                gardenDrawableUiUtils
            )
        }
    }
}
