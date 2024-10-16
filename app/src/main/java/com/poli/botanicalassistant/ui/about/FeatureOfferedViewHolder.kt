package com.poli.botanicalassistant.ui.about

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.poli.botanicalassistant.databinding.ItemAboutUsFeatureOfferedBinding
import com.poli.botanicalassistant.ui.about.model.FeatureOffered

class FeatureOfferedViewHolder(
    private val binding: ItemAboutUsFeatureOfferedBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(featureOffered: FeatureOffered) {
        binding.featureText.text = featureOffered.text
        binding.featureText.setCompoundDrawablesWithIntrinsicBounds(
            featureOffered.iconResId,
            0,
            0,
            0
        )
    }

    companion object {
        fun from(parent: ViewGroup): FeatureOfferedViewHolder {
            val binding = ItemAboutUsFeatureOfferedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return FeatureOfferedViewHolder(binding)
        }
    }
}
