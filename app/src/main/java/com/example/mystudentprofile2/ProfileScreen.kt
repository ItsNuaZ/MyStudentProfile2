package com.example.studentregistration

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Screen 2 — Profile.
 * Reads (does not mutate) the shared StudentViewModel state that was
 * produced on the Registration screen -> a pure "State -> UI" screen.
 */
@Composable
fun ProfileScreen(viewModel: StudentViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "My Profile", fontSize = 22.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Box(contentAlignment = Alignment.BottomEnd) {
            Image(
                painter = painterResource(id = R.drawable.student),
                contentDescription = "Student Photo",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )
            IconButton(onClick = { println("Edit profile") }) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        val displayName = viewModel.studentName.ifBlank { "Somchai Jaidee" }
        Text(text = displayName, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = "Computer Science")
        Text(text = "ID: ${viewModel.studentId.ifBlank { "6612345678" }}")

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Degree", fontWeight = FontWeight.Bold)
        Text(text = viewModel.selectedDegree)

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Skills", fontWeight = FontWeight.Bold)
        val skills = buildList {
            if (viewModel.usePython) add("Python")
            if (viewModel.useKotlin) add("Kotlin")
            if (viewModel.useJava) add("Java")
        }
        Text(text = if (skills.isEmpty()) "-" else skills.joinToString(" • "))

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Interest", fontWeight = FontWeight.Bold)
        LinearProgressIndicator(
            progress = { viewModel.interestLevel / 100f },
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = "${viewModel.interestLevel.toInt()}%")

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Notification ${if (viewModel.notificationEnabled) "ON" else "OFF"}")
    }
}