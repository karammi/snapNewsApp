package com.snap.snapNewsApp.press.domain.useCase

import com.snap.snapNewsApp.core.util.DataResult
import com.snap.snapNewsApp.press.domain.model.Press
import com.snap.snapNewsApp.press.domain.repository.PressRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class FetchHeadlinesUseCase @Inject constructor(
    private val pressRepository: PressRepository
) {
    suspend operator fun invoke(): DataResult<List<Press>> {
        return pressRepository.fetchTopHeadlines()
    }
}
