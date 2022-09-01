package com.snap.snapNewsApp.press.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snap.snapNewsApp.core.util.ApiErrorBody
import com.snap.snapNewsApp.core.util.DataResult
import com.snap.snapNewsApp.press.domain.model.Press
import com.snap.snapNewsApp.press.domain.useCase.FetchHeadlinesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * T is Data model
 * R is Error model
 * */

sealed class UiState<out T, out R>(open val data: T? = null, open val error: R? = null) {
    object Loading : UiState<Nothing, Nothing>()
    class Success<T>(override val data: T?) : UiState<T, Nothing>()
    class Error<R>(override val error: R?) : UiState<Nothing, R>()
}

data class PressUiState(
    private val pressList: UiState<List<Press>, ApiErrorBody> = UiState.Loading
)

@HiltViewModel
class PressViewModel @Inject constructor(
    private val fetchHeadlinesUseCase: FetchHeadlinesUseCase
) : ViewModel() {

    val pressUiState = MutableStateFlow(PressUiState())

    init {
        fetchPressHeadlines()
    }

    private fun fetchPressHeadlines() {
        viewModelScope.launch {
            val response = fetchHeadlinesUseCase.invoke()
            when (response) {
                is DataResult.Error -> {
                    pressUiState.emit(
                        value = pressUiState.value.copy(
                            pressList = UiState.Error(
                                error = ApiErrorBody(
                                    response.errorBody?.code,
                                    response.errorBody?.message
                                )
                            )
                        )
                    )
                }
                is DataResult.Success -> {
                    pressUiState.emit(
                        value = pressUiState.value.copy(
                            pressList = UiState.Success(data = response.value)
                        )
                    )
                }
            }
        }
    }
}
