package com.poli.botanicalassistant.ui.garden.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Data class representing a plant.
 *
 * @property id Unique identifier for the plant.
 * @property commonName The common name of the plant.
 * @property scientificName The scientific name of the plant.
 * @property imageUrl URL of the plant's image.
 * @property classification The classification of the plant (indoor,
 *    outdoor, succulent, etc.).
 * @property careInfo Information on how to care for the plant.
 * @property lifeCycle Information about the plant's life cycle (growth
 *    speed, seasonality).
 * @property isOwned Indicates if the plant is owned by the user.
 */
@Parcelize
data class PlantUi(
    val id: String,
    val commonName: String,
    val scientificName: String,
    val imageUrl: String,
    val classification: PlantTypeUi,
    val careInfo: CareInfoUi,
    val lifeCycle: LifeCycleUi,
    val isOwned: Boolean
) : Parcelable
