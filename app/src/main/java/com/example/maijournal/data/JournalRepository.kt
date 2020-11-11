package com.example.maijournal.data

import com.example.maijournal.data.db.dao.CategoryDao
import com.example.maijournal.data.model.CategoryX

class JournalRepository(private val categoryDao: CategoryDao) {

    suspend fun insertCategory(categoryX: CategoryX){
        categoryDao.insertCategory(categoryX)
    }

    fun fetchcategory() = categoryDao.fetchCategory()
}