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
import androidx.compose.runtime.produceState
import com.example.alquilercoches.ui.api.CocheApi
import com.example.alquilercoches.ui.model.Coche


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleCocheScreen(
    id: Long,
    onBack: () -> Unit,
    onEdit: () -> Unit
) {
    val state = produceState<Coche?>(initialValue = null, id) {
        value = try {
            CocheApi.retrofitService.getCocheById(id)
        } catch (e: Exception) {
            null
        }
    }

    val coche = state.value
    if (coche == null) {
        CircularProgressIndicator(modifier = Modifier.padding(16.dp))
    } else {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Marca: ${coche.marca}")
            Text("Modelo: ${coche.modelo}")
            Text("Precio: ${coche.precio}")
            Button(onClick = onBack, modifier = Modifier.padding(top = 16.dp)) { Text("Volver") }
            Button(onClick = onEdit, modifier = Modifier.padding(top = 8.dp)) { Text("Editar") }
        }
    }
}
