package com.example.alquilercoches.ui.crear

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.alquilercoches.ui.model.Coche
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ArrowBack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CrearCocheScreen(
    editId: Long? = null,
    viewModel: CrearCocheViewModel = viewModel(factory = CrearCocheViewModel.Factory(editId)),
    onSave: (Coche) -> Unit,
    onCancel: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (editId == null) "Nuevo coche" else "Editar coche") },
                navigationIcon = {
                    IconButton(onClick = onCancel) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    viewModel.save { cocheGuardado ->
                        onSave(cocheGuardado)
                    }
                },
                icon    = { Icon(Icons.Filled.Check, contentDescription = "Guardar") },
                text    = { Text("Guardar") },
                modifier= Modifier.padding(16.dp)
            )
        }
    ) { padding ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when (val state = uiState) {
                is CrearCocheUiState.Loading -> {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
                is CrearCocheUiState.Form -> {
                    CrearCocheForm(
                        marca             = state.marca,
                        modelo            = state.modelo,
                        matricula         = state.matricula,
                        precio            = state.precio,
                        disponible        = state.disponible,
                        onMarcaChange     = viewModel::onMarcaChange,
                        onModeloChange    = viewModel::onModeloChange,
                        onMatriculaChange = viewModel::onMatriculaChange,
                        onPrecioChange    = viewModel::onPrecioChange,
                        onDisponibleChange= viewModel::onDisponibleChange
                    )
                }
                is CrearCocheUiState.Error -> {
                    Text(
                        "Error cargando datos.",
                        Modifier.align(Alignment.Center),
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        }
    }
}

@Composable
private fun CrearCocheForm(
    marca: String,
    modelo: String,
    matricula: String,
    precio: String,
    disponible: Boolean,
    onMarcaChange: (String) -> Unit,
    onModeloChange: (String) -> Unit,
    onMatriculaChange: (String) -> Unit,
    onPrecioChange: (String) -> Unit,
    onDisponibleChange: (Boolean) -> Unit,
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value       = marca,
            onValueChange = onMarcaChange,
            label       = { Text("Marca") },
            modifier    = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value       = modelo,
            onValueChange = onModeloChange,
            label       = { Text("Modelo") },
            modifier    = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value       = matricula,
            onValueChange = onMatriculaChange,
            label       = { Text("Matrícula") },
            modifier    = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value       = precio,
            onValueChange = onPrecioChange,
            label       = { Text("Precio €/día") },
            singleLine  = true,
            modifier    = Modifier.fillMaxWidth()
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked         = disponible,
                onCheckedChange = onDisponibleChange
            )
            Spacer(Modifier.width(8.dp))
            Text("Disponible")
        }
    }
}
