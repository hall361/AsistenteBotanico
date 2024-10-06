package com.poli.botanicalassistant.ui.garden.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.poli.botanicalassistant.R
import com.poli.botanicalassistant.databinding.ItemPlantBinding
import com.poli.botanicalassistant.ui.garden.model.PlantTypeUi
import com.poli.botanicalassistant.ui.garden.model.PlantUi

class PlantViewHolder(
    private val listener: OnPlantClickListener,
    private val binding: ItemPlantBinding
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
        Glide.with(binding.plantImage.context)
            .load(imageUrl)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(R.drawable.ic_garden_placeholder)
            .into(binding.plantImage)
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
        val plantClassification = when (classification) {
            PlantTypeUi.INDOOR -> R.string.plant_classification_indoor
            PlantTypeUi.OUTDOOR -> R.string.plant_classification_outdoor
            PlantTypeUi.SUCCULENT -> R.string.plant_classification_succulent
            PlantTypeUi.OTHER -> R.string.plant_classification_other
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
