package com.example.moproject

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        // 인텐트로부터 토큰 받기
        val token = intent.getStringExtra("token")

        if (token == null) {
            Toast.makeText(this, "토큰이 없습니다.", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        // API 호출로 사용자 정보 가져오기
        RetrofitClient.instance.getUserInfo("Bearer $token")
            .enqueue(object : Callback<UserInfoResponse> {
                override fun onResponse(call: Call<UserInfoResponse>, response: Response<UserInfoResponse>) {
                    if (response.isSuccessful) {
                        val user = response.body()?.user
                        user?.let {
                            tvName.text = "이름: ${it.name}"
                            tvPhone.text = "전화번호: ${it.phoneNumber}"
                            tvRegion.text = "지역: ${it.region}"
                            tvUserType.text = "유형: ${if (it.type == "WORKER") "노동자" else "사업자"}"
                        }
                    } else {
                        Toast.makeText(this@ProfileActivity, "사용자 정보 불러오기 실패", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<UserInfoResponse>, t: Throwable) {
                    Toast.makeText(this@ProfileActivity, "서버 오류: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
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
