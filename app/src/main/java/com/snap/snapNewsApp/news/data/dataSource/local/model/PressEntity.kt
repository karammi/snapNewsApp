package com.snap.snapNewsApp.news.data.dataSource.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "press_tbl")
data class PressEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String
)
