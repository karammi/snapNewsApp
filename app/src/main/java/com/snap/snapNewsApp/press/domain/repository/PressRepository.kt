package com.snap.snapNewsApp.press.domain.repository

import com.snap.snapNewsApp.core.util.DataResult
import com.snap.snapNewsApp.press.domain.model.Press

interface PressRepository {
    suspend fun fetchTopHeadlines(): DataResult<List<Press>>
}
