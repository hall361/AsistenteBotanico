package com.poli.botanicalassistant.di

import com.poli.botanicalassistant.data.video.datasource.VideoDataSource
import com.poli.botanicalassistant.data.video.datasource.impl.VideoDataSourceImpl
import com.poli.botanicalassistant.data.video.repository.VideoRepository
import com.poli.botanicalassistant.data.video.repository.impl.VideoRepositoryImpl
import com.poli.botanicalassistant.ui.video.VideoAdapter
import com.poli.botanicalassistant.ui.video.VideosViewModel
import com.poli.botanicalassistant.ui.video.util.VideoTextUiUtil
import com.poli.botanicalassistant.ui.video.util.impl.VideoTextUiUtilImpl
import com.poli.botanicalassistant.usecase.GetVideosUseCase
import com.poli.botanicalassistant.usecase.impl.GetVideosUseCaseImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val videoModule = module {

    single<VideoDataSource> {
        VideoDataSourceImpl(
            firestore = get()
        )
    }

    single<VideoRepository> {
        VideoRepositoryImpl(
            videoDataSource = get()
        )
    }

    factory<GetVideosUseCase> {
        GetVideosUseCaseImpl(
            videoRepository = get()
        )
    }

    viewModel {
        VideosViewModel(
            getVideosUseCase = get()
        )
    }

    single<VideoTextUiUtil> {
        VideoTextUiUtilImpl()
    }

    factory {
        VideoAdapter(
            imageManager = get(),
            videoTextUiUtil = get(),
        )
    }
}
