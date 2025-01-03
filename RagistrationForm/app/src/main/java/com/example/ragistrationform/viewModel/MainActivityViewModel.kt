package com.example.ragistrationform.viewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ragistrationform.database.DbHelper

class MainActivityViewModel(val context: Context): ViewModel() {
    val shred_pref = context.getSharedPreferences("Login", Context.MODE_PRIVATE)
    var userName = MutableLiveData<String>()
    fun setUsername():String{
       userName.value = shred_pref.getString("username",null).toString()
        val tvuserName = "User : "+userName.value.toString()
        return tvuserName
    }
    fun insertFormData(name:String, contact:String, dob:String, address:String, mail:String, aadhar:String, pan:String, gen:String, course:String, image :String){
        val db = DbHelper(context)
        db.insertData(name,contact,dob,address,mail,aadhar,pan,gen,course,image)
    }
    fun logout(){
        shred_pref.edit().putString("username",null).apply()
    }
}