package com.example.application1.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MainActivityViewModelWithSaveInstanceState(state: SavedStateHandle)
    : ViewModel() {

    private val savedStateHandle = state

    fun saveState(number: String) {
        savedStateHandle[USER_KEY] = number
    }
    fun getState(): String {
        return savedStateHandle[USER_KEY] ?: ""
    }

    val userNumber: MutableLiveData<String> = savedStateHandle.getLiveData(USER_KEY)


    companion object{
        const val USER_KEY = "USER_KEY"
    }
}



