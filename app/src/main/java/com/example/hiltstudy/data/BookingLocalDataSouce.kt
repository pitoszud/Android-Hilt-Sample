package com.example.hiltstudy.data

import androidx.lifecycle.LiveData
import androidx.work.ListenableWorker
import com.example.hiltstudy.Result
import com.example.hiltstudy.database.BookingDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class BookingLocalDataSouce (
    private val bookingDao: BookingDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): BookingDataSource{

    override suspend fun getBookings(userId: String, accountType: String): List<Booking> {
        val booking = Booking("1234", "Saturday morning swim")
        bookingDao.insertBooking(booking)

        return listOf(booking)
    }

    override fun observeBookings(): LiveData<List<Booking>> {
        return bookingDao.observeAllBookings()!!
    }
}