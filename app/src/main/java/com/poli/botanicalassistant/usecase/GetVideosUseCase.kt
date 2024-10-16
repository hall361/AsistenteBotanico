package com.poli.botanicalassistant.usecase

import com.poli.botanicalassistant.domain.video.Video
import kotlinx.coroutines.flow.Flow

interface GetVideosUseCase {

    operator fun invoke(): Flow<List<Video>>
}
