package com.example.maijournal.ui.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.maijournal.data.JournalRepository

class CategoryViewModelFactory(private val repository: JournalRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CategoryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CategoryViewModel(
                repository
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class") }
}