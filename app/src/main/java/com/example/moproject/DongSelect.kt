package com.example.moproject

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moproject.databinding.ActivityDongSelectBinding

class DongSelect : AppCompatActivity() {

    private val itemList = listOf(
        "대야동", "계수동", "신천동", "방산동", "포동", "미산동", "은행동",
        "안현동", "매화동", "도창동", "금이동", "목감동", "물왕동", "산현동",
        "조남동", "논곡동", "군자동", "거모동", "월곶동", "정왕동", "배곧동",
        "죽율동", "과림동", "무지내동", "하중동", "하상동", "광석동", "장현동",
        "장곡동", "능곡동", "화정동"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityDongSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = RadioAdapter(itemList) { selectedRegion ->
            val resultIntent = Intent()
            resultIntent.putExtra("selectedRegion", selectedRegion)
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        binding.radioRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.radioRecyclerView.adapter = adapter
    }

    class RadioAdapter(
        private val items: List<String>,
        private val onItemSelected: (String) -> Unit // 선택 콜백
    ) : RecyclerView.Adapter<RadioAdapter.RadioViewHolder>() {

        private var selectedPosition = -1

        inner class RadioViewHolder(val radioButton: RadioButton) : RecyclerView.ViewHolder(radioButton)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioViewHolder {
            val radioButton = RadioButton(parent.context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                textSize = 18f
                setPadding(32, 32, 32, 32)
            }
            return RadioViewHolder(radioButton)
        }

        override fun onBindViewHolder(holder: RadioViewHolder, position: Int) {
            holder.radioButton.text = items[position]
            holder.radioButton.isChecked = (position == selectedPosition)

            holder.radioButton.setOnClickListener {
                val prev = selectedPosition
                selectedPosition = holder.adapterPosition
                notifyItemChanged(prev)
                notifyItemChanged(selectedPosition)

                // 선택한 항목을 콜백으로 전달하고 종료
                onItemSelected(items[position])
            }
        }

        override fun getItemCount(): Int = items.size
    }
}
