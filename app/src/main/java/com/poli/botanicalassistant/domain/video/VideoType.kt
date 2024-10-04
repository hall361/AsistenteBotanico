package com.poli.botanicalassistant.domain.video

/**
 * Enum class que representa diferentes tipos de videos.
 */
enum class VideoType {
    COURSE,
    TUTORIAL,
    INFO,
    OTHER;

    companion object {
        /**
         * Convierte un valor de cadena en un enum de tipo VideoType.
         *
         * @param value La representación en cadena del tipo de video.
         * @return El VideoType correspondiente o OTHER si no se encuentra coincidencia.
         */
        fun fromString(value: String) = values().firstOrNull {
            it.name.equals(value, ignoreCase = true)
        } ?: OTHER
    }
}
