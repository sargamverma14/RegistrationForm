package com.example.ragistrationform

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.ragistrationform.DataClass.MyDataClass
import com.example.ragistrationform.Factory.MainActivity2Factory
import com.example.ragistrationform.Factory.MainActivityFactory
import com.example.ragistrationform.databinding.ActivityMain2Binding
import com.example.ragistrationform.databinding.ActivityMainBinding
import com.example.ragistrationform.viewModel.MainActivity2ViewModel
import com.example.ragistrationform.viewModel.MainActivityViewModel

class MainActivity2 : AppCompatActivity() {
//     lateinit var mydataBinding :ActivityMain2Binding
lateinit var viewModel: MainActivity2ViewModel
   lateinit var factory : MainActivity2Factory
   lateinit var binding : ActivityMain2Binding
     override fun onCreate(savedInstanceState: Bundle?) {


        //binding....
//        val binding =ActivityMain2Binding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        val intent = intent
        title = "Response of Form"
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main2)
        factory = MainActivity2Factory(this@MainActivity2)
        viewModel = ViewModelProvider(this,factory)[MainActivity2ViewModel::class.java]
         binding.myView = viewModel
        binding.lifecycleOwner = this
         val data = intent.getSerializableExtra("dataClass") as MyDataClass



        val  Name= binding.name
        val  Dob= binding.dob
        val  Contact= binding.contact
        val Address = binding.Add
        val AadharNo = binding.Aadhar
        val Mail = binding.Email
        val PanNo = binding.Pan

        val Gender = binding.Gen
        val course = binding.Course


        Name.text = data.name
        Dob.text = data.dob
        Contact.text = data.contact
        Address.text = data.address
        AadharNo.text = data.aadhar
        Mail.text = data.email
        PanNo.text = data.pan
        Gender.text = data.gender
        course.text = data.courses
//       str = intent.getStringArrayListExtra("checkedItems").toString()
//        Name.text =  intent.getStringExtra("name").toString()
//        Dob.text =  intent.getStringExtra("dob").toString()
//        Contact.text =  intent.getStringExtra("contact").toString()
//        Address.text = intent.getStringExtra("address").toString()
//        AadharNo.text =  intent.getStringExtra("aadhar").toString()
//        Mail.text =  intent.getStringExtra("email-id").toString()
//        PanNo.text =  intent.getStringExtra("pan").toString()
//        Gender.text =  intent.getStringExtra("gender").toString()
//        course.text =  intent.getStringExtra("checkedItems").toString()









    }
}