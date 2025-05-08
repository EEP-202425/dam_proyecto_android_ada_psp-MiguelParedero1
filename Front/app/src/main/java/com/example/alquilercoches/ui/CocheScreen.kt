package com.example.alquilercocheapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.alquilercocheapp.model.Coche
import com.example.alquilercocheapp.viewmodel.CocheUiState
import com.example.alquilercocheapp.viewmodel.CocheViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun CocheScreen(
    cocheViewModel: CocheViewModel = viewModel()
) {
    val uiState by cocheViewModel.uiState.collectAsState()

    when (uiState) {
        is CocheUiState.Loading -> {
            CircularProgressIndicator()
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
            Text("Error cargando los coches")
        }
    }
}

@Composable
fun CocheItem(coche: Coche) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "${coche.marca} ${coche.modelo}", style = MaterialTheme.typography.titleLarge)
            Text(text = "Matrícula: ${coche.matricula}")
            Text(text = "Precio: ${coche.precio} €/día")
            Text(text = if (coche.disponible) "Disponible" else "No disponible")
        }
    }
}
