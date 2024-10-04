package com.poli.botanicalassistant.ui.video

import androidx.recyclerview.widget.DiffUtil
import com.poli.botanicalassistant.domain.video.Video

class VideoDiffCallback : DiffUtil.ItemCallback<Video>() {

    override fun areItemsTheSame(oldItem: Video, newItem: Video): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Video, newItem: Video): Boolean {
        return oldItem == newItem
    }
}
