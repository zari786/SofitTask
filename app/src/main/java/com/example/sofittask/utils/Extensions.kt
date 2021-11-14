package com.example.sofittask.utils

import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

fun View.isVisible(isVisible:Boolean){
    visibility = if(isVisible){
        View.VISIBLE
    }else{
        View.GONE
    }
}

fun Fragment.showToast(message:String){
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}