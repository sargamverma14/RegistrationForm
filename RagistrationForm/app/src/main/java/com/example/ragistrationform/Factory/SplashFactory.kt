package com.example.ragistrationform.Factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ragistrationform.viewModel.SplashActivityViewModel

class SplashFactory(var context: Context):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SplashActivityViewModel::class.java))
        {
        return SplashActivityViewModel(context) as T
        }
    throw IllegalArgumentException("Class not found")
    }

}