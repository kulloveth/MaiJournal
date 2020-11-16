package com.example.maijournal.app

import android.app.Application
import com.example.maijournal.data.JournalRepository
import com.example.maijournal.data.db.JournalDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class JournalApp : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
    }

    val database by lazy { JournalDatabase.getDatabase(this,applicationScope) }
    val repository by lazy { JournalRepository(database.categoryDao(),database.journalDao()) }
}