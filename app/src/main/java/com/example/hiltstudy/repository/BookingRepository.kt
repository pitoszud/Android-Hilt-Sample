package com.example.hiltstudy.repository

import com.example.hiltstudy.data.Booking
import com.example.hiltstudy.Result

interface BookingRepository {
    suspend fun getBookings(forceUpdate: Boolean = false, userId: String, accountType: String): Result<List<Booking>>
}