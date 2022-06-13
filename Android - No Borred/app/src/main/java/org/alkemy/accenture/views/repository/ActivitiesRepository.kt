package org.alkemy.accenture.views.repository

import androidx.recyclerview.widget.RecyclerView
import org.alkemy.accenture.views.Activities
import org.alkemy.accenture.views.intents.ActActivity

class ActivitiesRepository{
    private val activities = listOf(
        Activities("Education"),
        Activities("Recreational"),
        Activities("Social"),
        Activities("Diy"),
        Activities("Charity"),
        Activities("Cooking"),
        Activities("Relaxation"),
        Activities("Music"),
        Activities("Busywork")
    )
    fun getActivities(): List<Activities>? {
    return activities
}
}