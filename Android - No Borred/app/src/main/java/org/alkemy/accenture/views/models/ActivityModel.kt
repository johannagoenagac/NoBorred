package org.alkemy.accenture.views.models

import com.google.gson.annotations.SerializedName

data class ActivityModel(
    @SerializedName("activity")
    val activity: String,
    @SerializedName("accessibility")
    val accessibility: Double,
    @SerializedName("type")
    val type: String,
    @SerializedName("participants")
    val participants: Int,
    @SerializedName("price")
    val price: Double,
    @SerializedName("key")
    val key: Int
)