package com.example.hiltstudy.services

import android.util.Log
import com.example.hiltstudy.data.Booking
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

// @ActivityScoped
@Singleton
class BookingService @Inject constructor(private val authService: AuthService): IBookingService {

    override fun bookVenue(): Booking {
        val auth = authService.isAuthenticated()
        if (!auth){
            Log.e(TAG, "User is not authenticated")
        }
        val randomNum = Random.nextInt(1, 100)
        return Booking(venueName = "dummy Booking: $randomNum")
    }

    override fun getBookings(): List<Booking> {
        return listOf(Booking("1234", "Saturday morning swim"))
    }


    companion object {
        const val TAG = "BookingServiceImpl"
    }
}


interface IBookingService{
    fun bookVenue(): Booking
    fun getBookings(): List<Booking>
}