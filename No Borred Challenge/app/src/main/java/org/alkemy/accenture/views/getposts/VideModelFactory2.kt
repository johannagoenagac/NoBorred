package org.alkemy.accenture.views.getposts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.alkemy.accenture.data.posts.PostRemoteDataSource
import org.alkemy.accenture.data.posts.PostRepository

class VideModelFactory2: ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val remoteDataSource = PostRemoteDataSource()
        val repository = PostRepository(remoteDataSource)

        return MainViewModel2(repository) as T
    }

}