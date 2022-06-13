package org.alkemy.accenture.views.intents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.alkemy.accenture.databinding.TycActivityBinding

class TYCActivity: AppCompatActivity() {

    private lateinit var binding: TycActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TycActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    
}