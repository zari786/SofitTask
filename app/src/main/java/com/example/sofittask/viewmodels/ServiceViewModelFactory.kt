package com.example.sofittask.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sofittask.repositories.ServiceRepository
import java.lang.IllegalArgumentException

class ServiceViewModelFactory(private val serviceRepository: ServiceRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ServiceViewModel::class.java)){
            return ServiceViewModel(this.serviceRepository) as T
        }else{
            throw IllegalArgumentException("invalid viewModel class")
        }
    }
}