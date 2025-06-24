package com.example.moproject

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.moproject.databinding.Activity02Binding

class Activity02 : AppCompatActivity() {
    private var token: String? = null // ← 토큰 저장용 변수

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = Activity02Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "사용 시작"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // ✅ 로그인 액티비티에서 전달된 토큰 받기
        token = intent.getStringExtra("token")

        // 버튼 이벤트
        binding.button3.setOnClickListener {
            val intent = Intent(this, BusinessMenuActivity::class.java)
            intent.putExtra("token", token)
            startActivity(intent)
        }

        binding.button4.setOnClickListener {
            val intent = Intent(this, WorkerActivity::class.java)
            intent.putExtra("token", token)
            startActivity(intent)
        }

        val btnProfile = findViewById<Button>(R.id.btnProfile)
        val btnNotice = findViewById<Button>(R.id.btnNotice)

        btnProfile.setOnClickListener {
            // ✅ 프로필 화면에 토큰 전달
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("token", token)
            startActivity(intent)
        }

        btnNotice.setOnClickListener {
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
