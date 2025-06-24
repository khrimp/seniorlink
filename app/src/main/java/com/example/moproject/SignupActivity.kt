package com.example.moproject

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.moproject.databinding.ActivitySignupBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var regionLauncher: ActivityResultLauncher<Intent>
    private var selectedRegion: String = "서울" // 기본값 (또는 DongSelect에서 받아올 수도 있음)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        regionLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val region = result.data?.getStringExtra("selectedRegion")
                if (!region.isNullOrEmpty()) {
                    selectedRegion = region
                    binding.btnSelectRegion.text = region // 버튼에 지역 표시
                }
            }
        }

        // 직종 선택
        val selectedType = when (binding.radioGroupType.checkedRadioButtonId) {
            R.id.radioWorker -> "WORKER"
            R.id.radioEmployer -> "EMPLOYER"
            else -> "WORKER" // 기본값
        }

        // 지역 선택 (DongSelect 액티비티로 이동)
        binding.btnSelectRegion.setOnClickListener {
            val intent = Intent(this, DongSelect::class.java)
            regionLauncher.launch(intent)
        }

        // 회원가입 완료 버튼 클릭 시
        binding.btnSignupComplete.setOnClickListener {
            val loginId = binding.etLoginId.text.toString()
            val password = binding.etPassword.text.toString()
            val name = binding.etName.text.toString()
            val age = binding.etAge.text.toString().toIntOrNull() ?: 0
            val phoneNumber = binding.etPhone.text.toString()

            // 간단한 유효성 검사
            if (loginId.isEmpty() || password.isEmpty() || name.isEmpty() || phoneNumber.isEmpty()) {
                Toast.makeText(this, "모든 항목을 입력하세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            RetrofitClient.instance.signUp(
                loginId, password, name, age, phoneNumber, selectedType, selectedRegion
            ).enqueue(object : Callback<SignUpResponse> {
                override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
                    if (response.isSuccessful && response.body()?.result == "성공") {
                        Toast.makeText(this@SignupActivity, "회원가입 성공!", Toast.LENGTH_SHORT).show()
                        finish()
                    } else {
                        Toast.makeText(this@SignupActivity, "회원가입 실패: ${response.body()?.result}", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                    Toast.makeText(this@SignupActivity, "서버 오류: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}
