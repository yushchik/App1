package com.example.application1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.example.application1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //SharedPreferences исключительно для всего приложения
//
        val shared = this.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

        shared.edit().putString(SHARED_PREFERENCES_KEY, "this is sharedPreferences")
            .putString(SHARED_PREFERENCES_KEY2, "this is sharedPreferences 2")
            .putString(SHARED_PREFERENCES_KEY3, "this is sharedPreferences 3r3")
            .apply()
//        shared.edit().putString(SHARED_PREFERENCES_KEY2, "this is sharedPreferences 2").apply()
//        shared.edit().putString(SHARED_PREFERENCES_KEY3, "this is sharedPreferences 3").apply()

        val value = shared.getString(SHARED_PREFERENCES_KEY, "default")
//
//        println("sharedPreferences: $value")
//
//
//        //проверка по ключу (возвращает true или false)
//        val contains =  shared.contains(SHARED_PREFERENCES_KEY)
//
//        println("sharedPreferences: $contains")
//
//        //получение всех значений
//        val preferences = shared.all
//
//        println("sharedPreferences: $preferences")
//
//        //удаление по ключу
//
////        shared.edit().remove(SHARED_PREFERENCES_KEY).apply()
//
//        println("sharedPreferences: " + shared.all)
//
//        //удаление всего
//
////        shared.edit().clear().apply()
//
//        println("sharedPreferences: " + shared.all)
//
//
//        shared.edit {
//            putBoolean(SHARED_PREFERENCES_KEY, true)
//        }
//        shared.edit(commit = true) {
//            putBoolean(SHARED_PREFERENCES_KEY, true)
//        }


        //SharedPreferences исключительно для одного активити
//        val shAndroidKTXared = this.getPreferences(Context.MODE_PRIVATE)
//
//        shAndroidKTXared.edit().putString(SHARED_PREFERENCES_KEY, "this is new sharedPreferences").apply()
//
//        val value = shAndroidKTXared.getString(SHARED_PREFERENCES_KEY, "default")
//
//        println("sharedPreferences: $value")


//        val intent = Intent(this, MainActivity2::class.java)
//        startActivity(intent)

//        val shared = this.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
//
//        binding.btn.setOnClickListener {
//            shared.edit().putString(SHARED_PREFERENCES_KEY, binding.et.text.toString()).apply()
//        }
//
//        val listener = SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, key ->
//            when(key){
//                SHARED_PREFERENCES_KEY -> binding.tv.text = sharedPreferences?.getString(SHARED_PREFERENCES_KEY, "default")
//            }
//        }
//
//        shared.registerOnSharedPreferenceChangeListener(listener)


    }



    override fun onDestroy() {
        super.onDestroy()
//        shared.unregisterOnSharedPreferenceChangeListener(listener)

    }

    companion object {
        const val SHARED_PREFERENCES_NAME = "settings"
        const val SHARED_PREFERENCES_KEY = "ke43"
        const val SHARED_PREFERENCES_KEY2 = "key2"
        const val SHARED_PREFERENCES_KEY3 = "key3"
    }

}

