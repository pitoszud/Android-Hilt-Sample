package com.example.hiltstudy.services

import com.example.hiltstudy.data.Venue
import javax.inject.Inject


class VenueService @Inject constructor(){

    fun getVenue(): Venue {
        return Venue(venueName = "Morning swim")
    }
}


