package com.example.alquilercoches.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alquilercoches.ui.api.CocheApi
import com.example.alquilercoches.ui.model.Coche
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import android.util.Log

// Estado de UI
sealed interface CocheUiState {
    object Loading : CocheUiState
    data class Success(val coches: List<Coche>) : CocheUiState
    data class Error(val mensaje: String) : CocheUiState
}

class CocheViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<CocheUiState>(CocheUiState.Loading)
    val uiState: StateFlow<CocheUiState> = _uiState

    init {
        fetchCoches()
    }

    fun loadCoches() = fetchCoches()

    fun fetchCoches() {
        viewModelScope.launch {
            _uiState.value = CocheUiState.Loading
            try {
                val page = CocheApi.retrofitService.getCoches()
                val lista = page.content
                val disponibles = lista.filter { it.disponible }
                _uiState.value = CocheUiState.Success(disponibles)
            } catch (e: Exception) {
                Log.e("CocheVM", "Error al cargar coches", e)
                _uiState.value = CocheUiState.Error(e.message ?: "Error desconocido")
            }
        }
    }

    fun rentCoche(coche: Coche) {
        viewModelScope.launch {
            try {
                val actualizado = coche.copy(disponible = false)
                CocheApi.retrofitService.updateCoche(coche.id, actualizado)
                fetchCoches()
            } catch (e: Exception) {
                Log.e("CocheVM", "Error al alquilar coche ${coche.id}", e)

            }
        }
    }
}
