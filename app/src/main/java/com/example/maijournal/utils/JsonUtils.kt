package com.example.maijournal.utils

import android.content.Context
import android.util.Log
import com.example.maijournal.data.model.Category
import com.google.gson.Gson

object JsonUtils {
    private val TAG = JsonUtils::class.simpleName

    fun readCategories(context: Context){
        val jsonString =
            context.applicationContext.assets.open("categories.json").bufferedReader()
                .use { it.readText() }
        val category = Gson().fromJson(jsonString, Category::class.java)
        Log.d(TAG,""+category)
    }
}