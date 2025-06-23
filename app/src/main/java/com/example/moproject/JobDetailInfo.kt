package com.example.moproject

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.moproject.databinding.ActivityJobDetailInfoBinding

class JobDetailInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityJobDetailInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "직장 정보"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val title = intent.getStringExtra("title")
        val location = intent.getStringExtra("location")
        val time = intent.getStringExtra("time")
        val wage = intent.getStringExtra("wage")
        val imageResId = intent.getIntExtra("imageResId", R.drawable.sample1)

        binding.detailTitle.text = title
        binding.detailLocation.text = location
        binding.detailTime.text = time
        binding.detailWage.text = wage
        binding.detailImage.setImageResource(imageResId)
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