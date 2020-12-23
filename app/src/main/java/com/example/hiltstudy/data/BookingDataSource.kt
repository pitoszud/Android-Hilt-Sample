package com.example.hiltstudy.data

import androidx.lifecycle.LiveData
import com.example.hiltstudy.Result

interface BookingDataSource {
    suspend fun getBookings(userId: String, accountType: String): List<Booking>
    fun observeBookings(): LiveData<List<Booking>>
}