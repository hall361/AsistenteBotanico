package com.poli.botanicalassistant.ui.video

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.botanicalassistant.domain.video.Video
import com.poli.botanicalassistant.usecase.GetVideosUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class VideosViewModel(private val getVideosUseCase: GetVideosUseCase) : ViewModel() {
    private val _videos = MutableStateFlow<List<Video>>(emptyList())
    val videos: StateFlow<List<Video>> get() = _videos

    fun loadVideos() {
        viewModelScope.launch {
            getVideosUseCase().collect { videoList ->
                _videos.value = videoList
            }
        }
    }
}
