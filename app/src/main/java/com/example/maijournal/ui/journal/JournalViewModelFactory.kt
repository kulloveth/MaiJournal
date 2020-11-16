package com.example.maijournal.ui.journal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.maijournal.data.JournalRepository

@Suppress("UNCHECKED_CAST")
class JournalViewModelFactory(private val repository: JournalRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(JournalViewModel::class.java)){
            return JournalViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}