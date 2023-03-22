package com.example.application1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.application1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val liveData = MutableLiveData<String>()
//        //Кладем не из main thread
//        liveData.postValue("www")
//        //Кладем из main thread
//        liveData.value = "222"
//
////        println("liveData: " + liveData.value)
//
//        //Через лямбду
//        liveData.observe(this) {
//            println("liveData: $it")
//        }
////
//        liveData.value = "234"
//
//        val observer = Observer<String> { println("liveData: new $it") }
//        liveData.observeForever(observer)
//
//        liveData.value = "aerv"
//
//
//        //Через анонимный класс
//        liveData.observe(this, object : Observer<String> {
//            override fun onChanged(t: String?) {
//                println(t)
//            }
//        })


        val mainActivityViewModel: MainActivityViewModel by viewModels()

        //errorEvent
//        mainActivityViewModel.errorEvent.observe(this) {
//            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
//        }
//
//        binding.btnAlertDialog.setOnClickListener {
//            mainActivityViewModel.postError()
//        }

        //errorEventSingleLiveEvent
        mainActivityViewModel.errorEventSingleLiveEvent.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
        binding.btnAlertDialog.setOnClickListener {
            mainActivityViewModel.postErrorSingleLiveEvent()
        }

//        val observer = Observer<String> { TODO("Not yet implemented") }
//        liveData.observeForever(observer)
//
//        liveData.removeObserver(observer)

    }

    companion object {
    }

}

