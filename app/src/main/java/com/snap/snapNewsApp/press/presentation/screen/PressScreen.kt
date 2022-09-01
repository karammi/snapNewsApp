package com.snap.snapNewsApp.press.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.snap.snapNewsApp.press.presentation.viewModel.PressViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PressScreen(
    navController: NavController,
    pressViewModel: PressViewModel = hiltViewModel()
) {
    val uiState = pressViewModel.pressUiState.collectAsState()

    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(text = "this is the first test")
        }
    }
}
