package com.example.application1.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "student_address_table",
    foreignKeys = [ForeignKey(
        entity = Student::class,
        parentColumns = ["id"],
        childColumns = ["student_id"],
        onDelete = ForeignKey.CASCADE
    ), ForeignKey(
        entity = Address::class,
        parentColumns = ["id"],
        childColumns = ["address_id"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class StudentAddress(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "address_id") val addressId: Int,
    @ColumnInfo(name = "student_id") val studentId: Int,
)
