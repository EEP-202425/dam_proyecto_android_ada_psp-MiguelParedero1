// src/main/java/com/example/alquilercoches/ui/api/AuthApiService.kt
package com.example.alquilercoches.ui.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.POST

private const val BASE_URL = "http://10.0.2.2:8080/"

@Serializable
data class LoginRequest(val usuario: String, val password: String)

@Serializable
data class MessageResponse(val mensaje: String)

@Serializable
data class RegisterRequest(
    val nombre: String,
    val usuario: String,
    val telefono: String,
    val email: String,
    val password: String
)

@Serializable
data class RegisterResponse(val mensaje: String)

interface AuthApi {
    @POST("api/usuarios/login")
    suspend fun login(@Body req: LoginRequest): MessageResponse

    @POST("api/usuarios")          // coincide con @PostMapping("/api/usuarios")
    suspend fun register(@Body req: RegisterRequest): RegisterResponse
}

object AuthApiService {
    private val contentType = "application/json".toMediaType()
    private val json = Json { ignoreUnknownKeys = true }
    val service: AuthApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory(contentType))
            .client(OkHttpClient.Builder().build())
            .build()
            .create(AuthApi::class.java)
    }
}
