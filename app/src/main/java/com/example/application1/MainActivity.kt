package com.example.application1

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.application1.databinding.ActivityMainBinding
import com.example.application1.room.AppDatabase
import com.example.application1.room.entity.Student
import java.util.concurrent.Executors


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var sqlDb: SQLiteDatabase
    lateinit var cursor: Cursor
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//
//        val databaseHelper = DatabaseHelper(this)
//        sqlDb = databaseHelper.readableDatabase
//
//
//
//        //добавление через execSQL
////        sqlDb.execSQL(
////            "INSERT INTO ${DatabaseHelper.TABLE_NAME} " +
////                    "(${DatabaseHelper.COLUMN_ITEM}, ${DatabaseHelper.COLUMN_PRICE}) " +
////                    "VALUES ('chair', 150);"
////        )
////
////        //добавление через insert
////        val cv = ContentValues()
////        cv.put(DatabaseHelper.COLUMN_ITEM, "juice")
////        cv.put(DatabaseHelper.COLUMN_PRICE, 15)
////        sqlDb.insert(DatabaseHelper.TABLE_NAME, null, cv)
//
////        cursor = sqlDb.rawQuery("SELECT * FROM ${DatabaseHelper.TABLE_NAME}", null)
////
////        cursor.moveToFirst()
////        cursorToString(cursor)
////        println("SQL:   ${cursor.getString(1)} ${cursor.getDouble(2)}")
//
//        //изменение данных. работает только с ключами
////        val cv = ContentValues()
////        cv.put(DatabaseHelper.COLUMN_ITEM, "sofa")
////        cv.put(DatabaseHelper.COLUMN_PRICE, 76)
////        sqlDb.update(DatabaseHelper.TABLE_NAME, cv, DatabaseHelper.COLUMN_ID + "=" + 2, null)
//
//        // изменение данных
////        val cv = ContentValues()
////        cv.put(DatabaseHelper.COLUMN_PRICE, 17)
////        sqlDb.update(DatabaseHelper.TABLE_NAME, cv, DatabaseHelper.COLUMN_ITEM + "=" + "?", arrayOf("juice"))
//
//        //удаление данных
////        sqlDb.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.COLUMN_ITEM + "=" + "?", arrayOf("chair"))
//
//
//        //вывод данных с условием
////        cursor = sqlDb.rawQuery("SELECT * FROM ${DatabaseHelper.TABLE_NAME} WHERE ${DatabaseHelper.COLUMN_ID} = 3", null)
//
//        //вывод данных с условием
//        cursor = sqlDb.rawQuery(
//            "SELECT * FROM ${DatabaseHelper.TABLE_NAME} WHERE ${DatabaseHelper.COLUMN_PRICE} = ?",
//            arrayOf("17")
//        )
//
//        cursorToString(cursor)
//
//        //вывод первой строки
////        cursor.moveToFirst()
////        println("SQL:   ${cursor.getString(1)} ${cursor.getDouble(2)}")
//
////вывод последней строки
////         cursor.moveToLast()
////        println("SQL:   ${cursor.getString(1)} ${cursor.getDouble(2)}")
//
//        //закрытие курсора
////        cursor.close()
//    }
//
//
//    private fun cursorToString(cursor: Cursor) {
//        var headers = "SQL "
//        var line = "SQL "
//
//        if (cursor.moveToFirst()) {
//            val columnNames = cursor.columnNames
//            for (name in columnNames) headers += String.format("%s | ", name)
//            println(headers)
//            do {
//                for (name in columnNames) {
//                    line += String.format(
//                        "%s | ",
//                        cursor.getString(cursor.getColumnIndex(name))
//                    )
//                }
//                println(line)
//                line = "SQL "
//            } while (cursor.moveToNext())
//        }
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val MIGRATION_2_3 = object : Migration(2, 3) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL("ALTER TABLE student_table ADD COLUMN NewAddress TEXT NOT NULL DEFAULT ''")
//            }
//        }
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            DB_NAME
        )
            .build()

        val studentDao = db.studentDao()

//        val students = mutableListOf<Student>(
//            Student(0, "ivan", 20),
//            Student(1, "darya", 25),
//            Student(2, "marya", 30),
//            Student(3, "alex", 17),
//            Student(4, "kira", 17),
//            Student(5, "yulia", 23),
//            Student(6, "ivan", 24),
//            Student(7, "alex", 20)
//        )


        val students = mutableListOf<Student>(
            Student(10, "ivan", 20),
            Student(11, "darya", 25),
            Student(22, "marya", 30),
            Student(32, "alex", 17)
        )

        val getStudentsList = mutableListOf<Student>()

        //асинхронный вызов
        Executors.newSingleThreadExecutor().execute {
            studentDao.insertAll(students)
            println("students ${studentDao.getAll()}")
        }

        //асинхронный вызов
//        Executors.newSingleThreadExecutor().execute {
//            println("students ${studentDao.getStudent(17)}")
//        }

    }

    companion object {
        const val DB_NAME = "students"
    }

}

