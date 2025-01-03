package com.example.ragistrationform.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.ragistrationform.DataClass.UserList
import com.example.ragistrationform.database.DbHelper

class ViewDataNamesActivityViewModel(val context: Context):ViewModel() {
    fun getAllData():List<UserList> {
        val db = DbHelper(context)
        val list = db.getAllData()
        return list
    }


}