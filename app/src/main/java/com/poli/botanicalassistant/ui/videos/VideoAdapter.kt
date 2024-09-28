package com.poli.botanicalassistant.ui.videos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.poli.botanicalassistant.R
import com.poli.botanicalassistant.domain.video.Video

class VideoAdapter(
    private val videoList: List<Video>,
    private val onVideoClick: (String) -> Unit // Callback para manejar el clic en el video
) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    inner class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val videoName: TextView = itemView.findViewById(R.id.video_name)
        val videoAuthor: TextView = itemView.findViewById(R.id.video_author)
        val videoCreationDate: TextView = itemView.findViewById(R.id.video_creation_date)
        val videoDuration: TextView = itemView.findViewById(R.id.video_duration)
        val videoCategory: TextView = itemView.findViewById(R.id.video_category) // TextView para mostrar la categoría
        val videoThumbnail: ImageView = itemView.findViewById(R.id.video_image) // Miniatura del video
        val videoIcon: ImageView = itemView.findViewById(R.id.video_icon) // Ícono para acciones

        init {
            itemView.setOnClickListener {
                onVideoClick(videoList[adapterPosition].serverId) // Llamar al callback al hacer clic
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = videoList[position]
        holder.videoName.text = video.videoName
        holder.videoAuthor.text = video.author
        holder.videoCreationDate.text = video.creationDate
        holder.videoDuration.text = "${video.duration} segundos"
        holder.videoCategory.text = video.category.name // Mostrar la categoría

        // Cargar la imagen del video usando Glide y la URL en imageUrl
        Glide.with(holder.itemView.context)
            .load(video.imageUrl) // Usar la URL de la miniatura del video
            .into(holder.videoThumbnail) // Cargar la imagen en el ImageView

        holder.videoIcon.setImageResource(R.drawable.ic_play) // Cambia a tu ícono deseado
    }

    override fun getItemCount(): Int = videoList.size
}
