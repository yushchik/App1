package com.example.application1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.application1.databinding.ActivityMain2Binding
import com.example.application1.listUsers.ListUsers
import com.example.application1.person.Person
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.concurrent.Executors
import javax.net.ssl.HttpsURLConnection

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        //получение элемента
        Executors.newSingleThreadExecutor().execute {
            val url = URL(URL)

            val connection = url.openConnection() as HttpsURLConnection
            val gson = Gson()
            try {
                val br = BufferedReader(InputStreamReader(connection.inputStream))
                val line = br.readLine()
                val person = gson.fromJson(line, Person::class.java)
                println("GSON:  $person")
            } finally {
                connection.disconnect()
            }
        }


        //получение списка
        Executors.newSingleThreadExecutor().execute {
            val url = URL(URL_FOR_LIST)
            val connection = url.openConnection() as HttpsURLConnection
            val gson = Gson()
            try {
                val br = BufferedReader(InputStreamReader(connection.inputStream))
                val persons = mutableListOf<ListUsers>()
                br.forEachLine {
                    val person = gson.fromJson(it, ListUsers::class.java)
                    persons.add(person)
                }

                println("GSON:  $persons")
            } finally {
                connection.disconnect()
            }
        }
    }

    companion object {
        const val URL = "https://reqres.in/api/users/2"
        const val URL_FOR_LIST = "https://reqres.in/api/users?page=2"
    }


}