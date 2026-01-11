package com.example.remotedesk.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BatteryChargingFull
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.remotedesk.ui.component.ControlButton

@Composable
fun ControlScreen(viewmodel: ControlViewmodel = viewModel() ,
                  onDisconnect : () -> Unit ) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF0F2027),
                        Color(0xFF203A43),
                        Color(0xFF2C5364)
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Remote Desk",
                color = Color.White
            )

            Spacer(modifier = Modifier.height(40.dp))

            ControlButton(
                text = "Lock Laptop",
                icon = Icons.Default.Lock,
                onclick = { viewmodel.Locklaptop() }
            )

            Spacer(modifier = Modifier.height(16.dp))

            ControlButton(
                text = "Battery Status",
                icon = Icons.Default.BatteryChargingFull,
                onclick = { viewmodel.batteryStatus() }
            )

            Spacer(modifier = Modifier.height(16.dp))

            ControlButton(
                text = "System Status",
                icon = Icons.Default.Info,
                onclick = { viewmodel.SystemStatus() }
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                InfoBox(
                    title = "Battery",
                    value = viewmodel.batteryStatus,
                    modifier = Modifier.weight(1f)
                )

                InfoBox(
                    title = "System",
                    value = viewmodel.sytemStatus,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun InfoBox(
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .height(90.dp)
            .background(
                color = Color(0xFF1B1B1B),
                shape = RoundedCornerShape(18.dp)
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = title, color = Color.Gray)
        if (value.isNotBlank()) {
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = value, color = Color.White)
        }
    }
}
