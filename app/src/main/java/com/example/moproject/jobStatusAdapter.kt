package com.example.moproject

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moproject.databinding.ItemJobBinding
import android.content.Intent



class JobStatusAdapter(private val jobs: List<Job>) : RecyclerView.Adapter<JobStatusAdapter.JobViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val binding = ItemJobBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JobViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        holder.bind(jobs[position])
    }

    override fun getItemCount(): Int = jobs.size

    inner class JobViewHolder(private val binding: ItemJobBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(job: Job) {
            val context = binding.root.context
            val resId = context.resources.getIdentifier(job.imageName, "drawable", context.packageName)

            binding.imageView.setImageResource(resId)
            binding.title.text = job.title
            binding.description.text = job.description
            binding.location.text = job.location

            // 동네 설정 버튼 클릭
            binding.btnSetLocation.setOnClickListener {
                val intent = Intent(context, MapSelectActivity::class.java)
                context.startActivity(intent)
            }

            // 지원 현황 보기 버튼 클릭
            binding.btnApplicantStatus.setOnClickListener {
                val intent = Intent(context, ApplicantStatusActivity::class.java)
                context.startActivity(intent)
            }
        }
    }

}

