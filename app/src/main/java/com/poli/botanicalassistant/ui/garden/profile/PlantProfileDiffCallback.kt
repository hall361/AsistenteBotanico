package com.poli.botanicalassistant.ui.garden.profile

import androidx.recyclerview.widget.DiffUtil

class PlantProfileDiffCallback : DiffUtil.ItemCallback<PlantProfileUi>() {
    override fun areItemsTheSame(oldItem: PlantProfileUi, newItem: PlantProfileUi) = oldItem.type == newItem.type

    override fun areContentsTheSame(oldItem: PlantProfileUi, newItem: PlantProfileUi) = oldItem.type == newItem.type
}
