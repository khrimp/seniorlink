package com.example.moproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.moproject.databinding.Activity02Binding

class Activity02 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = Activity02Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "사용 시작"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.button3.setOnClickListener {
            val intent= Intent(this,BusinessMenuActivity::class.java)
            startActivity(intent)
        }

        binding.button4.setOnClickListener {
            val intent= Intent(this,WorkerActivity::class.java)
            startActivity(intent)
        }

        val btnProfile = findViewById<Button>(R.id.btnProfile)
        val btnNotice = findViewById<Button>(R.id.btnNotice)

        btnProfile.setOnClickListener {
            // 프로필 화면 이동
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        btnNotice.setOnClickListener {
            // 공지사항 화면 이동
            val intent = Intent(this, NoticeActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}