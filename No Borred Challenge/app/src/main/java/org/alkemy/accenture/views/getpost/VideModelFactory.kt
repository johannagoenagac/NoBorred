package org.alkemy.accenture.views.getpost

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.alkemy.accenture.data.posts.PostRemoteDataSource
import org.alkemy.accenture.data.posts.PostRepository

class VideModelFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        val remoteDataSource = PostRemoteDataSource()
        val repository = PostRepository(remoteDataSource)

        return MainViewModel(repository) as T
    }

}