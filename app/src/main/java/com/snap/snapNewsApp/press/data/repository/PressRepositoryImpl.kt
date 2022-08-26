package com.snap.snapNewsApp.press.data.repository

import com.snap.snapNewsApp.press.data.remote.dataSource.PressRemoteDataSource
import com.snap.snapNewsApp.press.domain.model.BaseResponse
import com.snap.snapNewsApp.press.domain.model.Press
import com.snap.snapNewsApp.press.domain.repository.PressRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class PressRepositoryImpl @Inject constructor(
    private val pressRemoteDataSource: PressRemoteDataSource
) : PressRepository {
    override suspend fun fetchTopHeadlines(): BaseResponse<Press> {
        TODO(" map data to domain modal, and return it as a Result model, using Flow")
    }
}
