package com.example.moproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.moproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            val intent= Intent(this,Activity02::class.java)
            startActivity(intent)
        }
        binding.btnSignup.setOnClickListener {
            val intent= Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }
    }
}