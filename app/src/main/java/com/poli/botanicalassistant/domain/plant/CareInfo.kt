package com.poli.botanicalassistant.domain.plant

/**
 * Data class representing care information for a plant.
 *
 * @property waterAmount The amount of water the plant needs.
 * @property light The type of light the plant requires (direct, indirect,
 *    etc.).
 * @property temperature The ideal temperature range for the plant.
 * @property humidity The ideal humidity level for the plant.
 */
data class CareInfo(
    val waterAmount: String,
    val light: String,
    val temperature: String,
    val humidity: String
)
