package com.example.application1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.application1.databinding.ActivityMain2Binding

abstract class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //SharedPreferences исключительно для одного активити
//
//        val shared = this.getPreferences(Context.MODE_PRIVATE)
//
//        val value = shared.getString(MainActivity.SHARED_PREFERENCES_KEY, "default")
//
//        println("sharedPreferences activity2 : $value")

        //SharedPreferences исключительно для всего приложения


//        val shared =
//            this.getSharedPreferences(MainActivity.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

//        val value = shared.getString(MainActivity.SHARED_PREFERENCES_KEY, "default")
//
//        println("sharedPreferences activity2 : $value")


    }

    companion object {
        private val USER_FIRST_NAME = stringPreferencesKey("user_first_name")
        private val USER_LAST_NAME = stringPreferencesKey("user_last_name")
        private val USER_BIRTH_DAY = longPreferencesKey("user_birth_day")
    }

}

