package com.snap.snapNewsApp.press.data.remote.dataSource

import com.snap.snapNewsApp.core.util.DataResult
import com.snap.snapNewsApp.press.data.remote.model.PressModel

interface PressRemoteDataSource {

    suspend fun fetchPressHeadlines(): DataResult<List<PressModel>?>
}
