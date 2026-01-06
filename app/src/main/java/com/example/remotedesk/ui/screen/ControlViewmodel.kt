package com.example.remotedesk.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ControlViewmodel : ViewModel() {


    var batteryStatus by mutableStateOf("Unknown")
    private set
    var sytemStatus by mutableStateOf("Unknown")
    private set

    fun batteryStatus(){
        batteryStatus = "85% charging"
    }
    fun SystemStatus(){
        sytemStatus = "Window"
    }
    fun Locklaptop(){
         println("85% charging")
    }

}