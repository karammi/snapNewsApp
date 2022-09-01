package com.snap.snapNewsApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.snap.snapNewsApp.core.ui.theme.SnapNewsAppTheme
import com.snap.snapNewsApp.press.presentation.screen.PressScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnapNewsAppTheme {
                NewsNavigator()
            }
        }
    }
}

@Composable
fun NewsNavigator() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.PressScreen.route
    ) {
        composable(route = Screen.PressScreen.route) {
            PressScreen(navController = navController)
        }
    }
}

sealed class Screen(val route: String) {
    object PressScreen : Screen(route = "pressScreen")
}
