package org.alkemy.accenture.views

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import org.alkemy.accenture.views.data.ResponseListener
import org.alkemy.accenture.views.data.RepositoryError
import org.alkemy.accenture.views.data.RepositoryResponse
import org.alkemy.accenture.views.data.post.PostRepository
import org.alkemy.accenture.views.models.ActivityModel


class SuggestionViewModel (
    private val repository: PostRepository
): ViewModel() {

    val suggestion = MutableLiveData<ActivityModel?>(null)
    val loading = MutableLiveData<Boolean>(false)
    val error = MutableLiveData<String?>(null)

    fun getRandomSuggestion(participantsNumber : Int) {

        error.value = null
        suggestion.value = null
        loading.value = true

        repository.getPostSuggestion(participantsNumber, object: ResponseListener<ActivityModel> {

            override fun onResponse(response: RepositoryResponse<ActivityModel>) {
                val suggestionResponse = response.data

                loading.value = false
                error.value = null
                suggestionResponse.also { suggestion.value = it }
            }

            override fun onError(repositoryError: RepositoryError) {
                val message = "${repositoryError.message} (code: ${repositoryError.code})"

                loading.value = false
                error.value = message
                suggestion.value = null
            }

        })
    }

     fun getSuggestion(participantsNumber : Int, type : String) {

      error.value = null
      suggestion.value = null
      loading.value = true

   repository.getSuggestionByParticipantsAndType(participantsNumber, type, object: ResponseListener<ActivityModel> {

          override fun onResponse(response: RepositoryResponse<ActivityModel>) {
              val suggestionResponse = response.data

              loading.value = false
              error.value = null
              suggestion.value = suggestionResponse
          }

          override fun onError(repositoryError: RepositoryError) {
              val message = "${repositoryError.message} (code: ${repositoryError.code})"

              loading.value = false
              error.value = message
              suggestion.value = null
          }

      })
    }

}

