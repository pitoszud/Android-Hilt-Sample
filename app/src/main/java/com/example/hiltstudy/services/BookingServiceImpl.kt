package com.example.hiltstudy.services

import android.util.Log
import com.example.hiltstudy.data.Booking
import com.example.hiltstudy.di.LocalDataImpl
import com.example.hiltstudy.di.RemoteDataImpl
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Singleton

// @ActivityScoped
@Singleton
class BookingServiceImpl @Inject constructor(private val authService: AuthService): BookingService {

    override fun bookVenue(): Booking {
        val auth = authService.isAuthenticated()
        if (!auth){
            Log.e(TAG, "User is not authenticated")
        }
        return Booking(venueName = "dummy Booking")
    }

    override fun getBookings(): List<Booking> {
        return listOf(Booking("1234", "Saturday morning swim"))
    }


    companion object {
        const val TAG = "BookingServiceImpl"
    }
}


interface BookingService{
    fun bookVenue(): Booking
    fun getBookings(): List<Booking>
}