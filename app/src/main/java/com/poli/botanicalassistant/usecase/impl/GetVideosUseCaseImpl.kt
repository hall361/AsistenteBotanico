package com.poli.botanicalassistant.usecase.impl

import com.poli.botanicalassistant.data.video.repository.VideoRepository
import com.poli.botanicalassistant.domain.video.Video
import com.poli.botanicalassistant.usecase.GetVideosUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class GetVideosUseCaseImpl(
    private val videoRepository: VideoRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : GetVideosUseCase {

    override fun invoke(): Flow<List<Video>> = videoRepository
        .getVideos()
        .flowOn(dispatcher)
}
