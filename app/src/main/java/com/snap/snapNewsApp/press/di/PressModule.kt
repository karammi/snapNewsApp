package com.snap.snapNewsApp.press.di

import com.snap.snapNewsApp.press.data.remote.PressApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object PressModule {

    @Provides
    @Singleton
    fun providePressApi(retrofit: Retrofit): PressApi = retrofit.create(PressApi::class.java)
}
