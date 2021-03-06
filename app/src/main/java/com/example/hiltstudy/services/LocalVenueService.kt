package com.example.hiltstudy.services

import com.example.hiltstudy.data.Venue
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

// @ActivityScoped
@Singleton
class LocalVenueService @Inject constructor(): VenueService{

    override fun getVenue(): Venue {
        return Venue(venueName = "Morning swim")
    }
}


// @ActivityScoped
@Singleton
class RemoteVenueService @Inject constructor(): VenueService{

    override fun getVenue(): Venue {
        return Venue(venueName = "Morning swim")
    }
}



interface VenueService{
    fun getVenue(): Venue
}



