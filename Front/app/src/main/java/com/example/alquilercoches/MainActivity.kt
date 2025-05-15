package com.example.alquilercoches

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.alquilercoches.ui.CocheScreen
import com.example.alquilercoches.ui.auth.LoginScreen
import com.example.alquilercoches.ui.auth.RegisterScreen
import com.example.alquilercoches.ui.crear.CrearCocheScreen
import com.example.alquilercoches.ui.detalle.DetalleCocheScreen
import com.example.alquilercoches.ui.theme.AlquilerCochesTheme
import com.example.alquilercoches.ui.viewmodel.CocheViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlquilerCochesTheme {
                val navController = rememberNavController()
                // ViewModel compartido para la lista de coches:
                val listVm: CocheViewModel = viewModel()

                Scaffold { innerPadding ->
                    Box(Modifier.padding(innerPadding)) {
                        NavHost(navController, startDestination = "login") {
                            composable("login") {
                                LoginScreen(
                                    onLoggedIn    = {
                                        navController.navigate("listado") {
                                            popUpTo("login") { inclusive = true }
                                        }
                                    },
                                    onGoToRegister = {
                                        navController.navigate("register")
                                    }
                                )
                            }
                            composable("register") {
                                RegisterScreen(onRegistered = {
                                    navController.navigate("listado") {
                                        popUpTo("login") { inclusive = true }
                                    }
                                })
                            }


                            // --- LISTADO / DETALLE / CREAR ---
                            composable("listado") {
                                CocheScreen(
                                    viewModel = listVm,
                                    modifier = Modifier.fillMaxSize(),
                                    onSelect = { coche ->
                                        navController.navigate("detalle/${coche.id}")
                                    },
                                    onCreate = {
                                        navController.navigate("crear")
                                    }
                                )
                            }
                            composable(
                                route = "detalle/{id}",
                                arguments = listOf(navArgument("id") { type = NavType.LongType })
                            ) { backStack ->
                                val id = backStack.arguments!!.getLong("id")
                                DetalleCocheScreen(
                                    id = id,
                                    onBack = { navController.popBackStack() },
                                    onEdit = {
                                        navController.navigate("crear?editId=$id")
                                    }
                                )
                            }
                            composable(
                                route = "crear?editId={editId}",
                                arguments = listOf(navArgument("editId") {
                                    type = NavType.LongType
                                    defaultValue = -1L
                                })
                            ) { backStack ->
                                val editId = backStack.arguments!!
                                    .getLong("editId")
                                    .takeIf { it >= 0L }
                                CrearCocheScreen(
                                    editId = editId,
                                    onSave = { nueva ->
                                        listVm.loadCoches()
                                        navController.popBackStack("listado", inclusive = false)
                                    },
                                    onCancel = {
                                        navController.popBackStack()
                                    }
                                )
                            }
                        }

                    }
                }
            }
        }
    }
}
