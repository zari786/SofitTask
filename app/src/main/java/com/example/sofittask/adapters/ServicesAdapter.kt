package com.example.sofittask.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sofittask.databinding.AdapterServicesBinding
import com.example.sofittask.models.Service

class ServicesAdapter : RecyclerView.Adapter<ServicesAdapter.ServicesViewHolder>() {

    var services: List<Service> = ArrayList()

    fun setAllServices(services: List<Service>) {
        this.services = services
        notifyDataSetChanged()
    }

    class ServicesViewHolder(private val adapterServicesBinding: AdapterServicesBinding) :
        RecyclerView.ViewHolder(adapterServicesBinding.root) {
        fun setData(service: Service) {
            adapterServicesBinding.item1Icon.setImageResource(service.item1Icon)
            adapterServicesBinding.item2Icon.setImageResource(service.item2Icon)
            adapterServicesBinding.item3Icon.setImageResource(service.item3Icon)
            adapterServicesBinding.item4Icon.setImageResource(service.item4Icon)

            adapterServicesBinding.item1Title.text = service.item1Title
            adapterServicesBinding.item2Title.text = service.item2Title
            adapterServicesBinding.item3Title.text = service.item3Title
            adapterServicesBinding.item4Title.text = service.item4Title

            adapterServicesBinding.title1.text = service.title1
            adapterServicesBinding.title2.text = service.title2
            adapterServicesBinding.title3.text = service.title3
            adapterServicesBinding.title4.text = service.title4

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterServicesBinding.inflate(inflater, parent, false)
        return ServicesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ServicesViewHolder, position: Int) {
        holder.setData(services[position])
    }

    override fun getItemCount(): Int {
        return services.size
    }
}