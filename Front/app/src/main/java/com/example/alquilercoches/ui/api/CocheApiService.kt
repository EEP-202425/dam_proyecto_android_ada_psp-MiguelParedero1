package com.example.alquilercoches.ui.api

import com.example.alquilercoches.ui.model.Coche
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "http://10.0.2.2:8080/" // o tu host real

private val retrofit = Retrofit.Builder()
    .addConverterFactory(
        Json { ignoreUnknownKeys = true }
            .asConverterFactory("application/json".toMediaType())
    )
    .baseUrl(BASE_URL)
    .build()

interface CocheApiService {
    @GET("api/coches")
    suspend fun getCoches(): List<Coche>
}

object CocheApi {
    val retrofitService: CocheApiService by lazy {
        retrofit.create(CocheApiService::class.java)
    }
}

