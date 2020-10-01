package com.example.hiltstudy.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.hiltstudy.repository.BookingRepository
import com.example.hiltstudy.Result
import com.example.hiltstudy.data.Booking

class BookingsViewModel

@ViewModelInject constructor(
    private val bookingRepository: BookingRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel(), LifecycleObserver {


    suspend fun getBookings(): List<Booking>{
        val result =  bookingRepository.getBookings(true, "123", "swimmer")

        return if (result is Result.Success){
            val resultList: List<Booking> = result.data

            if (resultList.isNotEmpty()){
                resultList
            }else{
                emptyList()
            }

        }else{
            emptyList()
        }
    }

}