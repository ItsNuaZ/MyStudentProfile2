package com.example.studentregistration

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

/**
 * Single source of truth for all UI state in the app.
 * Shared across screens (Registration / Profile / Settings) through the
 * same ViewModel instance obtained in MainActivity, so a change made on
 * one screen (e.g. Notifications switch) is reflected on another.
 */
class StudentViewModel : ViewModel() {

    // 2) EditText -> TextField
    var studentName by mutableStateOf("")
    var studentId by mutableStateOf("")

    // 7) / 8) RadioButton + RadioGroup(as Column) -> single selection state
    var selectedDegree by mutableStateOf("Bachelor")

    // 5) CheckBox -> Skills
    var usePython by mutableStateOf(false)
    var useKotlin by mutableStateOf(false)
    var useJava by mutableStateOf(false)

    // 6) ToggleButton -> IconToggleButton
    var isFavorite by mutableStateOf(false)

    // 9) Switch
    var notificationEnabled by mutableStateOf(true)
    var darkModeEnabled by mutableStateOf(false)

    // 10) SeekBar -> Slider
    var interestLevel by mutableStateOf(50f)

    // 11) ProgressBar -> LinearProgressIndicator
    var profileProgress by mutableStateOf(0.75f)

    // 12) Button + Event Chain result
    var registered by mutableStateOf(false)
}