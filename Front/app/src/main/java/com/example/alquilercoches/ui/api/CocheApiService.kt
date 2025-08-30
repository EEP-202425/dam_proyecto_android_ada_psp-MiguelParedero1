package com.example.alquilercoches.ui.api

import com.example.alquilercoches.ui.model.Coche
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.Response
import retrofit2.http.Query


private const val BASE_URL = "http://10.0.2.2:8080/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(
        Json { ignoreUnknownKeys = true }
            .asConverterFactory("application/json".toMediaType())
    )
    .baseUrl(BASE_URL)
    .build()

interface CocheApiService {
    @Serializable
    data class PageWrapper<T>(
        val content: List<T>,         // la lista de Coche
        val totalElements: Long,
        val totalPages: Int,
        val number: Int,
    )

    @GET("api/coches")
    suspend fun getCoches(
        @Query("numPagina") numPagina: Int = 0,
        @Query("marca") marca: String? = null
    ): PageWrapper<Coche>


    @GET("api/coches/{id}")
    suspend fun getCocheById(@Path("id") id: Long): Coche

    @POST("api/coches")
    suspend fun createCoche(@Body coche: Coche): Coche

    @PUT("api/coches/{id}")
    suspend fun updateCoche(@Path("id") id: Long, @Body coche: Coche): Coche

    @DELETE("api/coches/{id}")
    suspend fun deleteCoche(@Path("id") id: Long): Response<Unit>
}

object CocheApi {
    val retrofitService: CocheApiService by lazy {
        retrofit.create(CocheApiService::class.java)
    }
}

