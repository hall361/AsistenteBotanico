package com.poli.botanicalassistant.ui.about

import androidx.recyclerview.widget.DiffUtil
import com.poli.botanicalassistant.ui.about.model.FeatureOffered

class FeatureOfferedDiffCallback : DiffUtil.ItemCallback<FeatureOffered>() {

    override fun areItemsTheSame(oldItem: FeatureOffered, newItem: FeatureOffered) = oldItem.text == newItem.text

    override fun areContentsTheSame(oldItem: FeatureOffered, newItem: FeatureOffered) = oldItem == newItem
}
