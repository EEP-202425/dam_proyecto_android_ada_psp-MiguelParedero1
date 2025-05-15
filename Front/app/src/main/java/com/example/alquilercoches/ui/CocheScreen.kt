package com.example.alquilercoches.ui.viewmodel

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.alquilercoches.ui.model.Coche

@Composable
fun CocheScreen(
    viewModel: CocheViewModel = viewModel(),
    onSelect: (Coche) -> Unit,
    onCreate: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onCreate) {
                Icon(Icons.Default.Add, contentDescription = "Nuevo coche")
            }
        }
    ) { padding ->
        Box(Modifier.padding(padding)) {
            when (uiState) {
                is CocheUiState.Loading -> {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
                is CocheUiState.Error -> {
                    Text(
                        text = (uiState as CocheUiState.Error).mensaje,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.Center)
                    )
                }
                is CocheUiState.Success -> {
                    val lista = (uiState as CocheUiState.Success).coches
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(lista) { coche ->
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                elevation = CardDefaults.cardElevation(4.dp)
                            ) {
                                Column(Modifier.padding(16.dp)) {
                                    Text(
                                        text = coche.marca,
                                        style = MaterialTheme.typography.titleMedium
                                    )
                                    Text("Matrícula: ${coche.matricula}")
                                    Text("Precio: ${coche.precio} €/día")
                                    Text(if (coche.disponible) "Disponible" else "No disponible")
                                    Spacer(Modifier.height(8.dp))
                                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                        Button(onClick = { onSelect(coche) }) {
                                            Text("Ver detalle")
                                        }
                                        Button(
                                            onClick = { viewModel.rentCoche(coche) },
                                            enabled = coche.disponible
                                        ) {
                                            Text("Alquilar")
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
