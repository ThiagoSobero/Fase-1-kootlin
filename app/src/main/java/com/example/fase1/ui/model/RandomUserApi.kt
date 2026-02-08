package com.example.fase1.ui.model


import com.example.fase1.data.local.UserResponse
import retrofit2.http.GET

interface RandomUserApi {

    @GET("api/?results=10")
    suspend fun getUsers(): UserResponse
}