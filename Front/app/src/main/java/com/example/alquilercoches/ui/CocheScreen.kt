package com.example.alquilercoches.ui  // ajústalo si usas otro paquete

import androidx.compose.foundation.layout.*                // Box, LazyColumn, etc.
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*                          // CircularProgressIndicator, Card, MaterialTheme…
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState               // collectAsState()
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment                         // Alignment.Center
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel         // viewModel()
import com.example.alquilercoches.ui.model.Coche
import com.example.alquilercoches.ui.viewmodel.CocheUiState
import com.example.alquilercoches.ui.viewmodel.CocheViewModel

@Composable
fun CocheScreen(
    modifier: Modifier = Modifier,
    viewModel: CocheViewModel = viewModel()               // <— aquí
) {
    // Observa el StateFlow del ViewModel
    val uiState = viewModel.uiState.collectAsState().value

    Box(modifier = modifier) {
        when (uiState) {
            is CocheUiState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            is CocheUiState.Success -> {
                val coches = (uiState as CocheUiState.Success).coches
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(coches) { coche ->
                        CocheItem(coche)
                    }
                }
            }
            is CocheUiState.Error -> {
                Box(
                    Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Error al cargar")
                }
            }
        }
    }
}

@Composable
fun CocheItem(coche: Coche) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("${coche.marca} ${coche.modelo}", style = MaterialTheme.typography.titleLarge)
            Text("Matrícula: ${coche.matricula}")
            Text("Precio: ${coche.precio} €/día")
            Text(if (coche.disponible) "Disponible" else "No disponible")
        }
    }
}
