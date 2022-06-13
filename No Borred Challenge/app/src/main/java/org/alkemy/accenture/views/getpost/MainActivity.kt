package org.alkemy.accenture.views.getpost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import org.alkemy.accenture.databinding.MainActivityBinding
import org.alkemy.accenture.models.Post

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    private val viewModel: MainViewModel by viewModels(
        factoryProducer = { VideModelFactory() }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            //val post = Post(title = "Hola mundo", body = "Soy un post", userId = 14)
            //viewModel.createPost(post)
            if (binding.input.text.toString().isNotEmpty()) {
                val postId = Integer.parseInt(binding.input.text.toString())
                viewModel.getPost(postId)
            }
        }

        viewModel.post.observe(this) { value ->
            if (value != null) {
                binding.title.text = value.title
                binding.message.text = value.body
                binding.user.text = "Usuario ${value.userId}"
            } else {
                binding.title.text = ""
                binding.message.text = ""
                binding.user.text = ""
            }
        }

        viewModel.loading.observe(this) { value ->
            binding.button.isEnabled = !value
            binding.loading.visibility = if (value) View.VISIBLE else View.GONE
        }

        viewModel.error.observe(this) { value ->
            if (value != null) {
                Toast.makeText(this,value,Toast.LENGTH_LONG).show()
            }
        }

    }

}


