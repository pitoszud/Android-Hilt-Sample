package com.example.hiltstudy.services

import com.example.hiltstudy.data.Booking
import com.example.hiltstudy.di.LocalDataImpl
import com.example.hiltstudy.di.RemoteDataImpl
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Singleton

// @ActivityScoped
@Singleton
class BookingServiceImpl @Inject constructor(): BookingService {

    override fun bookVenue(): Booking {

        return Booking(venueName = "dummy Booking")
    }
}


interface BookingService{
    fun bookVenue(): Booking
}