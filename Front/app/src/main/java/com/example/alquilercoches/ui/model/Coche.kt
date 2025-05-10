package com.example.alquilercoches.ui.model

import kotlinx.serialization.Serializable

@Serializable
data class Coche(
    val id: Long,
    val marca: String,
    val modelo: String,
    val matricula: String,
    val disponible: Boolean,
    val precio: Double
)
