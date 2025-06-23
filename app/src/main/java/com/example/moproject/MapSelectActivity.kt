package com.example.moproject

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.moproject.databinding.ActivityMapSelectBinding

class MapSelectActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMapSelectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFinish.setOnClickListener {
            finish()
        }
        // 툴바 설정
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "동네설정"
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

