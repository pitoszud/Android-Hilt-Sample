package com.example.hiltstudy.data

import androidx.work.ListenableWorker
import com.example.hiltstudy.Result
import com.example.hiltstudy.database.BookingDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class BookingLocalDataSouce (
    private val bookingDao: BookingDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): BookingDataSource{

    override suspend fun getBookings(userId: String, accountType: String): Result<List<Booking>> {


        val dbBookings = bookingDao.getAllBookings()
        return if(dbBookings != null){
            Result.Success(dbBookings)
        }else{
            val booking = Booking("1234", "Saturday morning swim")
            val bookings = listOf(booking)
            Result.Success(bookings)
        }

    }
}