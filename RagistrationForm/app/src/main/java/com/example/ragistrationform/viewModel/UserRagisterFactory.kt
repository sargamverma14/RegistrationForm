package com.example.ragistrationform.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UserRagisterFactory(var context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UserRagisterViewModel::class.java)) {
            return UserRagisterViewModel(context) as T
        }
        throw IllegalArgumentException("class not found")
    }
}
