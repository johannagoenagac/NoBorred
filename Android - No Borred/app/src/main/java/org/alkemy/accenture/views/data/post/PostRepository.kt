package org.alkemy.accenture.views.data.post

import org.alkemy.accenture.views.data.ResponseListener
import org.alkemy.accenture.views.data.post.PostRemoteDataSource
import org.alkemy.accenture.views.models.ActivityModel

class PostRepository(
    private val remoteDataSource: PostRemoteDataSource
) {


    fun getPostSuggestion(participantsNumber : Int, listener: ResponseListener<ActivityModel>) {
        this.remoteDataSource.getPostSuggestion(participantsNumber, listener)
    }

    fun getSuggestionByParticipantsAndType(participants: Int,type: String, listener: ResponseListener<ActivityModel>) {
        this.remoteDataSource.getSuggestion(participants,type,listener)
    }


}