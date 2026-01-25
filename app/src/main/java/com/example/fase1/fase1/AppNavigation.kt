package com.example.fase1.fase1

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("home") { HomeScreen(navController) }
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