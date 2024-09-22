package com.poli.botanicalassistant.domain.plant

/**
 * Data class representing the life cycle information of a plant.
 *
 * @property growthSpeed The speed at which the plant grows (slow,
 *    moderate, fast).
 * @property seasonality The seasonal behavior of the plant (flowering,
 *    dormancy, etc.).
 */
data class LifeCycle(
    val growthSpeed: String,
    val seasonality: String
)
