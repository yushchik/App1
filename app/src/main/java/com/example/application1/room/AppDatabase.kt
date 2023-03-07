package com.example.application1.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.application1.room.dao.AddressDao
import com.example.application1.room.dao.StudentDao
import com.example.application1.room.entity.Address
import com.example.application1.room.entity.Student
import com.example.application1.room.entity.StudentAddress


@Database(entities = [Student::class, Address::class, StudentAddress::class], version = 3, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao
    abstract fun addressDao(): AddressDao
}