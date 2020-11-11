package com.example.maijournal.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Journal(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "category") val categoryX: CategoryX,
    val title: String,
    val desc: String,
    val detail:String
)