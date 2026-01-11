package com.example.remotedesk.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.remotedesk.network.ServerConfigViewModel
import com.example.remotedesk.ui.screen.ControlScreen
import com.example.remotedesk.ui.screen.ConnectScreen

@Composable
fun AppNavGraph(viewModel: ServerConfigViewModel) {

    val navController = rememberNavController()
    val isPaired by viewModel.isPaired.collectAsState()

    NavHost(
        navController = navController,
        startDestination = "connect"
    ) {

        composable("connect") {
            ConnectScreen(
                onConnected = {
                    viewModel.setPaired(true)   // ✅ सिर्फ state change
                }
            )
        }

        composable("control") {
            ControlScreen(
                onDisconnect = {
                    viewModel.setPaired(false)  // ✅ सिर्फ state change
                }
            )
        }
    }

    // ✅ SAFE STATE-BASED NAVIGATION
    LaunchedEffect(isPaired) {
        val currentRoute = navController.currentBackStackEntry?.destination?.route
        if (isPaired && currentRoute != "control") {
            navController.navigate("control") {
                popUpTo("connect") { inclusive = true }
            }
        } else if (!isPaired && currentRoute != "connect") {
            navController.navigate("connect") {
                popUpTo("control") { inclusive = true }
            }
        }
    }
}
