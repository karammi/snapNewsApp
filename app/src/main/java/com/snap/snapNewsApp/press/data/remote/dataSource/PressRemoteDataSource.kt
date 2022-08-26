package com.snap.snapNewsApp.press.data.remote.dataSource

import com.snap.snapNewsApp.press.data.remote.model.BaseResponseModel
import com.snap.snapNewsApp.press.data.remote.model.PressModel

interface PressRemoteDataSource {

    suspend fun fetchPressHeadlines(): BaseResponseModel<List<PressModel>>
}
