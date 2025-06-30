package com.example.recloth.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.recloth.composables.LandingScreen
import com.example.recloth.composables.RecycleScreen

sealed class Screen(val route: String) {
    object Landing : Screen("landing")
    object Recycle : Screen("recycle")
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Landing.route
    ) {
        composable(Screen.Landing.route) {
            LandingScreen(
                onRecycleClick = {
                    navController.navigate(Screen.Recycle.route)
                }
            )
        }
        
        composable(Screen.Recycle.route) {
            RecycleScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
} 