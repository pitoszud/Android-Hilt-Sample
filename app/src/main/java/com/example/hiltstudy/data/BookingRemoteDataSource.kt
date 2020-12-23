package com.example.hiltstudy.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hiltstudy.Result
import com.example.hiltstudy.services.BookingService

class BookingRemoteDataSource(private val bookingService: BookingService) : BookingDataSource{

    override suspend fun getBookings(userId: String, accountType: String): List<Booking> {
        return bookingService.getBookings()
    }

    override fun observeBookings(): LiveData<List<Booking>>{
        val ld = MutableLiveData<List<Booking>>(emptyList())
        return ld
    }


}