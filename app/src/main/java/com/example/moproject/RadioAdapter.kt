package com.example.moproject

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView

class RadioAdapter(private val itemCount: Int) : RecyclerView.Adapter<RadioAdapter.RadioViewHolder>() {
    private var selectedPosition = -1

    inner class RadioViewHolder(val radioButton: RadioButton) : RecyclerView.ViewHolder(radioButton)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_radio, parent, false) as RadioButton
        return RadioViewHolder(view)
    }

    override fun onBindViewHolder(holder: RadioViewHolder, position: Int) {
        holder.radioButton.isChecked = (position == selectedPosition)

        holder.radioButton.setOnClickListener {
            val previousPosition = selectedPosition
            selectedPosition = holder.adapterPosition
            notifyItemChanged(previousPosition)
            notifyItemChanged(selectedPosition)
        }
    }

    override fun getItemCount(): Int = itemCount
}