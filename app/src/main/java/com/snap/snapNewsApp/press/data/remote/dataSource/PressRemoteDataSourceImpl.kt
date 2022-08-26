package com.snap.snapNewsApp.press.data.remote.dataSource

import com.snap.snapNewsApp.core.util.ApiErrorBody
import com.snap.snapNewsApp.core.util.DataResult
import com.snap.snapNewsApp.press.data.remote.PressApi
import com.snap.snapNewsApp.press.data.remote.model.PressModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class PressRemoteDataSourceImpl @Inject constructor(
    private var pressApi: PressApi
) : PressRemoteDataSource {
    override suspend fun fetchPressHeadlines(): DataResult<List<PressModel>> {
        val response = pressApi.fetchTopHeadlines()
        return if (response.status == "ok") {
            DataResult.Success(response.data)
        } else {
            DataResult.Error(ApiErrorBody(code = response.code, message = response.message))
        }
    }
}
