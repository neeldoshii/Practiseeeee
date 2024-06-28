package com.example.myapplication.Room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee")
data class User(
    @PrimaryKey(autoGenerate = true)  val id : Int = 0,
    @ColumnInfo(name = "first_name") val firstName: String?=null,
    @ColumnInfo(name = "last_name") val lastName: String?=null,
    @ColumnInfo(name = "phone_no") val phoneNumber: Int?=null,
)
