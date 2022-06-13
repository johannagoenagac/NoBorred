package org.alkemy.accenture.views.getposts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import org.alkemy.accenture.databinding.PostItemBinding
import org.alkemy.accenture.models.Post

class PostAdapter(
    private var posts: List<Post>
): RecyclerView.Adapter<PostAdapter.PostViewHolder>()  {

    fun setPosts(posts: List<Post>) {
        this.posts = posts
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PostItemBinding.inflate(layoutInflater,parent,false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    class PostViewHolder(private val binding: PostItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post) {
            binding.title.text = post.title
            binding.message.text = post.body
            binding.user.text = "Usuario ${post.userId}"
        }
    }


}