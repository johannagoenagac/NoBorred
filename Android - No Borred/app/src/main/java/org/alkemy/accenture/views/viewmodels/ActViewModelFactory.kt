package org.alkemy.accenture.views.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.alkemy.accenture.views.repository.ActivitiesRepository


class ActViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        val repository = ActivitiesRepository()

        return ActViewModel(repository) as T
    }
}