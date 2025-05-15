package com.example.alquilercoches.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alquilercoches.ui.api.AuthApiService
import com.example.alquilercoches.ui.api.RegisterRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// RegisterViewModel.kt
class RegisterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<AuthUiState>(AuthUiState.Idle)
    val uiState: StateFlow<AuthUiState> = _uiState

    fun register(usuario: String, password: String, email: String) = viewModelScope.launch {
        _uiState.value = AuthUiState.Loading
        try {
            // aquí rellenamos nombre = usuario y teléfono vacío
            val req = RegisterRequest(
                nombre   = usuario,
                usuario  = usuario,
                telefono = "",
                email    = email,
                password = password
            )
            val resp = AuthApiService.service.register(req)
            _uiState.value = AuthUiState.Success(resp.mensaje)
        } catch(e: Exception) {
            _uiState.value = AuthUiState.Error("No se pudo registrar: ${e.message}")
        }
    }
}

