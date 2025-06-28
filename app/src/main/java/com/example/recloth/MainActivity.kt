package com.example.recloth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.recloth.navigation.AppNavigation
import com.example.recloth.ui.theme.ReClothTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReClothTheme {
                val navController = rememberNavController()
                AppNavigation(navController = navController)
            }
        }
    }
}
