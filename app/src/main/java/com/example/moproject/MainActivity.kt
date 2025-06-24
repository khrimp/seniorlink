package com.example.moproject

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.moproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        // 로그인 버튼 클릭
        binding.btnLogin.setOnClickListener {
            val loginId = binding.etPhone.text.toString()
            val password = binding.etPassword.text.toString()

            if (loginId.isBlank() || password.isBlank()) {
                Toast.makeText(this, "아이디와 비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 로그인 API 호출
            RetrofitClient.instance.login(loginId, password)
                .enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        if (response.isSuccessful && response.body()?.result == "성공") {
                            Toast.makeText(
                                this@MainActivity,
                                "로그인 성공: ${response.body()?.userName}",
                                Toast.LENGTH_SHORT
                            ).show()

                            // 토큰과 사용자 이름 등 전달
                            val token = response.body()?.token
                            val intent = Intent(this@MainActivity, Activity02::class.java)
                            intent.putExtra("token", token)
                            intent.putExtra("userName", response.body()?.userName)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this@MainActivity, "로그인 실패", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(this@MainActivity, "서버 오류: ${t.message}", Toast.LENGTH_SHORT).show()
                    }
                })
        }

        // 회원가입 버튼 클릭
        binding.btnSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}
