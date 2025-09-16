package com.example.studyhilt.vm

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CViewModel @Inject constructor() : ViewModel() {
    val title: String = "Page C"
}
