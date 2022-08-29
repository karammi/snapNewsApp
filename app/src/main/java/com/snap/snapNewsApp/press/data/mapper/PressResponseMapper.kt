package com.snap.snapNewsApp.press.data.mapper

import com.snap.snapNewsApp.core.util.ResponseMapper
import com.snap.snapNewsApp.press.data.remote.model.PressModel
import com.snap.snapNewsApp.press.domain.model.Press
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class PressResponseMapper @Inject constructor() : ResponseMapper<PressModel, Press> {
    override fun mapModelToEntity(model: PressModel): Press {
        return with(model) {
            Press(
                id = id,
                name = name,
                description = description,
                url = url,
                category = category,
                language = language,
                country = country
            )
        }
    }

    override fun mapModelFromEntity(entity: Press): PressModel {
        return PressModel(
            id = entity.id,
            name = entity.name,
            description = entity.description,
            url = entity.url,
            category = entity.category,
            language = entity.language,
            country = entity.country
        )
    }
}
