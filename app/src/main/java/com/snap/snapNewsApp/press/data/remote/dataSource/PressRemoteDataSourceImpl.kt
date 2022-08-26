package com.snap.snapNewsApp.press.data.remote.dataSource

import com.snap.snapNewsApp.press.data.remote.PressApi
import com.snap.snapNewsApp.press.data.remote.model.BaseResponseModel
import com.snap.snapNewsApp.press.data.remote.model.PressModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class PressRemoteDataSourceImpl @Inject constructor(
    private var pressApi: PressApi
) : PressRemoteDataSource {
    override suspend fun fetchPressHeadlines(): BaseResponseModel<List<PressModel>> {
        return pressApi.fetchTopHeadlines()
    }
}
