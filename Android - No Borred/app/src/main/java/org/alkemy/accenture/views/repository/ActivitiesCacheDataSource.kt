package org.alkemy.accenture.views.repository

import org.alkemy.accenture.views.Activities

class ActivitiesCacheDataSource (

    val cache: ActivitiesCacheDataSource
    ) {
        fun getActivities(): List<Activities>? {
            return cache.getActivities()
        }


}




