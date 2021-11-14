package com.example.sofittask.repositories

import com.example.sofittask.R
import com.example.sofittask.models.Service

class ServiceRepository {
    fun setFakeData(): List<Service> {
        val serviceList: ArrayList<Service> = ArrayList()

        serviceList.add(
            Service(
                R.drawable.ic_baseline_home_24,
                R.drawable.ic_baseline_home_24,
                R.drawable.ic_baseline_home_24,
                R.drawable.ic_baseline_home_24,
                "Icon Title 1",
                "Icon Title 2",
                "Icon Title 3",
                "Icon Title 4",
                "Title 1",
                "Title 2",
                "Title 3",
                "Title 4"
            )
        )

        serviceList.add(
            Service(
                R.drawable.ic_baseline_home_24,
                R.drawable.ic_baseline_home_24,
                R.drawable.ic_baseline_home_24,
                R.drawable.ic_baseline_home_24,
                "Icon Title 1",
                "Icon Title 2",
                "Icon Title 3",
                "Icon Title 4",
                "Title 1",
                "Title 2",
                "Title 3",
                "Title 4"
            )
        )

        serviceList.add(
            Service(
                R.drawable.ic_baseline_home_24,
                R.drawable.ic_baseline_home_24,
                R.drawable.ic_baseline_home_24,
                R.drawable.ic_baseline_home_24,
                "Icon Title 1",
                "Icon Title 2",
                "Icon Title 3",
                "Icon Title 4",
                "Title 1",
                "Title 2",
                "Title 3",
                "Title 4"
            )
        )

        return serviceList
    }
}