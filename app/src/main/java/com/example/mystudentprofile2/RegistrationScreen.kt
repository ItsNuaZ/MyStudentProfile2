package com.example.mystudentprofile2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegistrationScreen(
    viewModel: StudentViewModel,
    onRegisterSuccess: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Student Registration",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(contentAlignment = Alignment.BottomEnd) {
            Image(
                painter = painterResource(id = R.drawable.student),
                contentDescription = "Student Photo",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )
            IconButton(onClick = {
                println("Edit profile photo")
            }) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit photo")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Name", modifier = Modifier.align(Alignment.Start))
        TextField(
            value = viewModel.studentName,
            onValueChange = { viewModel.studentName = it },
            label = { Text("Enter your name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Student ID", modifier = Modifier.align(Alignment.Start))
        TextField(
            value = viewModel.studentId,
            onValueChange = { viewModel.studentId = it },
            label = { Text("6612345678") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Degree", modifier = Modifier.align(Alignment.Start), fontWeight = FontWeight.Bold)
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = viewModel.selectedDegree == "Bachelor",
                    onClick = { viewModel.selectedDegree = "Bachelor" }
                )
                Text("Bachelor")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = viewModel.selectedDegree == "Master",
                    onClick = { viewModel.selectedDegree = "Master" }
                )
                Text("Master")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Skills", modifier = Modifier.align(Alignment.Start), fontWeight = FontWeight.Bold)
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = viewModel.usePython, onCheckedChange = { viewModel.usePython = it })
                Text("Python")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = viewModel.useKotlin, onCheckedChange = { viewModel.useKotlin = it })
                Text("Kotlin")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = viewModel.useJava, onCheckedChange = { viewModel.useJava = it })
                Text("Java")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Notifications ${if (viewModel.notificationEnabled) "ON" else "OFF"}")
            Switch(
                checked = viewModel.notificationEnabled,
                onCheckedChange = { viewModel.notificationEnabled = it }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Interest Level: ${viewModel.interestLevel.toInt()}%",
            modifier = Modifier.align(Alignment.Start)
        )
        Slider(
            value = viewModel.interestLevel,
            onValueChange = { viewModel.interestLevel = it },
            valueRange = 0f..100f
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Profile Completion: ${(viewModel.profileProgress * 100).toInt()}%",
            modifier = Modifier.align(Alignment.Start)
        )
        LinearProgressIndicator(
            progress = { viewModel.profileProgress },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                viewModel.registered = true
                onRegisterSuccess()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("REGISTER")
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}