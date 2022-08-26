package com.snap.snapNewsApp.press.domain.model

data class BaseResponse<out T>(
    val status: String,
    val data: T,
    val code: String,
    val message: String
)
