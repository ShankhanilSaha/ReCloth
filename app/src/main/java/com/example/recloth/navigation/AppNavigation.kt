package com.example.recloth.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.recloth.composables.LandingScreen
import com.example.recloth.composables.LoginScreen
import com.example.recloth.composables.RecycleScreen

sealed class Screen(val route: String) {
    object Landing : Screen("landing")
    object Recycle : Screen("recycle")
    object Login : Screen("login")
}

@Composable
fun AppNavigation(navController: NavHostController, signIn: ()-> Unit) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
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

        composable(Screen.Login.route) {
            LoginScreen(
                onSignInClick = {
                    signIn()
                }
            )
        }
    }
} 