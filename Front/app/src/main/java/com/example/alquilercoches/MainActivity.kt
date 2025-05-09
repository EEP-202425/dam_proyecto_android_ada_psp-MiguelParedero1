package com.example.alquilercoches

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding           // <— aquí
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.alquilercoches.ui.CocheScreen
import com.example.alquilercoches.ui.theme.AlquilerCochesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlquilerCochesTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { contentPadding ->              // renombrado de `padding` a `contentPadding`
                    CocheScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(contentPadding)      // ahora ya se resuelve correctamente
                    )
                }
            }
        }
    }
}
