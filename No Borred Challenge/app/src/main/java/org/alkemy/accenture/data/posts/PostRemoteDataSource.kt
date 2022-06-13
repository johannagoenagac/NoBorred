package org.alkemy.accenture.data.posts

import org.alkemy.accenture.data.RetrofitService
import org.alkemy.accenture.data.RepositoryError
import org.alkemy.accenture.data.RepositoryResponse
import org.alkemy.accenture.data.ResponseListener
import org.alkemy.accenture.data.Source
import org.alkemy.accenture.models.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRemoteDataSource {

    fun getPost(id: Int, listener: ResponseListener<Post>) {
        val service = RetrofitService.instance
            .create(PostService::class.java)
            .getPost(id)

        service.enqueue(object : Callback<Post> {

            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                val post = response.body()
                if (response.isSuccessful && post != null) {
                    listener.onResponse(
                        RepositoryResponse(
                            data = post,
                            source = Source.REMOTE
                        )
                    )
                } else {
                    listener.onError(
                        RepositoryError(
                            message = "El servidor rechazó la solicitud",
                            code = response.code(),
                            source = Source.REMOTE
                        )
                    )
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                listener.onError(
                    RepositoryError(
                        message = t.message ?: "Error inesperado",
                        code = -1,
                        source = Source.REMOTE
                    )
                )
            }

        })
    }

    fun getPosts(listener: ResponseListener<List<Post>>) {
        val service = RetrofitService.instance
            .create(PostService::class.java)
            .getPosts()

        service.enqueue(object : Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val posts = response.body()
                if (response.isSuccessful && posts != null) {
                    listener.onResponse(
                        RepositoryResponse(
                            data = posts,
                            source = Source.REMOTE
                        )
                    )
                } else {
                    listener.onError(
                        RepositoryError(
                            message = "El servidor rechazó la solicitud",
                            code = response.code(),
                            source = Source.REMOTE
                        )
                    )
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                listener.onError(
                    RepositoryError(
                        message = t.message ?: "Error inesperado",
                        code = -1,
                        source = Source.REMOTE
                    )
                )
            }

        })
    }

    fun createPost(post: Post, listener: ResponseListener<Post>) {
        val service = RetrofitService.instance
            .create(PostService::class.java)
            .createPost(post)

        service.enqueue(object : Callback<Post> {

            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                val createdPost = response.body()
                if (response.isSuccessful && createdPost != null) {
                    listener.onResponse(
                        RepositoryResponse(
                            data = createdPost,
                            source = Source.REMOTE
                        )
                    )
                } else {
                    listener.onError(
                        RepositoryError(
                            message = "El servidor rechazó la solicitud",
                            code = response.code(),
                            source = Source.REMOTE
                        )
                    )
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                listener.onError(
                    RepositoryError(
                        message = t.message ?: "Error inesperado",
                        code = -1,
                        source = Source.REMOTE
                    )
                )
            }

        })
    }

}