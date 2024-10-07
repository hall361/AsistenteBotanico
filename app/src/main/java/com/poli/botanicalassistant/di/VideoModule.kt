package com.poli.botanicalassistant.di

import com.google.firebase.firestore.FirebaseFirestore
import com.poli.botanicalassistant.data.video.datasource.VideoDataSource
import com.poli.botanicalassistant.data.video.datasource.impl.VideoDataSourceImpl
import com.poli.botanicalassistant.data.video.repository.VideoRepository
import com.poli.botanicalassistant.data.video.repository.impl.VideoRepositoryImpl
import com.poli.botanicalassistant.ui.video.VideosViewModel
import com.poli.botanicalassistant.usecase.GetVideosUseCase
import com.poli.botanicalassistant.usecase.impl.GetVideosUseCaseImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val videoModule = module {
    single { FirebaseFirestore.getInstance() }
    single<VideoDataSource> { VideoDataSourceImpl(get()) }
    single<VideoRepository> { VideoRepositoryImpl(get()) }
    factory<GetVideosUseCase> { GetVideosUseCaseImpl(get()) }
    viewModel { VideosViewModel(get()) }
}
