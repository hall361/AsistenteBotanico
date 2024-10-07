package com.poli.botanicalassistant.usecase.impl

import com.poli.botanicalassistant.data.video.repository.VideoRepository
import com.poli.botanicalassistant.domain.video.Video
import com.poli.botanicalassistant.usecase.GetVideosUseCase
import kotlinx.coroutines.flow.Flow

class GetVideosUseCaseImpl(private val videoRepository: VideoRepository) : GetVideosUseCase {
    override fun invoke(): Flow<List<Video>> {
        return videoRepository.getVideos()
    }
}
