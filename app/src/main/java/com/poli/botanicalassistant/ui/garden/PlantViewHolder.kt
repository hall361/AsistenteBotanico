package com.poli.botanicalassistant.ui.garden

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.poli.botanicalassistant.R
import com.poli.botanicalassistant.databinding.ItemPlantBinding
import com.poli.botanicalassistant.domain.plant.Plant
import com.poli.botanicalassistant.domain.plant.PlantType

class PlantViewHolder(
    private val listener: OnPlantClickListener,
    private val binding: ItemPlantBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(plant: Plant) {
        binding.plantCommonName.text = plant.commonName
        binding.plantClassification.text = plant.classification.name
        loadImage()
        loadClassification(plant)
        configListeners(plant)
        configLoadOwnedIcon(plant)
    }

    private fun loadImage(
        imageUrl: String = "https://sakder.com/wp-content/uploads/Articles/visual-interest-to-a-shaded-outdoor-garden.jpg"
    ) {
        Glide.with(binding.plantImage.context)
            .load(imageUrl)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(R.drawable.ic_menu_garden)
            .into(binding.plantImage)
    }

    private fun configListeners(plant: Plant) {
        binding.root.setOnClickListener {
            listener.onPlantClick(plant)
        }
    }

    private fun configLoadOwnedIcon(plant: Plant) {
        if (plant.isOwned) {
            binding.ownedIcon.setImageResource(R.drawable.ic_favorite_selected)
        } else {
            binding.ownedIcon.setImageResource(R.drawable.ic_favorite_unselected)
        }
    }

    private fun loadClassification(plant: Plant) {
        val plantClassification = when (plant.classification) {
            PlantType.INDOOR -> R.string.plant_classification_indoor
            PlantType.OUTDOOR -> R.string.plant_classification_outdoor
            PlantType.SUCCULENT -> R.string.plant_classification_succulent
            PlantType.OTHER -> R.string.plant_classification_other
        }
        val classificationText = "${getTextFromResource(R.string.plant_classification)}: ${getTextFromResource(plantClassification)}"
        binding.plantClassification.text = classificationText
    }

    private fun getTextFromResource(resourceId: Int): String {
        return binding.root.context.getString(resourceId)
    }

    companion object {
        fun create(
            listener: OnPlantClickListener,
            parent: ViewGroup
        ): PlantViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemPlantBinding.inflate(layoutInflater, parent, false)
            return PlantViewHolder(listener, binding)
        }
    }
}
