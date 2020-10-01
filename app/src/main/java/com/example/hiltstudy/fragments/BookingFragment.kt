package com.example.hiltstudy.fragments

import androidx.fragment.app.Fragment
import com.example.hiltstudy.R
import com.example.hiltstudy.services.AuthService
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_bookings.view.*
import javax.inject.Inject

@AndroidEntryPoint
class BookingFragment(private val params: String) : Fragment(R.layout.fragment_bookings) {


    @Inject
    lateinit var authService: AuthService
}