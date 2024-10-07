package com.poli.botanicalassistant.ui.video.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import com.poli.botanicalassistant.domain.video.VideoType

@Parcelize
data class VideoUi(
    val id: String,
    val videoName: String,
    val creationDate: String,
    val duration: Int,
    val category: List<VideoType>,
    val author: String,
    val serverId: String,
    val imageUrl: String
) : Parcelable
