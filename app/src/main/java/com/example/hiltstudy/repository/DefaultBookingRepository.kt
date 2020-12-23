package com.example.hiltstudy.repository

import androidx.lifecycle.LiveData
import com.example.hiltstudy.data.Booking
import com.example.hiltstudy.data.BookingDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import com.example.hiltstudy.Result
import javax.inject.Inject

class DefaultBookingRepository

    @Inject constructor(
    private val remoteDataSource: BookingDataSource,
    private val localDataSource: BookingDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): BookingRepository{

    override suspend fun getBookings(forceUpdate: Boolean, userId: String, accountType: String
    ): List<Booking> {
        return localDataSource.getBookings("1234", "swimmer")
    }

    override fun observeBookings(): LiveData<List<Booking>> {
        return localDataSource.observeBookings()
    }

}