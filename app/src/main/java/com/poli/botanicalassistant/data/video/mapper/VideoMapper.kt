package com.poli.botanicalassistant.data.video.mapper

import com.poli.botanicalassistant.domain.video.Video
import com.poli.botanicalassistant.ui.video.VideoUi

fun Video.toUi() = VideoUi(
    id = this.id,
    videoName = this.videoName,
    creationDate = this.creationDate,
    duration = this.duration,
    category = this.category,
    author = this.author,
    serverId = this.serverId,
    imageUrl = this.imageUrl
)

fun List<Video>.toUiList() = this.map { it.toUi() }
