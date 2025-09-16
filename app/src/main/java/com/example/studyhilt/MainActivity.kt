package com.example.studyhilt

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EntryScreen(
                onOpenA = { startActivity(Intent(this, AActivity::class.java).putExtra("start", "A")) },
                onOpenC = { startActivity(Intent(this, AActivity::class.java).putExtra("start", "C")) }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntryScreen(onOpenA: () -> Unit, onOpenC: () -> Unit) {
    Scaffold(topBar = { TopAppBar(title = { Text("Main Entry") }) }) { inner ->
        Column(
            modifier = Modifier.fillMaxSize().padding(inner).padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = onOpenA, modifier = Modifier.fillMaxWidth()) { Text("进入A (Tabs)") }
            Spacer(Modifier.height(12.dp))
            Button(onClick = onOpenC, modifier = Modifier.fillMaxWidth()) { Text("进入C 页面") }
        }
    }
}