package com.example.moproject

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val tvName = findViewById<TextView>(R.id.tvName)
        val tvPhone = findViewById<TextView>(R.id.tvPhone)
        val tvRegion = findViewById<TextView>(R.id.tvRegion)
        val tvUserType = findViewById<TextView>(R.id.tvUserType)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "프로필"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // 예: 인텐트로 전달 받기 (또는 SharedPreferences, DB에서 불러오기)
        val name = intent.getStringExtra("name") ?: "홍길동"
        val phone = intent.getStringExtra("phone") ?: "010-1234-5678"
        val region = intent.getStringExtra("region") ?: "서울"
        val userType = intent.getStringExtra("userType") ?: "노동자"

        tvName.text = "이름: $name"
        tvPhone.text = "전화번호: $phone"
        tvRegion.text = "지역: $region"
        tvUserType.text = "유형: $userType"
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
