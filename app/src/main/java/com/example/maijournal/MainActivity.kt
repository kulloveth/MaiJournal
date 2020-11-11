package com.example.maijournal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.maijournal.app.JournalApp
import com.example.maijournal.ui.category.CategoryViewModel
import com.example.maijournal.ui.category.CategoryViewModelFactory
import com.example.maijournal.utils.JsonUtils

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.simpleName

    private val viewModel: CategoryViewModel by viewModels{
        CategoryViewModelFactory((application as JournalApp).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        JsonUtils.readCategories(this)

        viewModel.fetchCategory().observe(this, Observer {
            Log.d(TAG,""+it)
        })
    }
}