package com.poli.botanicalassistant.ui.garden.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.botanicalassistant.ui.garden.list.GardenUiState.Loading
import com.poli.botanicalassistant.ui.garden.list.GardenUiState.Success
import com.poli.botanicalassistant.ui.garden.mapper.toUiList
import com.poli.botanicalassistant.usecase.GetPlantsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class GardenViewModel(
    private val getPlantsUseCase: GetPlantsUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _gardenUiState = MutableStateFlow<GardenUiState>(Loading)
    val gardenUiState: StateFlow<GardenUiState> get() = _gardenUiState

    fun loadPlants() {
        _gardenUiState.value = Loading
        viewModelScope.launch {
            getPlantsUseCase()
                .map { plants -> plants.toUiList() }
                .flowOn(dispatcher)
                .collect { plants -> _gardenUiState.value = Success(plants) }
        }
    }
}
