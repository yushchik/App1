package com.example.application1

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.application1.databinding.ActivityMain2Binding
import com.example.application1.viewModel.MainActivity2ViewModel

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val mainActivity2ViewModel: MainActivity2ViewModel by viewModels()

//        mainActivity2ViewModel.progressEvent.observe(this) {
//            binding.progress.isVisible = it
//        }
//
//        binding.bntProgressStart.setOnClickListener {
//            mainActivity2ViewModel.showProgressBar()
//        }
//
//        binding.bntProgressStop.setOnClickListener {
//            mainActivity2ViewModel.hideProgressBar()
//        }


        //transformed
        mainActivity2ViewModel.transformedLiveData.observe(this) {
            binding.textView.text = (it * it).toString()
        }

        binding.btnTransform.setOnClickListener {
            mainActivity2ViewModel.postData(binding.editText.text.toString())
        }

//MediatorLiveData
//        mainActivity2ViewModel.commonSource.observe(this) {
//            binding.textView.text = it
//        }
//
//        binding.btnTransform.setOnClickListener {
//            mainActivity2ViewModel.postDatasource1(binding.editText.text.toString())
//            mainActivity2ViewModel.postDatasource2("data")
//        }


    }
}