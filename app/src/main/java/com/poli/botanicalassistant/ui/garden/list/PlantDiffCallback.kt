package com.poli.botanicalassistant.ui.garden.list

import androidx.recyclerview.widget.DiffUtil
import com.poli.botanicalassistant.ui.garden.model.PlantUi

class PlantDiffCallback : DiffUtil.ItemCallback<PlantUi>() {
    override fun areItemsTheSame(oldItem: PlantUi, newItem: PlantUi): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PlantUi, newItem: PlantUi): Boolean {
        return oldItem.id == newItem.id
    }
}
