package com.example.hiltstudy.fragments

import androidx.fragment.app.Fragment
import com.example.hiltstudy.services.AuthService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BookingFragment : Fragment(){

    @Inject
    lateinit var authService: AuthService
}