package com.poli.botanicalassistant.ui.about

import androidx.recyclerview.widget.DiffUtil

class AboutUsDiffCallback : DiffUtil.ItemCallback<AboutUsUi>() {
    override fun areItemsTheSame(oldItem: AboutUsUi, newItem: AboutUsUi) = oldItem == newItem

    override fun areContentsTheSame(oldItem: AboutUsUi, newItem: AboutUsUi) = oldItem == newItem
}
