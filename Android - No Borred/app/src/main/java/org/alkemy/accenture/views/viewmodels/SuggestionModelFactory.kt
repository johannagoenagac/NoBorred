package org.alkemy.accenture.views.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.alkemy.accenture.views.SuggestionViewModel
import org.alkemy.accenture.views.data.post.*

class SuggestionModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

            val remoteDataSource = PostRemoteDataSource()
            val repository = PostRepository(remoteDataSource)

            return SuggestionViewModel(repository) as T
    }


}
