package com.poli.botanicalassistant.ui.garden

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.botanicalassistant.ui.garden.GardenUiState.Loading
import com.poli.botanicalassistant.ui.garden.GardenUiState.Success
import com.poli.botanicalassistant.usecase.GetPlantsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class GardenViewModel(
    private val getPlantsUseCase: GetPlantsUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _plantsStateFlow = MutableStateFlow<GardenUiState>(Loading)
    val plantsStateFlow: StateFlow<GardenUiState> get() = _plantsStateFlow

    fun loadPlants() {
        _plantsStateFlow.value = Loading
        viewModelScope.launch {
            getPlantsUseCase()
                .flowOn(dispatcher)
                .collect { plants -> _plantsStateFlow.value = Success(plants) }
        }
    }
}
