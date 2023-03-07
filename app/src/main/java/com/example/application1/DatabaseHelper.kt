package com.example.application1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABLE $TABLE_NAME (" +
                    "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$COLUMN_ITEM TEXT, " +
                    "$COLUMN_PRICE REAL);"
        )

        db?.execSQL(
            "INSERT INTO $TABLE_NAME " +
                    "($COLUMN_ITEM, $COLUMN_PRICE) " +
                    "VALUES ('TABLE', 10);"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {



    }

    companion object {
        const val DATABASE_NAME = "prices.db"
        const val DATABASE_VERSION = 2

        const val TABLE_NAME = "prices"
        const val TABLE_NAME2 = "prices2"
        const val COLUMN_ID = "_id"
        const val COLUMN_ITEM = "item"
        const val COLUMN_PRICE = "price"
    }
}