package com.snap.snapNewsApp.press.data.repository

import com.snap.snapNewsApp.core.util.DataResult
import com.snap.snapNewsApp.core.util.map
import com.snap.snapNewsApp.press.data.mapper.PressResponseMapper
import com.snap.snapNewsApp.press.data.remote.dataSource.PressRemoteDataSource
import com.snap.snapNewsApp.press.domain.model.Press
import com.snap.snapNewsApp.press.domain.repository.PressRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class PressRepositoryImpl @Inject constructor(
    private val pressRemoteDataSource: PressRemoteDataSource,
    private val mapper: PressResponseMapper
) : PressRepository {
    override suspend fun fetchTopHeadlines(): DataResult<List<Press>> {
        return pressRemoteDataSource
            .fetchPressHeadlines()
            .map { response ->
                response?.map { pressModel ->
                    mapper.mapModelToEntity(pressModel)
                } ?: emptyList()
            }
    }
}
