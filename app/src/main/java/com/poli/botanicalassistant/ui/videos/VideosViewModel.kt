package com.poli.botanicalassistant.ui.videos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.poli.botanicalassistant.domain.video.Video
import com.poli.botanicalassistant.domain.video.VideoType

/**
 * ViewModel that handles the logic for the VideosFragment.
 */
class VideosViewModel : ViewModel() {

    // LiveData que contiene la lista de videos
    private val _videos = MutableLiveData<List<Video>>()
    val videos: LiveData<List<Video>> get() = _videos

    /**
     * Carga una lista inicial de videos (puedes reemplazarla con la lógica real).
     */
    fun loadInitialVideos() {
        // Simulación de carga de videos. Reemplaza esto con la carga real desde un repositorio o API.
        val sampleVideos = listOf(
            Video(
                id = "BA01",
                videoName = "El REINO DE LAS PLANTAS",
                creationDate = "2021-10-06",
                duration = 804,
                category = VideoType.INFO, // Categoría del video
                author = "Lifeder Educación",
                serverId = "https://www.youtube.com/watch?v=eCyfEb3B0SM",
                imageUrl = "https://img.youtube.com/vi/eCyfEb3B0SM/0.jpg" // URL de la imagen del video
            )
            // Puedes agregar más videos aquí si es necesario
        )
        _videos.value = sampleVideos
    }
}
