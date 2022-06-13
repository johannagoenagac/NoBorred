package org.alkemy.accenture.data.posts

import org.alkemy.accenture.models.Post
import retrofit2.Call
import retrofit2.http.*

interface PostService {

    @GET("/posts")
    fun getPosts(): Call<List<Post>>

    @GET("/posts/{id}")
    fun getPost(@Path("id") id: Int): Call<Post>

    @POST("/posts")
    fun createPost(@Body post: Post): Call<Post>

}