package com.example.remotedesk.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remotedesk.Network.ApiClient
import kotlinx.coroutines.launch

class ControlViewmodel : ViewModel() {


    var batteryStatus by mutableStateOf("Unknown")
    private set
    var sytemStatus by mutableStateOf("Unknown")
    private set

    fun batteryStatus(){
        viewModelScope.launch {
            try {
                val response = ApiClient.apiService.getBatteryStatus("123456")

                if (response.isSuccessful) {

                    val body = response.body()

                    if (body?.success == true && body.data != null) {
                        batteryStatus = "Battery: ${body.data.battery}%"
                    } else {
                        batteryStatus = body?.error ?: "Unknown error"
                    }

                } else {
                    batteryStatus = "HTTP Error: ${response.code()}"
                }

            } catch (e: Exception) {
                batteryStatus = "Error: ${e.message}"
            }
        }
    }
    fun SystemStatus(){
        viewModelScope.launch {
            try {
                val response = ApiClient.apiService.getSystemStatus("123456")
                if (response.isSuccessful) {

                    val body = response.body()

                    if (body?.success == true && body.data != null) {
                        sytemStatus = "System : ${body.data.os}"
                    } else {
                        sytemStatus = body?.error ?: "Unknown error"
                    }
                }
                    else{
                        sytemStatus = "HTTP Error: ${response.code()}"
                    }

            }catch (e : Exception){
                sytemStatus = "Error: ${e.message}"
            }
        }
    }
    fun Locklaptop(){
        viewModelScope.launch{
            try{
                val response = ApiClient.apiService.locklaptop("123456")

                if (response.isSuccessful) {
                    val body = response.body()

                    if (body?.success == true) {
                        // Backend ne lock kar diya
                        println(body.data ?: "Laptop locked successfully")
                    } else {
                        println(body?.error ?: "Lock failed")
                    }

                } else {
                    println("HTTP Error: ${response.code()}")
                }


            }catch (e : Exception){
                println("Exception: ${e.message}")
            }
        }

    }

}