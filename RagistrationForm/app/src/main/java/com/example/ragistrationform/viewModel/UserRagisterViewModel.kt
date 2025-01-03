package com.example.ragistrationform.viewModel

import androidx.lifecycle.ViewModel
import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.ragistrationform.database.DbHelper

class UserRagisterViewModel(val context:Context):ViewModel() {
    val shred_pref = context.getSharedPreferences("Login",MODE_PRIVATE)
    val editor = shred_pref.edit()
    fun setData(username : String){
        editor.putString("username",username).apply()

            val db = DbHelper(context)
            db.insertLoginData(username)


    }

}