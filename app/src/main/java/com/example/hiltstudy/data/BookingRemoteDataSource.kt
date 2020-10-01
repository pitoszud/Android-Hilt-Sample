package com.example.hiltstudy.data

import com.example.hiltstudy.Result

class BookingRemoteDataSource : BookingDataSource{

    override suspend fun getBookings(userId: String, accountType: String): Result<List<Booking>> {
        val booking = Booking("1234", "Saturday morning swim")
        val bookings = listOf(booking)
        return Result.Success(bookings)
    }

}