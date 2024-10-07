package com.poli.botanicalassistant.ui.garden.profile

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.poli.botanicalassistant.R
import com.poli.botanicalassistant.databinding.ItemPlantBasicInfoBinding
import com.poli.botanicalassistant.ui.garden.model.PlantTypeUi

class PlantBasicInfoViewHolder(
    private val binding: ItemPlantBasicInfoBinding
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
        Glide.with(binding.plantImage.context)
            .load(imageUrl)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(R.drawable.ic_garden_placeholder)
            .into(binding.plantImage)
    }

    private fun setupCommonName(commonName: String) {
        binding.commonNameText.text = commonName
    }

    private fun setupScientificName(scientificName: String) {
        binding.scientificNameText.text = scientificName
    }

    private fun setupClassification(classification: PlantTypeUi) {
        binding.classificationText.text = getClassificationText(classification)
        getClassificationIcon(classification)?.let { icon ->
            binding
                .classificationText
                .setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null)
        }
    }

    private fun getClassificationText(classification: PlantTypeUi): String {
        val plantClassification = when (classification) {
            PlantTypeUi.INDOOR -> R.string.plant_classification_indoor
            PlantTypeUi.OUTDOOR -> R.string.plant_classification_outdoor
            PlantTypeUi.SUCCULENT -> R.string.plant_classification_succulent
            PlantTypeUi.OTHER -> R.string.plant_classification_other
        }
        return "${getTextFromResource(R.string.plant_classification)}: ${getTextFromResource(plantClassification)}"
    }

    private fun getClassificationIcon(classification: PlantTypeUi): Drawable? {
        val icon = when (classification) {
            PlantTypeUi.INDOOR -> R.drawable.ic_plant_profile_classification_indoor
            PlantTypeUi.OUTDOOR -> R.drawable.ic_plant_profile_classification_outdoor
            PlantTypeUi.SUCCULENT -> R.drawable.ic_plant_profile_classification_succulent
            PlantTypeUi.OTHER -> R.drawable.ic_plant_profile_classification_other
        }
        return getDrawableFromResource(icon)
    }

    private fun getDrawableFromResource(@DrawableRes resourceId: Int): Drawable? {
        return ContextCompat.getDrawable(binding.root.context, resourceId)
    }

    private fun getTextFromResource(resourceId: Int): String {
        return binding.root.context.getString(resourceId)
    }

    companion object {
        fun create(parent: ViewGroup): PlantBasicInfoViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemPlantBasicInfoBinding.inflate(layoutInflater, parent, false)
            return PlantBasicInfoViewHolder(binding)
        }
    }
}
