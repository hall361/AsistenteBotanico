package com.poli.botanicalassistant.domain.plant

/** Enum class representing different types of plant classifications. */
enum class PlantType {

    /** Plants that are suited for indoor environments. */
    INDOOR,

    /** Plants that are suited for outdoor environments. */
    OUTDOOR,

    /** Plants that are classified as succulents. */
    SUCCULENT,

    /** Other types of plants that don't fall into the previous categories. */
    OTHER;

    companion object {
        fun fromString(value: String) = entries
            .firstOrNull { type -> type.name.equals(value, ignoreCase = true) }
            ?: OTHER
    }
}
