package com.example.maijournal.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class CategoryX(

    @PrimaryKey
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name="icon")
    val icon: String
)