package com.example.ragistrationform.Factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ragistrationform.viewModel.ViewDataNamesActivityViewModel

class ViewDataActivityFactory(val context: Context):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ViewDataNamesActivityViewModel::class.java)) {
            return ViewDataNamesActivityViewModel(context) as T
        }
        throw IllegalArgumentException("class not found")

    }
}