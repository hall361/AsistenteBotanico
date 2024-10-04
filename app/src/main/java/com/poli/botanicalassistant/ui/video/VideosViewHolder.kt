package com.poli.botanicalassistant.ui.video

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.poli.botanicalassistant.databinding.ItemVideoBinding
import com.poli.botanicalassistant.domain.video.Video

class VideosViewHolder(
    private val binding: ItemVideoBinding,
    private val onVideoClickListener: (Video) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(video: Video) {
        binding.videoName.text = video.videoName
        binding.videoAuthor.text = video.author

        Glide.with(binding.videoImage.context)
            .load("https://example.com/video_thumbnail.jpg")
            .into(binding.videoImage)

        binding.root.setOnClickListener {
            onVideoClickListener(video)
        }
    }
}
