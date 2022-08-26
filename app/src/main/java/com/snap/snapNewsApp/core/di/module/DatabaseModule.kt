package com.snap.snapNewsApp.core.di.module

import android.content.Context
import androidx.room.Room
import com.snap.snapNewsApp.core.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabase(
        @ApplicationContext application: Context
    ) = Room.databaseBuilder(
        application.applicationContext,
        AppDatabase::class.java,
        "news_db"
    ).build()
}
