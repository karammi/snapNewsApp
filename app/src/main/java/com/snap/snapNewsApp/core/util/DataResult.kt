package com.snap.snapNewsApp.core.util

sealed class DataResult<out R> {
    class Success<T>(val value: T) : DataResult<T>()
    class Error(val errorBody: ApiErrorBody) : DataResult<Nothing>()
}
