package org.alkemy.accenture.views

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.alkemy.accenture.databinding.NavActivitiesItemBinding
import org.alkemy.accenture.views.Activities

class ActivitiesAdapter(private val activityListener : ActivityListener): RecyclerView.Adapter<ActivitiesAdapter.ActivitiesViewHolder>() {
            private lateinit var activities: List<Activities>

    fun setActivities(newActivities: List<Activities>) {
        this.activities = newActivities
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivitiesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = NavActivitiesItemBinding.inflate(layoutInflater,parent,false)
        return ActivitiesViewHolder(binding, activityListener)
    }

    override fun onBindViewHolder(holder: ActivitiesViewHolder, position: Int) {
        holder.bind(this.activities[position])
    }

    override fun getItemCount(): Int {
        return this.activities.size
    }


    class ActivitiesViewHolder(
        private val binding: NavActivitiesItemBinding,
        private val activityListener : ActivityListener
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(activities: Activities) {
            this.binding.textviewActivitiesItems.text = activities.name
            this.binding.btnNext.setOnClickListener{
                activityListener.onSelect(activities.name)
            }
        }
    }

    interface ActivityListener{
        fun onSelect(activityName : String)
    }

}
