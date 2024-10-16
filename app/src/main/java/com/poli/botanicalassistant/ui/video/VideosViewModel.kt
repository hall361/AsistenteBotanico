package com.poli.botanicalassistant.ui.video

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.botanicalassistant.ui.video.mapper.toUiList
import com.poli.botanicalassistant.usecase.GetVideosUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class VideosViewModel(
    private val getVideosUseCase: GetVideosUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {
    private val _videosUiState = MutableStateFlow<VideosUiState>(VideosUiState.Loading)
    val videosUiState: StateFlow<VideosUiState> get() = _videosUiState

    fun loadVideos() {
        _videosUiState.value = VideosUiState.Loading
        viewModelScope.launch {
            getVideosUseCase()
                .map { videos -> videos.toUiList() }
                .flowOn(dispatcher)
                .collect { videos -> _videosUiState.value = VideosUiState.Success(videos) }
        }
    }
}
