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
            // Manejar el clic en el video aquí (puedes navegar a otro fragmento o actividad)
        }
        recyclerView.adapter = videoAdapter

        // Configurar el SwipeRefreshLayout
        swipeRefreshLayout.setOnRefreshListener {
            refreshVideoList() // Método que refresca la lista de videos
        }

        // Obtener videoId de los argumentos (si se necesita)
        val videoId = arguments?.getString("videoId") // Asegúrate de usarlo si es necesario
        if (videoId != null) {
            // Lógica para usar videoId
            // Por ejemplo, puedes cargar un video específico aquí
        }
    }

    private fun refreshVideoList() {
        // Aquí puedes recargar la lista de videos (por ejemplo, desde una API o fuente de datos)
        videoAdapter.notifyDataSetChanged() // Asegúrate de notificar al adaptador de los cambios
        swipeRefreshLayout.isRefreshing = false // Detener la animación de refresco
    }

    private fun getVideoList(): List<Video> {
        // Aquí deberías llenar la lista con tus datos de video
        return listOf(
            Video("1", "Video 1", "2024-01-01", 120, listOf("Categoría 1", "Categoría 2"), "Autor 1", "Servidor 1"),
            Video("2", "Video 2", "2024-01-02", 150, listOf("Categoría 2"), "Autor 2", "Servidor 2")
            // Agrega más videos aquí
        )
    }
}
