package com.example.remotedesk


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.remotedesk.network.ServerConfigViewModel
import com.example.remotedesk.network.ServerConfigViewModelFactory
import com.example.remotedesk.ui.navigation.AppNavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val factory = ServerConfigViewModelFactory(this)
            val serverConfigViewModel: ServerConfigViewModel =
                viewModel(factory = factory)
            LaunchedEffect (Unit){
                serverConfigViewModel.setPaired(false)
            }
            AppNavGraph(serverConfigViewModel)

        }
    }
}

