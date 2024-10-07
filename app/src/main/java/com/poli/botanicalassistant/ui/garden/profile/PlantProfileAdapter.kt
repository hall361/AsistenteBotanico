package com.poli.botanicalassistant.ui.garden.profile

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class PlantProfileAdapter : ListAdapter<PlantProfileUi, ViewHolder>(PlantProfileDiffCallback()) {

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is PlantProfileUi.BasicInfo -> PlantProfileType.BASIC_INFO.ordinal
            is PlantProfileUi.CareInfo -> PlantProfileType.CARE_INFO.ordinal
            is PlantProfileUi.LifeCycleInfo -> PlantProfileType.LIFE_CYCLE_INFO.ordinal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = when (viewType) {
        PlantProfileType.BASIC_INFO.ordinal -> PlantBasicInfoViewHolder.create(parent)
        PlantProfileType.CARE_INFO.ordinal -> PlantCareInfoViewHolder.create(parent)
        PlantProfileType.LIFE_CYCLE_INFO.ordinal -> PlantLifeCycleViewHolder.create(parent)
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
