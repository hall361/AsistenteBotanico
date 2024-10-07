package com.poli.botanicalassistant.data.video.repository.impl

import com.poli.botanicalassistant.data.video.repository.VideoRepository
import com.poli.botanicalassistant.data.video.datasource.VideoDataSource
import com.poli.botanicalassistant.domain.video.Video
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class VideoRepositoryImpl(
    private val videoDataSource: VideoDataSource
) : VideoRepository {

    override fun getVideos(): Flow<List<Video>> = videoDataSource.getVideos()
}
