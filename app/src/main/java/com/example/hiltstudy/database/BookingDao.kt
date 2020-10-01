package com.example.hiltstudy.database

import androidx.room.Dao
import androidx.room.Query
import com.example.hiltstudy.data.Booking

@Dao
interface BookingDao {

    @Query("SELECT * FROM bookings")
    suspend fun getAllBookings(): List<Booking>?

    @Query("DELETE FROM bookings")
    suspend fun deleteBookings()

}