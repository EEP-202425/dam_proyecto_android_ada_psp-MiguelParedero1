package com.example.alquilercoches.ui.detalle

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.TopAppBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleCocheScreen(
    id: Long,
    onBack: () -> Unit,
    onEdit: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalle del coche #$id") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Volver")
                    }
                },
                actions = {
                    IconButton(onClick = onEdit) {
                        Icon(Icons.Filled.Edit, contentDescription = "Editar")
                    }
                }
            )
        }
    ) { padding ->
        // Aquí podrías fetchear el coche por id y mostrar sus detalles
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Text("Marca: …")
            Spacer(Modifier.height(8.dp))
            Text("Modelo: …")
            // etc.
        }
    }
}

