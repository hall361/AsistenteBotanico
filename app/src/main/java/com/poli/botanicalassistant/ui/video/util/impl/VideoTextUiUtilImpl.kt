package com.poli.botanicalassistant.ui.video.util.impl

import com.poli.botanicalassistant.ui.video.util.VideoTextUiUtil

class VideoTextUiUtilImpl : VideoTextUiUtil {

    override fun formatVideoDuration(duration: Int): String {
        val hours = duration / 3600
        val minutes = (duration % 3600) / 60
        val remainingSeconds = duration % 60

        return when {
            hours > 0 -> "${hours}h:${minutes}m:${remainingSeconds}s"
            minutes > 0 -> "${minutes}m:${remainingSeconds}s"
            else -> "${remainingSeconds}s"
        }
    }
}
