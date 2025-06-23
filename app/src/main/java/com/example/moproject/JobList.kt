package com.example.moproject

import JobPostAdapter
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moproject.databinding.ActivityJobListBinding

data class JobPost(
    val title: String,
    val location: String,
    val time: String,
    val wage: String,
    val imageResId: Int
)

class JobList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityJobListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_job_list)
        val toolbar = binding.toolbar2
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val jobList = listOf(
            JobPost("편의점 야간 지원", "정왕동 사랑점", "22:30~10:30", "시급 10030원", R.drawable.sample1),
            JobPost("카페 서빙 알바", "능곡역 4번 출구", "22:30~10:30", "시급 10030원", R.drawable.sample2),
            JobPost("우유 배달", "정왕동", "06:00~08:00", "시급 9500원", R.drawable.sample3)
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = JobPostAdapter(jobList)
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