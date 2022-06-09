package com.aral.myapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.aral.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = getSharedPreferences("data", MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {
            val registeredUser = preferences.getString("user", "")
            val registeredPassword = preferences.getString("password", "")
            val loginUser = binding.loginUserName.text.toString()
            val loginPassword = binding.loginPassword.text.toString()
            if (registeredUser == loginUser && registeredPassword == loginPassword) {
                intent = Intent(applicationContext, MainWelcome::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "Login Incorrect", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnRegister2.setOnClickListener {
            intent = Intent(applicationContext, MainRegister::class.java)
            startActivity(intent)
        }
    }
}