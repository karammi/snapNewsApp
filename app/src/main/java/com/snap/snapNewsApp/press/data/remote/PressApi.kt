package com.snap.snapNewsApp.press.data.remote

import com.snap.snapNewsApp.press.data.remote.model.BaseResponseModel
import com.snap.snapNewsApp.press.data.remote.model.PressModel
import retrofit2.http.GET

interface PressApi {

    @GET("top-headlines/sources?apiKey=4306da9b007544c99aefb13e7ef73d5c")
    suspend fun fetchTopHeadlines(): BaseResponseModel<List<PressModel>>
}
