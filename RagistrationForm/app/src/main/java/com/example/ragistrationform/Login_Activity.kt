package com.example.ragistrationform

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.ragistrationform.Factory.LoginFactory
import com.example.ragistrationform.databinding.ActivityLoginBinding
import com.example.ragistrationform.viewModel.LoginViewModel
import com.google.android.material.snackbar.Snackbar

class Login_Activity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding:ActivityLoginBinding
    lateinit var myViewModel : LoginViewModel
    lateinit var Factory :LoginFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        title ="Login & Ragister"
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        Factory = LoginFactory(this@Login_Activity)
        myViewModel = ViewModelProvider(this,Factory)[LoginViewModel::class.java]
       binding.loginBtn.setOnClickListener(this)
       binding.skipBtn.setOnClickListener(this)
       binding.ragisterBtn.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
       when(v!!.id){
           R.id.loginBtn->{
           myViewModel.login(binding.username.text.toString())

        }

           R.id.skipBtn ->{
               myViewModel.skip()
              var intent = Intent(this,MainActivity::class.java)
               startActivity(intent)
               finish()
           }
           R.id.ragisterBtn ->{
               var myintent = Intent(this,UserRagister::class.java)
                startActivity(myintent)
               finish()
           }

       }
    }
}