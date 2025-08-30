package com.example.alquilercoches.ui.crear

sealed interface CrearCocheUiState {
    object Loading : CrearCocheUiState

    data class Form(
        val marca: String,
        val modelo: String,
        val matricula: String,
        val precio: String,
        val disponible: Boolean
    ) : CrearCocheUiState

    object Error : CrearCocheUiState
}
