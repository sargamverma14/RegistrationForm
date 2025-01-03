package com.example.ragistrationform

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.ragistrationform.databinding.ActivityUserRagisterBinding
import com.example.ragistrationform.viewModel.UserRagisterFactory
import com.example.ragistrationform.viewModel.UserRagisterViewModel

class UserRagister : AppCompatActivity() {
    lateinit var binding:ActivityUserRagisterBinding
    lateinit var myViewModel : UserRagisterViewModel
    lateinit var Factory : UserRagisterFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title ="Ragister"

        binding = DataBindingUtil.setContentView(this,R.layout.activity_user_ragister)
        Factory = UserRagisterFactory(this@UserRagister)
        myViewModel = ViewModelProvider(this,Factory)[UserRagisterViewModel::class.java]
        binding.ragister.setOnClickListener{
            myViewModel.setData(binding.user.text.toString())
            var intent = Intent(this,Login_Activity::class.java)
            startActivity(intent)
            finish()
        }

    }
    }
