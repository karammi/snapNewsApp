package com.snap.snapNewsApp.press.domain.repository

import com.snap.snapNewsApp.press.domain.model.BaseResponse
import com.snap.snapNewsApp.press.domain.model.Press

interface PressRepository {
    suspend fun fetchTopHeadlines(): BaseResponse<Press>
}
