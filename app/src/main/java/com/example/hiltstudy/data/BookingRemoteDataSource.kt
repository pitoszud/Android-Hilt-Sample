package com.example.hiltstudy.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hiltstudy.Result
import com.example.hiltstudy.services.BookingService

class BookingRemoteDataSource(val bookingService: BookingService) : BookingDataSource{

    override suspend fun getBookings(userId: String, accountType: String) {
        val booking = Booking("1234", "Saturday morning swim")
        val bookings = listOf(booking)
    }

    override fun observeBookings(): LiveData<List<Booking>>{
        val ld = MutableLiveData<List<Booking>>(emptyList())
        return ld
    }


}