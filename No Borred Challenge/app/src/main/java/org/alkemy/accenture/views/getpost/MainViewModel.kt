package org.alkemy.accenture.views.getpost

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.alkemy.accenture.data.posts.PostRepository
import org.alkemy.accenture.data.RepositoryError
import org.alkemy.accenture.data.RepositoryResponse
import org.alkemy.accenture.data.ResponseListener
import org.alkemy.accenture.models.Post

class MainViewModel(
    private val repository: PostRepository
): ViewModel() {

    val post = MutableLiveData<Post?>(null)
    val loading = MutableLiveData<Boolean>(false)
    val error = MutableLiveData<String?>(null)

    fun getPost(id: Int) {

        error.value = null
        post.value = null
        loading.value = true

        repository.getPost(id, object: ResponseListener<Post> {

            override fun onResponse(response: RepositoryResponse<Post>) {
                val postResponse = response.data

                loading.value = false
                error.value = null
                post.value = postResponse
            }

            override fun onError(repositoryError: RepositoryError) {
                val message = "${repositoryError.message} (code: ${repositoryError.code})"

                loading.value = false
                error.value = message
                post.value = null
            }

        })
    }

    fun createPost(newPost: Post) {
        repository.createPost(newPost,object: ResponseListener<Post> {

            override fun onResponse(response: RepositoryResponse<Post>) {
                val postResponse = response.data

                loading.value = false
                error.value = null
                post.value = postResponse
            }

            override fun onError(repositoryError: RepositoryError) {
                val message = "${repositoryError.message} (code: ${repositoryError.code})"

                loading.value = false
                error.value = message
                post.value = null
            }

        })
    }

}