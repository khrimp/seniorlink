package com.example.moproject

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.moproject.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSelectRegion.setOnClickListener {
            val intent= Intent(this,DongSelect::class.java)
            startActivity(intent)
        }
    }
}
