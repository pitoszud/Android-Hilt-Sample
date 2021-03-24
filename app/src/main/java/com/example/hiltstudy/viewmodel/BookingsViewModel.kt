package com.example.hiltstudy.viewmodel

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.hiltstudy.repository.BookingRepository
import com.example.hiltstudy.Result
import com.example.hiltstudy.Result.*
import com.example.hiltstudy.data.Booking
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

// @HiltViewModel replaced @ActivityScoped since 2.31.2-alpha
@HiltViewModel
class BookingsViewModel

// @ViewModelInject replaced with @Inject since 2.31.2-alpha
// @Assisted for SavedStateHandle removed
@Inject
constructor(
    private val bookingRepository: BookingRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel(), LifecycleObserver {

    private val _forceUpdate = MutableLiveData<Boolean>(false)

    val _bookings: LiveData<List<Booking>> = _forceUpdate.switchMap {forceUpdate ->

        viewModelScope.launch {
            val bookings = bookingRepository.getBookings(forceUpdate, "123", "swimmer")
            Log.d(TAG, "${bookings.size} bookings retrieved")
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


    companion object {
        const val TAG = "BookingsViewModel"
    }


}