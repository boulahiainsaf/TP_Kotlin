package com.example.demoapplicationins.bo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
 data class Course (val intitule:String, val achete:Boolean) :Parcelable