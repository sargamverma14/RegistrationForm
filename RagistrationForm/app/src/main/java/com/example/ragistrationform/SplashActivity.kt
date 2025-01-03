package com.example.ragistrationform

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.ragistrationform.Factory.SplashFactory
import com.example.ragistrationform.viewModel.SplashActivityViewModel

class SplashActivity : AppCompatActivity() {
    lateinit var factory: SplashFactory
    lateinit var viewModel: SplashActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        factory = SplashFactory(this)
        viewModel = ViewModelProvider(this,factory)[SplashActivityViewModel::class.java]
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            var check = viewModel.checkLogin()
            if(check)
            {
//           val intent = Intent(this,Login_Activity::class.java)
                val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
            }
            else{
                val intent = Intent(this,Login_Activity::class.java)
                startActivity(intent)
                finish()
            }

        },2000)

    }
}