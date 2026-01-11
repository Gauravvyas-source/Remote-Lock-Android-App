package com.example.remotedesk.network

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ServerConfigViewModel(
    private val store: ServerConfigStore
) : ViewModel() {

    val hostname = store.serverIpFlow
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = ""
        )

    val isPaired = store.isPairedFlow
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = false
        )

    fun saveHostName(value: String) {
        viewModelScope.launch {
            store.saveServerIp(value)
        }
    }

    fun clearHostname() {
        viewModelScope.launch {
            store.saveServerIp("")
        }
    }

    fun setPaired(value: Boolean) {
        viewModelScope.launch {
            store.setPaired(value)
        }
    }
}
