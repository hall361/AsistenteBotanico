package com.poli.botanicalassistant.data.video.repository

import com.poli.botanicalassistant.domain.video.Video
import kotlinx.coroutines.flow.Flow

interface VideoRepository {

    fun getVideos(): Flow<List<Video>>
}
