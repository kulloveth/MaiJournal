package com.example.maijournal.data

import com.example.maijournal.data.db.dao.CategoryDao
import com.example.maijournal.data.db.dao.JournalDao
import com.example.maijournal.data.model.CategoryX
import com.example.maijournal.data.model.Journal

class JournalRepository(private val categoryDao: CategoryDao,private val journalDao: JournalDao) {

    suspend fun insertCategory(categoryX: CategoryX){
        categoryDao.insertCategory(categoryX)
    }

    fun fetchcategory() = categoryDao.fetchCategory()

    suspend fun insertJournal(journal: Journal){
        journalDao.saveJournal(journal)
    }

    fun fetchJournal() = journalDao.fetchJournal()
}