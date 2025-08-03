package com.example.recloth

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.content.ContextCompat
import androidx.credentials.GetCredentialRequest
import androidx.navigation.compose.rememberNavController
import com.example.recloth.navigation.AppNavigation
import com.example.recloth.ui.theme.ReClothTheme
import com.google.android.libraries.identity.googleid.GetGoogleIdOption

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val googleIdOption = GetGoogleIdOption.Builder()
                .setFilterByAuthorizedAccounts(true)
                .setServerClientId(baseContext.getString(R.string.default_web_client_id))
                .build()

            val request = GetCredentialRequest.Builder()
                .addCredentialOption(googleIdOption)
                .build()
            val locationPermissionsAlreadyGranted = ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
            ReClothTheme {
                val navController = rememberNavController()
                AppNavigation(navController = navController)
            }
        }
    }
}
