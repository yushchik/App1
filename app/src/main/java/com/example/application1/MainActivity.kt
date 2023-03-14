package com.example.application1

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.application1.databinding.ActivityMainBinding
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var sqlDb: SQLiteDatabase
    lateinit var cursor: Cursor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gson = Gson()
//        val input = gson.toJson(1)
//        //gson работает на java, поэтому необходимо указывать ::class.java
//        val output = gson.fromJson(input, Int::class.java)


        //example 1
//        val student = Student(
//            name = "Ivan",
//            surName = "Ivanov",
//            age = 20,
//            address = "Minsk",
//            isMen = true
//        )

        //example 2
//        val student = Student(
//            name = "Ivan",
//            surName = "Ivanov",
//            age = 20,
//            address = Address(
//                country = "Belarus",
//                city = "Minsk",
//                street = "Pushkina",
//                buildNumber = "20/1"
//            ),
//            isMen = true
//        )

        // example 3
        val student = Student(
            name = "Ivan",
            surName = "Ivanov",
            age = 20,
            address = Address(
                country = "Belarus",
                city = "Minsk",
                street = "Pushkina",
                buildNumber = "20/1"
            ),
            isMen = true,
            assessment = mutableListOf(3,4,7,1)
        )

        val listOfStudent = mutableListOf<Student>()
        listOfStudent.add(student)
        listOfStudent.add(student)
        listOfStudent.add(student)
        listOfStudent.add(student)
        listOfStudent.add(student)

        val inputStudent = gson.toJson(listOfStudent)
        println("GSON: $inputStudent")

        val outputStudent = gson.fromJson(inputStudent, Student::class.java)

        println("GSON: $outputStudent")

    }

    companion object {
    }

}

