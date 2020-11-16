package com.example.maijournal.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.maijournal.data.db.dao.CategoryDao
import com.example.maijournal.data.db.dao.JournalDao
import com.example.maijournal.data.model.CategoryX
import com.example.maijournal.data.model.Journal
import com.example.maijournal.utils.JsonUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [CategoryX::class,Journal::class], version = 1)
abstract class JournalDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun journalDao():JournalDao

    companion object {
        @Volatile
        private var INSTANCE: JournalDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): JournalDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    JournalDatabase::class.java,
                    "journal.db"
                ).addCallback(JournalCallback(context,scope)).build()
                INSTANCE = instance

                instance
            }
        }
    }

    private class JournalCallback(private val context: Context, private val scope: CoroutineScope) :
        RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    val categoryDao = database.categoryDao()
                    val categoryList = JsonUtils.readCategories(context)
                    categoryList.category.forEach {
                        categoryDao.insertCategory(it)
                    }

                }

            }
        }
    }
}