package com.poli.botanicalassistant.domain.video

/**
 * Enum class representing different types of videos.
 */
enum class VideoType {
    COURSE,      // Course video
    TUTORIAL,    // Tutorial video
    INFO,        // Informational video
    OTHER;       // Other types of videos

    companion object {
        /**
         * Converts a string value into a VideoType enum.
         *
         * @param value The string representation of the video type.
         * @return The corresponding VideoType or OTHER if not found.
         */
        fun fromString(value: String) = values().firstOrNull {
            it.name.equals(value, ignoreCase = true)
        } ?: OTHER
    }
}
