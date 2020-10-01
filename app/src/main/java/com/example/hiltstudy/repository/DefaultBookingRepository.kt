package com.example.hiltstudy.repository

import com.example.hiltstudy.data.Booking
import com.example.hiltstudy.data.BookingDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import com.example.hiltstudy.Result

class DefaultBookingRepository(
    private val remoteDataSource: BookingDataSource,
    private val localDataSource: BookingDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): BookingRepository{

    override suspend fun getBookings(forceUpdate: Boolean, userId: String, accountType: String
    ): Result<List<Booking>> {

        return if (forceUpdate){
            remoteDataSource.getBookings("1234", "swimmer")
        }else{
            localDataSource.getBookings("1234", "swimmer")
        }

    }

}