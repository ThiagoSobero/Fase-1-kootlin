package com.example.fase1.ui.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class RandomApiResponse(
    val results: List<RandomUser>
)

@Serializable
data class RandomUser(
    val name: Name
)

@Serializable
data class Name(
    val first: String,
    val last: String
)