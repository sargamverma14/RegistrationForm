package com.example.ragistrationform

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.ragistrationform.DataClass.MyDataClass
import com.example.ragistrationform.Factory.ViewDataActivityFactory
import com.example.ragistrationform.Factory.individualAllDataFactory
import com.example.ragistrationform.databinding.ActivityIndividualAllDataBinding
import com.example.ragistrationform.databinding.ActivityViewDataNamesBinding
import com.example.ragistrationform.viewModel.ViewDataNamesActivityViewModel
import com.example.ragistrationform.viewModel.individualAllDataViewModel

class individualAllDataActivity : AppCompatActivity() {
    lateinit var factory:individualAllDataFactory
    lateinit var viewModel:individualAllDataViewModel
    lateinit var binding: ActivityIndividualAllDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title ="response of form"

        binding = DataBindingUtil.setContentView(this,R.layout.activity_individual_all_data)
        factory = individualAllDataFactory(this)
        viewModel = ViewModelProvider(this,factory)[individualAllDataViewModel::class.java]
       val intent = intent
       val data =  intent.getSerializableExtra("Data") as MyDataClass
        binding.tvname.text = data.name
        binding.tvcontact.text = data.contact
        binding.tvdob.text = data.dob
        binding.tvadhar.text = data.aadhar
        binding.tvpan.text = data.pan
        binding.tvaddress.text = data.address
        binding.tvmail.text = data.email
        binding.tvgen.text = data.gender
        binding.tvcourse.text = data.courses
        val img = data.image
        binding.image.setImageBitmap(img)

    }

    override fun onResume() {
        super.onResume()
        val intent = intent
        val data =  intent.getSerializableExtra("Data") as MyDataClass
        binding.tvname.text = "Name: "+data.name
        binding.tvcontact.text = "Contact: "+data.contact
        binding.tvdob.text = "Date of Birth: "+data.dob
        binding.tvadhar.text = "Aadhar: "+data.aadhar
        binding.tvpan.text = "Pan no. : "+data.pan
        binding.tvaddress.text = "Address: "+data.address
        binding.tvmail.text = "Mail-Id : "+data.email
        binding.tvgen.text = "Gender: "+data.gender
        binding.tvcourse.text = "Course: "+data.courses
    }
}