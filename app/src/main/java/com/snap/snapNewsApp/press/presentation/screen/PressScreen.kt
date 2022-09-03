package com.snap.snapNewsApp.press.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.snap.snapNewsApp.press.domain.model.Press
import com.snap.snapNewsApp.press.presentation.viewModel.PressViewModel
import com.snap.snapNewsApp.press.presentation.viewModel.UiState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PressScreen(
    navController: NavController,
    pressViewModel: PressViewModel = hiltViewModel()
) {
    val uiState = pressViewModel.pressUiState.collectAsState()

    when (uiState.value.pressList) {
        is UiState.Error -> {
            Text(text = uiState.value.pressList.error?.message.toString())
        }
        UiState.Loading -> {
            CircularProgressIndicator()
        }
        is UiState.Success -> {
            Scaffold(modifier = Modifier.fillMaxSize()) {
                LazyColumn {
                    items(uiState.value.pressList.data?.size ?: 0) { index: Int ->
                        PressItems(
                            press = uiState.value.pressList.data!![index],
                            onPressItemClicked = { press ->
                                println(press)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PressItems(press: Press, onPressItemClicked: (Press) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(8.dp)
            .clickable { onPressItemClicked(press) },
        elevation = 12.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    16.dp
                )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = press.name,
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        fontSize = 20.sp
                    )
                )
                Text(text = press.country)
            }

            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = press.category,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )
                )
                Text(text = press.language)
            }
            Row(
                modifier = Modifier.fillMaxWidth()
                    .wrapContentHeight(align = Alignment.CenterVertically)
                    .padding(
                        top = 4.dp
                    )
            ) {
                Text(
                    text = press.description,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        color = Color.Gray,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    )
                )
            }
        }
    }
}
