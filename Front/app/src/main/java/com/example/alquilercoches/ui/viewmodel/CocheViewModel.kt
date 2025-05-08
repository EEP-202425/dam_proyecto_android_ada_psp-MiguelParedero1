package com.example.alquilercocheapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alquilercocheapp.model.Coche
import com.example.alquilercocheapp.network.CocheApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed interface CocheUiState {
    data class Success(val coches: List<Coche>) : CocheUiState
    object Error : CocheUiState
    object Loading : CocheUiState
}

class CocheViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<CocheUiState>(CocheUiState.Loading)
    val uiState: StateFlow<CocheUiState> = _uiState

    init {
        getCoches()
    }

    private fun getCoches() {
        viewModelScope.launch {
            try {
                val listaCoches = CocheApi.retrofitService.getCoches()
                _uiState.value = CocheUiState.Success(listaCoches)
            } catch (e: Exception) {
                _uiState.value = CocheUiState.Error
            }
        }
    }
}
