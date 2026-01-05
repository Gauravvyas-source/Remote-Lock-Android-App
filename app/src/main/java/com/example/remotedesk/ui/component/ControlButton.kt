package com.example.remotedesk.ui.component

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ControlButton(
    text: String,
    icon: ImageVector,
    onclick: () -> Unit
) {
    var pressed by remember { mutableStateOf(false) }

    // ✅ Animation value (Dp)
    val elevationValue by animateDpAsState(
        targetValue = if (pressed) 4.dp else 12.dp,
        label = "card_elevation"
    )

    Card(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .clickable {
                pressed = true
                onclick()
                pressed = false
            },

        // ✅ FIXED PART (Material 3 way)
        elevation = CardDefaults.cardElevation(
            defaultElevation = elevationValue
        ),

        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(icon, contentDescription = null)
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = text)
        }
    }
}
