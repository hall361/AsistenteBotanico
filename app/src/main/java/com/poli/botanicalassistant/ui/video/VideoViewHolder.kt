package com.poli.botanicalassistant.ui.video

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.poli.botanicalassistant.R
import com.poli.botanicalassistant.databinding.ItemVideoBinding
import com.poli.botanicalassistant.framework.ImageManager
import com.poli.botanicalassistant.ui.video.model.VideoUi
import com.poli.botanicalassistant.ui.video.util.VideoTextUiUtil

class VideoViewHolder(
    private val listener: OnVideoClickListener,
    private val binding: ItemVideoBinding,
    private val imageManager: ImageManager,
    private val videoTextUiUtil: VideoTextUiUtil
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(video: VideoUi) {
        with(video) {
            binding.videoName.text = videoName
            binding.videoAuthor.text = author
            binding.videoDuration.text = videoTextUiUtil.formatVideoDuration(duration)
            loadImage(imageUrl)
            setListener(this)
        }
    }

    private fun loadImage(imageUrl: String) {
        imageManager.loadCircleImage(
            binding.videoImage,
            imageUrl,
            R.drawable.ic_play
        )
    }

    private fun setListener(video: VideoUi) {
        binding.root.setOnClickListener {
            listener.onVideoClick(video)
        }
    }

    companion object {
        fun create(
            listener: OnVideoClickListener,
            imageManager: ImageManager,
            parent: ViewGroup,
            videoTextUiUtil: VideoTextUiUtil
        ): VideoViewHolder {
            val binding = ItemVideoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return VideoViewHolder(listener, binding, imageManager, videoTextUiUtil)
        }
    }
}
