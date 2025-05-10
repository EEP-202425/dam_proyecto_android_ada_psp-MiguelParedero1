package com.example.alquilercoches.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alquilercoches.ui.api.CocheApi
import com.example.alquilercoches.ui.model.Coche
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed interface CocheUiState {
    object Loading : CocheUiState
    data class Success(val coches: List<Coche>) : CocheUiState
    object Error : CocheUiState
}

class CocheViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<CocheUiState>(CocheUiState.Loading)
    val uiState: StateFlow<CocheUiState> = _uiState

    init {
        fetchCoches()
    }

    private fun fetchCoches() {
        viewModelScope.launch {
            _uiState.value = CocheUiState.Loading
            _uiState.value = try {
                val lista = CocheApi.retrofitService.getCoches()
                CocheUiState.Success(lista)
            } catch (e: Exception) {
                CocheUiState.Error
            }
        }
    }
}