package com.snap.snapNewsApp.core.util

/**
 * this is used to implementing mapping data
 * from network model and domain entity
 *
 * params:
 * M :NetworkModel
 * E :Domain Entity
 * */
interface ResponseMapper<M, E> {
    fun mapModelToEntity(model: M): E

    fun mapModelFromEntity(entity: E): M
}
