package com.poli.botanicalassistant.ui.garden.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/** Enum class representing different types of plant classifications. */
@Parcelize
enum class PlantTypeUi : Parcelable {

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
