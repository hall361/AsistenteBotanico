package com.poli.botanicalassistant.ui.garden.list

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.poli.botanicalassistant.framework.ImageManager
import com.poli.botanicalassistant.ui.garden.model.PlantUi
import com.poli.botanicalassistant.ui.garden.util.GardenDrawableUiUtils
import com.poli.botanicalassistant.ui.garden.util.GardenTextUiUtils

class GardenAdapter(
    private val imageManager: ImageManager,
    private val gardenDrawableUiUtils: GardenDrawableUiUtils,
    private val gardenTextUiUtils: GardenTextUiUtils,
) : ListAdapter<PlantUi, PlantViewHolder>(PlantDiffCallback()) {

    private var _listener: OnPlantClickListener? = null
    private val listener get() = _listener!!

    fun setListener(listener: OnPlantClickListener) {
        _listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PlantViewHolder.create(
        listener,
        parent,
        imageManager,
        gardenDrawableUiUtils,
        gardenTextUiUtils
    )

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
