package com.example.hiltstudy.data

import com.example.hiltstudy.Result

interface BookingDataSource {
    suspend fun getBookings(userId: String, accountType: String): Result<List<Booking>>
}