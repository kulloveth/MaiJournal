package com.example.maijournal.data.db.dao

import androidx.room.*
import com.example.maijournal.data.model.Journal
import kotlinx.coroutines.flow.Flow

@Dao
interface JournalDao {

    @Insert
    suspend fun saveJournal(journal:Journal)

    @Query("select * from journal")
    fun fetchJournal(): Flow<List<Journal>>

    @Query("select * from journal where id=:id")
    fun fetchJournalById(id:Long):Flow<List<Journal>>

    @Delete
    suspend fun deleteJournal(journal: Journal)

    @Update
    suspend fun updateJournal(journal: Journal)

}