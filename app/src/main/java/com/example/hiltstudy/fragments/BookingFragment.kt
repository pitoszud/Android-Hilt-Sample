package com.example.hiltstudy.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.hiltstudy.R
import com.example.hiltstudy.services.AuthService
import com.example.hiltstudy.viewmodel.BookingsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_bookings.view.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@AndroidEntryPoint
class BookingFragment(private val params: String) : Fragment(R.layout.fragment_bookings) {

    @ExperimentalCoroutinesApi
    private val bookingsViewModel: BookingsViewModel by viewModels()

    @Inject
    lateinit var authService: AuthService



}