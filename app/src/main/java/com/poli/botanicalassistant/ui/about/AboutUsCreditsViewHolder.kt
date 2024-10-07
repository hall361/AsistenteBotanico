package com.poli.botanicalassistant.ui.about

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.poli.botanicalassistant.databinding.ItemAboutUsCreditsBinding

class AboutUsCreditsViewHolder(
    binding: ItemAboutUsCreditsBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind() = Unit

    companion object {
        fun create(
            parent: ViewGroup
        ): AboutUsCreditsViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemAboutUsCreditsBinding.inflate(layoutInflater, parent, false)
            return AboutUsCreditsViewHolder(binding)
        }
    }
}
