package com.example.ragistrationform.viewModel

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.ragistrationform.MainActivity
import com.example.ragistrationform.database.DbHelper
import com.google.android.material.snackbar.Snackbar

class LoginViewModel( val context: Context):ViewModel() {
    val shared_pref = context.getSharedPreferences("Login",MODE_PRIVATE)
    val editor = shared_pref.edit()
    fun skip(){
      editor.putString("username","Guest").apply()
    }
    fun login(user : String) {
//       shared_pref.edit().putString("username",user).apply()
        val db = DbHelper(context)
        val name = db.getRagisteredData(user)
        if (name != "") {
            shared_pref.edit().putString("username", name).apply()
        }

        if (user == shared_pref.getString("username", "").toString())
        {
            var myintent = Intent(context, MainActivity::class.java)
            context.startActivity(myintent)

        }
        else if(user != shared_pref.getString("username", "").toString()){
        Toast.makeText(context, "Invalid Username!! ", Toast.LENGTH_SHORT).show()
             }
    }
}


