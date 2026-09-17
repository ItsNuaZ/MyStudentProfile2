package com.example.mystudentprofile2

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class StudentViewModel : ViewModel() {
    var studentName by mutableStateOf("")
    var studentId by mutableStateOf("")

    var selectedDegree by mutableStateOf("Bachelor")

    var usePython by mutableStateOf(false)
    var useKotlin by mutableStateOf(false)
    var useJava by mutableStateOf(false)

    var isFavorite by mutableStateOf(false)

    var notificationEnabled by mutableStateOf(true)
    var darkModeEnabled by mutableStateOf(false)

    var interestLevel by mutableStateOf(50f)

    var profileProgress by mutableStateOf(0.75f)

    var registered by mutableStateOf(false)
}