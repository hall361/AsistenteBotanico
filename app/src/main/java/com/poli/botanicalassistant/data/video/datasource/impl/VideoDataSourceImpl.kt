package com.poli.botanicalassistant.data.video.datasource.impl

import com.google.firebase.firestore.FirebaseFirestore
import com.poli.botanicalassistant.data.video.datasource.VideoDataSource
import com.poli.botanicalassistant.domain.video.Video
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await

class VideoDataSourceImpl(
    private val firestore: FirebaseFirestore,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : VideoDataSource {

    override fun getVideos(): Flow<List<Video>> = flow {
        val videos = firestore.collection(COLLECTION_NAME)
            .get()
            .await()
            .toObjects(Video::class.java)
        emit(videos)
    }.flowOn(dispatcher)

    companion object {
        private const val COLLECTION_NAME = "videos"
    }
}
