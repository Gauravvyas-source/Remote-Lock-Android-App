package com.example.remotedesk.Network

data class ApiResponse<T>(
  val success : Boolean,
  val data : T?,
  val error : String?
)

data class BatteryResponse(val battery: Int)

data class SystemResponse(val os: String)
