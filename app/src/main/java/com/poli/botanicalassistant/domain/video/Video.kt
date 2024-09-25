package com.poli.botanicalassistant.domain.video

import com.poli.botanicalassistant.domain.plant.CareInfo
import com.poli.botanicalassistant.domain.plant.LifeCycle
import com.poli.botanicalassistant.domain.plant.PlantType

/**
 * Data class representing a plant.
 *
 * @property id Unique identifier for the video.
 * @property videoName The video name of the plant.
 * @property creationDate The Creation Date of the plant.
 * @property duration The Creation Date of the plant.
 * @property category The Category of the plant (Course, Info, etc.).
 * @property author The Author of the plant.
 * @property URL URL of the Videos.
 */


data class Video(
    val id: String,
    val videoName: String,
    val creationDate: String,
    val duration: Int,
    val category: List<String>,
    val author: String,
    val URL: String,

)
