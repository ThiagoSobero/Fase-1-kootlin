package com.example.fase1.fase1

sealed class Routes(val route: String) {
    object Login : Routes("login")
    object Home : Routes("home")
    object Detail : Routes("detail/{name}") {
        fun createRoute(name: String) = "detail/$name"
    }
}