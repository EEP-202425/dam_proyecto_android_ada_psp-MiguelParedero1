package com.example.alquilercoches.ui.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = viewModel(),
    onRegistered: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    var user  by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var pass  by remember { mutableStateOf("") }

    Scaffold { padding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = user,
                onValueChange = { user = it },
                label = { Text("Username") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = pass,
                onValueChange = { pass = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
            Button(
                onClick = { viewModel.register(user, pass, email) },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Registrar")
            }

            Spacer(Modifier.height(16.dp))
            when (uiState) {
                AuthUiState.Loading           -> CircularProgressIndicator()
                is AuthUiState.Success        -> LaunchedEffect(uiState) { onRegistered() }
                is AuthUiState.Error          ->
                    Text((uiState as AuthUiState.Error).error, color = MaterialTheme.colorScheme.error)
                else                          -> {}
            }
        }
    }
}
