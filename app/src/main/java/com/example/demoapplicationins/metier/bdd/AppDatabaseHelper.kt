package com.example.demoapplicationins.metier.bdd

import android.content.Context
import androidx.room.Room

class AppDatabaseHelper(context : Context)
{
    companion object
    {
        // Helper :
        private lateinit var databaseHelper: AppDatabaseHelper
        // Getter instance :
        fun getDatabase(context: Context): AppDatabase
        {
            if (!::databaseHelper.isInitialized)
            {
                databaseHelper = AppDatabaseHelper(context)
            }
            return databaseHelper.database
        }
    }
    // Base de données :
    val database: AppDatabase = Room
        .databaseBuilder(context.applicationContext, AppDatabase::class.java, "courses.db")
        .allowMainThreadQueries()
        .build()
}