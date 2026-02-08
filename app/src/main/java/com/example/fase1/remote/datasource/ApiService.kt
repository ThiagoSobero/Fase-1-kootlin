package com.example.fase1.remote.datasource

import com.example.fase1.Api.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("?inc=name,location,picture")
    suspend fun getContacts(
        @Query("key") apiKey: String,
        @Query("results") results: Int = 10
    ): ApiResponse
}