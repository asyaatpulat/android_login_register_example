package com.aral.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.aral.myapplication.databinding.ActivityMainRegisterBinding

class MainRegister : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val userInfo = binding.userName.text.toString()
            val password = binding.password.text.toString()
            val sharedPreferences = getSharedPreferences("data", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("user", "$userInfo").apply()
            editor.putString("password", "$password").apply()

            Toast.makeText(applicationContext, "Registration Successful", Toast.LENGTH_LONG).show()
            binding.userName.text.clear()
            binding.password.text.clear()
        }

        binding.btnMainPage.setOnClickListener {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}