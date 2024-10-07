package com.poli.botanicalassistant.ui.about

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.poli.botanicalassistant.ui.about.model.FeatureOffered

class FeatureOfferedAdapter : ListAdapter<FeatureOffered, FeatureOfferedViewHolder>(FeatureOfferedDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FeatureOfferedViewHolder.from(parent)

    override fun onBindViewHolder(holder: FeatureOfferedViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
