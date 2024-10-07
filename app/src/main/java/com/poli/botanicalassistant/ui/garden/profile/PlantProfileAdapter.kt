package com.poli.botanicalassistant.ui.garden.profile

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.poli.botanicalassistant.framework.ImageManager
import com.poli.botanicalassistant.ui.garden.util.GardenDrawableUiUtils
import com.poli.botanicalassistant.ui.garden.util.GardenTextUiUtils

class PlantProfileAdapter(
    private val imageManager: ImageManager,
    private val gardenDrawableUiUtils: GardenDrawableUiUtils,
    private val gardenTextUiUtils: GardenTextUiUtils,
) : ListAdapter<PlantProfileUi, ViewHolder>(PlantProfileDiffCallback()) {

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is PlantProfileUi.BasicInfo -> PlantProfileType.BASIC_INFO.ordinal
            is PlantProfileUi.CareInfo -> PlantProfileType.CARE_INFO.ordinal
            is PlantProfileUi.LifeCycleInfo -> PlantProfileType.LIFE_CYCLE_INFO.ordinal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = when (viewType) {
        PlantProfileType.BASIC_INFO.ordinal -> PlantBasicInfoViewHolder.create(
            parent,
            imageManager,
            gardenTextUiUtils,
            gardenDrawableUiUtils
        )

        PlantProfileType.CARE_INFO.ordinal -> PlantCareInfoViewHolder.create(
            parent,
            gardenTextUiUtils
        )

        PlantProfileType.LIFE_CYCLE_INFO.ordinal -> PlantLifeCycleViewHolder.create(
            parent,
            gardenTextUiUtils
        )

        else -> throw IllegalArgumentException("Invalid view type")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is PlantBasicInfoViewHolder -> holder.bind(getItem(position) as PlantProfileUi.BasicInfo)
            is PlantLifeCycleViewHolder -> holder.bind(getItem(position) as PlantProfileUi.LifeCycleInfo)
            is PlantCareInfoViewHolder -> holder.bind(getItem(position) as PlantProfileUi.CareInfo)
        }
    }
}
