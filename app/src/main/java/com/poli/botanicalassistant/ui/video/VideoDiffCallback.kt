package com.poli.botanicalassistant.ui.video

import androidx.recyclerview.widget.DiffUtil
import com.poli.botanicalassistant.ui.video.model.VideoUi

class VideoDiffCallback : DiffUtil.ItemCallback<VideoUi>() {

    override fun areItemsTheSame(oldItem: VideoUi, newItem: VideoUi): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: VideoUi, newItem: VideoUi): Boolean {
        return oldItem == newItem
    }
}
