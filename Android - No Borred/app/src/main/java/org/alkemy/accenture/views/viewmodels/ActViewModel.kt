package org.alkemy.accenture.views.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.alkemy.accenture.views.Activities
import org.alkemy.accenture.views.ActivitiesAdapter
import org.alkemy.accenture.views.repository.ActivitiesRepository

class ActViewModel (private val repository: ActivitiesRepository): ViewModel(){
    val activities = MutableLiveData<List<Activities>?>(null)

    fun onButtonClicked(){
        val repoActivities = repository.getActivities()
        activities.value = repoActivities
    }

    /*fun getActivities(){
        activities.value = repository.getActivities()
        println(activities.value)
    }*/
}