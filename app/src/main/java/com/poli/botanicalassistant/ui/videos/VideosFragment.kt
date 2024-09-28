package com.poli.botanicalassistant.ui.videos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.poli.botanicalassistant.R
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.poli.botanicalassistant.domain.video.Video
import com.poli.botanicalassistant.domain.video.VideoType
import androidx.navigation.fragment.findNavController
import com.poli.botanicalassistant.ui.videos.VideosFragmentDirections

class VideosFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var videoAdapter: VideoAdapter
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_videos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        videoAdapter = VideoAdapter(getVideoList()) { videoId ->
            // Navegar al VideoPlayerFragment pasando el serverId como videoId
            val action = VideosFragmentDirections.actionVideosFragmentToVideoPlayerFragment(videoId)
            findNavController().navigate(action)
        }
        recyclerView.adapter = videoAdapter

        // Configurar el SwipeRefreshLayout
        swipeRefreshLayout.setOnRefreshListener {
            refreshVideoList() // Método que refresca la lista de videos
        }
    }

    private fun refreshVideoList() {
        videoAdapter.notifyDataSetChanged() // Asegúrate de notificar al adaptador de los cambios
        swipeRefreshLayout.isRefreshing = false // Detener la animación de refresco
    }

    // Ajustado para incluir la imagen del video usando el campo "imageUrl"
    private fun getVideoList(): List<Video> {
        return listOf(
            Video(
                id = "BA01",
                videoName = "El REINO DE LAS PLANTAS",
                creationDate = "2021-10-06",
                duration = 804,
                category = VideoType.INFO,
                author = "Lifeder Educación",
                serverId = "https://www.youtube.com/watch?v=eCyfEb3B0SM",
                imageUrl = "https://img.youtube.com/vi/eCyfEb3B0SM/0.jpg" // URL de la imagen del video
            ),
            Video(
                id = "BA02",
                videoName = "El CICLO DEL AGUA", // Aquí puedes agregar el nombre del video
                creationDate = "2021-10-07", // Fecha de creación
                duration = 708, // Duración en segundos
                category = VideoType.INFO, // Cambiar a la categoría apropiada
                author = "Lifeder Educación", // Nombre del autor
                serverId = "https://www.youtube.com/watch?v=uwEGrB7fSgo", // URL del video
                imageUrl = "https://img.youtube.com/vi/uwEGrB7fSgo/0.jpg" // URL de la imagen del video
            )


            // Puedes agregar más videos aquí si es necesario
        )
    }
}
