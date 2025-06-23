import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moproject.JobDetailInfo
import com.example.moproject.JobPost
import com.example.moproject.databinding.ItemJobInfoBinding

class JobPostAdapter(
    private val jobList: List<JobPost>
) : RecyclerView.Adapter<JobPostAdapter.JobViewHolder>() {

    inner class JobViewHolder(val binding: ItemJobInfoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemJobInfoBinding.inflate(inflater, parent, false)
        return JobViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val job = jobList[position]
        with(holder.binding) {
            imageViewJob.setImageResource(job.imageResId)
            textViewTitle.text = job.title
            textViewLocation.text = job.location
            textViewTime.text = job.time
            textViewWage.text = job.wage
        }

        holder.binding.root.setOnClickListener {
            val context = holder.binding.root.context
            val intent = Intent(context, JobDetailInfo::class.java).apply {
                putExtra("title", job.title)
                putExtra("location", job.location)
                putExtra("time", job.time)
                putExtra("wage", job.wage)
                putExtra("imageResId", job.imageResId)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = jobList.size
}