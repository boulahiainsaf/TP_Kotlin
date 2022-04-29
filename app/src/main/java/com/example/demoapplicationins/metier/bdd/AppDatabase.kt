package com.example.demoapplicationins.metier.bdd

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.demoapplicationins.metier.dao.CoursesDAO
import com.example.demoapplicationins.metier.dto.CourseDTO


@Database(entities = [CourseDTO::class], version = 1)
abstract class AppDatabase :RoomDatabase()
{
    abstract fun coursesDAO(): CoursesDAO
}