package com.example.ragistrationform

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.ragistrationform.Factory.ViewDataActivityFactory
import com.example.ragistrationform.database.CustomLisetAdaptor
import com.example.ragistrationform.databinding.ActivityViewDataNamesBinding
import com.example.ragistrationform.viewModel.ViewDataNamesActivityViewModel

class ViewDataNamesActivity : AppCompatActivity(){
    lateinit var factory:ViewDataActivityFactory
    lateinit var viewModel:ViewDataNamesActivityViewModel
    lateinit var binding:ActivityViewDataNamesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title ="Data by Names"

//        setContentView(R.layout.activity_view_data_names)
         binding = DataBindingUtil.setContentView(this,R.layout.activity_view_data_names)
        factory = ViewDataActivityFactory(this)
         viewModel = ViewModelProvider(this,factory)[ViewDataNamesActivityViewModel::class.java]

       val list = viewModel.getAllData()

        binding.listview.adapter = CustomLisetAdaptor(this,list)

    }


    override fun onResume() {
        super.onResume()
        val list = viewModel.getAllData()
        binding.listview.adapter = CustomLisetAdaptor(this,list)


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    )
    {  super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==101 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
       val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:"+CustomLisetAdaptor.phone))
       startActivity(intent)
        }

    }


}