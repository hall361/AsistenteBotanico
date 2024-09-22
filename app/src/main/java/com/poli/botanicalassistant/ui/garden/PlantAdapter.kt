package com.poli.botanicalassistant.ui.garden

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.poli.botanicalassistant.domain.plant.Plant

class PlantAdapter(
    private val listener: OnPlantClickListener
) : ListAdapter<Plant, PlantViewHolder>(PlantDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PlantViewHolder.create(listener, parent)

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
