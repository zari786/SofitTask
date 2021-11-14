package com.example.sofittask.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.sofittask.R
import com.example.sofittask.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)
        return fragmentHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this).load(R.drawable.news_img1)
            .transform(CenterCrop(), RoundedCorners(30))
            .into(fragmentHomeBinding.newsImage1)

        Glide.with(this).load(R.drawable.news_img2)
            .transform(CenterCrop(), RoundedCorners(30))
            .into(fragmentHomeBinding.newsImage2)

        fragmentHomeBinding.menuItem1Icon.setOnClickListener {

        }

        fragmentHomeBinding.menuItem2Icon.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_home_to_services)
        }

        fragmentHomeBinding.menuItem3Icon.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_home_to_posts)
        }





    }

}