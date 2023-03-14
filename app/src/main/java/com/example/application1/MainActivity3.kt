package com.example.application1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.application1.databinding.ActivityMain3Binding
import com.example.application1.person.Person
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class MainActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val client = OkHttpClient()
        val request = Request.Builder()
            .url(URL)
            .build()


        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }
            override fun onResponse(call: Call, response: Response) {
                try {
                    val responseBody = response.body
                    val gson = Gson()
                    val person = gson.fromJson(responseBody?.string(), Person::class.java)
                    println("okhttp parse  ${person.support}")
                } catch (e: Exception) {
                    println(response)
                    e.printStackTrace()
                }
            }
        })
    }


    companion object {
        const val URL = "https://reqres.in/api/users/2"
    }
}