package com.poli.botanicalassistant.data.video.datasource

import com.poli.botanicalassistant.domain.video.Video
import kotlinx.coroutines.flow.Flow

interface VideoDataSource {

    fun getVideos(): Flow<List<Video>>
}
