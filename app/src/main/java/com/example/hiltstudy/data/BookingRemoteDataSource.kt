package com.example.hiltstudy.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hiltstudy.services.IBookingService

class BookingRemoteDataSource(private val IBookingService: IBookingService) : BookingDataSource{

    override suspend fun getBookings(userId: String, accountType: String): List<Booking> {
        return IBookingService.getBookings()
    }

    override fun observeBookings(): LiveData<List<Booking>>{
        val ld = MutableLiveData<List<Booking>>(emptyList())
        return ld
    }


}