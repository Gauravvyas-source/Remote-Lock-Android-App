package com.example.remotedesk


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LockScreen()
        }
    }
}

@Composable
fun LockScreen() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(
                onClick = {
                    lockLaptop()
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("🔒 Lock Laptop")
            }
        }
    }
}

fun lockLaptop() {
    thread {
        try {
            val url = URL( "http://172.28.60.31:5000/lock?token=123456") // ⚠️ apna laptop IP
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            conn.connect()

            val responseCode = conn.responseCode
            println("Response code: $responseCode")

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
