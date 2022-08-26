package com.snap.snapNewsApp.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.snap.snapNewsApp.news.data.dataSource.local.model.PressEntity

@Database(entities = [PressEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase()
