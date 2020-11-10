package com.example.maijournal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.maijournal.utils.JsonUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        JsonUtils.readCategories(this)
    }
}