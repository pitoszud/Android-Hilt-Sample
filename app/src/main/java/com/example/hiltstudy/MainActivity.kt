package com.example.hiltstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hiltstudy.services.BookingService
import com.example.hiltstudy.services.VenueService
import dagger.hilt.android.AndroidEntryPoint
import java.time.Duration
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var bookingService: BookingService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bk = bookingService.bookVenue()
        Toast.makeText(this, bk.venueName, Toast.LENGTH_LONG).show()
    }
}