package com.poli.botanicalassistant.ui.about

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class AboutUsAdapter(
    val featureOfferedAdapter: FeatureOfferedAdapter
) : ListAdapter<AboutUsUi, RecyclerView.ViewHolder>(AboutUsDiffCallback()) {

    override fun getItemViewType(position: Int) = getItem(position).type.ordinal

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        AboutUsType.HEADER.ordinal -> AboutUsHeaderViewHolder.create(parent)
        AboutUsType.WHAT_WE_OFFER.ordinal -> AboutUsWeOfferViewHolder.create(parent, featureOfferedAdapter)
        AboutUsType.ACTIONS.ordinal -> AboutUsActionsViewHolder.create(parent)
        AboutUsType.CREDITS.ordinal -> AboutUsCreditsViewHolder.create(parent)
        else -> throw IllegalArgumentException("Invalid view type")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is AboutUsHeaderViewHolder -> holder.bind()
            is AboutUsWeOfferViewHolder -> holder.bind(getItem(position) as AboutUsUi.WhatWeOffer)
            is AboutUsActionsViewHolder -> holder.bind(getItem(position) as AboutUsUi.Actions)
            is AboutUsCreditsViewHolder -> holder.bind()
        }
    }
}
