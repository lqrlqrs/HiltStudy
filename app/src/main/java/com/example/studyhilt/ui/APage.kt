package com.example.studyhilt.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.studyhilt.vm.StudentViewModel
import com.example.studyhilt.vm.TeacherViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun APage(
    selectedTab: Int,
    onSelectTab: (Int) -> Unit,
    onToB: () -> Unit,
    onToC: () -> Unit,
    teacherVm: TeacherViewModel,
    studentVm: StudentViewModel
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("A - Tabs") },
                actions = {
                    TextButton(onClick = onToB) { Text("到B") }
                    TextButton(onClick = onToC) { Text("到C") }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            TabRow(selectedTabIndex = selectedTab) {
                Tab(
                    selected = selectedTab == 0,
                    onClick = { onSelectTab(0) },
                    text = { Text("Teacher") }
                )
                Tab(
                    selected = selectedTab == 1,
                    onClick = { onSelectTab(1) },
                    text = { Text("Student") }
                )
            }
            when (selectedTab) {
                0 -> TeacherTab(teacherVm)
                else -> StudentTab(studentVm)
            }
        }
    }
}

@Composable
private fun TeacherTab(vm: TeacherViewModel) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Teacher VM: ${vm.id}")
        Spacer(Modifier.height(12.dp))
        Text(text = vm.message)
    }
}

@Composable
private fun StudentTab(vm: StudentViewModel) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Student VM: ${vm.id}")
        Spacer(Modifier.height(12.dp))
        Text(text = vm.message)
    }
}
