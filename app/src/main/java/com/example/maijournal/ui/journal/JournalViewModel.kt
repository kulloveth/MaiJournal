package com.example.maijournal.ui.journal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.maijournal.data.JournalRepository
import com.example.maijournal.data.model.Journal
import kotlinx.coroutines.launch

class JournalViewModel(private val repository: JournalRepository):ViewModel() {

    fun saveJournal(journal: Journal){
        viewModelScope.launch {
            repository.insertJournal(journal)
        }
    }

    fun fetchJournal() = repository.fetchJournal().asLiveData()
}