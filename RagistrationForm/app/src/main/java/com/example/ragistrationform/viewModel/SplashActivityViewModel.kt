package com.example.ragistrationform.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel

class SplashActivityViewModel(context:Context): ViewModel() {
    val shared_pref = context.getSharedPreferences("Login", Context.MODE_PRIVATE)
        fun checkLogin():Boolean{
            if(shared_pref.getString("username",null)==null || shared_pref.getString("username",null)=="Guest")
            { return false

            }
            return true
        }
}