package com.example.studyhilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.studyhilt.ui.APage
import com.example.studyhilt.ui.BPage
import com.example.studyhilt.ui.CPage
import com.example.studyhilt.vm.BViewModel
import com.example.studyhilt.vm.CViewModel
import com.example.studyhilt.vm.StudentViewModel
import com.example.studyhilt.vm.TeacherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val start = intent.getStringExtra("start") // "A" or "C"
        setContent {
            AActivityScreen(
                start = start,
                finish = { this.finish() }
            )
        }
    }
}

@Composable
private fun AActivityScreen (
    start: String?,
    finish: () -> Unit
) {
    val navController = rememberNavController()
    val startDestination = if (start == "C") "C" else "A"

    NavHost(
        navController = navController,
        startDestination = startDestination,
        route = "rootA"
    ) {
        // A：单一目的地，内部用状态切换Tab（不入返回栈）
        composable("A") {
            var selectedTab by rememberSaveable { mutableIntStateOf(0) }
            val teacherVm: TeacherViewModel = hiltViewModel()
            val studentVm: StudentViewModel = hiltViewModel()
            APage(
                selectedTab = selectedTab,
                onSelectTab = { to -> selectedTab = to },
                onToB = { navController.navigate("B") },
                onToC = { navController.navigate("C") },
                teacherVm = teacherVm,
                studentVm = studentVm
            )
        }

        // B：独立目的地（可选）
        composable("B") {
            val vm: BViewModel = hiltViewModel()
            BPage(vm = vm, onBack = { navController.popBackStack() })
        }
        // C：独立目的地
        composable("C") {
            val vm: CViewModel = hiltViewModel()
            CPage(vm = vm, onBack = {
                val success = navController.popBackStack()
                if (!success) {
                    finish()
                }
            })
        }
    }
}
