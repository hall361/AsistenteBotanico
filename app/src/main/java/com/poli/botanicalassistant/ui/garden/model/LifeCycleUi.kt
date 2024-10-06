package com.poli.botanicalassistant.ui.garden.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Data class representing the life cycle information of a plant.
 *
 * @property growthSpeed The speed at which the plant grows (slow,
 *    moderate, fast).
 * @property seasonality The seasonal behavior of the plant (flowering,
 *    dormancy, etc.).
 */
@Parcelize
data class LifeCycleUi(
    val growthSpeed: String,
    val seasonality: String
) : Parcelable
