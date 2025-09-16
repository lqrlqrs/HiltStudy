package com.example.studyhilt.vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import java.util.UUID

@HiltViewModel
class StudentViewModel @Inject constructor() : ViewModel() {
	val id: String = UUID.randomUUID().toString()
	var message by mutableStateOf("Student Tab")
}
