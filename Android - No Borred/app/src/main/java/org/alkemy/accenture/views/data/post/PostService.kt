package org.alkemy.accenture.views.data.post

import org.alkemy.accenture.views.models.ActivityModel
import retrofit2.Call
import retrofit2.http.*

interface PostService {


    @GET("/api/activity")
    fun getPostSuggestion(@Query("participants") participants: Int): Call<ActivityModel>

    @GET("/api/activity")
    fun getSuggestionByParticipantsAndType(@Query("participants") participants: Int, @Query("type") type: String): Call<ActivityModel>




}