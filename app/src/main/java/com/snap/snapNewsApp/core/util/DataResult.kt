package com.snap.snapNewsApp.core.util

sealed class DataResult<out R> {
    class Success<T>(val value: T) : DataResult<T>()
    class Error(val errorBody: ApiErrorBody?) : DataResult<Nothing>()
}

inline fun <R, T> DataResult<T>.map(transform: (value: T) -> R): DataResult<R> {
    return when (this) {
        is DataResult.Success -> DataResult.Success(transform(value as T))
        else -> DataResult.Error(
            errorBody = ApiErrorBody(
                code = "",
                message = ""
            )
        )
    }
}
