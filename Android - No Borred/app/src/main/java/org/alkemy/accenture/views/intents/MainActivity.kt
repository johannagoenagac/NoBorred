package org.alkemy.accenture.views.intents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.alkemy.accenture.databinding.MainActivityBinding
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import org.alkemy.accenture.views.Utils
import org.alkemy.accenture.views.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonActivityStart.setOnClickListener {
            val intent = Intent(this, ActActivity::class.java)
            startActivity(intent)
        }

        binding.textViewTyc.setOnClickListener {
            val intent = Intent(this, TYCActivity::class.java)
            startActivity(intent)
        }


        binding.buttonActivityStart.setOnClickListener{
            val intent = Intent(this, ActActivity::class.java)
            intent.putExtra(Utils.participantsLabel,viewModel.participantsNumber)
            startActivity(intent)
        }

        setListeners()
        setObservers()

    }

    private fun setListeners() {
        binding.editTextNumber.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence,start: Int,
                                       before: Int, count: Int) {
                viewModel.numberVerification(s.toString())
            }
        })
    }

    //Observer valida cambios en el Viewmodel
    private fun setObservers(){
        viewModel.blockbutton.observe(this){value ->
            binding.buttonActivityStart.isEnabled = value
        }
    }
    }





