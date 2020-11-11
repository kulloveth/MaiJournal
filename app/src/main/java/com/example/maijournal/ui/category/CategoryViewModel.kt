package com.example.maijournal.ui.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.maijournal.data.JournalRepository
import com.example.maijournal.data.model.CategoryX
import kotlinx.coroutines.launch

class CategoryViewModel(private val repository: JournalRepository):ViewModel() {


    fun insertCategory(categoryx:CategoryX){
        viewModelScope.launch {
            repository.insertCategory(categoryx)
        }
    }

    fun fetchCategory() = repository.fetchcategory().asLiveData()
}