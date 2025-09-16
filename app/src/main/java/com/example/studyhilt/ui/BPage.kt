package com.example.studyhilt.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.studyhilt.vm.BViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BPage(vm: BViewModel, onBack: () -> Unit) {
    Scaffold(topBar = { TopAppBar(title = { Text(vm.title) }) }) { inner ->
        Box(Modifier.fillMaxSize().padding(inner), contentAlignment = Alignment.Center) {
            Button(onClick = onBack) { Text("返回A") }
        }
    }
}
