package com.example.hiltstudy.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hiltstudy.data.Booking
import dagger.hilt.android.scopes.ActivityScoped


@Dao
interface BookingDao {

    @Query("SELECT * FROM bookings")
    suspend fun getAllBookings(): List<Booking>?

    @Query("SELECT * FROM bookings")
    fun observeAllBookings(): LiveData<List<Booking>>?

    @Query("DELETE FROM bookings")
    suspend fun deleteBookings()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooking(booking: Booking)


}