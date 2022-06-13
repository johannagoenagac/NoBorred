package org.alkemy.accenture.data.posts

import org.alkemy.accenture.data.ResponseListener
import org.alkemy.accenture.models.Post

class PostRepository(
    private val remoteDataSource: PostRemoteDataSource
) {

    fun getPost(id: Int, listener: ResponseListener<Post>) {
        this.remoteDataSource.getPost(id,listener)
    }

    fun getPosts(listener: ResponseListener<List<Post>>) {
        this.remoteDataSource.getPosts(listener)
    }

    fun createPost(post: Post, listener: ResponseListener<Post>) {
        this.remoteDataSource.createPost(post,listener)
    }

}