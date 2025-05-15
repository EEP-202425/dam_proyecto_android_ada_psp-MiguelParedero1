package com.example.alquilercoches.ui.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel(),
    onLoggedIn: () -> Unit,
    onGoToRegister: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    var user by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

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
                label = { Text("Usuario") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = pass,
                onValueChange = { pass = it },
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextButton(onClick = onGoToRegister) {
                    Text("¿No tienes cuenta? Regístrate")
                }
                Button(onClick = { viewModel.login(user, pass) }) {
                    Text("Entrar")
                }
            }

            Spacer(Modifier.height(16.dp))

            when (uiState) {
                is AuthUiState.Loading -> CircularProgressIndicator()
                is AuthUiState.Success -> LaunchedEffect(uiState) { onLoggedIn() }
                is AuthUiState.Error   -> {
                    Text(
                        text = (uiState as AuthUiState.Error).error,
                        color = MaterialTheme.colorScheme.error
                    )
                }
                else -> { }
            }
        }
    }
}
