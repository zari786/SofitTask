package com.example.sofittask.viewmodels

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sofittask.models.Service
import com.example.sofittask.repositories.ServiceRepository

class ServiceViewModel(private val serviceRepository: ServiceRepository):ViewModel() {

    var serviceList = MutableLiveData<List<Service>>()
    var loading = MutableLiveData<Boolean>()
    var error = MutableLiveData<String>()


    fun getAllServices(){
        loading.postValue(true)

        Handler(Looper.getMainLooper()).postDelayed({
            val response = serviceRepository.setFakeData()
            if(response.isNotEmpty()){
                loading.postValue(false)
                serviceList.postValue(response)
            }else{
                loading.postValue(false)
                error.postValue("error occur")
            }
        },1000)
    }

}