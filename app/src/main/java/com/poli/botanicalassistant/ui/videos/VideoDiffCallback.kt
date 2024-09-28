package com.poli.botanicalassistant.ui.videos

import androidx.recyclerview.widget.DiffUtil
import com.poli.botanicalassistant.domain.video.Video

/**
 * DiffUtil callback for calculating the difference between two lists of videos.
 */
class VideoDiffCallback : DiffUtil.ItemCallback<Video>() {

    // Verifica si los videos son los mismos comparando sus IDs
    override fun areItemsTheSame(oldItem: Video, newItem: Video): Boolean {
        return oldItem.id == newItem.id
    }

    // Verifica si los contenidos de los videos son iguales
    override fun areContentsTheSame(oldItem: Video, newItem: Video): Boolean {
        return oldItem == newItem
    }
}
