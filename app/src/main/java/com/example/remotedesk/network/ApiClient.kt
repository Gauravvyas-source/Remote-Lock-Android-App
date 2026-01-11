package com.example.remotedesk.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object ApiClient{
    private const val BASE_URL = "http://192.168.31.40:5000/"
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiService : ApiService by lazy{
retrofit.create(ApiService:: class.java)
    }
}
interface ApiService{
    @GET("lock")
    suspend fun locklaptop (@Query ("token") token : String): retrofit2.Response<ApiResponse<String>>


    @GET("battery")

    suspend fun getBatteryStatus(
        @Query ("token") token : String
    ): retrofit2.Response<ApiResponse<BatteryResponse>>

    @GET("status")
    suspend fun getSystemStatus(@Query ("token") token : String): retrofit2.Response<ApiResponse<SystemResponse>>
}