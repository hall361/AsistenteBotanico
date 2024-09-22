package com.poli.botanicalassistant.ui.garden

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.poli.botanicalassistant.R
import com.poli.botanicalassistant.databinding.ItemPlantBinding
import com.poli.botanicalassistant.domain.plant.Plant

class PlantViewHolder(
    private val listener: OnPlantClickListener,
    private val binding: ItemPlantBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(plant: Plant) {
        binding.plantCommonName.text = plant.commonName
        binding.plantClassification.text = plant.classification.name
        loadImage()
        configListeners(plant)
        configOwnedIcon(plant)
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

    private fun configOwnedIcon(plant: Plant) {
        if (plant.isOwned) {
            binding.ownedIcon.setImageResource(R.drawable.ic_favorite_selected)
        } else {
            binding.ownedIcon.setImageResource(R.drawable.ic_favorite_unselected)
        }
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
