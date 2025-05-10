package com.example.carrentalapp.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.carrentalapp.presentation.viewmodel.SpeedMonitorViewModel
import kotlinx.coroutines.flow.collectLatest



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpeedMonitorScreen(
    viewModel: SpeedMonitorViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val message = remember { mutableStateOf("Waiting for speed updates...") }

    LaunchedEffect(Unit) {
        viewModel.speedWarnings.collectLatest {
            message.value = it
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Speed Monitor") }
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = message.value,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    )
}
