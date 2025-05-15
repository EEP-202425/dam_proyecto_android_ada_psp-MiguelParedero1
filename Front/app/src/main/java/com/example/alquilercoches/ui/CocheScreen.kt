package com.example.alquilercoches.ui  // ajústalo si usas otro paquete

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold               // <<— faltaba
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.alquilercoches.ui.model.Coche
import com.example.alquilercoches.ui.viewmodel.CocheUiState
import com.example.alquilercoches.ui.viewmodel.CocheViewModel



@Composable
fun CocheScreen(
    modifier: Modifier = Modifier,
    viewModel: CocheViewModel = viewModel(),
    onSelect: (Coche) -> Unit,
    onCreate: () -> Unit           // <— aquí
) {
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

    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            FloatingActionButton(onClick = onCreate) {
                Icon(Icons.Default.Add, contentDescription = "Crear coche")
            }
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            when (uiState) {
                is CocheUiState.Loading -> CircularProgressIndicator(Modifier.align(Alignment.Center))
                is CocheUiState.Success -> {
                    LazyColumn {
                        items(uiState.coches) { coche ->
                            CocheItem(
                                coche,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { onSelect(coche) }
                                    .padding(8.dp)
                            )
                        }
                    }
                }
                is CocheUiState.Error -> Text("Error al cargar", Modifier.align(Alignment.Center))
            }
        }
    }
}

@Composable
fun CocheItem(
    coche: Coche,
    modifier: Modifier = Modifier          // <— por defecto vacío
) {
    Card(
        modifier = modifier
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
