package org.alkemy.accenture.views.data.post

    import org.alkemy.accenture.views.RetrofitService
    import org.alkemy.accenture.views.data.RepositoryError
    import org.alkemy.accenture.views.data.RepositoryResponse
    import org.alkemy.accenture.views.data.ResponseListener
    import org.alkemy.accenture.views.data.Source
    import org.alkemy.accenture.views.models.ActivityModel
    import retrofit2.Call
    import retrofit2.Callback
    import retrofit2.Response

    class PostRemoteDataSource {

        fun getPostSuggestion(partcipantsNumber: Int, listener: ResponseListener<ActivityModel>) {
            val service = RetrofitService.instance
                .create(PostService::class.java)
                .getPostSuggestion(partcipantsNumber)

            service.enqueue(object : Callback<ActivityModel> {

                override fun onResponse(call: Call<ActivityModel>, response: Response<ActivityModel>) {
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

                override fun onFailure(call: Call<ActivityModel>, t: Throwable) {
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

        fun getSuggestion(
            participants: Int,
            type: String,
            listener: ResponseListener<ActivityModel>
        ) {
            println("TIPO $type")
            println("PARTICIPANTS $participants")
            val service = RetrofitService.instance
                .create(PostService::class.java)
                .getSuggestionByParticipantsAndType(participants, type)

            service.enqueue(object : Callback<ActivityModel> {

                override fun onResponse(
                    call: Call<ActivityModel>,
                    response: Response<ActivityModel>
                ) {
                    val suggestion = response.body()
                    if (response.isSuccessful && suggestion != null) {
                        listener.onResponse(
                            RepositoryResponse(
                                data = suggestion,
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

                override fun onFailure(call: Call<ActivityModel>, t: Throwable) {
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
