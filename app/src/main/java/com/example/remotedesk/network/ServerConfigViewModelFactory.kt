package com.example.remotedesk.network

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ServerConfigViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ServerConfigViewModel::class.java)) {
            val store = ServerConfigStore(context.applicationContext)
            @Suppress("UNCHECKED_CAST")
            return ServerConfigViewModel(store) as T   // ✅ fixed constructor
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
