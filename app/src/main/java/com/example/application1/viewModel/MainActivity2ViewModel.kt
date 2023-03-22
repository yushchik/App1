package com.example.application1.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainActivity2ViewModel : ViewModel() {

//    val progressEvent = MutableLiveData<Boolean>()
//
//    fun showProgressBar() {
//        Executors.newSingleThreadExecutor().execute {
//            progressEvent.postValue(true)
////            Thread.sleep(5000)
////            progressEvent.postValue(false)
//        }
//    }
//
//    fun hideProgressBar() {
//        Executors.newSingleThreadExecutor().execute {
////            progressEvent.postValue(true)
////            Thread.sleep(5000)
//            progressEvent.postValue(false)
//        }
//    }


    //transformedLiveData

    private val liveData = MutableLiveData<String>()

    val transformedLiveData = Transformations
        .map(liveData) {
            Integer.parseInt(it)
        }

    fun postData(post: String) {
        liveData.value = post
    }


    //MediatorLiveData

//    val source1 = MutableLiveData<String>()
//    val source2 = MutableLiveData<String>()
//    val commonSource = MediatorLiveData<String>()
//
//    init {
//        commonSource.addSource(source1) {
//            commonSource.value = it
//        }
//        commonSource.addSource(source2) {
//            commonSource.value = it
//        }
//
//        commonSource.addSource(source1) {
//            if (it.lowercase(Locale.getDefault()) == "end") {
//                commonSource.removeSource(source1)
//                return@addSource
//            }
//            commonSource.value = it
//        }
//    }
//
//    fun postDatasource1(post: String) {
//        source1.value = post
//    }
//
//    fun postDatasource2(post: String) {
//        source2.value = post
//    }


}