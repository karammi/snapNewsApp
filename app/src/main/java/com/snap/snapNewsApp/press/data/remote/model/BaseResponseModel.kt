package com.snap.snapNewsApp.press.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BaseResponseModel<out T>(
    val status: String,
    @Json(name = "sources")
    val data: T? = null,
    val code: String? = null,
    val message: String? = null
)
