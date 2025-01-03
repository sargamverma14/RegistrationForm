package com.example.ragistrationform.Factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ragistrationform.viewModel.MainActivity2ViewModel
import com.example.ragistrationform.viewModel.MainActivityViewModel

class MainActivity2Factory(val context: Context):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainActivity2ViewModel(context)::class.java)){
            return MainActivity2ViewModel(context) as T

        }
        throw IllegalArgumentException("class not found")

    }
}