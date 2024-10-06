package com.poli.botanicalassistant.ui.garden.list

import com.poli.botanicalassistant.ui.garden.model.PlantUi

sealed class GardenUiState {
    data class Success(val plants: List<PlantUi>) : GardenUiState()
    data object Loading : GardenUiState()
}
