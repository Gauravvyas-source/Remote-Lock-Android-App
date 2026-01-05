package com.example.remotedesk.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.remotedesk.ui.component.ControlButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.BatteryChargingFull

@Composable
fun ControlScreen() {

    // 🔹 STEP 1: MAIN SURFACE (ONLY ONE)
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF0F2027),
                        Color(0xFF203A43),
                        Color(0xFF2C5364)
                    )
                )
            )
    ) {

        // 🔹 STEP 4: SCREEN ENTRY ANIMATION
        AnimatedVisibility(
            visible = true,
            enter = fadeIn()
        ) {

            // 🔹 STEP 3: LAYOUT
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                ControlButton(
                    text = "Lock Laptop",
                    icon = Icons.Default.Lock,
                    onclick = { println("Lock button clicked")}
                )

                Spacer(modifier = Modifier.height(16.dp))

                ControlButton(
                    text = "Battery Status",
                    icon = Icons.Default.BatteryChargingFull,
                    onclick = {   println("Battery button clicked")}
                )

                Spacer(modifier = Modifier.height(16.dp))

                ControlButton(
                    text = "System Status",
                    icon = Icons.Default.Info,
                    onclick = {  println("Status button clicked")}
                )
            }
        }
    }
}
