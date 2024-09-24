package com.poli.botanicalassistant.ui.garden

import androidx.recyclerview.widget.DiffUtil
import com.poli.botanicalassistant.domain.plant.Plant

class PlantDiffCallback : DiffUtil.ItemCallback<Plant>() {
    override fun areItemsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem.id == newItem.id
    }
}
