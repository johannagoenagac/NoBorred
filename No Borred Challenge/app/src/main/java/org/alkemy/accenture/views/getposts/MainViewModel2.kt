package org.alkemy.accenture.views.getposts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.alkemy.accenture.data.posts.PostRepository
import org.alkemy.accenture.data.RepositoryError
import org.alkemy.accenture.data.RepositoryResponse
import org.alkemy.accenture.data.ResponseListener
import org.alkemy.accenture.models.Post

class MainViewModel2(
    private val repository: PostRepository
): ViewModel() {

    val posts = MutableLiveData<List<Post>?>(null)
    val loading = MutableLiveData<Boolean>(false)
    val error = MutableLiveData<String?>(null)

    fun getPosts() {

        error.value = null
        posts.value = null
        loading.value = true

        repository.getPosts(object: ResponseListener<List<Post>> {

            override fun onResponse(response: RepositoryResponse<List<Post>>) {
                val postResponse = response.data

                loading.value = false
                error.value = null
                posts.value = postResponse
            }

            override fun onError(repositoryError: RepositoryError) {
                val message = "${repositoryError.message} (code: ${repositoryError.code})"

                loading.value = false
                error.value = message
                posts.value = null
            }

        })
    }

}