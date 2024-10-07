package com.poli.botanicalassistant.ui.about

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.poli.botanicalassistant.databinding.ItemAboutUsActionsBinding

class AboutUsActionsViewHolder(
    private val binding: ItemAboutUsActionsBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(actions: AboutUsUi.Actions) {
        with(binding) {
            continueExploringGardenButton.setOnClickListener {
                actions.listener.goToGarden()
            }
            continueExploringVideosButton.setOnClickListener {
                actions.listener.goToVideos()
            }
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
        ): AboutUsActionsViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemAboutUsActionsBinding.inflate(layoutInflater, parent, false)
            return AboutUsActionsViewHolder(binding)
        }
    }
}
