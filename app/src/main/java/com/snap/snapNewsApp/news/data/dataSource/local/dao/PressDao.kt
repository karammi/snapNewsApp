package com.snap.snapNewsApp.news.data.dataSource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.snap.snapNewsApp.news.data.dataSource.local.model.PressEntity

@Dao
interface PressDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPress(vararg press: PressEntity)
}
