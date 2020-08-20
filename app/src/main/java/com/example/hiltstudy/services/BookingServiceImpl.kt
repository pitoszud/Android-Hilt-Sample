package com.example.hiltstudy.services

import com.example.hiltstudy.data.Booking
import com.example.hiltstudy.di.LocalImpl
import com.example.hiltstudy.di.RemoteImpl
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class BookingServiceImpl @Inject constructor(
    @LocalImpl private val localVenueService: VenueService,
    @RemoteImpl private val remoteVenueService: VenueService
): BookingService {

    override fun bookVenue(): Booking {
        val vnr = localVenueService.getVenue().venueName.plus("from Booking Service - remote")
        // save in local database
        val vnl = remoteVenueService.getVenue().venueName.plus("from Booking Service - local")
        return Booking(venueName = "$vnr \n $vnl")
    }
}


interface BookingService{
    fun bookVenue(): Booking
}