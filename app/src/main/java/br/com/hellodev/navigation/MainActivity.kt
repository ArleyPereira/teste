package br.com.hellodev.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import br.com.hellodev.navigation.navigation.SetupNavHost
import br.com.hellodev.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationTheme {
                val navController = rememberNavController()
                SetupNavHost(navController = navController)
            }
        }
    }
}