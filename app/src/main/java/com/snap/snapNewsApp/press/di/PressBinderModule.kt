package com.snap.snapNewsApp.press.di

import com.snap.snapNewsApp.press.data.remote.dataSource.PressRemoteDataSource
import com.snap.snapNewsApp.press.data.remote.dataSource.PressRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class PressBinderModule {

    @Binds
    abstract fun bindPressRemoteDataSource(pressRemoteDataSource: PressRemoteDataSourceImpl): PressRemoteDataSource
}
