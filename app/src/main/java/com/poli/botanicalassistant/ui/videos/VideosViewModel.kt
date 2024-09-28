package com.poli.botanicalassistant.ui.videos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.poli.botanicalassistant.domain.video.Video

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
            Video("1", "Curso Kotlin", "2024-01-01", 1200, listOf("Course"), "Autor 1", "Server1"),
            Video("2", "Tutorial Android", "2024-02-01", 900, listOf("Tutorial"), "Autor 2", "Server2")
        )
        _videos.value = sampleVideos
    }
}
