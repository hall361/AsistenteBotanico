package com.poli.botanicalassistant.data.video.repository.impl

import com.poli.botanicalassistant.data.video.repository.VideoRepository
import com.poli.botanicalassistant.data.video.datasource.VideoDataSource
import com.poli.botanicalassistant.domain.video.Video
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class VideoRepositoryImpl(
    private val videoDataSource: VideoDataSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : VideoRepository {

    override fun getVideos(): Flow<List<Video>> = videoDataSource
        .getVideos()
        .flowOn(dispatcher)
}
