package com.example.application1

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import java.util.concurrent.atomic.AtomicBoolean

class MainActivityViewModel: ViewModel() {

    val errorEvent = MutableLiveData<String>()

    fun postError(){
        errorEvent.postValue("Error happened")
    }


    val errorEventSingleLiveEvent = SingleLiveEvent<String>()

    fun postErrorSingleLiveEvent(){
        errorEventSingleLiveEvent.postValue("Error happened")
    }

}

class SingleLiveEvent<T>: MutableLiveData<T> (){

    private val mPending = AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        if(hasActiveObservers()){}

            super.observe(owner) { t ->
                if (mPending.compareAndSet(true, false)) {
                    observer.onChanged(t)
                }

            }
    }

    override fun setValue(value: T) {
        mPending.set(true)
        super.setValue(value)
    }
}