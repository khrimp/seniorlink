package com.example.moproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moproject.databinding.ActivityJobStatusBinding

class JobStatusActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJobStatusBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobStatusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 툴바
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "등록한 일거리 현황"

        // RecyclerView 세팅
        val sampleJobs = listOf(
            Job("sample1", "편의점 야간 지원", "정왕동 사랑점", "근무자를 찾고 있습니다."),
            Job("sample2", "카페 서빙 알바", "능곡역 4번출구 스타벅스", "오전 근무자를 찾습니다."),
            Job("sample3", "우유 배달", "거모동", "아침에 우유 배달해주실 분 구합니다."),
            Job("sample4", "병원 번호표 도우미", "정왕동 시화병원", "도우미를 구하고 있습니다.")
        )

        val adapter = JobStatusAdapter(sampleJobs)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
