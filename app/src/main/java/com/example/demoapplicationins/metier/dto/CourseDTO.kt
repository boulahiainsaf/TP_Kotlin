package com.example.demoapplicationins.metier.dto

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity(tableName = "courses")

@Parcelize
class CourseDTO(
    @PrimaryKey(autoGenerate = true)
    val courseId : Long,
    val intitule:String,
    val achete:Boolean) : Parcelable
