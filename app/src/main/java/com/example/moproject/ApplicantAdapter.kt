package com.example.moproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moproject.databinding.ItemApplicantBinding

class ApplicantAdapter(private val applicants: List<Applicant>) :
    RecyclerView.Adapter<ApplicantAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemApplicantBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(applicant: Applicant) {
            binding.applicantName.text = applicant.name
            binding.applicantId.text = applicant.maskedId
            binding.applicantPhone.text = applicant.phone
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemApplicantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = applicants.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(applicants[position])
    }
}
