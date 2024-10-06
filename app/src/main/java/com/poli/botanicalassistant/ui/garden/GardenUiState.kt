package com.poli.botanicalassistant.ui.garden

import com.poli.botanicalassistant.domain.plant.Plant

sealed class GardenUiState {
    data class Success(val plants: List<Plant>) : GardenUiState()
    data object Loading : GardenUiState()
}
