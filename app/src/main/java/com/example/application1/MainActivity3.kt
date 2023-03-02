package com.example.application1

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.asLiveData
import androidx.navigation.ui.AppBarConfiguration
import com.example.application1.databinding.ActivityMain3Binding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity3 : AppCompatActivity() {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_prefs")

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMain3Binding
    private lateinit var userManager: UserManager
    var age = 0
    var fname = ""
    var lname = ""
    var gender = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //Get reference to our userManager class
        userManager = UserManager(dataStore)

        buttonSave()

        observeData()
    }

    private fun observeData() {

        //Updates age
        userManager.userAgeFlow.asLiveData().observe(this) {
            if (it != null) {
                age = it
                binding.tvAge.text = it.toString()
            }
        }

        //Updates firstname
        userManager.userFirstNameFlow.asLiveData().observe(this) {
            if (it != null) {
                fname = it
                binding.tvFname.text = it
            }
        }

        //Updates lastname
        userManager.userLastNameFlow.asLiveData().observe(this) {
            if (it != null) {
                lname = it
                binding.tvLname.text = it
            }
        }

        //Updates gender
        userManager.userGenderFlow.asLiveData().observe(this) {
            if (it != null) {
                gender = if (it) "Male" else "Female"
                binding.tvGender.text = gender
            }
        }
    }

    private fun buttonSave() {

        //Gets the user input and saves it
        binding.btnSave.setOnClickListener {
            fname = binding.etFname.text.toString()
            lname = binding.etLname.text.toString()
            age = binding.etAge.text.toString().toInt()
            val isMale = binding.switchGender.isChecked

            //Stores the values
            GlobalScope.launch {
                userManager.storeUser(age, fname, lname, isMale)
            }
        }
    }
}