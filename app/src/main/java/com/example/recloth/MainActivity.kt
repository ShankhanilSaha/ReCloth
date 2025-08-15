package com.example.recloth

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.recloth.navigation.AppNavigation
import com.example.recloth.navigation.Screen
import com.example.recloth.ui.theme.ReClothTheme
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val credentialManager: CredentialManager by lazy {
        CredentialManager.create(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReClothTheme {
                val navController = rememberNavController()
                AppNavigation(navController = navController,
                    signIn = {
                        signIn(navController)
                    })
//                LoginScreen(onSignInClick = {
//                    signIn()
//                })
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String,navController: NavController) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        FirebaseAuth.getInstance().signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("MainActivity", "Firebase sign-in success.")
                    val firebaseUser = FirebaseAuth.getInstance().currentUser
                    Log.d("MainActivity", "User UID: ${firebaseUser?.uid}")
                    // TODO: Navigate to your main app screen (AppNavigation) now.
                    navController.navigate(Screen.Landing.route)
                } else {
                    Log.w("MainActivity", "Firebase sign-in failed.", task.exception)
                }
            }
    }

    private fun signIn(navController: NavController) {
        val googleIdOption = GetGoogleIdOption.Builder()
            .setFilterByAuthorizedAccounts(false)
            .setServerClientId(getString(R.string.default_web_client_id))
            .build()
        val request = GetCredentialRequest.Builder()
            .addCredentialOption(googleIdOption)
            .build()
        lifecycleScope.launch {
            try {
                val result = credentialManager.getCredential(
                    request = request,
                    context = this@MainActivity
                )
                handleSignInSuccess(result.credential, navController)
            } catch (e: Exception) {
                Log.e("MainActivity", "Sign-in failed", e)
            }
        }
    }

    private fun handleSignInSuccess(credential: androidx.credentials.Credential,navController: NavController) {
        if (credential is CustomCredential && credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
            try {
                val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)
                val googleIdToken = googleIdTokenCredential.idToken
                Log.d("MainActivity", "Successfully got Google ID token: $googleIdToken")
                // TODO: Pass this token to your Firebase authentication function
                firebaseAuthWithGoogle(googleIdToken,navController)
            } catch (e: Exception) {
                Log.e("MainActivity", "Failed to create credential from data", e)
            }
        } else {
            Log.w("MainActivity", "Credential is not of type Google ID!")
        }
    }
}
