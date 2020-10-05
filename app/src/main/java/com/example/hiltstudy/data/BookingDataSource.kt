package com.example.hiltstudy.data

import androidx.lifecycle.LiveData
import com.example.hiltstudy.Result

interface BookingDataSource {
    suspend fun getBookings(userId: String, accountType: String)
    fun observeBookings(): LiveData<List<Booking>>
}