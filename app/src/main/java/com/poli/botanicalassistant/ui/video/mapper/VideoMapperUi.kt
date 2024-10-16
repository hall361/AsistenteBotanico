package com.poli.botanicalassistant.ui.video.mapper

import com.poli.botanicalassistant.domain.video.Video
import com.poli.botanicalassistant.ui.video.model.VideoUi

fun Video.toUi() = VideoUi(
    id = this.id,
    videoName = this.videoName,
    creationDate = creationDate,
    duration = duration,
    category = category,
    author = author,
    serverId = serverId,
    imageUrl = imageUrl
)

fun List<Video>.toUiList() = map { domainModel -> domainModel.toUi() }
