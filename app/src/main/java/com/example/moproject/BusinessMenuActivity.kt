package com.example.moproject

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.moproject.databinding.ActivityBusinessMenuBinding

class BusinessMenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBusinessMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBusinessMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 툴바 설정
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "사업자 메뉴"


        binding.registerStatusLayout.setOnClickListener {
            val intent = Intent(this, JobStatusActivity::class.java)
            startActivity(intent)
        }

        binding.registerJobLayout.setOnClickListener {
            val intent = Intent(this, JobRegister::class.java)
            startActivity(intent)
        }

        val btnProfile = findViewById<Button>(R.id.btnProfile)
        val btnNotice = findViewById<Button>(R.id.btnNotice)
        val btnHome = findViewById<Button>(R.id.btnHome)

        btnHome.setOnClickListener {
            val intent= Intent(this,Activity02::class.java)
            startActivity(intent)
        }

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

    // 👉 툴바의 뒤로가기(<) 버튼 클릭 처리
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

