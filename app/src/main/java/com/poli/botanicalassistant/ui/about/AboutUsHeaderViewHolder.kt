package com.poli.botanicalassistant.ui.about

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.poli.botanicalassistant.databinding.ItemAboutUsHeaderBinding

class AboutUsHeaderViewHolder(
    binding: ItemAboutUsHeaderBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind() = Unit

    companion object {
        fun create(parent: ViewGroup): AboutUsHeaderViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemAboutUsHeaderBinding.inflate(layoutInflater, parent, false)
            return AboutUsHeaderViewHolder(binding)
        }
    }
}
