package com.snap.snapNewsApp.core.util

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiErrorBody(
    val code: String? = null,
    val message: String? = null
)
