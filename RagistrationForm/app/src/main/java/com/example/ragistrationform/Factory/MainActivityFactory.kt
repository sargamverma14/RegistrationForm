package com.example.ragistrationform.Factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ragistrationform.viewModel.MainActivityViewModel

class MainActivityFactory(val context: Context):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainActivityViewModel(context)::class.java)){
            return MainActivityViewModel(context) as T

        }
        throw IllegalArgumentException("class not found")

    }
}