package com.poli.botanicalassistant.domain.video

/**
 * Represents a video with its associated data.
 *
 * @property id Unique identifier for the video.
 * @property videoName The name or title of the video.
 * @property creationDate The date the video was created.
 * @property duration The length of the video in seconds.
 * @property category The category or type of the video.
 * @property author The author or creator of the video.
 * @property serverId Identifier for the server where the video is hosted.
 * @property imageUrl The URL for the video's thumbnail image.
 */
data class Video(
    val id: String = "",
    val videoName: String = "",
    val creationDate: String = "",
    val duration: Int = 0,
    val category: List<VideoType> = listOf(),
    val author: String = "",
    val serverId: String = "",
    val imageUrl: String = ""
)
