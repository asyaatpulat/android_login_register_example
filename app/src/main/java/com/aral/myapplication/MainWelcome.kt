package com.aral.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aral.myapplication.databinding.ActivityMainWelcomeBinding

class MainWelcome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferences = getSharedPreferences("data", MODE_PRIVATE)
        val registeredUser = preferences.getString("user", "")
        val registeredPassword = preferences.getString("password", "")

        binding.userInfo.text = "User Name :" + registeredUser.toString()
        binding.userPassword.text = "Password :" + registeredPassword.toString()
        binding.btnLogOut.setOnClickListener {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}