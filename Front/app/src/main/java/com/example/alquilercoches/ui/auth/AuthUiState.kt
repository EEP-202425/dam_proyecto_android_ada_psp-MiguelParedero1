package com.example.alquilercoches.ui.auth

sealed interface AuthUiState {
    object Idle    : AuthUiState
    object Loading : AuthUiState
    data class Success(val message: String) : AuthUiState
    data class Error  (val error: String)   : AuthUiState
}
