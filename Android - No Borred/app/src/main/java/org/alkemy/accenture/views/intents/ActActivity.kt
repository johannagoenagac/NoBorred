package org.alkemy.accenture.views.intents

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import org.alkemy.accenture.databinding.NavActivitiesBinding
import org.alkemy.accenture.views.ActivitiesAdapter
import org.alkemy.accenture.views.viewmodels.ActViewModel
import org.alkemy.accenture.views.viewmodels.ActViewModelFactory
import org.alkemy.accenture.views.Utils
import org.alkemy.accenture.views.viewmodels.Suggestion


class ActActivity: AppCompatActivity() {

    private lateinit var binding: NavActivitiesBinding

    private val viewModel : ActViewModel by viewModels(
        factoryProducer = { ActViewModelFactory() }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NavActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.list.layoutManager = LinearLayoutManager(this)
        viewModel.onButtonClicked()

       /* viewModel.activities.observe(this){value ->
            if (value != null){
                val adapter = ActivitiesAdapter()

                binding.list.adapter = adapter
                adapter.setActivities(value)
            }
        }*/

        //val education = findViewById<EditText>(R.id.Education);
        //education.setEnabled(false);

        //binding.Education.setOnClickListener{
          //  val type = binding.Activities.
        //}


        val participants = this.intent.extras?.getInt(Utils.participantsLabel)
        viewModel.activities.observe(this) { value ->
            if (value != null) {
                val adapter = ActivitiesAdapter(object: ActivitiesAdapter.ActivityListener{
                    override fun onSelect(activityName: String) {
                        val intent = Intent(this@ActActivity , Suggestion::class.java)
                        intent.putExtra(Utils.participantsLabel,1)
                        intent.putExtra(Utils.typeLabel, activityName.lowercase())
                        startActivity(intent)
                    }
                })
                binding.list.adapter = adapter
                adapter.setActivities(value)
            }
        }

        setListeners(participants ?: 0)
        //setObservers()
    }

    private fun setListeners(participants : Int){
        binding.btnRandom.setOnClickListener{
            val intent = Intent(this, Suggestion::class.java)
            intent.putExtra(Utils.participantsLabel,participants)
            intent.putExtra(Utils.typeLabel, "")
            startActivity(intent)
        }
    }

    }
