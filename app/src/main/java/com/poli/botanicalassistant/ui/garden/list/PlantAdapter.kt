package com.poli.botanicalassistant.ui.garden.list

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.poli.botanicalassistant.domain.plant.Plant
import com.poli.botanicalassistant.ui.garden.model.PlantUi

class PlantAdapter(
    private val listener: OnPlantClickListener
) : ListAdapter<PlantUi, PlantViewHolder>(PlantDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PlantViewHolder.create(listener, parent)

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
