package com.example.application1.room.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class Student(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "student_name") val studentName: String,
    @ColumnInfo(name = "student_age") val studentAge: Int,
)
