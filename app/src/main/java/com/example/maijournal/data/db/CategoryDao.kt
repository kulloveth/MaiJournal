package com.example.maijournal.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.maijournal.data.model.CategoryX
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Insert(onConflict =OnConflictStrategy.REPLACE)
    suspend fun insertCategory(categoryX: CategoryX)

    @Query("Select * from category")
    fun fetchCategory():Flow<List<CategoryX>>
}