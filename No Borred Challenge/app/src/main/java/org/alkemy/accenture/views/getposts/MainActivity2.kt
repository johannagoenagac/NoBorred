package org.alkemy.accenture.views.getposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import org.alkemy.accenture.databinding.MainActivity2Binding
import org.alkemy.accenture.databinding.MainActivityBinding
import org.alkemy.accenture.views.getpost.MainViewModel
import org.alkemy.accenture.views.getpost.VideModelFactory

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: MainActivity2Binding
    private val viewModel: MainViewModel2 by viewModels(
        factoryProducer = { VideModelFactory2() }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            viewModel.getPosts()
        }

        binding.lista.layoutManager = LinearLayoutManager(this)
        val adapter = PostAdapter(emptyList())
        binding.lista.adapter = adapter

        viewModel.posts.observe(this) { value ->
            if (value != null) {
                adapter.setPosts(value)
            } else {
                adapter.setPosts(emptyList())
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


