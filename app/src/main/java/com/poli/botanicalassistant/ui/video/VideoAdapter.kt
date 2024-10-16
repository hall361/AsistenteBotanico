package com.poli.botanicalassistant.ui.video

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.poli.botanicalassistant.framework.ImageManager
import com.poli.botanicalassistant.ui.video.model.VideoUi
import com.poli.botanicalassistant.ui.video.util.VideoTextUiUtil

class VideoAdapter(
    private val imageManager: ImageManager,
    private val videoTextUiUtil: VideoTextUiUtil
) : ListAdapter<VideoUi, VideoViewHolder>(VideoDiffCallback()) {

    private var _listener: OnVideoClickListener? = null
    private val listener get() = _listener!!

    fun setListener(listener: OnVideoClickListener) {
        _listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VideoViewHolder.create(
        listener,
        imageManager,
        parent,
        videoTextUiUtil
    )

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
