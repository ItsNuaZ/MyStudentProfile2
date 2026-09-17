package com.example.mystudentprofile2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Screen 3 — Settings.
 * Dark Mode and Notifications reuse the SAME StudentViewModel state as the
 * other screens, so toggling here is reflected everywhere (and Dark Mode
 * actually re-themes the whole app, see MainActivity).
 */
@Composable
fun SettingsScreen(viewModel: StudentViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(text = "Settings", fontSize = 22.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(24.dp))

        // 9) Switch : Dark Mode
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Dark Mode")
            Switch(
                checked = viewModel.darkModeEnabled,
                onCheckedChange = { viewModel.darkModeEnabled = it }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 9) Switch : Notifications (shared state with Registration screen)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Notifications")
            Switch(
                checked = viewModel.notificationEnabled,
                onCheckedChange = { viewModel.notificationEnabled = it }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 6) ToggleButton -> IconToggleButton : Favorite
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Favorite")
            IconToggleButton(
                checked = viewModel.isFavorite,
                onCheckedChange = { viewModel.isFavorite = it }
            ) {
                Icon(
                    imageVector = if (viewModel.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite"
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Divider()
        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "About", fontWeight = FontWeight.Bold)
        Text(text = "Student Registration App")
    }
}