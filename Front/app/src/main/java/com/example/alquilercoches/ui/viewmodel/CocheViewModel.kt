package com.example.alquilercoches.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alquilercoches.ui.api.CocheApi
import com.example.alquilercoches.ui.model.Coche
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// Your UI state sealed interface
sealed interface CocheUiState {
    object Loading : CocheUiState
    data class Success(val coches: List<Coche>) : CocheUiState
    data class Error(val message: String) : CocheUiState
}

class CocheViewModel : ViewModel() {
    private val _uiState =
        MutableStateFlow<CocheUiState>(CocheUiState.Loading)
    val uiState: StateFlow<CocheUiState> = _uiState

    init { fetchCoches() }

    private fun fetchCoches() = viewModelScope.launch {
        _uiState.value = CocheUiState.Loading
        try {
            val page = CocheApi.retrofitService.getCoches()    // ahora es PageWrapper<Coche>
            _uiState.value = CocheUiState.Success(page.content)
        } catch (e: Exception) {
            _uiState.value = CocheUiState.Error(e.message ?: "Error desconocido")
        }
    }

    fun loadCoches() = fetchCoches()
}
