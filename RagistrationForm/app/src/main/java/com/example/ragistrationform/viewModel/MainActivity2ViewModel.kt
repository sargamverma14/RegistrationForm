package com.example.ragistrationform.viewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivity2ViewModel(context: Context): ViewModel() {
    val shred_pref = context.getSharedPreferences("Login", Context.MODE_PRIVATE)
    var userName = MutableLiveData<String>()
    fun setUsername():String{
        userName.value = shred_pref.getString("username",null).toString()
        val tvuserName = "Created By : "+userName.value.toString()
        return tvuserName
    }
}