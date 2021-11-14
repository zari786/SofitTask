package com.example.sofittask.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.sofittask.R
import com.example.sofittask.adapters.ServicesAdapter
import com.example.sofittask.databinding.FragmentServicesBinding
import com.example.sofittask.models.Service
import com.example.sofittask.repositories.ServiceRepository
import com.example.sofittask.utils.isVisible
import com.example.sofittask.utils.showToast
import com.example.sofittask.viewmodels.PostViewModel
import com.example.sofittask.viewmodels.PostViewModelFactory
import com.example.sofittask.viewmodels.ServiceViewModel
import com.example.sofittask.viewmodels.ServiceViewModelFactory

class ServicesFragment : Fragment() {
    private lateinit var serviceRepository: ServiceRepository
    private lateinit var serviceViewModel: ServiceViewModel
    private val adapter = ServicesAdapter()
    private lateinit var fragmentServicesBinding: FragmentServicesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentServicesBinding = FragmentServicesBinding.inflate(inflater, container, false)
        return fragmentServicesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        serviceRepository = ServiceRepository()
        serviceViewModel = ViewModelProvider(
            this,
            ServiceViewModelFactory(serviceRepository)
        ).get(ServiceViewModel::class.java)

        fragmentServicesBinding.servicesRecyclerview.adapter = adapter


        serviceViewModel.serviceList.observe(viewLifecycleOwner,{
            adapter.setAllServices(it)
        })

        serviceViewModel.loading.observe(viewLifecycleOwner,{
            if(it){
                fragmentServicesBinding.progressBar.isVisible(true)
                fragmentServicesBinding.servicesRecyclerview.isVisible(false)
            }else{
                fragmentServicesBinding.progressBar.isVisible(false)
                fragmentServicesBinding.servicesRecyclerview.isVisible(true)
            }
        })

        serviceViewModel.error.observe(viewLifecycleOwner,{
            showToast(it)
        })

        serviceViewModel.getAllServices()
    }

}