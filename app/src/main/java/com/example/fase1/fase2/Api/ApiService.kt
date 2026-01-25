package com.example.fase1.fase2.Api

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/iv9bqexh")
    suspend fun getContacts(
        @Query("key") apiKey: String,
        @Query("results") results: Int = 10
    ): ApiResponse
}
