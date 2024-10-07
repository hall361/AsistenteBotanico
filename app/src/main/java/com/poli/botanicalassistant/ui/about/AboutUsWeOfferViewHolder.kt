package com.poli.botanicalassistant.ui.about

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.poli.botanicalassistant.databinding.ItemAboutUsWhatWeOfferBinding

class AboutUsWeOfferViewHolder(
    private val binding: ItemAboutUsWhatWeOfferBinding,
    private val featureOfferedAdapter: FeatureOfferedAdapter,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(whatWeOffer: AboutUsUi.WhatWeOffer) {
        binding.featureOfferedRecycler.adapter = featureOfferedAdapter
        featureOfferedAdapter.submitList(whatWeOffer.featuresOffered)
    }

    companion object {
        fun create(
            parent: ViewGroup,
            featureOfferedAdapter: FeatureOfferedAdapter
        ): AboutUsWeOfferViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemAboutUsWhatWeOfferBinding.inflate(layoutInflater, parent, false)
            return AboutUsWeOfferViewHolder(binding, featureOfferedAdapter)
        }
    }
}
