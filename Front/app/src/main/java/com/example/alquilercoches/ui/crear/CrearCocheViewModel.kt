package com.example.alquilercoches.ui.crear

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.alquilercoches.ui.api.CocheApi
import com.example.alquilercoches.ui.model.Coche
import com.example.alquilercoches.ui.crear.CrearCocheUiState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

// (importa aquí tu sealed interface CrearCocheUiState)

class CrearCocheViewModel(private val editId: Long?) : ViewModel() {
    private val _uiState = MutableStateFlow<CrearCocheUiState>(CrearCocheUiState.Loading)
    val uiState: StateFlow<CrearCocheUiState> = _uiState.asStateFlow()



    init {
        if (editId != null) loadExisting()
        else _uiState.value = CrearCocheUiState.Form("", "", "", "", true)
    }

    private fun loadExisting() = viewModelScope.launch {
        _uiState.value = CrearCocheUiState.Loading
        try {
            val coche = CocheApi.retrofitService.getCocheById(editId!!)
            _uiState.value = CrearCocheUiState.Form(
                marca = coche.marca,
                modelo = coche.modelo,
                matricula = coche.matricula,
                precio = coche.precio.toString(),
                disponible = coche.disponible
            )
        } catch (e: Exception) {
            _uiState.value = CrearCocheUiState.Error
        }
    }

    // Cambios de campo
    fun onMarcaChange(v: String) = update { it.copy(marca = v) }
    fun onModeloChange(v: String) = update { it.copy(modelo = v) }
    fun onMatriculaChange(v: String) = update { it.copy(matricula = v) }
    fun onPrecioChange(v: String) = update { it.copy(precio = v) }
    fun onDisponibleChange(v: Boolean) = update { it.copy(disponible = v) }

    private fun update(fn: (CrearCocheUiState.Form) -> CrearCocheUiState.Form) {
        val current = _uiState.value
        if (current is CrearCocheUiState.Form) {
            _uiState.value = fn(current)
        }
    }

    /**
     * Guarda (POST o PUT), recupera el coche resultante del API
     * y lo pasa al callback onSaved.
     */
    fun save(onSaved: (Coche) -> Unit) = viewModelScope.launch {
        val current = _uiState.value
        if (current !is CrearCocheUiState.Form) return@launch

        val toSend = Coche(
            id = editId ?: 0L,
            marca = current.marca,
            modelo = current.modelo,
            matricula = current.matricula,
            disponible = current.disponible,
            precio = current.precio.toDoubleOrNull() ?: 0.0
        )

        try {
            val resultado = if (editId == null) {
                CocheApi.retrofitService.createCoche(toSend)
            } else {
                CocheApi.retrofitService.updateCoche(editId, toSend)
            }
            // devolvemos el coche tal cual nos llegó del servidor
            onSaved(resultado)
        } catch (e: Exception) {
            // aquí podrías emitir un error en uiState o mostrar un Snackbar...
        }
    }



    object Factory : ViewModelProvider.Factory {
        private var _editId: Long? = null
        operator fun invoke(editId: Long?) = apply { _editId = editId }
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CrearCocheViewModel(_editId) as T
        }
    }
}
