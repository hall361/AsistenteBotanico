package com.poli.botanicalassistant.ui.videos

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.poli.botanicalassistant.databinding.ItemVideoBinding
import com.poli.botanicalassistant.domain.video.Video

/**
 * ViewHolder for displaying video items in a RecyclerView.
 *
 * @property binding ViewBinding for the video item layout.
 * @property onVideoClickListener Lambda for handling video click events.
 */
class VideosViewHolder(
    private val binding: ItemVideoBinding,
    private val onVideoClickListener: (Video) -> Unit // Cambiado a lambda
) : RecyclerView.ViewHolder(binding.root) {

    /**
     * Bind the video data to the views in the layout.
     *
     * @param video The video data to display.
     */
    fun bind(video: Video) {
        binding.videoName.text = video.videoName
        binding.videoAuthor.text = video.author

        // Cargar la imagen del video (usando Glide)
        Glide.with(binding.videoImage.context)
            .load("https://example.com/video_thumbnail.jpg") // Cambia a la URL real
            .into(binding.videoImage)

        // Configura el evento de clic utilizando la lambda
        binding.root.setOnClickListener {
            onVideoClickListener(video) // Llama a la lambda al hacer clic
        }
    }
}
