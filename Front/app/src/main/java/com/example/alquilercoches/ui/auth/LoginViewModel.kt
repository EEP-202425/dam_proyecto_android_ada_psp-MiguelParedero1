package com.example.alquilercoches.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.example.alquilercoches.ui.api.AuthApiService
import com.example.alquilercoches.ui.api.LoginRequest
import retrofit2.HttpException

class LoginViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<AuthUiState>(AuthUiState.Idle)
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    fun login(usuario: String, password: String) = viewModelScope.launch {
        _uiState.value = AuthUiState.Loading
        try {
            val resp = AuthApiService
                .service
                .login(LoginRequest(usuario = usuario, password = password))

            if (resp.mensaje == "Log In exitoso") {
                _uiState.value = AuthUiState.Success(usuario)
            } else {
                _uiState.value = AuthUiState.Error("Usuario o contraseña incorrectos")
            }
        } catch (e: HttpException) {
            if (e.code() == 401) {
                _uiState.value = AuthUiState.Error("Usuario o contraseña incorrectos")
            } else {
                _uiState.value = AuthUiState.Error("Error HTTP ${e.code()}")
            }
        } catch (e: Exception) {
            _uiState.value = AuthUiState.Error("Error de red: ${e.localizedMessage}")
        }
    }
}
