package com.poli.botanicalassistant.ui.video

import com.poli.botanicalassistant.ui.video.model.VideoUi

sealed class VideosUiState {

    data object Loading : VideosUiState()

    data class Success(val videos: List<VideoUi>) : VideosUiState()
}
