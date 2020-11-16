package com.example.maijournal.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Journal(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val category: String,
    val title: String,
    val desc: String,
    val detail: String,
    val updatedAt: String
)