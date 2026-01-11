package com.example.fase1.App

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Login.route
    ) {
        composable(Routes.Login.route) {
            LoginScreen(navController)
        }
        composable(Routes.Home.route) {
            HomeScreen(navController)
        }
        composable(
            Routes.Detail.route,
            arguments = listOf(navArgument("name") {
                type = NavType.StringType
            })
        ) {
            val name = it.arguments?.getString("name") ?: ""
            DetailScreen(
                name = name,
                navController = navController
            )
        }
    }
}