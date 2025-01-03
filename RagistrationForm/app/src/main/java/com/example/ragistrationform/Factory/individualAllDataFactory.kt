package com.example.ragistrationform.Factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ragistrationform.viewModel.ViewDataNamesActivityViewModel
import com.example.ragistrationform.viewModel.individualAllDataViewModel

class individualAllDataFactory(val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(individualAllDataViewModel::class.java)) {
            return individualAllDataViewModel(context) as T
        }
        throw IllegalArgumentException("class not found")

    }
}