package com.poli.botanicalassistant.ui.video.util

interface VideoTextUiUtil {

    fun formatVideoDuration(duration: Int): String {
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
