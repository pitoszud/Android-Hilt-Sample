package com.example.hiltstudy.services

import com.example.hiltstudy.data.Booking
import com.example.hiltstudy.data.Venue
import javax.inject.Inject

class BookingService @Inject constructor(
    private val venueService: VenueService
){

    val vn = venueService.getVenue()

    fun bookVenue(): Booking{
        val booking = Booking(venueName = vn.venueName)

        return booking
    }
}