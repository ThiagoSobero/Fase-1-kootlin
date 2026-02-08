package com.example.fase1.ui.model

import kotlinx.serialization.Serializable


@Serializable
data class RandomuserApiResponse(
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