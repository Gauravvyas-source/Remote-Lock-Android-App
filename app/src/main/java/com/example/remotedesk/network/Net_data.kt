package com.example.remotedesk.network

data class ApiResponse<T>(
  val success : Boolean,
  val data : T?,
  val error : String?
)

data class BatteryResponse(val battery: Int)

data class SystemResponse(val os: String)
