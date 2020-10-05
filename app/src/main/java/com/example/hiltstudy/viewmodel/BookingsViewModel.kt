package com.example.hiltstudy.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.hiltstudy.repository.BookingRepository
import com.example.hiltstudy.Result
import com.example.hiltstudy.Result.*
import com.example.hiltstudy.data.Booking
import kotlinx.coroutines.launch

class BookingsViewModel

@ViewModelInject constructor(
    private val bookingRepository: BookingRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel(), LifecycleObserver {

    private val _forceUpdate = MutableLiveData<Boolean>(false)

    val _bookings: LiveData<List<Booking>> = _forceUpdate.switchMap {forceUpdate ->

        viewModelScope.launch {
            bookingRepository.getBookings(forceUpdate, "123", "swimmer")
        }

        bookingRepository.observeBookings().switchMap {bookingList ->
            getResultData(bookingList)
        }

    }


    private fun getResultData(bookingResult: List<Booking>): LiveData<List<Booking>>{
        val result = MutableLiveData<List<Booking>>()
        result.value = bookingResult

        return result
    }


}